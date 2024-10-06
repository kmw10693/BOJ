-- 코드를 작성해주세요
SELECT count(*) as FISH_COUNT, F.FISH_NAME from FISH_INFO I
join FISH_NAME_INFO F on I.FISH_TYPE = F.FISH_TYPE
group by F.FISH_NAME
order by FISH_COUNT desc;