package Implementation.programmers;

// 문제 : [PCCP 기출문제] 1번 / 붕대 감기
// 풀이 일자 : 2025.10.24
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/250137

public class No_250137 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int current_health = health;
            int time = 1;
            int cnt = 0;
            for(int[] attack : attacks) {
                while(time < attack[0]) {
                    cnt += 1;
                    current_health += bandage[1];
                    
                    if(cnt == bandage[0]) {
                        current_health += bandage[2];
                        cnt = 0;
                    }
                                    
                    if(current_health > health) {
                        current_health = health;
                    }
                    time += 1;
                }
                
                current_health -= attack[1];
                cnt = 0;
                if(current_health <= 0) {
                    break;
                }
                time += 1;
            }
            
            int answer = current_health <= 0 ? -1 : current_health;
            return answer;
        }
    }
}
