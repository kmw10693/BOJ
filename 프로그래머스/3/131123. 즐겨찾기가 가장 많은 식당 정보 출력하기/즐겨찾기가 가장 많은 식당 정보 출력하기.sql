-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO
where (food_type, favorites) IN (SELECT food_type, max(favorites) from REST_INFO GROUP BY FOOD_TYPE)
order by food_type desc