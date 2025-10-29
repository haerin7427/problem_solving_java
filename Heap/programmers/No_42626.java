package Heap.programmers;

// 문제 : 더 맵게
// 풀이 일자 : 2025.10.29
// https://school.programmers.co.kr/learn/courses/30/lessons/42626

import java.util.*;
public class No_42626 {
    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int value : scoville) {
                minHeap.add(value);
            }
            
            int answer = 0;
            while (minHeap.peek() < K && minHeap.size() > 1) {
                answer += 1;
                int value1 = minHeap.poll();
                int value2 = minHeap.poll();
                minHeap.add(value1 + value2 * 2);
            }
            if(minHeap.peek() < K) {
                answer = -1;
            }
            return answer;
        }
    }
}
