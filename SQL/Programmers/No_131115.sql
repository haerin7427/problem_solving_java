-- 문제 : 가격이 제일 비싼 식품의 정보 출력하기
-- 풀이 일자 : 2026.02.23
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131115

SELECT *
FROM FOOD_PRODUCT
WHERE PRICE = (SELECT MAX(PRICE) FROM FOOD_PRODUCT)
;