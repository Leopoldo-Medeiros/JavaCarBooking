package com.leo.car;

public class CarDAO {
    private static final Car[] cars;

    static {
        cars = new Car[] {
                new Car("1234", "Fiat", false),
                new Car("4567", "Tesla", true),
                new Car("8901", "Ford", false),
                new Car("1029", "Volkswagen", true)
        };
    }
    public static Car[] getCar() {
        return cars;
    }
}
