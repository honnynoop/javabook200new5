package kr.co.infopub.chapter.s149;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
// 연산자 오러로딩은 없다.
public class Sudoku {
	boolean isShuffle=true;
	double [][] sdoku;
	double [][] basic;
	int n;
	public Sudoku(int n) {
		this.n=n;
		sdoku=new double[n*n][n*n];
		basic=new double[n][n];
	}
	public Sudoku() {
		this(3);
	}
	private void clear(){
		int m=sdoku.length;
		for (int i = 0; i < m; i++) {
			Arrays.fill(sdoku[i], 0);
		}
	}
	
	public boolean isShuffle() {
		return isShuffle;
	}
	public void setShuffle(boolean isShuffle) {
		this.isShuffle = isShuffle;
	}
	private void init(){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <n; j++) {
				basic[i][j]=i*n+j+1;
				sdoku[i][j]=basic[i][j];
			}
		}
	}
	public void print2(){
		System.out.println(new Matrix(sdoku));
	}
	public void print(){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < sdoku.length; i++) {
			sb.append("[\t");
			for (int j = 0; j < sdoku[i].length; j++) {
				sb.append((int)sdoku[i][j]+"\t");
			}
			sb.append("]");
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	private void shuffle(){
		if(isShuffle()){
			Matrix msdo=MatrixUtil.toTwoOne(new Matrix(basic));
			double[][]mms=msdo.getMatrix();//1x9
			ArrayList<Double> list=new ArrayList<Double>();
			for (int i = 0; i < mms[0].length; i++) {
				list.add(mms[0][i]);
			}
			Collections.shuffle(list);
			for (int i = 0; i < mms[0].length; i++) {
				mms[0][i]=list.get(i);
			}
			msdo=MatrixUtil.toOneTwo(new Matrix(mms),n,n);
			basic=msdo.getMatrix();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <n; j++) {
					sdoku[i][j]=basic[i][j];
				}
			}
		}
	}
	public void make(){
		clear();
		init();
		shuffle();
		makeS1();
		makeS2();
		makeS3();
		makeS4();
		makeS5();
		makeS6();
		makeS7();
		makeS8();
	}
	private double [][] x2={{0,1,0},{0,0,1},{1,0,0}};
	private double [][] x1={{0,0,1},{1,0,0},{0,1,0}};
	public void makeS1(){
		Matrix s0=new Matrix(basic);
		Matrix s1=MatrixUtil.mulMatrix( new Matrix(x2),s0);
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i][j+n]=s1.getMatrix()[i][j];
			}
		}
	}
	public void makeS2(){
		Matrix s0=new Matrix(basic);
		Matrix s2=MatrixUtil.mulMatrix( new Matrix(x1),s0);
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i][j+2*n]=s2.getMatrix()[i][j];
			}
		}
	}
	public void makeS3(){
		Matrix s0=new Matrix(basic);
		Matrix s3=MatrixUtil.mulMatrix( s0,new Matrix(x1));
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i+n][j]=s3.getMatrix()[i][j];
			}
		}
	}
	public void makeS4(){
		Matrix s0=new Matrix(basic);
		Matrix s1=MatrixUtil.mulMatrix( new Matrix(x2),s0);
		Matrix s4=MatrixUtil.mulMatrix( s1,new Matrix(x1));
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i+n][j+n]=s4.getMatrix()[i][j];
			}
		}
	}
	public void makeS5(){
		Matrix s0=new Matrix(basic);
		Matrix s1=MatrixUtil.mulMatrix( new Matrix(x1),s0);
		Matrix s5=MatrixUtil.mulMatrix( s1,new Matrix(x1));
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i+n][j+2*n]=s5.getMatrix()[i][j];
			}
		}
	}
	public void makeS6(){
		Matrix s0=new Matrix(basic);
		Matrix s6=MatrixUtil.mulMatrix( s0,new Matrix(x2));
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i+2*n][j]=s6.getMatrix()[i][j];
			}
		}
	}
	public void makeS7(){
		Matrix s0=new Matrix(basic);
		Matrix s1=MatrixUtil.mulMatrix( new Matrix(x2),s0);
		Matrix s7=MatrixUtil.mulMatrix( s1,new Matrix(x2));
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i+2*n][j+n]=s7.getMatrix()[i][j];
			}
		}
	}
	public void makeS8(){
		Matrix s0=new Matrix(basic);
		Matrix s1=MatrixUtil.mulMatrix( new Matrix(x1),s0);
		Matrix s8=MatrixUtil.mulMatrix( s1,new Matrix(x2));
		for (int i = 0; i < n; i++) {
			for (int j =0; j <n; j++) {
				sdoku[i+2*n][j+2*n]=s8.getMatrix()[i][j];
			}
		}
	}
}
