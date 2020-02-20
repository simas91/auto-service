package autoservice.domain;

import java.util.UUID;

public class Vehicle {

    private final UUID vehicleId;
    private final String registration;
    private final String manufacturer;
    private final String model;
    private final Integer year;
    private final Integer mileage;

    public Vehicle(UUID vehicleId, String registration, String manufacturer, String model, Integer year, Integer mileage) {
        this.vehicleId = vehicleId;
        this.registration = registration;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public String getRegistration() {
        return registration;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }
}
