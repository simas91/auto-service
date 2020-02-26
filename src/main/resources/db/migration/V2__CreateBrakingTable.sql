CREATE TABLE IF NOT EXISTS braking (

    vehicle_id UUID NOT NULL REFERENCES vehicle (vehicle_id),
    section SMALLINT NOT NULL,
    part SMALLINT NOT NULL,
    date_of_service date NOT NULL,
    date_of_expiration date,
    miles_of_service INTEGER NOT NULL,
    miles_of_expiration INTEGER,
    position VARCHAR (100),
    info TEXT
);