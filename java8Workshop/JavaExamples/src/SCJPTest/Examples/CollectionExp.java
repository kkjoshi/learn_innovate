package SCJPTest.Examples;
import java.util.*;
import SCJPTest.Examples.HomeAutomation.*;

public class CollectionExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//arraylistExp();
		DVDInfoReader reader = new DVDInfoReader();
		//	C:\\dev\\workspace\\JavaExamples\\src\\SCJPTest\Examples\\HomeAutomation\\
		String appdir = System.getProperty("user.dir");
		ArrayList<DVDInfo> dvdInfolist = reader.populateDVDInfo(appdir + "\\dvdinfo.txt");
		Collections.sort(dvdInfolist);
		
		for(DVDInfo info: dvdInfolist){
			System.out.println("Title: " + info.get_title() + " Gender: " + info.get_gender() + " Lead Actor: " + info.get_leadActor());
		}
		
		Collections.sort(dvdInfolist, new LeadActorComparator());
		System.out.println("Lead Actor comparision");
		for(DVDInfo info: dvdInfolist){
			System.out.println("Title: " + info.get_title() + " Gender: " + info.get_gender() + " Lead Actor: " + info.get_leadActor());
		}
		
	}

	private static class LeadActorComparator implements Comparator<DVDInfo>
	{
		public int compare(DVDInfo a, DVDInfo b){
			return a.get_leadActor().compareTo(b.get_leadActor());
		}
	}
	private static void arraylistExp() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Abc");
		al.add("bcd");
		System.out.println(al.size());
		System.out.println(al.contains("abc")); // will return false, default is case sensitive comparision
		
	}

}
