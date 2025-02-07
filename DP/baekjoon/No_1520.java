package DP.baekjoon;

// 문제 : 내리막 길
// 풀이 일자 : 2025.02.08, 구글링
// 설명 : https://www.acmicpc.net/problem/1520

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No_1520 {

    static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int height;
    static int width;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());


        board = new int[height][width];
        dp = new int[height][width];
        for(int y=0; y<height; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<width; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<height; y++) {
            for(int x=0; x<width; x++) {
                dp[y][x] = -1;
            }
        }

        System.out.println(count_the_way(0, 0));

    }


    static int count_the_way (int y, int x) {
        
        if(y + 1 == height && x + 1 == width) {
            return 1;
        }

        if(dp[y][x] == -1) {
        
            dp[y][x] = 0;
            for(int i=0; i<move.length; i++) {
                int ny = y + move[i][0];
                int nx = x + move[i][1];

                if(nx < 0 || ny < 0 || nx >= width || ny >= height) continue;
                if(board[y][x] > board[ny][nx]) {
                    dp[y][x] += count_the_way(ny, nx);
                }
            }
        }

        return dp[y][x];
    }
}
