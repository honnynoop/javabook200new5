package kr.co.infopub.chapter.s147;
// 행렬연산 역행렬
public class MatrixUtil {
 public static Matrix addMatrix(Matrix a, Matrix b){
	int m=a.getMatrix().length;
	int n=a.getMatrix()[0].length;
	double [][]c=new double[m][n];
	for (int i = 0; i < c.length; i++) {
		for (int j = 0; j < c[i].length; j++) {
			c[i][j]=a.getMatrix()[i][j]+b.getMatrix()[i][j];
		}
	}
	return new Matrix(c);
 }//
 public static Matrix diffMatrix(Matrix a, Matrix b){
	int m=a.getMatrix().length;
	int n=a.getMatrix()[0].length;
	double [][]c=new double[m][n];
	for (int i = 0; i < c.length; i++) {
		for (int j = 0; j < c[i].length; j++) {
			c[i][j]=a.getMatrix()[i][j]-b.getMatrix()[i][j];
		}
	}
	return new Matrix(c);
 }//
 public static Matrix mulMatrix(Matrix a, Matrix b){
	int m=a.getMatrix().length;
	int n=a.getMatrix()[0].length; 
	int p=b.getMatrix()[0].length;
	double [][]c=new double[m][p];
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < p; j++) {
			for (int k = 0; k < n; k++) {
				c[i][j]+=a.getMatrix()[i][k]*b.getMatrix()[k][j];
			}
		}
	}
	return new Matrix(c);
 }//
 // Gaus 소거법 -역행렬
 public static Matrix revMatrix(Matrix a){
	double [][] matricex=a.getMatrix();//깊은 복사
	double [][] matrices=new double[matricex.length][matricex[0].length*2];
	
	for (int i = 0; i < matricex.length; i++) {
		for (int j = 0; j < matricex[i].length; j++) {
			matrices[i][j]=matricex[i][j];
		}
	}
	for (int i = 0; i < matricex.length; i++) {
		matrices[i][i+matricex[i].length]=1.0;
	}
	int row=matrices.length;
	int col=matrices[0].length;//n==0 
	for (int k = 0; k <row; k++) {
		double max=0.0;
		int pivotRow=k;
		for (int j = k; j < row; j++) {
			double tempMax=Math.abs(matrices[j][k]);
			if(max<tempMax){
				max=tempMax;
				pivotRow=j;
			}
		}
		if(k!=pivotRow){
			for (int j = 0; j <col; j++) {
				double temp=matrices[k][j];
				matrices[k][j]=matrices[pivotRow][j];
				matrices[pivotRow][j]=temp;
			}
		}//pivot 
		double pivot=matrices[k][k];
		for (int j = k; j <col; j++) {
			matrices[k][j]/=pivot;      // 1로 만들기
		}
		for (int i = 0; i < row; i++) {
			if(i!=k){
				double delta=matrices[i][k];
				for (int j = k; j <col; j++) {
					matrices[i][j]-=delta*matrices[k][j];
				}
			}
		}
	}
	//System.out.println(matrices);
	double [][] results=new double[matricex.length][matricex.length];
	for (int i = 0; i < matricex.length; i++) {
		for (int j = 0; j < matricex[i].length; j++) {
			results[i][j]=matrices[i][j+matricex[i].length];
		}
	}
	return new Matrix(results);
 }//
 public static Matrix toTwoOne(Matrix a){
	int m=a.getMatrix().length;
	int n=a.getMatrix()[0].length;
	double [][]c=new double[1][m*n];
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			c[0][i*n+j]=a.getMatrix()[i][j];
		}
	}
	return new Matrix(c);
 }
 public static Matrix toOneTwo(Matrix a, int m, int n){
	int l=a.getMatrix()[0].length;
	double [][]c=new double[m][n];
	for (int i = 0; i < l; i++) {
		c[i/n][i%n]=a.getMatrix()[0][i];
	}
	return new Matrix(c);
 }
}