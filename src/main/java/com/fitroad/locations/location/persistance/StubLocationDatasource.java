package com.fitroad.locations.location.persistance;

import com.fitroad.locations.location.BaseLocation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class StubLocationDatasource implements LocationDatasource {
    private static Long lastId = 3L;
    private static final Map<Long, BaseLocation> LOCATIONS_MAP = new HashMap<>(Map.of(
            1L, new BaseLocation(1L, "Moscow", 55.755773f, 37.617761f),
            2L, new BaseLocation(2L, "Kiev", 50.402395f, 30.532690f),
            3L, new BaseLocation(3L, "Saint-Petersburg", 59.938806f, 30.314278f)
    ));

    @Override
    public Mono<Boolean> save(BaseLocation location) {
        long id = ++lastId;
        location.setId(id);
        Mono<BaseLocation> result = Mono.justOrEmpty(LOCATIONS_MAP.put(id, location));
        return result.hasElement();
    }

    @Override
    public Mono<BaseLocation> getLocationByName(String name) {
        Optional<BaseLocation> first = LOCATIONS_MAP.values().stream()
                .filter(loc -> loc.getName().equals(name))
                .findFirst();
        return Mono.just(first.orElseThrow(() -> new RuntimeException(String.format("Unable to find location with the name %s", name))));
    }

    @Override
    public Flux<BaseLocation> getLocations() {
        return Flux.fromIterable(new ArrayList<>(LOCATIONS_MAP.values()));
    }
}
