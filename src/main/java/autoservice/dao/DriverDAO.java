package autoservice.dao;

import autoservice.domain.Driver;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class DriverDAO {

    private final JdbcTemplate jdbcTemplate;

    public List<Driver> getAllDrivers() {
        String sql = "" +
                "SELECT " +
                "driver_id, " +
                "name, " +
                "surname, " +
                "date_of_birth, " +
                "phone_number, " +
                "date_of_start, " +
                "date_of_leave, " +
                "miles_done, " +
                "hours_done " +
                "FROM driver";

        return jdbcTemplate.query(sql, mapDriverFromDb());

    }

    private RowMapper<Driver> mapDriverFromDb() {
        return (resultSet, i) -> {

            UUID driverId = UUID.fromString(resultSet.getString("driver_id"));
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            Date dateOfBirth = resultSet.getDate("date_of_birth");
            String phoneNumber = resultSet.getString("phone_number");
            Date dateOfStart = resultSet.getDate("date_of_start");
            Date dateOfLeave = resultSet.getDate("date_of_leave");
            int milesDone = resultSet.getInt("miles_done");
            int hoursDone = resultSet.getInt("hours_done");

            return new Driver(driverId, name, surname, dateOfBirth, phoneNumber, dateOfStart, dateOfLeave, milesDone, hoursDone);
        };
    }

    public void addNewDriver(UUID id, Driver driver) {

        String sql = "" +
                "INSERT INTO driver (" +
                "driver_id, " +
                "name, " +
                "surname, " +
                "date_of_birth, " +
                "phone_number, " +
                "date_of_start, " +
                "date_of_leave, " +
                "miles_done, " +
                "hours_done) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                id,
                driver.getName(),
                driver.getSurname(),
                driver.getDateOfBirth(),
                driver.getPhoneNumber(),
                driver.getDateOfStart(),
                driver.getDateOfLeave(),
                driver.getMilesDone(),
                driver.getHoursDone()
        );

    }

    public Driver selectDriver(UUID id) {

        String sql = "SELECT * FROM driver WHERE driver_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                mapDriverFromDb(),
                id
        );
    }

    public void updateDriver(UUID id, Driver driver) {

        String sql = "" +
                "UPDATE driver SET " +
                "name = ?, " +
                "surname = ?, " +
                "date_of_birth = ?, " +
                "phone_number = ?, " +
                "date_of_start = ?, " +
                "date_of_leave = ?, " +
                "miles_done = ?, " +
                "hours_done = ? " +
                "WHERE driver_id = ? ";

        jdbcTemplate.update(
                sql,
                driver.getName(),
                driver.getSurname(),
                driver.getDateOfBirth(),
                driver.getPhoneNumber(),
                driver.getDateOfStart(),
                driver.getDateOfLeave(),
                driver.getMilesDone(),
                driver.getHoursDone(),
                id
        );

    }
}
