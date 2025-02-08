select H.EMP_NO, E.EMP_NAME, (case when 
                    AVG(SCORE) >= 96 then 'S'
                    when AVG(SCORE) >= 90 then 'A'
                    when AVG(SCORE) >= 80 then 'B'
                    else 'C' END) as GRADE, 
                    (case 
                     when AVG(SCORE) >= 96 then E.SAL * 0.2
                     when AVG(SCORE) >= 90 then E.SAL * 0.15
                     when AVG(SCORE) >= 80 then E.SAL * 0.1
                     else 0 end) as BONUS
                    from HR_GRADE H, HR_EMPLOYEES E 
where H.EMP_NO = E.EMP_NO
group by H.EMP_NO
order by H.EMP_NO;