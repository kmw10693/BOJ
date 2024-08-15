-- 코드를 작성해주세요
select info.ITEM_ID, ITEM_NAME, RARITY from ITEM_INFO as info
join ITEM_TREE as tree on info.ITEM_ID = tree.ITEM_ID
where info.ITEM_ID NOT IN (SELECT PARENT_ITEM_ID from ITEM_TREE where PARENT_ITEM_ID is not null group by PARENT_ITEM_ID  )
order by ITEM_ID desc