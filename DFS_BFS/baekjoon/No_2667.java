package DFS_BFS.baekjoon;

// 문제 : 단지번호붙이기
// 풀이 일자 : 2025.03.19, 2025.05.26
// 설명 : https://www.acmicpc.net/problem/2667

import java.io.*;
import java.util.*;

public class No_2667 {

    private static int[][] move = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    private static int[][] board;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for(int y=0; y<n; y++) {
            String info = br.readLine();
            for(int x=0; x<n; x++) {
                board[y][x] = info.charAt(x) - '0';
            }
        }

        visited = new boolean[n][n];
        List<Integer> answer = bfs();
        print_answer(answer);
    }

    private static class Node {
        int y;
        int x;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static List<Integer> bfs() {

        List<Integer> houce_list = new ArrayList<>();
        
        for(int y=0; y<board.length; y++) {
            for(int x=0; x<board[0].length; x++) {

                if(board[y][x] == 0 || visited[y][x]) continue;
                
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(x, y));
                visited[y][x] = true;
                int count = 1;
                while (!queue.isEmpty()) {
                    Node current_node = queue.remove();

                    for(int[] d : move) {
                        int new_y = current_node.y + d[0];
                        int new_x = current_node.x + d[1];

                        if(new_y < 0 || new_y >= board.length || new_x < 0 || new_x >= board[0].length) continue;
                        if(board[new_y][new_x] == 0 || visited[new_y][new_x]) continue;

                        count += 1;
                        visited[new_y][new_x] = true;
                        queue.add(new Node(new_x, new_y));
                    }
                }
                houce_list.add(count);
            }
        }

        return houce_list;
    }

    private static void print_answer(List<Integer> values) {
        StringBuffer sb = new StringBuffer();
        Collections.sort(values);
        sb.append(values.size() +"\n");
        for(int a : values) {
            sb.append(a +"\n");
        }
        System.out.print(sb.toString());

    }

    
}
