select B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, sum(BS.SALES * b.price) as TOTAL_SALES from BOOK B
join AUTHOR A on B.AUTHOR_ID = A.AUTHOR_ID
join BOOK_SALES BS on BS.BOOK_ID = B.BOOK_ID
where BS.SALES_DATE like '2022-01%'
group by a.author_id, b.category
order by a.author_id, b.category desc
