-- 코드를 작성해주세요
select A.ID, A.GENOTYPE, B.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA A, ECOLI_DATA B
where A.PARENT_ID = B.ID and A.GENOTYPE & B.GENOTYPE = B.GENOTYPE
order by ID asc;