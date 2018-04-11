package kr.co.infopub.chapter.s150;
public class FifteenPuzzleMain {
	public static void main(String[] args) {
		// 15 Game 테스트 
		int[][]m={{1,2,3,4},
		{5,6,0,7},
		{9,10,11,8},
		{13,14,15,12}};
		FifteenPuzzle puzzle=new FifteenPuzzle(m);  // 짝수에 적용가능
		puzzle.testPuzzles();    // 테스트  배열 m 15 Game 가능? 
		puzzle.print();
		// 15 Game 만들기 
		FifteenPuzzle puzzle2=new FifteenPuzzle();  // 짝수에 적용가능
		//puzzle2.makePuzzle(false); // 과정 보이지 않기
		puzzle2.makePuzzle(true);    //과정보이기
		puzzle2.print();
	}
}
