package kr.co.infopub.chapter.s138;
public class HanoisMain {
	public static void main(String[] args) {
		int tray=4;
		Hanoi ha=new Hanoi(tray);  
		int [][] a=ha.getRings();
		HanoisUtil.showHanoi(a);
		HanoisUtil.moveHanoi(a,tray,'a','b','c');
	}
}
