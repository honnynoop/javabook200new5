package kr.co.infopub.chapter.s134;
public class JSort {
	public static void BubbleSort(int[] n){
		for(int i=0; i<n.length-1; i++){
			for(int j=0; j<n.length-1-i; j++){
				if(n[j]>n[j+1]){
					int temp=n[j];
					n[j]=n[j+1];
					n[j+1]=temp;
				}
			}
		}
	}//버블정렬
	public static void InsertSort(int[] n){	
		for (int i = 0; i < n.length; i++) {
			int temp=n[i];
			int j=i-1;
			while(j>=0 && n[j]> temp){					//왼쪽 수가 더 클 동안 앞의 값을 바로 뒤의 위치에 넣어준다.
				n[j+1]=n[j];
				j--;
			}
			n[j+1]=temp;
		}
	}//삽입정렬
	public static void SelectSort(int n[]){
		for (int i = 0; i < n.length; i++) {
			int k = i;
			for(int j = i+1;j<n.length;j++){
				 if(n[j] < n[k]){
					 k = j;
				 }
			}
			int temp=n[i];
			n[i]=n[k];
			n[k]=temp;	
		}	
	}//셀렉 정렬 끝
	public static void QuickSort(int[] nn, int start, int end){
		int left =start; 
		int right=end;
		int mid=nn[(start+end)/2];
		do{
				//A
			while((nn[left]<mid) && (left < end)){
				left++;
				
			}
			while((mid<nn[right]) && (right>start)){
				right--;
			}
				//B
			if(left<=right){
				
				int temp=nn[left];			
				nn[left]=nn[right];
				nn[right]=temp;
				left++;
				right--;
			}
		}while(left<right);
		//C
		if(start<right){
			QuickSort(nn,start,right);
		}
		//D
		if(left<end){
			QuickSort(nn,left,end);
		}
	}
	public static void QuickSort(int[] n){
		QuickSort(n,0,n.length-1);
	}
	public static void ascSort(int [] n){
		int count = n.length;
		for(int i=0;i<count-1;i++){
			for(int j=0;j<count-1-i;j++){
				if(n[j] > n[j+1]){
					int temp = n[j];
					n[j] = n[j+1];
					n[j+1]=temp;
				}
			}
		}
	}
	public static void print(int []n){
		for(int i=0;i<n.length;i++){
			System.out.print(n[i]+" ");
		}
		System.out.println();
	}	
}
