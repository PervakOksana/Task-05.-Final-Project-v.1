package by.htp.jwd.service.impl;

import java.util.List;

import by.htp.jwd.bean.Car;
import by.htp.jwd.dao.CarDAO;
import by.htp.jwd.dao.DAOException;
import by.htp.jwd.dao.DAOProvider;
import by.htp.jwd.service.CarService;
import by.htp.jwd.service.ServiceException;

public class CarServiceImpl implements CarService {

	@Override
	public boolean addCarService(Car car) throws ServiceException {

		DAOProvider proviger = DAOProvider.getInstance();
		CarDAO carDAO = proviger.getCardao();
		boolean result = false;
		try {
			result = carDAO.addCar(car);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public List<Car> allCar() throws ServiceException {

		DAOProvider proviger = DAOProvider.getInstance();
		CarDAO carDAO = proviger.getCardao();
		List<Car> cars=null;
		try {
			cars = carDAO.allCar();
			System.out.println("List<Car>  ");
		} catch (DAOException e) {
			System.out.println("List<Car>  DAOException");
			throw new ServiceException(e);
			
		}
		return cars;
	}

}
