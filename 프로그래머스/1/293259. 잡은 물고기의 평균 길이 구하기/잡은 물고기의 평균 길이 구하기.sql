-- 코드를 작성해주세요
select round(sum(ifnull(length, 10))/count(*), 2) as AVERAGE_LENGTH
from FISH_INFO