package dev.spring.step02factory;

public class TapeReaderFactory {

    public static TapeReader createTapeReader() {
        return new TapeReader();
    }

}
