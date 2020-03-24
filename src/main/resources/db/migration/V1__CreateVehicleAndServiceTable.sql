CREATE TABLE IF NOT EXISTS vehicle (
    vehicle_id UUID PRIMARY KEY NOT NULL,
    registration VARCHAR(7) NOT NULL,
    manufacturer VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year SMALLINT NOT NULL,
    mileage INTEGER NOT NULL,
    mot Date NOT NULL
);

CREATE TABLE IF NOT EXISTS driver (
    driver_id UUID PRIMARY KEY NOT NULL,
    name VARCHAR (50),
    surname VARCHAR (50),
    date_of_birth date,
    phone_number VARCHAR (13),
    date_of_start date,
    date_of_leave date,
    miles_done INTEGER,
    hours_done SMALLINT
);

CREATE TABLE IF NOT EXISTS mechanic (
    mechanic_id UUID PRIMARY KEY NOT NULL,
    name VARCHAR (50),
    surname VARCHAR (50),
    date_of_birth date,
    phone_number VARCHAR (13),
    date_of_start date,
    date_of_leave date
);

CREATE TABLE IF NOT EXISTS driver_records (
    vehicle_id UUID NOT NULL REFERENCES vehicle (vehicle_id),
    driver_id UUID NOT NULL REFERENCES driver (driver_id),
    date_of_start timestamp,
    date_of_finish timestamp,
    total_time interval,
    vehicle_miles_at_start INTEGER,
    vehicle_miles_at_finish INTEGER,
    miles_done INTEGER,
    info TEXT
);

CREATE TABLE IF NOT EXISTS service (
    vehicle_id UUID NOT NULL REFERENCES vehicle (vehicle_id),
    mechanic_id UUID REFERENCES mechanic (mechanic_id),
    department INTEGER NOT NULL,
    section INTEGER NOT NULL,
    part INTEGER NOT NULL,
    date_of_service date NOT NULL,
    date_of_expiration date,
    miles_of_service INTEGER NOT NULL,
    miles_of_expiration INTEGER,
    position_or_quantity VARCHAR (100),
    info TEXT
);