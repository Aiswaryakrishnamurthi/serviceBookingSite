package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.BookingRequest;
import com.example.demo.Entity.Service;
import com.example.demo.Repository.ServiceRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class ServiceController {

    private final ServiceRepository serviceRepository;

    public ServiceController(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    // Mapping for the home/index page
    @GetMapping
    public String index() {
        return "index"; // Ensure this corresponds to index.html in your templates folder
    }

    // Mapping for the service page
    @GetMapping("/services")
    public String services(Model model) {
        List<Service> servicesList = serviceRepository.findAll();
        model.addAttribute("services", servicesList); // Add services to the model for the view
        return "service"; // Ensure this corresponds to services.html in your templates folder
    }

    // Mapping for the booking page
    @GetMapping("/booking")
    public String booking() {
        return "booking"; // Ensure this corresponds to booking.html in your templates folder
    }

    // Search functionality mapping
    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        // Use the repository's search method
        List<Service> searchResults = serviceRepository.findByNameContainingIgnoreCase(query);
        model.addAttribute("searchResults", searchResults);
        return "services"; // Return the view name for the services page
    }
    
    @GetMapping("/successbooking")
    public String successbooking() {
        return "bookingSuccess"; // Ensure this corresponds to booking.html in your templates folder
    }
    @GetMapping("/plumbers")
    public String showPlumbersPage() {
        return "plumbers"; // This maps to plumbers.html
    }

    @GetMapping("/electricians")
    public String showElectriciansPage() {
        return "electricians"; // This maps to electricians.html
    }

    @GetMapping("/painters")
    public String showPaintersPage() {
        return "painters"; // This maps to painters.html
    }
    
    @GetMapping("/service")
    public String showServicePage() {
        return "service"; // This maps to painters.html
    }

    @GetMapping("/cooking")
    public String showCooking() {
        return "cooking"; // This maps to houseworkers.html
    }
    @GetMapping("/babysitter")
    public String showBabySitter() {
        return "babysitter"; // This maps to houseworkers.html
    }
    @GetMapping("/houseworkers")
    public String showhouseworkers() {
        return "houseworkers"; // This maps to houseworkers.html
    }
    @GetMapping("/petcare")
    public String showPetcare() {
        return "Petcare"; // This maps to houseworkers.html
    }
    @RestController
    @RequestMapping("/api")
    public class BookingController {

        @PostMapping("/book")
        public ResponseEntity<String> bookService(@RequestBody BookingRequest bookingRequest) {
            // Logic to save the booking request
            // For example, save it to a database

            return ResponseEntity.ok("Booking confirmed!"); // Respond with a success message
        }
    }


}
