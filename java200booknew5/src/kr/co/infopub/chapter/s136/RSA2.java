package kr.co.infopub.chapter.s136;
import java.util.ArrayList;
public class RSA2 {
 public static final int WHERETO=400;
 public static final int START=200;
 private int p=241;
 private int q=83;
 private int n;
 private int phiN;
 private int e;
 private int d;
 public void makePQ(){
	p=(int)(Math.random()*(START));
	q=(int)(Math.random()*(WHERETO+START));
	while((p==q)||
			(!Java200Math.isPrime(p)||
			!Java200Math.isPrime(q))){
		p=(int)(Math.random()*(START));
		q=(int)(Math.random()*(WHERETO+START));
	}
 }
 public void makeN(){
	n=p*q;
 }
 public int getN() {
	return n;
 }
 public void print(){
	System.out.printf("(p,q)=(%d, %d)\n"
	+ "(n,phi)=(%d,%d)\n(e,d)=(%d,%d)\n",
			p,q,n,phiN,e,d);
 }
 public void makePHIN(){
	this.phiN=(p-1)*(q-1);
 }
 public int getPhiN() {
	return phiN;
 }
 public void makeE(){
	ArrayList<Integer> 
	es=new ArrayList<Integer>();
	for (int i = 2; i < phiN; i++) {
		if(Java200Math.gcd(phiN, i)==1){
			es.add(i);
		}
	}
	e=es.get(es.size()-1);//가장큰것.(랜덤으로 만들면 좋다)
 }
 public void makeD(){
	int count=2;
	while(!(count*e%phiN==1 && count!=e)){
		count++;
	}
	d=count;
 }
 public int toCiph(int m){
	int tot=1;
	for (int i = 0; i < e; i++) {
		tot=(tot*m)%n;
	}
	return tot;
 }
 public int toUnCiph(int c){
	int tot=1;
	for (int i = 0; i < d; i++) {
		tot=(tot*c)%n;
	}
	return tot;
 }
 public static void main(String[] args) {
	RSA2 aa=new RSA2();
	//aa.makePQ();
	aa.makeN();
	aa.makePHIN();
	aa.makeE();
	aa.makeD();
	aa.print();
	int a=65;
	int b=66;
	int c=67;
	int d=68;
	System.out.printf("원본 %d\t%d\t%d\t%d\n",a,b,c,d);
	int ca=aa.toCiph(a);
	int cb=aa.toCiph(b);
	int cc=aa.toCiph(c);
	int cd=aa.toCiph(d);
	System.out.printf("암호 %d\t%d\t%d\t%d\n",ca,cb,cc,cd);
	System.out.printf("복호 %d\t%d\t%d\t%d\n",
			aa.toUnCiph(ca),aa.toUnCiph(cb),
			aa.toUnCiph(cc),aa.toUnCiph(cd));
	
	System.out.println("----------------------");
	for(int i=65 ; i<200 ;i++){
		int bbb=aa.toCiph(i);
		int ccc=aa.toUnCiph(bbb);
		System.out.println(String.format("%d, %d, %d", i,bbb,ccc));
	}
	System.out.println("---------------------");
	String h="가나다라마바사안녕하세요";
	char[] ch=h.toCharArray();
	
	for (int i = 0; i < ch.length; i++) {
		int tt=(int)ch[i]-44000;
		int jj=aa.toCiph(tt);
		int kk=aa.toUnCiph(jj);
		System.out.printf(
	"%d %d\t%c\n",tt,jj,(char)(kk+44000) );
	}
 }
}
