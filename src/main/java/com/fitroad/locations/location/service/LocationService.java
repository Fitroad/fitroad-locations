package com.fitroad.locations.location.service;

import com.fitroad.locations.location.BaseLocation;
import com.fitroad.locations.location.persistance.LocationDatasource;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class LocationService implements LocationServiceApi {
    private LocationDatasource datasource;

    public LocationService(LocationDatasource datasource) {
        this.datasource = datasource;
    }

    public void save(BaseLocation location) {
        datasource.save(location);
    }

    public Mono<BaseLocation> getLocationByName(String name) {
        return datasource.getLocationByName(name);
    }

    public Flux<BaseLocation> getLocations() {
        return datasource.getLocations();
    }
}
