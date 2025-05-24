package DFS_BFS.baekjoon;

// 문제 : 쉬운 최단거리
// 풀이 일자 : 2025.05.24
// 설명 : https://www.acmicpc.net/problem/14940

import java.util.*;
import java.io.*;

public class No_14940 {
    static int[][] input_board;
    static int[][] output_board;
    static boolean[][] visited;
    static int goal_x, goal_y;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        input_board = new int[n][m];
        output_board = new int[n][m];
        visited = new boolean[n][m];

        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++) {
                input_board[y][x] = Integer.parseInt(st.nextToken());

                if(input_board[y][x] == 2) {
                    goal_x = x;
                    goal_y = y;
                }
            }
        }

        bfs();

        StringBuffer sb = new StringBuffer();
        for(int y=0; y<n; y++) {
            for(int x=0; x<m; x++) {
                if(output_board[y][x] == 0 && input_board[y][x] == 1) {
                    sb.append("-1 ");
                }else {
                    sb.append(output_board[y][x] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    static class Node {
        int y; 
        int x;
        int distance;

        Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.distance = d;
        }
    }

    static void bfs() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(goal_y, goal_x, 0));
        visited[goal_y][goal_x] = true;

        int[][] move = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            Node current_node = queue.remove();
            output_board[current_node.y][current_node.x] = current_node.distance;

            for(int[] d : move) {
                int new_y = current_node.y + d[0];
                int new_x = current_node.x + d[1];
                int new_distance = current_node.distance + 1;

                if(new_x >= input_board[0].length || new_x < 0 || new_y >= input_board.length || new_y < 0 || visited[new_y][new_x] || input_board[new_y][new_x] != 1) {
                    continue;
                } else {
                    queue.add(new Node(new_y, new_x, new_distance));
                    visited[new_y][new_x] = true;
                }
            }
            
        }

    }
    
}
