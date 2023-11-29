/*
 使用学生信息表 和 课程成绩表
 测试 LEFT JOIN、RIGHT JOIN、INNER JOIN、OUTER JOIN
 */
use homework_55th;
CREATE TABLE students
(
    student_id INT,
    name       VARCHAR(50),
    age        INT,
    class      VARCHAR(50)
);


INSERT INTO students (student_id, name, age, class)
VALUES (1, 'Alice', 18, 'Class A'),
       (2, 'Bob', 19, 'Class B'),
       (3, 'Charlie', 20, 'Class C'),
       (4, 'David', 18, 'Class A'),
       (5, 'Emily', 19, 'Class B');

CREATE TABLE grades
(
    student_id INT,
    course     VARCHAR(50),
    grade      INT
);

INSERT INTO grades (student_id, course, grade)
VALUES (1, 'Math', 90),
       (1, 'Science', 85),
       (2, 'Math', 95),
       (2, 'Science', 92),
       (3, 'Math', 88),
       (3, 'Science', 90),
       (4, 'Math', 92),
       (4, 'Science', 87),
       (5, 'Math', 85),
       (5, 'Science', 90);
INSERT INTO students (student_id, name, age, class)
VALUES (6, 'fff', 18, 'Class A');
SELECT * from  students;
SELECT * from  grades;
# INNER JOIN 和 JOIN 和 CROSS JOIN一样, 这个只保留符合要求的
SELECT *
FROM students AS s2
         CROSS JOIN grades AS g2
                    ON s2.student_id = g2.student_id;
SELECT *
FROM students AS s
         INNER JOIN grades AS g
                    ON s.student_id = g.student_id
union
SELECT *
FROM students AS s2
         CROSS JOIN grades AS g2
                    ON s2.student_id = g2.student_id;
# OUTER JOIN mysql没有
SELECT *
FROM students AS s OUTER JOIN grades AS g
ON s.student_id = g.student_id;
#  测试 LEFT JOIN  必须加ON，如果没匹配，保留左边的
SELECT *
FROM students AS s
         LEFT JOIN grades AS g
                   ON s.student_id = g.student_id;
#  RIGHT JOIN、  必须加ON, 如果没匹配，保留右边的
SELECT *
FROM students AS s
         LEFT JOIN grades AS g
                   ON s.student_id = g.student_id;


CREATE TABLE student4
(
    student_id INT,
    name       VARCHAR(50),
    age        INT,
    class_id      INT
);

CREATE TABLE class
(
    id INT,
    name VARCHAR(255)
);


INSERT INTO student4 (student_id, name, age, class_id)
VALUES
    (1, 'John Doe', 20, 1001),
    (2, 'Jane Smith', 22, 1002),
    (3, 'Michael Johnson', 21, 1003),
    (4, 'Emily Davis', 19, 1004);

-- Insert data into the class table
INSERT INTO class (id, name)
VALUES
    (1001, 'Mathematics'),
    (1002, 'English'),
    (1003, 'Science'),
    (1004, 'History');


select * from student4;
select * from class;
DELETE FROM student4;


-- 显示学生和班级
select s.name,c.name
from student4 as s
join class as c on c.id = s.class_id;

-- 显示1003编号有哪些学生
select s.name,c.name
from student4 as s
join class as c on s.class_id = c.id
where class_id = 1003;

