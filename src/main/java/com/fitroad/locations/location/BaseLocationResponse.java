package com.fitroad.locations.location;

import java.util.Objects;

public class BaseLocationResponse extends BaseResponse {
    private Long id;
    private String title;
    private Float latitude;
    private Float longitude;

    public BaseLocationResponse() {

    }

    public BaseLocationResponse(String errorMessage) {
        super(errorMessage);
    }

    public BaseLocationResponse(String name, Float latitude, Float longitude) {
        this.title = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BaseLocationResponse(Long id, String name, Float latitude, Float longitude) {
        this.id = id;
        this.title = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public BaseLocationResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BaseLocationResponse setTitle(String title) {
        this.title = title;
        return this;
    }

    public Float getLatitude() {
        return latitude;
    }

    public BaseLocationResponse setLatitude(Float latitude) {
        this.latitude = latitude;
        return this;
    }

    public Float getLongitude() {
        return longitude;
    }

    public BaseLocationResponse setLongitude(Float longitude) {
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
