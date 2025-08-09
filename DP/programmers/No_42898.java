package DP.programmers;


// 문제 : 등굣길
// 풀이 일자 : 2025.08.09
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/42898

public class No_42898 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
    
            int[][] dp = new int[n+1][m+1];
            for(int[] puddle : puddles) {
                dp[puddle[1]][puddle[0]] = -1;
            }
            
            for(int y=1; y<=n; y++) {
                for(int x=1; x<=m; x++) {
                    if(x == 1 && y == 1) {
                        dp[y][x] = 1;
                    }else if(dp[y][x] == -1) {
                        dp[y][x] = 0;
                    }else {
                        dp[y][x] = ((dp[y][x-1] + dp[y-1][x]) % 1000000007);
                    }
                }
            }
            
            return dp[n][m];
        }
    }
}