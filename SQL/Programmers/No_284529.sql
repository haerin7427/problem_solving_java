-- 문제 : 부서별 평균 연봉 조회하기
-- 풀이 일자 : 2026.04.29
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/284529

SELECT A.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(SAL), 0) AVG_SAL
FROM HR_EMPLOYEES A LEFT JOIN HR_DEPARTMENT B ON A.DEPT_ID = B.DEPT_ID
GROUP BY A.DEPT_ID, DEPT_NAME_EN
ORDER BY AVG_SAL DESC
;