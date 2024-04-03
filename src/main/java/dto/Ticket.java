package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private int SeatNo;
	private int ticketCost;
	

	public int getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	
	
	public int getSeatNo() {
		return SeatNo;
	}
	public void setSeatNo(int seatNo) {
		SeatNo = seatNo;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", SeatNo=" + SeatNo + ", ticketCost=" + ticketCost + "]";
	}
	

}

