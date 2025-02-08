select sum(G.score) as SCORE, G.EMP_NO, H.EMP_NAME, H.POSITION, H.EMAIL from HR_EMPLOYEES H, HR_GRADE G
where H.EMP_NO = G.EMP_NO
group by H.EMP_NO
order by SCORE desc limit 1;