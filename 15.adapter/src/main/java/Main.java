import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	public static void main(String[] args) {
		Calendar calendar = new GregorianCalendar();

		NewDateInterface dateAdapter = new CalendarToNewDateAdapter(calendar);

		dateAdapter.setYear(2023);
		dateAdapter.setMonth(Calendar.DECEMBER);
		dateAdapter.setDay(25);

		System.out.println("Initial Date: " + dateAdapter.getYear() + "-" + (dateAdapter.getMonth() + 1) + "-" +
		                   dateAdapter.getDay());

		int daysToAdvance = 10;
		dateAdapter.advanceDays(daysToAdvance);
		System.out.println("Advanced the date by " + daysToAdvance + " days.");

		System.out.println("New Date: " + dateAdapter.getYear() + "-" + (dateAdapter.getMonth() + 1) + "-" +
		                   dateAdapter.getDay());

		dateAdapter.setMonth(Calendar.JANUARY);
		dateAdapter.setDay(1);
		dateAdapter.setYear(2024);
		System.out.println("Set Date: " +
		                   dateAdapter.getYear() + "-" +
		                   (dateAdapter.getMonth() + 1) + "-" +
		                   dateAdapter.getDay());
		dateAdapter.advanceDays(31);
		System.out.println("Advanced into Feb: " + dateAdapter.getYear() + "-" + (dateAdapter.getMonth() + 1) + "-" +
		                   dateAdapter.getDay());
	}
}