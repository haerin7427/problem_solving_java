-- 문제 : 오랜 기간 보호한 동물(2)
-- 풀이 일자 : 2026.04.28
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/59411

WITH INFO AS (
    SELECT A.ANIMAL_ID, A.NAME, DATEDIFF(A.DATETIME, B.DATETIME) DIF
    FROM ANIMAL_OUTS A
    LEFT JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
    ORDER BY DIF DESC
)
SELECT ANIMAL_ID, NAME
FROM INFO
LIMIT 2
;