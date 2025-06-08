package Implementation.baekjoon;

// 문제 : 지구 온난화
// 풀이 일자 : 2025.06.08(2)
// 설명 : https://www.acmicpc.net/problem/5212

import java.util.*;
import java.io.*;

public class No_5212 {
    static char[][] initial;
    static char[][] after;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        initial = new char[r][c];
        after = new char[r][c];

        for(int y=0; y<r; y++){
            String str = br.readLine();
            for(int x=0; x<c; x++){
                initial[y][x] = str.charAt(x);
            }
        }

        int minX=9, maxX=0, maxY=0, minY=9;
        for(int y=0; y<initial.length; y++){
            for(int x=0; x<initial[0].length; x++){
                after[y][x] = initial[y][x] == '.' ? '.' : check_land(y, x);

                if(after[y][x] == 'X') {
                    if(minX > x) {
                        minX = x;
                    }
                    if(maxX < x) {
                        maxX = x;
                    }
                    if(minY > y) {
                        minY = y;
                    }
                    if(maxY < y) {
                        maxY = y;
                    }
                }
            }
        }

        StringBuffer answer = new StringBuffer();
        for(int y=minY; y<=maxY; y++) {
            for(int x=minX; x<=maxX; x++) {
                answer.append(after[y][x]);
            }
            answer.append('\n');
        }
        System.out.print(answer.toString());
    }

    static char check_land(int y, int x) {
        int count=0;
        int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] d : move) {
            int newY = y + d[0];
            int newX = x + d[1];

            if(newY < 0 || newY >= initial.length || newX < 0 || newX >= initial[0].length) {
                count += 1;
            }else if(initial[newY][newX] == '.') {
                count += 1;
            }
        }
        return count >= 3 ? '.' : 'X';
    }
}
