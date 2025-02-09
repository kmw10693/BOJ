-- 코드를 작성해주세요
SELECT count(*) as FISH_COUNT, FISH_NAME
from FISH_INFO I, FISH_NAME_INFO N
where I.FISH_TYPE = N.FISH_TYPE
group by FISH_NAME
order by FISH_COUNT desc;