package kr.co.infopub.chapter.s143;
public class Floyd{
    private int[][]data;
    private int[][]p;
    public String[] name;
    public Floyd(){
        Init();        
    }
    public void Init(){
        //p1~p5 경로, 1000 충분히 큰 수
        data = new int[][] { { 0,2,3,1000,7},
                            {5,0,1000,1000,4 },
                            {2,1000,0,6,1000 }, 
                            {1000,1000,3,0,4}, 
                            {6,1,6,2,0 } };
        p = new int[data.length][data.length];
        name=new String[]{"P1","P2","P3","P4","P5"};
    }
    //Floyd 알고리즘을 이용하여 최단경로의 
    //비용과 함께 최단경로를 구하는 함수
    public void distance(){
        for (int i = 0; i < data.length; i++){
            for (int j = 0; j < data.length; j++){
                p[i][ j] = -1;
            }
        }
        for (int k = 0; k < data.length; k++) {
            for (int i = 0; i < data.length; i++){
                for (int j = 0; j < data.length; j++){
					if (data[i][ j] > data[i][ k] + data[k][ j]){
					    p[i][ j] = k;
					    data[i][ j] = data[i][ k] + data[k][ j];
					}
                }
            }
        }
    }//
    //최단경로 중간 경유지 출력,q출발지,r도착지
    public void Path(int q, int r){
        if (p[q][r] != -1) {
            Path(q, p[q][ r]);
            System.out.printf("%s -> ", name[p[q][r]]);
            Path(p[q][r], r);
        }
    }
    //모든 경로를 출력 해주는 함수
    public void printPath(){
        int count = data.length;
        for (int i = 0; i < count; i++){
            for (int j = 0; j < count; j++){
                System.out.printf("%d\t", data[i][j]);
            }
            System.out.println();
        }
    }//
    public static void main(String[] args) {
    	 Floyd floy = new Floyd();
         floy.printPath();
         System.out.println("-----------------------");
         floy.distance();
         floy.printPath();
         int start = 0;//1
         int goal = 4;//P5
         System.out.printf("%s -> ", floy.name[start]);
         floy.Path(start, goal);
         System.out.printf("%s", floy.name[goal]);
         System.out.println();
	}
}//class Floyd
