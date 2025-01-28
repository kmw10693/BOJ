-- 코드를 작성해주세요
select ID, N.FISH_NAME, LENGTH from FISH_INFO I 
join FISH_NAME_INFO N on I.FISH_TYPE = N.FISH_TYPE
where (I.FISH_TYPE, I.LENGTH) in (select FISH_TYPE, MAX(LENGTH) from FISH_INFO
                                 group by FISH_TYPE)
order by 1