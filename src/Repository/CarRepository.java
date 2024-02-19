package Repository;

import DBconnection.PostgreSQL;
import Models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CarRepository {private static final AtomicInteger count = new AtomicInteger(0);
    private Connection connection= PostgreSQL.getConnection();

    public CarRepository() throws Exception {

    }


    public Car getById(int id) throws Exception {
        String sql = "SELECT * FROM cars WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrend(resultSet.getString("brend"));
                car.setCondition(resultSet.getString("condition"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getInt("price"));
                return car;
            } else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  List<Car> getAll() {
        List<Car> cars = new ArrayList<>();
        try {
            String query = "SELECT * FROM cars ORDER BY id asc ;";
            PreparedStatement st = connection.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrend(resultSet.getString("brend"));
                car.setCondition(resultSet.getString("condition"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getInt("price"));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Car car) {
        String sql = "INSERT INTO cars(brend, condition, year, price) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getBrend());
            stmt.setString(2, car.getCondition());
            stmt.setInt(3, car.getYear());
            stmt.setInt(4, car.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to upload car");
            e.printStackTrace();
        }
    }


    public void update( Car car){
        String sql = "UPDATE cars SET brend = ?, condition = ?, year = ?, price = ? WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, car.getBrend());
            stmt.setString(2, car.getCondition());
            stmt.setInt(3, car.getYear());
            stmt.setDouble(4, car.getPrice());
            stmt.setInt(5,car.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to upload car");
            e.printStackTrace();

        }

    }

    public void delete(int id){
        String sql = "DELETE FROM cars WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to delete book");
            e.printStackTrace();
        }
    }
}
