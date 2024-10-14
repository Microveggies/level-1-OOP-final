
/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */package part01;

public enum Category {
	FRUITVEG("fruit & veg"),COMPOSITE("Composite food"), DAIRY("Dairy"),PROTEIN("Protein"),CEREAL("Cereal"),FAT("Fat"),SPICEHERB("Spice & Herb"), SUGAR("Sugar"),ESSENTIALNUT("Essential nutrient"),NULL("UNKNOWN");
	
	private String catstring;
	private Category(String cat) {
		catstring = cat;
	}
	
	public String toString() {
		return catstring;
	}
}
