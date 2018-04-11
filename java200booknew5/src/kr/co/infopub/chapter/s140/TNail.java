package kr.co.infopub.chapter.s140;
public class TNail {
	private int m;
	private int n;
	private int[][] loc;
	public TNail(int m, int n) {
		super();
		this.m = m;
		this.n = n;
		loc=new int[m][n];
	}
	public void make(){
		int x=0;
		int y=0;
		int d=1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				loc[x][y]=i*n+j+1;//넣고
					if(d==0){  
						//2) 오른쪽이동
						if(y+1<n && loc[x][y+1]==0){
							y++;  // 오른쪽
						}else{    // 오른쪽 벽또는 숫자
							d=3;  
							x--;  // 위로
						}
					} else if(d==1){
					//1) 아래로 내려가자
					if(x+1<n && loc[x+1][y]==0){
						x++; // 아래로
					}else{   // 아래쪽 벽또는 숫자
						d=0; 
						y++; // 오른쪽
					}
				}else if(d==2){
					//4)왼쪽이동
					if(y-1>=0 && loc[x][y-1]==0){
						y--; // 왼쪽
					}else{   // 왼쪽 벽또는 숫자
						d=1;
						x++; // 아래
					}
				}else if(d==3){
					//3)위로 올라가자
					if(x-1>=0 && loc[x-1][y]==0){
						x--; // 위로
					}else{   // 위쪽 벽또는 숫자
						d=2; 
						y--; // 왼쪽
					}
				}
			}
		}
	}
	public void print(){
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
//				System.out.printf("(%2d:[%d,%d])",
//				loc[i][j],i,j);
				System.out.printf("(%2d)",loc[i][j]);
			}
			System.out.println();
		}
	}
}
