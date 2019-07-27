package com.dao;

import java.sql.SQLException;

import com.pojo.Passenger;

public interface PassengerDAO {

	// Insert
	public void save(Passenger passenger) throws SQLException;

	// Read
	public Passenger getById(int id);

	// Update
	public void updateById(int id);

	// Delete
	public void deleteById(int id);
}
