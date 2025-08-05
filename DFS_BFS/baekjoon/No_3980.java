package DFS_BFS.baekjoon;

// 문제 : 선발 명단
// 풀이 일자 : 2025.08.05
// 설명 : https://www.acmicpc.net/problem/3980

import java.util.*;
import java.io.*;

public class No_3980 {
    static final int PLAYER = 11;
    static int[][] power = new int[PLAYER][PLAYER];
    static int c, max_value, value;
    static StringBuffer answer = new StringBuffer();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<c; i++) {
            for(int y = 0; y<power.length; y++) {
                st = new StringTokenizer(br.readLine());
                for(int x=0; x<power[0].length; x++) {
                    power[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            max_value = 0; value = 0;
            visited = new boolean[PLAYER];
            set_position(0);
            answer.append(max_value + "\n");
        }
        System.out.print(answer);
    }

    private static void set_position(int player_no) {
        if(player_no == PLAYER) {
            if(max_value < value) {
                max_value = value;
            }
            return ;
        }

        for(int i=0; i<visited.length; i++) {
            if(visited[i] || power[player_no][i] == 0) continue;

            value += power[player_no][i];
            visited[i] = true;
            set_position(player_no+1);
            value -= power[player_no][i];
            visited[i] = false;
        }
    }
}