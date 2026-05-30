package Greedy.baekjoon;

// 문제 : 보석 도둑
// 풀이 일자 : 2026.04.15
// 설명 : https://www.acmicpc.net/problem/1202

import java.io.*;
import java.util.*;

public class No_1202 {

    private static class Product implements Comparable<Product> {
        int weight;
        int cost;

        Product (int w, int c) {
            weight = w;
            cost = c;
        }

        @Override
        public int compareTo(Product o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Product> product_list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(sc.nextLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            product_list.add(new Product(w, c));
        }

        List<Integer> bag_list = new ArrayList<>();
        for(int i=0; i<k; i++) {
            bag_list.add(Integer.parseInt(sc.nextLine()));
        }

        Collections.sort(product_list);
        Collections.sort(bag_list);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int idx = 0;
        for(int i=0; i<k; i++) {
            while(idx < n && bag_list.get(i) >= product_list.get(idx).weight) {
                
                pq.add(product_list.get(idx).cost);
                idx += 1;
            }
            if(!pq.isEmpty())
                answer += pq.poll();
        }

        System.out.println(answer);
    }
    
}