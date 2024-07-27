-- 코드를 작성해주세요
select count(*) as FISH_COUNT
FROM FISH_INFO
where date_format(time, '%Y') = 2021
