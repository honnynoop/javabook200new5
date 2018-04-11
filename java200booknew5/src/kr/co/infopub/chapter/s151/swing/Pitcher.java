package kr.co.infopub.chapter.s151.swing;

import java.util.Arrays;

public class Pitcher {

	private int [] gong;
	private int n;//3
	private int num=10;
	public Pitcher() {
		this(10,3);
	}
	public Pitcher(int num,int n ) {
		super();
		this.n = n;
		this.num = num;
		gong=new int[n]; //gong 3°³
		Arrays.fill(gong, -1);
	}
	public int[] getGong() {
		return gong;
	}
	//0~9
	public int makeOne(){
		return (int)(Math.random()*num);
	}
	
	public boolean contains(int gn){
		boolean isC=false;
		for (int i = 0; i < n; i++) {
			if(gn==gong[i]){
				isC=true;
				break;
			}
		}
		return isC;
	}
	
	public void make(){
		Arrays.fill(gong, -1);
		int count=0;
		while(count!=n){
			int temp=makeOne();
			if( !contains(temp) ){
				gong[count++]=temp;
			}
		}
	}
	
	public void print(){
		System.out.println("Pitcher");
		for (int i = 0; i < n; i++) {
			System.out.printf("%d\t",gong[i]);
		}
		System.out.println();
	}
	
	
	
}
