-- 문제 : 잡은 물고기 중 가장 큰 물고기의 길이 구하기
-- 풀이 일자 : 2025.06.22
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/298515
SELECT CONCAT(MAX(LENGTH), 'cm') MAX_LENGTH
FROM FISH_INFO
;