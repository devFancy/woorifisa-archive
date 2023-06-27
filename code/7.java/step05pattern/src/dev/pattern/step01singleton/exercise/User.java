package dev.pattern.step01singleton.exercise;
/*
 * ☆ -- User - 티켓 발행기를 이용하여 티켓을 발급받는 사용자 클래스 -- ☆
 */
public class User {
	Ticket ticket; // - User가 보유한 티켓
	
	// - 티켓 발행기를 사용하는 기능
	void useTicketMachine() {
		TicketMachine ticketMachine = TicketMachine.getTicketMachine();
		
	}
	
	// - 자신의 티켓을 꺼내는 기능, TicketMachine 클래스에서 고유한 티켓인지 확인할 때 사용
	Ticket getMyTicket() {
		return ticket;
	}

	// - User 인스턴스의 주소값 출력을 통해 User 인스턴스가 개별 User인지 확인하는 기능
	@Override
	public String toString() {
		return "Serial No." + Integer.toHexString(hashCode());
	}
	
}
