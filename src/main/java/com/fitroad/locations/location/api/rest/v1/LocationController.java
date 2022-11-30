package com.fitroad.locations.location.api.rest.v1;

import com.fitroad.locations.location.BaseLocationRequest;
import com.fitroad.locations.location.api.LocationApi;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/locations")
public class LocationController implements LocationApi {

    private final LocationServiceGateway service;

    public LocationController(LocationServiceGateway service) {
        this.service = service;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> save(BaseLocationRequest baseLocation) {
        return service.save(baseLocation);
    }

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> getLocationByName(@PathVariable("name") String name) {
        return service.getLocationByName(name);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> getLocations() {
        return service.getLocations();
    }
}
