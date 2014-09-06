package com.goeuro.test.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class GeoObject {
    @JsonProperty("_id")
    private String id;
    private String coreCountry;
    private String country;
    private String countryCode;
    private String distance;
    private String fullName;
    @JsonProperty("geo_position")
    private GeoPosition geoPosition;
    @JsonProperty("iata_airport_code")
    private String iataAirportCode;
    private String inEurope;
    private String key;
    private String locationId;
    private String name;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(String coreCountry) {
        this.coreCountry = coreCountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public String getIataAirportCode() {
        return iataAirportCode;
    }

    public void setIataAirportCode(String iataAirportCode) {
        this.iataAirportCode = iataAirportCode;
    }

    public String getInEurope() {
        return inEurope;
    }

    public void setInEurope(String inEurope) {
        this.inEurope = inEurope;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
