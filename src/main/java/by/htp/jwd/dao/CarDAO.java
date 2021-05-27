package by.htp.jwd.dao;

import java.util.List;

import by.htp.jwd.bean.Car;

public interface CarDAO {
	
	boolean addCar (Car car) throws DAOException;
	List<Car> allCar() throws DAOException;
}
