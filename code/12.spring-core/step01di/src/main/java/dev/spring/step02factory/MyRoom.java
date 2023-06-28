package dev.spring.step02factory;
public class MyRoom {
    public static void main(String[] args) {
        // MyRoom에서 TapeReader에 대한 의존성을 낮추는 방법
        // -> MyRoom.java에서 new를 사용하지 않고, Tapereader를 생성하여 사용하는 방법

        // 제약조건: MyRoom에서 new TapeReader()만 안쓰면 됨
        // 힌트: 팩토리(Factory)
        // 팩토리 메서드: 객체를 생성하는 쪽(Factory.java)과 사용하는 쪽(MyRoom.java)을 분리
        TapeReader reader = TapeReaderFactory.createTapeReader();

        reader.test();
    }
}
