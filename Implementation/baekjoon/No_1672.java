package Implementation.baekjoon;

// 문제 : DNA 해독
// 풀이 일자 : 2025.05.13
// 설명 : https://www.acmicpc.net/problem/1672

import java.io.*;

public class No_1672 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String DNA = br.readLine();

        char new_word = DNA.charAt(N-1);
        for(int i=N-2; i>=0; i--) {
            new_word = decode_dna(new_word, DNA.charAt(i));
        }
        System.out.println(new_word);
    }

    private static char decode_dna(char word1, char word2) {
        
        if(word1 == word2) {
            return word1;
        } else {
            if((word1 == 'G' && word2 == 'A') || (word1 == 'A' && word2 == 'G')) {
                return 'C';
            } else if ((word1 == 'C' && word2 == 'A') || (word1 == 'A' && word2 == 'C') || (word1 == 'G' && word2 == 'T') || (word1 == 'T' && word2 == 'G')) {
                return 'A';
            } else if ((word1 == 'G' && word2 == 'C') || (word1 == 'C' && word2 == 'G')) {
                return 'T';
            }else if ((word1 == 'T' && word2 == 'A') || (word1 == 'A' && word2 == 'T') || (word1 == 'T' && word2 == 'C') || (word1 == 'C' && word2 == 'T')) {
                return 'G';
            }
        }
        return ' ';
    }
}
