package kr.co.infopub.chapter.s147;
// ¿ªÇà·Ä
public class MatrixMain {
	public static void main(String[] args) {
		double [][] basic={{2,3,1},{4,1,-3},{-1,2,2}};
		double [][] y={{-4},{-2},{2}};
		Matrix A=new Matrix(basic);
		A.print();
		Matrix Y=new Matrix(y);
		Y.print();
		Matrix A_1=MatrixUtil.revMatrix(A);
		A_1.print();
		Matrix E=MatrixUtil.mulMatrix(A_1, A);
		E.print();
		Matrix X=MatrixUtil.mulMatrix(A_1,Y);
		X.print();
	}
}
