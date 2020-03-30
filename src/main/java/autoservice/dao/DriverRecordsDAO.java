package autoservice.dao;

import autoservice.domain.DriverRecords;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class DriverRecordsDAO {

    private final JdbcTemplate jdbcTemplate;

    public List<DriverRecords> getAllDriverRecords() {

        String sql = "" +
                "SELECT " +
                "vehicle_id, " +
                "driver_id, " +
                "date_of_start, " +
                "date_of_finish, " +
                "vehicle_miles_at_start, " +
                "vehicle_miles_at_finish, " +
                "miles_done, " +
                "info " +
                "FROM driver_records";

        return jdbcTemplate.query(sql, mapRecordsFromDb());
    }

    private RowMapper<DriverRecords> mapRecordsFromDb() {
        return (resultSet, i) -> {

            UUID vehicleId = UUID.fromString(resultSet.getString("vehicle_id"));
            UUID driverId = UUID.fromString(resultSet.getString("driver_id"));
            Date dateOfStart = resultSet.getDate("date_of_start");
            Date dateOfFinish = resultSet.getDate("date_of_finish");
            int milesAtStart = resultSet.getInt("vehicle_miles_at_start");
            int milesAtFinish = resultSet.getInt("vehicle_miles_at_finish");
            int milesDone = resultSet.getInt("miles_done");
            String info = resultSet.getString("info");


            return new DriverRecords(vehicleId, driverId, dateOfStart, dateOfFinish, milesAtStart, milesAtFinish, milesDone, info);
        };
    }

    public List<DriverRecords> getAllRecordsByDriver(UUID driverId) {

        String sql = "SELECT * FROM driver_records WHERE driver_id = ?";

        return jdbcTemplate.query(
                sql,
                mapRecordsFromDb(),
                driverId
        );

    }

    public List<DriverRecords> getAllRecordsByVehicle(UUID vehicleId) {

        String sql = "SELECT * FROM driver_records WHERE vehicle_id = ?";

        return jdbcTemplate.query(
                sql,
                mapRecordsFromDb(),
                vehicleId
        );

    }

    public void addNewRecord(DriverRecords driverRecords){

        String sql = "" +
                "INSERT INTO driver_records (" +
                "vehicle_id, " +
                "driver_id, " +
                "date_of_start, " +
                "date_of_finish, " +
                "vehicle_miles_at_start, " +
                "vehicle_miles_at_finish, " +
                "miles_done, " +
                "info ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        jdbcTemplate.update(
                sql,
                driverRecords.getVehicleId(),
                driverRecords.getDriverId(),
                driverRecords.getDateOfStart(),
                driverRecords.getDateOfFinish(),
                driverRecords.getMilesAtStart(),
                driverRecords.getMilesAtFinish(),
                driverRecords.getMilesDone(),
                driverRecords.getInfo()
        );

    }
}

