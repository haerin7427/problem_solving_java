package Implementation.baekjoon;

// 문제 : 지구 온난화
// 풀이 일자 : 2025.05.20
// 설명 : https://www.acmicpc.net/problem/5212

import java.util.*;
import java.io.*;

public class No_5212 {
    static List<String> current_map = new LinkedList<>();
    static char[][] after50_map;
    static int r, c;
    static int min_x=9, max_x=0, min_y=9, max_y=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i=0; i<r; i++) {
            current_map.add(br.readLine());
        }

        after50_map = new char[r][c];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(current_map.get(i).charAt(j) == 'X') {
                    check_land(i, j);
                } else {
                    after50_map[i][j] = '.';
                }
            }
        }
        StringBuffer answer = new StringBuffer();
        for(int y = min_y; y<=max_y; y++) {
            for(int x = min_x; x<=max_x; x++) {
                answer.append(after50_map[y][x]);
            }
            answer.append("\n");
        }
        System.out.print(answer.toString());
    }    
    private static void check_land(int y, int x) {

        int count_sea = 0;

        if(y-1 < 0 || current_map.get(y-1).charAt(x) == '.') {
            count_sea += 1;
        }
        if(x-1 < 0 || current_map.get(y).charAt(x-1) == '.') {
            count_sea += 1;
        }
        if(y+1 >= r || current_map.get(y+1).charAt(x) == '.') {
            count_sea += 1;
        }
        if(x+1 >= c || current_map.get(y).charAt(x+1) == '.') {
            count_sea += 1;
        }

        if(count_sea >= 3) {
            after50_map[y][x] = '.';
        }else {
            after50_map[y][x] = 'X';
            if(min_x > x) {
                min_x = x;
            }
            if(max_x < x) {
                max_x = x;
            }
            if(min_y > y) {
                min_y = y;
            }
            if(max_y < y) {
                max_y = y;
            }
        }
    }
}
