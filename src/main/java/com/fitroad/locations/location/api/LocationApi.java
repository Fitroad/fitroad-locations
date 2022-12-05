package com.fitroad.locations.location.api;

import com.fitroad.locations.location.BaseLocationRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationApi {
    Mono<Void> save(Mono<BaseLocationRequest> baseLocation);
    Mono<?> getLocationByName(Mono<String> name);
    Flux<?> getLocations();
}
