package Implementation;

// 문제 : 후보 추천하기
// 풀이 일자 : 2025.06.10
// 설명 : https://www.acmicpc.net/problem/1713

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

public class No_1713 {
    static Map<Integer, Student> map = new HashMap<>();

    private static class Student {
        LocalDateTime register_at;
        int count;

        Student(LocalDateTime r, int c) {
            register_at = r;
            count = c;
        }

        void addCount() {
            count += 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++) {
            int student_no = Integer.parseInt(st.nextToken());

            if(map.containsKey(student_no)) {
                Student student = map.get(student_no);
                student.addCount();
                map.put(student_no, student);
            }else {
                if(map.size() == n) {
                    remove_student();
                }
                map.put(student_no, new Student(LocalDateTime.now(), 1));
            }
        }
        print_answer();
    }

    private static void remove_student() {
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1).count != map.get(o2).count) {
                    return map.get(o1).count - map.get(o2).count;
                }else {
                    return map.get(o1).register_at.compareTo(map.get(o2).register_at);
                }
            }
        });
        map.remove(keySet.get(0));
    }

    private static void print_answer() {
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        StringBuffer answer = new StringBuffer();
        for(int no : keySet) {
            answer.append(no + " ");
        }
        System.out.println(answer);
    }
}
