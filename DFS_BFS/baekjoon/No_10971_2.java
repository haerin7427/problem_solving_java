package DFS_BFS.baekjoon;

// 문제 : 외판원 순회 2
// 풀이 일자 : 2026.04.15
// 설명 : https://www.acmicpc.net/problem/10971

import java.io.*;
import java.util.*;

public class No_10971_2 {
    private static int best_route = 10000000;
    private static int n;
    private static int[][] graph;
    private static boolean[] visited;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new InputStreamReader(System.in));

        n = Integer.parseInt(sc.nextLine());
        graph = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st;
        for(int y=0; y<n; y++) {
            st = new StringTokenizer(sc.nextLine());
            for(int x=0; x<n; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(best_route);
    }

    private static void dfs(int current_node, int first_node, int th, int weight) {

        if(th == n-1) {
            if(graph[current_node][first_node] > 0 && best_route > weight + graph[current_node][first_node]) {
                best_route = weight + graph[current_node][first_node];
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i] && graph[current_node][i] > 0 && best_route > weight + graph[current_node][i]) {
                visited[i] = true;
                dfs(i, first_node, th+1, weight + graph[current_node][i]);
                visited[i] = false;
            }
        }
    }
}