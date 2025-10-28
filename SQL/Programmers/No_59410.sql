-- 문제 : NULL 처리하기
-- 풀이 일자 : 2025.10.28
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/59410

SELECT ANIMAL_TYPE, IFNULL(NAME, 'No name') NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID
;