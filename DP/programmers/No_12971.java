package DP.programmers;

// 문제 : 스티커 모으기(2)
// 풀이 일자 : 2026.06.25
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/12971

public class No_12971 {
    class Solution {
        public int solution(int sticker[]) {
            int answer = 0;
            int n = sticker.length;
            
            if(n < 4) {
                for(int i=0; i<n; i++) {
                    if(answer < sticker[i]) {
                        answer = sticker[i];
                    }
                }
                
                return answer;
            }

            int[][] no_first_sticker = new int[n][2];
            no_first_sticker[1][0] = sticker[1]; 
            no_first_sticker[1][1] = 0;
            
            for(int i=2; i<n; i++) {
                no_first_sticker[i][0] = sticker[i] + no_first_sticker[i-1][1];
                no_first_sticker[i][1] = Math.max(no_first_sticker[i-1][0], no_first_sticker[i-1][1]);
            }
            answer = Math.max(no_first_sticker[n-1][0], no_first_sticker[n-1][1]);
            
            
            int[][] yes_first_sticker = new int[n][2];
            yes_first_sticker[2][0] = sticker[0] + sticker[2]; 
            yes_first_sticker[2][1] = sticker[0];
            
            for(int i=3; i<n-1; i++) {
                yes_first_sticker[i][0] = sticker[i] + yes_first_sticker[i-1][1];
                yes_first_sticker[i][1] = Math.max(yes_first_sticker[i-1][0], yes_first_sticker[i-1][1]);
            }
            answer = Math.max(answer, Math.max(yes_first_sticker[n-2][0], yes_first_sticker[n-2][1]));
            
            

            return answer;
        }
    }
    
}
