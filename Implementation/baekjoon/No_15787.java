package Implementation.baekjoon;

// 문제 : 기차가 어둠을 헤치고 은하수를
// 풀이 일자 : 2025.07.21
// 설명 : https://www.acmicpc.net/problem/15787

import java.io.*;
import java.util.*;

public class No_15787 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        List<Integer>[] trains = new List[n];
        for(int i=0; i<n; i++) {
            trains[i] = new LinkedList<>();
            for(int j=0; j<20; j++) {
                trains[i].add(0);
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int train_index = Integer.parseInt(st.nextToken()) - 1;
            int seat_index = 0;
            if(type < 3) {
                seat_index = Integer.parseInt(st.nextToken()) - 1;
            }

            if(type == 1) {
                if(trains[train_index].get(seat_index) == 0) {
                    trains[train_index].remove(seat_index);
                    trains[train_index].add(seat_index, 1);
                }
            }else if(type == 2) {
                if(trains[train_index].get(seat_index) == 1) {
                    trains[train_index].remove(seat_index);
                    trains[train_index].add(seat_index, 0);
                }
            }else if(type == 3) {
                trains[train_index].remove(19);
                trains[train_index].add(0, 0);
            }else if(type == 4) {
                trains[train_index].remove(0);
                trains[train_index].add(0);
            }
        }

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            StringBuffer sb = new StringBuffer();
            for(int seat : trains[i]) {
                sb.append(seat);
            }
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }
    
}