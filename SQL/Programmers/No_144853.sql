-- 문제 : 조건에 맞는 도서 리스트 출력하기
-- 풀이 일자 : 2025.08.15
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/144853

SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = '인문' 
and DATE_FORMAT(PUBLISHED_DATE, '%Y') = 2021
ORDER BY PUBLISHED_DATE
;