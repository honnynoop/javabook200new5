package kr.co.infopub.chapter.s125;
public class AntQuiz {
	//s="112111"
	public  String   ant(String s){
		String t="";
		char c=s.charAt(0);//'1'
		int count=1;
		for (int i = 1; i < s.length() ; i++) {
			if( c==s.charAt(i) ){
				count++;
			}else {
				t=t+c+count;
				c=s.charAt(i);
				count=1;
			}
		}
		t=t+c+count;
		return t;
	}
	public void ant(int stage){
		String s="11";
		for (int i = 0; i <stage; i++) {
			System.out.println(s);
			s=ant(s);
		}
	}
	public static void main(String[] args) {
		AntQuiz quiz=new AntQuiz();
		quiz.ant(12);
	}
}
