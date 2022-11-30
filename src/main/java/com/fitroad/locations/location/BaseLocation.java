package com.fitroad.locations.location;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "locations")
public class BaseLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float latitude;
    private Float longitude;

    public BaseLocation() {

    }

    public BaseLocation(String name, Float latitude, Float longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BaseLocation(Long id, String name, Float latitude, Float longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BaseResponse buildBaseLocationResponse() {
        return new BaseLocationResponse(
                id,
                name,
                latitude,
                longitude
        );
    }

    public Long getId() {
        return id;
    }

    public BaseLocation setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BaseLocation setName(String name) {
        this.name = name;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public BaseLocation setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public BaseLocation setLongitude(Float longitude) {
        this.longitude = longitude;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BaseLocation)) {
            return false;
        }
        BaseLocation location = (BaseLocation) obj;
        return  location.getName().equals(name) &&
                location.getLatitude().equals(latitude) &&
                location.getLongitude().equals(longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude);
    }

    @Override
    public String toString() {
        return "BaseLocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
