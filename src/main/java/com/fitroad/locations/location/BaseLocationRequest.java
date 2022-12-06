package com.fitroad.locations.location;

import java.util.Objects;

public class BaseLocationRequest {
    private String title;
    private Float latitude;
    private Float longitude;

    public BaseLocationRequest() {

    }

    public BaseLocation buildBaseLocation() {
        return new BaseLocation(
                title,
                latitude,
                longitude
        );
    }

    public BaseLocationRequest(String name, Float latitude, Float longitude) {
        this.title = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public BaseLocationRequest setTitle(String name) {
        this.title = name;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public BaseLocationRequest setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public BaseLocationRequest setLongitude(Float longitude) {
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
        return  location.getTitle().equals(title) &&
                location.getLatitude().equals(latitude) &&
                location.getLongitude().equals(longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, latitude, longitude);
    }

    @Override
    public String toString() {
        return "BaseLocation{" +
                "title='" + title + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
