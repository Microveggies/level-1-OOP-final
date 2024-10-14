
/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */package part01;

public enum Day {
	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"),FRIDAY("Friday"),UNASSIGNED("unassigned");
	
	private String Daystring;
	private Day(String day) {
		Daystring = day;
	}
	
	public String toString() {
		return Daystring;
	}
}
