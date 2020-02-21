CREATE TABLE IF NOT EXISTS vehicle (
    vehicle_id UUID PRIMARY KEY NOT NULL,
    registration VARCHAR(7),
    manufacturer VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year SMALLINT NOT NULL,
    mileage INTEGER NOT NULL
);