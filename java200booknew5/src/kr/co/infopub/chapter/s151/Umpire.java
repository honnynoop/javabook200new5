package kr.co.infopub.chapter.s151;
import java.util.Arrays;
public class Umpire {
	private int [] pitBall;
	private int [] hitBall;
	private int n;
	public Umpire(int n) {
		this.n=n;
		pitBall=new int[n];
		hitBall=new int[n];
		Arrays.fill(pitBall, -1);
		Arrays.fill(hitBall, -1);
	}
	public Umpire() {
		this(3);
	}
	public void setPitBall(int[] pitBall) {
		System.arraycopy(pitBall, 0,
				this.pitBall, 0, pitBall.length);
	}
	public void setHitBall(int[] hitBall) {
		System.arraycopy(hitBall, 0,
				this.hitBall, 0, hitBall.length);
	}
	public int strike(){
		int count=0;
		for (int i = 0; i < n; i++) {
			if(pitBall[i]==hitBall[i]){
				count++;
			}
		}
		return count;
	}
	public int ball(){
		int count=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i!=j && pitBall[i]==hitBall[j]){
					count++;
				}
			}
		}
		return count;
	}
}
