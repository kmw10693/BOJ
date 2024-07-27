select ID, LENGTH
FROM FISH_INFO
order by IFNULL(LENGTH, 9) desc, id
limit 10