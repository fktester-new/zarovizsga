package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    List<String> getDogsByCountry(String country) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("select name from dog_types where country = ?");

        ) {
            stmt.setString(1, country.toUpperCase(Locale.ROOT));
            return parseResult(stmt);

        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Query failed!", sqle);
        }


    }

    private List<String> parseResult(PreparedStatement stmt) {
        List<String> result = new ArrayList<>();
        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                String name = rs.getString("name").toLowerCase();
                result.add(name);
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by query", sqle);
        }

    }
}
