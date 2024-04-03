package controller;

import java.util.Random;
import java.util.Scanner;
import dao.PaymentDao;
import dao.TicketDao;
import dao.CustomerDao;
import dao.MovieDao;
import dto.Payment;
import dto.Customer;
import dto.Movie;
import dto.Ticket;

public class Methods {
	 Scanner scanner = new Scanner(System.in);
	 Customer customer = new Customer();
	 CustomerDao customerdao=new CustomerDao();
	 Movie movie=new Movie();
	 MovieDao movieDao=new MovieDao();
	 Random random=new Random();
	 Payment card=new Payment();
	 PaymentDao cardDao=new PaymentDao();
	 Ticket ticket=new Ticket();
	 TicketDao ticketdao=new TicketDao();
	 
	int totalticketprice=250;
	 
	// User signup method
	public void Signup()
	{
	     System.out.println("Enter UserName:");
	     String username=scanner.next();
	     
	     System.out.println("Enter Email id:");
	     String email=scanner.next();
	     
	     System.out.println("Enter Phone Number:");
	     long phno=scanner.nextLong();
	     
	     System.out.println("Enter Password:");
	     String password=scanner.next();
	     
	  // Set user details
	     customer.setCustomerName(username);
	     customer.setCustomerEmail(email);
	     customer.setCustomerPhoneNumber(phno);
	     customer.setCustomerPassword(password);
	     
	  // Insert user into database
	     customerdao.Insert(customer);
	     
	}
	// Insert movie details method
	public void insertmovie()
	{
		movie.setMovieTitle("Hanuman");
		movie.setGenre("Adventure/Action");
		movie.setMovieReleaseDate("14/1/2024");
		movie.setMovieRating(4.8);
		
		movieDao.insert(movie);
	}
	
	
	
	 
	// User login method
	public void login()
	{
		 System.out.println("Enter Email id:");
	     String email=scanner.next();
	     
	     System.out.println("Enter Password:");
	     String password=scanner.next();
	  // Validate user credentials
	     if (customerdao.validateCredentials(email, password)) {
	    	    System.out.println("Login successful");
	    	} else {
	    	    System.out.println("Invalid credentials");
	    	    System.out.println("Please Login Again");
	    	    login();// Recursive call to login method for retrying
	    	}
 
	}
	// Display available movies method
	public void movies()
	{
		System.out.println("List of Movies:");
		System.out.println("1. Evil Dead");
		
		
		System.out.println("2. Gunturu Karam");
	
		
		System.out.println("3. Fidaa");
		
		
		System.out.println("4. Suzume");
		
		
		System.out.println("5. Family Star");
	
		
		System.out.println("6. Hanuman");
		
		
		System.out.println("Enter Your Choice");
		int movienumber=scanner.nextInt();
		
		switch(movienumber)
		{
		case 1:
			Movie movie1=movieDao.fetch(movienumber);
			String moviename1=movie1.getMovieTitle();
			System.out.println("You have selected " +moviename1);
			break;
		case 2:
			Movie movie2=movieDao.fetch(movienumber);
			String moviename2=movie2.getMovieTitle();
			System.out.println("You have selected " +moviename2);
			break;
		case 3:
			Movie movie3=movieDao.fetch(movienumber);
			String moviename3=movie3.getMovieTitle();
			System.out.println("You have selected " +moviename3);
			break;
		case 4:
			Movie movie4=movieDao.fetch(movienumber);
			String movien4=movie4.getMovieTitle();
			System.out.println("You have selected " +movien4);
			break;
		case 5:
			Movie movie5=movieDao.fetch(movienumber);
			String moviename5=movie5.getMovieTitle();
			System.out.println("You have selected " +moviename5);
			break;
		case 6:
			Movie movie6=movieDao.fetch(movienumber);
			String moviename6=movie6.getMovieTitle();
			System.out.println("You have selected " +moviename6);
			break;	
		}
		Movie movie=movieDao.fetch(movienumber);
		System.out.println(movie);
	}
	// Book tickets method
	public int booktickets()
	{
		double ticketprice=250.00;
		System.out.println("DO YOU WANT TO BOOK THE TICKETS:(YES/N0)");
		String choice2=scanner.next();
		if(choice2.equals("yes"))
		{
			
				System.out.println("Ticket Price: 250/-");
				System.out.println("How many tickets do you want?");
				int tickets=scanner.nextInt();
				seat(tickets);
				int totalticket=(int) (tickets*ticketprice);
				System.out.println("Total amount for " +tickets+" tickets is: " +totalticket);
				return totalticket;
			}
		
		else
		{
			System.out.println("Thank you for visiting...");
			return 0;
			
		}
	}
	// Payment method
	public void payment(int totalticket) {
		System.out.println("Please choose payment method: ");
		System.out.println("1. Credit card/Debit card");
		System.out.println("2. UPI");
		int choice3=scanner.nextInt();
		switch(choice3) {
		case 1:
			System.out.println("please enter card number:");
			long cardno=scanner.nextLong();
			card.setCardNumber(cardno);
			cardDao.insert(card);
			System.out.println("Enter password: ");
			String cardpassword=scanner.next();
			if(customerdao.Fetch(choice3).equals(cardpassword))
			{
				System.out.println("Total Amount debited is "+totalticket);
				System.out.println("you have successfully booked tickets...");
			}
			break;
		case 2:
			System.out.println("enter Phone Number :");
			long phno=scanner.nextLong();
			System.out.println("enter password :");
			String pass=scanner.next();
			 if (customerdao.validateCredentialsusingphno(phno, pass)) {
		    	    System.out.println("Total Amount debited is "+totalticket);
		    	} else {
		    	    System.out.println("Invalid credentials");
		    	    System.out.println("Please try Again");
		    	    booktickets();
		    	    payment(totalticket);
		    	    
		    	    
		    	}
			}
			
		
		
	}
	
	//selecting seats
	public void seat(int tickets) {
		System.out.println("Select the seats");
		System.out.println("1 2 3 4 5");
		System.out.println("6 7 8 9 10");
		System.out.println("11 12 13 14 15");
		
		for(int i=1;i<=tickets;i++) {
		int seatedno=scanner.nextInt();
		ticket.setSeatNo(seatedno);
		ticket.setTicketCost(totalticketprice);
		ticketdao.insert(ticket);
				
		switch(seatedno) {
		case 1:
			Ticket ticket1=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket1);
			break;
			
		case 2:
			Ticket ticket2=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket2);
			break;
			
		case 3:
			Ticket ticket3=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket3);
			break;
			
		case 4:
			Ticket ticket4=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket4);
			break;
			
		case 5:
			Ticket ticket5=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket5);
			break;
			
		case 6:
			Ticket ticket6=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket6);
			break;
			
		case 7:
			Ticket ticket7=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket7);
			break;
			
		case 8:
			Ticket ticket8=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket8);
			break;
			
		case 9:
			Ticket ticket9=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket9);
			break;
			
		case 10:
			Ticket ticket10=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket10);
			break;
			
		case 11:
			Ticket ticket11=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket11);
			break;
			
		case 12:
			Ticket ticket12=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket12);
			break;
			
		case 13:
			Ticket ticket13=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket13);
			break;
			
		case 14:
			Ticket ticket14=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket14);
			break;
			
		case 15:
			Ticket ticket15=ticketdao.fetch(seatedno);
			System.out.println("You have selected " +ticket15);
			break;
			
		
		}	
		}
		System.out.println("YOUR SEATS ARE SELECTED");	
		System.out.println("DO YOU WANT TO CONFIRM THE BOOKING:(YES/NO)");
		String confirm=scanner.next();
		
		if(confirm.equals(confirm)) {
			System.out.println("CONGRATULATIONS YOUR TICKETS GOT BOOKED ");
		}
		else {
			movies();
		}
	
	}
}
