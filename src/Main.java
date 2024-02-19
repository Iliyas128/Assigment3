import Models.Car;
import Repository.CarRepository;

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
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("1. Get car by id");
            System.out.println("2. Get all cars");
            System.out.println("3. Add a new car");
            System.out.println("4. Update an existing car");
            System.out.println("5. Delete a car by id");
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
                    List<Car> allCars = carRepository.getAll();
                    System.out.println("All cars: " + allCars);
                    break;
                case 3:
                    Car newCar = new Car();
                    System.out.println("Enter car brand:");
                    newCar.setBrend(scanner.next());
                    System.out.println("Enter car condition:");
                    scanner.nextLine();
                    newCar.setCondition(scanner.nextLine());
                    System.out.println("Enter car year:");
                    newCar.setYear(scanner.nextInt());
                    System.out.println("Enter car price:");
                    newCar.setPrice(scanner.nextInt());
                    try {
                        carRepository.save(newCar);
                        System.out.println("New car saved: " + newCar);
                    } catch (Exception e) {
                        System.out.println("Failed to save new car: " + e.getMessage());
                    }
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
                default:
                    System.out.println("Invalid choice");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
