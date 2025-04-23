-- 문제 : 조건에 맞는 아이템들의 가격의 총합 구하기
-- 풀이 일자 : 2025.04.23
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/273709

SELECT SUM(PRICE) TOTAL_PRICE
FROM ITEM_INFO
WHERE RARITY = 'LEGEND'
;