select he.dept_id, dept_name_en as DEPT_NAME_EN, round(avg(sal),0) as AVG_SAL from hr_employees as he
join hr_department as hd on he.dept_id = hd.dept_id
group by dept_id, dept_name_en
order by avg_sal desc;