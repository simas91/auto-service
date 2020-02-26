package autoservice.dao;

import autoservice.domain.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class VehicleDAO {

    private final JdbcTemplate jdbcTemplate;

    public List<Vehicle> selectAllVehicles() {

        String sql = "" +
                "SELECT " +
                "vehicle_id, " +
                "registration, " +
                "manufacturer, " +
                "model, " +
                "year, " +
                "mileage, " +
                "mot " +
                "FROM vehicle";

        return jdbcTemplate.query(sql, mapVehicleFromDb());
    }

    public Vehicle selectVehicle(UUID id) {
        String sql = "SELECT * FROM vehicle WHERE vehicle_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                mapVehicleFromDb(),
                id
        );

    }

    private RowMapper<Vehicle> mapVehicleFromDb() {
        return (resultSet, i) -> {

            UUID vehicleId = UUID.fromString(resultSet.getString("vehicle_id"));
            String registration = resultSet.getString("registration");
            String manufacturer = resultSet.getString("manufacturer");
            String model = resultSet.getString("model");
            int year = resultSet.getInt("year");
            int mileage = resultSet.getInt("mileage");
            Date date = resultSet.getDate("mot");

            return new Vehicle(vehicleId, registration, manufacturer, model, year, mileage, date);
        };
    }

    @SuppressWarnings("ConstantConditions")
    public boolean isRegistrationTaken(String registration) {

        String sql = "" +
                "SELECT EXISTS ( " +
                "SELECT 1 " +
                "FROM vehicle " +
                "WHERE registration = ? " +
                ")";

        return jdbcTemplate.queryForObject(
                sql,
                new Object[] {registration},
                (resultSet, i) -> resultSet.getBoolean(1)
        );
    }

    public void insertVehicle(UUID vehicleId, Vehicle vehicle) {
        String sql = "" +
                "INSERT INTO vehicle (" +
                "vehicle_id, " +
                "registration, " +
                "manufacturer, " +
                "model, " +
                "year, " +
                "mileage, " +
                "mot ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                vehicleId,
                vehicle.getRegistration(),
                vehicle.getManufacturer(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getMileage(),
                vehicle.getMot()
        );
    }
}
