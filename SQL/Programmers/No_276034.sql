-- 문제 : 조건에 맞는 개발자 찾기
-- 풀이 일자 : 2025.10.20
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/276034

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS A
JOIN SKILLCODES B ON A.SKILL_CODE & B.CODE = B.CODE
WHERE B.NAME = 'Python' OR B.NAME = 'C#'
GROUP BY ID, EMAIL, FIRST_NAME, LAST_NAME
ORDER BY ID ASC
;