-- 코드를 작성해주세요
select count(id) as FISH_COUNT
from FISH_INFO
where FISH_TYPE IN 
    (select FISH_TYPE FROM FISH_NAME_INFO WHERE FISH_NAME = 'BASS' or FISH_NAME = 'SNAPPER')