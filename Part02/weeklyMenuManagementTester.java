/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part02;

import part01.QUBKitchen;
import part01.Resources;

public class weeklyMenuManagementTester {
	public static void main(String[] args) {
		//TC1();
		//TC2();
		//TC3();
		//TC4();
		//TC5();
		//TC6();
		//TC7();
		//TC8();
		//TC9();
		//TC10();
		//TC11();
		TC12();
	}
	public static void TC1() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 1||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: CREATING MENU|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: start: 1 end: 2\nstarter: toast main: toast2: dessert: toast3  ");
		try {
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		QUBKitchen.AddWeeklyMenu();
		for(part01.WeeklyMenu men:Resources.menuexists) {
			if(men.getStart() == 1) {
				System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(),men.getStart(),men.getEnd()));
				System.out.println("TEST PASSED menu outputted");
			}
		}
		}catch(Exception e) {
			System.out.println("TEST FAILED menu not created");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
public static void TC2() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 2||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: CREATING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 1 end: 2\nstarter: toast2 main: toast2: dessert: toast3  ");
	try {
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	QUBKitchen.AddWeeklyMenu();
	for(part01.WeeklyMenu men:Resources.menuexists) {
		if(men.getStart() == 1) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(),men.getStart(),men.getEnd()));
			System.out.println("TEST PASSED menu outputted");
		}
	}
	}catch(Exception e) {
		System.out.println("TEST FAILED menu not created");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC3() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 3||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: CREATING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 511 end: 2\nstarter: toast main: toast2: dessert: toast3  ");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	QUBKitchen.AddWeeklyMenu();
	boolean passed = true;
	for(part01.WeeklyMenu men:Resources.menuexists) {
		System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
		if(men.getStart() <1 || men.getStart() > 52) {
			passed = false;
		}
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC4() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 4||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: DELETING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 2");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	Resources.menuexists = QUBKitchen.deleteMenu(2);
	boolean passed = true;
	for(part01.WeeklyMenu men:Resources.menuexists) {
		System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
		if(men.getStart() == 2) {
			passed = false;
		}
	}
	
	if(passed) {
		System.out.println("TEST PASSED no menu starting at week 2 found");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC5() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 5||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: DELETING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 9");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	Resources.menuexists = QUBKitchen.deleteMenu(9);
	boolean passed = true;
	for(part01.WeeklyMenu men:Resources.menuexists) {
		System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
		if(men.getStart() == 9) {
			passed = false;
		}
	}
	
	if(passed) {
		System.out.println("TEST PASSED menu list unaltered");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC6() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 6||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: DISPLAYING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 2");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = false;
	try {
	for(part01.WeeklyMenu men:Resources.menuexists) {
		if(men.getStart() == 2) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			passed = true;
		}
	}
	}catch(Exception e) {
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC7() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 7||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: DISPLAYING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 25");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = true;
	try {
	for(part01.WeeklyMenu men:Resources.menuexists) {
		if(men.getStart() == 25) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			passed = false;
		}
	}
	}catch(Exception e) {
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC8() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 8||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING  MENU |||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: 1");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = false;
	QUBKitchen.updateMenu();
	try {
	for(part01.WeeklyMenu men:Resources.menuexists) {
		if(men.getStart() == 1) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			passed = true;
		}
	}
	}catch(Exception e) {
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC9() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 9||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING  MENU |||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: -1");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = true;
	QUBKitchen.updateMenu();
	try {
	for(part01.WeeklyMenu men:Resources.menuexists) {
		if(men.getStart() == -1) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			passed = false;
		}
	}
	}catch(Exception e) {
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC10() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 10||||||||||||||||||||||||||||||||");
	System.out.println("|||||||||||||||||||||||||||| TESTING: UPDATING  MENU |||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: dessert: toast3 ---> cake");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = false;
	QUBKitchen.updateMenu();
	try {
	for(part01.WeeklyMenu men:Resources.menuexists) {
		System.out.println(men.getWeeklyMenu().toString());
		if(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()).contains("cake")) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			passed = true;
		}
	}
	}catch(Exception e) {
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC11() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 11||||||||||||||||||||||||||||||||");
	System.out.println("|||||||||||||||||||||||||||| TESTING: UPDATING  MENU |||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: dessert: toast1 ---> toast2");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = false;
	try {
		QUBKitchen.updateMenu();
		passed = true;
	}catch(Exception e) {
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC12() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 6||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: DISPLAYING MENU|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: start: delete recipe toast3 then display menu");
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	boolean passed = false;
	try {
	for(part01.WeeklyMenu men:Resources.menuexists) {
		if(men.getStart() == 2) {
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			QUBKitchen.deleteRecipe("toast3");
			System.out.println(QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd()));
			String menu = QUBKitchen.menToString(men.getWeeklyMenu(), men.getStart(),men.getEnd());
			if(!menu.contains("toast3")) {
				passed = true;
			}
		}
	}
	}catch(Exception e) {
		passed = false;
	}
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}
	
}
