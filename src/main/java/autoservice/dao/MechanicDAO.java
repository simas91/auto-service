package autoservice.dao;

import autoservice.domain.Mechanic;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class MechanicDAO {

    private final JdbcTemplate jdbcTemplate;

    public List<Mechanic> getAllMechanics() {

        String sql = "" +
                "SELECT " +
                "mechanic_id, " +
                "name, " +
                "surname, " +
                "date_of_birth, " +
                "phone_number, " +
                "date_of_start, " +
                "date_of_leave " +
                "FROM mechanic";

        return jdbcTemplate.query(sql, mapMechanicFromDb());

    }

    private RowMapper<Mechanic> mapMechanicFromDb() {
        return (resultSet, i) -> {

            UUID mechanicId = UUID.fromString(resultSet.getString("mechanic_id"));
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            Date dateOfBirth = resultSet.getDate("date_of_birth");
            String phoneNumber = resultSet.getString("phone_number");
            Date dateOfStart = resultSet.getDate("date_of_start");
            Date dateOfLeave = resultSet.getDate("date_of_leave");

            return new Mechanic(mechanicId, name, surname, dateOfBirth, phoneNumber, dateOfStart, dateOfLeave);
        };
    }

    public void addNewMechanic(UUID id, Mechanic mechanic) {

        String sql = "" +
                "INSERT INTO mechanic (" +
                "mechanic_id, " +
                "name, " +
                "surname, " +
                "date_of_birth, " +
                "phone_number, " +
                "date_of_start, " +
                "date_of_leave) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                id,
                mechanic.getName(),
                mechanic.getSurname(),
                mechanic.getDateOfBirth(),
                mechanic.getPhoneNumber(),
                mechanic.getDateOfStart(),
                mechanic.getDateOfLeave()
        );

    }

    public Mechanic selectMechanic(UUID id) {

        String sql = "SELECT * FROM mechanic WHERE mechanic_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                mapMechanicFromDb(),
                id
        );
    }

    public void updateMechanic(UUID id, Mechanic mechanic) {

        String sql = "" +
                "UPDATE mechanic SET " +
                "name = ?, " +
                "surname = ?, " +
                "date_of_birth = ?, " +
                "phone_number = ?, " +
                "date_of_start = ?, " +
                "date_of_leave = ? " +
                "WHERE mechanic_id = ? ";

        jdbcTemplate.update(
                sql,
                mechanic.getName(),
                mechanic.getSurname(),
                mechanic.getDateOfBirth(),
                mechanic.getPhoneNumber(),
                mechanic.getDateOfStart(),
                mechanic.getDateOfLeave(),
                id
        );
    }
}
