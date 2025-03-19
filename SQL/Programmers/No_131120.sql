-- 문제 : 3월에 태어난 여성 회원 목록 출력하기
-- 풀이 일자 : 2025.03.19
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131120

SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W' and MONTH(DATE_OF_BIRTH) = 3 and TLNO IS NOT NULL
ORDER BY MEMBER_ID;