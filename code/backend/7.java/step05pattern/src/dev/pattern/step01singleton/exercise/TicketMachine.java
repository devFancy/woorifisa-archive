package dev.pattern.step01singleton.exercise;

import java.util.UUID;

/*
 * ☆ -- TicketMachine - 티켓을 발행해주는 기계 -- ☆
 */

public class TicketMachine {
	int MAX_TICKET_LIMIT; // - 발행 가능한 최대 티켓 수
	int currentTicketCount; // - 현재까지 발급된 티켓 수
	long[] VALID_SERIAL_NUMBERS; // - 유효한 티켓 번호만 보관하고 있는 배열
	private static TicketMachine ticketMachine = new TicketMachine();
	
	
	// ticketMachine 를 가져옴..
	public static TicketMachine getTicketMachine() {
		return ticketMachine;
	}
	
	
	// 티켓을 발급해주는 기능
	public Ticket getTicket() {
		 Ticket ticket = new Ticket();
	}

	// 티켓 머신 인스턴스 취득
	TicketMachine operateTicketMachine() {
		
	}

	// 전달받은 티켓이 유효한지 검증해주는 기능
	void checkValidTicket(Ticket ticket) {

	}

	// 티켓 발행기의 고유번호를 확인할 수 있는 기능
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
