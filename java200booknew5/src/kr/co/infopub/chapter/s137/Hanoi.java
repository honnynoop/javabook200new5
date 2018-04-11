package kr.co.infopub.chapter.s137;
public class Hanoi {
 private int  tray=3;       // 접시 수
 private int  bar=3;        // 막대수는 변경 불가능
 int [][] rings;
 public Hanoi(int tray){
	this.tray=tray;         //접시 수 변경
	rings=new int[tray][bar];
	for(int i=0;i<rings.length;i++){
		int x=2*i+1;
		rings[i][0]=x;
	}
 }
 public int[][] getRings(){
	return rings;
 }     
 public  void moveHanoi(int num, char ringA,char ringB,char ringC){
	if(num==1){
		System.out.println(ringA+" bar쪽에 있던 링이 "+ringB+" bar쪽으로 이동");
	}else {
		moveHanoi(num-1,ringA,ringC,ringB);
		System.out.println(ringA+" bar쪽에 있던 링이 "+ringB+" bar쪽으로 이동");
		moveHanoi(num-1,ringC,ringB,ringA);
	}
 }
}
