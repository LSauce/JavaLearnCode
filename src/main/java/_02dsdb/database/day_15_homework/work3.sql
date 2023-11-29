-- 现在有一个学生表，需要存储的信息包括，学生id，姓名，年龄，身高，体重，籍贯，身份证号，联系电话
--
-- 现在有一个图书信息表，需要存储的信息包括，序号，书名，作者，出版社，出版日期，定价，备注
-- 插入几条SQL，练习一下，预习一下。
USE homework_55th;
CREATE TABLE student3
(
    id                 INT PRIMARY KEY,
    name               VARCHAR(50),
    age                INT,
    height             INT,
    weight             INT,
    hometown           VARCHAR(50),
    resident_id_number CHAR(18),
    phone_number       VARCHAR(100)
);

CREATE TABLE book
(
    id               INT PRIMARY KEY,
    book_name        VARCHAR(1000),
    author           VARCHAR(50),
    publishing_house VARCHAR(1000),
    publication_date DATE,
    price            DECIMAL,
    remarks          VARCHAR(1000)
);

INSERT INTO student3 (id, name, age, height, weight, hometown, resident_id_number, phone_number)
VALUES (1, '张三', 20, 175, 65, '北京', '110101199001010001', '1234567890'),
       (2, '李四', 22, 180, 70, '上海', '310101199002020002', '9876543210'),
       (3, '王五', 21, 168, 55, '广州', '440101199003030003', '1357924680');

INSERT INTO book (id, book_name, author, publishing_house, publication_date, price, remarks)
VALUES (1, '红楼梦', '曹雪芹', '人民文学出版社', '2020-01-01', 59.99, '经典名著'),
       (2, '水浒传', '施耐庵', '人民文学出版社', '2019-12-15', 49.99, '中国四大名著之一'),
       (3, '西游记', '吴承恩', '人民文学出版社', '2021-03-10', 55.00, '中国四大名著之一');


