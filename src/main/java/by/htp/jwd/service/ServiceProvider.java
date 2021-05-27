package by.htp.jwd.service;

import by.htp.jwd.service.impl.CarServiceImpl;
import by.htp.jwd.service.impl.UserServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {
	}

	private final UserService userServise = new UserServiceImpl();
	private final CarService carServise = new CarServiceImpl();

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserServise() {
		return userServise;
	}

	public CarService getCarServise() {
		return carServise;
	}
	
}
