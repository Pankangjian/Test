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
	 * �����㷨--ð���㷨
	 * �������Ƚϴ�С���ϴ�����³�����С����ð����
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
	 * �����㷨--ѡ������
	 * �ڳ���ΪN�����������У���һ�α���n-1�������ҵ���С����ֵ���һ��Ԫ�ؽ�����
     * �ڶ��α���n-2�������ҵ���С����ֵ��ڶ���Ԫ�ؽ�����
     * ....
     * ��n-1�α������ҵ���С����ֵ���n-1��Ԫ�ؽ�����������ɡ�
	 */
	public void p1(int arr[], int lenth){
		for(int i = 0; i<lenth-1; i++){
			int min = i; 
			/*
			 * ������1,0,3,9,0,6,1,2,5,4--1��[039061254]��Сֵ�Ƚ�
			 * ��ȡ��00,1����[3961254]��Сֵ�Ƚ�
			 * ��ȡ11,��3ȡ�����������[96254]��Сֵ�Ƚ�
			 * ......
			 * ����������Сֵ��Ԫ��1�Ƚ�,
			*/
			for(int j = i+1; j < lenth; j++){
				if(arr[j]<arr[min]){
					min = j;    //��Сֵ��Ԫ�ؽ��н���
				}
			}
//			System.out.print("��Сֵ"+min);
			//i������Сֵʱ,���Ԫ��Ϊ��Сֵ,
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
	 * �����㷨--��������
	 * ��Ҫ�����һ�����У��ٶ�ǰn-1�����Ѿ��ź���
	 * ���ڽ���n�����嵽ǰ������������У�
	 * ʹ����n����Ҳ���ź�˳��ġ���˷���ѭ����ֱ��ȫ���ź�˳��
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
	 * �����㷨--ϣ������
	 * ��Ҫ�����һ�����У�����ĳһ������Ϊ���������У����������зֱ���в�������
	 * Ȼ���𽥽�������С,���ظ��������̡�ֱ������Ϊ1,��ʱ�������л�������,�����в�������
	 */
	public void p4(int arr[],int lenth){
		int temp = 0;
	      int incre = lenth;
	      while(true){
	          incre = incre/2;
	          for(int k = 0; k < incre;k++){    //����������Ϊ����������
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
	 * �����㷨--��������
	 * �ȴ�������ȡ��һ������Ϊkeyֵ��
	 * ���������С����ȫ������������ߣ����ڻ����������ȫ�����������ұߣ�
	 * ����������С�����ظ��ڶ�����ֱ��������ֻ��1������
	 */
	public void p5(int a[],int l,int r){
		if(l>=r)
	          return;
		
	        int i = l; int j = r; int key = a[l];//ѡ���һ����Ϊkey
	        while(i<j){
	        	
	            while(i<j && a[j]>=key)//���������ҵ�һ��С��key��ֵ
	                j--;
	            
	            if(i<j){
	                a[i] = a[j];
	                i++;
	            }
	            
	            while(i<j && a[i]<key)//���������ҵ�һ������key��ֵ
	                i++;
	            
	            if(i<j){
	                a[j] = a[i];
	                j--;
	            }
	        }
	        //i == j
	        a[i] = key;
	        p5(a, l, i-1);//�ݹ����
	        p5(a, i+1, r);//�ݹ����
	}
	
	/**
	 * �����㷨--�鲢����
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