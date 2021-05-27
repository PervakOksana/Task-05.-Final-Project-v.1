package by.htp.jwd.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.jwd.bean.Car;
import by.htp.jwd.command.Command;
import by.htp.jwd.service.CarService;
import by.htp.jwd.service.ServiceException;
import by.htp.jwd.service.ServiceProvider;

public class IndexView implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// RequestDispatcher requestDispather =
		// request.getRequestDispatcher("/WEB-INF/views/index_view.jsp");
		// requestDispather.forward(request, response);

		ServiceProvider provider = ServiceProvider.getInstance();
		CarService carService = provider.getCarServise();
		HttpSession session = request.getSession();
		try {
			System.out.println("IndexView ");
			List<Car> cars = carService.allCar();
			for (Car car : cars) {
				System.out.println(car.getBrand());
			}
			request.setAttribute("cars", cars);

			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/views/index_view.jsp");
			requestDispather.forward(request, response);
			// session.removeAttribute("messageLog");
			// session.removeAttribute("message");

		} catch (ServiceException e) {
			System.out.println("IndexView  ServiceException e");
			RequestDispatcher requestDispather = request.getRequestDispatcher("/WEB-INF/views/index_view.jsp");
			requestDispather.forward(request, response);
		}
	}

}
