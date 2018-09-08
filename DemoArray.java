class DemoArray {
	public static void main(String[] args) {
		DemoArray t = new DemoArray();
		t.p1();
		t.p2();
	}

	public static void p1() {
		// ����д�� new��һ���ؼ���,��������ʵ�����
		int[] arr = { 1, 2, 3, 4, 5 };            // ��̬��ʼ���ļ�д��ʽ,ֻ����һ�ж���
		int[] arr1 = new int[5];                  // ��̬��ʼ��,���ڴ��п���������5���ռ�
		arr1[0] = 5;
		arr1[4] = 10;
		int[] arr2 = new int[] { 1, 2, 3 };       // ��̬��ʼ��,һ��ʼ���͸�ֵ,����ֵ�ĸ�����������
		// System.out.print(arr2[1]);
	}

	public static void p2() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// System.out.println(arr[-1]);           // ArrayIndexOutOfBoundsException:��������Խ���쳣
		// arr = null;
		// System.out.println(arr[0]);            // NullPointerException:��ָ���쳣
		for (int x = 0; x < arr.length; x++) {
			// һά����ı�������
			System.out.print(arr[x] + " ");
		}
		int[] arr1 = { 11, 22, 33, 44, 55, 66 };
		int max = getMax(arr1);                    // ��ȡ�����е����ֵ
		// System.out.print(max);
		revArray(arr1);                           // �����鷴ת����
		print(arr1);                              // ������ӡ����
		int index = getIndex(22,arr1);
		System.out.println(index);
	}

	private static int getMax(int[] arr1) {
		int max = arr1[0];                          // ���������¼ס��һ��λ�õ�ֵ
		for (int x = 1; x < arr1.length; x++) {     // ��������,�ӵڶ���λ��
			if (arr1[x] > max) {                    // ��max�е�ֵ�Ƚ�,�����maxֵ��
				max = arr1[x];                      // ��max�е�ֵ�滻��
			}
		}
		return max;                                 // �����ֵ����
	}

	public static void revArray(int[] arr1) {
		for (int x = 0; x < arr1.length / 2; x++) {
			int temp = arr1[x];
			arr1[x] = arr1[arr1.length - 1 - x];
			arr1[arr1.length - 1 - x] = temp;
		}
	}

	public static void print(int[] arr1) {
		for (int x = 0; x < arr1.length; x++) {
			System.out.print(arr1[x] + " ");
		}
	}
    public static int getIndex(int shu,int [] arr1){
    	// ����Ԫ�ز���(����ָ��Ԫ�ص�һ���������г��ֵ�����)
    	for (int x = 0; x<arr1.length; x++ ){
    		if (shu == arr1[x]){
    			return x;       //������ֵ���س�������
    		}
    	}
    	 return -1;             //�쳣����ֵ
    }
	
}
