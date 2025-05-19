package Graph.baekjoon;

// 문제 : 효율적인 해킹
// 풀이 일자 : 2025.05.19
// 설명 : https://www.acmicpc.net/problem/1325

import java.util.*;
import java.io.*;

public class No_1325 {
    static List<Integer>[] graph;
    static int[] check;
    static boolean[] visited;
    static StringBuffer answer = new StringBuffer();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        check = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[b].add(a);
        }

        int max = 1;
        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];
            bfs(i);

        }

        for(int i=1; i<=n; i++) {
            if(check[i] < max) {
                max = check[i];
            }
        }

        for(int i=1; i<=n; i++) {
            if(check[i] == max) {
                answer.append(i + " ");
            }
        }
        System.out.printf(answer.toString());
    }

    static void bfs(int root_node) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root_node);
        visited[root_node] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();

            for(int i=0; i<graph[node].size(); i++) {
                int next_node = graph[node].get(i);
                if(!visited[next_node]){
                    visited[next_node] = true;
                    check[next_node]++;
                    queue.add(next_node);
                    
                }
            }
        }
    }
}
