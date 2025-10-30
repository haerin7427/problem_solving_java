-- 문제 : 업그레이드 할 수 없는 아이템 구하기
-- 풀이 일자 : 2025.10.30
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/273712

SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID NOT IN (SELECT PARENT_ITEM_ID FROM ITEM_TREE WHERE PARENT_ITEM_ID IS NOT NULL )
ORDER BY ITEM_ID DESC
;