package ro.fasttrackit.curs13.homework.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private final List<DaySchedule> dailyActivities = new ArrayList<>();
    public DailyPlanner(List<DaySchedule> dailyActivities) {
        if (dailyActivities != null) {
            this.dailyActivities.addAll(dailyActivities);
        }
    }
    public void addActivity (WeekDays day, String activity) throws NoActivityException {
        List<String> activities = new ArrayList<>();

        if (activity == null) {
            throw new NoActivityException("nu exista nicio activitate");
        } else {
            activities.add(activity);
        }
        for (DaySchedule daySchedule : dailyActivities) {
            if (daySchedule.getDay() == day) {
                daySchedule.addActivityInSchedule(activity);
                return; //daca deja am ziua din parametru, opresc metoda aici
            }
        }
        DaySchedule mySchedule = new DaySchedule(day, activities);
        dailyActivities.add(mySchedule);

    }
    public void removeActivity (WeekDays day, String activity) throws NoActivityException {
        if (activity == null) {
            throw new NoActivityException("the activity does not exist");
        } else {
        for (DaySchedule daySchedule : dailyActivities) {
            if (day == daySchedule.getDay()){
                if (daySchedule.getActivities().contains(activity)) {
                        daySchedule.removeActivityInSchedule(activity); //inainte modificam lista din daySchedule in dailyplanner in loc sa o modific in daySchedule
                        return;
                    }
                }
            }
        }
        throw new NoActivityException("the activity does not exist"); //exceptia care functioneaza
    }

    public List<String> getActivities (WeekDays day) {
        List<String> activities = new ArrayList<>();
        for (DaySchedule daySchedule : dailyActivities) {
            if (day == daySchedule.getDay()) {
                activities.addAll(daySchedule.getActivities());
            }
        }
        return activities;
    }

    public Map<WeekDays, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<WeekDays, List<String>> result = new HashMap<>();
        for (DaySchedule daySchedule : dailyActivities) {
            List<String> activities = result.get(daySchedule.getDay());

            if (activities == null) {
                activities = new ArrayList<>();
                result.put(daySchedule.getDay(), activities);
            }
            if (daySchedule.getActivities() == null || daySchedule.getActivities().size() == 0) {
                throw new NoActivitiesForDayException("no activity this day");
            } else {
                activities.addAll(daySchedule.getActivities());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "DailyPlanner{" +
                "dailyActivities=" + dailyActivities +
                '}';
    }
}
