import java.util.*;

class Solution {
    public int lcm(int a, int b){
        return a/b;
    }
    
    public int gcb(int a, int b){
        int big = a > b ? a : b;
        int small = a > b ? b : a;
        int temp = 0;
        
        while (small > 0){
            temp = big % small;
            big = small;
            small = temp;
        }
        return big;
    }
    
    public int solution(int[] arr) {
        int num = lcm(arr[0]*arr[1], gcb(arr[0], arr[1]));
        for (int i = 2; i < arr.length; i++){
            num = lcm(num*arr[i], gcb(num, arr[i]));
        }
        return num;
    }
}

// 14 21 => 21 % 14 = 7
//          14 % 7  = 0
// 294 / 7 = 42