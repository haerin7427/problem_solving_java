-- 문제 : 조건에 맞는 도서와 저자 리스트 출력하기
-- 풀이 일자 : 2025.09.06
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/144854

SELECT BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE,'%Y-%m-%d') PUBLISHED_DATE
FROM BOOK B
LEFT JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE B.CATEGORY = '경제'
ORDER BY PUBLISHED_DATE
;