CREATE TABLE IF NOT EXISTS category ( id INT PRIMARY KEY, name VARCHAR(255) NOT NULL );
CREATE TABLE IF NOT EXISTS course ( courseId int PRIMARY KEY, description varchar(255) ,price int,title varchar(100),
categoryId int not null,
 foreign key(categoryId) references category(id) ON DELETE CASCADE ON UPDATE CASCADE );
