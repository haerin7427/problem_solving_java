package DFS_BFS.baekjoon;

// 문제 : 미로 탐색
// 풀이 일자 : 2025.03.20
// 설명 : https://www.acmicpc.net/problem/2178

import java.util.*;
import java.io.*;

public class No_2178 {
    
    public static class Location {
        int y;
        int x;
        int distance;

        Location(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.distance = d;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int[][] board = new int[N][M];
        for(int i=0; i<board.length; i++) {
            String str = br.readLine();
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = (str.charAt(j) - '0');
            }
        }

        boolean[][] visited = new boolean[N][M];
        int[][] move = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        List<Location> queue = new LinkedList<>();
        queue.add(new Location(0, 0, 1));
        visited[0][0] = true;
        int answer = 0;
        while(!queue.isEmpty()){
            Location current = queue.remove(0);

            if(current.y == N-1 && current.x == M-1) {
                answer = current.distance;
                break;
            }

            for(int[] m : move) {
                int new_y = current.y + m[0];
                int new_x = current.x + m[1];

                if(new_y<0 || new_y>=board.length || new_x<0 || new_x>=board[0].length) continue;
                if(board[new_y][new_x] == 0 || visited[new_y][new_x]) continue;

                queue.add(new Location(new_y, new_x, current.distance+1));
                visited[new_y][new_x] = true;
            }
        }
        System.out.println(answer);
    }
    
}
