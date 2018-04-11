package kr.co.infopub.chapter.s134;

public class JSort2 {
	
	/**
	 * 
	 * <pre>
	 * BubbleSort : 바로앞의 배열값과 자신의 배열값을 비교하여 자신이 더 작은 수인경우 자리를 바꾸어준다. 
	 * 					그리하여 배열길이만큼 1회전하면 제일 마지막 배열값은 제일 큰수가 된다. 
	 * 					그다음 제일 큰수가 된 마지막 배열자리만 제외하고 다시 자리를 바꾸어 주는 작업을 해준다.
	 * 					배열길이만큼 회전하면 정렬이 완료된다. </pre>
	 */
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
	/** 
	 * <pre>
	 * InsertSort : 정렬이 정상적으로 되어있는지 확인해보다가 증가순 정렬에 위배되는경우 
	 * 				  다른곳에 임시 저장한다. 그리고 그 위배되던 자리가 비면, 위배되는 자리의 앞수들을 한칸씩
	 * 				  뒤로 이동하여 빈 공간을 없앤다. 그렇게 제일 앞자리 자리가 비면 임시저장해두었던 수를 대입한다.
	 * 				  이런 방법으로 반복하면 정렬이 된다.</pre>
	 */
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
	
	
	
	/**
	 * <pre>
	 * SelectSort : 배열의 길이만큼 회전하면서 제일 작은값을 유출해내고 그 값을 제일 앞자리의 값과 교체해준다.
	 * 				   다시 나머지 중에서 최소값을 구해내어 나머지의 왼쪽으로 보낸다. 
	 * </pre>
	 */
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
		
	}
	//셀렉 정렬 끝
	
	/**
	 * <pre>
	 * QuickSort : 배열의 길이의 중간부분을 pivot으로 설정하고 기준보다 작으면 왼쪽으로, 크면 오른쪽으로 옮긴다.
	 * 				  이 작업이 완료되면 또 그 나뉜 부분의 중간부분을 기준으로 정하고 
	 * 				  작으면 왼쪽으로 , 크면 오른쪽으로 옮기는 작업을 반복한다.
	 * </pre>
	 */

	
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
		/**
		 * 처음 QuickSort를 입력받아서 배열의 길이값까지 매개변수로 넘겨주는 작업을 실행한다.  
		 */
		public static void QuickSort(int[] n){
			QuickSort(n,0,n.length-1);
		}
			
	
		
	
	/**
	 * <pre>
	 * 버블 정렬
	 * static 메소드로 객체생성없이 ClassName.MethodName으로 사용할 수 있다. </br>
	 * 변수 count에 배열길이 -1 를 대입 (인덱스 번호는 0부터 시작하기 때문에.) 
	 * 중복 for문을 이용해 outer for문은 0~ 배열끝까지 정렬이 될때까지 반복되게 한다.
	 * Inner For문은 0~배열끝 - 1 -i 까지 반복하여 가장 큰 값을 가장 오른쪽으로 이동시키고, 그다음 결과는 
	 * 가장 오른쪽 - 1 에 위치시키기 위함이다.
	 * if 문으로 조건을 주어 (첫번째 숫자와 두번째 숫자를 비교) 큰값을 빈 공간에 잠시넣고, 작은값을 왼쪽으로
	 * 큰값을 오른쪽으로 이동시키는 swap 과정의 반복이 일어나게 된다.
	 *   </pre>
	 * @param n  = 정렬하고 싶을 숫자 (int형 배열)
	 */
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
	
	/**
	 * 
	 *  파라미터로 입력된 임의의 숫자들(int 형 배열 n)
	 *  을 인덱스 번호대로 (0~ n의 갯수까지) 출력하는 메소드.
	 * @param n 결과를 출력하고자 하는 인트 배열 (int 배열 형태)
	 */
	public static void print(int []n){
		for(int i=0;i<n.length;i++){
			System.out.print(n[i]+" ");
		}
		System.out.println();
	}	

}
