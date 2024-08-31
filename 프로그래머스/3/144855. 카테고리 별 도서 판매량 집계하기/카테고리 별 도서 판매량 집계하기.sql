-- 코드를 입력하세요
SELECT CATEGORY, SUM(b.sales) as TOTAL_SALES
from BOOK a
join BOOK_SALES as b on a.BOOK_ID = b.BOOK_ID
where b.SALES_DATE like '2022-01%'
group by a.CATEGORY
order by a.CATEGORY