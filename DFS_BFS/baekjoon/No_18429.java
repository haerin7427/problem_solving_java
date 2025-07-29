package DFS_BFS.baekjoon;

// 문제 : 근손실
// 풀이 일자 : 2025.07.29
// 설명 : https://www.acmicpc.net/problem/18429

import java.util.*;
import java.io.*;

public class No_18429 {
    static int n, k;
    static int[] tools;
    static boolean[] used;
    static int current_status = 500;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tools = new int[n];
        used = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            tools[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int index) {
        if(index == n) {
            answer += 1;
            return;
        }

        for(int i = 0; i<n; i++) {
            if(used[i]) continue;
            if(current_status + tools[i] - k < 500) continue;

            used[i] = true;
            current_status += (tools[i] - k);
            dfs(index+1);
            used[i] = false;
            current_status -= (tools[i] - k);
        }
    }
}