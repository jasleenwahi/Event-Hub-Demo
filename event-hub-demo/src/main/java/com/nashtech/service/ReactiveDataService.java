package com.nashtech.service;

/**
 * Interface representing a service for performing reactive data access
 * operations on cars.
 * It provides methods for obtaining cars with a specific brand and getting
 * distinct car brands in a reactive manner.
 */
public interface ReactiveDataService {

    /**
     * Retrieves car data from an external data source.
     */
    void fetchAndSendData();

}
