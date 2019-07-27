package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.dao.PassengerDAO;
import com.mapper.PassengerMapper;
import com.pojo.Passenger;

public class PassengerDAOImpl implements PassengerDAO {

	private JdbcTemplate jdbcTemplate;

	public PassengerDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void save(Passenger passenger) throws SQLException {
		String SQL = "insert into passenger(name, source, destination, booking_date, journey_date, departure_time, booking_status, cost) values(?,?,?,?,?,?,?,?)";
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, passenger.getName());
				ps.setString(2, passenger.getSource());
				ps.setString(3, passenger.getDestination());
				ps.setDate(4, Date.valueOf(passenger.getDob().toString()));
				ps.setDate(5, Date.valueOf(passenger.getDoj().toString()));
				ps.setString(6, passenger.getTime());
				ps.setString(7, passenger.getStatus());
				ps.setFloat(8, passenger.getCost());
				return ps;
			}
		}, generatedKeyHolder);
		passenger.setId(generatedKeyHolder.getKey().intValue());
		System.out
				.println("Data is inserted successfully and the generated passenger id is " + passenger.getId() + "\n");
	}

	@Override
	public Passenger getById(int id) {
		String SQL = "select * from passenger where id = ?";
		List<Passenger> passenger = jdbcTemplate.query(SQL, new PassengerMapper(), id);
		return passenger.size() == 1 ? passenger.get(0) : new Passenger();
	}

	@Override
	public void updateById(int id) {
		Passenger originalPassenger = getById(id);
		if (originalPassenger.getId() != 0) {
			String SQL = "update passenger set booking_status = ? where id = ?";
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter booking status (W/L, RAC,CNF) : ");
			String status = sc.next();
			int i = jdbcTemplate.update(SQL, status, id);
			if (i == 1)
				System.out.println("Successfully updated the booking status\n");
			else
				System.out.println("FAILED\n");
		} else
			System.out.println("Details not found\n");
	}

	@Override
	public void deleteById(int id) {
		String SQL = "delete from passenger where id = ?";
		int i = jdbcTemplate.update(SQL, id);
		if (i == 1)
			System.out.println("Passenger details successfully deleted\n");
		else
			System.out.println("Passenger not found\n");
	}

}
