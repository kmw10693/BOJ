-- 코드를 입력하세요
select HOUR(DATETIME) as HOUR, count(*) as COUNT from ANIMAL_OUTS
where HOUR(DATETIME) >= 9 and HOUR(DATETIME) < 20
group by HOUR(DATETIME)
ORDER by HOUR(DATETIME);