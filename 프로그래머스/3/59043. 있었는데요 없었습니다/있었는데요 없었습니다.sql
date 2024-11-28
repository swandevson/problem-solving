SELECT
    ins.animal_id as ANIMAL_ID,
    ins.name as NAME
FROM
    animal_ins as ins
LEFT JOIN
    animal_outs as outs
ON
    ins.animal_id = outs.animal_id
WHERE
    ins.datetime > outs.datetime
ORDER BY ins.datetime
;