package DFS_BFS.baekjoon;

// 문제 : 연산자 끼워넣기
// 풀이 일자 : 2025.07.29
// 설명 : https://www.acmicpc.net/problem/14888

import java.util.*;
import java.io.*;

public class No_14888 {
    static int n;
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static int[] values;
    static int[] count_operators;
    static List<Integer> current_operators = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        values = new int[n];
        count_operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            count_operators[i] = Integer.parseInt(st.nextToken());
        }
        assemble();
        System.out.println(max + "\n" + min);
    }

    private static void assemble() {
        if(current_operators.size() == n-1) {
            calculate();
            return ;
        }

        for(int i=0; i<4; i++) {
            if(count_operators[i] > 0) {
                current_operators.add(i);
                count_operators[i] -= 1;
                assemble();
                current_operators.remove(current_operators.size()-1);
                count_operators[i] += 1;
            }
        }
    }


    private static void calculate() {
        
        long result = values[0];
        for(int i=0; i<current_operators.size(); i++) {
            if(current_operators.get(i) == 0) {
                result += values[i+1];
            }else if(current_operators.get(i) == 1) {
                result -= values[i+1];
            }else if(current_operators.get(i) == 2) {
                result *= values[i+1];
            }else if(current_operators.get(i) == 3){
                result /= values[i+1];
            }
        }

        if(max < result) {
            max = result;
        }
        if(min > result) {
            min = result;
        }
    }
}
