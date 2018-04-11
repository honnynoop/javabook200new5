package kr.co.infopub.chapter.s151;
import java.util.Arrays;
import java.util.Scanner;
public class Hitter {
	private int [] gong;
	private int n;//3
	private int num=10;
	public Hitter() {
		this(10,3);
	}
	public Hitter(int num,int n ) {
		this.n = n;
		this.num = num;
		gong=new int[n]; //gong 3개
		Arrays.fill(gong, -1);
	}
	public int[] getGong() {
		return gong;
	}
	public void make(){
		// 과제 => 서로 다르도록 하시오
		System.out.println(
				"0~9 사이의 서로 다른 정수를 붙여서 입력해 주세요. 예)123");
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		//123
		for (int i = 0; i < n; i++) {
			gong[i]=s.charAt(i)-'0';   //'1'-'0'
		}
		
	}
	public void print(){
		System.out.println("Hitter");
		for (int i = 0; i < n; i++) {
			System.out.printf("%d\t",gong[i]);
		}
		System.out.println();
	}
}
