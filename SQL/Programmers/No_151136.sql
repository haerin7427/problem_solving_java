-- 문제 : 평균 일일 대여 요금 구하기
-- 풀이 일자 : 2025.08.15
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/151136

SELECT ROUND(AVG(DAILY_FEE),0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'
;