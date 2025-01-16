SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH from MEMBER_PROFILE
where month(DATE_OF_BIRTH) = 3 and GENDER = 'W' and TLNO is not NULL
order by MEMBER_ID asc;