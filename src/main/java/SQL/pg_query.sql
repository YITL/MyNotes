-- 这里仅记录涉及rank()函数的题目

-- 22、查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
SELECT 
	sid, score, cid, rank_num
FROM(
	SELECT 
		sid,
		score,
		cid,
		RANK() OVER(PARTITION BY cid ORDER BY score	DESC) rank_num
	FROM "SC"
) t
WHERE rank_num IN (2,3)

-- 24、查询学生平均成绩及其名次
SELECT
	sid,
	avg_score,
	RANK() OVER (ORDER BY avg_score DESC)
FROM (
	SELECT 
		sid,
		AVG(score) avg_score
	FROM "SC"
	GROUP BY sid
) t

-- 25、查询各科成绩前三名的记录
SELECT 
	sid, score, cid, rank_num
FROM(
	SELECT 
		sid,
		score,
		cid,
		RANK() OVER(PARTITION BY cid ORDER BY score	DESC) rank_num
	FROM "SC"
) t
WHERE rank_num <= 3

-- 42、查询每门功课成绩最好的前两名
SELECT
	sid, score, cid, rank_num
FROM(
	SELECT
		sid, score, cid,
	RANK() OVER(PARTITION by cid ORDER BY score DESC) rank_num
	FROM "SC"
)t
WHERE rank_num <= 2


