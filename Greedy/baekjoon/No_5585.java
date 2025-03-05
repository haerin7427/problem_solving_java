package Greedy.baekjoon;

// 문제 : 거스름돈
// 풀이 일자 : 2025.03.05
// 설명 : https://www.acmicpc.net/problem/5585

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_5585 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = 1000 - Integer.parseInt(br.readLine());
        int[] coins = new int[]{500, 100, 50, 10, 5, 1};


        int count = 0;
        for(int coin : coins) {
            count += value / coin;
            value %= coin;
        }
        System.out.println(count);
    }
    
}
