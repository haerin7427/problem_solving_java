package Implementation.programmers;

// 문제 : 석유 시추
// 풀이 일자 : 2025.08.11
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

public class No_250136 {
    class Solution {
        private class Node {
            int y;
            int x;
            
            Node(int y, int x) {
                this.y = y;
                this.x = x;
            }
        }
        private Map<Integer, Integer> map = new HashMap<>();
        private int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}}; 
        public int solution(int[][] land) {
            int answer = 0, no = 2;
            for(int x=0; x<land[0].length; x++) {
                Set<Integer> set = new HashSet<>();
                for(int y=0; y<land.length; y++) {
                    if(land[y][x] == 1) {
                        map.put(no, get_size(y, x, no, land));
                        no += 1;
                    }
                    
                    if(land[y][x] != 0) {
                        set.add(land[y][x]);
                    }
                }
                
                int sum=0;
                for(int key : set) {
                    sum += map.get(key);
                }
                if(answer < sum) {
                    answer = sum;
                }
            }
            
            return answer;
        }
        
        private int get_size(int y, int x, int no, int[][] land) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(y, x));
            land[y][x] = no;
            int size = 1;
            while(!queue.isEmpty()){
                Node current_node = queue.remove();
                
                for(int[] d : move) {
                    int ny = current_node.y + d[0];
                    int nx = current_node.x + d[1];
                    
                    if(ny < 0 || ny >= land.length || nx < 0 || nx >= land[0].length) continue;
                    if(land[ny][nx] != 1) continue;
                    
                    size += 1;
                    land[ny][nx] = no;
                    queue.add(new Node(ny, nx));
                }
            }
            return size;
            
        }
    }
}
