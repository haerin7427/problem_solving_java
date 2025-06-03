package DFS_BFS.baekjoon;

// 문제 : 촌수계산
// 풀이 일자 : 2025.06.03
// 설명 : https://www.acmicpc.net/problem/2644

import java.io.*;
import java.util.*;

public class No_2644 {

    private static class Node {
        int value;
        int level;

        Node(int v, int l) {
            value = v;
            level = l;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken());
        int person2 = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new LinkedList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(new Node(person1, 0));
        visited[person1] = true;

        int answer = -1;
        while(!queue.isEmpty()) {
            Node now = queue.remove();

            for(int person : graph[now.value]) {
                if(visited[person]) continue;

                if(person2 == person) {
                    answer = now.level+1;
                    break;
                } else {
                    visited[person] = true;
                    queue.add(new Node(person, now.level+1));
                }
            }

            if(answer != -1) {
                break;
            }
        }
        System.out.println(answer);
    }
    
}
