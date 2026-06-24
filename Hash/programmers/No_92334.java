package Hash.programmers;

// 문제 : 신고 결과 받기
// 풀이 일자 : 2026.06.24
// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;
public class No_92334 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int idCount = id_list.length;
            Map<String, Integer> reportCounts = new HashMap<>();
            Map<String, List<String>> reportersPerUser = new HashMap<>();
            Map<String, Integer> mailCounts = new HashMap<>();
            
            for(String reportInfo : report) {
                String[] temp = reportInfo.split(" ");
                String reporter = temp[0];
                String target = temp[1];
                
                List<String> reported_id_list = reportersPerUser.getOrDefault(target, new LinkedList<>());
                
                if(reported_id_list.contains(reporter)) continue;
                
                reported_id_list.add(reporter);
                reportersPerUser.put(target, reported_id_list);
                
                reportCounts.put(target, reportCounts.getOrDefault(target, 0) + 1);
            }
            
            for(String id : reportCounts.keySet()) {
                if(reportCounts.get(id) >= k) {
                    for(String reported_id : reportersPerUser.get(id)) {
                        mailCounts.put(reported_id, mailCounts.getOrDefault(reported_id, 0) + 1);
                    }
                }
            }
            
            int[] answer = new int[idCount];
            int idx = 0;
            for(String id : id_list) {
                answer[idx++] = mailCounts.getOrDefault(id, 0);
            }
            return answer;
        }
    }
}
