package suanfa;
import java.util.Scanner;

/**
 *@author pan
 * 
 �������ʻ��ļ��ڣ�ˮ�ɻ��������������˵Ĵ�����ѧ���и�ˮ�ɻ�����
 ������������ģ� ��ˮ�ɻ�������ָһ����λ�������ĸ�λ���ֵ������͵����䱾��
 ���磺153=1^3+5^3+3^3�� ����Ҫ�����������m��n��Χ�ڵ�ˮ�ɻ�����
 ��������:
 ���������ж��飬ÿ��ռһ�У�������������m��n��100 �� m �� n �� 999����
 �������:
 ����ÿ������ʵ����Ҫ����������ڸ�����Χ�ڵ�ˮ�ɻ���������˵�������ˮ�ɻ���������ڵ���m
 ����С�ڵ���n������ж������Ҫ���С����������һ���������֮����һ���ո����;
 ��������ķ�Χ�ڲ�����ˮ�ɻ����������no;
 ÿ������ʵ�������ռһ�С�
 */
public class Shuixianhua1 {
 
    //ˮ�ɻ���
   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            boolean isfirst = true;
            for(int i=m; i<=n; i++){
                int g = i%10;           //m=153ʱ��153%10����Ϊ3     3��3�η�Ϊ27
                int s = i/10%10;       //m=153ʱ��153/10%10����Ϊ5   5��3�η�Ϊ125
                int b = i/10/10%10;   //m=153ʱ��153/100%10����Ϊ1   1��3�η�Ϊ1    27+125+1=153
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