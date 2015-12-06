package SCJPTest.Examples;
import java.util.Arrays;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


public class TestArrays {
	public static void main(String[] args)
	{
		String[] array = {"abc", "def", "ghi" };
		System.out.println(Arrays.toString(array));
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));
		System.out.println(LocalDateTime.now(Clock.system(ZoneId.systemDefault())));
		System.out.println("UTC: " + LocalDateTime.now(Clock.systemUTC()));
		System.out.println(LocalDateTime.now(Clock.systemDefaultZone()));
		
		LocalDateTime ldt = LocalDateTime.of(2015, Month.DECEMBER, 30, 20,28, 35, 1000 * (int)Math.pow(10, 5) );
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		LocalDateTime ldt1 = LocalDateTime.now();
	
		System.out.println(dtf.format(ldt1));
		System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalTime.now()));
		System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(LocalDateTime.now()));
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(LocalDateTime.now()));
		System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(LocalDate.now()));
	}

}
