package DFS_BFS.baekjoon;

// 문제 : 미술가 미미
// 풀이 일자 : 2025.07.31
// 설명 : https://www.acmicpc.net/problem/20950

import java.io.*;
import java.util.*;

public class No_20950 {
    private static class Color {
        int red;
        int green;
        int blue;

        Color(int r, int g, int b) {
            red = r;
            green = g;
            blue = b;
        }
    }

    static Color[] input;
    static Color target;
    static int answer = 255*3;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        input = new Color[n];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            input[i] = new Color(r, g, b);
        }
        st = new StringTokenizer(br.readLine());
        target = new Color(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for(int i=0; i<n-1; i++) {
            mix_color(i+1, input[i].red, input[i].green, input[i].blue, 1);
        }
        System.out.println(answer);
    }

    private static void mix_color(int index, int sum_r, int sum_g, int sum_b, int count) {
       
        if(count == 7 || index >= n) {
            return ;
        }

        int new_red = sum_r + input[index].red;
        int new_green = sum_g + input[index].green;
        int new_blue = sum_b +input[index].blue;

        check_color(new_red/(count+1), new_green/(count+1), new_blue/(count+1));
        mix_color(index+1, new_red, new_green, new_blue, count+1);
        mix_color(index+1, sum_r, sum_g, sum_b, count);
    }

    private static void check_color(int r, int g, int b) {
        int sum = Math.abs(target.red - r) + Math.abs(target.green - g) + Math.abs(target.blue - b);

        if(answer > sum) {
            answer = sum;
        }
    }
}
