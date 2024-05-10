package com.backendtillspa.backendtillspa.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.backendtillspa.backendtillspa.models.Reservation;

@Service
public class ReservationService {
    private final MongoOperations mongoOperations;

    public ReservationService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Reservation addReservation(Reservation reservation) {
        return mongoOperations.insert(reservation);
    }

    public List<Reservation> getReservations() {
        return mongoOperations.findAll(Reservation.class);
    }

    public Reservation getReservationId(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Reservation.class);
    }

    public List<Reservation> getAllReservationPackages(String packages) {
        Query query = new Query();
        query.addCriteria(Criteria.where("packages").is(packages));
        return mongoOperations.find(query, Reservation.class);
    }
        
    public Reservation editReservation(String id, Reservation reservation) {
        Query query = Query.query(Criteria.where("id").is(id));
        Update update = Update.update("name", reservation.getReservationName());

        mongoOperations.updateFirst(query, update, Reservation.class);
        return mongoOperations.findById(id, Reservation.class);
    }

    
    //ÄNDRA HELA RESERVATIONEN

    /*public Reservation editReservation(String id, Reservation reservation) {
        reservation.setId(id);
        return mongoOperations.save(reservation);
    }*/

    public void deleteReservation(String id) {
        Query query = Query.query(Criteria.where("id").is(id));

        mongoOperations.remove(query, Reservation.class);
    }

}

