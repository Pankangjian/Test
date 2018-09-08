class DemoArray {
	public static void main(String[] args) {
		DemoArray t = new DemoArray();
		t.p1();
		t.p2();
	}

	public static void p1() {
		// 数组写法 new是一个关键字,用来创建实体对象
		int[] arr = { 1, 2, 3, 4, 5 };            // 静态初始化的简写形式,只能在一行定义
		int[] arr1 = new int[5];                  // 动态初始化,在内存中开辟连续的5个空间
		arr1[0] = 5;
		arr1[4] = 10;
		int[] arr2 = new int[] { 1, 2, 3 };       // 静态初始化,一初始化就赋值,根据值的个数决定长度
		// System.out.print(arr2[1]);
	}

	public static void p2() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// System.out.println(arr[-1]);           // ArrayIndexOutOfBoundsException:数组索引越界异常
		// arr = null;
		// System.out.println(arr[0]);            // NullPointerException:空指针异常
		for (int x = 0; x < arr.length; x++) {
			// 一维数组的遍历操作
			System.out.print(arr[x] + " ");
		}
		int[] arr1 = { 11, 22, 33, 44, 55, 66 };
		int max = getMax(arr1);                    // 获取数组中的最大值
		// System.out.print(max);
		revArray(arr1);                           // 对数组反转操作
		print(arr1);                              // 遍历打印数组
		int index = getIndex(22,arr1);
		System.out.println(index);
	}

	private static int getMax(int[] arr1) {
		int max = arr1[0];                          // 定义变量记录住第一个位置的值
		for (int x = 1; x < arr1.length; x++) {     // 遍历数组,从第二个位置
			if (arr1[x] > max) {                    // 与max中的值比较,如果比max值大
				max = arr1[x];                      // 将max中的值替换掉
			}
		}
		return max;                                 // 将最大值返回
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
    	// 数组元素查找(查找指定元素第一次在数组中出现的索引)
    	for (int x = 0; x<arr1.length; x++ ){
    		if (shu == arr1[x]){
    			return x;       //出现数值返回长度索引
    		}
    	}
    	 return -1;             //异常返回值
    }
	
}
