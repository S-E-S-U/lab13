import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarDataProcessor {
    public static void main(String[] args) {
        List<Car> cars = readCarDataFromFile("src/car_info.txt");

        String targetBrand = "Toyota";

        System.out.println("Cars of brand " + targetBrand + ":");
        for (Car car : cars) {
            if (car.brand.equals(targetBrand)) {
                System.out.println(car);
            }
        }
    }

    public static List<Car> readCarDataFromFile(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String brand = parts[0];
                    String model = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    int mileage = Integer.parseInt(parts[3]);
                    cars.add(new Car(brand, model, year, mileage));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}