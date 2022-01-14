package ro.fasttrackit.curs13.homework12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarShop {
    private final List<Car> cars = new ArrayList<>();

    public CarShop(Car... cars) {
        this(List.of(cars));
    }

    public CarShop(List<Car> cars) {
        if (cars != null) {
            this.cars.addAll(cars);
        }
    }

    public Map<String, Integer> countCars() {
        Map<String, Integer> result = new HashMap<>();
        for (Car car : cars) {
            Integer crtCount = result.getOrDefault(car.getName(), 0);
            result.put(car.getName(), crtCount + 1);
        }
        return result;
    }

    public Map<KmRange, List<Car>> groupByKm(List<KmRange> ranges) {
        Map<KmRange, List<Car>> result = new HashMap<>();
        for (Car car : cars) {
            KmRange carRange = findRange(ranges, car);
            List<Car> carsForRange = result.get(carRange);
            if (carsForRange == null) {
                carsForRange = new ArrayList<>();
                result.put(carRange, carsForRange);
            }
            carsForRange.add(car);
        }
        return result;
    }

    private KmRange findRange(List<KmRange> ranges, Car car) {
        for (KmRange range : ranges) {
            if (range.matches(car.getKm())) {
                return range;
            }
        }
        KmRange lastRange = ranges.get(ranges.size() - 1);
        return new KmRange(lastRange.getMax(), Integer.MAX_VALUE);
    }
}
