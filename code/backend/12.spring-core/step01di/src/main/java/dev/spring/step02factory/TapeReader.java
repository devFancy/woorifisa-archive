package dev.spring.step02factory;

// 비디오 테이프를 읽어주는 기계
public class TapeReader {
    // 테이프를 테스트하기 위해 Tape 타입을 필드로 가지고 있음
    Tape tape;

    // 테이프를 테스트하는 메서드
    public void test() {
        // 테이프를 테스트하기 위해 테이프 생성
        tape = new Tape("아일랜드", true);

        if(tape.isWorked()) {
            System.out.println(tape.getName() + " 정상 동작합니다.");
        } else {
            System.out.println(tape.getName() + " 사기 당했습니다..");
        }
    }
}
