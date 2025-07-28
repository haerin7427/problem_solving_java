package DFS_BFS.baekjoon;

// 문제 : 외판원 순회 2
// 풀이 일자 : 2025.07.28
// 설명 : https://www.acmicpc.net/problem/10971

import java.util.*;
import java.io.*;

public class No_10971 {
    static int minimum_cost, n, current_cost, count_cities, first_node;
    static boolean[] visited;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        minimum_cost = (n-1) * 1000000;
        board = new int[n][n];

        StringTokenizer st;
        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            current_cost = 0;
            count_cities = 1;
            visited[i] = true;
            first_node = i;
            dfs(i);
        }
        System.out.println(minimum_cost);
    }
    
    private static void dfs(int node) {
        if(count_cities == n) {
            if(board[node][first_node] != 0) {
                if(minimum_cost > current_cost + board[node][first_node]) {
                    minimum_cost = (current_cost + board[node][first_node]);
                }
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i] && board[node][i] != 0 && (minimum_cost > current_cost + board[node][i])) {
                current_cost += board[node][i];
                visited[i] = true;
                count_cities += 1;
                dfs(i);
                current_cost -= board[node][i];
                visited[i] = false;
                count_cities -= 1;
            }
        }
        
    }
}