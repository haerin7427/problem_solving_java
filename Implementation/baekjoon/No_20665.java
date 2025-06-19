package Implementation.baekjoon;

// 문제 : 독서실 거리두기
// 풀이 일자 : 2025.06.19
// 설명 : https://www.acmicpc.net/problem/20665

import java.io.*;
import java.util.*;
import java.time.*;

public class No_20665 {

    private static class Reservation {
        LocalTime start_time;
        LocalTime end_time;

        Reservation(String time) {
            start_time = LocalTime.of(Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(2, 4)), 0);
            end_time = LocalTime.of(Integer.parseInt(time.substring(5, 7)), Integer.parseInt(time.substring(7, 9)), 0);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Reservation> list = new LinkedList<>();
        for(int i=0; i<t; i++) {
            list.add(new Reservation(br.readLine()));
        }

        Collections.sort(list, new Comparator<Reservation>(){
            @Override
            public int compare(Reservation o1, Reservation o2) {
                if(!o1.start_time.equals(o2.start_time)) {
                    return o1.start_time.compareTo(o2.start_time);
                }else {
                    long m1 = Duration.between(o1.start_time, o1.end_time).toMinutes();
                    long m2 = Duration.between(o2.start_time, o2.end_time).toMinutes();
                    return (int)(m1 - m2);
                }
            }
        });

        LocalTime[] seats = new LocalTime[n+1];
        int answer = 0, count_user = 0;
        LocalTime manager_time = LocalTime.of(9, 0, 0);
        for(Reservation user : list) {
            int new_seat_no = 1;
            if(count_user > 0) {
                List<Integer> open_seat_list = new ArrayList<>();
                List<Integer> close_seat_list = new ArrayList<>();
                for(int i=1; i<=n; i++) {
                    if(seats[i] != null && user.start_time.isBefore(seats[i])) {
                            close_seat_list.add(i);
                    }else {
                        if(seats[i] != null) {
                            seats[i] = null;
                            count_user -= 1;
                        }
                        open_seat_list.add(i);
                    }
                }

                if(!close_seat_list.isEmpty()) {
                    int max_distance = 0;
                    for(int open_seat : open_seat_list) {
                        int min_distance = 101;
                        for(int close_seat : close_seat_list) {
                            int d = Math.abs(open_seat - close_seat);
                            if(min_distance > d) {
                                min_distance = d;
                            }
                        }

                        if(max_distance < min_distance) {
                            max_distance = min_distance;
                            new_seat_no = open_seat;
                        }
                    }
                }
            }

            count_user += 1;
            seats[new_seat_no] = user.end_time;

            if(new_seat_no == p) {
                answer += Duration.between(manager_time, user.start_time).toMinutes();
                manager_time = user.end_time;
            }
        }

        answer += Duration.between(manager_time, LocalTime.of(21,0,0)).toMinutes();
        System.out.println(answer);
    }
}