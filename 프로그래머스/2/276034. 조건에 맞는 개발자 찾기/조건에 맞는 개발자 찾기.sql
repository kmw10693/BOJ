-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME from DEVELOPERS
where SKILL_CODE & (select code from SKILLCODES where NAME = "PYTHON")
or SKILL_CODE & (select code from SKILLCODES where NAME = "C#")
order by ID;