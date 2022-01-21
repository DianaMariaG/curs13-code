package ro.fasttrackit.curs13.homework.ex2;

import ro.fasttrackit.curs13.homework.ex1.DailyPlanner;
import ro.fasttrackit.curs13.homework.ex1.NoActivitiesForDayException;
import ro.fasttrackit.curs13.homework.ex1.NoActivityException;
import ro.fasttrackit.curs13.homework.ex1.WeekDays;

import java.util.List;
import java.util.Scanner;

public class ApplicationMenu {
    public static void main(String[] args) throws NoActivityException, NoActivitiesForDayException {
        DailyPlanner dailyPlanner = new DailyPlanner();

        boolean option = true;
        do {
            System.out.println("Please choose an option between 1) - 5)");
            System.out.println(" 1)-add an activity \n 2)-remove an activity \n 3)-list all activities \n 4)-end planning 5)-Exit");
            int input = userInput();
            try {
                switch (input) {
                    case 1 -> optionAddActivity(dailyPlanner);
                    case 2 -> optionRemoveActivity(dailyPlanner);
                    case 3 -> optionListActivitiesForDay(dailyPlanner);
                    case 4 -> optionEndPlanning(dailyPlanner);
                    case 5 -> {
                        option = false;
                    }
                    default -> System.out.println("The option does not exist");
                };
            } catch (NoActivityException | NoActivitiesForDayException activityException) {
                System.out.println(activityException.getMessage());
            }
        }while(option);
    }

    private static int userInput() {
        Scanner console = new Scanner(System.in);

        System.out.println("Choose an option, by selecting the corresponding number");
        return console.nextInt();
    }

    private static void optionAddActivity(DailyPlanner dailyPlanner) throws NoActivityException {
        WeekDays day = chooseOneDay();
        String activityInput = chooseOneActivity();

        dailyPlanner.addActivity(day,activityInput);
        System.out.println("The activity was successfully added!");
    }

    private static void optionRemoveActivity(DailyPlanner dailyPlanner) throws NoActivityException {
        WeekDays day = chooseOneDay();
        String activityInput = chooseOneActivity();

        dailyPlanner.removeActivity(day,activityInput);
        System.out.println("The activity was removed!");
    }

    private static void optionListActivitiesForDay(DailyPlanner dailyPlanner) {
        WeekDays day = chooseOneDay();
        System.out.println(dailyPlanner.getActivities(day)); //printez toate activitatile pt ziua respectiva
    }

    private static void optionEndPlanning(DailyPlanner dailyPlanner) throws NoActivitiesForDayException {
        System.out.println("Your daily planner looks like this: " +dailyPlanner.endPlanning());
    }

    private static WeekDays chooseOneDay() {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduce the day by choosing a number between 1-7: ");
        int dayInput = console.nextInt();
        WeekDays day = switch (dayInput) {
            case 1 -> WeekDays.MONDAY;
            case 2 -> WeekDays.TUESDAY;
            case 3 -> WeekDays.WEDNESDAY;
            case 4 -> WeekDays.THURSDAY;
            case 5 -> WeekDays.FRIDAY;
            case 6 -> WeekDays.SATURDAY;
            case 7 -> WeekDays.SUNDAY;
            default -> null;
        };
        return day;
    }

    private static String chooseOneActivity() {
        Scanner console = new Scanner(System.in);
        System.out.println("Introduce the activity: ");
        String activityInput = console.next();
        return activityInput;
    }

}
