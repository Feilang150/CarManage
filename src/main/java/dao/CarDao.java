package dao;

import model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM car";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
             
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String carBrand = resultSet.getString("car_brand");
                String carType = resultSet.getString("car_type");
                int price = resultSet.getInt("price");
                Date carColor = resultSet.getDate("car_color");

                cars.add(new Car(id, carBrand, carType, price, carColor));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public void addCar(Car car) {
        String sql = "INSERT INTO car (car_brand, car_type, price, car_color) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, car.getCarBrand());
            preparedStatement.setString(2, car.getCarType());
            preparedStatement.setInt(3, car.getPrice());
            preparedStatement.setDate(4, new java.sql.Date(car.getCarColor().getTime()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        String sql = "UPDATE car SET car_brand=?, car_type=?, price=?, car_color=? WHERE id=?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setString(1, car.getCarBrand());
            preparedStatement.setString(2, car.getCarType());
            preparedStatement.setInt(3, car.getPrice());
            preparedStatement.setDate(4, new java.sql.Date(car.getCarColor().getTime()));
            preparedStatement.setInt(5, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(int id) {
        String sql = "DELETE FROM car WHERE id=?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Car getCarById(int id) {
        Car car = null;
        String sql = "SELECT * FROM car WHERE id=?";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String carBrand = resultSet.getString("car_brand");
                String carType = resultSet.getString("car_type");
                int price = resultSet.getInt("price");
                Date carColor = resultSet.getDate("car_color");

                car = new Car(id, carBrand, carType, price, carColor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }
}