package DP.baekjoon;

// 문제 : 호텔
// 풀이 일자 : 2025.06.17
// 설명 : https://www.acmicpc.net/problem/1106

import java.util.*;
import java.io.*;

public class No_1106 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] cost = new int[n];
        int[] customer = new int[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[c+1];
        int[] limit = new int[c+1];
        for(int i=1; i<=c; i++) {
            int min_cost = 100001;
            int max_customer = 0;

            for(int j=0; j<n; j++) {
                if(customer[j] > i) {
                    if(min_cost > cost[j]) {
                        min_cost = cost[j];
                        max_customer = customer[j];
                    }
                }else if(customer[j] == i) {
                    min_cost = Math.min(min_cost, cost[j]);
                    max_customer = i;
                }else {
                    if(limit[i-customer[j]] >= i && min_cost > dp[i-customer[j]]) {
                        min_cost = dp[i-customer[j]];
                        max_customer = limit[i-customer[j]];
                    }else if(min_cost > dp[i-customer[j]] + cost[j]) {
                        min_cost = dp[i-customer[j]] + cost[j];
                        max_customer = limit[i-customer[j]] + customer[j];
                    }                    
                }
            }

            dp[i] = min_cost;
            limit[i] = max_customer;
        }
       
        System.out.println(dp[c]);
    }
    
}
