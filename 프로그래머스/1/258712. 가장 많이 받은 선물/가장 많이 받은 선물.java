import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int friendsNum = friends.length;
        int[][] graph = new int[friendsNum][friendsNum];
        int[] giftIndex = new int[friendsNum];
        int[] takeGift = new int[friendsNum];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friendsNum; i++){
            map.put(friends[i], i);
        }
        
        for (String s : gifts){
            int giver = map.get(s.split(" ")[0]);
            int given = map.get(s.split(" ")[1]);
            
            graph[giver][given]++;
            giftIndex[giver]++;
            giftIndex[given]--;
        }
        
        for (int i = 0; i < friendsNum; i++){
            for (int j = i+1; j < friendsNum; j++){
                int num1 = graph[i][j];
                int num2 = graph[j][i];
                if (num1 == num2 || (num1 == 0 && num2 == 0)){
                    if (giftIndex[i] == giftIndex[j]){
                        continue;
                    }
                    else if (giftIndex[i] > giftIndex[j]){
                        takeGift[i]++;
                    }
                    else {
                        takeGift[j]++;
                    }
                }
                else {
                    if (num1 > num2){
                        takeGift[i]++;
                    }
                    else{
                        takeGift[j]++;
                    }
                }
            }
        }
        
        for (int i = 0; i < friendsNum; i++){
            answer = Math.max(answer, takeGift[i]);
        }
        return answer;
    }
}