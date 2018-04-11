package kr.co.infopub.chapter.s146;
// 행렬연산
public class MatrixMain {
	public static void main(String[] args) {
		double [][] basic={{1,2,3},{4,5,6},{7,8,9}};
		Matrix s0=new Matrix(basic);
		s0.print();
		double [][] x2={{0,1,0},{0,0,1},{1,0,0}};
		double [][] x1={{0,0,1},{1,0,0},{0,1,0}};
		
		Matrix mx2=new Matrix(x2);
		Matrix mx1=new Matrix(x1);
		
		Matrix s1=MatrixUtil.mulMatrix(mx2, s0);
		s1.print();
		Matrix s2=MatrixUtil.mulMatrix(mx1, s0);
		s2.print();
		Matrix s3=MatrixUtil.mulMatrix( s0,mx1);
		s3.print();
	}
}
