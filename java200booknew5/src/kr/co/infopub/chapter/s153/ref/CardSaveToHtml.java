package kr.co.infopub.chapter.s153.ref;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CardSaveToHtml {

	public  void save(Card[]cd,String fname){
		FileWriter fw=null;
		PrintWriter pw=null;
		try {
			fw=new FileWriter(fname,false);
			pw=new PrintWriter(fw,true);
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<table border='0'>");
			int col=CardUtil.RANK.length;
			int row=CardUtil.SUIT.length;
			
			for (int i = 0; i < row; i++) {
				pw.println("<tr>");
				for (int j = 0; j < col; j++) {
					pw.println("<td>");
					pw.println("<img src='image/"+cd[i*col+j].getCard().toLowerCase()+".gif'/>");
					pw.println("</td>");
				}
				pw.println("</tr>");
			}
			pw.println("<table>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				
			}
			pw.close();
		}
	}
	public  void save(ArrayList<Card[]> clist,String fname){
		FileWriter fw=null;
		PrintWriter pw=null;
		try {
			fw=new FileWriter(fname,false);
			pw=new PrintWriter(fw,true);
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<table border='0'>");
			int col=5;
			int row=clist.size();
			
			for (int i = 0; i < row; i++) {
				pw.println("<tr>");
				pw.println("<td>");
				pw.println((i+1));
				pw.println("</td>");
				for (int j = 0; j < col; j++) {
					pw.println("<td>");
					pw.println("<img src='image/"+clist.get(i)[j].getCard().toLowerCase()+".gif'/>");
					pw.println("</td>");
				}
				pw.println("</tr>");
			}
			pw.println("<table>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (IOException e) {
			System.out.println(e);
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				
			}
			pw.close();
		}
	}
}
