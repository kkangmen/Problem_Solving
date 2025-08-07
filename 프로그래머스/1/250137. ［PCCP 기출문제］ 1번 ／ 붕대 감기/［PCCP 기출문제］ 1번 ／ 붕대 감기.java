import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int bonusSuccestion = bandage[0];
        int heal = bandage[1];
        int bonusHp = bandage[2];
        int hp = health;
        int currTime = 1;
        int maxTime = 0;
        int attackTime = 0;
        int curSuccestion = 0;
        for (int[] i : attacks){
            maxTime = Math.max(maxTime, i[0]);
        }
        
        while (currTime <= maxTime){
            System.out.print("currTime = " + currTime);
            
            if (currTime == attacks[attackTime][0]){
                hp -= attacks[attackTime][1];
                attackTime++;
                curSuccestion = 0;
                if (hp <= 0){
                    return -1;
                }
            }
            else {
                curSuccestion++;
                if (curSuccestion == bonusSuccestion){
                    // System.out.println("success");
                    hp += bonusHp;
                    hp += heal;
                    curSuccestion = 0;
                }
                else {
                    hp += heal;
                }
                
                if (hp > health){
                    hp = health;
                }
            }
            System.out.print(" hp = " + hp);
            System.out.println(" curSuccestion = " + curSuccestion);
            currTime += 1;
        }
        return hp;
    }
}