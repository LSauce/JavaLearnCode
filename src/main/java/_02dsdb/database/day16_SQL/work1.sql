-- 创建一个城市表，字段有id、名字、所属国家名字、人口、所属省份
-- 并插入若干数据
USE homework_55th;
CREATE TABLE day15_city
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255),
    country    VARCHAR(255),
    population INT,
    province   VARCHAR(255)
);

INSERT INTO day15_city (name, country, population, province)
VALUES ('北京', '中国', 2171, '北京市'),
       ('上海', '中国', 2418, '上海市'),
       ('广州', '中国', 1490, '广东省'),
       ('深圳', '中国', 1303, '广东省'),
       ('杭州', '中国', 981, '浙江省'),
       ('成都', '中国', 1633, '四川省'),
       ('重庆', '中国', 3048, '重庆市'),
       ('武汉', '中国', 1121, '湖北省'),
       ('南京', '中国', 847, '江苏省'),
       ('天津', '中国', 1558, '天津市'),
       ('纽约', '美国', 8538, '纽约州'),
       ('伦敦', '英国', 8982, '大伦敦'),
       ('东京', '日本', 1393, '东京都'),
       ('巴黎', '法国', 2148, '法兰西岛大区'),
       ('柏林', '德国', 3675, '柏林州'),
       ('莫斯科', '俄罗斯', 1262, '莫斯科市'),
       ('悉尼', '澳大利亚', 5312, '新南威尔士州'),
       ('开罗', '埃及', 2041, '开罗省'),
       ('孟买', '印度', 1244, '马哈拉施特拉邦'),
       ('约翰内斯堡', '南非', 957, '豪登省');
-- 1. 查询所有城市名及人口信息
SELECT name, population
FROM day15_city;
-- 2. 查询city表中，所有中国的城市信息
SELECT *
FROM day15_city
WHERE country = '中国';
-- 3. 查询人口数小于100人城市信息
SELECT *
FROM day15_city
WHERE population < 100;
-- 4. 查询中国,人口数超过500的所有城市信息
SELECT *
FROM day15_city
WHERE country = '中国'
  and population > 500;
-- 5. 查询中国或美国的城市信息
SELECT *
FROM day15_city
WHERE country in ('中国', '美国');
-- 6. 查询人口数为100-200（包括两头）城市信息
SELECT *
FROM day15_city
WHERE population BETWEEN 100 AND 200;
-- 7. 查询中国或美国，人口数大于500的城市
SELECT *
FROM day15_city
WHERE population > 500
  AND country IN ('中国', '美国');
-- 8. 查询城市名为qing开头的城市信息
SELECT *
FROM day15_city
WHERE name LIKE 'qing%';
-- 9. 统计city表的行数
SELECT COUNT(*) AS '城市行数'
FROM day15_city;
-- 10.统计各国城市的个数
SELECT country, COUNT(*) AS '城市个数'
FROM day15_city
GROUP BY country;
-- 11.统计每个国家的城市总人口数
SELECT country, SUM(population) AS '总人数'
FROM day15_city
GROUP BY country;
-- 12.统计中国每个省的城市个数及城市名列表
SELECT province, COUNT(name), GROUP_CONCAT(name)
FROM day15_city
WHERE country = '中国'
GROUP BY province;
-- 13.统计每个国家的城市个数,并且只显示超过5个城市的国家
SELECT country, COUNT(name)
FROM day15_city
GROUP BY country
HAVING COUNT(name) > 5; -- having对 分组后的结果 进行筛选
-- 14.统计每个国家的城市个数,并且只显示超过5个城市的国家并按照从大到小排序
SELECT country, COUNT(name)
FROM day15_city
GROUP BY country
HAVING COUNT(name) > 5
ORDER BY COUNT(name) DESC;

-- 15.统计每个国家的城市个数,并且只显示超过5个城市的国家并按照从大到小排序,并且只显示排名前三
SELECT country, COUNT(name)
FROM day15_city
GROUP BY country
HAVING COUNT(name) > 5
ORDER BY COUNT(name) DESC
LIMIT 3; -- LIMIT 必须放在最后，不能放 ORDER，要不排序不就是 无效排序了

INSERT INTO day15_city (name, country, population, province) VALUES
('悉尼', '澳大利亚', 5312, '新南威尔士州'),
('墨尔本', '澳大利亚', 4967, '维多利亚州'),
('布里斯班', '澳大利亚', 2472, '昆士兰州'),
('珀斯', '澳大利亚', 2070, '西澳大利亚州'),
('阿德莱德', '澳大利亚', 1345, '南澳大利亚州'),
('堪培拉', '澳大利亚', 426, '澳大利亚首都地区'),
('奥克兰', '新西兰', 1522, '奥克兰地区'),
('惠灵顿', '新西兰', 412, '惠灵顿地区'),
('克赖斯特彻奇', '新西兰', 401, '坎特伯雷地区'),
('汉密尔顿', '新西兰', 238, '怀卡托地区'),
('温哥华', '加拿大', 675, '不列颠哥伦比亚省'),
('多伦多', '加拿大', 2930, '安大略省'),
('蒙特利尔', '加拿大', 1760, '魁北克省'),
('卡尔加里', '加拿大', 1235, '阿尔伯塔省'),
('渥太华', '加拿大', 989, '安大略省'),
('巴黎', '法国', 2148, '法兰西岛大区'),
('马赛', '法国', 862, '普罗旺斯-阿尔卑斯-蓝色海岸大区'),
('里昂', '法国', 515, '奥弗涅-罗讷-阿尔卑斯大区'),
('尼斯', '法国', 340, '普罗旺斯-阿尔卑斯-蓝色海岸大区'),
('图卢兹', '法国', 466, '奥克西塔尼大区'),
('马德里', '西班牙', 3266, '马德里自治区');