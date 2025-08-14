-- 문제 : 인기있는 아이스크림
-- 풀이 일자 : 2025.08.14
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/133024

SELECT FLAVOR
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC
;