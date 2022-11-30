package com.fitroad.locations.location.api;

import com.fitroad.locations.location.BaseLocationRequest;
import org.springframework.http.ResponseEntity;

public interface LocationApi {
    ResponseEntity<?> save(BaseLocationRequest baseLocation);
    ResponseEntity<?> getLocationByName(String name);
    ResponseEntity<?> getLocations();
}
