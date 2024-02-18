package Models;

public class Car {
    private int id;
    private String brend;
    private int year;

    private String condition;

    private int price;



    public Car(int id,String brend,int year, String condition, int price){
        this.id=id;
        this.brend=brend;
        this.year=year;
        this.condition=condition;
        this.price=price;
    }

    public Car() {

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
                ", year=" + year +
                ", condition='" + condition + '\'' +
                ", price=" + price +
                '}';
    }
}
