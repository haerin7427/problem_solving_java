-- 문제 : 없어진 기록 찾기
-- 풀이 일자 : 2025.09.08
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/59042

SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM ANIMAL_INS)
ORDER BY ANIMAL_ID
;