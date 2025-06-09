package DP.baekjoon;

// 문제 : 설탕 배달
// 풀이 일자 : 2025.06.09
// 설명 : https://www.acmicpc.net/problem/2839

import java.io.*;

public class No_2839 {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1]; // dp[i] = i킬로그램의 설탕을 배달해야할 때 봉지 수 (3, 5킬로그램의 봉지로 배달할 수 없을 경우 : -1)
        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        if(n>=4) {dp[4] = -1;}
        if(n>=5) {dp[5] = 1;}

        for(int i=6; i<=n; i++) {
            dp[i] = count_bag(i) ;
        }
        System.out.println(dp[n]);
    }

    private static int count_bag (int n) {
        int case1=-1, case2=-1;
        if(dp[n-5] != -1) {
            case1 = dp[n-5] + 1;
        }
        if(dp[n-3] != -1) {
            case2 = dp[n-3] + 1;
        }


        if(case1 == -1 && case1 == case2) {
            return -1;
        }else if(case1 == -1 && case1 != case2) {
            return case2;
        }else if(case2 == -1 && case1 != case2) {
            return case1;
        }else {
            return Math.min(case1, case2);
        }
    }
    
}
