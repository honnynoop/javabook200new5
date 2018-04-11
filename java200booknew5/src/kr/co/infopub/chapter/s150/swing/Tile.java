package kr.co.infopub.chapter.s150.swing;

public class Tile {
	
	private int tileNum=0;//0~15 갖고 있는 번호
	private int row;//그림 행 위치
	private int col;//그림 행 위치
	
	//0  1	2	3
	//4	 5	6	7
	//8	 9	10	11
	//12 13	14	15 ==>15를 empty

	@Override
	public String toString() {
		//return String.format("%2d(%d,%d)",tileNum,row,col);
		return String.format("%2d",tileNum);
	}
	public Tile(int tileNum, int row, int col) {
		super();
		this.tileNum = tileNum;
		this.row = row;
		this.col = col;
	}
	public Tile( int row, int col) {
		this(15,row,col);
	}
	public Tile( ) {
		this(15,3,3);
	}
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getTileNum() {
		return tileNum;
	}
	public void setTileNum(int tileNum) {
		this.tileNum = tileNum;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + tileNum;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		Tile other = (Tile) obj;
//		return getTileNum()==other.getTileNum()?true:false;
//	}
}
