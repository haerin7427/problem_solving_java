package DP.programmers;

// 문제 : 사칙연산
// 풀이 일자 : 2025.10.30
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/1843

import java.util.*;
public class No_1843 {
    class Solution {
        public int solution(String arr[]) {
            int n = arr.length / 2 + 1;
            int[][] dp_max = new int[n][n];
            int[][] dp_min = new int[n][n];
            
            for(int i=0; i<n; i++) {
                Arrays.fill(dp_max[i], Integer.MIN_VALUE);
                Arrays.fill(dp_min[i], Integer.MAX_VALUE);
                
                dp_max[i][i] = Integer.parseInt(arr[2*i]);
                dp_min[i][i] = Integer.parseInt(arr[2*i]);
            }
            
            for(int len = 1; len < n; len++) {
                for(int start=0; start < n-len; start++) {
                    int end = start + len;
                    
                    for(int k=start; k<end; k++) {
                        String operator = arr[2*k+1];
                        
                        if(operator.equals("+")) {
                            dp_max[start][end] = Math.max(dp_max[start][end], dp_max[start][k] + dp_max[k+1][end]);
                            dp_min[start][end] = Math.min(dp_min[start][end], dp_min[start][k] + dp_min[k+1][end]);
                        }else {
                            dp_max[start][end] = Math.max(dp_max[start][end], dp_max[start][k] - dp_min[k+1][end]);
                            dp_min[start][end] = Math.min(dp_min[start][end], dp_min[start][k] - dp_max[k+1][end]);
                        }
                    }
                }
            }
            
            int answer = dp_max[0][n-1];
            return answer;
        }
    }
}
