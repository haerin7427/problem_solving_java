package Implementation.baekjoon;

// 문제 : 인내의 도미노 장인 호석
// 풀이 일자 : 2025.06.10
// 설명 : https://www.acmicpc.net/problem/20165

import java.io.*;
import java.util.*;

public class No_20165 {
    static int[][] board;
    static char[][] checked;
    static int n, m;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        checked = new char[n+1][m+1];
        for(int y=1; y<board.length; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<board[0].length; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
                checked[y][x] = 'S';
            }
        }

        for(int i=0; i<r; i++) {
            // 공격
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);

            if(checked[y][x] == 'S') {
                if(d == 'E') {
                    move_east(x, y);
                }else if(d == 'W') {
                    move_west(x, y);
                }else if(d == 'S') {
                    move_south(x, y);
                }else if(d == 'N') {
                    move_north(x, y);
                }
            }

            // 수비
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            checked[y][x] = 'S';
        }
        print_answer();
    }

    private static void print_answer() {
        StringBuffer sb = new StringBuffer();
        sb.append(count + "\n");
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                sb.append(checked[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void move_east(int x, int y) {
        int goal = x+1;
        for(int new_x=x; new_x < goal; new_x++) {
            if(checked[y][new_x] == 'F') {
                continue;
            }else if(new_x == m) {
                goal = m+1;
                break;
            }else {
                goal = Math.max(goal, new_x + board[y][new_x] <= m ? (new_x + board[y][new_x]) : m+1);
            }
        }

        for(int i=x; i<goal; i++) {
            if(checked[y][i] == 'S') {
                checked[y][i] = 'F';
                count += 1;
            }
        }
    }

    private static void move_west(int x, int y) {
        int goal = x-1;
        for(int new_x=x; new_x > goal; new_x--) {
            if(checked[y][new_x] == 'F') {
                continue;
            }else if(new_x == 1) {
                goal = 0;
                break;
            }else {
                goal = Math.min(goal, new_x - board[y][new_x] > 0 ? (new_x - board[y][new_x]) : 0);
            }
        }

        for(int i=x; i>goal; i--) {
            if(checked[y][i] == 'S') {
                checked[y][i] = 'F';
                count += 1;
            }
        }
    }

    private static void move_south(int x, int y) {
        int goal = y+1;
        for(int new_y=y; new_y < goal; new_y++) {
            if(checked[new_y][x] == 'F') {
                continue;
            }else if(new_y == n) {
                goal = n+1;
                break;
            }else {
                goal = Math.max(goal, new_y + board[new_y][x] <= n ? (new_y + board[new_y][x]) : n+1);
            }
        }

        for(int i=y; i<goal; i++) {
            if(checked[i][x] == 'S') {
                checked[i][x] = 'F';
                count += 1;
            }
        }
    }

    private static void move_north(int x, int y) {
        int goal = y-1;
        for(int new_y=y; new_y > goal; new_y--) {
            if(checked[new_y][x] == 'F') {
                continue;
            }else if(new_y == 1) {
                goal = 0;
                break;
            }else {
                goal = Math.min(goal, new_y - board[new_y][x] > 0 ? (new_y - board[new_y][x]) : 0);
            }
        }

        for(int i=y; i>goal; i--) {
            if(checked[i][x] == 'S') {
                checked[i][x] = 'F';
                count += 1;
            }
        }
    }
    
}