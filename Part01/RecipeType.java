package part01;

public enum RecipeType {
	STARTER("Starter"),MAIN("Main Course"), DESSERT("Dessert");
	
	private String typestring;
	private RecipeType(String type) {
		typestring = type;
	}
	
	public String toString() {
		return typestring;
	}
}
