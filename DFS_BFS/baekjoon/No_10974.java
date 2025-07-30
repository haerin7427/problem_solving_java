package DFS_BFS.baekjoon;

// 문제 : 모든 순열
// 풀이 일자 : 2025.07.30
// 설명 : https://www.acmicpc.net/problem/10974

import java.io.*;

public class No_10974 {
    static StringBuffer answer = new StringBuffer();
    static int n;
    static int[] array;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];
        visited = new boolean[n];

        dfs(0);
        System.out.print(answer);
    }

    private static void dfs (int index) {
        if(index == n) {
            for(int num : array) {
                answer.append(num + " ");
            }
            answer.append("\n");
            return;
        }

        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            array[index] = i+1;
            dfs(index+1);
            visited[i] = false;
        }
    }
}