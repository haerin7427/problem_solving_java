package DFS_BFS.baekjoon;

// 문제 : 유기농 배추
// 풀이 일자 : 2025.06.02
// 설명 : https://www.acmicpc.net/problem/1012

import java.util.*;
import java.io.*;

public class No_1012 {

    static int[][] board;
    static boolean[][] visited;
    static StringBuffer answer = new StringBuffer();
    static int[][] move = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int h=0; h<t; h++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int col = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            board = new int[row][col];
            for(int i=0; i<count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            }

            int bug_count = 0;
            visited = new boolean[row][col];
            for(int y=0; y<row; y++) {
                for(int x=0; x<col; x++) {
                    
                    if(board[y][x] == 0 || visited[y][x]) continue;

                    bug_count += 1;
                    dfs(y, x);
                }
            }
            answer.append(bug_count+"\n");
        }
        System.out.print(answer);
    }


    static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int[] m : move) {
            int new_y = y+m[0];
            int new_x = x+m[1];

            if(new_y < 0 || new_x < 0 || new_y >= board.length || new_x >= board[0].length) continue;
            if(board[new_y][new_x] == 0 || visited[new_y][new_x]) continue;

            dfs(new_y, new_x);
        }
    }
    
}
