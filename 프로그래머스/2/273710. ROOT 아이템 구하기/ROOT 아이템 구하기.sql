-- 코드를 작성해주세요
SELECT T.ITEM_ID, ITEM_NAME from ITEM_TREE T
join ITEM_INFO I on T.ITEM_ID = I.ITEM_ID
where PARENT_ITEM_ID is NULL
order by T.ITEM_ID asc;