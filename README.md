
# commons-tools
=======
# commons-tools

## CSS 样式
`````
  src/main/webapp/static/css/style.css
`````

## JSP 
`````
  src/main/webapp/pages/jsp/
`````

### search jar 
````
javax.naming.ldap.InitialLdapContext
````

### 安装mysql
````
1、修改my-default.ini
2、添加
	basedir=D:\Program Files\MySql\mysql-5.7.17-winx64
	datadir=D:\Program Files\MySql\mysql-5.7.17-winx64\data
3、mysqld -install
4、mysqld --initialize 
5、net start mysql
6、查询data目录下的*.err最后会有一个默认的密码就可以了
7、使用 mysql -u root -p 初始化的密码
8、修改密码set password for root@localhost = password('123456');
````




git reset --hard  HEAD

find -type f|xargs grep -i e2e

## vim 命令
set nowrapscan  禁止在搜索到文件两端时重新搜索
set incsearch  输入搜索内容时就显示搜索结果
set hlsearch   搜索时高亮显示被找到的文本
set number  显示行号
