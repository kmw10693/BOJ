select D.ID, case when D.S <= 0.25 then 'CRITICAL'
             when D.S <= 0.5 then 'HIGH'
             when D.S <= 0.75 then 'MEDIUM'
             else 'LOW'
             end as COLONY_NAME
from (select ID, PERCENT_RANK() over(order by SIZE_OF_COLONY desc) as S from ECOLI_DATA) D
order by ID asc;