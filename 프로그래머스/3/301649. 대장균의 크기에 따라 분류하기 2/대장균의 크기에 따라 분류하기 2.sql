-- 코드를 작성해주세요
select A.ID,
case
    when A.PER <= 0.25 then 'CRITICAL'
    when A.PER <= 0.5 then 'HIGH'
    when A.PER <= 0.75 then 'MEDIUM'
    ELSE 'LOW'
END AS COLONY_NAME
from(
    select ID,
    PERCENT_RANK() over (ORDER BY SIZE_OF_COLONY desc) as PER
    FROM ECOLI_DATA
) AS A
ORDER BY A.ID