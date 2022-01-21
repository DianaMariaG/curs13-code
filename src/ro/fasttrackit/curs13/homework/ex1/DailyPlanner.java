package ro.fasttrackit.curs13.homework.ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPlanner {
    private final List<DaySchedule> dailyActivities;

    public DailyPlanner() {
        this.dailyActivities = new ArrayList<>();
        for (WeekDays day : WeekDays.values()) {
            this.dailyActivities.add(new DaySchedule(day)); //am prepoulat lista si nu mai verific la fiecare met daca exista obiectul
            //tot timpul obiectul va exista; mai trb verificat doar daca lista e goala sau nu
        }
    }
    public void addActivity (WeekDays day, String activity) throws NoActivityException {
        if (activity == null) {
            throw new NoActivityException("nu exista nicio activitate");
        }
        DaySchedule daySchedule = findSchedule(day); //met utila ca sa nu fac return din for si sa nu rup logica in 2
        if (daySchedule == null) {
            this.dailyActivities.add(new DaySchedule(day, List.of(activity)));
        } else {
            daySchedule.addActivityInSchedule(activity);
        }
        //findSchedule(day).addActivityInSchedule(activity) - pentru cazul in care obiectul exista mereu
    }

    private DaySchedule findSchedule(WeekDays day) {
        for (DaySchedule schedule : dailyActivities) {
            if (schedule.getDay() == day) {
                return schedule;
            }
        }
        return null;
    }

    public void removeActivity (WeekDays day, String activity) throws NoActivityException {
        if (activity == null) {
            throw new NoActivityException("the activity does not exist");
        }
        DaySchedule daySchedule = findSchedule(day);
        if (daySchedule.hasActivity(activity)) {
            daySchedule.removeActivityInSchedule(activity); //inainte modificam lista din daySchedule in dailyplanner in loc sa o modific in daySchedule
        } else {
            throw new NoActivityException("the activity does not exist this day");
        }
    }

    public List<String> getActivities (WeekDays day) {
        DaySchedule daySchedule = findSchedule(day);
        return daySchedule.getActivities();
    }

    public Map<WeekDays, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<WeekDays, List<String>> result = new HashMap<>();
        for (DaySchedule daySchedule : dailyActivities) {

            if (daySchedule.getActivities().isEmpty()) { //acum, lista de activitati nu mai e nula, ca e predefinita in constructor
                throw new NoActivitiesForDayException("EXCEPTION: you don't have activities for everyday!!");
            }
            List<String> activities = daySchedule.getActivities();
            result.put(daySchedule.getDay(), activities);
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
