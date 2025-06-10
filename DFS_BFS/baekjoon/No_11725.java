package DFS_BFS.baekjoon;

// 문제 : 트리의 부모 찾기
// 풀이 일자 : 2025.05.15(2)
// 설명 : https://www.acmicpc.net/problem/11725

import java.io.*;
import java.util.*;

public class No_11725 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new List[n+1];
        int[] parent_node = new int[n+1];
        boolean[] visited = new boolean[n+1];

        for(int i=0; i<=n; i++) {
            tree[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int node = queue.remove();

            for(int i=0; i< tree[node].size(); i++) {
                int child_node = tree[node].get(i);
                if(!visited[child_node]) {
                    parent_node[child_node] = node;
                    visited[child_node] = true;
                    queue.add(child_node);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=2; i<=n; i++) {
            sb.append(parent_node[i] + "\n");
        }
        System.out.print(sb.toString());
    }
    
}
