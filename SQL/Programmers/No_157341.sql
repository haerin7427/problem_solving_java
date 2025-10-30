-- 문제 : 대여 기록이 존재하는 자동차 리스트 구하기
-- 풀이 일자 : 2025.10.30
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/157341

SELECT DISTINCT CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE MONTH(START_DATE) = '10'
    AND CAR_ID IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_CAR WHERE CAR_TYPE = '세단')
ORDER BY CAR_ID DESC
;