-- 문제 : 카테고리 별 상품 개수 구하기
-- 풀이 일자 : 2026.05.05
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131529

SELECT CATEGORY, COUNT(*) PRODUCTS
FROM (
    SELECT SUBSTRING(PRODUCT_CODE, 1, 2) CATEGORY
    FROM PRODUCT
    ) A
GROUP BY CATEGORY
ORDER BY CATEGORY ASC
;