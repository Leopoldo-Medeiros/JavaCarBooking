package leo.carbooking.car;

public class Car {
    private final String regNumber;
    private final String brand;
    private final boolean isElectric;

    // Constructor
    public Car(String regNumber, String brand, boolean isElectric) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.isElectric = isElectric;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isElectric() {
        return isElectric;
    }
}
