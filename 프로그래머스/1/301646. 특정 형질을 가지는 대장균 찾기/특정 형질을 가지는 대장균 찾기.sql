-- 코드를 작성해주세요
select count(ID) as COUNT
from ECOLI_DATA
where CONV(GENOTYPE, 10, 2) not like '%1_' and (CONV(GENOTYPE, 10, 2) like '%1' or CONV(GENOTYPE, 10, 2) like '%1__')