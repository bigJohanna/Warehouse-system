import java.time.LocalDateTime;
import java.time.Month;

public enum Season {

    WINTER, SPRING, SUMMER, AUTUMN, ALL;

    double discountAccordingToSeason(NailPolish polish) {
        Month todaysMonth = LocalDateTime.now().getMonth();
        double price = polish.getPrice();

        switch (polish.getSeason()) {
            case WINTER:
            case AUTUMN:
                if (todaysMonth.equals(Month.MARCH) || todaysMonth.equals(Month.APRIL) || todaysMonth.equals(Month.MAY)||
                        todaysMonth.equals(Month.JUNE) || todaysMonth.equals(Month.JULY) || todaysMonth.equals(Month.AUGUST)) {
                    return price * 0.8;
                }
            case SPRING:
            case SUMMER:
                if (todaysMonth.equals(Month.SEPTEMBER) || todaysMonth.equals(Month.OCTOBER) || todaysMonth.equals(Month.NOVEMBER) ||
                        todaysMonth.equals(Month.DECEMBER) || todaysMonth.equals(Month.JANUARY) || todaysMonth.equals(Month.FEBRUARY)) {
                    return price * 0.8;
                }
                break;
        }
        return price;
    }
}