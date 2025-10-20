package DP.programmers;

// 문제 : 멀리 뛰기
// 풀이 일자 : 2025.10.20
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/12914

public class No_12914 {
    class Solution {
        public long solution(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1; dp[1] = 1;
            
            for(int i=2; i<=n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            }
            long answer = dp[n];
            return answer;
        }
    }
}