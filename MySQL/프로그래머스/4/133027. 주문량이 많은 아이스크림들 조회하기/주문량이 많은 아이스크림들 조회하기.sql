-- 코드를 입력하세요
WITH first_half_total AS (
    SELECT
        flavor,
        SUM(total_order) AS total_order
    FROM first_half
    GROUP BY flavor
), july_total AS (
    SELECT
        flavor,
        SUM(total_order) as total_order
    FROM july
    GROUP BY flavor
)


SELECT
    f.flavor
FROM first_half_total as f
JOIN july_total j
    ON f.flavor = j.flavor
GROUP BY f.flavor
ORDER BY (f.total_order + j.total_order) DESC
LIMIT 3

