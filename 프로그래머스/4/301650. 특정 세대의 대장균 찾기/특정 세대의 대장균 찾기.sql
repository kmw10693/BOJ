-- 코드를 작성해주세요
WITH FIRST_GEN AS(
    select ID, PARENT_ID from ECOLI_DATA
    where PARENT_ID is NULL
),
SECOND_GEN AS(
    select D.ID, D.PARENT_ID from ECOLI_DATA D
    join FIRST_GEN G on D.PARENT_ID = G.ID
)

select E.ID from ECOLI_DATA E
join SECOND_GEN S on E.PARENT_ID = S.ID
order by E.ID;