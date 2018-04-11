package kr.co.infopub.chapter.s150.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TileJPanelMain {
	public  void createAndShowUI()
    {
        JFrame frame = new JFrame("TilePanel Draw ver. 0.8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainp=(JPanel)frame.getContentPane();
        int n=3;//nXn 퍼즐 만들기 2이상 가능하지만 5부터는 그림확인 속도도 늦어짐
        TileJPanel pjp=new TileJPanel(frame,n);
        pjp.setTest(true); //true면 디버그 모드 false면 실행모드
        mainp.add(pjp);
        frame.setSize(16+n*TileUtil.TILESIZE,
        		64+n*TileUtil.TILESIZE);//기본으로 16, 메뉴가 있으면 64이동해서 시작
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
	    {
	        public void run()
	        {
	        	TileJPanelMain ir=new TileJPanelMain();
	            ir.createAndShowUI();
	        }
	    });
	}
}
