/**
 * Assessment 2 csc1027 name: Adam Caughey student no: 40399033
 */
package part03;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
// Make sure to import the correct Console definition
// java.io contains a different definition
import console.Console;
public class MenuConsole {
	private String items[];
	private String title;
	private Console con;

	public MenuConsole(String title, String data[],int height, int width) {
		this.con = new Console(true);
		this.con.setSize(height,width);
		this.con.setVisible(true);;
		this.title = title;
		this.items = data;
	}
	
	public Console getcon() {
		return this.con;
	}

	private void display() {
		con.setFont(new Font("Courier",Font.BOLD,30));
		con.setBgColour(Color.black);
		con.setColour(Color.green);
		con.println(title);
		for (int count = 0; count < title.length(); count++) {
			con.print("+");
		}
		con.println();
		con.setFont(new Font("Courier",Font.PLAIN,25));
		con.setColour(Color.white);
		for (int option = 1; option <= items.length; option++) {
			con.println(option + ". " + items[option - 1]);
		}
		con.println();
	}

	public String getUserChoice() {
		con.setColour(Color.white);
		boolean ok = false;
		String value = "";
		display();
		do {
			con.setColour(Color.green);
			con.print("Enter Selection: ");
			try {
				value = con.readLn();
				if ( value.equals("1")|| value.equals("2")|| value.equals("3")||value.equals("4")||value.equals("5")||value.equals("6")) {
					ok = true;
				}
			} catch (Exception ex) {
				con.readLn();
			}
		} while (!ok);
		return value;
	}
	
	public String getMainUserChoice() {
		con.setColour(Color.white);
		boolean ok = false;
		String value = "";
		display();
		do {
			con.setColour(Color.green);
			con.print("Enter Selection: ");
			try {
				value = con.readLn();
				if ( value.equals("1")|| value.equals("2")|| value.equals("3")||value.equals("4")) {
					ok = true;
				}
			} catch (Exception ex) {
				con.readLn();
			}
		} while (!ok);
		return value;
	}
	
}
