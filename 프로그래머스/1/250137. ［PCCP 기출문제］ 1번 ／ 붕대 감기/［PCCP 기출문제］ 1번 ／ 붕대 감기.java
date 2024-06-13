import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int skillTime = bandage[0];
        int heal = bandage[1];
        int plusHeal = bandage[2];
        int endTime = attacks[attacks.length - 1][0];
        int hp = health;
        int time = 0;
        int j = 0;
        for(int i = 0; i <= endTime; i++) {
            
            if(i == attacks[j][0]){
                time = 1;
                hp -= attacks[j][1];
                if(hp <= 0) {
                    return -1;
                }
                if(j < attacks.length - 1) j++;
                // System.out.println(hp);
                continue;
            }
            if(time == skillTime) {
                System.out.println("i : " + i + " time : " + time + " hp : " + hp);
                hp = hp + plusHeal + heal;
                if(hp > health) hp = health;
                time = 1;
                // System.out.println(hp);
                continue;
            }
            if(hp < health){
                hp = hp + heal;
                if(hp > health) hp = health;
                time++;
                // System.out.println(hp);
            }
        }
        
        return hp <= 0 ? -1 : hp;
    }
}