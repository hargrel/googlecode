package edu.itee.antipodes.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import edu.itee.antipodes.domain.db.Tour;

public class JdbcTourDao extends SimpleJdbcDaoSupport implements TourDao {
	
	public List<Tour> getTourList() {
		String sql = "SELECT tourID, tourName, tourDesc, price, totalDays FROM tour";
		List<Tour> tours = getSimpleJdbcTemplate().query(sql, new TourMapper());
		return tours;
	}
	
	public Tour getTourByID(int id) {
		String sql = "SELECT tourID, tourName, tourDesc, price, totalDays FROM tour WHERE tourID = " + id;
		List<Tour> tours = getSimpleJdbcTemplate().query(sql, new TourMapper());
		return tours.get(0);
	}
	
	public void saveTour(Tour tour) {
		String sql = "UPDATE TOUR SET tourName = :tourName, tourDesc = :tourDesc, price = :price, totalDays = :totalDays WHERE tourID = :tourID";
		getSimpleJdbcTemplate().update(sql, new MapSqlParameterSource()
			.addValue("tourName", tour.getTourName())
	        .addValue("tourDesc", tour.getTourDesc())
	        .addValue("price", tour.getPrice())
	        .addValue("totalDays", tour.getTotalDays())
	        .addValue("tourID", tour.getTourID())
	        );
	}
	
	public void dropTour(Tour tour) {
		String sql = "DELETE FROM tour WHERE tourID = " + tour.getTourID();
		getSimpleJdbcTemplate().update(sql);
	}
	
	public void addTour(Tour tour) {
		String sql = "insert into tour (tourID, tourName, tourDesc, price, totalDays) values (?, ?, ?, ?, ?)";
		getSimpleJdbcTemplate().update(sql, new Object[] {
				tour.getTourID(), 
				tour.getTourName(),
				tour.getTourDesc(),
				tour.getPrice(),
				tour.getTotalDays()
			}
		);
	}

    private static class TourMapper implements ParameterizedRowMapper<Tour> {

        public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {
            Tour tr = new Tour();
            tr.setTourID(rs.getInt("tourID"));
            tr.setTourName(rs.getString("tourName"));
            tr.setTourDesc(rs.getString("tourDesc"));
            tr.setPrice(new Double(rs.getDouble("price")));
            tr.setTotalDays(rs.getInt("totalDays"));
            return tr;
        }

    }	
	
	
}
