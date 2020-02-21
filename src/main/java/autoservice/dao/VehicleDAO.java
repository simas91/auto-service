package autoservice.dao;

import autoservice.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class VehicleDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Vehicle> selectAllVehicles() {

        String sql = "" +
                "SELECT " +
                "vehicle_id, " +
                "registration, " +
                "manufacturer, " +
                "model, " +
                "year, " +
                "mileage " +
                "FROM vehicle";

        return jdbcTemplate.query(sql, mapVehicleFromDb());
    }

    private RowMapper<Vehicle> mapVehicleFromDb() {
        return (resultSet, i) -> {

            UUID vehicleId = UUID.fromString(resultSet.getString("vehicle_id"));
            String registration = resultSet.getString("registration");
            String manufacturer = resultSet.getString("manufacturer");
            String model = resultSet.getString("model");
            int year = resultSet.getInt("year");
            int mileage = resultSet.getInt("mileage");

            return new Vehicle(vehicleId, registration, manufacturer, model, year, mileage);
        };
    }
}
