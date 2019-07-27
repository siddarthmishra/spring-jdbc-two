package com.mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.pojo.Passenger;

public class PassengerMapper implements RowMapper<Passenger> {

	@Override
	public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Passenger passenger = new Passenger();
		passenger.setId(rs.getInt("id"));
		passenger.setName(rs.getString("name"));
		passenger.setSource(rs.getString("source"));
		passenger.setDestination(rs.getString("destination"));
		Date _dob = rs.getDate("booking_date");
		passenger.setDob(LocalDate.parse(_dob.toString()));
		Date _doj = rs.getDate("journey_date");
		passenger.setDoj(LocalDate.parse(_doj.toString()));
		passenger.setTime(rs.getTime("departure_time").toString());
		passenger.setStatus(rs.getString("booking_status"));
		passenger.setCost(rs.getFloat("cost"));
		return passenger;
	}

}
