package com.backendtillspa.backendtillspa.controllers;



import com.backendtillspa.backendtillspa.models.Reservation;
import com.backendtillspa.backendtillspa.services.ReservationService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "https://king-prawn-app-44rdd.ondigitalocean.app/")
public class ReservationController {
    
    private ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @GetMapping
    public String getRoot() {
        System.out.println("Förfrågan mottagen");
        return "{'Hello World'}";
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        System.out.println("Förfrågan mottagen");
        return reservationService.getReservations();
    }

    @GetMapping("/reservation/{id}")
    public Reservation getReservationId(@PathVariable String id) {
        return reservationService.getReservationId(id);
    }

    @GetMapping("/reservation/other/{packages}")
    public List<Reservation> getAllReservationPackages(@PathVariable String packages) {
        return reservationService.getAllReservationPackages(packages);
    }
    
    
    @PostMapping("/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }
    
    @PatchMapping("/reservation/{id}")
    public Reservation editReservation(@PathVariable String id, @RequestBody Reservation reservation) {
        return reservationService.editReservation(id, reservation);
    }

    @DeleteMapping("/reservation/{id}")
    public String deleteReservation(@PathVariable String id) {
        
        reservationService.deleteReservation(id);
        return "{'message':'Reservation with id '" + id + "' has been deleted'}";
    }


}
