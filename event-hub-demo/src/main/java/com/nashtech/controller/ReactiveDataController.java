package com.nashtech.controller;


import com.nashtech.service.ReactiveDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller class
 * which handles reactive data access for cars.
 * This controller provides endpoints for retrieving car data based on
 * the brand and getting distinct car brands.
 */
@RestController
@RequestMapping("v1/data")
public class ReactiveDataController {

    /**
     * The service implementation for reactive data access.
     * This service provides methods for retrieving and processing car data
     * in a reactive manner.
     * It is marked as 'final' to ensure immutability after initialization.
     */
    @Autowired
    private ReactiveDataService reactiveDataService;

    /**
     * Endpoint to retrieve data from mockaroo
     * and send vehicle data to the Event Hub.
     *
     * @return ResponseEntity with a success message
     * if data is sent successfully.
     */
    @PostMapping
    public ResponseEntity<Object> pushDataToCloud() {
        reactiveDataService.fetchAndSendData();
        return new ResponseEntity<>(HttpStatus.CREATED);

    }



}
