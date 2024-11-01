const searchInput = document.getElementById('search-input');
const suggestionsBox = document.getElementById('suggestions');

searchInput.addEventListener('input', function() {
    const query = searchInput.value.toLowerCase();
    suggestionsBox.innerHTML = '';
    if (query) {
        const suggestions = cityInfo.filter(info => info.capital.toLowerCase().includes(query) || info.countryName.toLowerCase().includes(query)).map(info => info.capital + ' (' + info.countryName + ')');
        if (suggestions.length > 0) {
            suggestionsBox.style.display = 'block';
            suggestions.forEach(suggestion => {
                const suggestionItem = document.createElement('div');
                suggestionItem.textContent = suggestion;
                suggestionItem.className = 'autocomplete-suggestion';
                suggestionItem.onclick = function() {
                    const [capital, countryName] = suggestion.split(' (');
                    searchInput.value = capital;
                    suggestionsBox.innerHTML = '';
                    suggestionsBox.style.display = 'none';
                    searchCapital(capital, countryName.slice(0, -1));
                };
                suggestionsBox.appendChild(suggestionItem);
            });
        } else {
            suggestionsBox.style.display = 'none';
        }
    } else {
        suggestionsBox.style.display = 'none';
    }
});

function searchCapital(capital, countryName) {
    const result = cityInfo.find(info => info.capital.toLowerCase() === capital.toLowerCase() && info.countryName.toLowerCase() === countryName.toLowerCase());
    const resultBox = document.getElementById('result');
    const countryInfoBox = document.getElementById('country-info');

    if (result) {
        resultBox.textContent = ` [${result.capital}, ${result.countryName}]`;
        countryInfoBox.innerHTML = `
            <p><strong>Population:</strong> ${result.countryDTO.populationCountry}</p>
            <p><strong>Area:</strong> ${result.countryDTO.areaCountry} km²</p>
            <p><strong>Official Language:</strong> ${result.countryDTO.officialLanguageCountry}</p>
            <p><strong>Currency:</strong> ${result.countryDTO.currencyCountry}</p>
            <button class="btn btn-primary mt-2" onclick="window.location.href='/details-weather/get?city=${encodeURIComponent(result.capital)}'"">Weather</button>
        `;
    } else {
        resultBox.textContent = `City or country not found for ${capital} (${countryName}).`;
        countryInfoBox.innerHTML = '';
    }
}