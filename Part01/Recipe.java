/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part01;

import java.util.ArrayList;

public class Recipe {
	private static int nextid =1;
	private int id;
	private String name;
	private RecipeType type;
	private ArrayList<ArrayList<Object>> ingredient;
	private String method;
	private int portions;
	
	public Recipe(String name, ArrayList<ArrayList<Object>> ingredient, String type, String method, int portions) {
		this.id = nextid;
		nextid++;
		setName(name);
		setIngredient(ingredient);
		setType(type);
		setMethod(method);
		setPortions(portions);
	}
	public void setPortions(int portions) {
		this.portions = portions;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIngredient(ArrayList<ArrayList<Object>> ingredient) {
		this.ingredient = ingredient;
	}
	
	public void setType(RecipeType type) {
		this.type = type;
	}
	
	public void setType(String type) {
		switch(type) {
		case "Starter":
			this.type = RecipeType.STARTER;
			break;
		case "Main Course":
			this.type = RecipeType.MAIN;
			break;
		case "Dessert":
			this.type = RecipeType.DESSERT;
			break;
		}
	}
	
	public void setMethod(String method) {
		this.method = method;
	}
	
	public int getPortions() {
		return this.portions;
		}
	
	public ArrayList<ArrayList<Object>> getLiteralIngredients() {
		return this.ingredient;
	}
	public String getIngredients() {
	    StringBuilder result = new StringBuilder();
	    
	    for (ArrayList<Object> ingredientEntry : ingredient) {
	        if (ingredientEntry.size() == 4) {
	            String quantity = ingredientEntry.get(1).toString(); 
	            String unit = ingredientEntry.get(2).toString(); 
	            Ingredient ingredientObj = (Ingredient) ingredientEntry.get(0); 
	            String preparation = ingredientEntry.get(3).toString(); 
	            result.append(quantity).append(" ").append(unit).append(" ").append(ingredientObj.GetName()).append(" ").append(preparation).append("\n");
	        } else {
	            result.append("Incomplete ingredient entry\n");
	        }
	    }

	    return result.toString();
	}
	
	public int getfullcal() {
		int totalcal=0;
		for (ArrayList<Object> ingredientEntry : ingredient) {
	        if (ingredientEntry.size() == 4) {
	        	if(ingredientEntry.get(2).equals("g")) {
	        	Ingredient ingredientObj = (Ingredient) ingredientEntry.get(0);
	        	int quantity = (int) ingredientEntry.get(1);
	        	totalcal = totalcal+ (quantity/100)*(ingredientObj.GetCal());
	        }else {
	        	Ingredient ingredientObj = (Ingredient) ingredientEntry.get(0);
	        	int quantity = (int) ingredientEntry.get(1);
	        	totalcal = totalcal+ (quantity)*(ingredientObj.GetCal());
	        }
		}
		}
		return totalcal;
	}
	public String getName() {
		return this.name;
	}
	public int getID() {
		return this.id;
	}
	
	public String getmethod() {
		return this.method;
	}
	public String getType() {
		return this.type.toString();
	}
	public String toString() {
	    return type.toString()+": " + name; // Assuming 'name' is a field in your Recipe class
	}
}
