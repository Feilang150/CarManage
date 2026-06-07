package model;

import java.util.Date;

public class Car {
    private int id;
    private String carBrand;
    private String carType;
    private int price;
    private Date carColor;

    public Car() {}

    public Car(int id, String carBrand, String carType, int price, Date carColor) {
        this.id = id;
        this.carBrand = carBrand;
        this.carType = carType;
        this.price = price;
        this.carColor = carColor;
    }

    // Getter 和 Setter 方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getCarBrand() { return carBrand; }
    public void setCarBrand(String carBrand) { this.carBrand = carBrand; }

    public String getCarType() { return carType; }
    public void setCarType(String carType) { this.carType = carType; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public Date getCarColor() { return carColor; }
    public void setCarColor(Date carColor) { this.carColor = carColor; }
}