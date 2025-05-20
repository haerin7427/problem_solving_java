package DFS_BFS.baekjoon;

// 문제 : 연결 요소의 개수
// 풀이 일자 : 2025.05.20
// 설명 : https://www.acmicpc.net/problem/11724

import java.io.*;
import java.util.*;

public class No_11724 {
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        int answer = 0;
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                answer += 1;
                bfs(i);
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int root_node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root_node);
        visited[root_node] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.remove();

            for(int i=0; i<graph[current_node].size(); i++) {
                int next = graph[current_node].get(i);

                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
            
        }
    }
    
}
