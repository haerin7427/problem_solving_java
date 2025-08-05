package DFS_BFS.baekjoon;

// 문제 : 계란으로 계란치기
// 풀이 일자 : 2025.08.05
// 설명 : https://www.acmicpc.net/problem/16987

import java.util.*;
import java.io.*;

public class No_16987 {

    static class Egg {
        int s;
        int w;

        Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }

        void minus_s(int w) {
            this.s -= w;
        }
        void plus_s(int w) {
            this.s += w;
        }
    }

    static int n;
    static Egg[] eggs;
    static int answer;
    static int current = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];

        StringTokenizer st ;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        break_egg(0, 0);
        System.out.println(answer);
    }

    private static void break_egg(int grab_egg, int current_egg) {
        if(grab_egg == n) {
            if(answer < current_egg) {
                answer = current_egg;
            }
            return;
        }else if(eggs[grab_egg].s <=0) {
            break_egg(grab_egg+1, current_egg);
            return;
        }

        boolean is_right_egg = true;
        for(int i=0; i<n; i++) {
            if(grab_egg == i || eggs[i].s <=0) continue;

            is_right_egg = false;
            eggs[grab_egg].minus_s(eggs[i].w);
            eggs[i].minus_s(eggs[grab_egg].w);
            int cnt = 0;
            if(eggs[grab_egg].s <=0) {
                cnt += 1;
            }
            if(eggs[i].s <= 0) {
                cnt += 1;
            }
            break_egg(grab_egg+1, current_egg + cnt);

            eggs[grab_egg].plus_s(eggs[i].w);
            eggs[i].plus_s(eggs[grab_egg].w);
        }

        if(is_right_egg) {
            break_egg(n, current_egg);
        }
    }
}
