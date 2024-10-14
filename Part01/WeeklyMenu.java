/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part01;

import java.util.ArrayList;

public class WeeklyMenu {
	private int start;
	private int end;
	private Object[][] weeklyMenu;

	public WeeklyMenu(ArrayList<ArrayList<Object>> menuItems,int start, int end) {
	    setWeeklyMenu(menuItems);
	    setStart(start);
	    setEnd(end);
	}

		public void setStart(int start) {
			this.start = start;
		}
		
		public void setEnd(int end) {
			this.end = end;
		}
		
		public void setWeeklyMenu(ArrayList<ArrayList<Object>> menuItems) {
			this.weeklyMenu = new Object[5][3];
			for (int i = 0; i < menuItems.size(); i++) {
		        ArrayList<Object> menuInner = menuItems.get(i);
		        Day day = (Day) menuInner.get(0);
		        int dayIndex = day.ordinal();
		        for (int j = 1; j < menuInner.size() && j - 1 < 3; j++) {
		            Object menuItem = menuInner.get(j);
		            if (menuItem instanceof part01.Recipe) {
		                weeklyMenu[dayIndex][j - 1] = menuItem;
		            } else {
		                System.out.println("Invalid menu item type at index " + j);
		            }
		        }
		    }
		}
		
		public int getStart() {
			return this.start;
		}
		
		public int getEnd() {
			return this.end;
		}
		
	    public Object[][] getWeeklyMenu() {
	        return weeklyMenu;
	    }
	    
	    

}
