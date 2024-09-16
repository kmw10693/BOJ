-- 코드를 입력하세요
SELECT A.APNT_NO, P.PT_NAME, P.PT_NO, A.MCDP_CD, D.DR_NAME, A.APNT_YMD from APPOINTMENT as A
join PATIENT as P on A.PT_NO = P.PT_NO
join DOCTOR as D on D.DR_ID = A.MDDR_ID
where A.APNT_YMD like '2022-04-13%' and A.APNT_CNCL_YN = 'N'
order by A.APNT_YMD asc
