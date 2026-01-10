import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int curLeftHand = 10;
        int curRightHand = 12;
        for (int i : numbers){
            if (i == 1 || i == 4 || i == 7){
                answer.append("L");
                curLeftHand = i;
            }
            else if (i == 3 || i == 6 || i == 9){
                answer.append("R");
                curRightHand = i;
            }
            else{
                if (i == 0){
                    i = 11;
                }
                int distanceLeft = Math.abs(i - curLeftHand);
                int distanceRight = Math.abs(i - curRightHand);
                int totalDistanceLeft = distanceLeft/3 + distanceLeft%3;
                int totalDistanceRight = distanceRight/3 + distanceRight%3;
                if (totalDistanceLeft < totalDistanceRight){
                    answer.append("L");
                    curLeftHand = i;
                }
                else if (totalDistanceLeft > totalDistanceRight){
                    answer.append("R");
                    curRightHand = i;
                }
                else{
                    if (hand.equals("right")){
                        answer.append("R");
                        curRightHand = i;
                    }
                    else {
                        answer.append("L");
                        curLeftHand = i;
                    }
                }
            }
        }
        return answer.toString();
    }
}