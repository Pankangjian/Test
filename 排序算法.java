package suanfa;

public class Paixu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr [] = {1,0,3,9,8,6,7,2,5,4,-1};
		Paixu paixu = new Paixu();
		paixu.p(arr);
		System.out.println();
		paixu.p1(arr,11);
		System.out.println();
		paixu.p3(arr,11);
		System.out.println();
		paixu.p4(arr,11);
	}
	public void Paixu(){
	 
	}
	/**
	 * 排序算法--冒泡算法
	 * 两个数比较大小，较大的数下沉，较小的数冒起来
	 */
	public static void  p(int arr[]){
		int temp;
		for(int i = 0; i<arr.length; i++){
			
			for(int j = 0; j<arr.length-1; j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					
				}
			}
		}
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr[i]);
			
		}
		
	}
	/**
	 * 排序算法--选择排序
	 * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * ....
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
	 */
	public void p1(int arr[], int lenth){
		for(int i = 0; i<lenth-1; i++){
			int min = i; 
			/*
			 * 有数组1,0,3,9,0,6,1,2,5,4--1与[039061254]最小值比较
			 * 提取出00,1继续[3961254]最小值比较
			 * 提取11,把3取出与遍历数组[96254]最小值比较
			 * ......
			 * 遍历查找最小值与元素1比较,
			*/
			for(int j = i+1; j < lenth; j++){
				if(arr[j]<arr[min]){
					min = j;    //最小值与元素进行交换
				}
			}
//			System.out.print("最小值"+min);
			//i不是最小值时,输出元素为最小值,
			if(min != i){
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		for (int i = 0; i < lenth; i++){
			System.out.print(arr[i]);
		}
	}
	
	/**
	 * 排序算法--插入排序
	 * 在要排序的一组数中，假定前n-1个数已经排好序，
	 * 现在将第n个数插到前面的有序数列中，
	 * 使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
	 */
	public void p3(int arr [],int lenth){
		int temp;
		for(int i = 0; i < lenth-1; i++){
			for(int j = i + 1; j >0; j--){
				if(arr[j]<arr[j-1]){
					temp = arr[j-1];
	                  arr[j-1] = arr[j];
	                  arr[j] = temp;
	              }       
			}
		}
		for (int i = 0; i < lenth; i++){
			System.out.print(arr[i]);
		}
	}

	/**
	 * 排序算法--希尔排序
	 * 在要排序的一组数中，根据某一增量分为若干子序列，并对子序列分别进行插入排序。
	 * 然后逐渐将增量减小,并重复上述过程。直至增量为1,此时数据序列基本有序,最后进行插入排序。
	 */
	public void p4(int arr[],int lenth){
		int temp = 0;
	      int incre = lenth;
	      while(true){
	          incre = incre/2;
	          for(int k = 0; k < incre;k++){    //根据增量分为若干子序列
	              for(int i = k + incre; i<lenth;i += incre){
	                  for(int j=i;j>k;j-=incre){
	                      if(arr[j]<arr[j-incre]){
	                          temp = arr[j-incre];
	                          arr[j-incre] = arr[j];
	                          arr[j] = temp;
	                      }else{
	                    	  
	                          break;
	                      }
	                  }
	              }   
	          }
	          if(incre == 1){
	              break;
	          }
	          
	      }
	}
	
	/**
	 * 排序算法--快速排序
	 * 先从数列中取出一个数作为key值；
	 * 将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
	 * 对左右两个小数列重复第二步，直至各区间只有1个数。
	 */
	public void p5(int a[],int l,int r){
		if(l>=r)
	          return;
		
	        int i = l; int j = r; int key = a[l];//选择第一个数为key
	        while(i<j){
	        	
	            while(i<j && a[j]>=key)//从右向左找第一个小于key的值
	                j--;
	            
	            if(i<j){
	                a[i] = a[j];
	                i++;
	            }
	            
	            while(i<j && a[i]<key)//从左向右找第一个大于key的值
	                i++;
	            
	            if(i<j){
	                a[j] = a[i];
	                j--;
	            }
	        }
	        //i == j
	        a[i] = key;
	        p5(a, l, i-1);//递归调用
	        p5(a, i+1, r);//递归调用
	}
	
	/**
	 * 排序算法--归并排序
	 */
	public void p6(int a[], int n, int b[], int m, int c[]){
		int i, j, k;

	    i = j = k = 0;
	    while (i < n && j < m)
	    {
	        if (a[i] < b[j])
	            c[k++] = a[i++];
	        else
	            c[k++] = b[j++]; 
	    }

	    while (i < n)
	        c[k++] = a[i++];

	    while (j < m)
	        c[k++] = b[j++];
	}
}