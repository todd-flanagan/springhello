package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class BuildRowMapper implements RowMapper<Build> {

	@Override
	public Build mapRow(ResultSet rs, int rowNum) throws SQLException {

		Build b = new Build();

		b.settoolbox(rs.getString("toolbox"));
		b.setctf(rs.getString("ctf"));

		return b;
	}

}
