-- 코드를 입력하세요
select B.CATEGORY, sum(SALES) as TOTAL_SALES from BOOK_SALES S
join BOOK B on S.BOOK_ID = B.BOOK_ID
where YEAR(SALES_DATE) = 2022 and MONTH(SALES_DATE) = 1
group by B.CATEGORY
order by B.CATEGORY asc;