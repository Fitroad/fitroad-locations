package com.fitroad.locations.location.persistance;

import com.fitroad.locations.location.BaseLocation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationDatasource {
    Mono<Boolean> save(BaseLocation location);
    Mono<BaseLocation> getLocationByName(String name);
    Flux<BaseLocation> getLocations();
}
