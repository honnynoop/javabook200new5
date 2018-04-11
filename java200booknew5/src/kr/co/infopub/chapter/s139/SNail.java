package kr.co.infopub.chapter.s139;
public class SNail {
	private int m;
	private int n;
	private int[][] loc;
	public SNail(int m, int n) {
		super();
		this.m = m;
		this.n = n;
		loc=new int[m][n];
	}
	public void make(){
		int x=0;
		int y=0;
		int d=0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				loc[x][y]=i*n+j+1;//넣고
				if(d==0){  // 오른쪽으로 이동
					if(y+1<n && loc[x][y+1]==0){
						y++;
					}else{    // 오른쪽 벽이나 숫자
						d=1;  // 아래
						x++;  // 0,5(y++)=>0,6(x++)->1,6
					}
				} else if(d==1){ //아래로 이동
					if(x+1<n && loc[x+1][y]==0){
						x++;  // 아래로
					}else{    // 아래 벽이나 숫자
						d=2;  // 왼쪽으로
						y--;  // 5,6(x++)=>6,6(y--)->6,5
					}
				}else if(d==2){ // 왼쪽으로
					if(y-1>=0 && loc[x][y-1]==0){
						y--;  // 왼쪽으로
					}else{    // 왼쪽 벽이나 숫자
						d=3;  // 위로
						x--;  // 6,1(y--)=>6,0(x--)->5,0
					}
				}else if(d==3){
					if(x-1>=0 && loc[x-1][y]==0){
						x--;  // 위로 이동
					}else{    // 위쪽벽이나 숫자
						d=0;  // 오른쪽
						y++;  // 2,0(x--)=>1,0(y++)->1,1
					}
				}
			}
		}
	}
	public void print(){
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				//System.out.printf("(%2d:[%d,%d])",loc[i][j],i,j);
				System.out.printf("(%2d)",loc[i][j]);
			}
			System.out.println();
		}
	}
}
