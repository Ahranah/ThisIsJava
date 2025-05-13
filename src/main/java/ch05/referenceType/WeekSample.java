package ch05.referenceType;

import java.util.Calendar;

public class WeekSample {
public static void main(String[] args) {
    Week  today = null;

    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DAY_OF_WEEK);
    int dayOfWeekInMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);

    today = switch (day) {
        case 1 -> Week.SUNDAY;
        case 2 -> Week.SATURDAY;
        case 3 -> Week.FRIDAY;
        case 4 -> Week.THURSDAY;
        case 5 -> Week.WEDNESDAY;
        case 6 -> Week.TUESDAY;
        case 7 -> Week.MONDAY;
        default -> today;
    };
    System.out.println("dayOfWeekInMonth: " + dayOfWeekInMonth + " year: " + year + " month: " + month + " today: " + today +"  day " + day);
}
}
