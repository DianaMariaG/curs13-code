package ro.fasttrackit.curs13.homework.ex1;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private final WeekDays day;
    private final List<String> activities = new ArrayList<>();

    public DaySchedule(WeekDays day, List<String> activities) {
        this.day = day;
        if (activities != null) {
            this.activities.addAll(activities);
        }
    }
    public WeekDays getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }

    @Override
    public String toString() { //new
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
