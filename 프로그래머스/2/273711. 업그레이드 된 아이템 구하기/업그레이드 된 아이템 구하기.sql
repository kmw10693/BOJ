-- 코드를 작성해주세요
select it.ITEM_ID, it.ITEM_NAME, it.RARITY from ITEM_INFO as it
INNER JOIN ITEM_TREE il ON it.ITEM_ID = il.ITEM_ID
where il.PARENT_ITEM_ID in (select item_id from ITEM_INFO where rarity = 'RARE')
order by it.ITEM_ID desc;