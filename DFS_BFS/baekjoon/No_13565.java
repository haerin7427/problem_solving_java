package DFS_BFS.baekjoon;

// 문제 : 침투
// 풀이 일자 : 2025.05.29
// 설명 : https://www.acmicpc.net/problem/13565

import java.util.*;
import java.io.*;

public class No_13565 {
    static int m,n;
    static int[][] board;
    static boolean[][] visited;
    private static int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};


    static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        visited = new boolean[m][n];
        for(int y=0; y<m; y++) {
            String str = br.readLine();
            for(int x=0; x<n; x++) {
                board[y][x] = str.charAt(x) - '0';
            }
        }

        boolean flag = false;
        for(int x=0; x<n; x++) {

            if(board[0][x] == 1 || visited[0][x]) continue;

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, x));

            while(!queue.isEmpty()) {
                Node cur = queue.remove();

                for(int[] d : move) {
                    int new_y = cur.y + d[0];
                    int new_x = cur.x + d[1];

                    if(new_y < 0 || new_y >= m || new_x < 0 || new_x >= n) continue;
                    if(board[new_y][new_x] == 1 || visited[new_y][new_x]) continue;

                    if(new_y == m-1) {
                        flag = true;
                        queue.removeAll(queue);
                        break;
                    } else {
                        visited[new_y][new_x] = true;
                        queue.add(new Node(new_y, new_x));
                    }
                }
            }
            if(flag) {
                break;
            }
        }

        if(flag) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
