-- 문제 : 언어별 개발자 분류하기
-- 풀이 일자 : 2026.04.20
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/276036

SELECT
    CASE 
        WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE NAME = "Python") != 0
            AND SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = "Front End") != 0
                THEN 'A'
        WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE NAME = "C#") != 0
            THEN 'B'
        WHEN SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = "Front End") != 0
            THEN 'C'
        ELSE NULL
    END GRADE, ID, EMAIL
FROM DEVELOPERS
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID
;