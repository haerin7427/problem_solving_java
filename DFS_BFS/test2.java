package DFS_BFS;

import java.util.Scanner;

public class test2 {
    private static int[][] move = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int[][] ground;
    private static boolean[][] visited;
    private static int M, N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer answer = new StringBuffer();

        for(int i=0; i<T; i++) {
            M = sc.nextInt();
            N = sc.nextInt();

            ground = new int[N][M];
            visited = new boolean[N][M];
            int K = sc.nextInt();

            for(int j=0; j<K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();

                ground[Y][X] = 1;
            }

            int bug_count = 0;
            for(int y=0; y<N; y++) {
                for(int x=0; x<M; x++) {
                    if(ground[y][x] == 1 && !visited[y][x]) {
                        bug_count += 1;
                        dfs(y, x);
                    }
                }
            }
            answer.append(bug_count + "\n");
        }
        System.out.print(answer.toString());
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int[] m : move) {
            int ny = y + m[0];
            int nx = x + m[1];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if(ground[ny][nx] == 0 || visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
