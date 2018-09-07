package suanfa;
import java.util.Scanner;

/**
 *@author pan
 * 
 春天是鲜花的季节，水仙花就是其中最迷人的代表，数学上有个水仙花数，
 他是这样定义的： “水仙花数”是指一个三位数，它的各位数字的立方和等于其本身，
 比如：153=1^3+5^3+3^3。 现在要求输出所有在m和n范围内的水仙花数。
 输入描述:
 输入数据有多组，每组占一行，包括两个整数m和n（100 ≤ m ≤ n ≤ 999）。
 输出描述:
 对于每个测试实例，要求输出所有在给定范围内的水仙花数，就是说，输出的水仙花数必须大于等于m
 并且小于等于n，如果有多个，则要求从小到大排列在一行内输出，之间用一个空格隔开;
 如果给定的范围内不存在水仙花数，则输出no;
 每个测试实例的输出占一行。
 */
public class Shuixianhua1 {
 
    //水仙花数
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            boolean isfirst = true;
            for(int i=m; i<=n; i++){
                int g = i%10;           //m=153时，153%10余数为3     3的3次方为27
                int s = i/10%10;       //m=153时，153/10%10余数为5   5的3次方为125
                int b = i/10/10%10;   //m=153时，153/100%10余数为1   1的3次方为1    27+125+1=153
//                if((Math.pow(g,3)+Math.pow(s,3)+Math.pow(b,3))==i){
                  if((g*g*g+s*s*s+b*b*b)==i){
                    if(isfirst){
                        System.out.print(i);
                       isfirst = false;
                    }
                    else
                        System.out.print(" "+i);
                }
            }
            if(isfirst){
                System.out.println("no");
            }
        }
    }
}