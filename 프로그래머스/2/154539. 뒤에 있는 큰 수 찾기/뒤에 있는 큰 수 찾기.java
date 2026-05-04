import java.util.*;

class Solution {
    private static Stack<Point> stack = new Stack();
    
    private class Point {
        int index;
        int number;
        Point(int index, int number){
            this.index = index;
            this.number = number;
        }
    }
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        stack.push(new Point(0, numbers[0]));
        for (int i = 1; i < numbers.length; i++){
            while (!stack.isEmpty() && stack.peek().number < numbers[i]){
                answer[stack.peek().index] = numbers[i];
                stack.pop();
            }
            stack.push(new Point(i, numbers[i]));
        }
                   
        for (int i = 0; i < answer.length; i++){
            if (answer[i] == 0){
                answer[i] = -1;
            }
        }
        return answer;
    }
}