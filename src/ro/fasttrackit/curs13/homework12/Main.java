package ro.fasttrackit.curs13.homework12;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarShop shop = new CarShop(
                new Car("BMW", 20, 400000, 2000),
                new Car("Audi", 2, 40000000, 2000),
                new Car("Mercedes", 12, 112000, 2000),
                new Car("Opel", 5, 44200, 2000),
                new Car("BMW", 3, 1000, 2000),
                new Car("Audi", 7, 4000, 2000));

        System.out.println(shop.countCars());
        System.out.println(shop.groupByKm(List.of(
                new KmRange(0, 10000),
                new KmRange(10000, 100000),
                new KmRange(100000, 1000_000))));
    }
}
