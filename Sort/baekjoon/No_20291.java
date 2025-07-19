package Sort.baekjoon;

// 문제 : 파일 정리
// 풀이 일자 : 2025.07.19
// 설명 : https://www.acmicpc.net/problem/20291

import java.util.*;
import java.io.*;

public class No_20291 {

    static class Type {
        String name;
        int count;

        Type(String n, int c) {
            name = n;
            count = c;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Type> list = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            String info = br.readLine();
            int lastDot = info.lastIndexOf('.');
            String target = info.substring(lastDot+1);

            map.put(target, map.getOrDefault(target, 0)+1);
        }

        for(String key : map.keySet()) {
            list.add(new Type(key, map.get(key)));
        }

        list.sort(Comparator.comparing(Type::getName));

        for(Type o : list) {
            System.out.println(o.name + " " + o.count);
        }
    }
    
}
