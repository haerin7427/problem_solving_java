package DP.baekjoon;

// 문제 : 가장 긴 증가하는 부분 수열
// 풀이 일자 : 2025.02.07 구글링 참고
// 설명 : https://www.acmicpc.net/problem/11053

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No_11053 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];
        int[] dp = new int[N];
        int max = 1;
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;

            for(int j = 0; j<i; j++) {
                if(array[j] < array[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
                
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
