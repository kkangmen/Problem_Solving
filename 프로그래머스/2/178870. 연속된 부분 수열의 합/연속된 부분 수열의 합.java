import java.util.*;

class Solution {
    class Window {
        int start;
        int end;
        
        Window(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    
    List<Window> candidates = new ArrayList<>();
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        while (left < sequence.length){
            if (sum < k){
                right++;
                if (right == sequence.length){
                    break;
                }
                sum += sequence[right];
            } else {
                if (sum == k){
                    candidates.add(new Window(left, right));
                }
                sum -= sequence[left];
                left++;
            }
        }
        
        Collections.sort(candidates, (o1, o2) -> {
            int gap1 = o1.end-o1.start;
            int gap2 = o2.end-o2.start;
            if (gap1 == gap2){
                return o1.start - o2.start;
            }
           return gap1 - gap2;
        });
        
        // for (Window w : candidates){
        //     System.out.println(w.start + ", " + w.end);
        // }
        answer[0] = candidates.get(0).start;
        answer[1] = candidates.get(0).end;
        return answer;
    }
}