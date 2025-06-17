package Implementation.baekjoon;

// 문제 : 감시
// 풀이 일자 : 2025.06.17
// 설명 : https://www.acmicpc.net/problem/15683

import java.util.*;
import java.io.*;

public class No_15683 {
    static int[][] move = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    static List<CCTV> cctv_list = new LinkedList<>();
    static int n, m, answer;
    static int[][] board;
    static int[][] copy_board;
    static int[] cctv_direction;

    private static class CCTV {
        int value;
        int y;
        int x;

        CCTV(int v, int y, int x) {
            this.value = v;
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());

                if(board[y][x] > 0 && board[y][x] < 6) {
                    cctv_list.add(new CCTV(board[y][x], y, x));
                }
            }
        }

        cctv_direction = new int[cctv_list.size()];
        answer = n*m;
        permutation(0);
        System.out.println(answer);
    }
    
    private static void permutation(int depth) {

        if(cctv_list.size() == depth) {
            // 1. board 새로 만들기
            copy_board = new int[board.length][board[0].length];
            for(int y=0; y<copy_board.length; y++) {
                System.arraycopy(board[y], 0, copy_board[y], 0 , board[y].length);
            }

            // 2. 표시하기
            for(int i=0; i<cctv_list.size(); i++) {
                check_cctv(cctv_list.get(i), cctv_direction[i]);
            }

            // 3. 갯수 체크
            count_section();
            return;
        }

        for(int i=0; i<4; i++) {
            cctv_direction[depth] = i;
            permutation(depth+1);
        }
    }

    private static void check_cctv(CCTV cctv, int direction) {
        if(cctv.value == 1) {
            check_board(cctv, direction);
        }else if(cctv.value == 2) {
            if(direction % 2 == 0 ) {
                check_board(cctv, 0);
                check_board(cctv, 2);
            }else {
                check_board(cctv, 1);
                check_board(cctv, 3);
            }
        }else if(cctv.value == 3) {
            check_board(cctv, direction);
            check_board(cctv, (direction+1) % 4);
        }else if(cctv.value == 4) {
            for(int i=0; i<3; i++) {
                int d = (direction + i) % 4;
                check_board(cctv, d);
            }
        }else if(cctv.value == 5) {
            check_board(cctv, 0);
            check_board(cctv, 1);
            check_board(cctv, 2);
            check_board(cctv, 3);
        }
    }

    private static void check_board(CCTV cctv, int direction) {
        int row = copy_board.length;
        int col = copy_board[0].length;

        int ny = cctv.y;
        int nx = cctv.x;
        while(true) {
            ny += move[direction][0];
            nx += move[direction][1];

            if(ny < 0 || ny >= row || nx < 0 || nx >= col || copy_board[ny][nx] == 6) {
                break;
            }
            
            if(copy_board[ny][nx] == 0) {
                copy_board[ny][nx] = -1;
            }
        }
    }

    private static void count_section() {
        int count = 0;
        for(int y=0; y<copy_board.length; y++) {
            for(int x=0; x<copy_board[0].length; x++) {
                if(copy_board[y][x] == 0) {
                    count += 1;
                }
            }
        }

        if(answer > count) {
            answer = count;
        }
    }
}