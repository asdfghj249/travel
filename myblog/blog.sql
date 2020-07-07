/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-07-07 11:35:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `first_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `appreciation` int(11) NOT NULL DEFAULT '0' COMMENT '赞赏开启，默认 ，0开启，1关闭',
  `share_statement` int(11) NOT NULL DEFAULT '0' COMMENT '版权开启，默认 ，0开启，1关闭',
  `commentabled` int(11) NOT NULL DEFAULT '0' COMMENT '评论开启，默认 ，0开启，1关闭',
  `published` int(11) NOT NULL DEFAULT '0' COMMENT '博客发布，默认 ，0发布，1保存',
  `recommend` int(11) NOT NULL DEFAULT '0' COMMENT '是否推荐 默认 1推荐，0不推荐',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `description` text,
  `tag_ids` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES ('1', 'maven中静态资源的过滤', '# maven中静态资源的过滤\r\n\r\npom.xml文件中加入下面配置\r\n\r\n### 可以过滤java和resources文件夹里面所有的的.properties和.xml文件\r\n**directory：指定资源所在的目录，目录的路径是相对于pom.xml文件的\r\nincludes：指定要包含哪些文件**\r\n**filtering标签中：false表示不过滤，true表示过滤**\r\n\r\n```java\r\n    <build>\r\n        <resources>\r\n            <resource>\r\n                <directory>src/main/java</directory>\r\n                <includes>\r\n                    <include>**/*.properties</include>\r\n                    <include>**/*.xml</include>\r\n                </includes>\r\n                <filtering>false</filtering>\r\n            </resource>\r\n            <resource>\r\n                <directory>src/main/resources</directory>\r\n                <includes>\r\n                    <include>**/*.properties</include>\r\n                    <include>**/*.xml</include>\r\n                </includes>\r\n                <filtering>false</filtering>\r\n            </resource>\r\n        </resources>\r\n    </build>\r\n```\r\n', '/images/pictures/1.jpg', '原创', '157', '1', '1', '1', '1', '1', '2020-03-12 08:25:47', '2018-03-13 11:56:19', '3', '1', 'pom.xml文件中加入下面配置\r\n可以过滤java和resources文件夹里面所有的的.properties和.xml文件', '4');
INSERT INTO `t_blog` VALUES ('2', '使用System.out.format()格式化输出', '#### JDK5.0允许java像C语言那样直接用printf()方法来格式化输出\r\n####  System.out.format()功能与printf()一样，可以使用%d,%f等参数。\r\n使用System.out.format()完成**左对齐，补0，千位分隔符，小数点位数，本地化表达**\r\n```java\r\npublic class TestNumber {\r\n   \r\n    public static void main(String[] args) {\r\n        int year = 2020;\r\n        //左对齐，补0，千位分隔符，小数点位数，本地化表达\r\n        \r\n      //直接打印数字\r\n        System.out.println(year);\r\n          \r\n        //直接打印数字\r\n        System.out.format(\"%d%n\",year);\r\n        //总长度是8,默认右对齐\r\n        System.out.format(\"%8d%n\",year);\r\n        //总长度是8,左对齐\r\n        System.out.format(\"%-8d%n\",year);\r\n        //总长度是8,不够补0\r\n        System.out.format(\"%08d%n\",year);\r\n        //千位分隔符\r\n        System.out.format(\"%,8d%n\",year*10000);\r\n  \r\n        //保留5位小数\r\n        System.out.format(\"%.5f%n\",Math.PI);\r\n          \r\n        //不同国家的千位分隔符\r\n        System.out.format(Locale.FRANCE,\"%,.2f%n\",Math.PI*10000);\r\n        System.out.format(Locale.US,\"%,.2f%n\",Math.PI*10000);\r\n        System.out.format(Locale.UK,\"%,.2f%n\",Math.PI*10000);\r\n          \r\n    }\r\n}\r\n```\r\n输出结果：\r\n\r\n```java\r\n2020\r\n2020\r\n    2020\r\n2020    \r\n00002020\r\n20,200,000\r\n3.14159\r\n31?415,93\r\n31,415.93\r\n31,415.93\r\n```\r\n', '/images/pictures/2.jpg', '原创', '202', '1', '1', '1', '1', '1', '2019-03-12 13:42:14', '2019-03-13 12:00:08', '6', '1', 'JDK5.0允许java像C语言那样直接用printf()方法来格式化输出\r\nSystem.out.format()功能与printf()一样，可以使用%d,%f等参数。\r\n\r\n使用System.out.format()完成左对齐，补0，千位分隔符，小数点位数，本地化表达', '7');
INSERT INTO `t_blog` VALUES ('3', 'Springboot中PageHelper 分页查询使用方法', '### 一：导入依赖\r\n\r\n```java\r\n<dependency>\r\n	<groupId>com.github.pagehelper</groupId>\r\n	<artifactId>pagehelper-spring-boot-starter</artifactId>\r\n	<version>1.2.13</version>\r\n</dependency>\r\n```\r\n### 二：配置yml文件中PageHelper的属性\r\n\r\n```java\r\npagehelper:                #分页插件\r\n  helper-dialect: mysql\r\n  reasonable: true\r\n  support-methods-arguments: true\r\n  params:\r\n```\r\n### 三：在controller类中使用，\r\n##### 1.在查询方法上调用PageHelper.startPage()方法，设置分页的页数和每页信息数，\r\n##### 2.将查询出来的结果集用PageInfo的构造函数初始化为一个分页结果对象\r\n##### 3.将分页结果对象存入model，返回前端页面\r\n```java\r\n@GetMapping(\"/types\")\r\npublic String types(@RequestParam(required = false,defaultValue = \"1\",value = \"pagenum\")int pagenum, Model model){\r\n\r\n    PageHelper.startPage(pagenum, 5);  //pagenum：页数，pagesize:每页的信息数\r\n    \r\n    List<Type> allType = typeService.getAllType(); //调用业务层查询方法\r\n    \r\n    PageInfo<Type> pageInfo = new PageInfo<>(allType); //得到分页结果对象\r\n    \r\n    model.addAttribute(\"pageInfo\", pageInfo);  //携带分页结果信息\r\n    \r\n    return \"admin/types\";  //回到前端展示页面\r\n}\r\n```\r\n### 四：前端展示分页（thymeleaf+semantic-ui）,这里ui用自己的就行，比如bootstrap或layui，主要是thymeleaf的使用。\r\n\r\n```java\r\n<table  class=\"ui compact celled teal table\">\r\n  <thead>\r\n  <tr>\r\n    <th></th>\r\n    <th>名称</th>\r\n    <th>操作</th>\r\n  </tr>\r\n  </thead>\r\n  <tbody>\r\n  <tr th:each=\"type, iterStat : ${pageInfo.list}\">\r\n    <td th:text=\"${iterStat.count}\">1</td>\r\n    <td th:text=\"${type.name}\">摸鱼方法</td>\r\n    <td>\r\n      <a href=\"#\" th:href=\"@{/admin/types/{id}/input(id=${type.id})}\" class=\"ui mini teal basic button\">编辑</a>\r\n      <a href=\"#\" th:href=\"@{/admin/types/{id}/delete(id=${type.id})}\" class=\"ui mini red basic button\">删除</a>\r\n    </td>\r\n  </tr>\r\n  </tbody>\r\n  <tfoot>\r\n  <tr>\r\n    <th colspan=\"7\">\r\n      <div class=\"ui mini pagination menu\"  >\r\n        <div class=\"item\"><a th:href=\"@{/admin/types}\">首页</a></div>\r\n        <div class=\"item\"><a th:href=\"@{/admin/types(pagenum=${pageInfo.hasPreviousPage}?${pageInfo.prePage}:1)}\">上一页</a></div>\r\n        <div class=\"item\"><a th:href=\"@{/admin/types(pagenum=${pageInfo.hasNextPage}?${pageInfo.nextPage}:${pageInfo.pages})}\">下一页</a></div>\r\n        <div class=\"item\"><a th:href=\"@{/admin/types(pagenum=${pageInfo.pages})}\">尾页</a></div>\r\n      </div>\r\n      <a href=\"#\" th:href=\"@{/admin/types/input}\" class=\"ui mini right floated teal basic button\">新增</a>\r\n    </th>\r\n  </tr>\r\n  </tfoot>\r\n</table>\r\n\r\n<div class=\"ui segment m-inline-block\">\r\n  <p >当前第<span th:text=\"${pageInfo.pageNum}\"></span>页，总<span th:text=\"${pageInfo.pages}\"></span>页，共<span th:text=\"${pageInfo.total}\"></span>条记录</p>\r\n</div>\r\n```\r\n### 五：效果展示（pagesize设置为5的效果）\r\n![在这里插入图片描述](https://img-blog.csdnimg.cn/20200310105006168.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQyODA0NzM2,size_16,color_FFFFFF,t_70)\r\n', '/images/pictures/3.jpg', '原创', '47', '1', '0', '1', '1', '1', '2019-03-14 17:05:58', '2018-03-21 11:45:10', '1', '1', '1.在查询方法上调用PageHelper.startPage()方法，设置分页的页数和每页信息数，\r\n2.将查询出来的结果集用PageInfo的构造函数初始化为一个分页结果对象\r\n3.将分页结果对象存入model，返回前端页面', '5,4');
INSERT INTO `t_blog` VALUES ('4', 'thymeleaf语法及使用', '## 模板引擎\r\n\r\n简介：模板引擎(这里特指用于Web开发的模板引擎)是为了使用户界面与业务数据(内容)分离而产生的,它可以生成特定格式的文档，用于网站的模板引擎就会生成一个标准的HTML文档。\r\n模板引擎的思想：\r\n![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMDk1OTQxMTQucG5n?x-oss-process=image/format,png)\r\nThymeleaf就是SpringBoot给我们推荐的一种模板引擎！\r\n\r\n## Thymeleaf模板引擎\r\n\r\n#### 1.使用Thymeleaf之前的步骤\r\n\r\n 1. Thymeleaf 官网：https://www.thymeleaf.org/\r\n 2. springboot项目直接引入依赖：\r\n```java\r\n<dependency>\r\n   <groupId>org.springframework.boot</groupId>\r\n   <artifactId>spring-boot-starter-thymeleaf</artifactId>\r\n</dependency>\r\n```\r\n3.非springboot项目直接引入依赖：\r\n\r\n```java\r\n<dependency>\r\n    <groupId>org.thymeleaf</groupId>\r\n    <artifactId>thymeleaf</artifactId>\r\n    <version>2.1.4</version>\r\n</dependency>\r\n```\r\n  4.在thymeleaf的配置类ThymeleafProperties中我们可以发现：thymeleaf配置的默认前缀为：\"classpath:/templates/\"，默认后缀为：\".html\"，只要把html页面放在这个路径下，\r\n\r\nthymeleaf就可以帮我们自动渲染。\r\n\r\n```java\r\npublic class ThymeleafProperties {\r\n    private static final Charset DEFAULT_ENCODING;\r\n    public static final String DEFAULT_PREFIX = \"classpath:/templates/\";\r\n    public static final String DEFAULT_SUFFIX = \".html\";\r\n    private boolean checkTemplate = true;\r\n    private boolean checkTemplateLocation = true;\r\n    private String prefix = \"classpath:/templates/\";\r\n    private String suffix = \".html\";\r\n    private String mode = \"HTML\";\r\n...\r\n}\r\n```\r\n如图为用idea创建的springboot的项目结构：将html页面放在resources/templates中即可。\r\n![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMDk1OTExMTMucG5n?x-oss-process=image/format,png)\r\n#### 2.Thymeleaf语法简单使用（th:text, th:utext, th:each）\r\n编写一个controller实现跳转到一个html页面，通过Model对象携带数据\r\n\r\n```java\r\n@Controller\r\npublic class HelloController {\r\n\r\n    @RequestMapping(\"/success\")\r\n    public String success(Model model){\r\n        //存入数据\r\n        model.addAttribute(\"msg\",\"<h1>Hello</h1>\");\r\n        model.addAttribute(\"users\", Arrays.asList(\"小红\", \"小米\",\"小白\"));\r\n        //classpath:/templates/success.html\r\n        return \"success\";\r\n    }\r\n}\r\n```\r\nsuccess.html\r\n\r\n```java\r\n<!DOCTYPE html>\r\n<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\r\n<head>\r\n    <meta charset=\"UTF-8\">\r\n    <title>Title</title>\r\n</head>\r\n<body>\r\n    <h1>success</h1>\r\n\r\n    <!--Thymeleaf语法：th:text就是将div中的内容设置为它指定的值-->\r\n\r\n    <div th:text=\"${msg}\">你好</div>\r\n    <!--utext：会解析html，显示相应的效果-->\r\n    <div th:utext=\"${msg}\">你好</div>\r\n    <!--each：遍历-->\r\n    <h3 th:each=\"user:${users}\" th:text=\"${user}\"></h3>\r\n\r\n</body>\r\n</html>\r\n```\r\n通过http://localhost:8080/success路径访问到success.html页面，同时成功显示数据：![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMTEyOTE3MTUucG5n?x-oss-process=image/format,png)\r\n#### 3.Thymeleaf基本语法（属性和表达式）\r\n**Thymeleaf标准表达式**\r\n   \r\n\r\n 1. 变量表达式：**${ }**：用于前端获取后端传递的变量值\r\n\r\n   \r\n\r\n 1. 选择表达式：***{ }**：用于绑定一个对象的属性\r\n\r\n   \r\n\r\n 1. URL链接表达式：**@{ }**：用于链接\r\n\r\n    \r\n\r\n 1. 条件表达式：**三目运算符（表达式 ？值（then）：值（else））**\r\n\r\n    \r\n\r\n\r\n    \r\n**Thymeleaf属性标签：**\r\n![在这里插入图片描述](https://imgconvert.csdnimg.cn/aHR0cHM6Ly9pbWFnZXMuY25ibG9ncy5jb20vY25ibG9nc19jb20venltMTk5OS8xNjQ1NDE2L29fMjAwMjExMTEzMTAxMTYucG5n?x-oss-process=image/format,png)\r\n\r\n \r\n\r\n', '/images/pictures/4.jpg', '原创', '66', '1', '1', '1', '1', '1', '2020-03-14 17:01:31', '2018-03-14 17:01:31', '1', '1', '简介：模板引擎(这里特指用于Web开发的模板引擎)是为了使用户界面与业务数据(内容)分离而产生的,它可以生成特定格式的文档，用于网站的模板引擎就会生成一个标准的HTML文档。Thymeleaf就是SpringBoot给我们推荐的一种模板引擎！', '5,3');
INSERT INTO `t_blog` VALUES ('5', '利用Set集合去重', '### Set集合特点:\r\n#### ①     一次只存一个元素,\r\n\r\n#### ②     不能存储重复的元素\r\n\r\n#### ③     存储顺序和取出来的顺序不一定一致不能存储重复的元素\r\n\r\n可以利用②这一特点，完成去重的功能。\r\n#### 一：Set集合去掉List集合中重复元素\r\n\r\n```java\r\npublic static void main(String[] args) {\r\n	\r\n	//利用set集合 去除ArrayList集合中的重复元素\r\n	ArrayList<String> list = new ArrayList<>();\r\n	list.add(\"1\");\r\n    list.add(\"1\");\r\n    list.add(\"2\");\r\n    list.add(\"2\");\r\n    list.add(\"3\");\r\n    list.add(\"3\");\r\n    list.add(\"4\");\r\n    list.add(\"4\");\r\n    System.out.println(\"去重前的List集合：\"+list);\r\n    \r\n	Set<String> set = new HashSet<>();\r\n	set.addAll(list);\r\n	System.out.println(\"Set集合：\"+set);\r\n	\r\n	list.clear();            // 清空原有元素 放入被list去重后的元素\r\n	list.addAll(set);\r\n	System.out.println(\"去重后的List集合：\"+list);\r\n}\r\n```\r\n运行结果：\r\n\r\n```java\r\n去重前的List集合：[1, 1, 2, 2, 3, 3, 4, 4]\r\nSet集合：[1, 2, 3, 4]\r\n去重后的List集合：[1, 2, 3, 4]\r\n```\r\n\r\n#### 二：Set集合去掉字符串中重复子串\r\n\r\n```java\r\npublic static void main(String[] args) {\r\n	String str = \"aaab\";\r\n	System.out.println(\"字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个\");\r\n	\r\n	Set<String> set = new HashSet<String>();\r\n	for (int step = 0; step <= str.length() - 1; step++) {\r\n		//扫描全部子串\r\n		for (int begin = 0, end = 1 + step; end <= str.length(); begin++, end++) {     \r\n			String kid = str.substring(begin, end);   //截取字符串子串\r\n			set.add(kid);			//将子串放入set集合，完成去重\r\n		}\r\n	}\r\n	System.out.println(\"去除重复子串后的全部子串有：\"+set.size()+\"个\");\r\n	System.out.println(\"分别是：\" + set);\r\n}\r\n```\r\n运行结果：\r\n```java\r\n字符串aaab 有非空子串a, b, aa, ab, aaa, aab, aaab，一共 7 个\r\n去除重复子串后的全部子串有：7个\r\n分别是：[aa, aaa, a, ab, b, aab, aaab]\r\n```\r\n\r\n', '/images/pictures/5.jpg', '原创', '88', '1', '1', '1', '1', '1', '2020-03-13 11:21:46', '2019-03-14 16:19:35', '1', '1', 'Set集合特点:\r\n① 一次只存一个元素,\r\n② 不能存储重复的元素\r\n③ 存储顺序和取出来的顺序不一定一致不能存储重复的元素', '6');
INSERT INTO `t_blog` VALUES ('6', 'mybatis根据日期查询、查询日期并返回', '### 方法：\r\n\r\n#### 1.查询日期，返回日期字符串\r\n```handlebars\r\n//查询所有博客对应的年份，返回一个集合\r\nList<String> findGroupYear();  \r\n```\r\n#### 2.根据日期查询\r\n```handlebars\r\n//根据年份查询博客信息\r\nList<Blog> findByYear(@Param(\"year\") String year);  \r\n```\r\n\r\n\r\n### mybatis映射:\r\n\r\n\r\n```java\r\n<select id=\"findGroupYear\" resultType=\"String\">\r\n    select DATE_FORMAT(b.update_time, \'%Y\') from t_blog b\r\n</select>\r\n\r\n\r\n<select id=\"findByYear\" resultType=\"Blog\">\r\n    select b.title, b.update_time, b.id, b.flag\r\n    from t_blog b\r\n    where DATE_FORMAT(b.update_time, \'%Y\') = #{year}\r\n</select>\r\n```\r\n\r\n## 总结：\r\n**DATE_FORMAT(date,format)：date表示日期，format表示显示的格式。**\r\n**该方法可以把date类型转换为String类型的字符串**\r\n', '/images/pictures/6.jpg', '原创', '99', '1', '1', '1', '1', '1', '2020-03-21 11:54:41', '2019-03-21 15:33:02', '5', '1', 'mybatis根据日期查询、查询日期并返回\r\n方法：\r\n1.查询日期，返回日期字符串', '4');
INSERT INTO `t_blog` VALUES ('10', '蓝桥杯：基础练习 01字串（java）', '## 试题 基础练习 01字串\r\n  \r\n### 资源限制\r\n时间限制：1.0s   内存限制：256.0MB\r\n### 问题描述\r\n对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：\r\n\r\n00000\r\n\r\n00001\r\n\r\n00010\r\n\r\n00011\r\n\r\n00100\r\n\r\n请按从小到大的顺序输出这32种01串。\r\n\r\n### 输入格式\r\n本试题没有输入。\r\n### 输出格式\r\n输出32行，按从小到大的顺序每行一个长度为5的01串。\r\n### 样例输出\r\n00000\r\n00001\r\n00010\r\n00011\r\n<以下部分省略>\r\n\r\n#### 思路：\r\n**使用Integer.toBinaryString()将十进制整数转换为二进制字符串，再判断长度是否能整除5，在前面加0输出**\r\n\r\n```java\r\npublic class 字串01 {\r\n	public static void main(String[] args) {\r\n		\r\n		for(int i = 0; i <= 31; i++) {\r\n			String s = Integer.toBinaryString(i);\r\n			int len = s.length();\r\n			switch(len % 5) {\r\n			case 1: s = \"0000\" + s;break;\r\n			case 2: s = \"000\" + s;break;\r\n			case 3: s = \"00\" + s;break;\r\n			case 4: s = \"0\" + s;break;\r\n			case 0: break;\r\n			}\r\n			System.out.println(s);\r\n		}\r\n	}\r\n}\r\n```\r\n\r\n**另一种方法，不用判断加0，也可以直接使用printf输出指定格式的整数：**\r\n```java\r\npublic class 字串01 {\r\n	public static void main(String[] args) {\r\n		\r\n		for(int i = 0; i <= 31; i++) {\r\n			String s = Integer.toBinaryString(i);\r\n			int n = Integer.parseInt(s);\r\n			System.out.printf(\"%05d\\n\",n);\r\n		}\r\n	}\r\n}\r\n```\r\n\r\n', '/images/pictures/7.jpg', '原创', '301', '1', '1', '1', '1', '1', '2020-03-21 16:19:41', '2017-03-21 16:19:41', '6', '1', '问题描述\r\n\r\n对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：\r\n\r\n00000\r\n\r\n00001\r\n\r\n00010\r\n\r\n00011\r\n\r\n00100\r\n\r\n请按从小到大的顺序输出这32种01串。', '7');
INSERT INTO `t_blog` VALUES ('11', '安东尼经典语录', '我怕你说话，我怕你沉默。 \r\n我怕你来到，我怕你离开。 \r\n我怕抓紧你，我怕放走你。 \r\n我怕你看到我，我怕你无视我。 \r\n我怕你想念我，我怕你忘记我。 \r\n我怕你过于依赖我，我怕你不再需要我。 \r\n我怕你爱我，我怕你不爱我。 \r\n我怕你太爱我，我怕你不够爱我。\r\n\r\n不管昨夜经历了怎样的泣不成声 早晨醒来这个城市依然车水马龙\r\n\r\n不要让那个喜欢你的人 撕心裂肺地为你哭那么一次 因为 你能把他伤害到那个样子的机会 只有一次 那一次以后 你就从不可或缺的人变成可有可无的人了 即使他还爱你 可是 总有一些东西真的改变了\r\n\r\n应该趁着年轻 和喜欢的人一起 制造些比夏天还要温暖的事\r\n\r\n风不懂云的漂泊。天不懂雨的落魄。眼不懂泪的懦弱。所以你不懂我的选择。也可以不懂我的难过。不是每一个人都一定要快乐。不是每一种痛都一定要诉说\r\n\r\n后来，我终于能接受，我们不会再在一起这个实事。我想我唯一能做的就是，继承那些，你拥有的让我着迷的品质，好好地生活下去。\r\n\r\n如果你喜欢的人不喜欢你，那么就算全世界的人都喜欢你，还是会觉得孤独吧。If the person you like doesn\'t like you ,wouldn\'t it still be lonely even if the whole world loves you.\r\n\r\n那些 我们一直惴惴不安 又充满好奇的未来 会在心里隐隐约约地觉得它们是明亮的\r\n\r\n人生，总会有不期而遇的温暖，和生生不息的希望。\r\n\r\n其实我一直相信 等你出现的时候我就知道是你\r\n\r\n我谈过最长的恋爱，就是自恋，我爱自己，没有情敌。\r\n\r\n不知道如何爱你，看着你，是我唯一的方式。I don\'t know how to love you ,looking at you is the only way i know\r\n\r\n我所知道的关于你的事情 就只有天气预报了\r\n\r\n我觉得 我们俩之间就像喝酒 我干杯 你随意\r\n\r\n玫瑰当然爱小王子 \r\n不过当你真的喜欢一个人的时候 就会想很多 会很容易办蠢事 说傻话 \r\n更别说 那个人像小王子那么可爱 \r\n玫瑰很温柔 其实她只是不知所措罢了 \r\n至于小王子 他还太小了 不明白玫瑰的温柔 \r\n他的离开也许并不是坏事\r\n\r\n最喜欢早上，好像什么都可以重新开始，中午的时候就开始觉得忧伤，晚上最难度过。\r\n\r\nI know that one day I will forgot you. \r\nI don\'t have anticipation. \r\nI don\'t feel sad. \r\nI just know, that\'s all.\r\n\r\n长大了 总有那么一两次机会 你会为了喜欢的人 跑那么一跑 因为 如果是对的人的话 走路真的来不及\r\n\r\n很久以后，那些好极了和糟透了的时刻我们都会忘记，唯一真实和难忘的是，我们抬头挺胸走过的人生。\r\n\r\n不论是我的世界车水马龙繁华盛世 还是它们都瞬间消失化为须臾 我都会坚定地走向你 不慌张 不犹豫', '/images/pictures/8.jpg', '原创', '50', '1', '1', '1', '1', '1', '2020-03-22 19:36:45', '2020-03-22 19:36:45', '3', '1', '不论是我的世界车水马龙繁华盛世\r\n 还是它们都瞬间消失化为须臾 \r\n我都会坚定地走向你 不慌张 不犹豫', '8');
INSERT INTO `t_blog` VALUES ('13', 'MarkDown文档示例', '[TOC]\r\n\r\n> 注意下面每一个标记如果和内容同行，中间都加一个空格\r\n\r\n我是大标题，和一级标题长得一样\r\n===\r\n我是次级标题，和二级标题长得一样\r\n---\r\n\r\n# 这是一级标题\r\n## 这是二级标题\r\n###### 一直到六级标题\r\n\r\n# 列表\r\n- 无序写法1\r\n* 无序写法2\r\n+ 无序写法3\r\n    + 嵌套加一个Tab\r\n        + 再套一层\r\n            + 再来\r\n1. 有序列表只有这一种写法\r\n2. 数字加点\r\n\r\n# 表格\r\n| 字段1    | 字段2  | 字段3    |\r\n| ---------|:-----:|---------:|\r\n|内容      |内容    |内容      |\r\n|这列左对齐 |这列居中|这列右对齐 |\r\n\r\n# 分割线\r\n***\r\n---\r\n___\r\n* * *\r\n- - -\r\n_ _ _\r\n注意：如果用---要和前方空行防止被当成标题符号\r\n\r\n# 字体\r\n*斜体1*\r\n_斜体2_\r\n**粗体**\r\n__粗体2__\r\n***斜粗体***\r\n___斜粗体2___\r\n~~删除线~~\r\n\r\n# 超链接\r\n[百度](https://www.baidu.com\"百度一下，你就知道\")\r\n\r\n# 插入图片\r\n！[图片alt](https://baike.baidu.com/pic/Bliss/52106/0/0bd162d9f2d3572ccd5be1ec8913632762d0c341?fr=lemma&ct=single#aid=0&pic=0bd162d9f2d3572ccd5be1ec8913632762d0c341\"title\")\r\n\r\n# 引用\r\n> 引用内容\r\n>> 嵌套引用\r\n\r\n# 代码块\r\n`单行代码`\r\n    ```\r\n    代码块\r\n    ```', '/images/pictures/8.jpg', '原创', '0', '1', '1', '1', '1', '1', '2020-07-03 21:09:15', '2020-07-05 13:16:15', '4', '1', null, '3');
INSERT INTO `t_blog` VALUES ('21', 'Markdown使用', '# 欢迎使用Markdown编辑器写博客\r\n\r\n\r\n    本Markdown编辑器使用[StackEdit][6]修改而来，用它写博客，将会带来全新的体验哦：\r\n\r\n\r\n    - **Markdown和扩展Markdown简洁的语法**\r\n    - **代码块高亮**\r\n    - **图片链接和图片上传**\r\n    - ***LaTex*数学公式**\r\n    - **UML序列图和流程图**\r\n    - **离线写博客**\r\n    - **导入导出Markdown文件**\r\n    - **丰富的快捷键**\r\n\r\n\r\n    -------------------\r\n\r\n\r\n    ## 快捷键\r\n\r\n\r\n     - 加粗    `Ctrl + B` \r\n     - 斜体    `Ctrl + I` \r\n     - 引用    `Ctrl + Q`\r\n     - 插入链接    `Ctrl + L`\r\n     - 插入代码    `Ctrl + K`\r\n     - 插入图片    `Ctrl + G`\r\n     - 提升标题    `Ctrl + H`\r\n     - 有序列表    `Ctrl + O`\r\n     - 无序列表    `Ctrl + U`\r\n     - 横线    `Ctrl + R`\r\n     - 撤销    `Ctrl + Z`\r\n     - 重做    `Ctrl + Y`\r\n\r\n\r\n    ## Markdown及扩展\r\n\r\n\r\n    > Markdown 是一种轻量级标记语言，它允许人们使用易读易写的纯文本格式编写文档，然后转换成格式丰富的HTML页面。    —— <a href=\"https://zh.wikipedia.org/wiki/Markdown\" target=\"_blank\"> [ 维基百科 ]\r\n\r\n\r\n    使用简单的符号标识不同的标题，将某些文字标记为**粗体**或者*斜体*，创建一个[链接](http://www.csdn.net)等，详细语法参考帮助？。\r\n\r\n\r\n    本编辑器支持 **Markdown Extra** , 　扩展了很多好用的功能。具体请参考[Github][2].  \r\n\r\n\r\n    ### 表格\r\n\r\n\r\n    **Markdown　Extra**　表格语法：\r\n\r\n\r\n    项目     | 价格\r\n    -------- | ---\r\n    Computer | $1600\r\n    Phone    | $12\r\n    Pipe     | $1\r\n\r\n\r\n    可以使用冒号来定义对齐方式：\r\n\r\n\r\n    | 项目      |    价格 | 数量  |\r\n    | :-------- | --------:| :--: |\r\n    | Computer  | 1600 元 |  5   |\r\n    | Phone     |   12 元 |  12  |\r\n    | Pipe      |    1 元 | 234  |\r\n\r\n\r\n    ###定义列表\r\n\r\n\r\n    **Markdown　Extra**　定义列表语法：\r\n    项目１\r\n    项目２\r\n    :   定义 A\r\n    :   定义 B\r\n\r\n\r\n    项目３\r\n    :   定义 C\r\n\r\n\r\n    :   定义 D\r\n\r\n\r\n    > 定义D内容\r\n\r\n\r\n    ### 代码块\r\n    代码块语法遵循标准markdown代码，例如：\r\n    ``` python\r\n    @requires_authorization\r\n    def somefunc(param1=\'\', param2=0):\r\n        \'\'\'A docstring\'\'\'\r\n        if param1 > param2: # interesting\r\n            print \'Greater\'\r\n        return (param2 - param1 + 1) or None\r\n    class SomeClass:\r\n        pass\r\n    >>> message = \'\'\'interpreter\r\n    ... prompt\'\'\'\r\n    ```\r\n\r\n\r\n    ###脚注\r\n    生成一个脚注[^footnote].\r\n      [^footnote]: 这里是 **脚注** 的 *内容*，会显示在页面的最后。\r\n\r\n    ### 目录\r\n    用 `[TOC]`来生成目录：\r\n\r\n\r\n    [TOC]\r\n\r\n\r\n    ### 数学公式\r\n    使用MathJax渲染*LaTex* 数学公式，详见[math.stackexchange.com][1].\r\n\r\n\r\n     - 行内公式，数学公式为：$\\Gamma(n) = (n-1)!\\quad\\forall n\\in\\mathbb N$。\r\n     - 块级公式：\r\n\r\n\r\n    $$ x = \\dfrac{-b \\pm \\sqrt{b^2 - 4ac}}{2a} $$\r\n\r\n\r\n    更多LaTex语法请参考 [这儿][3].\r\n\r\n\r\n    ### UML 图:\r\n\r\n\r\n    可以渲染序列图：\r\n\r\n\r\n    ```sequence\r\n    张三->李四: 嘿，小四儿, 写博客了没?\r\n    Note right of 李四: 李四愣了一下，说：\r\n    李四-->张三: 忙得吐血，哪有时间写。\r\n    ```\r\n\r\n\r\n    或者流程图：\r\n\r\n\r\n    ```flow\r\n    st=>start: 开始\r\n    e=>end: 结束\r\n    op=>operation: 我的操作\r\n    cond=>condition: 确认？\r\n\r\n\r\n    st->op->cond\r\n    cond(yes)->e\r\n    cond(no)->op\r\n    ```\r\n\r\n\r\n    - 关于 **序列图** 语法，参考 [这儿][4],\r\n    - 关于 **流程图** 语法，参考 [这儿][5].\r\n\r\n\r\n    ## 离线写博客\r\n\r\n\r\n    即使用户在没有网络的情况下，也可以通过本编辑器离线写博客（直接在曾经使用过的浏览器中输入[write.blog.csdn.net/mdeditor](http://write.blog.csdn.net/mdeditor)即可。**Markdown编辑器**使用浏览器离线存储将内容保存在本地。\r\n\r\n\r\n    用户写博客的过程中，内容实时保存在浏览器缓存中，在用户关闭浏览器或者其它异常情况下，内容不会丢失。用户再次打开浏览器时，会显示上次用户正在编辑的没有发表的内容。\r\n\r\n\r\n    博客发表后，本地缓存将被删除。　\r\n\r\n\r\n    用户可以选择 <i class=\"icon-disk\"></i> 把正在写的博客保存到服务器草稿箱，即使换浏览器或者清除缓存，内容也不会丢失。\r\n\r\n\r\n    > **注意：**虽然浏览器存储大部分时候都比较可靠，但为了您的数据安全，在联网后，**请务必及时发表或者保存到服务器草稿箱**。\r\n\r\n\r\n    ##浏览器兼容\r\n\r\n\r\n     1. 目前，本编辑器对Chrome浏览器支持最为完整。建议大家使用较新版本的Chrome。\r\n     3. IE９以下不支持\r\n     4. IE９，１０，１１存在以下问题\r\n        1. 不支持离线功能\r\n        1. IE9不支持文件导入导出\r\n        1. IE10不支持拖拽文件导入', '/images/pictures/8.jpg', '转载', '0', '1', '1', '1', '1', '1', '2020-07-06 08:50:15', '2020-07-05 18:50:32', '4', '1', 'Markdown的简单使用规则', '3');

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag_id` bigint(20) DEFAULT NULL,
  `blog_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES ('1', '3', '4');
INSERT INTO `t_blog_tags` VALUES ('2', '4', '1');
INSERT INTO `t_blog_tags` VALUES ('3', '4', '3');
INSERT INTO `t_blog_tags` VALUES ('4', '5', '3');
INSERT INTO `t_blog_tags` VALUES ('5', '5', '4');
INSERT INTO `t_blog_tags` VALUES ('6', '7', '2');
INSERT INTO `t_blog_tags` VALUES ('7', '6', '5');
INSERT INTO `t_blog_tags` VALUES ('66', '4', '6');
INSERT INTO `t_blog_tags` VALUES ('74', '7', '10');
INSERT INTO `t_blog_tags` VALUES ('75', '8', '11');
INSERT INTO `t_blog_tags` VALUES ('76', '3', '13');
INSERT INTO `t_blog_tags` VALUES ('88', '3', '21');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  `admincomment` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('72', 'zc', 'zc@123.com', 'zc', '/images/avatar.png', '2020-07-06 13:57:26', '1', '-1', '0');
INSERT INTO `t_comment` VALUES ('73', 'zc1', 'zc1@123.com', 'zc1', '/images/avatar.png', '2020-07-06 13:59:15', '1', '72', '0');
INSERT INTO `t_comment` VALUES ('74', 'zc1', 'zc1@123.com', 'zc1', '/images/avatar.png', '2020-07-06 14:18:00', '1', '-1', '0');
INSERT INTO `t_comment` VALUES ('75', 'zc2', 'zc2@123.com', 'zc2', '/images/avatar.png', '2020-07-06 14:18:46', '1', '72', '0');
INSERT INTO `t_comment` VALUES ('76', 'zc3', 'zc3@123.com', '回复zc1的评论', '/images/avatar.png', '2020-07-06 14:57:35', '1', '73', '0');
INSERT INTO `t_comment` VALUES ('77', '小兰', 'xiaolan@163.com', 'hhh', '/images/avatar.png', '2020-07-06 15:26:10', '1', '74', '0');
INSERT INTO `t_comment` VALUES ('78', '小蓝', 'xiaolan@163.com', '我叫小蓝', '/images/avatar.png', '2020-07-06 15:26:33', '1', '77', '0');
INSERT INTO `t_comment` VALUES ('79', '测试', 'ee@163.com222', '这是一个测试', '/images/avatar.png', '2020-07-06 15:38:44', '1', '-1', '0');
INSERT INTO `t_comment` VALUES ('80', 'zc', 'zc@163.com', '我是管理员', '/images/me.jpg', '2020-07-06 15:59:47', '1', '-1', '1');
INSERT INTO `t_comment` VALUES ('81', 'zc', 'zc@123.com', '我来回复一下', '/images/me.jpg', '2020-07-06 16:00:05', '1', '79', '1');
INSERT INTO `t_comment` VALUES ('82', '小兰', 'ee@163.com222', '嘿嘿嘿', '/images/avatar.png', '2020-07-07 10:32:27', '2', '-1', '0');

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('3', '前端');
INSERT INTO `t_tag` VALUES ('4', '后端');
INSERT INTO `t_tag` VALUES ('5', 'springboot');
INSERT INTO `t_tag` VALUES ('6', 'java');
INSERT INTO `t_tag` VALUES ('7', 'javase');
INSERT INTO `t_tag` VALUES ('8', '杂谈');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('1', '学习方法');
INSERT INTO `t_type` VALUES ('2', '轻松一刻');
INSERT INTO `t_type` VALUES ('3', '生活日常');
INSERT INTO `t_type` VALUES ('4', '学习笔记');
INSERT INTO `t_type` VALUES ('5', '小结');
INSERT INTO `t_type` VALUES ('6', '学习技术');
INSERT INTO `t_type` VALUES ('10', '测试1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zc', 'zc', '202cb962ac59075b964b07152d234b70', 'zc@163.com', '/images/me.jpg', null, null, null);
