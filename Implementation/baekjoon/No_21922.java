package Implementation.baekjoon;

// 문제 : 학부 연구생 민상
// 풀이 일자 : 2025.06.10
// 설명 : https://www.acmicpc.net/problem/21922

import java.io.*;
import java.util.*;

public class No_21922 {
    static Queue<Node> queue = new LinkedList<>();
    static int[][] move = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][][] visited;
    static boolean[][] possible;
    static int[][] board;

    private static class Node {
        int y;
        int x;
        int direction;

        Node(int y, int x, int d) {
            this.y = y;
            this.x = x;
            direction = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        possible = new boolean[n][m];
        visited = new boolean[n][m][4];

        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                if(board[y][x] == 9) {
                    for(int i=0; i<move.length; i++) {
                        visit_node(y, x, i);
                    }
                }

            }
        }

        while(!queue.isEmpty()) {
            Node now = queue.remove();

            int new_y = now.y + move[now.direction][0];
            int new_x = now.x + move[now.direction][1];

            if(new_y < 0 || new_y >= n || new_x < 0 || new_x >= m) continue;


            if(now.direction % 2 == 0) { // 세로
                if(board[new_y][new_x] == 2 ) {
                    visited[new_y][new_x][now.direction] = true;
                    possible[new_y][new_x] = true;
                    continue;
                }
                
                int new_direction = now.direction;
                if(board[new_y][new_x] == 3) {
                    new_direction = now.direction == 2 ? 1 : 3;
                }else if(board[new_y][new_x] == 4) {
                    new_direction = now.direction == 2 ? 3 : 1;
                }
                visit_node(new_y, new_x, new_direction);

            }else { // 가로
                if(board[new_y][new_x] == 1 ) {
                    visited[new_y][new_x][now.direction] = true;
                    possible[new_y][new_x] = true;
                    continue;
                }
                
                int new_direction = now.direction;
                if(board[new_y][new_x] == 3) {
                    new_direction = now.direction == 1 ? 2 : 0;
                }else if(board[new_y][new_x] == 4) {
                    new_direction = now.direction == 1 ? 0 : 2;
                }

                visit_node(new_y, new_x, new_direction);
                
            }
        }

        int count = 0;
        for(int y=0; y<n; y++) {
            for(int x=0; x<m; x++) {
                if(possible[y][x]) {
                    count += 1;
                } 
            }
        }
        System.out.println(count);
    }

    private static void visit_node(int y, int x, int direction) {
        if(!visited[y][x][direction]) {
            queue.add(new Node(y, x, direction));
            visited[y][x][direction] = true;
            possible[y][x] = true;
        }
    }
    
}