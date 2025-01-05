WITH percent_rank_by_size AS 
(
    SELECT
        id,
        PERCENT_RANK() OVER (ORDER BY size_of_colony DESC) * 100 AS size_rank
    FROM ecoli_data
)

# SELECT * FROM percent_rank_by_size
# ORDER BY id ASC;

SELECT 
    id, 
    CASE 
        WHEN size_rank <= 25 THEN 'CRITICAL'
        WHEN size_rank <= 50 THEN 'HIGH'
        WHEN size_rank <= 75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS colony_name
FROM percent_rank_by_size
ORDER BY id ASC;