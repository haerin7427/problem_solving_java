package Greedy.baekjoon;

// 문제 : 배
// 풀이 일자 : 2025.03.06
// https://www.acmicpc.net/problem/1092

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class No_1092 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] tool = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            tool[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tool);

        int M = Integer.parseInt(br.readLine());
        List<Integer> boxes = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes);
        Collections.reverse(boxes);

        if(tool[N-1] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!boxes.isEmpty()){
            time += 1;

            for(int i=N-1; i>=0; i--) {
                for(int j=0; j<boxes.size(); j++) {
                    if(tool[i] >= boxes.get(j)) {
                        boxes.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println(time);
    }
    
}
