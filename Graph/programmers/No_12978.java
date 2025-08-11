package Graph.programmers;

// 문제 : 배달
// 풀이 일자 : 2025.08.10
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/12978

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class No_12978 {
    class Solution {
        private class Node {
            int value;
            int distance;
            
            Node(int v, int d) {
                value = v;
                distance = d;
            }
        }
        public int solution(int N, int[][] road, int K) {
            // 간선 정보 및 크기 저장
            int[] times = new int[N+1];
            List<Node>[] list = new ArrayList[N+1];
            for(int i=0; i<=N; i++) {
                list[i] = new ArrayList<>();
                times[i] = 1000000;
            }
            
            for(int[] r : road) {
                int n1 = r[0];
                int n2 = r[1];
                int distance = r[2];
                
                list[n1].add(new Node(n2, distance));
                list[n2].add(new Node(n1, distance));
            }
            
            // BFS로 순회
            Queue<Node> queue = new LinkedList<>();

            queue.add(new Node(1, 0));
            times[1] = 0;
            
            while(!queue.isEmpty()) {
                Node node = queue.remove();
                
                for(Node next : list[node.value]) {
                    if(times[next.value] > times[node.value] + next.distance) {
                        times[next.value] = times[node.value] + next.distance;
                        queue.add(new Node(next.value, times[next.value]));
                    }
                }
            }
            
            int answer = 0;
            for(int i=1; i<=N; i++) {
                if(times[i] <= K) {
                    answer += 1;
                }
            }
            return answer;
        }
    }

    class Solution2 {
    
        public int solution(int N, int[][] road, int K) {
    
            int[][] arr = new int[N+1][N+1];
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    arr[i][j] = 1000000;
                }
            }
            
            for(int i=1; i<=N; i++) {
                arr[i][i] = 0;
            }
            
            for(int[] r : road) {
                int n1 = r[0];
                int n2 = r[1];
                int distance = r[2];
                
                arr[n1][n2] = Math.min(arr[n1][n2], distance);
                arr[n2][n1] = Math.min(arr[n2][n1], distance);
            }
            
            // BFS로 순회
            for(int m = 1; m<=N; m++) {
                for(int s=1; s<=N; s++) {
                    for(int e=1; e<=N; e++) {
                        if(arr[s][m] == 1000000 || arr[m][e] == 1000000) continue;
                        if(arr[s][e] > arr[s][m] + arr[m][e]) {
                            arr[s][e] = arr[s][m] + arr[m][e];
                        }
                    }
                }
            }
            
            int answer = 0;
            for(int i=1; i<=N; i++) {
                if(arr[1][i] <= K) {
                    answer += 1;
                }
            }
    
            return answer;
        }
    }

    class Solution3 {
        private class Node {
            int value;
            int distance;
            
            Node(int v, int d) {
                value = v;
                distance = d;
            }
        }
        public int solution(int N, int[][] road, int K) {
            
            // 간선 정보 및 크기 저장
            int[] times = new int[N+1];
            List<Node>[] list = new ArrayList[N+1];
            for(int i=0; i<=N; i++) {
                list[i] = new ArrayList<>();
                times[i] = 1000000;
            }
            
            for(int[] r : road) {
                int n1 = r[0];
                int n2 = r[1];
                int distance = r[2];
                
                list[n1].add(new Node(n2, distance));
                list[n2].add(new Node(n1, distance));
            }
            
            // BFS로 순회
            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
                @Override
                public int compare(Node a, Node b) {
                    if(a.distance < b.distance) {
                        return -1;
                    }else {
                        return 0;
                    }
                }
            });

            pq.add(new Node(1, 0));
            times[1] = 0;
            
            while(!pq.isEmpty()) {
                Node node = pq.remove();
                
                for(Node next : list[node.value]) {
                    if(times[next.value] > times[node.value] + next.distance) {
                        times[next.value] = times[node.value] + next.distance;
                        pq.add(new Node(next.value, times[next.value]));
                    }
                }
            }
            
            int answer = 0;
            for(int i=1; i<=N; i++) {
                if(times[i] <= K) {
                    answer += 1;
                }
            }

            return answer;
        }
    }
}