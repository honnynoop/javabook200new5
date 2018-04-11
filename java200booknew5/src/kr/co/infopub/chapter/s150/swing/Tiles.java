package kr.co.infopub.chapter.s150.swing;
public class Tiles {

	private int n=4; //nxn 퍼즐 만들기
	private Tile[][] tile;
	private SongPuzzle puzzle;
	//테스트용
	private boolean isTest=false;
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}

	public Tiles() {
		this(4);
	}
	public Tiles(int n) {
		this.n=n;
	}

	public void make(){
		tile=new Tile[n][n];
		puzzle=new SongPuzzle(n);
		//puzzle.init(n);//0~15
		puzzle.makePuzzle(isTest);
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < n; j++) {
				int num=puzzle.getPuzzle(i, j);
				tile[i][j]=new Tile(num,i,j);
			}
		}
	}
	
	public Tile getTile(int r, int c){
		return tile[r][c];
	}

	public Tile[][] getTile() {
		return tile;
	}
	public void print(){
		System.out.println("in tiles");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				 System.out.printf("%s\t",tile[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Tiles tiles =new Tiles(4);
		tiles.setTest(true);
		tiles.make();
		tiles.print();
	}
}
