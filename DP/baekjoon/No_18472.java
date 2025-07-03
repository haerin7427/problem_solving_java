package DP.baekjoon;

// 문제 : 함께 블록 쌓기
// 풀이 일자 : 2025.07.01
// 설명 : https://www.acmicpc.net/problem/18427

import java.util.*;
import java.io.*;

public class No_18472 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] dp = new int[501][h+1];
        int block_index = 0;
        int pre_student_last_block = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            
            while (st.countTokens() > 0) {
                block_index += 1;
                int block = Integer.parseInt(st.nextToken());

                for(int height=1; height<=h; height++) {
                    if(block > height) {
                        dp[block_index][height] = dp[block_index-1][height];
                    }else if(block == height) {
                        dp[block_index][height] += (dp[block_index-1][height] + 1) % 10007;
                    }else {
                        dp[block_index][height] += (dp[block_index-1][height] + dp[pre_student_last_block][height-block]) % 10007;
                    }
                }
            }
            pre_student_last_block = block_index;
        }

        int answer = dp[block_index][h];
        System.out.println(answer);
    }
}