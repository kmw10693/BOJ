select A.ID, case 
              when A.PERCENT <= 0.25 then 'LOW'
              when A.PERCENT <= 0.5 then 'MEDIUM'
              when A.PERCENT <= 0.75 then 'HIGH'
             else 'CRITICAL' END AS COLONY_NAME
from( SELECT ID, PERCENT_RANK() OVER (order by SIZE_OF_COLONY) as PERCENT from ECOLI_DATA) A
order by ID asc;