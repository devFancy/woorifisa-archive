package dev.syntax.step02logging.step03slf4j;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySlf4j {

	private static Logger logger = LoggerFactory.getLogger(MySlf4j.class);

	/*
	 * Error > Warn > Info > Debug > Trace ⛔️ Error : 예상하지 못한 심각한 문제가 발생하는 경우, 즉시
	 * 조취를 취해야 할 수준의 레벨 ⚠ ️Warn : 로직 상 유효성 확인, 예상 가능한 문제로 인한 예외 처리, 당장 서비스 운영에는 영향이
	 * 없지만 주의해야 할 부분 ✅ Info : 운영에 참고할만한 사항, 중요한 비즈니스 프로세스가 완료됨 ⚙️ Debug : 개발 단계에서
	 * 사용하며, SQL 로깅을 할 수 있음 📝 Trace : 모든 레벨에 대한 로깅이 추적되므로 개발 단계에서 사용함 ref.
	 * https://tecoble.techcourse.co.kr/post/2021-08-07-logback-tutorial/
	 */

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("FirstLogger");
		System.out.print("Which doctor do you prefer?\n");
		Scanner in = new Scanner(System.in);
		String doctorName = in.next();
		String[] doctor = { "Joe", "Helen", "Chandler", "John" };
		String[] days = { "Monday", "Wednesday", "Thursday", "Saturday" };
		boolean doctorFound = false;
		boolean dayFound = false;
		for (String s : doctor) {
			if (s.equals(doctorName)) {
				System.out.print("Found the doctor!\n");
				logger.info("Doctor found: " + doctorName);
				doctorFound = true;
				break;
			}
		}
		if (doctorFound) {
			System.out.println("When do you want to schedule your appointment?");
			String dayPicked = in.next();
			for (String p : days) {
				if (p.equals(dayPicked)) {
					System.out.println("You are booked for " + dayPicked);
					logger.info("Appointment booked on " + dayPicked);
					dayFound = true;
					System.exit(0);
				}
			}
			if (dayFound == false) {
				logger.error("Sorry, we are not available on that day.");
				logger.info("Exiting application.");
				System.exit(0);
			}
		} else {
			logger.error("Invalid doctor name");
		}
		logger.info("Exiting application.");
		System.exit(0);
	}
}
