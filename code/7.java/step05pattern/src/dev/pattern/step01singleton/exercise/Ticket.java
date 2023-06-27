package dev.pattern.step01singleton.exercise;

/*
 * ☆ -- Ticket - 티켓 추상 클래스 -- ☆
 */

public abstract class Ticket {
	long serialNumber; // - 티켓 고유번호
	
	// 티켓의 고유 번호를 확인할 수 있는 기능
	protected Ticket(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public long getSerialNumber() {
		return serialNumber;
	}
}
