import java.util.*;

class Solution {
    public class TangerineClass {
        private int size;
        private int count;
        
        public TangerineClass(int size, int count){
            this.size = size;
            this.count = count;
        }
    }
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        List<TangerineClass> list = new ArrayList<>();
        for (int i : tangerine){
            tangerineMap.put(i, tangerineMap.getOrDefault(i, 0) + 1);
        }
        
        for (int i : tangerineMap.keySet()){
            list.add(new TangerineClass(i, tangerineMap.get(i)));
        }
        
        Collections.sort(list, (a, b) -> {
           return b.count - a.count; 
        });
        
        int curCount = 0;
        // 출력
        Iterator<TangerineClass> iter = list.iterator();
        while (iter.hasNext()){
            TangerineClass t = iter.next();
            curCount += t.count;
            answer++;
            if (curCount >= k){
                break;
            }
        }
        
        
        return answer;
    }
}