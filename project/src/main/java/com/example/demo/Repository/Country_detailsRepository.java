package com.example.demo.Repository;

import com.example.demo.Entity.Country_details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Country_detailsRepository extends JpaRepository<Country_details, Integer> {
}
