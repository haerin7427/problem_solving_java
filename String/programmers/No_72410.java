package String.programmers;

// 문제 : 신규 아이디 추천
// 풀이 일자 : 2025.10.30, 2026.04.29, 2026.06.25
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

    // 풀이 일자 : 2026.04.29
    class Solution2 {
        public String solution(String new_id) {

            new_id = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]","").replaceAll("\\.{2,}",".").replaceAll("^\\.","").replaceAll("\\.$","");
            if(new_id.length() == 0) {
                new_id = "a";
            }else if(new_id.length() >= 16) {
                new_id = new_id.substring(0, 15).replaceAll("\\.$","");
            }
            
            while(new_id.length() < 3) {
                new_id = new_id + new_id.charAt(new_id.length()-1);
            }
            return new_id;
        }
    }

    // 풀이 일자 : 2026.06.26
    class Solution3 {
        
        public String solution(String new_id) {
            
            String part1 = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]", "").replaceAll("\\.{2,}", ".").replaceAll("^[\\.]", "").replaceAll("[\\.]$", "");
            if(part1.length() == 0) {
                part1 = "aaa";
            }else if(part1.length() >= 16) {
                part1 = part1.substring(0,15).replaceAll("[\\.]$", "");
            }else if(part1.length() <= 2) {
                StringBuffer sb = new StringBuffer();
                sb.append(part1);
                int last_index = part1.length()-1;
                while(sb.toString().length() < 3) {
                    sb.append(part1.substring(last_index, last_index+1));
                }
                part1 = sb.toString();
            }
            
            return part1;
        }
    }
}