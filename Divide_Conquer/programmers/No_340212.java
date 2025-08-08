package Divide_Conquer.programmers;

// 문제 : 퍼즐 게임 챌린지
// 풀이 일자 : 2025.08.08
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/340212?language=java

public class No_340212 {
    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            
            for(int time : times) {
                limit -= time;
            }
            int left = 1, right = 1000000;
            int answer = 1000000;
            while(left < right) {
                int level = (left + right) / 2;
                if(find_minimum_level(diffs, times, level, limit)){
                    answer = Math.min(answer, level);
                    right = level;
                }else {
                    left = level+1;
                }
            }
            return answer;
        }
        
        private boolean find_minimum_level(int[] diffs, int[] times, int level, long limit) {
            long sum_time = 0;
            for(int i=1; i<diffs.length; i++) {
                if(diffs[i] > level) {
                    sum_time += ( (diffs[i] - level) * (times[i] + times[i-1]));
                    if(sum_time > limit) {
                        return false;
                    }
                }
            }
            
            return true;
        }
    }
}
