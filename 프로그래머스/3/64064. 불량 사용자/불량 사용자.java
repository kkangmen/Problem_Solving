import java.util.*;

class Solution {
    
    boolean[] isUsed;
    Set<List<String>> set = new HashSet<>();
    
    public boolean isPossible(String banId, String userId){
        
        boolean flag = true;
        
        if (banId.length() != userId.length()){
            return false;
        }
        
        for (int i = 0; i < banId.length(); i++){
            char banCh = banId.charAt(i);
            char userCh = userId.charAt(i);
            
            if (banCh != '*' && (banCh != userCh)){
                return false;
            }
        }
        
        // System.out.println("banId: " + banId + " userId: " + userId + " 가능하다");
        return true;
    }
    
    public void dfs(String[] user_id, String[] banned_id, List<String> curList){
        if (curList.size() == banned_id.length){
            // set에 추가
            List<String> copy = new ArrayList<>(curList);
            Collections.sort(copy);
            
            set.add(copy);
            
            // for (int i = 0; i < curList.size(); i++){
            //     System.out.print(curList.get(i) + " ");
            // }
            // System.out.println();
            return;
        }
        
        for (int i = 0; i < user_id.length; i++){
            if (isPossible(banned_id[curList.size()], user_id[i])
               && !isUsed[i]){
                isUsed[i] = true;
                curList.add(user_id[i]);
                dfs(user_id, banned_id, curList);
                isUsed[i] = false;
                curList.remove(curList.size()-1);
            }
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        List<String> curList = new ArrayList<>();
        isUsed = new boolean[user_id.length];
        
        dfs(user_id, banned_id, curList);
        
        // for (List<String> list: set){
        //     for (String s : list){
        //         System.out.print(s + " ");
        //     }
        //     System.out.println();
        // }
        return set.size();
    }
}