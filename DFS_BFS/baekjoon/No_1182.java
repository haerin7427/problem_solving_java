package DFS_BFS.baekjoon;

// 문제 : 부분수열의 합
// 풀이 일자 : 2025.07.28
// 설명 : https://www.acmicpc.net/problem/1182

import java.util.*;
import java.io.*;

public class No_1182 {
    static int n, s, count_the_case;
    static int[] values;
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        values = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        count_the_case = 0;
        dfs(0, 0);
        if(s == 0) {
            count_the_case -= 1;
        }
        System.out.println(count_the_case);
    }

    private static void dfs(int node_idx, int sum) {
        if(node_idx == n) {
            if(s == sum) {
                count_the_case += 1;
            }
            return;
        }

        dfs(node_idx+1, sum + values[node_idx]);
        dfs(node_idx+1, sum);
    }
}