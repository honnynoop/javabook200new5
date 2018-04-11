package kr.co.infopub.chapter.s150;
public class SongPuzzleUtil {
	//2차원 배열을 1차원 배열로 바꾸기
	public static void toTwoOne(int[][] org, int[] tar ){
		int row=org.length;
		int col=org[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				tar[i*col+j]=org[i][j];
			}
		}
	}
	//1차원 배열을 2차원 배열로 바꾸기
	public static void toOneTwo(int[] org, int[][] tar ){
		int n=org.length;
		int col=tar[0].length;
		for (int i = 0; i < n; i++) {
			tar[i/col][i%col]=org[i];
		}
	}
}
