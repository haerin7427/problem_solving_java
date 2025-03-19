package DFS_BFS.baekjoon;

// 문제 : DFS와 BFS
// 풀이 일자 : 2025.03.19
// 설명 : https://www.acmicpc.net/problem/1260

import java.io.*;
import java.util.*;

public class No_1260 {
    private static int[][] board;
    private static boolean[] visited;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        board = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            board[node1][node2] = 1;
            board[node2][node1] = 1;
        }        
        
        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);

    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        visited[node] = true;

        for(int i=1; i<=N; i++) {
            if(board[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs (int node) {
        List<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.remove(0);
            System.out.print(current_node + " ");

            for(int i=1; i<=N; i++) {
                if(board[current_node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            
        }
    }  
}
