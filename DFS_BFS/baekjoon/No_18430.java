package DFS_BFS.baekjoon;

// 문제 : 무기 공학
// 풀이 일자 : 2025.08.08
// 설명 : https://www.acmicpc.net/problem/18430

import java.util.*;
import java.io.*;

public class No_18430 {
    static int n, m;
    static int[][] wood;
    static boolean[][] visited;
    static int answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        wood = new int[n][m];
        for(int y=0; y<wood.length; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<wood[0].length; x++) {
                wood[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        if(wood.length != 1 && wood[0].length != 1) {
            visited = new boolean[n][m];
            find(0, 0);
        }
        System.out.println(answer);
    }

    private static void find(int index, int value) {

        if(index == n*m) {
            if(value > answer) {
                answer = value;
            }
            return;
        }

        int i = index / m;
        int j = index % m;

        if(!visited[i][j]) {

            if(i-1 >= 0 && j+1 < m && !visited[i-1][j] && !visited[i][j+1]) {
                visited[i-1][j] = true;
                visited[i][j] = true;
                visited[i][j+1] = true;
                find(index+1, value + wood[i][j]*2 + wood[i-1][j] + wood[i][j+1]);
                visited[i-1][j] = false;
                visited[i][j] = false;
                visited[i][j+1] = false;
            }

            if(i-1 >= 0 && j-1 >= 0 && !visited[i-1][j] && !visited[i][j-1]) {
                visited[i-1][j] = true;
                visited[i][j] = true;
                visited[i][j-1] = true;
                find(index+1, value + wood[i][j]*2 + wood[i-1][j] + wood[i][j-1]);
                visited[i-1][j] = false;
                visited[i][j] = false;
                visited[i][j-1] = false;
            }

            if(i+1 < n && j-1 >= 0 && !visited[i+1][j] && !visited[i][j-1]) {
                visited[i+1][j] = true;
                visited[i][j] = true;
                visited[i][j-1] = true;
                find(index+1, value + wood[i][j]*2 + wood[i+1][j] + wood[i][j-1]);
                visited[i+1][j] = false;
                visited[i][j] = false;
                visited[i][j-1] = false;

            }
            if(i+1 < n && j+1 < m && !visited[i+1][j] && !visited[i][j+1]) {
                visited[i+1][j] = true;
                visited[i][j] = true;
                visited[i][j+1] = true;
                find(index+1, value + wood[i][j]*2 + wood[i+1][j] + wood[i][j+1]);
                visited[i+1][j] = false;
                visited[i][j] = false;
                visited[i][j+1] = false;
            }
        }
        find(index+1, value);
    }
}
