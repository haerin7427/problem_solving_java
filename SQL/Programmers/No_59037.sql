-- 문제 : 어린 동물 찾기
-- 풀이 일자 : 2025.10.20
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/59037

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID ASC
;