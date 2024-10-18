package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ServiceRepository;

@Service
public class ServiceSearchService {
    @Autowired
    private ServiceRepository serviceRepository; // Replace with your actual repository

    public List<com.example.demo.Entity.Service> searchServices(String query) {
        // Implement your search logic here
        // This is just a placeholder. Replace with your actual search implementation
        return serviceRepository.findByNameContainingIgnoreCase(query);
    }
}
