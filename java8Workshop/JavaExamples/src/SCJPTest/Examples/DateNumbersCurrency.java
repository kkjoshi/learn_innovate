package SCJPTest.Examples;
import java.util.*;
import java.text.*;

public class DateNumbersCurrency {

	public static void main(String[] args) {
		
		Calendar cl = Calendar.getInstance();
		System.out.println(cl.getTime().toLocaleString());
		DateFormat dtf1 = DateFormat.getDateInstance(2, Locale.ITALY);
		DateFormat dtf2 = DateFormat.getDateInstance(DateFormat.FULL, Locale.GERMANY);
		DateFormat dtf3 = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
		
		System.out.println(dtf1.format(cl.getTime()));
		System.out.println(dtf2.format(cl.getTime()));
		System.out.println(dtf3.format(cl.getTime()));
		System.out.println(DateFormat.getDateInstance(DateFormat.FULL, Locale.TRADITIONAL_CHINESE).format(cl.getTime()));
		System.out.println(Locale.GERMANY.getDisplayCountry(Locale.GERMAN));
		System.out.println(Locale.ITALY.getDisplayCountry(Locale.GERMAN));
		System.out.println(Locale.ITALY.getDisplayCountry(Locale.ITALY));
		System.out.println(dtf3.format(cl.getTime()));
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.CANADA);
		NumberFormat nfger = NumberFormat.getCurrencyInstance(Locale.GERMANY);
		System.out.println(nf.format(12345.67));
		System.out.println(nfger.format(12345.67));
		
		try{
			NumberFormat nf2 = NumberFormat.getInstance(Locale.UK);
			NumberFormat nf3 = NumberFormat.getCurrencyInstance(Locale.UK);
			nf2.setMaximumFractionDigits(5);
			nf2.setParseIntegerOnly(false);
			
			Number nm = nf2.parse("2345.80");
			System.out.println(nm.doubleValue());
			System.out.println(nf3.format(3455768.504));
		}
		catch(ParseException pe){
			System.out.println(pe.getMessage());
			
		}
	
	}

}
