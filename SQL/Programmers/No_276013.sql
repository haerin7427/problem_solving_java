-- 문제 : Python 개발자 찾기
-- 풀이 일자 : 2025.03.20
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/276013

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE
    (SKILL_1 = 'Python' OR SKILL_2 = 'Python' OR SKILL_3 = 'Python')
ORDER BY ID