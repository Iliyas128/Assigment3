package Models;

public class Car {
    private int id;
    private String brend;
    private String model;
    private int year;

    private String condition;

    private int price;

    public Car() {

    }

    public Car(String brend, String model,int year, String condition, int price){
        this.brend=brend;
        this.model = model;
        this.year=year;
        this.condition=condition;
        this.price=price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brend='" + brend + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", condition='" + condition + '\'' +
                ", price=" + price +
                '}';
    }
}
