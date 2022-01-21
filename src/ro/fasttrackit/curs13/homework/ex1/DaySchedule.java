package ro.fasttrackit.curs13.homework.ex1;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private final WeekDays day;
    private final List<String> activities;

    public DaySchedule (WeekDays day) { //constructor care cere doar ziua (override)
        this(day, List.of());
    }

    public DaySchedule(WeekDays day, List<String> activities) {
        this.day = day;
        this.activities = activities == null
                ? new ArrayList<>()
                : new ArrayList<>(activities);
    }

    public WeekDays getDay() {
        return day;
    }

    public List<String> getActivities() {
        return new ArrayList<String>(activities); //lista noua care contine exact elem din activities; getActivities intoarce lista de activitati, dar nu si referinta catre variabila din clasa
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }

    public void addActivityInSchedule(String activity) {
        activities.add(activity);
    }
    public void removeActivityInSchedule(String activity) {
        activities.remove(activity);
    }

    public boolean hasActivity(String activity) {
        return activities.contains(activity);
    }



}
