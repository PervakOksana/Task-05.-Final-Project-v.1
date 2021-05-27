package by.htp.jwd.command.impl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import by.htp.jwd.bean.Car;
import by.htp.jwd.command.Command;
import by.htp.jwd.service.CarService;
import by.htp.jwd.service.ServiceException;
import by.htp.jwd.service.ServiceProvider;

@MultipartConfig(maxFileSize = 16177215)
public class AddNewCar implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServiceProvider provider = ServiceProvider.getInstance();
		CarService carService = provider.getCarServise();

		String brand = request.getParameter("brand");
		String describe_of_brand = request.getParameter("describe_of_brand");
		String bodywork = request.getParameter("bodywork");
		String power = request.getParameter("power");
		String transmission = request.getParameter("transmission");
		int number_of_doors = Integer.parseInt(request.getParameter("number_of_doors"));
		int year = Integer.parseInt(request.getParameter("year"));

		String photoPath = request.getParameter("photoPath");

		Car car = new Car(brand, describe_of_brand, bodywork, power, transmission, number_of_doors, year, photoPath);
		System.out.println(car.toString());
		try {
			carService.addCarService(car);
			response.sendRedirect("Controller?command=indexview");
		} catch (ServiceException e) {
			response.sendRedirect("Controller?command=indexview");
		}
	}

}
