package Implementation.baekjoon;

// 문제 : ZOAC 4
// 풀이 일자 : 2025.03.19
// 설명 : https://www.acmicpc.net/problem/23971

import java.util.*;
import java.io.*;

public class No_23971 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int desk_per_row = W / (M+1) + (W%(M+1) != 0 ? 1 : 0);
        int row = H / (N+1) + (H % (N+1) != 0 ? 1 : 0);
        System.out.println(desk_per_row*row);
    }
    
}
