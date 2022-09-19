package phoneList;

import java.util.*;

/*
 * Phone List
 * 
 * You'll be using an ArrayList of Contact objects
 * to crate a digital address book.
 * 
 * You MUST
 *   - Use an ArrayList
 *   - Keep list in alphabetical order
 *   - Complete the methods below
 *   
 * You May
 *   - Add methods as you see fit
 *   - Change method parameters and return types
 *   
 * You May NOT
 *   - change the menu method
 *        unless you're changing what methods it calls
 * 
 */


public class PhoneList {
	
	public ArrayList<Contact> contactList;
	public static Scanner input;

	private long timeSleep;
	
	//Constructor
	public PhoneList() {
		//initialize instance variables
		this.contactList = new ArrayList<Contact>();
		this.input = new Scanner(System.in);
		this.timeSleep = 2000;
	}
	
	
	
	public void addContact() {
		ClearScreen();

		System.out.println("Enter the contact's name: ");
		String name = input.nextLine();
		System.out.println("Enter the contact's number: ");
		long number = input.nextLong();

		Contact contact = new Contact(name, number);

		contactList.add(contact);
		contactList.sort((Contact c1, Contact c2) -> c1.getContactName().compareTo(c2.getContactName()));	
		
		try{		
			System.out.println(contact.getContactName() + " (" + contact.getContactNumber() + ") has been added to the list.");
			Thread.sleep(this.timeSleep);
		}
		catch(Exception e){
			System.out.println("Program Error: " + e.getMessage());
		}

		String holding = input.nextLine();
	}
			
	public void removeContact() {
		ClearScreen();
		
		System.out.println("---- Contact List ----\n");
		if(contactList.isEmpty()){
			System.out.println("There are no contacts in the list.\n");
			try {		
				Thread.sleep(this.timeSleep);
			}
			catch(Exception e){
				System.out.println("Program Error: " + e.getMessage());
			} 
			return;
		}

		for(int i = 0; i < contactList.size(); i++){
			System.out.println("[" + i + "] " + contactList.get(i).getContactName() + " (" + contactList.get(i).getContactNumber() + ")");
		}

		System.out.println("Enter index to remove: ");
		int toRemove = input.nextInt();

		contactList.remove(toRemove);
	}
	
	public void printList() {
		ClearScreen();

		System.out.println("---- Contact List ----\n");
		if(contactList.isEmpty()){
			System.out.println("There are no contacts in the list.\n");
			try {		
				Thread.sleep(this.timeSleep);
			}
			catch(Exception e){
				System.out.println("Program Error: " + e.getMessage());
			} 
			return;
		}
		else{
			for (Contact contact : contactList) {
				System.out.println(contact.getContactName() + " (" + contact.getContactNumber() + ")");
			}
			input.nextLine();
		}

		
		
	}

	public void menu() {

		ClearScreen();

		int input = 0;
		
		String menu = "-----------------------\n"
				    + "     Contacts Menu     \n"
				    + "-----------------------\n"
				    + "  1 - Add Contact      \n"
				    + "  2 - Remove Contact   \n"
				    + "  3 - Print List       \n"
				    + "  4 - Quit             \n\n"
				    + "Enter Choice: ";
		
		while (input != 4) {  //keep looping till user want's to quit
			
			//try getting an input
			try {

				String inputString = getString(menu);  //get input
				input = Integer.valueOf(inputString);  //try converting to int
			}
			catch (Exception e) {
				//if bad input, set input to 0
				input = 0;  
			}
		
			switch (input) {
			case 1:
				//handle menu line 1: Add Contact
				addContact();
				break;
			case 2:
				//handle menu line 2: Remove Contact
				removeContact();
				break;
			case 3:
				//handle menu line 3: Print List
				printList();
				break;
			case 4:
				//handle menu line 4: Quit
				System.out.println("\nGoodbye!");
				break;
			default:
				ClearScreen();
				System.out.println("\nNot a valid input. Please try again.\n");
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		PhoneList app = new PhoneList();
		app.menu();
	}

	// Utils
	public static String getString(String str) {
		
		System.out.print(str);  //notice it's NOT a print line.  This way input is next to question.
		return input.nextLine();
		
	}
	public static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }    
}
