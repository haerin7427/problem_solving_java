package Implementation.baekjoon;

// 문제 : 동방 프로젝트 (Small)
// 풀이 일자 : 2025.06.17
// 설명 : https://www.acmicpc.net/problem/14594

import java.util.*;
import java.io.*;

public class No_14594 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] rooms = new int[n+1];
        Arrays.fill(rooms, 1);
        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int side1 = Integer.parseInt(st.nextToken());
            int side2 = Integer.parseInt(st.nextToken());

            for(int j= side1; j<side2; j++) {
                rooms[j] = 0;
            }
        }

        int count = 0;
        for(int o : rooms) {
            if(o == 1) {
                count += 1;
            }
        }
        count -= 1;
        System.out.println(count);
    }
    
}