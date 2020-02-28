package autoservice.dao;

import autoservice.domain.Braking;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class BrakingDAO {

    private final JdbcTemplate jdbcTemplate;


    public Braking selectAllBraking(UUID id) {
        String sql = "SELECT * FROM braking WHERE vehicle_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                mapVehicleFromDb(),
                id
        );
    }

    private RowMapper<Braking> mapVehicleFromDb() {
        return (resultSet, i) -> {

            UUID vehicleId = UUID.fromString(resultSet.getString("vehicle_id"));
            int section = resultSet.getInt("section");
            int part = resultSet.getInt("part");
            Date dateOfService = resultSet.getDate("date_of_service");
            Date dateOfExpiration = resultSet.getDate("date_of_expiration");
            int milesOfService = resultSet.getInt("miles_of_service");
            int milesOfExpiration = resultSet.getInt("miles_of_expiration");
            String position = resultSet.getString("position");
            String info = resultSet.getString("info");


            return new Braking(vehicleId, section, part, dateOfService, dateOfExpiration, milesOfService, milesOfExpiration, position, info);
        };
    }
}
