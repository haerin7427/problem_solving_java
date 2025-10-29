-- 문제 : 이름이 있는 동물의 아이디
-- 풀이 일자 : 2025.10.29
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/59407

SELECT ANIMAL_ID
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID ASC
;