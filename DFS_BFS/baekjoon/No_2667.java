package DFS_BFS.baekjoon;

// 문제 : 단지번호붙이기
// 풀이 일자 : 2025.03.19
// 설명 : https://www.acmicpc.net/problem/2667

import java.io.*;
import java.util.*;

public class No_2667 {

    private static int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    private static int[][] board;
    private static boolean[][] visited;
    private static int count_house;
    private static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                board[i][j] = str.charAt(j) == '0' ? 0 : 1;
            }
        }


        int count_section = 0;
        visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(board[i][j] == 1 && !visited[i][j]) {
                    count_section += 1;
                    count_house = 0;
                    dfs(i, j);
                    list.add(count_house);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(count_section).append("\n");
        Collections.sort(list);
        for(int num : list){
            answer.append(num).append("\n");
        }
        System.out.println(answer);
    }

    public static void dfs (int y, int x) {
        visited[y][x] = true;
        count_house += 1;

        for(int i=0; i<move.length; i++){
            int newY = y + move[i][0];
            int newX = x + move[i][1];

            if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
            if(board[newY][newX] == 0 || visited[newY][newX]) continue;

            dfs(newY, newX);
        }
    }
}
