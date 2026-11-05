import java.util.*;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int rotate = 1;

        int big = 0;
        int small = 0;
        if (a > b){
            big = a;
            small = b;
        }
        else {
            big = b;
            small = a;
        }
        
        // big = 5 => 3 => 2
        // small = 3 => 2 => 1
        while (small%2 == 0 || small+1 != big){
            if (big % 2 == 0){
                big /= 2;
            }
            else {
                big = big/2 + 1;
            }
            
            if (small % 2 == 0){
                small /= 2;
            }
            else {
                if (small != 1){
                    small = small/2 + 1;
                }
            }
            
            System.out.println(big + " " + small);
            rotate++;
        }

        return rotate;
    }
}