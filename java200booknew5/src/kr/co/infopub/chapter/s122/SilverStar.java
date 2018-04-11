package kr.co.infopub.chapter.s122;
public class SilverStar {
 public static void  stepDia(int n){
	for (int i = 0; i < n ; i++) {
		for (int j = 0; j <Math.abs(i-n/2)  ; j++) {
			System.out.printf(" ");
		}
		for (int k= 0; k <n-2*Math.abs(i-n/2) ; k++) {
			System.out.printf("*");
		}
		System.out.println();
	}
 }
 public static void main(String[] args) {
	 SilverStar.stepDia(9);
 }
 public static void  stepDown(int n){
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i+1 ; j++) {
			System.out.printf("*");
		}
		System.out.println();
	}
 }//
 public static void  stepUp(int n){
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <n-1-i  ; j++) {
			System.out.printf("   ");
		}
		for (int k= 0; k <i+1; k++) {
			System.out.printf("¨Í");
		}
		System.out.println();
	}
 }//
 public static void  stepTri(int n){
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <n-1-i  ; j++) {
			System.out.printf("   ");
		}
		for (int k= 0; k <2*i+1; k++) {
			System.out.printf("¨Í");
		}
		System.out.println();
	}
  }
  public static void  stepRevTri(int n){
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <i  ; j++) {
			System.out.printf("   ");
		}
		for (int k= 0; k <2*n-1-2*i ; k++) {
			System.out.printf("¨Í");
		}
		System.out.println();
	}
 }
}