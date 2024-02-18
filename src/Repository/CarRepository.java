package Repository;

import DBconnection.PostgreSQL;
import Models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
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
    public  List<Car> getAll() throws Exception{
        List<Car> clients=new ArrayList<>();
        try {
            PreparedStatement st=connection.getc();
            String query="SELECT * FROM Clients ORDER BY id asc ;";
            PreparedStatement st=con.prepareStatement(query);
            ResultSet resultSet=st.executeQuery();
            while (resultSet.next()){
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrend(resultSet.getString("brend"));
                car.setCondition(resultSet.getString("condition"));
                car.setYear(resultSet.getInt("year"));
                car.setPrice(resultSet.getInt("price"));

            }
            return clients;
        }
    }
    public void save(Car cars){
        String sql = "INSERT INTO books(name, author, genre, price, quantity) values(?,?,?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cars.getBrend());
            stmt.setString(2, cars.getAuthor());
            stmt.setString(3, cars.getGenre());
            stmt.setDouble(4, cars.getPrice());
            stmt.setInt(5, cars].getQuantity());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to upload book");
            e.printStackTrace();

        }
    }
    public void update( book){
        String sql = "UPDATE books SET name = ?, author = ?, genre = ?, price = ?, quantity = ? WHERE id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, book.getName());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setDouble(4, book.getPrice());
            stmt.setInt(5, book.getQuantity());
            stmt.setInt(6, book.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to upload book");
            e.printStackTrace();

        }

    }

    public void delete(int id){
        String sql = "DELETE from cars WHERE id = ?";
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
