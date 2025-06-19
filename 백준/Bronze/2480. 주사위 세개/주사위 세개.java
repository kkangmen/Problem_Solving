import java.util.*;

public class Main{
    public static void solution(){
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int max = Math.max(Math.max(a,b),c);

        if (a == b && b == c){
            System.out.println(10000 + a*1000);
        }
        else if (a != b && b != c && a != c){
            System.out.println(max * 100);
        }
        else {
            if (a == b){
                System.out.println(1000 + a*100);
            }
            else if (b == c){
                System.out.println(1000 + b*100);
            }
            else {
                System.out.println(1000 + a*100);
            }
        }
    }
    public static void main(String[] args){
        solution();
    }
}