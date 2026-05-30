-- 문제 : 대장균들의 자식의 수 구하기
-- 풀이 일자 : 2026.05.05
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/299305

WITH INFO AS (
    SELECT A.ID, COUNT(*) CHILD_COUNT
    FROM ECOLI_DATA A LEFT JOIN ECOLI_DATA B ON A.ID = B.PARENT_ID
    WHERE B.ID IS NOT NULL
    GROUP BY A.ID
    )
    SELECT A.ID, IFNULL(CHILD_COUNT, 0) CHILD_COUNT
    FROM ECOLI_DATA A LEFT JOIN INFO B ON A.ID = B.ID
    ORDER BY ID ASC
;