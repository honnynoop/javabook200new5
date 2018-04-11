package kr.co.infopub.chapter.s144;
public class SubmergeLands {
 private char[] pass = {'a','b','c','d','e','f','g','h','i','j','k','l','m','o','p','q','r','s','t','u','v','w','x','y','z'}; 
 private int d=0;
 public SubmergeLands(int d) {
	this.d = d;
 }
 public int toNum(char a){
     if(Character.isDigit(a)){
		 return a-'0';
	 }else return 0;
 }
 public  int findApart(char region[][] , int x, int y, char step, int depth){
	int count=0;
	int right=region.length;
	int bottom=region[0].length;
	if (x < 0 || x >= bottom || y < 0 || y >= right || toNum(region[y][x]) <6) {
		return 0;
	}
	region[y][x] = pass[depth % pass.length];// 0~9를 반복표시 침수지를 세는 과정
    count = 1 + findApart(region, x, y - 1, step, depth + 1)
          + findApart(region, x + 1, y, step, depth + 1)
          + findApart(region, x, y + 1, step, depth + 1)
          + findApart(region, x - 1, y, step, depth + 1);
    if(d>0){  // 대각선도 같은 침수지로 인정
    	  count+= findApart(region, x + 1, y - 1, step, depth + 1)   
    	  + findApart(region, x + 1, y + 1, step, depth + 1)
    	  + findApart(region, x - 1, y + 1, step, depth + 1)
    	  + findApart(region, x - 1, y - 1, step, depth + 1);
    }
    region[y][x] = step;
    print(region);
    return count;
 }
 public static void print(char c[][]){
	for (int i = 0; i < c.length; i++) {
		for (int j = 0; j < c[i].length; j++) {
			System.out.printf("%c",c[i][j]);
		}
		System.out.println();
	}
	System.out.println("---------------------");
 }
 public static void main(String[] args) {
	 int d=0;  //d=0 대각선 인정-같은 침수지, 대각선 불인정 d=1-다른 침수지
	 SubmergeLands apt=new SubmergeLands(d);
//	 char region[][]={ 
//				  { '2','7','8'},
//				  { '5','6','4'},
//				  { '8','5','9'}
//				  };
	  char region[][]={ // 강우량 분포 - 6이상의 침수된다고 가정
			  { '2','3','2','3','4','3','0','0'},
			  { '4','5','3','4','5','8','0','0'},
			  { '6','6','4','5','6','7','0','0'},
			  { '8','5','5','6','7','6','3','4'},
			  { '9','7','6','7','8','3','5','5'},
			  { '3','8','7','8','6','2','3','6'},
			  { '5','9','8','9','5','1','6','7'},
			  { '7','3','9','7','4','0','7','8'}
			  };
	  int right=region.length;
	  int bottom=region[0].length;
	  int count=0;
	  char steps[] = new char[26];   //A침수지, B침수지, .... 26침수지 이하
	  for (int i = 0; i < steps.length; i++) {
		steps[i]=(char)('A'+i);
	  }
	  int []sizes=new int[bottom*right];  //침수지내 침수지 수
	  int blocknums=0;  //침수지 수
	  for (int iy = 0; iy < right; ++iy){
		    for (int ix = 0; ix < bottom; ++ix) {
		         count = apt.findApart(region, ix, iy, steps[blocknums], 0);
			     if (count>0) {
				    sizes[blocknums++] = count;
			     }
			}
	  }
	  System.out.printf("침수지 단지= %d개\n", blocknums);
	  for (int ix = 0; ix < blocknums; ++ix){
		  System.out.printf("%c 침수지 단지  = 침수지 %d개\n", steps[ix], sizes[ix]);
	  }
 }
}
