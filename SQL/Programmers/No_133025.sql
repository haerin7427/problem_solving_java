-- 문제 : 과일로 만든 아이스크림 고르기
-- 풀이 일자 : 2025.07.31
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/133025

SELECT A.FLAVOR
FROM ICECREAM_INFO A
LEFT JOIN FIRST_HALF B
    ON A.FLAVOR	= B.FLAVOR	
WHERE B.TOTAL_ORDER > 3000 and A.INGREDIENT_TYPE = "fruit_based"
ORDER BY TOTAL_ORDER DESC
;