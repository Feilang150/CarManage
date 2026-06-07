package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Car;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import dao.CarDao;

/**
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarDao carDao = new CarDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if ("list".equals(action)) {
            List<Car> cars = carDao.getAllCars();
            request.setAttribute("cars", cars);
            request.getRequestDispatcher("/views/listCar.jsp").forward(request, response);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Car car = carDao.getCarById(id);
            request.setAttribute("car", car);
            request.getRequestDispatcher("/views/editCar.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            carDao.deleteCar(id);
            response.sendRedirect("CarServlet?action=list");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String action = request.getParameter("action");

        if ("add".equals(action)) {
            String carBrand = request.getParameter("carBrand");
            String carType = request.getParameter("carType");
            int price = Integer.parseInt(request.getParameter("price"));
            Date carColor = Date.valueOf(request.getParameter("carColor"));

            Car car = new Car(0, carBrand, carType, price, carColor);
            carDao.addCar(car);
            response.sendRedirect("CarServlet?action=list");
        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String carBrand = request.getParameter("carBrand");
            String carType = request.getParameter("carType");
            int price = Integer.parseInt(request.getParameter("price"));
            Date carColor = Date.valueOf(request.getParameter("carColor"));

            Car car = new Car(id, carBrand, carType, price, carColor);
            carDao.updateCar(car);
            response.sendRedirect("CarServlet?action=list");
        }
    }

}

/*
import javax.servlet.ServletException;
import javax.servlet.http.*;
*/
