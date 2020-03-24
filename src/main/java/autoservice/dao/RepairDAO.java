package autoservice.dao;

import autoservice.domain.Repair;
import autoservice.domain.Vehicle;
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

    public List<Repair> getAllRepairs() {

        String sql = "" +
                "SELECT " +
                "vehicle_id, " +
                "mechanic_id, " +
                "department, " +
                "section, " +
                "part, " +
                "date_of_service, " +
                "date_of_expiration, " +
                "miles_of_service, " +
                "miles_of_expiration, " +
                "position_or_quantity, " +
                "info " +
                "FROM service";

        return jdbcTemplate.query(sql, mapRepairFromDb());
    }

    public List<Repair> getSpecificVehicleRepair(UUID vehicleId, int department, int section, int part) {
        String sql = "SELECT * FROM service WHERE vehicle_id = ? AND department = ? AND section = ? AND part = ?";

        return jdbcTemplate.query(
                sql,
                mapRepairFromDb(),
                vehicleId,
                department,
                section,
                part
        );
    }

    public List<Repair> getSpecificMechanicRepair(UUID mechanicId, int department, int section, int part) {
        String sql = "SELECT * FROM service WHERE mechanic_id = ? AND department = ? AND section = ? AND part = ?";

        return jdbcTemplate.query(
                sql,
                mapRepairFromDb(),
                mechanicId,
                department,
                section,
                part
        );
    }

    public List<Repair> getAllSelectedMechanicRepair(UUID mechanicId) {
        String sql = "SELECT * FROM service WHERE mechanic_id = ?";

        return jdbcTemplate.query(
                sql,
                mapRepairFromDb(),
                mechanicId
        );
    }

    private RowMapper<Repair> mapRepairFromDb() {
        return (resultSet, i) -> {

            UUID vehicleId = UUID.fromString(resultSet.getString("vehicle_id"));
            UUID mechanicId = UUID.fromString(resultSet.getString("mechanic_id"));
            int department = resultSet.getInt("department");
            int section = resultSet.getInt("section");
            int part = resultSet.getInt("part");
            Date dateOfService = resultSet.getDate("date_of_service");
            Date dateOfExpiration = resultSet.getDate("date_of_expiration");
            int milesOfService = resultSet.getInt("miles_of_service");
            int milesOfExpiration = resultSet.getInt("miles_of_expiration");
            String position = resultSet.getString("position_or_quantity");
            String info = resultSet.getString("info");


            return new Repair(vehicleId, mechanicId, department, section, part, dateOfService, dateOfExpiration, milesOfService, milesOfExpiration, position, info);
        };
    }

    public void insertNewRepair(Repair repair) {
        String sql = "" +
                "INSERT INTO service (" +
                "vehicle_id, " +
                "mechanic_id, " +
                "department, " +
                "section, " +
                "part, " +
                "date_of_service, " +
                "date_of_expiration, " +
                "miles_of_service, " +
                "miles_of_expiration, " +
                "position_or_quantity, " +
                "info ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                repair.getVehicleId(),
                repair.getMechanicId(),
                repair.getDepartment(),
                repair.getSection(),
                repair.getPart(),
                repair.getDateOfService(),
                repair.getDateOfExpiration(),
                repair.getMilesOfService(),
                repair.getMilesOfExpiration(),
                repair.getPositionOrQuantity(),
                repair.getInfo()
        );
    }
}

