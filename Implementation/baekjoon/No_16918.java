package Implementation.baekjoon;

// 문제 : 봄버맨
// 풀이 일자 : 2025.05.24
// 설명 : https://www.acmicpc.net/problem/16918

import java.util.*;
import java.io.*;

public class No_16918 {
    static Node[][] board;
    static int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    static class Node {
        char value;
        int install_at;

        Node(char v, int i) {
            value = v;
            install_at = i;
        }
    }
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        board = new Node[r][c];
        for(int i=0; i<r; i++) {
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                board[i][j] = new Node(str.charAt(j), 0);
            }
        }


        if(n % 2 == 0) {
            print_even_board(r, c);
        } else {
            int current_time = 1;
            while(current_time < n) {
                current_time += 1;

                if(current_time % 2 == 0) {
                    for(int i=0; i<r; i++) {
                        for(int j=0; j<c; j++) {
                            if(board[i][j].value == '.') {
                                board[i][j].value = 'O';
                                board[i][j].install_at = current_time;
                            }
                        }
                    }
                }else {
                    for(int i=0; i<r; i++) {
                        for(int j=0; j<c; j++) {
                            if(board[i][j].value == 'O' && current_time - board[i][j].install_at == 3) {
                                board[i][j].value = '.';

                                for(int[] m : move) {
                                    int new_y = i + m[0];
                                    int new_x = j + m[1];
                                    if(new_y < 0 || new_y >= r || new_x < 0 || new_x >= c) continue;
                                    if(board[new_y][new_x].value == 'O' && current_time - board[new_y][new_x].install_at == 3) continue;
                                    board[new_y][new_x].value = '.';
                                }
                            }
                        }
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    sb.append(board[i][j].value);
                }
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
    }

    private static void print_even_board(int r, int c) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                sb.append("O");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    
}
