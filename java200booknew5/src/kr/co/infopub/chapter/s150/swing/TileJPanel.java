package kr.co.infopub.chapter.s150.swing;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TileJPanel extends JPanel implements MouseListener, ActionListener{
	//테스트용
	private boolean isTest=false;
	//private String imageUrl="Lighthouse.jpg";
	private String imageUrl="Penguins.jpg";

	private JFrame mainFrame;
	private JMenuBar mainBar=new JMenuBar();
	private JMenu fileMenu=new JMenu("FILE");
	private JMenuItem exitItem=new JMenuItem("EXIT");
	private JMenuItem newItem=new JMenuItem("NEW");
	
	private JMenu numMenu=new JMenu("NUM");
	private JMenuItem twoItem=new JMenuItem("2");
	private JMenuItem threeItem=new JMenuItem("3");
	private JMenuItem fourItem=new JMenuItem("4");
	private JMenuItem fifthItem=new JMenuItem("5");
	
	
	private  int ITERNUMBER;
	private int startX=0;//펭귄의 시작부분
	private int startY=0;
	private int count=0;//클릭수
	private int n=4;
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	private Tiles tiles;
	
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public TileJPanel(JFrame mainFrame, int n) {
		this.mainFrame=mainFrame;
		this.n=n;
		ITERNUMBER=n*n;//16
		makeMenu();
		tiles=new Tiles(n);
		tiles.setTest(isTest);
		tiles.make();
		addMenuListener();
		//------------------------------
		this.setSize(this.n*100,this.n*100);
	}//
	public TileJPanel(JFrame mainFrame) {
		this(mainFrame,4);
	}//
	public void addMenuListener(){
		this.addMouseListener(this);
		exitItem.addActionListener(this);
		newItem.addActionListener(this);
		threeItem.addActionListener(this);
		fourItem.addActionListener(this);
		fifthItem.addActionListener(this);
		twoItem.addActionListener(this);
	}
	private void makeMenu() {
		mainBar.add(fileMenu);
		fileMenu.add(newItem);//new
		fileMenu.add(exitItem);//exit
		mainBar.add(numMenu);
		
		numMenu.add(twoItem);//2
		numMenu.add(threeItem);//3
		numMenu.add(fourItem);//4
		numMenu.add(fifthItem);//5
		mainFrame.setJMenuBar(mainBar);
	}
	public void setTest(boolean isTest) {
		this.isTest = isTest;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public void restart(){
		tiles.make();
		tiles.setTest(isTest);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(!isGameOver()){
			if(isTest){
				//--테스트용
				SongPuzzle testposs=new SongPuzzle(tiles.getTile());
				testposs.makeTestPuzzle(true);
				testposs.print();
				//--테스트용
			}
			for (int i = 0; i<n; i++) {
				for (int j = 0; j < n; j++) {
					Tile tt=tiles.getTile(i, j);
					int num=tt.getTileNum();
					int mt=num-1;
					if(mt==-1){mt=n*n-1;}//1~15 0--> 0~14, 15
					//1~8 0-->0~7 8
					int x=(mt)/n;
					int y=(mt)%n;
					Image img=fromTiles(i,j,x,y);
					g.drawImage(img,
							(j)*TileUtil.TILESIZE, 
							(i)*TileUtil.TILESIZE
							,null);
					if(isTest){
						g.setFont(new Font(Font.SERIF, Font.PLAIN, 10));
						g.drawString(num+"("+i+","+j+")", 
								(j)*TileUtil.TILESIZE, 
								(i)*TileUtil.TILESIZE+20);
					}
					if(isTest){
						g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
						g.drawString(""+count+"Move!",
								n*TileUtil.TILESIZE/2-30,n*TileUtil.TILESIZE/2);
					}
					printchangeTilesf(hasEmpty(i, j)+String.format("[%d]", num)+"\t\t");
				}
				printchangeTiles("");
			}
			printchangeTiles("");
			
		}else{
			for (int i = 0; i<n; i++) {
				for (int j = 0; j <n; j++) {

					Image img=fromTiles(i,j);
					g.drawImage(img,
							(j)*TileUtil.TILESIZE, 
							(i)*TileUtil.TILESIZE
							,null);
					
				}
			}
			g.setFont(new Font(Font.SERIF, Font.BOLD, 30));
			g.drawString(""+count+"Move!",n*TileUtil.TILESIZE/2-30,n*TileUtil.TILESIZE/2);
		}
		//updateUI();
	}
	//배열좌표
	public Image fromTiles(int i, int j, int x, int y){
		Tile t=tiles.getTile(i, j);
		Image img=null;
		if(t.getTileNum()==0){
			img=ImageUtiil.getImage(getUrl("white.jpg"));
		}else{
			//그림좌표
			img=getPhotoImage(y, x,startX,startY);
		}
		return img;
	}
	public Image fromTiles(int i, int j){
		Image img=getPhotoImage(j, i,startX,startY);
		return img;
	}
	
	public Image getPhotoImage(int x, int y){//0~3 0~3
		return getPhotoImage(x,y,0,0);
	}
	public Image getPhotoImage(int x, int y, int moveX, int moveY){//0~3 0~3
		return getPhotoImage(imageUrl,x,y,moveX,moveY);
	}
	public Image getPhotoImage(String url,int x, int y, int moveX, int moveY){//0~3 0~3
		Image img=ImageUtiil.getImage(getUrl(url));
		BufferedImage bufimg=ImageUtiil.fromImage(img, 0,0,
				n*TileUtil.TILESIZE+moveX,
				n*TileUtil.TILESIZE+moveY );
		BufferedImage subimg=ImageUtiil.getSubBufferedImage(bufimg, 
				moveX+TileUtil.TILESIZE*x,
				moveY+TileUtil.TILESIZE*y, 
				TileUtil.TILESIZE, 
				TileUtil.TILESIZE);
		Image madeImg=ImageUtiil.fromImgBuffer(subimg);
		return madeImg;
	}
	public String getUrl(String str){
		return ImageUtiil.imgUrl+str;
	}
	//배열좌표
	public boolean isGameOver(){
		boolean isGameOver=true;//모두 같으면 
		for (int i = 0; i<ITERNUMBER-1; i++) {
			Tile t=this.tiles.getTile(i/n, i%n);
			printchangeTilesf(String.format("%d(%d,%d)\t",
					t.getTileNum(),i/n, i%n));
			if(t.getTileNum()!=i+1){//1~15 0(0은 끝)
				isGameOver=false;
				break;
			}
		}
		printchangeTiles("");
		return isGameOver;
	}
	//배열좌표
	public boolean isProper(int x, int y){
		return (x>=0 && x<n) && (y>=0 && y<n);
	}
	//배열 좌표
	public boolean isEmpty(int x, int y){
		Tile t=this.tiles.getTile(x, y);
		//num이 같으면 같은 객체로 오버로딩
		//return t.equals(new Tile(0,0,0))?true:false;
		return t.getTileNum()==0?true:false;
	}//
	//배열좌표
	public boolean hasEmpty(int x, int y){
		boolean isS=false;
		if(!isEmpty(x, y)){//나는0가 아니면서 주변에 0가 있니
			if(isProper(x, y+1) && isEmpty(x, y+1)){//left
				isS=true;
			}else if(isProper(x+1, y) && isEmpty(x+1, y)){//up
				isS=true;
			}else if(isProper(x, y-1) && isEmpty(x, y-1)){//right
				isS=true;
			}else if(isProper(x-1, y) && isEmpty(x-1, y)){//down
				isS=true;
			}
		}
		return isS;
	}//
	public void printchangeTiles(String s){
		if(isTest){
			System.out.println(s);
		}
	}
	public void printchangeTilesf(String s){
		if(isTest){
			System.out.printf(s);
		}
	}
	//배열좌표
	public void move(int x ,int y){
		if(isProper(x, y+1) && isEmpty(x, y+1)){//left
			changeTiles(x,y,x, y+1);
			printchangeTiles("R"+String.format("(%d,%d)", x,y));
		}else if(isProper(x+1, y) && isEmpty(x+1, y)){//up
			changeTiles(x,y,x+1, y);
			printchangeTiles("D"+String.format("(%d,%d)", x,y));
		}else if(isProper(x, y-1) && isEmpty(x, y-1)){//right
			changeTiles(x,y,x, y-1);
			printchangeTiles("L"+String.format("(%d,%d)", x,y));
		}else if(isProper(x-1, y) && isEmpty(x-1, y)){//down
			changeTiles(x,y,x-1, y);
			printchangeTiles("U"+String.format("(%d,%d)", x,y));
		}
	}//
	//배열좌표
	public void changeTiles(int x1,int y1, int x2, int y2){
		//위치는 변경하지 말고 번호값만 바꾸자
		int temp=tiles.getTile()[x1][y1].getTileNum();
		tiles.getTile()[x1][y1].setTileNum(tiles.getTile()[x2][y2].getTileNum());
		tiles.getTile()[x2][y2].setTileNum(temp);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(!isGameOver()){
			//그림좌표 얻기->배열좌표로 변환 => 중요
			int y=e.getX()/TileUtil.TILESIZE;
			int x=e.getY()/TileUtil.TILESIZE;
			Tile t=this.tiles.getTile(x, y);// 배열좌표로
			printchangeTiles(String.format("%d[%d,%d]",t.getTileNum(),x,y));
			if( hasEmpty(x,y) ){
				move(x,y);
				count++;
			}
			if(isTest){
				tiles.print();
			}
			this.repaint();//paint 호출
		}
	}//
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.newItem){
			this.count=0;
			tiles.setTest(isTest);
			this.tiles.make();
			setJFramSize(n,n);
			printchangeTiles("newItem :"+n);
		}else if(e.getSource()==this.exitItem){
			System.exit(-1);
		}else if(e.getSource()==this.threeItem){
			onItemAction(3);
			printchangeTiles("threeItem :"+n);
		}else if(e.getSource()==this.fourItem){
			onItemAction(4);
			printchangeTiles("fourItem :"+n);
		}else if(e.getSource()==this.fifthItem){
			onItemAction(5);
			printchangeTiles("fifthItem :"+n);
		}else if(e.getSource()==this.twoItem){
			onItemAction(2);
			printchangeTiles("twoItem :"+n);
		}
	}//
	public void onItemAction(int newNum){
		this.count=0;
		tiles.setTest(isTest);
		this.n=newNum;
		ITERNUMBER=this.n*this.n;
		this.tiles.setN(newNum);
		this.tiles.make();
		setJFramSize(newNum,newNum);
	}
	public void setJFramSize(int x, int y){
		this.mainFrame.setSize(16+x*TileUtil.TILESIZE,
				64+y*TileUtil.TILESIZE);
		this.updateUI();
	}
}
