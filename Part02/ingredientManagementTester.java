/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part02;

import part01.QUBKitchen;
import part01.Resources;

public class ingredientManagementTester {

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
		System.out.println("||||||||||||||||||||||||||TESTING: CREATING INGREDIENT|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: garlic, fruit & veg, 30");
		try {
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.addIngredient();
		System.out.println(QUBKitchen.listIngredient());
		System.out.println("TEST PASSED ingredient outputted");
		}catch(Exception e) {
			System.out.println("TEST FAILED ingredient not created");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC2() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 2||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: CREATING INGREDIENT|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: garlic, fruit & veg, thirty");
		try {
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.addIngredient();
		System.out.println(QUBKitchen.listIngredient());
		System.out.println("TEST PASSED exception handled and ingredient correctly made");
		}catch(Exception e) {
			System.out.println("TEST FAILED exception not handled");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC3() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 3||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: CREATING INGREDIENT|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: garlic, fruit & veg, -1");
		try {
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.addIngredient();
		System.out.println(QUBKitchen.listIngredient());
		System.out.println("TEST PASSED exception handled and ingredient correctly made");
		}catch(Exception e) {
			System.out.println("TEST FAILED exception not handled");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC4() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 4||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: CREATING INGREDIENT|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: garlic, abcd, 30");
		try {
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.addIngredient();
		System.out.println(QUBKitchen.listIngredient());
		System.out.println("TEST PASSED exception handled and ingredient correctly made");
		}catch(Exception e) {
			System.out.println("TEST FAILED exception not handled");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC5() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 5||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: DISPLAYING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: N/A");
		try {
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		System.out.println(QUBKitchen.listIngredient());
		System.out.println("TEST PASSED Ingredients displayed with no exceptions");
		}catch(Exception e) {
			System.out.println("TEST FAILED exception not handled");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC6() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 6||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: DELETING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: garlic");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		Resources.ingredientexists = QUBKitchen.deleteIngredient("garlic");
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = true;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetName().equals("garlic")) {
				passed = false;
			}
		}
		if(!passed) {
			System.out.println("TEST FAILED garlic still in ingredients");
		}else {
			System.out.println("TEST PASSED garlic removed from ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	public static void TC7() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 7||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: UPDATING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: garlic2");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		QUBKitchen.updateIngredient("garlic", 1, "garlic2");
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = false;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetName().equals("garlic2")) {
				passed = true;
			}
		}
		if(passed) {
			System.out.println("TEST PASSED garlic2 found in ingredients");
		}else {
			System.out.println("TEST FAILED garlic2 not in ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	public static void TC8() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 8||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: UPDATING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: none leave blank");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		QUBKitchen.updateIngredient("garlic", 1, "");
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = true;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetName().equals("")) {
				passed = false;
			}
		}
		if(passed) {
			System.out.println("TEST PASSED null not in ingredients");
		}else {
			System.out.println("TEST FAILED null found in ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	public static void TC9() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 9||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: UPDATING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: dairy");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		QUBKitchen.updateIngredient("garlic", 2, "dairy");
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = false;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetType().equalsIgnoreCase("dairy") && ing.GetName().equals("garlic")) {
				passed = true;
			}
		}
		if(passed) {
			System.out.println("TEST PASSED garlic now dairy in ingredients");
		}else {
			System.out.println("TEST FAILED garlic not dairy in ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	public static void TC10() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 10||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: UPDATING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: abcd");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		QUBKitchen.updateIngredient("garlic", 2, "abcd");
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = true;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetType().equalsIgnoreCase("UNKNOWN") && ing.GetName().equals("garlic")) {
				passed = false;
			}
		}
		if(passed) {
			System.out.println("TEST PASSED garlic not updated in ingredients");
		}else {
			System.out.println("TEST FAILED garlic category null in ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	public static void TC11() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 11||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: UPDATING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: 100");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		QUBKitchen.updateIngredient("garlic", 3, 100);;
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = false;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetCal() == 100 && ing.GetName().equals("garlic")) {
				passed = true;
			}
		}
		if(passed) {
			System.out.println("TEST PASSED garlic calories updated in ingredients");
		}else {
			System.out.println("TEST FAILED garlic calories not updated in ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	public static void TC12() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 12||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||TESTING: UPDATING INGREDIENTS|||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: -1");
		QUBKitchen kit = new QUBKitchen();
		QUBKitchen.initialise();
		QUBKitchen.updateIngredient("garlic", 3, -1);;
		System.out.println(QUBKitchen.listIngredient());
		boolean passed = true;
		for(part01.Ingredient ing: Resources.ingredientexists) {
			if(ing.GetCal() == -1 && ing.GetName().equals("garlic")) {
				passed = false;
			}
		}
		if(passed) {
			System.out.println("TEST PASSED garlic calories updated to valid value in ingredients");
		}else {
			System.out.println("TEST FAILED garlic calories updated to invalid value in ingredients");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	
	}
	
	
	

}
