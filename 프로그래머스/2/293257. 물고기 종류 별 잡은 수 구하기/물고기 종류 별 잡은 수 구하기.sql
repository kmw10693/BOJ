-- 코드를 작성해주세요
select count(id) as FISH_COUNT, N.FISH_NAME
from FISH_NAME_INFO N
JOIN FISH_INFO I ON I.FISH_TYPE = N.FISH_TYPE
group by N.FISH_NAME
order by 1 desc;