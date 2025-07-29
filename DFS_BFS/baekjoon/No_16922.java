package DFS_BFS.baekjoon;

// 문제 : 로마 숫자 만들기
// 풀이 일자 : 2025.07.29
// 설명 : https://www.acmicpc.net/problem/16922

import java.util.*;
import java.io.*;

public class No_16922 {
    static int n;
    static int[] values;
    static HashSet<Integer> answers = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        values = new int[n];
        make_case(0, 0);
        System.out.println(answers.size());

    }

    private static void make_case(int index, int prev) {
        if(index == n) {
            calculate();
            return;
        }
        for(int i=prev; i<4; i++) {
            values[index] = i;
            make_case(index+1, i);
        }
    }

    private static void calculate() {
        int sum = 0;
        for(int value : values) {
            if(value == 0) {
                sum += 1;
            }else if(value == 1) {
                sum += 5;
            }else if(value == 2) {
                sum += 10;
            }else if(value == 3) {
                sum += 50;
            }
        }
        answers.add(sum);
    }
    
}
