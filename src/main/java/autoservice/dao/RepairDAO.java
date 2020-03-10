package autoservice.dao;

import autoservice.domain.Repair;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class RepairDAO {

    private final JdbcTemplate jdbcTemplate;


    public List<Repair> getAllService(UUID id, String department, String section, String part) {
        String sql = "SELECT * FROM service WHERE vehicle_id = ? AND department = ? AND section = ? AND part = ?";

        return jdbcTemplate.query(
                sql,
                mapVehicleFromDb(),
                id,
                department,
                section,
                part
        );
    }

    private RowMapper<Repair> mapVehicleFromDb() {
        return (resultSet, i) -> {

            UUID vehicleId = UUID.fromString(resultSet.getString("vehicle_id"));
            String department = resultSet.getString("department");
            String section = resultSet.getString("section");
            String part = resultSet.getString("part");
            Date dateOfService = resultSet.getDate("date_of_service");
            Date dateOfExpiration = resultSet.getDate("date_of_expiration");
            int milesOfService = resultSet.getInt("miles_of_service");
            int milesOfExpiration = resultSet.getInt("miles_of_expiration");
            String position = resultSet.getString("position_or_quantity");
            String info = resultSet.getString("info");


            return new Repair(vehicleId, department, section, part, dateOfService, dateOfExpiration, milesOfService, milesOfExpiration, position, info);
        };
    }
}

