-- 문제 : 강원도에 위치한 생산공장 목록 출력하기
-- 풀이 일자 : 2025.08.16
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131112

SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID
;