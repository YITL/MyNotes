-- 1查询"01"课程比"02"课程成绩高的所有学生的学号
SELECT DISTINCT
	t1.sid AS sid 
FROM
	( SELECT * FROM SC WHERE cid = '01' ) AS t1
	INNER JOIN ( SELECT * FROM SC WHERE cid = '02' ) AS t2 
	ON t1.sid = t2.sid 
WHERE
	t1.score > t2.score

-- 2查询平均成绩大于60分的同学的学号和平均成绩
SELECT 
	sid, AVG(score)
FROM SC
GROUP BY sid
HAVING AVG(score) > 60

-- 3查询所有同学的学号、姓名、选课数、总成绩
SELECT 
	s.sid,
	s.sname,
	COUNT(cid),
	SUM(score)
FROM Student AS s 
LEFT JOIN SC AS sc
ON s.sid = sc.sid
GROUP BY s.sid, s.sname

-- 4姓“李”的老师的个数
SELECT COUNT(tid)
FROM Teacher
WHERE tname LIKE '李%'

-- 5查询没学过“张三”老师课的同学的学号、姓名
SELECT sid, sname
FROM Student 
WHERE sid NOT IN(
	SELECT sid
	FROM Teacher t
	LEFT JOIN Course c ON t.tid = c.cid
	LEFT JOIN SC sc ON c.cid = sc.cid
	WHERE t.tname = '张三'
)

-- 6查询学过“01”并且也学过编号“02”课程的同学的学号、姓名
SELECT sid, sname 
FROM Student
WHERE sid IN(
	SELECT sid
	FROM SC
	GROUP BY sid
	HAVING COUNT(IF(cid = '01',score,NULL)) > 0 AND COUNT(IF(cid='02',score,NULL)) > 0
)

-- 7查询学过“张三”老师所教的课的同学的学号、姓名
SELECT sid, sname
FROM Student 
WHERE sid IN(
	SELECT sid
	FROM Teacher t
	LEFT JOIN Course c ON t.tid = c.cid
	LEFT JOIN SC sc ON c.cid = sc.cid
	WHERE t.tname = '张三'
)

-- 8查询课程编号“01”的成绩比课程编号“02”课程低的所有同学的学号、姓名
SELECT sid, sname
FROM Student
WHERE sid IN(
	SELECT 
		t1.sid
	FROM
		(SELECT * FROM SC WHERE cid = '01') AS t1
	LEFT JOIN
		(SELECT * FROM SC WHERE cid = '02') AS t2
	ON t1.sid = t2.sid
	WHERE t1.score < t2.score
)

-- 9查询所有课程成绩小于60分的同学的学号、姓名
SELECT sid, sname
FROM Student
WHERE sid IN(
	SELECT sid
	FROM SC AS sc
	GROUP BY sid
	HAVING MAX(score) < 60
)

-- 10查询没有学全所有课的同学的学号、姓名
SELECT sid, sname
FROM Student
WHERE sid IN(
	SELECT 
		sid
	FROM SC
	GROUP BY sid
	HAVING COUNT(cid) < (SELECT COUNT(*) FROM Course)
)

-- 11查询至少有一门课与学号为“01”的同学所学相同的同学的学号和姓名
SELECT DISTINCT sid
FROM SC
WHERE cid IN(
	SELECT cid
	FROM SC
	WHERE sid = '01'
)

-- 12查询和"01"号的同学学习的课程完全相同的其他同学的学号和姓名
SELECT sc.sid
FROM(
	SELECT cid
	FROM SC
	WHERE sid = '01'
)t1
LEFT JOIN SC sc
ON t1.cid = sc.cid
GROUP BY sc.sid
HAVING COUNT(DISTINCT sc.cid) = (SELECT COUNT(DISTINCT cid) FROM SC WHERE sid = '01')

-- 13把“SC”表中“张三”老师教的课的成绩都更改为此课程的平均成绩
UPDATE SC sc 
JOIN(
	SELECT cid, AVG(score) score
	FROM SC
	WHERE cid IN(SELECT FROM Teacher t INNER JOIN Course c ON t.tid = c.cid WHERE t.tname = '张三')
	GROUP BY cid
) t
ON sc.cid = t.cid
SET sc.score = t.score
## 最后测试

-- 14查询没学过"张三"老师讲授的任一门课程的学生姓名
SELECT sname
FROM Student
WHERE sid NOT IN(
	SELECT 
	DISTINCT sc.sid
	FROM SC sc
	LEFT JOIN Course c
	ON sc.cid = c.cid
	LEFT JOIN Teacher t
	ON c.tid = t.tid
	WHERE t.tname = '张三'
)

-- 15查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩
SELECT 
	t1.sid,
	s.sname,
	t1.avg_score
FROM (
	SELECT 
	sc.sid,
	AVG(score) avg_score,
	COUNT(IF(score<60,cid,NULL))
	FROM SC sc
	GROUP BY sid
	HAVING COUNT(IF(score<60,cid,NULL)) >= 2
)t1
LEFT JOIN 
Student s
ON t1.sid = s.sid

-- 16检索"01"课程分数小于60，按分数降序排列的学生信息
SELECT 
	s.*,
	t1.score
FROM(
	SELECT 
		DISTINCT sid, 
		score
	FROM SC
	WHERE cid = '01'
	AND score < '60'
)t1
LEFT JOIN
	Student s
ON t1.sid = s.sid
ORDER BY t1.score

-- 17按平均成绩从高到低显示所有学生的平均成绩
SELECT 
sid, 
AVG(score)
FROM 
SC
GROUP BY sid
ORDER BY AVG(score) DESC

-- 18查询各科成绩最高分、最低分和平均分：以如下形式显示：课程ID，课程name，最高分，最低分，平均分，及格率
SELECT
cid,
MAX(score),
MIN(score),
AVG(score),
COUNT(IF(score>=60,cid,NULL))/COUNT(cid) AS pass_rate
FROM SC
GROUP BY cid

--  19按各科平均成绩从低到高和及格率的百分数从高到低顺序
SELECT
cid,
AVG(score) avg_score,
COUNT(IF(score>=60,cid,NULL))/COUNT(cid) AS pass_rate
FROM SC
GROUP BY cid
ORDER BY avg_score, pass_rate DESC

-- 20查询学生的总成绩并进行排名
SELECT 
	sid,
	SUM(score) sum_score
FROM SC
GROUP BY sid
ORDER BY sum_score DESC

-- 21查询不同老师所教不同课程平均分从高到低显示
SELECT 
	c.tid,
	AVG(sc.score) avg_score
FROM SC sc
LEFT JOIN Course c
ON sc.cid = c.cid
GROUP BY c.tid
ORDER BY avg_score DESC

-- 22查询所有课程的成绩第2名到第3名的学生信息及该课程成绩
SELECT 
	*
FROM(
	SELECT 
		(SELECT COUNT(*) FROM SC t2 WHERE t1.cid = t2.cid AND t1.score <= t2.score) num,
		t1.*
	FROM SC t1
) sc
LEFT JOIN Student s
ON sc.sid = s.sid
WHERE sc.num IN (2,3)

-- 23统计各科成绩各分数段人数：课程编号,课程名称,[100-85],[85-70],[70-60],[0-60]及所占百分比
SELECT 
cid,
COUNT(IF(score>85,score,NULL))/COUNT(sid) count_85_100,
COUNT(IF(score>70&&score<=85,score,NULL))/COUNT(sid) count_70_85,
COUNT(IF(score>60&&score<=70,score,NULL))/COUNT(sid) count_60_70,
COUNT(IF(score<=60,score,NULL))/COUNT(sid) count_0_60
FROM SC sc
GROUP BY cid

-- 24查询学生平均成绩及其名次
SELECT 
	s.*,
	@rank := @rank+1 rank
FROM(
	SELECT
		sid,
		AVG(score) avg_score
	FROM SC
	GROUP BY sid
	ORDER BY avg_score DESC
) s, (SELECT @rank := 0) t
ORDER BY rank

-- 25查询各科成绩前三名的记录

-- 26查询每门课程被选修的学生数
SELECT 
cid,
COUNT(sid)
FROM SC
GROUP BY cid

-- 27查询出只选修了一门课程的全部学生的学号和姓名
SELECT 
sid
FROM SC
GROUP BY sid
HAVING COUNT(cid) = 1

-- 28查询男生、女生人数
SELECT 
ssex,
COUNT(sid)
FROM Student
GROUP BY ssex

-- 29查询名字中含有"风"字的学生信息
SELECT
*
FROM Student
WHERE sname LIKE '%风%'

-- 30查询同名同性学生名单，并统计同名人数
SELECT
	sname,
	ssex,
	COUNT(sid)
FROM Student s
GROUP BY sname,ssex
HAVING COUNT(sid) > 1

-- 31查询1990年出生的学生名单(注：Student表中Sage列的类型是datetime)
SELECT
*
FROM Student
WHERE YEAR(sage) = 1990

-- 32查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列
SELECT
	cid,
	AVG(score) AS avg_score
FROM SC
GROUP BY cid
ORDER BY avg_score, cid DESC

-- 37查询不及格的课程，并按课程号从大到小排列
SELECT
	*
FROM SC
WHERE score < 60
ORDER BY cid DESC

-- 38查询课程编号为"01"且课程成绩在60分以上的学生的学号和姓名；
SELECT
	*
FROM SC
WHERE score > 60 AND cid = '01'

-- 40查询选修“张三”老师所授课程的学生中，成绩最高的学生姓名及其成绩
SELECT
 t1.sid,
 t1.score
FROM SC t1
LEFT JOIN Course t2
ON t1.cid = t2.cid
LEFT JOIN Teacher t3
ON t2.tid = t3.tid
WHERE t3.tname = '张三'
ORDER BY score DESC
LIMIT 1

-- 42查询每门功课成绩最好的前两名

-- 43统计每门课程的学生选修人数（超过5人的课程才统计）。
-- 要求输出课程号和选修人数，查询结果按人数降序排列，若人数相同，按课程号升序排列
SELECT
	cid,
	COUNT(sid) count
FROM SC
GROUP BY cid
HAVING count > 5
ORDER BY count DESC, cid

-- 44检索至少选修两门课程的学生学号
SELECT 
	sid,
	COUNT(cid) count
FROM SC
GROUP BY sid
HAVING count >= 2

-- 45查询选修了全部课程的学生信息(严谨写法参考12)
SELECT
	sid,
	COUNT(cid) count
FROM SC
GROUP BY sid
HAVING count = (SELECT COUNT(DISTINCT cid) FROM Course)

-- 46查询各学生的年龄
SELECT
	sid,
	sname,
	YEAR(CURRENT_DATE) - YEAR(sage) age
FROM Student

-- 47查询本周过生日的学生
SELECT
 *
FROM Student
WHERE WEEKOFYEAR(sage) = WEEKOFYEAR(CURRENT_DATE)

-- 48查询下周过生日的学生
SELECT
 *
FROM Student
WHERE WEEKOFYEAR(sage) = WEEKOFYEAR(DATE_ADD(CURRENT_DATE, INTERVAL 1 WEEK))

-- 49查询本月过生日的学生
SELECT
 *
FROM Student
WHERE MONTH(sage) = MONTH(CURRENT_DATE)

-- 50查询下月过生日的学生
SELECT
 *
FROM Student
WHERE MONTH(CURRENT_DATE) = MONTH(DATE_SUB(sage,INTERVAL 1 MONTH))