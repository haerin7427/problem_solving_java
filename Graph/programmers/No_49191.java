package Graph.programmers;

// 문제 : 순위
// 풀이 일자 : 2025.10.29
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/49191?language=java

public class No_49191 {
    class Solution {
    
        public int solution(int n, int[][] results) {
            boolean[][] win_record = new boolean[n+1][n+1];
            boolean[][] lose_record = new boolean[n+1][n+1];
                    
            for(int[] result : results) {
                win_record[result[0]][result[1]] = true;
                lose_record[result[1]][result[0]] = true;
            }
            
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    for(int h=1; h<=n; h++) {
                        if(win_record[j][i] && win_record[i][h]) {
                            win_record[j][h] = true;
                        }
                        if(lose_record[j][i] && lose_record[i][h]) {
                            lose_record[j][h] = true;
                        }
                    }
                }
            }
            
            int answer = 0;
            for(int i=1; i<=n; i++) {
                int cnt = 0;
                for(int j=1; j<=n; j++) {
                    if(win_record[i][j] || lose_record[i][j]) {
                        cnt += 1;
                    }
                }
                if(cnt == n-1) {
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
