package kr.co.infopub.chapter.s151;
public class HyoBaseballMain {
 public static void main(String[] args) {
	Pitcher pit=new Pitcher();      // 공 던지는 투수
	Hitter hit=new Hitter();        // 공 치는 타자
	Umpire ump=new Umpire();        // 스트라이크, 볼 심판
	int iterCount=0;                // 10번 이내에 끝내기
	pit.make();                     // 공 던지기
	ump.setPitBall(pit.getGong());  // 심판에게 투수공 넣기
	System.out.println("Play Base Ball~~~~~~~");
	while(true){
		iterCount++;
		hit.make();           // 타자 - 공맞추기
		System.out.printf("%d번째 입려한 공 : %d,%d,%d\n",
			 iterCount,hit.getGong()[0],hit.getGong()[1],hit.getGong()[2]);
		ump.setHitBall(hit.getGong());  // 심판에게 타자공 넣기
		int strike=ump.strike();
		int ball=ump.ball();
		System.out.printf("%d번째  %dstrike %dball\n",iterCount,strike, ball);
		if(iterCount<10 && strike==3){   // 3 스트라이크- 모두 맞춤
			System.out.println("You Win!!");
			break;
		}else if(iterCount>=10 && strike<3){
			System.out.println("You Lose!!");
			System.out.printf("투수 : %d,%d,%d\n",
					   pit.getGong()[0],pit.getGong()[1],pit.getGong()[2]);
			break;
		}
	}
 }
}
