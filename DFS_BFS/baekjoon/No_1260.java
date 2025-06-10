package DFS_BFS.baekjoon;

// 문제 : DFS와 BFS
// 풀이 일자 : 2025.05.15(2)
// 설명 : https://www.acmicpc.net/problem/1260

import java.io.*;
import java.util.*;

public class No_1260 {
    static int[][] board;
    static boolean[] visited;
    static StringBuffer answer = new StringBuffer();

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        board = new int[n+1][n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            board[n1][n2] = 1;
            board[n2][n1] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);

        answer.append("\n");
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(answer.toString());
    }

    private static void dfs(int node) {
        visited[node] = true;
        answer.append(node + " ");

        for(int i=1; i<board.length; i++) {
            if(!visited[i] && board[node][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int root_node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root_node);
        visited[root_node] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.remove();
            answer.append(current_node + " ");

            for(int i=1; i<board.length; i++) {
                if(board[current_node][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
