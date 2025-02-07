package DP.baekjoon;

// 문제 : 평범한 배낭
// 풀이 일자 : 2025.02.07 구글링 참고
// 설명 : https://www.acmicpc.net/problem/12865

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_12865 {
    static Integer[][] dp;
    static List<Product> products;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        products = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            products.add(new Product(W,V));
        }

        dp = new Integer[N][K+1];
        System.out.println(knapSack(N-1, K));
    }

    static int knapSack(int n, int k) {

        if(n < 0) {
            return 0;
        }

        if(dp[n][k] == null) {
            if(products.get(n).weight > k) {
                dp[n][k] = knapSack(n-1, k);
            }else {
                dp[n][k] = Math.max(knapSack(n-1, k-products.get(n).weight)+products.get(n).value, knapSack(n-1, k));
            }
        }

        return dp[n][k];
    }

    static class Product {
        int weight;
        int value;

        Product(int W, int V) {
            weight = W;
            value = V;
        }
    }
}
