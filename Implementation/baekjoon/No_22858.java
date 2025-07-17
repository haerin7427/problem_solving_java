package Implementation.baekjoon;

// 문제 : 원상 복구 (small)
// 풀이 일자 : 2025.07.17
// 설명 : https://www.acmicpc.net/problem/22858

import java.util.*;
import java.io.*;

public class No_22858 {
    static int n;
    static int k;
    static int[] cards;
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        cards = new int[n+1];
        d = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<k; i++) {
            back_to_card();
        }

        StringBuffer answer = new StringBuffer();
        for(int i=1; i<=n; i++) {
            answer.append(cards[i] + " ");
        }
        System.out.println(answer);
    }

    private static void back_to_card() {
        int[] temp = new int[n+1];
        for(int i=1; i<=n; i++) {
            temp[d[i]] = cards[i];
        }
        cards = temp.clone();
    }
    
}