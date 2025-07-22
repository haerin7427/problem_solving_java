package Implementation.baekjoon;

// 문제 : 유성
// 풀이 일자 : 2025.07.22
// 설명 : https://www.acmicpc.net/problem/10703

import java.util.*;
import java.io.*;

public class No_10703 {
    static int R, S;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        board = new char[R][S];

        for(int y=0; y<R; y++) {
            String s = br.readLine();
            for(int x=0; x<S; x++) {
                board[y][x] = s.charAt(x);
            }
        }

        int min = 3000;
        for(int x=0; x<S; x++) {
            for(int y=R-1; y>=0; y--) {
                if(board[y][x] == 'X') {
                    int distance = calculate_distance(y, x);
                    if(min > distance) {
                        min = distance;
                    }
                    break;
                }
            }
        }

        for(int x=0; x<S; x++) {
            for(int y=R-1; y>=0; y--) {
                if(board[y][x] == 'X') {
                    exchange_mark(y, y+min, x);
                }
            }
        }


        StringBuffer answer = new StringBuffer();
        for(int y=0; y<R; y++) {
            for(int x=0; x<S; x++) {
                answer.append(board[y][x]);
            }
            answer.append("\n");
        }
        System.out.print(answer);
        
    }

    private static int calculate_distance(int y, int x) {
        int distance = 0;
        for(int i = y+1; i<R; i++) {
            if(board[i][x] == '.') {
                distance += 1;
            }else {
                break;
            }
        }
        return distance;
    }

    private static void exchange_mark(int y1, int y2, int x) {
        char temp = board[y1][x];
        board[y1][x] = board[y2][x];
        board[y2][x] = temp;
    }
    
}