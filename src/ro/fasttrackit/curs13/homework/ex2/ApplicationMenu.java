package ro.fasttrackit.curs13.homework.ex2;

import ro.fasttrackit.curs13.homework.ex1.DailyPlanner;
import ro.fasttrackit.curs13.homework.ex1.NoActivitiesForDayException;
import ro.fasttrackit.curs13.homework.ex1.NoActivityException;
import ro.fasttrackit.curs13.homework.ex1.WeekDays;

import java.util.List;
import java.util.Scanner;

public class ApplicationMenu {
    public static void main(String[] args) throws NoActivityException, NoActivitiesForDayException {
        DailyPlanner dailyPlanner = new DailyPlanner(List.of());

        boolean option = true;
        do {
            int input = userInput();
            dailyPlanner = switch (input) {
                case 1 -> userInputOption1(dailyPlanner);
                case 2 -> userInputOption2(dailyPlanner);
                case 3 -> userInputOption3(dailyPlanner);
                case 4 -> userInputOption4(dailyPlanner);
                case 5 -> {
                    option = false;
                    yield dailyPlanner;
                }
                default -> null;
            };
        }while (option);

        System.out.println(dailyPlanner);
    }

    private static int userInput() {
        Scanner console = new Scanner(System.in);

        System.out.println("Choose an option, by selecting the corresponding number");
        return console.nextInt();
    }
    private static DailyPlanner userInputOption1(DailyPlanner dailyPlanner) throws NoActivityException {
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
        System.out.println("Introduce the activity: ");
        String activityInput = console.next();
        dailyPlanner.addActivity(day,activityInput);
        return dailyPlanner;

    }
    private static DailyPlanner userInputOption2(DailyPlanner dailyPlanner) throws NoActivityException {
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

        System.out.println("Introduce the activity: ");
        String activityInput = console.next();
        dailyPlanner.removeActivity(day,activityInput);
        return dailyPlanner;
    }
    private static DailyPlanner userInputOption3(DailyPlanner dailyPlanner) {
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
        dailyPlanner.getActivities(day);
        return dailyPlanner;
    }

    private static DailyPlanner userInputOption4(DailyPlanner dailyPlanner) throws NoActivitiesForDayException {
        Scanner console = new Scanner(System.in);

        dailyPlanner.endPlanning();
        return dailyPlanner;
    }

}
