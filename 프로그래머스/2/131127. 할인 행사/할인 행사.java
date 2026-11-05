import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> for10DaysFoodMap = new HashMap<>();
        for (int i = 0; i < 10; i++){
            String s = discount[i];
            
            for10DaysFoodMap.put(s, for10DaysFoodMap.getOrDefault(s, 0) + 1);
        }
        
        int windowFirst = 0;
        int windowLast = 9;
        // i = 9, 10, 11, 12,
        // wL = 10, 11, 12, 13,
        for (int i = 9; i < discount.length; i++){
            boolean flag = true;
            // System.out.println(windowLast);
            for (int j = 0; j < want.length; j++){
                String food = want[j];
                int quantity = number[j];
                
                int tenDaysQuantity = for10DaysFoodMap.getOrDefault(food,0);
                
                if (tenDaysQuantity < quantity){
                    flag = false;
                }
            }
            
            if (flag){
                // System.out.println(windowFirst);
                answer++;
            }
            
            windowFirst++;
            windowLast++;
            if (windowLast >= discount.length){
                break;
            }
            String newFood = discount[windowLast];
            String deleteFood = discount[windowFirst-1];
            for10DaysFoodMap.put(newFood, for10DaysFoodMap.getOrDefault(newFood, 0) + 1);
            for10DaysFoodMap.put(deleteFood, for10DaysFoodMap.get(deleteFood) - 1);
        }
        return answer;
    }
}