/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class QUBKitchen {
////////////////////////////////////////////////////////Menus///////////////////////////////////////////////////////////////////
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		/**
		 * initialises the starting data into the system to be used
		 */
		initialise();
		/**
		 * Creates new menu titled "QUB Kitchen" and populates its choices with the values in Resources.mainOptions and prompts
		 * the user for input so long as quit is not true.
		 */
		Menu mainMenu = new Menu("QUB Kitchen", Resources.mainOptions);
		int choice = 0;
		boolean quit = false;
		do {
			choice = mainMenu.getUserChoice();
			quit = processChoice(choice);
		} while (!quit);

		System.out.println("All done - Goodbye!");
	}

	private static boolean processChoice(int choice) {
		/**
		 * Assigns the functions creating the component managers to the values of the main menu stored in Resources.menuOptions
		 */
		boolean quit = false;
		switch (choice) {
		case 1:
			manageIngredients();
			break;
		case 2:
			manageRecipes();
			break;
		case 3:
			manageWeeklyMenu();
			break;
		case 4:
			quit = true;
		}
		return quit;
	}

	private static void manageIngredients() {
		/**
		 * Creates a new instance of the menu class using Resources.ingredientOptions as the options to select and uses a switch
		 * case to get inputs necessary to pass into the function to complete the action associated.
		 */
		Menu ingredientmanager = new Menu("Ingredient Manager",Resources.ingredientOptions);
		int choice = ingredientmanager.getUserChoice();
		switch (choice) {
		case 1:
			addIngredient();
			break;
		case 2:
			//gets name of ingredient delete passing into the deleteIngredient function
			System.out.println("enter ingredient to delete: ");
			String answer = input.nextLine();
			/**sets the ingredientexists ArrayList to the value returned by deleteIngredient which will be a new copy of the
			 * ArrayList without the deleted ingredient
			 */
			Resources.ingredientexists = deleteIngredient(answer);
			break;
		case 3:
			//collects an ingredient and the value to be updated in the array
			System.out.println("enter ingredient: ");
			String ing = input.nextLine();
			System.out.println("1.update name\n2.update category\n3.update calories\n");
			int updateChoice = input.nextInt();
			//clears the scanner of inputs
			input.nextLine();
			/**ensures the choices are between the values listed by the system the first if collects a string value and the else
			 * if uses method overloading to run another version of the updateIngredient method taking an integer instead of a 
			 * String to update calories
			 */
			if(updateChoice >0 && updateChoice<3) {
				//collecting new string to be passed into the method
				System.out.println("enter new value: ");
				String updated = input.nextLine();
				updateIngredient(ing,updateChoice,updated);
			}else if(updateChoice == 3) {
				//collecting new string to be passed into the method
				System.out.println("enter new value: ");
				int updated = input.nextInt();
				//clearing the scanner
				input.nextLine();
				updateIngredient(ing,updateChoice,updated);
			}else {
				//returning feedback for invalid answers to the end user
				System.out.println("invalid answer");
			}
			
		case 4:
			/**calls the sort the sort algorithm to sort the ingredientexists list alphabetically before displaying the ingredients
			 * using the list ingredient method which returns the ingredients as strings
			 */
			sortIngredientsAlphabetically();
			String display = listIngredient();
			System.out.println(display);
			break;
		case 5:
			searchIngredient();
			break;
		case 6:
			//returns to the top-level menu
			break;	
		
		}
	}
	
	private static void manageRecipes() {
		/**
		 * creates new instance of the menu class using the Resources.recipeOptions ArrayList to populate the choices on the menu 
		 * and prompts the user to give input to be used in the switch statement
		 */
		Menu RecipeManager = new Menu("Recipe Manager", Resources.recipeOptions);
		int choice = RecipeManager.getUserChoice();
		switch(choice) {
		case 1:
			addRecipe();
			break;
		case 2:
			/**
			 * intakes a name for a recipe and passes it into the deleteRecipe function, this function overwrites the 
			 * Resources.recipeexists with the same list minus the recipe passed in if it exists.
			 */
			System.out.println("enter recipe to delete: ");
			String answer = input.nextLine();
			Resources.recipeexists = deleteRecipe(answer);
			break;
		case 3:
			/**
			 * Sorts recipeexists ArrayList alphabetically desplaying each recipes name then calls the update function which
			 * will prompt the user for a value on that list to update.
			 */
			sortRecipesAlphabetically();
			String displayupdates = listRecipes();
			System.out.println(displayupdates);
			updateRecipe();
			break;
		case 4:
			/**
			 * similar to above displays recipe names alphabetically in order then takes in a recipe name and displays all details
			 * of the recipe named
			 */
			sortRecipesAlphabetically();
			String display = listRecipes();
			System.out.println(display);
			System.out.println("enter recipe to show: ");
			String name = input.nextLine();
			StringBuilder recipe = listOneRecipe(name);
			System.out.println(recipe);
			break;
		case 5:
			searchRecipe();
			break;
		case 6:
			break;
		}
		
		
		
	}

	private static void manageWeeklyMenu() {
		/**creates new instance of the menu class using Resources.MenuOptions to populate the choices prompting input to feed
		 * into the switch case
		 */
		Menu Menumanager = new Menu("Menu Manager",Resources.MenuOptions);
		int choice = Menumanager.getUserChoice();
		switch (choice) {
		case 1:
			//call the addWeeklyMenu method to create a new menu
			AddWeeklyMenu();
	        break;
	    
		case 2:
			/**asks for the beginning date for a menu to feed into the delete function the updates menuexists to be a copy 
			 * without the menu entered.
			 */
			System.out.println("Enter week of Menu to remove:");
			int MenToDel = input.nextInt();
			input.nextLine();
			Resources.menuexists = deleteMenu(MenToDel);
			break;
		case 3:
			//calls the update menu function to edit a section of the menu
			updateMenu();
			break;
		case 4:
			/**
			 * takes in a starting week the compares this week to the menus in menuexists and if a match is found it displays
			 * the full menu
			 */
			System.out.println("Enter Starting week");
			int weekStart = input.nextInt();
			input.nextLine();
			for(WeeklyMenu menu : Resources.menuexists) {
				if(menu.getStart() == weekStart) {
					System.out.println("Weekly Menu added:\n" + menToString(menu.getWeeklyMenu(), menu.getStart(), menu.getEnd()));
				}
			}
			break;
		}
	}
//////////////////////////////////////////////////////Ingredients////////////////////////////////////////////////////////////////
	public static void addIngredient() {
		/**gets inputs for the necessary to create an instance of the ingredient class passing them into the designated 
		 * function
		 */
		System.out.println("enter name: ");
		String ingname = input.nextLine();
		System.out.println("enter category: ");
		String cat = input.nextLine();
		while(cat == null){
			System.out.println("Invalid Entry ");
			System.out.println("enter category: ");
			cat = input.nextLine();
		}
		System.out.println("enter calories per 100g: ");
		int cal = input.nextInt();
		while(cal < 0 || cal > 500) {
			System.out.println("Invalid Entry ");
			System.out.println("enter calories per 100g: ");
			cal = input.nextInt();
		}
		//uses input.nextLine() to clear the scanner 
		input.nextLine();
		//creates ingredient using the fields collected and adds it to ingredientexists
		Ingredient ing = new Ingredient(ingname,cat,cal);
		Resources.ingredientexists.add(ing);
		}
	public static Ingredient addIngredient(String name, Category category, int cal) {
		/**
		 * params: name - ingredient name, category = ingredient food group, cal = calories per 100g
		 */
		//an alternate version of the above !!!ONLY FOR INITIALISING NOT USED ANYWHERE ELSE!!!
		Ingredient ing = new Ingredient(name,category,cal);
		Resources.ingredientexists.add(ing);
		return ing;
		}
	public static String listIngredient() {
	//creates an empty string and then loops through the ingredientexists list adding the details of the ingredient to string
		String ingredientlist = "";
		for(int i = 0; i <= Resources.ingredientexists.size()-1; i++) {
			ingredientlist= ingredientlist +"name: " + Resources.ingredientexists.get(i).GetName()+ " category: " + Resources.ingredientexists.get(i).GetType()+ " calories(per 100g): " + Resources.ingredientexists.get(i).GetCal() + "\n";
		}
		return ingredientlist;
	}
	public static ArrayList<Ingredient> deleteIngredient(String ing) {
		/**
		 * params: ing = ingredient to be deleted
		 */
		//Deletes an ingredient by copying all values except the value to be deleted into a new list and overwriting the previous
	    ArrayList<Ingredient> newingredients = new ArrayList<>();
	    for (Ingredient ingredient : Resources.ingredientexists) {
	        if (!ingredient.GetName().equals(ing)) {
	            newingredients.add(ingredient);
	        }
	    }
	    return newingredients;
	}
	public static void sortIngredientsAlphabetically() {
        int num = Resources.ingredientexists.size();
        //performs a bubble sort in items in the ingredientexists to sort it into alphabetical order
        for (int i = 0; i < num - 1; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                Ingredient ing1 = Resources.ingredientexists.get(j);
                Ingredient ing2 = Resources.ingredientexists.get(j + 1);
                //compares ingredient to the one after it and swaps if they are out of order
                if (ing1.GetName().compareTo(ing2.GetName()) > 0) {
                	Resources.ingredientexists.set(j, ing2);
                	Resources.ingredientexists.set(j + 1, ing1);
                }
            }
        }
 }
    public static void updateIngredient(String name ,int selection, String updated) {
    	/**
    	 * params: name = ingredient to be updated, selection = the choice made for component to update, updated = new value for the field
    	 */
    	//updates either name or category depending on response to the question checks if the ingredient named exists then updates
    	switch(selection) {
    	case 1:
        	for(Ingredient ingredient : Resources.ingredientexists) {
        		if(ingredient.GetName().equals(name)) {
        			ingredient.SetName(updated);
        		}
        	}
        	break;
    	case 2:
    		for(Ingredient ingredient : Resources.ingredientexists) {
        		if(ingredient.GetName().equals(name)) {
        			ingredient.SetType(updated);
        		}
        	}
        	break;	
    	}
    }
    public static void updateIngredient(String name ,int selection, int updated) {
    	/**
    	 * params: name = ingredient to be updated, selection = the choice made for component to update, updated = new value for the field
    	 */
    	//an alternate version of the above taking in an integer update value to edit the calories
        	for(Ingredient ingredient : Resources.ingredientexists) {
        		if(ingredient.GetName().equals(name)) {
        			while((updated < 0 || updated > 500)) {
        				System.out.println("Invalid Entry try again:");
        				updated = input.nextInt();
        				input.nextLine();
        			}
        				
        			ingredient.SetCal(updated);
        		}
        	}
    	
    }
    public static void searchIngredient() {
    	//gets integer input to be used in the switch statement to search by the chosen category
    	System.out.println("1.By ID\n2.By name\n3.By category");
    	int searchChoice = input.nextInt();
    	//clears the scanner
    	input.nextLine();
    	switch(searchChoice) {
    	case 1:
    		System.out.println("enter ID: ");
    		int searchID = input.nextInt();
    		//clears the scanner
        	input.nextLine();
        	//iterates through ingredientexists checking of the ingredients criteria match the search criteria
        	for(Ingredient ingredient : Resources.ingredientexists){
        		if(ingredient.GetID() == searchID) {
        			//if is a successful search outputs ingredient details
        			System.out.println(ingredient.toString());
        		}
        	}
        	break;
    	case 2:
    		System.out.println("enter name: ");
    		String searchName = input.nextLine();
    		input.nextLine();
        	//iterates through ingredientexists checking of the ingredients criteria match the search criteria
    		for(Ingredient ingredient : Resources.ingredientexists){
        		if(ingredient.GetName().equalsIgnoreCase(searchName)) {
        			//if is a successful search outputs ingredient details
        			System.out.println(ingredient.toString());
        		}
        	}
    		break;
    	case 3:
    		System.out.println("enter category: ");
    		String searchCat = input.nextLine();
    		input.nextLine();
        	//iterates through ingredientexists checking of the ingredients criteria match the search criteria
    		for(Ingredient ingredient : Resources.ingredientexists){
        		if(ingredient.GetType().equalsIgnoreCase(searchCat)) {
        			//if is a successful search outputs ingredient details
        			System.out.println(ingredient.toString());
        		}
        	}
    		break;
    	default:
    		//if user inouts an integer out of range prompts an invalid message
    		System.out.println("Invalid entry");
    		break;
    	}
    }
////////////////////////////////////////////////////////Recipes///////////////////////////////////////////////////////////////// 
    public static void addRecipe() {
	 boolean valid = true;
	 boolean ingredientfound = false;
	 while(valid) {
		 ingredientfound = false;
	//creates a 2-dimensional ArrayList to store a series of ingredients
		ArrayList<ArrayList<Object>> ingredients = new ArrayList<>();
		//gets inputs for name and a number of ingredients to loop inputs for
		System.out.println("name of recipe: ");
		String recipeName = input.nextLine();
		while(recipeName.equals(null)||recipeName.equals("")) {
			System.out.println("invalid, please enter new value");
			recipeName = input.nextLine();
		}
		System.out.println("how many ingredients?: ");
		int quantity = input.nextInt();
		//clearing scanner of input
		input.nextLine();
		//loops creating the ArrayList to be stored in ingredients for each ingredient input in the quantity value
		for(int i =0; i <= quantity-1; i++) {
			//Creates an ArrayList of type Object as it stores a series of classes to be added into ingredients 
			ArrayList<Object> ingredientinner = new ArrayList<>();
			//collects ingredient name
			System.out.println("name of ingredient: ");
			String ingredientName = input.nextLine();
			//validates the ingredient named exists and if it does it will be added into the ArrayList ingredientinner
			for (Ingredient ingredient : Resources.ingredientexists) {
		        if (ingredient.GetName().equals(ingredientName)) {
		            ingredientinner.add(ingredient);
		            ingredientfound = true;
		        }
		        
			}
			if(!ingredientfound) {
				System.out.println("no such ingredient found");
				ingredientfound = false;
				break;
			}
			//collects the quantity of ingredient wrapped as Integer allowing it to be stored in an ArrayList
			System.out.println("enter quantity in grams");
			Integer amount = input.nextInt();
			while(amount < 0) {
				System.out.println("invalid");
				amount = input.nextInt();
			}
			//clears scanner of inputs
			input.nextLine();
			ingredientinner.add(amount);
			//collects a value for unit of measurement as sample data showed values such as cloves of garlic rather than grams
			System.out.println("unit: ");
			String unit = input.nextLine();
			ingredientinner.add(unit);
			/**allows a preparation to be input so that mashed potatoes and cubed potatoes do not have to be seperate instances
			 * of the ingredient class allowing ingredients to be more reusable 
			 */
			System.out.println("Enter preparation: ");
			String prep = input.nextLine();
			ingredientinner.add(prep);
			/**adds the created ArrayList into the main ingredients ArrayList as a completed ingredient then loops up to the number
			 * of ingredients for the recipe
			 */
			ingredients.add(ingredientinner);
	}
		/**
		 *asks for user input to create an instance of the RecipeType enum for the course the recipe is. 
		 */
		if(!ingredientfound) {
			System.out.println("no such ingredient found");
			valid = false;
			break;
		}
		System.out.println("enter type(Starter,Main Course,Dessert): ");
		String type = input.nextLine();
		//creates an empty string to store the steps of the recipe and collects how many steps there are to iterate through
		String method = "";
		System.out.println("how many steps?: ");
		int steps = input.nextInt();
		//clears scanner
		input.nextLine();
		/**
		 * Loops through asking for the recipe steps up to the number of times the user input when prompted adding them to
		 * the method string in the format:
		 * 1. x
		 * 2. y
		 */
		for(int i =0; i <= steps-1; i++) {
			System.out.println("enter step: ");
			method = method +i+1+". "+ input.nextLine()+ "\n";
		}
		System.out.println("How many servings?: ");
		int portions = input.nextInt();
		//clears scanner and passes collected values into the method to create a recipe.
		input.nextLine();
	 Recipe Rec = new Recipe(recipeName,ingredients,type,method,portions);
    	Resources.recipeexists.add(Rec);
    	valid = false;
	 }
    }
public static ArrayList<Recipe> deleteRecipe(String rec) {
	/**
	 * params: rec = name of recipe to delete
	 */
	//Deletes recipe by copying all values except the value to be deleted into a new list and overwriting the previous
	    ArrayList<Recipe> newrecipe = new ArrayList<>();
	    for (Recipe recipe : Resources.recipeexists) {
	        if (!recipe.getName().equals(rec)) {
	            newrecipe.add(recipe);
	        }
	    }
	    return newrecipe;
	}
public static void sortRecipesAlphabetically() {
	//performs a bubble sort in items in the recipeexists to sort it into alphabetical order
        int n = Resources.recipeexists.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Recipe rec1 = Resources.recipeexists.get(j);
                Recipe rec2 = Resources.recipeexists.get(j + 1);
              //compares ingredient to the one after it and swaps if they are out of order
                if (rec1.getName().compareTo(rec2.getName()) > 0) {
                	Resources.recipeexists.set(j, rec2);
                	Resources.recipeexists.set(j + 1, rec1);
                	}
                }
            }
        }
public static StringBuilder listOneRecipe(String name) {
	/**
	 * name of recipe to have details displayed
	 */
	//makes use of the string builder class to easily append many details into a string adding all details of a recipe to be displayed
	StringBuilder recipedetails = new StringBuilder();
	for(Recipe recipe : Resources.recipeexists) {
		if(recipe.getName().equals(name)) {
			recipedetails.append(recipe.getName()+"\n").append(recipe.getIngredients()+"\n").append("course: " + recipe.getType() + "\n").append(recipe.getmethod() + "\n").append("servings: " +Integer.toString(recipe.getPortions())+ "\n").append("total calories:" + recipe.getfullcal());
		}
	}
	return recipedetails;
}
public static String listRecipes() {
	//outputs a list of the names of all recipes by iterating through recipeexists calling the getName method
	String recipelist = "";
	for(int i = 0; i <= Resources.recipeexists.size()-1; i++) {
		recipelist= recipelist +"name: " + Resources.recipeexists.get(i).getName()+ "\n";
	}
	return recipelist;
}
public static void updateRecipe() {
	//gets an input of recipe name to be edited
	System.out.println("enter recipe to edit");
	String editchoice = input.nextLine();
	//loops through existing recipes comparing their name to the name of the recipe entered to see if its valid
	for(int i = 0; i <= Resources.recipeexists.size()-1;i++) {
		if(Resources.recipeexists.get(i).getName().equals(editchoice)) {
			//list outs editing options taking in the integer response to a switch case to update the corresponding function
			System.out.println("1. Update Name\n2. Update Ingredients\n3.Update Method\n4. Update Portions\n5. Update type");
			int editedfeature = input.nextInt();
			input.nextLine();
			switch(editedfeature) {
			case 1:
				//takes in a string and feeds it into the setName method to update the recipe
				System.out.println("enter new value");
				String newval = input.nextLine();
				while(newval.equals(null)|| newval.equals("")) {
					System.out.println("invalid, please enter new value");
					newval = input.nextLine();
				}
				Resources.recipeexists.get(i).setName(newval);
				break;
			case 2:
				//creates a new ingredients set prompting the user to reenter the ingredients list to the new values
				ArrayList<ArrayList<Object>> ingredients = new ArrayList<>();
				System.out.println("how many ingredients?: ");
				int quantity = input.nextInt();
				input.nextLine();
				//creates the inner array list storing each ingredients detail j times j being the number of ingredients quantity
				for(int j =0; j <= quantity-1; j++) {
					ArrayList<Object> ingredientinner = new ArrayList<>();
					System.out.println("name of ingredient: ");
					String ingredientName = input.nextLine();
					for (Ingredient ingredient : Resources.ingredientexists) {
				        if (ingredient.GetName().equals(ingredientName)) {
				            ingredientinner.add(ingredient);
				        }
					}
					// asks user for quantity asking it to be reentered if it is not a valid amount
					System.out.println("enter quantity in grams");
					Integer amount = input.nextInt();
					input.nextLine();
					while(amount < 0) {
						System.out.println("invalid try again: ");
						amount = input.nextInt();
						input.nextLine();
					}
					ingredientinner.add(amount);
					System.out.println("unit: ");
					String unit = input.nextLine();
					ingredientinner.add(unit);
					System.out.println("Enter preparation: ");
					String prep = input.nextLine();
					ingredientinner.add(prep);
					ingredients.add(ingredientinner);
				}
				Resources.recipeexists.get(i).setIngredient(ingredients);
				break;
			case 3:
				
				String method = "";
				System.out.println("how many steps?: ");
				int steps = input.nextInt();
				input.nextLine();
				for(int k =0; k <= steps-1; k++) {
					System.out.println("enter step: ");
					method = method +(k+1)+". "+ input.nextLine()+ "\n";
				}
				Resources.recipeexists.get(i).setMethod(method);
				break;
			case 4:
				System.out.println("How many servings?: ");
				int portions = input.nextInt();
				input.nextLine();
				Resources.recipeexists.get(i).setPortions(portions);
				break;
			case 5:
				System.out.println("new type: ");
				String type = input.nextLine();
				Resources.recipeexists.get(i).setType(type);
				break;
			}
		}
	}
}
public static Recipe getValidRecipe(Scanner input, String courseType) {
	/**
	 * params: input = scanner to allow input to be gathered in the method, courseType = The course type to compare the recipe to
	 * 
	 * uses the scanner to read in a recipe entered by end user and checks if it matches the coursetype passed in 
	 * if it does not match then it will prompt the user again and if it does it will return the inputted recipe.
	 */
	
    Recipe recipeInput;
    do {
        System.out.println("Enter " + courseType);
        String recipeName = input.nextLine().toLowerCase();
        recipeInput = findRecipe(recipeName, courseType);
        if (recipeInput == null) {
            System.out.println("Invalid " + courseType + ". Please try again.");
        }
    } while (recipeInput == null);
    return recipeInput;
}
public static Recipe findRecipe(String recipeName, String courseType) {
	/**
	 * params: recipeName = name of recipe to find, courseType = the course you are checking it is e.g. starter
	 * checks to see if there is a matching recipe in the existing recipes that shares a name and coursetype with that input.
	 */
    for (Recipe recipe : Resources.recipeexists) {
        if (recipe.getName().toLowerCase().equals(recipeName) && recipe.getType().equals(courseType)) {
            return recipe;
        }
    }
    return null;
}
public static void searchRecipe() {
	/**
	 * takes in an integer value to decide search criteria the when in the correct case it will search the existing recipes to see if
	 * a recipe in the list matches the criteria outputting it.
	 */
	System.out.println("1.By ID\n2.By name\n3.By course");
	int searchChoice = input.nextInt();
	input.nextLine();
	switch(searchChoice) {
	case 1:
		System.out.println("enter ID: ");
		int searchID = input.nextInt();
    	input.nextLine();
    	for(Recipe rec : Resources.recipeexists){
    		if(rec.getID() == searchID) {
    			System.out.println(listOneRecipe(rec.getName()));
    		}
    	}
    	break;
	case 2:
		System.out.println("enter name: ");
		String searchName = input.nextLine();
		for(Recipe rec : Resources.recipeexists){
    		if(rec.getName().equalsIgnoreCase(searchName)) {
    			System.out.println(listOneRecipe(rec.getName()));
    		}
    	}
		break;
	case 3:
		System.out.println("enter course: ");
		String searchCat = input.nextLine();
		for(Recipe rec : Resources.recipeexists){
    		if(rec.getType().equalsIgnoreCase(searchCat)) {
    			System.out.println(listOneRecipe(rec.getName()));
    		}
    	}
		break;
	default:
		System.out.println("Invalid entry");
		break;
	}
}
/////////////////////////////////////////////////////Weekly Menu///////////////////////////////////////////////////////////////////
public static String menToString(Object[][] weeklyMenu, int weekstart, int weekend) {
	/**
	 * Params: weeklyMenu = 2D array of objects storing the menu column zero has the days then each column holds a course
	 * Takes in values of a weekly menu as parameters and formats them for a digestible output for the end user to read
	 */
    StringBuilder sb = new StringBuilder();
    sb.append(weekstart + " - " + weekend +"\n");
    for (int i = 0; i < weeklyMenu.length; i++) {
        sb.append("Day: ").append(Day.values()[i]).append("\n");
        for (int j = 0; j < weeklyMenu[i].length; j++) {
            sb.append("  ").append(weeklyMenu[i][j]).append("\n");
        }
    }
    return sb.toString();
}
public static ArrayList<WeeklyMenu> deleteMenu(int start) {
	/**
	 * params: start = starting week of the menu to be deleted
	 * Iterates through the menu array copying all menus that do not share a start date with that entered into the function effectively 
	 * removing it from the array
	 */
    ArrayList<WeeklyMenu> newrecipe = new ArrayList<>();
    for (WeeklyMenu menu : Resources.menuexists) {
        if (menu.getStart() != start) {
            newrecipe.add(menu);
        }
    }
    return newrecipe;
}
public static void updateMenu() {
	/**
	 * prompts user to enter an integer value used to decide the value being updated then within the  updating case uses the weekly menu setter methods
	 * to update the values  
	 */
	System.out.println("Enter starting week of the menu to edit: ");
	int mentoedit = input.nextInt();
	input.nextLine();
	for(WeeklyMenu menu : Resources.menuexists) {
		if(menu.getStart() == mentoedit) {
			System.out.println("1. update start week\n2. update ending week\n3. update menu content");
			int updatechoice = input.nextInt();
			input.nextLine();
			switch(updatechoice) {
			case 1:
				System.out.println("enter new start week:");
				int newstart = input.nextInt();
				input.nextLine();
				menu.setStart(newstart);
				break;
			case 2:
				System.out.println("enter new end week:");
				int newend = input.nextInt();
				input.nextLine();
				menu.setEnd(newend);
				break;
			case 3:
				ArrayList<ArrayList<Object>> MenuOuter = new ArrayList<>();
				for (int i = 0; i < 5; i++) { // Assuming 5 days in a week
		            ArrayList<Object> MenuInner = new ArrayList<>();
		            Day day = Day.values()[i];
		            MenuInner.add(day);

		            Recipe starter = getValidRecipe(input, "Starter");
		            MenuInner.add(starter);

		            Recipe mainCourse = getValidRecipe(input, "Main Course");
		            MenuInner.add(mainCourse);

		            Recipe dessert = getValidRecipe(input, "Dessert");
		            MenuInner.add(dessert);

		            MenuOuter.add(MenuInner);
		        }
				menu.setWeeklyMenu(MenuOuter);
				break;
			}
		}
	}
}
public static void AddWeeklyMenu() {
	/**
	 * prompts the user to enter a start and end week then iterates 5 times times asking for three courses validating the follow
	 * the starter main dessert pattern and a day is assigned in according to the value of i e.g. i =0 means monday
	 */
	System.out.println("Enter starting week (e.g. week 1)");
	int start = input.nextInt();
	input.nextLine();
	System.out.println("Enter end week");
	int end = input.nextInt();
	input.nextLine();
    ArrayList<ArrayList<Object>> MenuOuter = new ArrayList<>();
    for (int i = 0; i < 5; i++) { // Assuming 5 days in a week
        ArrayList<Object> MenuInner = new ArrayList<>();
        Day day = Day.values()[i];
        MenuInner.add(day);

        Recipe starter = getValidRecipe(input, "Starter");
        MenuInner.add(starter);

        Recipe mainCourse = getValidRecipe(input, "Main Course");
        MenuInner.add(mainCourse);

        Recipe dessert = getValidRecipe(input, "Dessert");
        MenuInner.add(dessert);

        MenuOuter.add(MenuInner);
    }

    WeeklyMenu men = new WeeklyMenu(MenuOuter,start,end);
    Resources.menuexists.add(men);
}
//////////////////////////////////////////////////////Other/////////////////////////////////////////////////////////////////////
public static void initialise() {
	Ingredient ing1 = addIngredient("garlic", Category.FRUITVEG, 111);
	Ingredient ing2 = addIngredient("butter", Category.DAIRY, 717);
	Ingredient ing3 = addIngredient("White Bread", Category.COMPOSITE, 265);
	Ingredient ing4 = addIngredient("Apples", Category.FRUITVEG, 52);
	Ingredient ing5 = addIngredient("milk", Category.DAIRY, 42);
	Ingredient ing6 = addIngredient("Baked Beans", Category.COMPOSITE,155);
	Ingredient ing7 = addIngredient("Bell Peppers", Category.FRUITVEG,20);
	Ingredient ing8 = addIngredient("Celery", Category.FRUITVEG,8);
	Ingredient ing9 = addIngredient("Cheese",Category.DAIRY,402);
	Ingredient ing10 = addIngredient("Eggs", Category.DAIRY, 155);
	Ingredient ing11 = addIngredient("Flour", Category.CEREAL, 364);
	Ingredient ing12 = addIngredient("Ground Beef",Category.PROTEIN,332);
	Ingredient ing13 = addIngredient("Jam", Category.SUGAR,278);
	Ingredient ing14 = addIngredient("Leeks",Category.FRUITVEG,62);
	Ingredient ing15 = addIngredient("Lettuce",Category.FRUITVEG,15);
	Ingredient ing16 = addIngredient("Olive Oil", Category.FAT, 884);
	Ingredient ing17 = addIngredient("Onions", Category.FRUITVEG,40);
	Ingredient ing18 = addIngredient("Penne Pasta", Category.COMPOSITE,118);
	Ingredient ing19 = addIngredient("Pepper",Category.SPICEHERB,20);
	Ingredient ing20 = addIngredient("Potatoes", Category.FRUITVEG,75);
	Ingredient ing21 = addIngredient("Salt", Category.ESSENTIALNUT, 0);
	Ingredient ing22 = addIngredient("Stock Cubes", Category.COMPOSITE,438);
	Ingredient ing23 = addIngredient("Sugar", Category.SUGAR,387);
	Ingredient ing24 = addIngredient("Tomatoes", Category.FRUITVEG, 19);
	Ingredient ing25 = addIngredient("Water", Category.ESSENTIALNUT,0);
	
	ArrayList<Object> in1 = new ArrayList<>();
	ArrayList<ArrayList<Object>> intot = new ArrayList<>();
	
	in1.add(ing3);
	in1.add(1);
	in1.add("slice");
	in1.add("freshly sliced crust on");
	ArrayList<Object> in2 = new ArrayList<>();
	in2.add(ing2);
	in2.add(1);
	in2.add("knob");
	in2.add("soft at room temperature");
	intot.add(in1);
	intot.add(in2);
	Recipe rec1 = new Recipe("toast", intot, "Starter", "1. Toast bread\n2. spread on butter and enjoy\n",1);
	Resources.recipeexists.add(rec1);
	Recipe rec2 = new Recipe("toast2", intot, "Main Course", "1. Toast bread\n2. spread on butter and enjoy\n",1);
	Resources.recipeexists.add(rec2);
	Recipe rec3 = new Recipe("toast3", intot, "Dessert", "1. Toast bread\n2. spread on butter and enjoy\n",1);
	Resources.recipeexists.add(rec3);
	Recipe rec4 = new Recipe("cake", intot, "Dessert", "1. Toast bread\n2. spread on butter and enjoy\n",1);
	Resources.recipeexists.add(rec4);
	
	ArrayList<Object> meninner = new ArrayList<>();
	ArrayList<ArrayList<Object>> mentot = new ArrayList<>();
	meninner.add(Day.MONDAY);
	meninner.add(rec1);
	meninner.add(rec2);
	meninner.add(rec3);
	mentot.add(meninner);
	meninner = new ArrayList<>();
	meninner.add(Day.TUESDAY);
	meninner.add(rec1);
	meninner.add(rec2);
	meninner.add(rec3);
	mentot.add(meninner);
	meninner = new ArrayList<>();
	meninner.add(Day.WEDNESDAY);
	meninner.add(rec1);
	meninner.add(rec2);
	meninner.add(rec3);
	mentot.add(meninner);
	meninner = new ArrayList<>();
	meninner.add(Day.THURSDAY);
	meninner.add(rec1);
	meninner.add(rec2);
	meninner.add(rec3);
	mentot.add(meninner);
	meninner = new ArrayList<>();
	meninner.add(Day.FRIDAY);
	meninner.add(rec1);
	meninner.add(rec2);
	meninner.add(rec3);
	mentot.add(meninner);
	meninner = new ArrayList<>();
	WeeklyMenu men1 = new WeeklyMenu(mentot,2,3);
	Resources.menuexists.add(men1);
}
}
