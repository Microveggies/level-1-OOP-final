/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part03;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;

// Make sure to import the correct Console definition
// java.io contains a different definition
import console.Console;
import part01.Category;
import part01.Day;
import part01.Ingredient;
import part01.Menu;
import part01.Recipe;
import part01.Resources;
import part01.WeeklyMenu;
public class QUBMediaKitchen {
	static String userdir = System.getProperty("user.dir");
	static String path = userdir + "/Images/";
	public static void main(String[] args) {
		// This will create a new Console instance
		// - a value of 'false' disables keyboard input
		initialise();
		MenuConsole mainMenu = new MenuConsole("QUB Kitchen", Resources.mainOptions,300,400);
		String choice = "";
		boolean quit = false;
		do {
			choice = mainMenu.getMainUserChoice();
			int choiceint = Integer.parseInt(choice);
			System.out.println(choiceint);
			quit = processChoice(choiceint);
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
		MenuConsole ingredientmanager = new MenuConsole("Ingredient Manager",Resources.ingredientOptions,300,500);
		String choice = ingredientmanager.getUserChoice();
		Console con = ingredientmanager.getcon();
		int choiceint = Integer.parseInt(choice);
		switch (choiceint) {
		case 1:
			addIngredient(ingredientmanager);
			break;
		case 2:
			con.println("enter ingredient to delete");
			String deletion = con.readLn();
			Resources.ingredientexists = deleteIngredient(deletion);
			con.println("deleted");
			try {
				Thread.sleep(100);
				con.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
				con.setVisible(false);
			}
			break;
		case 3:
			//collects an ingredient and the value to be updated in the array
			con.println("enter ingredient: ");
			String ing =con.readLn();
			con.println("1.update name\n2.update category\n3.update calories\n");
			String choicestr = con.readLn();
			int updateChoice = Integer.parseInt(choicestr);
			/**ensures the choices are between the values listed by the system the first if collects a string value and the else
			 * if uses method overloading to run another version of the updateIngredient method taking an integer instead of a 
			 * String to update calories
			 */
			if(updateChoice >0 && updateChoice<3) {
				//collecting new string to be passed into the method
				con.println("enter new value: ");
				String updated = con.readLn();
				updateIngredient(ing,updateChoice,updated,ingredientmanager);
			}else if(updateChoice == 3) {
				//collecting new string to be passed into the method
				System.out.println("enter new value: ");
				String updatedstr = con.readLn();
				int updated = Integer.parseInt(updatedstr);
				updateIngredient(ing,updateChoice,updated,ingredientmanager);
			}else {
				//returning feedback for invalid answers to the end user
				con.println("invalid answer");
			}
			con.setVisible(false);
			break;
		case 4:
			sortIngredientsAlphabetically();
			listIngredient();
			con.setVisible(false);
			break;
		
		case 5:
			sortIngredientsAlphabetically();
			searchIngredient(ingredientmanager);
			con.setVisible(false);
			break;
		case 6:
			con.setVisible(false);
			break;
		}
	}
	private static void addIngredient(MenuConsole console) {
		/**gets inputs for the necessary to create an instance of the ingredient class passing them into the designated 
		 * function
		 */
		Console con = console.getcon();
		con.println("enter name: ");
		String ingname = con.readLn();
		con.println("enter category: ");
		String cat = con.readLn();
		while(cat == null){
			con.println("Invalid Entry ");
			con.println("enter category: ");
			cat = con.readLn();
		}
		con.println("enter calories per 100g: ");
		String calstring = con.readLn();
		int cal = Integer.parseInt(calstring);
		while(cal < 0 || cal > 500) {
			con.println("Invalid Entry ");
			con.println("enter calories per 100g: ");
			calstring = con.readLn();
			cal = Integer.parseInt(calstring);
		}
		//creates ingredient using the fields collected and adds it to ingredientexists
		Ingredient ing = new Ingredient(ingname,cat,cal);
		Resources.ingredientexists.add(ing);
		System.out.println("added");
		con.setVisible(false);
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
	private static void sortIngredientsAlphabetically() {
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
	private static void listIngredient() {
		//creates an empty string and then loops through the ingredientexists list adding the details of the ingredient to string
			Console con = new Console(false);
			con.setSize(500,400);
			con.setVisible(true);
			con.setFont(new Font("Courier",Font.PLAIN,25));
			con.setBgColour(Color.black);
			con.setColour(Color.green);
			String ingredientlist = "";
			
			for(int i = 0; i <= Resources.ingredientexists.size()-1; i++) {
				try {
				String imgaddress = Resources.ingredientexists.get(i).GetName().replaceAll("\\s+", "") + ".png";
				ImageIcon img = new ImageIcon(path + imgaddress);
				System.out.println(path+imgaddress);
				con.println(img);
				con.println("name: " + Resources.ingredientexists.get(i).GetName()+ "\ncategory: " + Resources.ingredientexists.get(i).GetType()+"\ncalories(per 100g): " + Resources.ingredientexists.get(i).GetCal() + "\n"+"\n");
				}catch(Exception e){
					con.println("no image found");
				}
				
			}
			
		}
	private static ArrayList<Ingredient> deleteIngredient(String ing) {
		//Deletes an ingredient by copying all values except the value to be deleted into a new list and overwriting the previous
	    ArrayList<Ingredient> newingredients = new ArrayList<>();
	    for (Ingredient ingredient : Resources.ingredientexists) {
	        if (!ingredient.GetName().equals(ing)) {
	            newingredients.add(ingredient);
	        }
	    }
	    return newingredients;
	}
	private static void updateIngredient(String name ,int selection, String updated,MenuConsole console) {
    	//updates either name or category depending on response to the question checks if the ingredient named exists then updates
		Console con = console.getcon();
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
    private static void updateIngredient(String name ,int selection, int updated,MenuConsole console) {
    	//an alternate version of the above taking in an integer update value to edit the calories
    	Console con = console.getcon();
    	for(Ingredient ingredient : Resources.ingredientexists) {
        		if(ingredient.GetName().equals(name)) {
        			while((updated < 0 || updated > 500)) {
        				con.println("Invalid Entry try again:");
        				String updatestr = con.readLn();
        				updated = Integer.parseInt(updatestr);
        			}
        				
        			ingredient.SetCal(updated);
        		}
        	}
    	
    }
    private static void searchIngredient(MenuConsole console) {
    	Console con = console.getcon();
    	Console displayCon = new Console(false);
    	displayCon.setSize(500, 300);
    	displayCon.setVisible(false);
    	displayCon.setBgColour(Color.black);
		displayCon.setColour(Color.green);
    	displayCon.println("1.By ID\n2.By name\n3.By category");
    	String choicestr = con.readLn();
    	int searchChoice = Integer.parseInt(choicestr);
    	switch(searchChoice) {
    	case 1:
    		con.println("enter ID: ");
    		String IDstr = con.readLn();
    		int searchID = Integer.parseInt(IDstr);
        	for(Ingredient ingredient : Resources.ingredientexists){
        		if(ingredient.GetID() == searchID) {
        			String imgaddress = ingredient.GetName().replaceAll("\\s+", "") + ".png";
    				ImageIcon img = new ImageIcon(path + imgaddress);
    				System.out.println(path+imgaddress);
    				displayCon.setVisible(true);
    				displayCon.println(img);
        			displayCon.println(ingredient.toString());
        		}
        	}
        	break;
    	case 2:
    		con.println("enter name: ");
    		String searchName = con.readLn();
    		for(Ingredient ingredient : Resources.ingredientexists){
        		if(ingredient.GetName().equalsIgnoreCase(searchName)) {
        			String imgaddress = ingredient.GetName().replaceAll("\\s+", "") + ".png";
    				ImageIcon img = new ImageIcon(path + imgaddress);
    				System.out.println(path+imgaddress);
    				displayCon.setVisible(true);
    				displayCon.println(img);
        			displayCon.println(ingredient.toString());
        		}
        	}
    		break;
    	case 3:
    		con.println("enter category: ");
    		String searchCat = con.readLn();
    		for(Ingredient ingredient : Resources.ingredientexists){
        		if(ingredient.GetType().equalsIgnoreCase(searchCat)) {
        			String imgaddress = ingredient.GetName().replaceAll("\\s+", "") + ".png";
    				ImageIcon img = new ImageIcon(path + imgaddress);
    				System.out.println(path+imgaddress);
    				displayCon.setVisible(true);
    				displayCon.println(img);
        			displayCon.println(ingredient.toString());
        		}
        	}
    		break;
    	default:
    		displayCon.println("Invalid entry");
    		break;
    	}
    }
    
    private static void manageRecipes() {
		/**
		 * creates new instance of the menu class using the Resources.recipeOptions ArrayList to populate the choices on the menu 
		 * and prompts the user to give input to be used in the switch statement
		 */
		MenuConsole RecipeManager = new MenuConsole("Recipe Manager", Resources.recipeOptions,300,500);
		String choice = RecipeManager.getUserChoice();
		Console con = RecipeManager.getcon();
		int choiceint = Integer.parseInt(choice);
		switch(choiceint) {
		case 1:
			addRecipe(RecipeManager);
			break;
		case 2:
			con.println("enter recipe to delete");
			String deletion = con.readLn();
			Resources.recipeexists = deleteRecipe(deletion);
			con.println("deleted");
			try {
				Thread.sleep(100);
				con.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
				con.setVisible(false);
			}
			break;
		case 3:
			/**
			 * Sorts recipeexists ArrayList alphabetically desplaying each recipes name then calls the update function which
			 * will prompt the user for a value on that list to update.
			 */
			sortRecipesAlphabetically();
			String displayupdates = listRecipes();
			con.println(displayupdates);
			updateRecipe(RecipeManager);
			con.setVisible(false);
			break;
		case 4:
			/**
			 * similar to above displays recipe names alphabetically in order then takes in a recipe name and displays all details
			 * of the recipe named
			 */
			Console displaycon = new Console(true);
			displaycon.setSize(300,300);
			displaycon.setVisible(true);
			displaycon.setBgColour(Color.black);
			displaycon.setColour(Color.white);
			displaycon.setFont(new Font("Courier",Font.PLAIN,25));
			con.setVisible(false);
			sortRecipesAlphabetically();
			String display = listRecipes();
			displaycon.println(display);
			displaycon.setColour(Color.green);
			displaycon.println("enter recipe to show: ");
			String name = displaycon.readLn();
			StringBuilder recipe = listOneRecipe(name);
			displaycon.println(recipe);
			con.setVisible(false);
			break;
		case 5:
			sortRecipesAlphabetically();
			searchRecipe();
			con.setVisible(false);
			break;
		case 6:
			con.setVisible(false);
			break;
		}
    }
    private static void addRecipe(MenuConsole console) {
    Console con = console.getcon();
   	 boolean valid = true;
   	 boolean ingredientfound = false;
   	 while(valid) {
   		 ingredientfound = false;
   	//creates a 2-dimensional ArrayList to store a series of ingredients
   		ArrayList<ArrayList<Object>> ingredients = new ArrayList<>();
   		//gets inputs for name and a number of ingredients to loop inputs for
   		con.println("name of recipe: ");
   		String recipeName = con.readLn();
   		while(recipeName.equals(null)||recipeName.equals("")) {
   			con.println("invalid, please enter new value");
   			recipeName = con.readLn();
   		}
   		con.println("how many ingredients?: ");
   		String quantstr = con.readLn();
   		int quantity = Integer.parseInt(quantstr);
   		//loops creating the ArrayList to be stored in ingredients for each ingredient input in the quantity value
   		for(int i =0; i <= quantity-1; i++) {
   			//Creates an ArrayList of type Object as it stores a series of classes to be added into ingredients 
   			ArrayList<Object> ingredientinner = new ArrayList<>();
   			//collects ingredient name
   			con.println("name of ingredient: ");
   			String ingredientName = con.readLn();
   			//validates the ingredient named exists and if it does it will be added into the ArrayList ingredientinner
   			for (Ingredient ingredient : Resources.ingredientexists) {
   		        if (ingredient.GetName().equals(ingredientName)) {
   		            ingredientinner.add(ingredient);
   		            ingredientfound = true;
   		        }
   		        
   			}
   			if(!ingredientfound) {
   				con.println("no such ingredient found");
   				ingredientfound = false;
   				break;
   			}
   			//collects the quantity of ingredient wrapped as Integer allowing it to be stored in an ArrayList
   			con.println("enter quantity in grams");
   			String amountstr = con.readLn();
   			Integer amount = Integer.parseInt(amountstr);
   			ingredientinner.add(amount);
   			//collects a value for unit of measurement as sample data showed values such as cloves of garlic rather than grams
   			con.println("unit: ");
   			String unit = con.readLn();
   			ingredientinner.add(unit);
   			/**allows a preparation to be input so that mashed potatoes and cubed potatoes do not have to be seperate instances
   			 * of the ingredient class allowing ingredients to be more reusable 
   			 */
   			con.println("Enter preparation: ");
   			String prep = con.readLn();
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
   			con.println("no such ingredient found");
   			valid = false;
   			break;
   		}
   		con.println("enter type(Starter,Main Course,Dessert): ");
   		String type = con.readLn();
   		//creates an empty string to store the steps of the recipe and collects how many steps there are to iterate through
   		String method = "";
   		con.println("how many steps?: ");
   		String stepstr = con.readLn();
   		int steps = Integer.parseInt(stepstr);
   		/**
   		 * Loops through asking for the recipe steps up to the number of times the user input when prompted adding them to
   		 * the method string in the format:
   		 * 1. x
   		 * 2. y
   		 */
   		for(int i =0; i <= steps-1; i++) {
   			con.println("enter step: ");
   			method = method +i+1+". "+ con.readLn()+ "\n";
   		}
   		con.println("How many servings?: ");
   		String portstr = con.readLn();
   		int portions = Integer.parseInt(portstr);
   		Recipe Rec = new Recipe(recipeName,ingredients,type,method,portions);
       	Resources.recipeexists.add(Rec);
       	valid = false;
   	 }
   	 con.setVisible(false);
       }
    private static ArrayList<Recipe> deleteRecipe(String ing) {
    	//Deletes recipe by copying all values except the value to be deleted into a new list and overwriting the previous
    	    ArrayList<Recipe> newrecipe = new ArrayList<>();
    	    for (Recipe recipe : Resources.recipeexists) {
    	        if (!recipe.getName().equals(ing)) {
    	            newrecipe.add(recipe);
    	        }
    	    }
    	    return newrecipe;
    	}
    private static void sortRecipesAlphabetically() {
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
    private static String listRecipes() {
    	//outputs a list of the names of all recipes by iterating through recipeexists calling the getName method
    	String recipelist = "";
    	for(int i = 0; i <= Resources.recipeexists.size()-1; i++) {
    		recipelist= recipelist +"name: " + Resources.recipeexists.get(i).getName()+ "\n";
    	}
    	return recipelist;
    }
    private static StringBuilder listOneRecipe(String name) {
    	//makes use of the string builder class to easily append many details into a string adding all details of a recipe to be displayed
    	StringBuilder recipedetails = new StringBuilder();
    	for(Recipe recipe : Resources.recipeexists) {
    		if(recipe.getName().equals(name)) {
    			recipedetails.append(recipe.getName()+"\n").append(recipe.getIngredients()+"\n").append("course: " + recipe.getType() + "\n").append(recipe.getmethod() + "\n").append("servings: " +Integer.toString(recipe.getPortions())+ "\n").append("total calories:" + recipe.getfullcal());
    		}
    	}
    	return recipedetails;
    }
    private static void updateRecipe(MenuConsole console) {
    	//gets an input of recipe name to be edited
    	Console con = console.getcon();
    	con.println("enter recipe to edit");
    	String editchoice = con.readLn();
    	//loops through existing recipes comparing their name to the name of the recipe entered to see if its valid
    	for(int i = 0; i <= Resources.recipeexists.size()-1;i++) {
    		if(Resources.recipeexists.get(i).getName().equals(editchoice)) {
    			//list outs editing options taking in the integer response to a switch case to update the corresponding function
    			con.println("1. Update Name\n2. Update Ingredients\n3.Update Method\4. Update Portions");
    			String featurestr = con.readLn();
    			int editedfeature = Integer.parseInt(featurestr);
    			switch(editedfeature) {
    			case 1:
    				//takes in a string and feeds it into the setName method to update the recipe
    				con.println("enter new value");
    				String newval = con.readLn();
    				while(newval.equals(null)|| newval.equals("")) {
    					con.println("invalid, please enter new value");
    					newval = con.readLn();
    				}
    				Resources.recipeexists.get(i).setName(newval);
    				break;
    			case 2:
    				//creates a new ingredients set prompting the user to reenter the ingredients list to the new values
    				ArrayList<ArrayList<Object>> ingredients = new ArrayList<>();
    				con.println("how many ingredients?: ");
    				String quantstr = con.readLn();
    				int quantity = Integer.parseInt(quantstr);
    				//creates the inner array list storing each ingredients detail j time j being the number of ingredients quantity
    				for(int j =0; j <= quantity-1; j++) {
    					ArrayList<Object> ingredientinner = new ArrayList<>();
    					con.println("name of ingredient: ");
    					String ingredientName = con.readLn();
    					for (Ingredient ingredient : Resources.ingredientexists) {
    				        if (ingredient.GetName().equals(ingredientName)) {
    				            ingredientinner.add(ingredient);
    				        }
    					}
    					con.println("enter quantity in grams");
    					String amountstr = con.readLn();
    					Integer amount = Integer.parseInt(amountstr);
    					ingredientinner.add(amount);
    					con.println("unit: ");
    					String unit = con.readLn();
    					ingredientinner.add(unit);
    					con.println("Enter preparation: ");
    					String prep = con.readLn();
    					ingredientinner.add(prep);
    					ingredients.add(ingredientinner);
    				}
    				Resources.recipeexists.get(i).setIngredient(ingredients);
    				break;
    			case 3:
    				
    				String method = "";
    				con.println("how many steps?: ");
    				String stepstr = con.readLn();
    				int steps = Integer.parseInt(stepstr);
    				for(int k =0; k <= steps-1; k++) {
    					con.println("enter step: ");
    					method = method +(k+1)+". "+ con.readLn()+ "\n";
    				}
    				Resources.recipeexists.get(i).setMethod(method);
    				break;
    			case 4:
    				con.println("How many servings?: ");
    				String portstr = con.readLn();
    				int portions = Integer.parseInt(portstr);
    				Resources.recipeexists.get(i).setPortions(portions);
    				break;
    			}
    		}
    	}
    }
    private static Recipe getValidRecipe(MenuConsole console, String courseType) {
    	Console con = console.getcon();
        Recipe recipeInput;
        do {
            con.println("Enter " + courseType);
            String recipeName = con.readLn().toLowerCase();
            recipeInput = findRecipe(recipeName, courseType);
            if (recipeInput == null) {
                con.println("Invalid " + courseType + ". Please try again.");
            }
        } while (recipeInput == null);
        return recipeInput;
    }
    private static Recipe findRecipe(String recipeName, String courseType) {


        for (Recipe recipe : Resources.recipeexists) {
            if (recipe.getName().toLowerCase().equals(recipeName) && recipe.getType().equals(courseType)) {
                return recipe;
            }
        }
        return null;
    }
    private static void searchRecipe() {
    	Console con = new Console(true);
    	con.setBgColour(Color.black);
		con.setColour(Color.green);
		con.setSize(400, 400);
		con.setVisible(true);
    	con.println("1.By ID\n2.By name\n3.By course");
    	String searchstr = con.readLn();
    	int searchChoice = Integer.parseInt(searchstr);
    	switch(searchChoice) {
    	case 1:
    		con.println("enter ID: ");
    		String IDstr = con.readLn();
    		int searchID = Integer.parseInt(IDstr);
        	for(Recipe rec : Resources.recipeexists){
        		if(rec.getID() == searchID) {
        			con.println(listOneRecipe(rec.getName()));
        		}
        	}
        	break;
    	case 2:
    		con.println("enter name: ");
    		String searchName = con.readLn();
    		for(Recipe rec : Resources.recipeexists){
        		if(rec.getName().equalsIgnoreCase(searchName)) {
        			con.println(listOneRecipe(rec.getName()));
        		}
        	}
    		break;
    	case 3:
    		con.println("enter course: ");
    		String searchCat = con.readLn();
    		for(Recipe rec : Resources.recipeexists){
        		if(rec.getType().equalsIgnoreCase(searchCat)) {
        			con.println(listOneRecipe(rec.getName()));
        		}
        	}
    		break;
    	default:
    		con.println("Invalid entry");
    		break;
    	}
    }
    
    private static void manageWeeklyMenu() { 
    /**creates new instance of the menu class using Resources.MenuOptions to populate the choices prompting input to feed
	 * into the switch case
	 */
	MenuConsole MenuManager = new MenuConsole("Menu Manager",Resources.MenuOptions,300,500);
	String choice = MenuManager.getUserChoice();
	Console con = MenuManager.getcon();
	int choiceint = Integer.parseInt(choice);
	switch(choiceint) {
	case 1:
		//call the addWeeklyMenu method to create a new menu
		AddWeeklyMenu(MenuManager);
        break;
    
	case 2:
		/**asks for the beginning date for a menu to feed into the delete function the updates menuexists to be a copy 
		 * without the menu entered.
		 */
		con.println("Enter week of Menu to remove:");
		String MenToDelstr = con.readLn();
		int MenToDel = Integer.parseInt(MenToDelstr);
		Resources.menuexists = deleteMenu(MenToDel);
		con.println("Deleted");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		con.setVisible(false);
		break;
	case 3:
		//calls the update menu function to edit a section of the menu
		updateMenu(MenuManager);
		con.setVisible(false);
		break;
	case 4:
		/**
		 * takes in a starting week the compares this week to the menus in menuexists and if a match is found it displays
		 * the full menu
		 */
		
		con.println("Enter Starting week");
		String weekStart = con.readLn();
		int Startdate = Integer.parseInt(weekStart);
		Console displaycon = new Console(true);
		displaycon.setSize(1000,450);
		displaycon.setVisible(true);
		displaycon.setBgColour(Color.black);
		displaycon.setFont(new Font("Courier",Font.PLAIN,25));
		displaycon.setColour(Color.green);
		for(WeeklyMenu menu : Resources.menuexists) {
			if(menu.getStart() == Startdate) {
				displaycon.println("Weekly Menu added:\n" + menToString(menu.getWeeklyMenu(), menu.getStart(), menu.getEnd()));
			}
		}
		con.setVisible(false);
		break;
	case 5:
		con.setVisible(false);
		break;
	}
}
    private static void AddWeeklyMenu(MenuConsole console) {
    	Console con = console.getcon();
    	con.println("Enter starting week (e.g. week 1)");
    	String weekStart = con.readLn();
		int Startdate = Integer.parseInt(weekStart);
    	con.println("Enter end week");
    	String weekend = con.readLn();
		int Enddate = Integer.parseInt(weekStart);
        ArrayList<ArrayList<Object>> MenuOuter = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Assuming 5 days in a week
            ArrayList<Object> MenuInner = new ArrayList<>();
            Day day = Day.values()[i];
            MenuInner.add(day);

            //System.out.println("Enter Starter");
            Recipe starter = getValidRecipe(console, "Starter");
            MenuInner.add(starter);

            //System.out.println("Enter Main");
            Recipe mainCourse = getValidRecipe(console, "Main Course");
            MenuInner.add(mainCourse);

            //System.out.println("Enter dessert");
            Recipe dessert = getValidRecipe(console, "Dessert");
            MenuInner.add(dessert);

            MenuOuter.add(MenuInner);
        }

        WeeklyMenu men = new WeeklyMenu(MenuOuter,Startdate,Enddate);
        Resources.menuexists.add(men);
        con.setVisible(false);
    }
    private static ArrayList<WeeklyMenu> deleteMenu(int start) {
        ArrayList<WeeklyMenu> newrecipe = new ArrayList<>();
        for (WeeklyMenu menu : Resources.menuexists) {
            if (menu.getStart() != start) {
                newrecipe.add(menu);
            }
        }
        return newrecipe;
    }
    private static String menToString(Object[][] weeklyMenu, int weekstart, int weekend) {
        StringBuilder sb = new StringBuilder();
        sb.append("week" + weekstart + " -  week " + weekend);
        for (int i = 0; i < weeklyMenu.length; i++) {
            sb.append("\nDay: ").append(Day.values()[i]).append("\n");
            for (int j = 0; j < weeklyMenu[i].length; j++) {
                sb.append("  ").append(weeklyMenu[i][j]);
            }
        }
        return sb.toString();
    }
    private static void updateMenu(MenuConsole console) {
    	Console con = console.getcon();
    	con.println("Enter starting week of the menu to edit: ");
    	String menenter = con.readLn();
		int mentoedit = Integer.parseInt(menenter);
    	for(WeeklyMenu menu : Resources.menuexists) {
    		if(menu.getStart() == mentoedit) {
    			con.println("1. update start week\n2. update ending week\n3. update menu content");
    			String updatestr = con.readLn();
    			int updatechoice = Integer.parseInt(updatestr);
    			switch(updatechoice) {
    			case 1:
    				con.println("enter new start week:");
    				String weekStart = con.readLn();
    				int Startdate = Integer.parseInt(weekStart);
    				menu.setStart(Startdate);
    			case 2:
    				con.println("enter new end week:");
    				String weekEnd = con.readLn();
    				int Enddate = Integer.parseInt(weekEnd);
    				menu.setEnd(Enddate);
    			case 3:
    				ArrayList<ArrayList<Object>> MenuOuter = new ArrayList<>();
    				for (int i = 0; i < 5; i++) { // Assuming 5 days in a week
    		            ArrayList<Object> MenuInner = new ArrayList<>();
    		            Day day = Day.values()[i];
    		            MenuInner.add(day);

    		            //System.out.println("Enter Starter");
    		            Recipe starter = getValidRecipe(console, "Starter");
    		            MenuInner.add(starter);

    		            //System.out.println("Enter Main");
    		            Recipe mainCourse = getValidRecipe(console, "Main Course");
    		            MenuInner.add(mainCourse);

    		            //System.out.println("Enter dessert");
    		            Recipe dessert = getValidRecipe(console, "Dessert");
    		            MenuInner.add(dessert);

    		            MenuOuter.add(MenuInner);
    		        }
    				menu.setWeeklyMenu(MenuOuter);
    			}
    		}
    	}
    }
    
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



	


