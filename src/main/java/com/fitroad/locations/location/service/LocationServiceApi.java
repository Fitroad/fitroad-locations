package com.fitroad.locations.location.service;

import com.fitroad.locations.location.BaseLocation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationServiceApi {
    void save(BaseLocation baseLocation);
    Mono<BaseLocation> getLocationByName(String name);
    Flux<BaseLocation> getLocations();
}
