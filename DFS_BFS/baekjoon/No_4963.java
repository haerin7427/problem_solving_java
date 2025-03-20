package DFS_BFS.baekjoon;

// 문제 : 섬의 개수
// 풀이 일자 : 2025.03.20
// 설명 : https://www.acmicpc.net/problem/4963

import java.util.*;
import java.io.*;

public class No_4963 {
    private static int[][] board;
    private static boolean[][] visited;
    private static int[][] move = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,-1}, {-1,1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuffer sb = new StringBuffer();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            board = new int[h][w];
            for(int y=0; y<board.length; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<board[0].length; x++){
                    board[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int count_island = 0;
            visited = new boolean[h][w];
            for(int y=0; y<board.length; y++) {
                for(int x=0; x<board[0].length; x++){
                    if(board[y][x] == 1 && !visited[y][x]) {
                        count_island += 1;
                        dfs(y, x);
                    }
                }
            }
            sb.append(count_island).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int[] m : move) {
            int new_y = y + m[0];
            int new_x = x + m[1];

            if(new_x < 0 || new_x >= board[0].length || new_y < 0 || new_y >= board.length) continue;
            if(board[new_y][new_x] == 0 || visited[new_y][new_x]) continue;

            dfs(new_y, new_x);
        }
    }
    
}
