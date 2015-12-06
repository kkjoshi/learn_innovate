package SCJPTest.Examples.HomeAutomation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.*;

public class DVDInfoPathReader extends DVDInfoReader {

	public ArrayList<DVDInfo> populateDVDInfo(String filename){
		
		try{
			Path path = Paths.get(filename);
			if(Files.notExists(path))
				return null;
			//file.createNewFile();
			//FileReader freader =  new FileReader(file);
			BufferedReader buffReader = new BufferedReader(new FileReader(path.toFile()));
			String line;
			ArrayList<DVDInfo> dvdInfoList = new ArrayList<DVDInfo>(); 	
			while((line = buffReader.readLine()) != null)
			{
				String []arr = line.split("/");
				if(arr.length < 3)
					continue;
				DVDInfo dvdinfo = new DVDInfo(arr[0], arr[1], arr[2]);
				dvdInfoList.add(dvdinfo);
			}
			buffReader.close();
			
			return dvdInfoList;
		}catch(IOException ioex){
			
		}
		return null;
		
	}
}
