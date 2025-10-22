-- 문제 : 상품을 구매한 회원 비율 구하기
-- 풀이 일자 : 2025.10.22
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/131534

SELECT YEAR, MONTH, COUNT(DISTINCT USER_ID) PURCHASED_USERS, ROUND(COUNT(DISTINCT USER_ID) / TOTAL_USER_2021,1) PUCHASED_RATIO
FROM (
    SELECT YEAR(sales_date) YEAR, MONTH(sales_date) MONTH, A.USER_ID, TOTAL_USER_2021
    FROM ONLINE_SALE A
    INNER JOIN (SELECT USER_ID, (
                    SELECT COUNT(*)
                    FROM USER_INFO 
                    WHERE YEAR(JOINED) = '2021') AS TOTAL_USER_2021
                FROM USER_INFO WHERE YEAR(JOINED) = '2021'
               ) B ON A.USER_ID = B.USER_ID
) C
GROUP BY YEAR, MONTH