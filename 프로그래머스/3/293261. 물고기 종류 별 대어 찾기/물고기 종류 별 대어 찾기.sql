-- 코드를 작성해주세요
select ID, n.FISH_NAME, LENGTH from FISH_INFO as i
join FISH_NAME_INFO as n on i.FISH_TYPE = n.FISH_TYPE
where n.FISH_TYPE in (select FISH_TYPE from FISH_INFO group by FISH_TYPE HAVING LENGTH = MAX(LENGTH))