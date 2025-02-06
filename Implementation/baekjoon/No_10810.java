package Implementation.baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 문제 : 공 넣기
// 풀이 시간 : 10분
// 설명 : https://www.acmicpc.net/problem/10810

public class No_10810 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> basket = new HashMap<>();
        for(int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            
            for(int a=i; a<=j; a++) {
                basket.put(a, k);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i <= N; i++) {
            sb.append(basket.getOrDefault(i, 0)+ " ");
        }
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
    }
}