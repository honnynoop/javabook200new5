package kr.co.infopub.chapter.s151.swing;

public class BallData {

	private int round;
	private int ball1;
	private int ball2;
	private int ball3;
	private int strike;
	private int ball;
	public BallData() {

	}
	public BallData(int round, int ball1, int ball2, int ball3, int strike,
			int ball) {
		super();
		this.round = round;
		this.ball1 = ball1;
		this.ball2 = ball2;
		this.ball3 = ball3;
		this.strike = strike;
		this.ball = ball;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getBall1() {
		return ball1;
	}
	public void setBall1(int ball1) {
		this.ball1 = ball1;
	}
	public int getBall2() {
		return ball2;
	}
	public void setBall2(int ball2) {
		this.ball2 = ball2;
	}
	public int getBall3() {
		return ball3;
	}
	public void setBall3(int ball3) {
		this.ball3 = ball3;
	}
	public int getStrike() {
		return strike;
	}
	public void setStrike(int strike) {
		this.strike = strike;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	@Override
	public String toString() {
		return "BallData [round=" + round + ", ball1=" + ball1 + ", ball2="
				+ ball2 + ", ball3=" + ball3 + ", strike=" + strike + ", ball="
				+ ball + "]";
	}
	
	

}
