package controller;

import java.util.Scanner;



public class Main {
	public static void main(String[] args) throws InterruptedException {
		Methods Method=new Methods();
		Scanner scanner = new Scanner(System.in);
//		Method.insertmovie();
		
		 // Displaying welcome message and menu options
		System.out.println("WELCOME TO BOOKMYSHOW");
		
		
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.Exit");
		System.out.println("Enter Your Choice:");
		// Reading user's choice
		int choice1=scanner.nextInt();
		
		switch(choice1) {
		case 1:
			// Perform user registration
			Method.Signup();
			System.out.println("Successfully signed up please proceed to login...");
			// Display available movies
			Method.login();
			// Display available movies
			Method.movies();
			// Booking tickets
			int totalticket=Method.booktickets();
			// Process payment
			Method.payment(totalticket);
			
			// Display thank you message
			System.out.println("Thanks for visiting....");
			
			break;
		
		case 2:
			// Perform user login
			Method.login();
			// Display available movies
			Method.movies();
			// Book tickets
			int totalticket1=Method.booktickets();
			// Process payment
			Method.payment(totalticket1);
			// Display thank you message
			System.out.println("Thanks for visiting....");
			break;
			
		case 3:
			// Display exit message
			System.out.println("Thank you for visiting...");
		}
		
		
	}

}
