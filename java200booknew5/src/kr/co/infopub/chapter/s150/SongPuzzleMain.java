package kr.co.infopub.chapter.s150;
import java.util.Scanner;
public class SongPuzzleMain {
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int n=scann.nextInt();
		System.out.println("2이상의 정수를 입력하세요.");
		SongPuzzle puzzle=new SongPuzzle(n);  //홀수, 짝수에 모두 적용가능
		//puzzle.makePuzzle(false); // 과정 보이지 않기
		puzzle.makePuzzle(true);    // 과정 보이기
		puzzle.print();
	}
}
