-- 문제 : 대장균의 크기에 따라 분류하기 2
-- 풀이 일자 : 2025.10.29
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/301649

WITH RANK_SIZE AS (
SELECT ID, RANK() OVER (ORDER BY SIZE_OF_COLONY DESC) R
FROM ECOLI_DATA
)
, COUNT_ECOLI AS (
SELECT COUNT(*) CNT
FROM ECOLI_DATA
)
SELECT ID,
    CASE
        WHEN (R <= CNT / 4) THEN 'CRITICAL'
        WHEN (R <= CNT / 4 * 2) THEN 'HIGH'
        WHEN (R <= CNT / 4 * 3) THEN 'MEDIUM'
        ELSE 'LOW'
    END COLONY_NAME
FROM RANK_SIZE, COUNT_ECOLI
ORDER BY ID ASC
;