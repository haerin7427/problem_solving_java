package Implementation.baekjoon;

// 문제 : 달팽이
// 풀이 일자 : 2025.07.15
// 설명 : https://www.acmicpc.net/problem/1913

import java.io.*;

public class No_1913 {
    static int n;
    static int value = 1;
    static int target;
    static int[][] board;
    static int center_y;
    static int center_x;
    static StringBuffer answer = new StringBuffer();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());

        board = new int[n][n];
        center_y = (n-1)/2;
        center_x = center_y;
        int[][] move = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}, {0,1}};
        int y = center_y;
        int x = center_x;
        for(int level=0; level<=n/2; level++) {
            set_value(y, x);

            for(int[] d : move) {

                while(is_check(y+d[0], x+d[1], level)) {
                    y += d[0];
                    x += d[1];
                    
                    set_value(y, x);
                }
            }
            y -= 1;
            
        }

        for(int i=0; i<board.length; i++) {
            for(int h=0; h<board[0].length; h++) {
                System.out.print(board[i][h] + " ");
            }
            System.out.println();
        }
        System.out.println(answer);

    }

    private static void set_value(int y, int x) {
        if(target == value) {
            answer.append(y+1).append(" ").append(x+1);
        }
        board[y][x] = value++;
    }

    private static boolean is_check(int y, int x, int level) {
        if(y < 0 || y >= n || x < 0 || x >= n) {
            return false;
        }else if(board[y][x] != 0) {
            return false;
        }else {
            if(Math.abs(center_y - y) <= level && Math.abs(center_x - x) <= level) {
                return true;
            }else {
                return false;
            }
        }
    }
}