-- 코드를 작성해주세요
WITH c AS (
    SELECT 
        parent_id, 
        COUNT(*) AS child_count
    FROM ecoli_data
    WHERE parent_id IS NOT NULL
    GROUP BY parent_id
) 

SELECT
    e.id, 
    IFNULL(child_count, 0) as child_count
FROM
    ecoli_data e
LEFT JOIN c ON c.parent_id = e.id
