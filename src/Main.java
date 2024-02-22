import Methods.CarService;
import Models.Car;
import Repository.CarRepository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRepository carRepository = null;
        try {
            carRepository = new CarRepository();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CarService carService = new CarService(carRepository);
        Scanner scanner = new Scanner(System.in);

        try {
            boolean exit = false;
            while (!exit) {
                System.out.println("|--------------------------------------------------------------|");
                System.out.println("|    SHINA                                                     |");
                System.out.println("|                                                              |");
                System.out.println("|  2.Get all cars    3.Add a new car   6.Search car by model   |");
                System.out.println("|                                                                |");
                System.out.println("|                                                              |");
                System.out.println("4. Update an existing car");
                System.out.println("5. Delete a car by id");
                System.out.println("6. Search car by model");
                System.out.println("7. Exit");
                System.out.println("Enter your choice:");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter car id:");
                        int id = scanner.nextInt();
                        Car carById = carRepository.getById(id);
                        System.out.println("Car by id: " + carById);
                        break;
                    case 2:
                        System.out.println("Enter the sorting option:");
                        System.out.println("1. Sort by year");
                        System.out.println("2. Sort by price");
                        System.out.println("3. No sorting");
                        int option = scanner.nextInt();
                        String sortBy = "";
                        switch (option) {
                            case 1:
                                sortBy = "year";
                                break;
                            case 2:
                                sortBy = "price";
                                break;
                            case 3:
                                sortBy = "id";
                                break;
                            default:
                                System.out.println("Invalid option");
                                break;
                        }
                        List<Car> allCars = carRepository.getAll(sortBy);
                        System.out.println("All cars:");
                        for (Car car : allCars) {
                            System.out.println(car);
                        }
                        break;
                    case 3:
                        carService.addCar();
                        break;
                    case 4:
                        Car existingCar = new Car();
                        System.out.println("Enter car id to update:");
                        existingCar.setId(scanner.nextInt());
                        System.out.println("Enter updated price:");
                        existingCar.setPrice(scanner.nextInt());
                        carRepository.update(existingCar);
                        System.out.println("Existing car updated: " + existingCar);
                        break;
                    case 5:
                        System.out.println("Enter car id to delete:");
                        int deleteId = scanner.nextInt();
                        carRepository.delete(deleteId);
                        System.out.println("Car with id " + deleteId + " deleted.");
                        break;
                    case 7:
                        exit = true;
                        break;
                    case 6:
                        System.out.println("Enter car model to search:");
                        String model = scanner.next();
                        List<Car> carsByModel = carRepository.getByModel(model);
                        System.out.println("Cars with model " + model + ":");
                        for (Car car : carsByModel) {
                            System.out.println(car);
                        }
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

}