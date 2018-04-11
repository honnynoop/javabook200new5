package kr.co.infopub.chapter.s134;
import kr.co.infopub.chapter.s133.Lotto6Num;
public class JSortMain3 {
	public static void main(String[] args) {
		Lotto6Num lot=new Lotto6Num(1000,100);
		lot.randomMake();        //정렬안된 정수 100개를 저장한 배열 만들기
    	int [] m=lot.getLots();  //정렬안된 정수 100개를 저장한 배열 얻기
    	int []n=new int[m.length];
		System.arraycopy(m, 0, n, 0, m.length);
		JSort.print(n);
		long a=System.nanoTime();
		JSort.InsertSort(n);
		long b =System.nanoTime();
		System.out.println((b-a)+"nano sec");  // 10의 -9승
		JSort.print(n);
	}
}
