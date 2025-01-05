-- 코드를 작성해주세요
SELECT t.id FROM ecoli_data f
JOIN ecoli_data s ON s.parent_id = f.id
JOIN ecoli_data t ON t.parent_id = s.id
WHERE f.parent_id IS NULL
ORDER BY id ASC