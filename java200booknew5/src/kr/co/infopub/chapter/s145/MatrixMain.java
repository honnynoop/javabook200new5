package kr.co.infopub.chapter.s145;
public class MatrixMain {
	public static void main(String[] args) {
		double [][] m1={{1,2,3},{2,3,4},{3,4,5}};
		Matrix mtr1=new Matrix(m1);
		double [][] m2={{-1,2,-3},{2,-3,4},{-3,4,-5}};
		Matrix mtr2=new Matrix(m2);
		mtr1.print();
		mtr2.print();
		
		Matrix mtr3=mtr1.makeMatrix();  // 깊은 복사
		mtr3.print();
		
		System.out.println(mtr1.equals(mtr3)); // 내용이 일치하지만 주소가 다른 객체
	}
}
