package DFS_BFS;

import java.util.Scanner;

public class test {
    private static int N, M;
    private static int[][] arr;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                count += 1;
                dfs(i);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;
        
        for(int i=1; i<=N; i++) {
            if(arr[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}