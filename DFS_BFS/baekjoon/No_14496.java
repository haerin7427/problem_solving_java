package DFS_BFS.baekjoon;

// 문제 : 그대, 그머가 되어
// 풀이 일자 : 2025.06.03
// 설명 : https://www.acmicpc.net/problem/14496

import java.io.*;
import java.util.*;

public class No_14496 {

    public static class Node {
        int value;
        int level;

        Node(int v, int l) {
            value = v;
            level = l;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new List[n+1];
        for(int i=0; i<=n; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            list[v1].add(v2);
            list[v2].add(v1);
        }

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int answer = -1;
        if(a == b) {
            answer = 0;
        } else {
            queue.add(new Node(a, 0));
            visited[a] = true;
        }

        while (!queue.isEmpty()) {
            Node now = queue.remove();

            for(int next : list[now.value]) {
                if(visited[next]) continue;

                visited[next] = true;
                queue.add(new Node(next, now.level+1));
                if(next == b) {
                    answer = now.level + 1;
                    break;
                }
            }

            if(answer != -1) {
                break;
            }
        }

        System.out.println(answer);
    }
}
