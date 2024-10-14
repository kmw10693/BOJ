select BOOK_ID, AUTHOR_NAME, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE from BOOK b
join AUTHOR A on b.author_id = a.author_id
where b.category = '경제'
order by published_date asc;