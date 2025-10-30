package String.programmers;

// 문제 : 신규 아이디 추천
// 풀이 일자 : 2025.10.30
// 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/72410

public class No_72410 {
    public String solution(String new_id) {
        
        String recommand_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "");        
        recommand_id = recommand_id.replaceAll("\\.{2,}", ".");
        recommand_id = recommand_id.replaceAll("^\\.+", "").replaceAll("\\.+$", "");
        
        if(recommand_id.length() == 0) {
            recommand_id = "a";
        }else if(recommand_id.length() > 15) {
            recommand_id = recommand_id.substring(0,15);
            recommand_id = recommand_id.replaceAll("\\.+$", "");
        }
        
        if(recommand_id.length() <= 2) {
            StringBuffer sb = new StringBuffer();
            sb.append(recommand_id);
            while(sb.length() < 3) {
                sb.append(recommand_id.charAt(recommand_id.length()-1));
            }
            recommand_id = sb.toString();
        }
        return recommand_id;
    }
}
