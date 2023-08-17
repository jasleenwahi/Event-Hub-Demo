package com.nashtech.service;

import com.nashtech.model.Car;
import reactor.core.publisher.Mono;

public interface CloudDataService {

    /**
     * Publishes vehicle data to the pub/sub topic.
     *
     * @param carData A Flux of Car objects representing
     *                the data to be published.
     * @return A Mono representing
     * the completion of the publishing process.
     * @throws Exception If an error occurs during the publishing process.
     */
    Mono<Void> pushData(Car carData);

}
