package Implementation.baekjoon;

// 문제 : 오리
// 풀이 일자 : 2025.07.15
// 설명 : https://www.acmicpc.net/problem/12933

import java.util.*;
import java.io.*;

public class No_12933 {

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String duck = new String("quack");
        List<Stack<Character>> list = new LinkedList<>();

        int answer = -1;
        for(char word : input.toCharArray()) {
            if(word == 'q') {
                Stack<Character> new_stack = new Stack<>();
                new_stack.add('q');
                list.add(new_stack);
            }else {
                boolean is_check = false;
                for(Stack<Character> queue : list) {
                    String temp = queue.peek().toString() + word;
                    if(duck.contains(temp)) {
                        if(word == 'k') {
                            list.remove(queue);
                        }else {
                            queue.add(word);
                        }
                        is_check = true;
                        break;
                    }
                }

                if(!is_check) {
                    answer = -1;
                    break;
                }
            }

            if(answer < list.size()) {
                answer = list.size();
            }
        }

        if(list.size() != 0) {
            answer = -1;
        }

        System.out.println(answer);
    }
}