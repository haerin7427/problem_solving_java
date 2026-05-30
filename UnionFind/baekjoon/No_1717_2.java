package UnionFind.baekjoon;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No_1717_2 {
    private static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for(int i=0; i<arr.length; i++) {
            arr[i] = i;
        }

        StringBuffer answer = new StringBuffer();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(sc.nextLine());
            int key = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(key == 0) {
                union(a, b);
            }else if(key == 1) {
                if(find(a) == find(b)) {
                    answer.append("YES\n");
                }else {
                    answer.append("NO\n");
                }
            }
        }
        System.out.print(answer);
    }

    private static void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if(root_a <= root_b) {
            arr[root_b] = root_a;
        }else {
            arr[root_a] = root_b;
        }
    }

    private static int find(int a) {
        int value = arr[a];
        if(value != arr[value]) {
            arr[a] = find(value);
        }
        return arr[a];
    }
}