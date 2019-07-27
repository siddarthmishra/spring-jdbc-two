package com.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.daoImpl.PassengerDAOImpl;
import com.pojo.Passenger;

public class PassengerMain {

	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				com.configurations.SpringJdbcConfig.class);
		PassengerDAOImpl passengerDAOImpl = context.getBean("myPassengerDAOImpl", PassengerDAOImpl.class);
		Scanner sc = new Scanner(System.in);
		int ch, id;
		String name, source, destination, status, _dob, _doj, stringTime, time;
		LocalDate dob, doj;
		LocalDateTime _time;
		float cost;
		Passenger passenger = new Passenger();
		final int EXIT = 5;
		do {
			System.out.println("1.Insert\n2.Read\n3.Update\n4.Delete");
			System.out.println(EXIT + ".Exit\nEnter the option from above");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("\nInsert Passenger");
				System.out.println("Enter the Passenger name : ");
				name = sc.next();
				System.out.println("Enter the source : ");
				source = sc.next();
				System.out.println("Enter the destination : ");
				destination = sc.next();
				System.out.println("Enter date of booking (YYYY-MM-DD) : ");
				_dob = sc.next();
				dob = LocalDate.parse(_dob);
				System.out.println("Enter date of journey (YYYY-MM-DD) : ");
				_doj = sc.next();
				doj = LocalDate.parse(_doj);
				System.out.println("Enter departure time (HH:mm:ss) : ");
				stringTime = sc.next().trim();
				_time = LocalDateTime.of(doj, LocalTime.parse(stringTime));
				time = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss").format(_time);
				System.out.println("Enter booking status (W/L, RAC,CNF) : ");
				status = sc.next();
				System.out.println("Enter the cost : ");
				cost = sc.nextFloat();
				passenger = new Passenger(name, source, destination, dob, doj, time, status, cost);
				passengerDAOImpl.save(passenger);
				break;
			case 2:
				System.out.println("\nEnter passenger id : ");
				id = sc.nextInt();
				passenger = passengerDAOImpl.getById(id);
				if (passenger.getId() != 0)
					System.out.println(passenger + "\n");
				else
					System.out.println("Details not found\n");
				break;
			case 3:
				System.out.println("Enter passenger ID : ");
				id = sc.nextInt();
				passengerDAOImpl.updateById(id);
				break;
			case 4:
				System.out.println("\nEnter the passenger ID : ");
				id = sc.nextInt();
				passengerDAOImpl.deleteById(id);
				break;
			case EXIT:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Selection. Enter again\n");
			}

		} while (ch != EXIT);
		System.out.println("Thank You");
		sc.close();
		context.close();
	}

}
