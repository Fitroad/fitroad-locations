package com.fitroad.locations.location.api.rest.v1;

import com.fitroad.locations.location.BaseLocationRequest;
import com.fitroad.locations.location.BaseLocationResponse;
import com.fitroad.locations.location.api.LocationApi;
import com.fitroad.locations.location.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LocationServiceGateway implements LocationApi {
    private LocationService service;

    public LocationServiceGateway(LocationService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<?> save(BaseLocationRequest baseLocation) {
        ResponseEntity<?> response;
        try {
            service.save(baseLocation.buildBaseLocation());
            response = ResponseEntity.ok(null);
        } catch (Exception exception) {
            response = buildWithException(exception);
        }
        return response;
    }

    @Override
    public ResponseEntity<?> getLocationByName(String name) {
        ResponseEntity<?> response;
        try {
            response = buildWithSuccess(service.getLocationByName(name));
        } catch(Exception exception) {
            response = buildWithException(exception);
        }
        return response;
    }

    @Override
    public ResponseEntity<?> getLocations() {
        ResponseEntity<?> response;
        try {
            response = buildWithSuccess(service.getLocations());
        } catch(Exception exception) {
            response = buildWithException(exception);
        }
        return response;
    }

    private ResponseEntity<?> buildWithSuccess(Object body) {
        return ResponseEntity.ok(body);
    }

    private ResponseEntity<?> buildWithException(Exception exception) {
        return new ResponseEntity<>(new BaseLocationResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
