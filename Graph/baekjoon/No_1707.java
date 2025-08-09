package Graph.baekjoon;

// 문제 : 이분 그래프
// 풀이 일자 : 2025.08.09
// 설명 : https://www.acmicpc.net/problem/1707

import java.util.*;
import java.io.*;

public class No_1707 {
    static StringBuffer answer = new StringBuffer();
    static boolean[] visited;
    static int[] colored;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer();
        StringTokenizer st ;
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[v+1];
            for(int j=0; j<=v; j++) {
                graph[j] = new ArrayList<>();
            }

            for(int j=0; j<e; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph[v1].add(v2);
                graph[v2].add(v1);
            }

            visited = new boolean[v+1];
            colored = new int[v+1];
            boolean right_graph = true;

            for(int j=1; j<=v; j++) {
                if(!visited[j] && !bfs(j, v, graph)) {
                    right_graph = false;
                    break;
                }
            }

            if(right_graph) {
                answer.append("YES\n");
            }else{
                answer.append("NO\n");
            }
        }

        System.out.print(answer);
    }

    private static boolean bfs(int start_node, int v, List<Integer>[] graph) {


        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_node);
        visited[start_node] = true;
        colored[start_node] = 1;

        while(!queue.isEmpty()) {
            int node = queue.remove();
            for(int next : graph[node]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    colored[next] = (-1) * colored[node];
                }else if(colored[node] * colored[next] == 1){
                    return false;
                }
            }
        }
        return true;
    }
}