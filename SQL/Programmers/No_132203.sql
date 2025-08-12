-- 문제 : 흉부외과 또는 일반외과 의사 목록 출력하기
-- 풀이 일자 : 2025.08.12
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/132203

SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d") AS HIRE_YMD
FROM DOCTOR
WHERE DOCTOR.MCDP_CD = "CS" OR DOCTOR.MCDP_CD = "GS"
ORDER BY HIRE_YMD DESC, DR_NAME ASC
;