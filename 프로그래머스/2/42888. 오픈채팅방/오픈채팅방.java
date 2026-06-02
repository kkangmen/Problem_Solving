import java.util.*;

class Solution {
    
    static Map<String, String> userMap = new HashMap<>();
    static List<String> message = new ArrayList<>();
    
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        for (String s : record){
            String[] log = s.split(" ");
            String action = log[0];
            String uid = log[1];
            String name = "";
            switch(action){
                case "Enter":
                    name = log[2];
                    userMap.put(uid, name);
                    message.add(uid+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    message.add(uid+"님이 나갔습니다.");
                    break;
                case "Change":
                    name = log[2];
                    userMap.put(userMap.getOrDefault(0, uid), name);
                    break;
            }
        }
        
        // for (String s : userMap.keySet()){
        //     System.out.println(s + ", " + userMap.get(s));
        // }
        
        for (String s : message){
            String[] text = s.split(" ");
            String front = text[0];
            String uid = front.substring(0, front.length()-2);
            // System.out.println(uid);
            
            String name = userMap.get(uid);
            s = s.replace(uid, name);
            answer.add(s);
        }
        
        // for (String s : message){
        //     System.out.println(s);
        // }
        return answer;
    }
}