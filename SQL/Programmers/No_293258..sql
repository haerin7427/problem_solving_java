-- 문제 : 잔챙이 잡은 수 구하기
-- 풀이 일자 : 2025.03.20
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/293258

SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO
WHERE LENGTH IS NULL
;