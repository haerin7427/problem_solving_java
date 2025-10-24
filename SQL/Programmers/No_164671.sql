-- 문제 : 조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
-- 풀이 일자 : 2025.10.24
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/164671

SELECT CONCAT('/home/grep/src/', BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) FILE_PATH
FROM USED_GOODS_FILE
WHERE BOARD_ID IN (
    SELECT BOARD_ID
    FROM USED_GOODS_BOARD
    WHERE VIEWS = (SELECT MAX(VIEWS) MAX_VIEWS FROM USED_GOODS_BOARD)
)
ORDER BY FILE_ID DESC
;