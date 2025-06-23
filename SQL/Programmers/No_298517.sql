-- 문제 : 가장 큰 물고기 10마리 구하기
-- 풀이 일자 : 2025.06.23
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/298517
SELECT ID, LENGTH
FROM FISH_INFO
WHERE LENGTH > 10
ORDER BY LENGTH DESC, ID ASC
LIMIT 10
;