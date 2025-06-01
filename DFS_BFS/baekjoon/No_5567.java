package DFS_BFS.baekjoon;

// 문제 : 결혼식
// 풀이 일자 : 2025.06.01
// 설명 : https://www.acmicpc.net/problem/5567

import java.util.*;
import java.io.*;

public class No_5567 {
    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new List[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        Set<Integer> friends = new HashSet<>();
        for(int node : graph[1]) {
            friends.add(node);
            for(int friend : graph[node]) {
                friends.add(friend);
            }
        }

        friends.remove(1);
        System.out.println(friends.size());
    }
    
}
