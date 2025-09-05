-- 문제 : 서울에 위치한 식당 목록 출력하기
-- 풀이 일자 : 2025.09.05
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131118

SELECT A.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(SCORE, 2) SCORE
FROM REST_INFO A
    INNER JOIN (SELECT REST_ID, AVG(REVIEW_SCORE) SCORE
                FROM REST_REVIEW 
               GROUP BY REST_ID) B ON A.REST_ID = B.REST_ID
WHERE 
    A.ADDRESS LIKE '서울%'
ORDER BY SCORE DESC, FAVORITES DESC
    ;