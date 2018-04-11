package kr.co.infopub.chapter.s148;
import java.util.Arrays;
public class Matrix {
	private double [][] matrix;
	public Matrix(int m, int n) {
		matrix=new double[m][n];
	}
	public Matrix() {
		this(3,3);
	}
	public Matrix(Matrix mat) {
		this(mat.getMatrix());
	}
	public Matrix(double[][] deep) {
		matrix=deepCopy(deep);
	}
	public  void clear(){
		int m=matrix.length;
		for (int i = 0; i < m; i++) {
			Arrays.fill(matrix[i], 0);
		}
	}
	private double[][] deepCopy(double[][] deep){
		int m=deep.length;
		int n=deep[0].length;
		double[][] paste=new double[m][n];
		for (int i = 0; i <m; i++) {
			System.arraycopy(deep[i], 0, paste[i], 0, n);
		}
		return paste;
	}
	public double[][] getMatrix() {
		return deepCopy(matrix);
	}
	
	public Matrix makeMatrix(){
		return new Matrix(matrix);
	}
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < matrix.length; i++) {
			sb.append("[");
			for (int j = 0; j < matrix[i].length; j++) {
				sb.append(matrix[i][j]+"\t");
			}
			sb.append("]");
			sb.append("\n");
		}
		return sb.toString();
	}
	public void print(){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%f\t",matrix[i][j]);
			}
			System.out.println();
		}
	}
}