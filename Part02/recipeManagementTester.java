/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part02;

import java.util.ArrayList;

import part01.QUBKitchen;
import part01.Resources;

public class recipeManagementTester {

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
		//TC12();
		//TC13();
		//TC14();
		//TC15();
		//TC16();
		//TC17();
		TC18();

	}
	
	public static void TC1() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 1||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: CREATING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: \n name: garlic butter\n ingredients: garlic 4 cloves minced\n "
				+ "butter 2 knobs salted\n method: \"add garlic to butter and mix\n course: Starter\n servings: 2\n  ");
		try {
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		QUBKitchen.addRecipe();
		for(part01.Recipe rec:Resources.recipeexists) {
			if(rec.getName().equalsIgnoreCase("garlic butter")) {
				System.out.println(QUBKitchen.listOneRecipe(rec.getName()));
				System.out.println("TEST PASSED recipe outputted");
			}
		}
		}catch(Exception e) {
			System.out.println("TEST FAILED recipe not created");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC2() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 2||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: CREATING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: \n name: garlic butter\n ingredients: garlic -1 cloves minced\n "
				+ "butter two knobs salted\n method: \"add garlic to butter and mix\"\n course: Starter\n servings: 2\n  ");
		try {
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		QUBKitchen.addRecipe();
		for(part01.Recipe rec:Resources.recipeexists) {
			if(rec.getName().equalsIgnoreCase("garlic butter")) {
				System.out.println(QUBKitchen.listOneRecipe(rec.getName()));
				System.out.println("TEST PASSED recipe outputted");
			}
		}
		}catch(Exception e) {
			System.out.println("TEST FAILED");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC3() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 3||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: CREATING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: \n name: garlic butter\n ingredients: garlic 4 cloves minced\n "
				+ "tomato 2 knobs salted\n method: \"add garlic to butter and mix\"\n course: Starter\n servings: 2\n  ");
		try {
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		QUBKitchen.addRecipe();
		for(part01.Recipe rec:Resources.recipeexists) {
			if(rec.getName().equalsIgnoreCase("garlic butter")) {
				System.out.println(QUBKitchen.listOneRecipe(rec.getName()));
				System.out.println("TEST PASSED recipe outputted");
			}
		}
		}catch(Exception e) {
			System.out.println("TEST FAILED");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC4() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 4||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: CREATING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: \n name: garlic butter\n ingredients: garlic 4 cloves minced\n "
				+ "butter 2 knobs salted\n method: add garlic to butter and mix\"\n course: abcd\n servings: 2\n  ");
		try {
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		QUBKitchen.addRecipe();
		for(part01.Recipe rec:Resources.recipeexists) {
			if(rec.getName().equalsIgnoreCase("garlic butter")) {
				System.out.println(QUBKitchen.listOneRecipe(rec.getName()));
				System.out.println("TEST PASSED recipe outputted");
			}
		}
		}catch(Exception e) {
			System.out.println("TEST FAILED");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC5() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 5||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: CREATING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: \n name: garlic butter\n ingredients: garlic *blank* cloves minced\n "
				+ "butter *blank* knobs salted\n method: add garlic to butter and mix\"\n course: Starter\n servings: 2\n  ");
		try {
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		QUBKitchen.addRecipe();
		for(part01.Recipe rec:Resources.recipeexists) {
			if(rec.getName().equalsIgnoreCase("garlic butter")) {
				System.out.println(QUBKitchen.listOneRecipe(rec.getName()));
				System.out.println("TEST PASSED recipe outputted");
			}
		}
		}catch(Exception e) {
			System.out.println("TEST FAILED");
		}
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC6() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 6||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: DELETING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: toast ");
		Boolean passed = true;
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		System.out.println(QUBKitchen.listRecipes());
		System.out.println("DELETING");
		Resources.recipeexists = QUBKitchen.deleteRecipe("toast");
		System.out.println(QUBKitchen.listRecipes());
		for(part01.Recipe rec : Resources.recipeexists) {
			if(rec.getName().equals("toast")) {
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
	
	public static void TC7() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 7||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: DELETING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: pizza ");
		Boolean passed = true;
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		System.out.println(QUBKitchen.listRecipes());
		System.out.println("DELETING");
		try {
			Resources.recipeexists = QUBKitchen.deleteRecipe("pizza");
		}catch(Exception e) {
			passed = false;
		}
		System.out.println(QUBKitchen.listRecipes());
		for(part01.Recipe rec : Resources.recipeexists) {
			if(rec.getName().equals("pizza")) {
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
	
	public static void TC8() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 8||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: LISTING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: toast ");
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		try {
			System.out.println("Listing recipe");
			QUBKitchen.listOneRecipe("toast");
			System.out.println("recipe listed");
			System.out.println("TEST PASSED");
		}catch(Exception e) {
			System.out.println("TEST FAILED");
		}
		
		
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC9() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 9||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: LISTING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: pizza ");
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		try {
			System.out.println("Listing recipe");
			QUBKitchen.listOneRecipe("toast");
			System.out.println("recipe listed");
			System.out.println("TEST PASSED");
		}catch(Exception e) {
			System.out.println("TEST FAILED");
		}
		
		
		System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
	}
	
	public static void TC10() {
		System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 10||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
		System.out.println("TEST DATA TO BE INPUT: toast ---> baked bread ");
		Boolean passed = false;
		QUBKitchen kit = new QUBKitchen();
		kit.initialise();
		System.out.println("Listing recipe");
		System.out.println(QUBKitchen.listRecipes());
		QUBKitchen.updateRecipe();
		System.out.println("Listing updated recipes");
		System.out.println(QUBKitchen.listRecipes());
		for(part01.Recipe rec : Resources.recipeexists) {
			if(rec.getName().equalsIgnoreCase("baked bread")) {
				passed = true;
			}
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
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast --->  *blank* ");
	Boolean passed = true;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipes");
	System.out.println(QUBKitchen.listRecipes());
	for(part01.Recipe rec : Resources.recipeexists) {
		if(rec.getName().equalsIgnoreCase("")) {
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

public static void TC12() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 12||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast 4 cloves garlic --> toast 400g garlic ");
	Boolean passed = false;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipe");
	System.out.println(QUBKitchen.listOneRecipe("toast"));
	for(part01.Recipe rec : Resources.recipeexists) {
		ArrayList<ArrayList<Object>> ing = rec.getLiteralIngredients();
		if(ing.get(0).get(1) == (Integer) 400); {
			passed = true;
		}
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	

	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC13() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 13||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast 4 cloves garlic --> toast four cloves garlic ");
	Boolean passed = true;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipe");
	System.out.println(QUBKitchen.listOneRecipe("toast"));
	try {
		for(part01.Recipe rec : Resources.recipeexists) {
		ArrayList<ArrayList<Object>> ing = rec.getLiteralIngredients();
		if(ing.get(0).get(1).equals("four")){
			passed = false;
		}
		}
	}catch(Exception e) {
		System.out.println("EXCEPTION CAUGHT");
		passed = false;
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	

	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC14() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 14||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast 4 cloves garlic --> toast -4 cloves garlic ");
	Boolean passed = true;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipe");
	System.out.println(QUBKitchen.listOneRecipe("toast"));
	for(part01.Recipe rec : Resources.recipeexists) {
		ArrayList<ArrayList<Object>> ing = rec.getLiteralIngredients();
		if((Integer) ing.get(0).get(1) < (Integer) 0) {
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

public static void TC15() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 15||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast 4 cloves garlic --> toast 4 cloves tomato ");
	Boolean passed = true;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	try {
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipe");
	System.out.println(QUBKitchen.listOneRecipe("toast"));
	}catch(Exception e) {
		passed = false;
	}
	for(part01.Recipe rec : Resources.recipeexists) {
		if(rec.getIngredients().contains("Incomplete ingredient entry")) {
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

public static void TC16() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 16||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast Starter --> toast Main Course ");
	Boolean passed = false;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipe");
	System.out.println(QUBKitchen.listOneRecipe("toast"));
	for(part01.Recipe rec : Resources.recipeexists) {
		if(rec.getType().equalsIgnoreCase("Main Course")&& rec.getName().equals("toast")) {
			passed = true;
		}
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}

	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}

public static void TC17() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 17||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING: UPDATING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: toast Starter --> toast Main Course ");
	Boolean passed = true;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listRecipes());
	try {
	QUBKitchen.updateRecipe();
	System.out.println("Listing updated recipe");
	System.out.println(QUBKitchen.listOneRecipe("toast"));
	}catch(Exception e) {
		passed = false;
	}
	for(part01.Recipe rec : Resources.recipeexists) {
		if(rec.getType().equalsIgnoreCase(null)&& rec.getName().equals("toast")) {
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

public static void TC18() {
	System.out.println("|||||||||||||||||||||||||||||||||||TEST  CASE 18||||||||||||||||||||||||||||||||");
	System.out.println("||||||||||||||||||||||||||||TESTING:DISPLAYING RECIPE|||||||||||||||||||||||||||");
	System.out.println("TEST DATA TO BE INPUT: delete bread ingredient then display cake");
	Boolean passed = false;
	QUBKitchen kit = new QUBKitchen();
	kit.initialise();
	System.out.println("Listing recipe");
	System.out.println(QUBKitchen.listOneRecipe("cake"));
	try {
		Resources.ingredientexists = QUBKitchen.deleteIngredient("bread");
		System.out.println("bread deleted re displaying cake");
		System.out.println(QUBKitchen.listOneRecipe("cake"));
	}catch(Exception e) {
		passed = false;
	}
	for(part01.Recipe rec : Resources.recipeexists) {
		if(rec.getIngredients().contains("Incomplete ingredient entry")) {
			passed = true;
		}
	}
	
	if(passed) {
		System.out.println("TEST PASSED");
	}else {
		System.out.println("TEST FAILED");
	}
	System.out.println("||||||||||||||||||||||||||||||||||END TEST CASE|||||||||||||||||||||||||||||||||");
}
}

