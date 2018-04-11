package kr.co.infopub.chapter.s151.swing;
import javax.swing.JFrame;
public class BaseBallJFrameMain {

	public static void main(String[] args) {
		
		BaseBallJFrame mf=new BaseBallJFrame();
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.setSize(500, 500);
		mf.setTitle("Hyo Baseball Game ver 0.9");
		mf.setVisible(true);
		mf.setResizable(false);
		
	}

}
