package DFS_BFS.baekjoon;

// 문제 : 트리
// 풀이 일자 : 2025.05.13
// 설명 : https://www.acmicpc.net/problem/4803

import java.util.*;
import java.io.*;

public class No_4803 {
    static List<Integer>[] arr;
    static boolean[] visited;
    static StringBuffer answer = new StringBuffer();
    static int count_node;
    static int count_edge;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int index = 0;
        while (!input.equals("0 0")) {
            index += 1;
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr = new List[n+1];
            visited = new boolean[n+1];


            for(int i=1; i<=n; i++) {
                arr[i] = new LinkedList<>();
            }

            for(int i=0; i<m; i++) {

                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                arr[node1].add(node2);
                arr[node2].add(node1); 
            }
            
            int count = 0;
            for(int i=1; i<=n; i++) {
                if(!visited[i]) {
                    count_node = 0;
                    count_edge = 0;
                    dfs(i);

                    if(((count_edge / 2) + 1) == count_node) {
                        count += 1;
                    }
                }

                
            }

            print_result(index, count);
            input = br.readLine();
        }
        System.out.print(answer);
    }

    private static void dfs (int node) {
        visited[node] = true;
        count_node += 1;

        for(int i=0; i<arr[node].size(); i++) {
            int next_node = arr[node].get(i);
            count_edge += 1;

            if(!visited[next_node]) {
                dfs(next_node);
            }
        }
    }

    private static void print_result (int index, int tree_count) {
        if(tree_count == 0) {
            answer.append("Case " + index + ": No trees.\n");
        }else if(tree_count == 1) {
            answer.append("Case " + index + ": There is one tree.\n");
        }else {
            answer.append("Case " + index + ": A forest of " + tree_count + " trees.\n");
        }
    }
    
}
