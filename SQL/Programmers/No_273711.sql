-- 문제 : 업그레이드 된 아이템 구하기
-- 풀이 일자 : 2025.03.20
-- 설명 : https://school.programmers.co.kr/learn/courses/30/lessons/273711

SELECT D.ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO D
JOIN (
    SELECT A.ITEM_ID
    FROM ITEM_TREE A
    LEFT JOIN ITEM_INFO B ON A.PARENT_ITEM_ID = B.ITEM_ID
    WHERE B.RARITY = 'RARE'
) C ON D.ITEM_ID = C.ITEM_ID
ORDER BY ITEM_ID DESC;