-- 코드를 작성해주세요
select D.DEPT_ID, DEPT_NAME_EN, ROUND(AVG(E.SAL), 0) as AVG_SAL from HR_DEPARTMENT as D
join HR_EMPLOYEES as E on D.DEPT_ID = E.DEPT_ID
group by D.DEPT_ID
order by AVG_SAL desc