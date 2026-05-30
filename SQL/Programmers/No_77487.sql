-- 문제 : 헤비 유저가 소유한 장소
-- 풀이 일자 : 2026.05.04
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/77487

SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(*) > 1
)
ORDER BY ID ASC;