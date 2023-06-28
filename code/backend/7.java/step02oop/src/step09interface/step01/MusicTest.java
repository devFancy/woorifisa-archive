package step09interface.step01;

public class MusicTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Audio lpRecord = new Audio(); // 음악 CD
		
		Bts bts = new Bts();
		lpRecord.musicPlay(bts);
//		System.out.println("다음 노래 재생");
//		lpRecord.musicPlay("원하는 음악CD2");
	}

}
