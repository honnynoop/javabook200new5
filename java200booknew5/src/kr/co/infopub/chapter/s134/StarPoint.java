package kr.co.infopub.chapter.s134;
public class StarPoint {
 public static void printStarDecrease(int n){	
	for(int i=0; i<n;i++){
		for(int j=0; j<i;j++){
			System.out.print(" ");
		}
		for(int k=1; k<2*(n-i);k++){
			System.out.print("*");
		}
		System.out.println();
	}
 }
 public static void main(String[] args) {
	 printStarDecrease(5);
 }
 public static void printStarIncrease(int n){
	for(int i=n-1; i>=0;i--){
		for(int j=0; j<i;j++){
			System.out.print(" ");
		}
		for(int k=1; k<2*(n-i);k++){
			System.out.print("*");
		}
		System.out.println();
	}
 }
 public static void printButterfly(int n){
	printStarDecrease(n);
	printStarIncrease(n);
 }
 public static void printDiamond(int n){
	printStarIncrease(n);
	printStarDecrease(n);
 } 
}
