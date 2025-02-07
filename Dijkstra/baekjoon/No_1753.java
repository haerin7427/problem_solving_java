package Dijkstra.baekjoon;

// 문제 : 최단경로
// 풀이 일자 : 2025.02.08, 구글링
// 설명 : https://www.acmicpc.net/problem/1753

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No_1753 {

    static class Node {
        int vertex;
        int weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        int K = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[V+1];
        int[] dist = new int[V+1]; // dist[i] = K에서 i까지의 최단 경로

        boolean[] isVisited = new boolean[V+1];

        for(int i=1; i<=V; i++) {
            list[i] = new ArrayList<>();
            dist[i] = 2000000;
        }

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        dist[K] = 0;
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(!isVisited[cur.vertex]) {
                isVisited[cur.vertex] = true;

            }


            for(int i=0; i<list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);

                if(!isVisited[next.vertex] && dist[cur.vertex] + next.weight < dist[next.vertex]) {

                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++) {
            if(dist[i] == 2000000) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
    
}
