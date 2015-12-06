package SCJPTest.Examples.HomeAutomation;

import java.io.*;
import java.util.ArrayList;

public class DVDInfo implements Comparable<DVDInfo>{

	private String _title;
	private String _gender;
	private String _leadActor;
	DVDInfo(String t, String g, String la){
		_title = t;
		_gender = g;
		_leadActor = la;
	}
	public int compareTo(DVDInfo dvdInfo2){
		return _title.compareTo(dvdInfo2.get_title());
	}
	public String get_title() {
		return _title;
	}
	public String get_gender() {
		return _gender;
	}
	public String get_leadActor() {
		return _leadActor;
	}
	public void set_title(String _title) {
		this._title = _title;
	}
	public void set_gender(String _gender) {
		this._gender = _gender;
	}
	public void set_leadActor(String _leadActor) {
		this._leadActor = _leadActor;
	}
	
}
