package com.fitroad.locations.location.api.rest.v1;

import com.fitroad.locations.location.BaseLocationRequest;
import com.fitroad.locations.location.BaseResponse;
import com.fitroad.locations.location.api.LocationApi;
import com.fitroad.locations.location.service.LocationService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/locations")
public class LocationController implements LocationApi {

    private LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Mono<Void> save(Mono<BaseLocationRequest> baseLocation) {
        return baseLocation
            .map(r -> r.buildBaseLocation())
            .flatMap(location -> { service.save(location); return Mono.empty(); });
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Mono<BaseResponse> getLocationByName(@PathVariable("name") Mono<String> name) {
        return name
            .flatMap(service::getLocationByName)
            .map(location -> location.buildBaseLocationResponse());
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Flux<BaseResponse> getLocations() {
        return service.getLocations()
            .map(location -> location.buildBaseLocationResponse());
    }
}
