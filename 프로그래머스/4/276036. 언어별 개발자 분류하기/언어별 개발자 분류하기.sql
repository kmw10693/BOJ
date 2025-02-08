-- 코드를 작성해주세요
SELECT 
    case 
        when D.SKILL_CODE & (select CODE from SKILLCODES where NAME = "Python") and D.SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = "Front End") then 'A'
        when D.SKILL_CODE & (select CODE from SKILLCODES where NAME = "C#") then 'B'
        when D.SKILL_CODE & (select sum(CODE) from SKILLCODES where CATEGORY = "Front End") then 'C' end as GRADE, ID, EMAIL from DEVELOPERS D, SKILLCODES S
group by GRADE, ID, EMAIL
having GRADE is not NULL
order by GRADE, ID
                                                                        