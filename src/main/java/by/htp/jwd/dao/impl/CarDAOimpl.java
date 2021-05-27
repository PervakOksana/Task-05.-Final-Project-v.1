package by.htp.jwd.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.jwd.bean.Car;
import by.htp.jwd.connection_pool.ConnectionPool;
import by.htp.jwd.connection_pool.ConnectionPoolException;
import by.htp.jwd.connection_pool.ConnectionProvider;
import by.htp.jwd.dao.CarDAO;
import by.htp.jwd.dao.DAOException;


public class CarDAOimpl implements CarDAO{

	static {
		MYSQLDriverLoader.getInstance();
	}
	@Override
	public boolean addCar(Car car) throws DAOException {
		System.out.println("addCar");
		boolean result = true;
		Connection con = null;
		Statement st = null;
		ConnectionProvider provider = ConnectionProvider.getInstance();
		ConnectionPool cp = provider.getConnectionPool();
		final String CAR_ADD = "INSERT INTO car (brand, describe_of_brand, bodywork, power, transmission, number_of_doors, year, photo, photoPath  ) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			cp.initPoolData();
			con = cp.takeConnection();
			PreparedStatement preparedStatement = con.prepareStatement(CAR_ADD);

			preparedStatement.setString(1, car.getBrand());
			preparedStatement.setString(2, car.getDescribe_of_brand());
			preparedStatement.setString(3, car.getBodywork());
			preparedStatement.setString(4, car.getPower());
			preparedStatement.setString(5, car.getTransmission());
			preparedStatement.setInt(6, car.getNumber_of_doors());
			preparedStatement.setInt(7, car.getYear());
			preparedStatement.setString(9, car.getPhotoPath());
			
		   InputStream instream=null;
		try {
			instream = Files.newInputStream(Paths.get(car.getPhotoPath()));
			preparedStatement.setBinaryStream(8, instream); 
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		   
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			result = false;
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return result;
	}
	@Override
	public List<Car> allCar() throws DAOException {
		System.out.println("List<Car>   DAO");
		
		Statement st = null;
		ConnectionProvider provider = ConnectionProvider.getInstance();
		ConnectionPool cp = provider.getConnectionPool();

		final String LIST_NEWS = "SELECT * FROM car";
		ResultSet rs = null;
		List<Car> cars = null;
		Connection con = null;
		try {
			cp.initPoolData();
			con = cp.takeConnection();
			st = con.createStatement();
			rs = st.executeQuery(LIST_NEWS);
			cars = new ArrayList<Car>();
			while (rs.next()) {
				
				String brand = rs.getString("brand");
				String describe_of_brand = rs.getString("describe_of_brand");
				String bodywork = rs.getString("bodywork");	
				String power = rs.getString("power");
				String transmission = rs.getString("transmission");
				int number_of_doors = rs.getInt("number_of_doors");		
				int year = rs.getInt("year");
				String photoPath = rs.getString("photoPath");				
				Blob photo = rs.getBlob("photo");
				Car car = new Car(brand, describe_of_brand, bodywork, power, transmission, number_of_doors, year, photoPath);
				
					cars.add(car);
				
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} catch (NullPointerException e) {
			throw new DAOException(e);
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new DAOException(e);
			} catch (NullPointerException e) {
				throw new DAOException(e);
			}
		}

		return cars;
	}

}
