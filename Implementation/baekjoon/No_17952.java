package Implementation.baekjoon;

import java.util.*;
import java.io.*;

// 문제 : 과제는 끝나지 않아!
// 풀이 일자 : 2025.04.01
// 설명 : https://www.acmicpc.net/problem/17952

public class No_17952 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int total_score=0;
        int score=0, time=0;
        Stack<Work> waiting_list = new Stack<>();
        for(int i=0; i<N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("0")) {
                if(score == 0 && !waiting_list.empty()) {
                    Work w = waiting_list.pop();
                    score = w.score;
                    time = w.time;
                }
            } else {
                if(score > 0) {
                    waiting_list.add(new Work(time, score));
                }

                score = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());
            }

            if(score > 0) {
                time -= 1;
            }

            if(time == 0) {
                total_score += score;
                score = 0;
            }
        }

        System.out.println(total_score);
    }

    private static class Work {
        int time;
        int score;

        Work (int t, int s) {
            time = t;
            score = s;
        }
    }
}
