-- 코드를 작성해주세요
select H.DEPT_ID, H.DEPT_NAME_EN, ROUND(avg(R.SAL), 0) as AVG_SAL from HR_DEPARTMENT H, HR_EMPLOYEES R
where H.DEPT_ID = R.DEPT_ID
group by H.DEPT_ID
order by AVG_SAL desc
