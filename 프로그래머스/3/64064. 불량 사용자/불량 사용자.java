import java.util.*;

class Solution {
    
    boolean[] isUsed;
    Set<List<String>> set = new HashSet<>();
    String[] cur_id;
    
    public boolean isPossible(String id1, String id2){
        if (id1.length() != id2.length()){
            return false;
        }
        
        for (int i = 0; i < id1.length(); i++){
            char ch1 = id1.charAt(i);
            char ch2 = id2.charAt(i);
            
            if (ch2 == '*'){
                continue;
            }
            
            if (ch1 != ch2){
                return false;
            }
        }
        
        return true;
    }
    
    public void bTracking(String[] user_id, String[] banned_id, String[] cur_id, int length, int size){
        if (size == length){
            String[] copy = cur_id.clone();
            Arrays.sort(copy);
            set.add(new ArrayList<>(List.of(copy)));
            return;
        }
        
        for (int i = 0; i < user_id.length; i++){
            if (!isUsed[i] && isPossible(user_id[i], banned_id[size])){
                cur_id[size] = user_id[i];
                isUsed[i] = true;
                bTracking(user_id, banned_id, cur_id, length, size+1);
                isUsed[i] = false;
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        
        isUsed = new boolean[user_id.length];
        cur_id = new String[banned_id.length];
        
        bTracking(user_id, banned_id, cur_id, banned_id.length, 0);
        
        // System.out.println("정답");
        // for (List<String> s: set){
        //     for (String str : s){
        //         System.out.print(str + " ");
        //     }
        //     System.out.println();
        // }
        return set.size();
    }
}