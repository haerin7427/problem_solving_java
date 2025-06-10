package DFS_BFS.baekjoon;

// 문제 : 순열 사이클
// 풀이 일자 : 2025.05.13
// 설명 : https://www.acmicpc.net/problem/10451

import java.util.*;
import java.io.*;

public class No_10451 {
    static int[] arr;
	static boolean[] visited;
	static int cycle;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer answer = new StringBuffer();

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N+1];
            for(int j=1; j<=N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N+1];
            cycle = 0;
            for(int j=1; j<=N; j++) {
				if(!visited[j]) {
					dfs(j);
					cycle += 1;
				}
			}
			answer.append(cycle + "\n");
        }
        System.out.print(answer);
    }

    static void dfs(int start) {
		visited[start]= true;
		
		int next= arr[start];
		if(!visited[next]) {
			dfs(arr[start]);
		}
		
	}
    
}
