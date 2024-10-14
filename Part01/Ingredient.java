/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part01;

public class Ingredient {
	private static int nextid = 1;
	private int id;
	private String name;
	private Category type;
	private int cal;
	
	public Ingredient(String name,String type,int cal){
		this.id = nextid;
		nextid++;
		SetName(name);
		SetType(type);
		SetCal(cal);
	}
	
	
	public Ingredient(String name, Category type, int cal) {
		this.id = nextid;
		nextid++;
		SetName(name);
		SetType(type);
		SetCal(cal);
	}


	public String GetName() {
		return this.name;
	}
	
	public String GetType() {
		return this.type.toString();
	}
	
	public int GetCal() {
		return this.cal;
	}
	
	public int GetID() {
		return this.id;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetType(Category type) {
		this.type = type;
	}
	public void SetType(String type) {
		switch(type){
		case "fruit & veg":
			SetType(Category.FRUITVEG);
			break;
		case "composite food":
			SetType(Category.COMPOSITE);
			break;
		case "dairy":
			SetType(Category.DAIRY);
			break;
		case "protein":
			SetType(Category.PROTEIN);
			break;
		case "fat":
			SetType(Category.FAT);
			break;
		case "cereal":
			SetType(Category.CEREAL);
			break;
		case "herb & spice":
			SetType(Category.SPICEHERB);
			break;
		case "sugar":
			SetType(Category.SUGAR);
			break;
		case "essential nutrient":
			SetType(Category.ESSENTIALNUT);
			break;
		default:
			SetType(Category.NULL);
		}
		}
		
	public void SetCal(int cal) {
			this.cal = cal;
		}
		
	public String toString() {
			String str = "ID: "+ GetID() +
					"\nname: "+ GetName() +
					"\ncategory: "+ GetType() +
					"\ncal(per100g): " + GetCal() +
					"\n";
			return str;
		}
		
	}
	
	


