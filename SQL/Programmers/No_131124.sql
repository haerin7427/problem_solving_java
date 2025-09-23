-- 문제 : 그룹별 조건에 맞는 식당 목록 출력하기
-- 풀이 일자 : 2025.09.23
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131124

SELECT B.MEMBER_NAME, A.REVIEW_TEXT, DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") REVIEW_DATE
FROM REST_REVIEW A
LEFT JOIN MEMBER_PROFILE B ON A.MEMBER_ID = B.MEMBER_ID
WHERE
B.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM (
        SELECT MEMBER_ID,
               COUNT(*) AS CNT,
               RANK() OVER (ORDER BY COUNT(*) DESC) AS RNK
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
    ) C
    WHERE RNK = 1
)
ORDER BY REVIEW_DATE ASC, REVIEW_TEXT ASC
;