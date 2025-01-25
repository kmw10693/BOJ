-- 코드를 작성해주세요
SELECT I.ITEM_ID, ITEM_NAME, RARITY from ITEM_INFO I
join ITEM_TREE T on I.ITEM_ID = T.ITEM_ID
where PARENT_ITEM_ID in (select ITEM_ID from ITEM_INFO where RARITY = "RARE")
order by I.ITEM_ID desc;