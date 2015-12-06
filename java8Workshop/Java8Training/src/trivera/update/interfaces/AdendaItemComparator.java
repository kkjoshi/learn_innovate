package trivera.update.interfaces;
import trivera.update.interfaces.agenda.*;
import java.util.Comparator;

public class AdendaItemComparator implements Comparator<AgendaItem> {
	
	public int compare(AgendaItem t1, AgendaItem t2){
		return t1.getDateTime().compareTo(t2.getDateTime());
	}

}
