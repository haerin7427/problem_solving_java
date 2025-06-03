package DFS_BFS.baekjoon;

// 문제 : 점프 점프
// 풀이 일자 : 2025.06.03
// 설명 : https://www.acmicpc.net/problem/14248


import java.util.*;
import java.io.*;

public class No_14248 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] bridge = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }
        int initial = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> answer = new HashSet<>();
        boolean[] visited = new boolean[n+1];

        queue.add(initial);
        visited[initial] = true;

        while(!queue.isEmpty()) {
            int now = queue.remove();
            answer.add(now);

            int next_right = now + bridge[now];
            int next_left = now - bridge[now];

            if(next_right <= n && !visited[next_right]) {
                visited[next_right] = true;
                queue.add(next_right);
            }

            if(next_left > 0 && !visited[next_left]) {
                visited[next_left] = true;
                queue.add(next_left);
            }
        }
        System.out.println(answer.size());
    }
}
