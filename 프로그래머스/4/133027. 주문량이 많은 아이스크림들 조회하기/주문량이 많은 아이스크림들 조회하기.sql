-- 코드를 입력하세요
WITH JULYA AS (
    SELECT SHIPMENT_ID, FLAVOR, sum(TOTAL_ORDER) as TOTAL_ORDER
    from JULY group by FLAVOR
),
A AS(
    SELECT F.FLAVOR, F.TOTAL_ORDER + J.TOTAL_ORDER as TOTAL_ORDER from FIRST_HALF as F
    join JULYA as J on F.FLAVOR = J.FLAVOR
    order by TOTAL_ORDER desc
)
SELECT A.FLAVOR from A
limit 3