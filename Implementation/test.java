package Implementation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        System.out.println("T: " + T);
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
            int days = sc.nextInt();
            int[] arr = new int[days];
            for(int i=0; i<days; i++) {
            	arr[i] = sc.nextInt();
            }
            
            int max = arr[days-1];
            long answer = 0;
            for(int i=days-2; i>=0; i--) {
            	if(max > arr[i]) {
                    	answer += (max - arr[i]);
                }else if(max < arr[i]){
                    	max = arr[i];
                }
            }
            
            System.out.println("#"+test_case+ " " + answer);
          
		}
    }
}
