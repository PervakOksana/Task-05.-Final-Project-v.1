package by.htp.jwd.service;

import java.util.List;

import by.htp.jwd.bean.Car;

public interface CarService {
	
	public boolean addCarService(Car car) throws ServiceException;
	public List<Car> allCar() throws ServiceException;

}
