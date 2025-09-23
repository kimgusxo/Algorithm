class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int hp = health;
        int[] time = new int[attacks[attacks.length-1][0]+1];
        
        // 배열 만들어서 미리 박아놓고 순회시키면 될거같음
        for(int i = 0; i < attacks.length; i++) {
            time[attacks[i][0]] = attacks[i][1];
        }
        
        int t = bandage[0];
        int heal = bandage[1];
        int bonus = bandage[2];
        
        int idx = 0;
        for(int el : time) {
            if(el == 0) {
                hp = hp+heal > health ? health : hp+heal;
                idx++;
                if(idx == t) {
                    hp = hp+bonus > health ? health : hp+bonus;
                    idx = 0;
                }
            } else {
                hp -= el;
                idx = 0;
                
                if(hp <= 0) return -1;
            }
        }
        
        return hp;
    }
}