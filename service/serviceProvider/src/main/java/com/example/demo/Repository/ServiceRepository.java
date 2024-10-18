package com.example.demo.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	 List<Service> findByNameContainingIgnoreCase(String query);


}
