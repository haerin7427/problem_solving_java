package Greedy.programmers;

// 문제 : 기지국 설치
// 풀이 일자 : 2025.10.30
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/12979

public class No_12979 {
    class Solution {
        public int solution(int n, int[] stations, int w) {

            int answer = 0, start = 1, end = 0;
            for(int station : stations) {
                end = station - w - 1; // 전파가 안 닿는 끝 지점
                
                if(start <= end) {
                    answer += Math.ceil((end - start + 1) / (2.0 * w + 1));
                }
                start = station + w + 1;
            }
            
            if(start <= n) {
                end = n;
                answer += Math.ceil((end - start + 1) / (2.0 * w + 1));
            }

            return answer;
        }
    }
}
