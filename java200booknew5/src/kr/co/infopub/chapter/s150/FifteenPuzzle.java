package kr.co.infopub.chapter.s150;
public class FifteenPuzzle {
 private int [][] puzzle;
 private int n;
 public FifteenPuzzle(int n) {
	init(n);
 }
 public FifteenPuzzle() {
	this(4);
 }
 public void init(int n){
	this.n=n;
	puzzle=new int[n][n];
	for (int i = 0; i <n*n ; i++) {
		puzzle[i/n][i%n]=i;
	}//0~n*n-1
 }
 public int getPuzzle(int r, int c){
	return puzzle[r][c];
 }
 private int num(){
	int row=puzzle.length;
	return (int)((row*row)*Math.random());
 }
 public void shuffle(){
	int row=puzzle.length;
	int col=puzzle[0].length;
	int [] sh=new int[row*col];
	FifteenPuzzleUtil.toTwoOne(puzzle, sh);
	for (int i = 0; i < sh.length; i++) {
		int temp=num();
		int mtemp=sh[i];
		sh[i]=sh[temp];
		sh[temp]=mtemp;
	}
	FifteenPuzzleUtil.toOneTwo(sh, puzzle);
 }
 private int invertnumber(){
	int row=puzzle.length;
	int col=puzzle[0].length;
	int [] sh=new int[row*col];
	int location=0;
	FifteenPuzzleUtil.toTwoOne(puzzle, sh);
	for (int i = 0; i < sh.length; i++) {
		if(sh[i]==0){location=i;break;}
	}
	int ivn=0;
	for (int i = 0; i < sh.length-1; i++) {
		for (int j = i+1; j < sh.length; j++) {
			if(i!=location && j!=location && sh[i]>sh[j] ){
				ivn++;
			}
		}
	}
	return ivn;
 }//
 private int zero(){
	int row=puzzle.length;
	int col=puzzle[0].length;
	int [] sh=new int[row*col];
	FifteenPuzzleUtil.toTwoOne(puzzle, sh);
	int znum=0;
	for (int i = 0; i < sh.length; i++) {
		if(sh[i]==0){
			znum=i/col;
			break;
		}
	}
	return znum;
 }
 public int evenpuzle(){
	int num=0;
	int invert=invertnumber();
	num+=invert;
	num+=puzzle.length;
	num+=zero();
	return num;
 }
 public void makePuzzle(boolean show){
	int num=0;
	do{
		shuffle();
		num=evenpuzle();
		if(show){
			if(puzzle.length%2==0 && num%2==1){ //홀수면 가능
				System.out.println("Even Possible Middle!");
				System.out.printf("Row  : %d \n", puzzle.length);
				System.out.printf("IVN  : %d \n", invertnumber());
				System.out.printf("Zero : %d \n", zero());
				System.out.printf("TOT  : %d \n", num);
				System.out.println("---------------------------");
			}else if(puzzle.length%2==0){
				System.out.println("Even Impossible Middle!");
				System.out.printf("Row  : %d \n", puzzle.length);
				System.out.printf("IVN  : %d \n", invertnumber());
				System.out.printf("Zero : %d \n", zero());
				System.out.printf("TOT  : %d \n", num);
				print();
				System.out.println("---------------------------");
			}
		}
	}while((puzzle.length+num)%2==0);
 }
 public void print(){
	int n=puzzle.length;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <n; j++) {
			System.out.printf("%2d\t",puzzle[i][j]);
		}
		System.out.println();
	}
	System.out.println();
 }
 // 테스트용 생성자
 public FifteenPuzzle(int [][] pz) {
	this.n=pz.length;
	init(n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <n; j++) {
			puzzle[i][j]=pz[i][j];
		}
	}
 }
 // 테스트 메서드
 public void testPuzzles(){
	int num=evenpuzle();
	if(puzzle.length%2==0 && num%2==1){//홀수면 가능
		System.out.println("Even Possible Middle!");
		System.out.printf("Row  : %d \n", puzzle.length);
		System.out.printf("IVN  : %d \n", invertnumber());
		System.out.printf("Zero : %d \n", zero());
		System.out.printf("TOT  : %d \n", num);
		System.out.println("---------------------------");
	}else if(puzzle.length%2==0){
		System.out.println("Even Impossible Middle!");
		System.out.printf("Row  : %d \n", puzzle.length);
		System.out.printf("IVN  : %d \n", invertnumber());
		System.out.printf("Zero : %d \n", zero());
		System.out.printf("TOT  : %d \n", num);
		System.out.println("---------------------------");
	}
 }
}//
