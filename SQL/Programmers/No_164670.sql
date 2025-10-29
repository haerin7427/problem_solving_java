-- 문제 : 조건에 맞는 사용자 정보 조회하기
-- 풀이 일자 : 2025.10.29
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/164670

WITH COUNT_BOARD AS (
    SELECT WRITER_ID, COUNT(*) CNT
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING CNT >= 3
)
SELECT USER_ID, 
        NICKNAME, 
        CONCAT(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) AS '전체주소', 
        CONCAT(
            SUBSTRING(TLNO, 1, 3), "-",  -- 앞자리 (010)
            SUBSTRING(TLNO, 4, 4), "-",  -- 가운데자리 (1234)
            SUBSTRING(TLNO, 8)          -- 뒷자리 (5678)
        ) AS '전화번호'
FROM COUNT_BOARD 
LEFT JOIN USED_GOODS_USER ON COUNT_BOARD.WRITER_ID = USED_GOODS_USER.USER_ID
ORDER BY USER_ID DESC
;