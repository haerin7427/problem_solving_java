package DFS_BFS.baekjoon;

// 문제 : 그림
// 풀이 일자 : 2025.02.26
// 설명 : https://www.acmicpc.net/problem/1926

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1926 {
    
    static int n, m, count=0, max_picture=0;
    static int[][] board;
    static boolean[][] visited;
    static int[][] move = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count_one = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 1 && !visited[i][j]) {
                    count_one += 1;
                    count = 0;
                    dfs(i, j);

                    if(max_picture < count) {
                        max_picture = count;
                    }
                }
            }
        }

        System.out.println(count_one);
        System.out.print(max_picture);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        count += 1;

        for(int i=0; i<4; i++) {
            int ny = y + move[i][0];
            int nx = x + move[i][1];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(board[ny][nx] == 0 || visited[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
