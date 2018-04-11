package kr.co.infopub.chapter.s151.swing;

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
		super();
		this.n = n;
		this.num = num;
		gong=new int[n]; //gong 3°³
		Arrays.fill(gong, -1);
	}
	public int[] getGong() {
		return gong;
	}
	
	public void make(int[] index){
		System.arraycopy(index, 0, gong, 0, index.length);
	}
	
	public void print(){
		System.out.println("Hitter");
		for (int i = 0; i < n; i++) {
			System.out.printf("%d\t",gong[i]);
		}
		System.out.println();
	}
}
