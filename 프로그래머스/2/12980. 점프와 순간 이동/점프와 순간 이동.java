import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n > 0){
            if (n % 2 == 0){
                n /= 2;
            }
            else {
                n -= 1;
                ans++;
            }
        }

        return ans;
    }
}

// 5 -> 4 -> 2 -> 1 => 2
// 6 -> 3 -> 2 -> 1 => 2
// 5000 -> 2500 -> 1250 -> 625 -> 624 -> 312 -> 156 -> 78 -> 39 -> 38 -> 19 -> 18 -> 9 -> 8
// -> 4 -> 2 -> 1 => 5