import Methods.CarService;
import Methods.MainHelper;
import Models.Car;
import Repository.CarRepository;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final CarService carService;
    private final MainHelper mainHelper;

    public Main() {
        Scanner scanner = new Scanner(System.in);
        CarRepository carRepository;
        try {
            carRepository = new CarRepository();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        carService = new CarService(carRepository);
        mainHelper = new MainHelper(scanner, carService);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = mainHelper.getUserChoice();
            switch (choice) {
                case 1:
                    mainHelper.displayCarById();
                    break;
                case 2:
                    mainHelper.displayAllCars();
                    break;
                case 3:
                    carService.addCar();
                    break;
                case 4:
                    mainHelper.updateExistingCar();
                    break;
                case 5:
                    mainHelper.deleteCarById();
                    break;
                case 6:
                    mainHelper.searchCarByModel();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        mainHelper.closeScanner();
    }

    private void displayMenu() {
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|    SHINA.com                                                     7.Exit       |");
        System.out.println("+-------------------------------------------------------------------------------|");
        System.out.println("|  2.all available cars      6.Search car by model      3.Sell your car         |");
        System.out.println("|                                                                               |");
        System.out.println("|                                                                               |");
        System.out.println("|  4.Update an existing car                             5.Delete a car by id    |");
        System.out.println("|                                                                               |");
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("Enter your choice:");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
}
