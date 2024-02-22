package Methods;

import Models.Car;

import java.util.List;
import java.util.Scanner;

public class MainHelper {
    private Scanner scanner;
    private CarService carService;

    public MainHelper(Scanner scanner, CarService carService) {
        this.scanner = scanner;
        this.carService = carService;
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }

    public void displayCarById() {
        System.out.println("Enter car id:");
        int id = scanner.nextInt();
        Car carById = carService.getCarById(id);
        System.out.println("Car by id: " + carById);
    }

    public void displayAllCars() {
        System.out.println("Enter the sorting option:");
        System.out.println("1. Sort by year");
        System.out.println("2. Sort by price");
        System.out.println("3. No sorting");
        int option = scanner.nextInt();
        String sortBy = getSortByOption(option);
        List<Car> allCars = carService.getAllCars(sortBy);
        System.out.println("All cars:");
        allCars.forEach(System.out::println);
    }

    private String getSortByOption(int option) {
        switch (option) {
            case 1:
                return "year";
            case 2:
                return "price";
            case 3:
                return "id";
            default:
                throw new IllegalArgumentException("Invalid sorting option");
        }
    }

    public void updateExistingCar() {
        Car existingCar = new Car();
        System.out.println("Enter car id to update:");
        existingCar.setId(scanner.nextInt());
        System.out.println("Enter updated price:");
        existingCar.setPrice(scanner.nextInt());
        carService.updateCar(existingCar);
        System.out.println("Existing car updated: " + existingCar);
    }

    public void deleteCarById() {
        System.out.println("Enter car id to delete:");
        int deleteId = scanner.nextInt();
        carService.deleteCar(deleteId);
        System.out.println("Car with id " + deleteId + " deleted.");
    }

    public void searchCarByModel() {
        System.out.println("Enter car model to search:");
        String model = scanner.next();
        List<Car> carsByModel = carService.getCarsByModel(model);
        System.out.println("Cars with model " + model + ":");
        carsByModel.forEach(System.out::println);
    }
}
