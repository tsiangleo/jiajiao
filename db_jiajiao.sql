/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.1.73-community : Database - db_jiajiao
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_jiajiao` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `db_jiajiao`;

/*Table structure for table `t_administrator` */

DROP TABLE IF EXISTS `t_administrator`;

CREATE TABLE `t_administrator` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  `role` varchar(256) DEFAULT NULL,
  `realname` varchar(256) DEFAULT NULL,
  `phone` varchar(256) DEFAULT NULL,
  `gender` varchar(256) DEFAULT NULL,
  `logintimes` int(11) DEFAULT '0',
  `blacklist` varchar(256) DEFAULT '否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_administrator` */

insert  into `t_administrator`(`id`,`username`,`password`,`role`,`realname`,`phone`,`gender`,`logintimes`,`blacklist`) values (5,'admin','21232f297a57a5a743894a0e4a801fc3','超级管理员','马化腾','18888888888','男',0,'否');

/*Table structure for table `t_adminlogging` */

DROP TABLE IF EXISTS `t_adminlogging`;

CREATE TABLE `t_adminlogging` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(256) DEFAULT NULL,
  `logintime` varchar(256) DEFAULT NULL,
  `loginip` varchar(256) DEFAULT NULL,
  `result` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

/*Data for the table `t_adminlogging` */

insert  into `t_adminlogging`(`id`,`username`,`logintime`,`loginip`,`result`) values (39,'admin','2017-06-01 22:21:51','0:0:0:0:0:0:0:1','登陆成功'),(40,'admin','2017-06-01 22:21:51','0:0:0:0:0:0:0:1','登陆成功'),(41,'admin','2017-06-01 22:24:06','0:0:0:0:0:0:0:1','登陆成功'),(42,'admin','2017-06-01 22:24:06','0:0:0:0:0:0:0:1','登陆成功'),(43,'admin','2017-06-01 22:26:05','0:0:0:0:0:0:0:1','登陆成功'),(44,'admin','2017-06-01 22:26:05','0:0:0:0:0:0:0:1','登陆成功');

/*Table structure for table `t_certificate` */

DROP TABLE IF EXISTS `t_certificate`;

CREATE TABLE `t_certificate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherid` bigint(20) NOT NULL,
  `idcard` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stucard` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `undergraduate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `graduate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cet4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cet6` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `tem8` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `cct` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `toefl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ielts` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_certificate` */

/*Table structure for table `t_collection` */

DROP TABLE IF EXISTS `t_collection`;

CREATE TABLE `t_collection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberid` bigint(20) NOT NULL,
  `teacherid` bigint(20) NOT NULL COMMENT '教员编号',
  `time` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_collection` */

insert  into `t_collection`(`id`,`memberid`,`teacherid`,`time`) values (3,46,42,'2014-04-11 14:44:45'),(5,46,40,'2014-04-11 19:21:31'),(6,55,42,'2014-04-11 21:14:54'),(8,60,43,'2014-04-14 22:06:13'),(9,60,41,'2014-04-14 22:06:19');

/*Table structure for table `t_evaluation` */

DROP TABLE IF EXISTS `t_evaluation`;

CREATE TABLE `t_evaluation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `teacherid` bigint(20) NOT NULL,
  `totalevaluation` varchar(256) DEFAULT NULL,
  `content` varchar(256) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL,
  `time` varchar(256) DEFAULT NULL,
  `reply` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_evaluation` */

insert  into `t_evaluation`(`id`,`teacherid`,`totalevaluation`,`content`,`author`,`time`,`reply`) values (1,40,'好评','sdf','xy111','2017-06-01 19:58:06',NULL);

/*Table structure for table `t_link` */

DROP TABLE IF EXISTS `t_link`;

CREATE TABLE `t_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '链接站点名称',
  `url` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '站点地址',
  `info` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_link` */

insert  into `t_link`(`id`,`name`,`url`,`info`) values (1,'百度','http://www.baidu.com','中文最大的搜索引擎。'),(2,'淘宝网','http://www.taobao.com','中国最大的C2C交易平台'),(5,'重庆邮电大学','http://www.cqupt.edu.cn','皇家邮电');

/*Table structure for table `t_member` */

DROP TABLE IF EXISTS `t_member`;

CREATE TABLE `t_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `balance` int(11) NOT NULL DEFAULT '50' COMMENT '账户余额，以前是积分（jifen）',
  `phone` varchar(255) COLLATE utf8_bin NOT NULL,
  `role` varchar(255) COLLATE utf8_bin NOT NULL,
  `registdate` varchar(255) COLLATE utf8_bin NOT NULL,
  `lasttime` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'NULL' COMMENT '降序排列',
  `lastip` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'NULL',
  `logintime` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'NULL',
  `loginip` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'NULL',
  `type` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '普通会员' COMMENT '2代表高级VIP会员，1代表标准VIP会员，0代表普通会员，降序排列',
  `searchrank` int(11) NOT NULL DEFAULT '0' COMMENT '会员排序设置，取值0~9，降序排列',
  `VIPdeadline` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT 'NULL' COMMENT 'VIP到期时间',
  `logintimes` int(11) NOT NULL DEFAULT '0' COMMENT '用户登陆次数',
  `registip` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '注册IP',
  `blacklist` varchar(2) COLLATE utf8_bin NOT NULL DEFAULT '否' COMMENT '是否为黑名单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_member` */

insert  into `t_member`(`id`,`username`,`password`,`email`,`balance`,`phone`,`role`,`registdate`,`lasttime`,`lastip`,`logintime`,`loginip`,`type`,`searchrank`,`VIPdeadline`,`logintimes`,`registip`,`blacklist`) values (46,'xueyuan','4297f44b13955235245b2497399d7a93','424321913@qq.com',63,'18716319111','学员','2014-04-09 21:14:21','2014-04-13 19:20:10','127.0.0.1','2014-04-13 19:21:22','127.0.0.1','高级VIP',9,'',0,'127.0.0.1','否'),(47,'jiaoyuan','e10adc3949ba59abbe56e057f20f883e','123@123.ccc',20,'18716319111','教员','2014-04-09 21:18:52','2014-04-17 17:51:19','127.0.0.1','2014-04-17 23:08:13','127.0.0.1','标准VIP',9,'',14,'127.0.0.1','否'),(48,'jiaoyuan2','4297f44b13955235245b2497399d7a93','12321@11.cc',20,'18716319111','教员','2014-04-09 21:26:31','2014-04-11 19:59:12','127.0.0.1','2014-04-17 16:57:18','127.0.0.1','高级VIP',0,'',1,'127.0.0.1','否'),(49,'jiaoyuan3','4297f44b13955235245b2497399d7a93','12321@11.cc',20,'18716319111','教员','2014-04-09 21:29:37','NULL','NULL','2014-04-09 22:24:39','127.0.0.1','标准VIP',1,'',0,'127.0.0.1','否'),(50,'jiaoyuan4','4297f44b13955235245b2497399d7a93','12321@11.cc',20,'18716319111','教员','2014-04-09 22:08:51','NULL','NULL','NULL','NULL','标准VIP',4,'',0,'127.0.0.1','否'),(51,'jiaoyuan5','4297f44b13955235245b2497399d7a93','424321913@qq.com',20,'18716319111','教员','2014-04-11 15:25:31','NULL','NULL','NULL','NULL','高级VIP',2,'',0,'127.0.0.1','否'),(53,'laoshi','4297f44b13955235245b2497399d7a93','424321913@qq.com',20,'18716319111','教员','2014-04-11 20:10:20','NULL','NULL','2014-04-11 20:11:05','127.0.0.1','高级VIP',0,'',0,'127.0.0.1','否'),(54,'jiaoshi2','4297f44b13955235245b2497399d7a93','123123@ww.com',20,'123123123123','教员','2014-04-11 20:13:11','NULL','NULL','NULL','NULL','标准VIP',0,'',0,'127.0.0.1','否'),(55,'xueyuan2','4297f44b13955235245b2497399d7a93','12321@11.cc',20,'18716319111','学员','2014-04-11 20:25:52','NULL','NULL','2014-04-11 20:26:19','127.0.0.1','标准VIP',0,'',0,'127.0.0.1','否'),(56,'xueyuan9','4297f44b13955235245b2497399d7a93','123124@11.cc',20,'123123','学员','2014-04-12 12:47:42','NULL','NULL','NULL','NULL','普通会员',0,'',0,'127.0.0.1','否'),(57,'jiaoyuan9','4297f44b13955235245b2497399d7a93','123124@11.cc',20,'123123','教员','2014-04-12 12:49:38','2014-04-12 12:55:54','127.0.0.1','2014-04-12 12:56:55','127.0.0.1','普通会员',0,'',0,'127.0.0.1','否'),(58,'xueyuan8','4297f44b13955235245b2497399d7a93','123124@11.cc',20,'16611231231','学员','2014-04-12 13:48:09','2014-04-12 13:49:09','127.0.0.1','2014-04-12 13:49:52','127.0.0.1','普通会员',0,'',0,'127.0.0.1','否'),(59,'xstest','e10adc3949ba59abbe56e057f20f883e','123123@1231.qwe',20,'123123123123','教员','2014-04-14 21:53:54','NULL','NULL','2014-04-17 16:55:37','127.0.0.1','普通会员',0,'NULL',1,'127.0.0.1','否'),(60,'xstest2','4297f44b13955235245b2497399d7a93','123123@qwe.ccc',20,'123123123123','学员','2014-04-14 21:55:27','2014-04-14 22:07:06','127.0.0.1','2014-04-14 22:07:30','127.0.0.1','普通会员',0,'NULL',2,'127.0.0.1','否'),(61,'lstest','4297f44b13955235245b2497399d7a93','123123@12312.cc',20,'123123123123','教员','2014-04-14 22:08:05','NULL','NULL','NULL','NULL','普通会员',0,'NULL',0,'127.0.0.1','否'),(62,'lstest2','4297f44b13955235245b2497399d7a93','123123@12312.cc3',20,'123123123123','教员','2014-04-14 22:09:16','NULL','NULL','NULL','NULL','普通会员',0,'NULL',0,'127.0.0.1','否'),(63,'123123','4297f44b13955235245b2497399d7a93','123123@123.cc',50,'12312312312','教员','2017-06-01 17:16:23','NULL','NULL','NULL','NULL','普通会员',0,'NULL',0,'0:0:0:0:0:0:0:1','否'),(64,'qqqq','3bad6af0fa4b8b330d162e19938ee981','qqq@qq.xx',50,'18777716543','教员','2017-06-01 18:20:14','2017-06-01 18:27:26','0:0:0:0:0:0:0:1','2017-06-01 18:27:26','0:0:0:0:0:0:0:1','普通会员',0,'NULL',2,'0:0:0:0:0:0:0:1','否'),(65,'xy111','e10adc3949ba59abbe56e057f20f883e','1111@cc.com',40,'18200667654','学员','2017-06-01 19:57:28','NULL','NULL','NULL','NULL','普通会员',0,'NULL',0,'0:0:0:0:0:0:0:1','否');

/*Table structure for table `t_membertype` */

DROP TABLE IF EXISTS `t_membertype`;

CREATE TABLE `t_membertype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员组',
  `typename` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '会员组名字，',
  `sort` int(11) NOT NULL COMMENT '2代表高级VIP会员，1代表标准VIP会员，0代表普通会员，降序排列',
  `moneypt` int(11) NOT NULL COMMENT '每次查看消耗的积分',
  `discount` float NOT NULL COMMENT '账户充值时的折扣',
  `expense` int(11) NOT NULL COMMENT '购买会员所需费用',
  `validperiod` int(11) NOT NULL COMMENT '会员有效期（单位：天）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_membertype` */

insert  into `t_membertype`(`id`,`typename`,`sort`,`moneypt`,`discount`,`expense`,`validperiod`) values (1,'普通会员',23,5,0.03,4,3600123),(2,'标准VIP',2,3,0.9,40,20),(4,'高级VIP',1,2,0.8,60,20);

/*Table structure for table `t_news` */

DROP TABLE IF EXISTS `t_news`;

CREATE TABLE `t_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `content` mediumtext COLLATE utf8_bin NOT NULL,
  `source` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '来源',
  `type` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '新闻类型',
  `publishtime` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '发布时间',
  `click` int(11) NOT NULL DEFAULT '0' COMMENT '点击',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_news` */

insert  into `t_news`(`id`,`title`,`content`,`source`,`type`,`publishtime`,`click`) values (1,'习近平会见澳大利亚总理 老挝总理 缅甸议长','<p>\r\n	海外网4月11日综合 中国国家主席习近平11日在人民大会堂会见澳大利亚总理阿博特。<br />\r\n	<br />\r\n	习近平感谢澳方为中方参与搜寻马来西亚航空公司失联客机提供的支持和协助，表示中方将继续全力参与搜寻，并同澳方保持密切沟通与合作。<br />\r\n	<br />\r\n	阿博特通报了澳方搜寻工作进展情况，表示中方是最早派舰船参与南线海域搜寻的国家。澳方对中方给予的及时协助表示感谢，并愿继续同中方加强沟通与配合。<br />\r\n	<br />\r\n	习近平表示，你这次率庞大代表团访华，体现了澳大利亚政府及各州区、各界对发展中澳关系的重视和诚意。中澳两国都是亚太地区重要国家，拥有广泛而重要的共 同利益，合作潜力巨大。中方愿意同澳方一道，推动中澳战略伙伴关系持续向前发展。双方要保持密切高层交往和各级别沟通对话，增进政治互信，加快双边自由贸 易协定谈判，希望澳方为中国企业在澳投资经营提供良好条件。双方还要推进两军、打击跨国犯罪、人文等领域交流与合作，加强在多边领域协调与配合，共同应对 气候变化、网络安全等全球性挑战。今年两国将分别主办亚太经合组织领导人非正式会议和二十国集团领导人峰会，双方应该继续相互支持，确保两场会议取得积极 成果。<br />\r\n	<br />\r\n	阿博特表示，中国的发展对澳大利亚、对地区和世界都是机遇。澳大利亚愿意做中国可信赖的长期合作伙伴。访问中国是我这次东北亚之行的重中之重，也是访问的 高潮，目的是加强澳中战略伙伴关系，这有利于维护亚太地区和平与稳定。随同我来访的有澳大利亚多名部长、州长和大批企业家，这充分表明澳方对加强对华合作 的强烈愿望。澳方愿与中方加快两国自贸协定谈判，欢迎中国企业赴澳投资兴业，希望加强两国金融、教育、科技、文化、旅游等领域合作，促进民间交往。我欢迎 习近平主席今年赴澳出席二十国集团领导人峰会并访问澳大利亚，我也期待再次来华出席亚太经合组织领导人非正式会议。<br />\r\n	<br />\r\n	<strong>会见老挝总理</strong><br />\r\n	<br />\r\n	中国国家主席习近平11日在北京会见老挝总理通邢。<br />\r\n	<br />\r\n	习近平指出，中老友谊千金难换，弥足珍贵。当前，国际和地区形势深刻复杂演变，中老两国都进入改革和发展新阶段，要加强团结合作，永做好邻居、好朋友、好 同志、好伙伴，推动中老全面战略合作伙伴关系不断迈上新台阶。双方要保持两党两国高层交往传统，加强战略沟通和协调，交流互鉴治国理政经验，扩大人文交 流，拓展能源资源、生态旅游、基础设施建设等领域合作，争取尽早签署中老铁路合作协议。<br />\r\n	<br />\r\n	习近平强调，建设社会主义事业，必须处理改革发展稳定三者关系。相信老挝通过革新开放，一定会实现国家发展的目标。中方愿继续提供力所能及的帮助。<br />\r\n	<br />\r\n	通邢表示，老方感谢中方长期以来提供的宝贵支持和帮助。加强老中全面战略合作伙伴关系对老挝国内建设事业具有重要意义。老方愿认真落实两国元首达成的重要 共识，加强各领域合作，尤其是积极推进老中铁路项目。老方高度赞赏并愿积极参与中方提出的构建丝绸之路经济带和21世纪海上丝绸之路倡议。<br />\r\n	<br />\r\n	<strong>会见缅甸联邦议会议长吴瑞曼</strong><br />\r\n	<br />\r\n	国家主席习近平11日在人民大会堂会见缅甸联邦议会议长兼人民院议长吴瑞曼。<br />\r\n	<br />\r\n	习近平说，中缅是山水相连的友好邻邦，两国人民世代以&ldquo;胞波&rdquo;相称。坚持发展中缅睦邻友好合作，符合彼此根本利益。在当前国际和地区形势发生深刻复杂变化 的大背景下，双方要坚持从战略高度和长远角度出发，坚定推进中缅全面战略合作的决心，不断增进政治互信，深化各领域务实合作。中方支持缅甸作为东盟轮值主 席国在地区和国际舞台发挥更大作用，愿同缅方保持协调配合，共同推进中国－东盟合作。<br />\r\n	<br />\r\n	习近平说，中国正在进行全面深化改革，缅甸也在积极推动改革、发展经济，双方应进一步加强经济合作与经验交流，造福两国和两国人民。<br />\r\n	<br />\r\n	在谈到党际交往时，习近平说，议长先生还担任缅甸联邦巩固与发展党的主席，中国共产党愿同缅甸联邦巩固与发展党加强交往，深化治党理政经验交流，推进干部培训合作，促进两党各自执政能力建设。<br />\r\n	<br />\r\n	吴瑞曼表示，缅方高度重视建立在和平共处五项原则基础上的缅中友好关系，感谢中方在国际社会为缅仗义执言，在缅经济社会发展中提供帮助。中国的成功发展是 缅甸的重要机遇。缅政府和议会高度赞赏中国正在进行全面深化改革，愿学习借鉴中国经济社会发展经验，促进缅中友好关系深入发展。<br />\r\n	<br />\r\n	全国人大常委会副委员长兼秘书长王晨参加会见。（综合中新网 新华网 国际在线）<br />\r\n	<br />\r\n	&nbsp;</p>\r\n','海外网','高考资讯','2014-04-13 13:53:58',37),(3,'今年北京市8.9万人报名中考 同比减3700余人','<p>\r\n	　昨天，记者从北京教育考试院了解到，今年北京市中考报名确认考生人数达8.9万，比去年减少3700余人。其中，名额分配资格审核合格的考生约6.7万人。</p>\r\n<p>\r\n	　　中招办相关负责人介绍，在报名考生中，京籍考生6.9万人，非京籍考生2万人；应届生8.8万人，往届生1000余人。据统计，名额分配资格审核合格的考生约6.7万人。</p>\r\n<p>\r\n	　　今年本市各类高级中等学校共计划招生8.6万人。其中，普通高中招收约5.24万人，职业教育类招收约3.36万人，普职比继续稳定在6∶4。中等职 业教育招生规模中，五年制高等职业教育招收0.5万人，普通中等专业学校招收1.4万人，职业高中招收0.7万人，技工学校招收0.76万人。(记者李 琦)</p>\r\n<p class=\"tp07 tp06\">\r\n	(责编：黄达)</p>\r\n','京华时报','中考资讯','2014-04-13 15:10:06',2),(5,'小学试点“全课程” 两老师“包”下一个班','<p>\r\n	数学不够好，常被说&ldquo;数学是体育老师教的&rdquo;。以后这句话可能不再是嘲笑，而是时髦了。因为常州有好几所小学，一年级学生的数学就真是体育老师教的。 常州市天宁区5所小学整体实行&ldquo;全课程&rdquo;改革，教材不再是每个学科一本书，而是将不同的课程融合在一本教材里。两名老师&ldquo;包班&rdquo;，对课时进行有效分配，以 达到最好的效果。</p>\r\n<p>\r\n	　　这种看起来非常新潮的教学方式已实施了半年，对此，孩子们很接受：&ldquo;学校很好玩，上课跟做游戏一样&rdquo;、&ldquo;很喜欢上学，不仅能学到东西，还能表演，每周 一还能跟大家&lsquo;讲故事&rsquo;&rdquo;。但家长们却有些担心和疑问，不知道体育老师教数学课，孩子能学到多少东西？跨学科教学会不会误人子弟？家长还担心，长期下去会 不会基础不牢？校方称，老师培训多次已能驾驭。而且包班教学主要应用于低年级，中高年级的各学科依旧将由专业老师进行教授。常州市天宁区教育文体局副局长 表示，&ldquo;全课程&rdquo;不是简单的学科叠加，也不是消解学科本质，更不是放弃知识学习。&ldquo;这种课程结构的改变，跨学科学习，不仅学习内容极大拓展，学习方式也更 加丰富，可以认为是一种&lsquo;全人&rsquo;的教育。&rdquo;</p>\r\n<p>\r\n	　　据扬子晚报</p>\r\n<p>\r\n	　　<strong>网评</strong></p>\r\n<p>\r\n	　　@浮生未歇246651：&ldquo;数学是体育老师教的&rdquo;终于成真。</p>\r\n<p>\r\n	　　@孤叶：可喜的尝试！</p>\r\n<p>\r\n	　　@夏日的风暴1834：惊喜和赞扬，全学科教育更加关注人的发展，这是教育理念的跨越。</p>\r\n<p>\r\n	　　@溪筠：支持！小学就那点东西，完全可以糅在一起，用一种更自然的方法教授。</p>\r\n<p>\r\n	　　@东出阳关道：改革是需要勇气的，常州的小学勇气可嘉！但教学改革事关孩子的未来，还是要多方论证，谨慎一点为好！</p>\r\n<p>\r\n	　　@发拂霜：不合适，要是不喜欢某个老师，而他却包下了大部分的课程，学生时时面对的都是自己不喜欢的人，不是很痛苦的一件事情吗？</p>\r\n<p>\r\n	　　@旧人归：有些老师确实是全才，不能一概而论，但在选择老师时总得斟酌一番吧。</p>\r\n<p>\r\n	　　@留住你：小学改了，初中高中不改，高考不改，你让这群孩子怎么办？</p>\r\n<p>\r\n	　　@氧气：是否可喜要看尝试的成本有多高，付出的代价有多大，收益有多高，对这个事不要过早下结论。</p>\r\n<p>\r\n	　　@粮民没品：铁打的学校，流水的学生。请对得起学生。</p>\r\n<p>\r\n	　　@锦绣中华：教学本就是专业性很强的技术活，让老师什么都教，你说这哪是教学，简直就是误人子弟！</p>\r\n<p>\r\n	　　@情自阑珊：如果失败了，孩子的一生就会有不同的发展轨迹了。</p>\r\n<p class=\"tp07 tp06\">\r\n	(责编：肖静阳)</p>\r\n','北京晚报','专家辅导','2014-04-13 15:11:23',5),(6,'应届大学毕业生期望薪水更趋理性','<p>\r\n	&nbsp;</p>\r\n<p style=\"margin: 1em 0px; padding: 0px; border: 0px; outline: 0px; font-family: 宋体; font-size: 16px; vertical-align: baseline; list-style-type: none; color: rgb(0, 0, 0); line-height: 28px; widows: 2; orphans: 2;\">\r\n	湖北省2013年新春大型人才招聘会上周日在华科体育馆举办，282家企业提供2万余个岗位，近3万人入场求职。记者现场调查发现，六成<span name=\"HL_TAG\" style=\"margin: 0px; padding: 0px; border-width: 0px; border-bottom-style: dotted; outline: 0px; font-style: inherit; font-family: inherit; vertical-align: baseline; list-style-type: none; color: rgb(0, 132, 216); text-decoration: underline;\">应届毕业生</span>期望月薪接近职场实际情况，求职者就业观念更为理性。</p>\r\n<p style=\"margin: 1em 0px; padding: 0px; border: 0px; outline: 0px; font-family: 宋体; font-size: 16px; vertical-align: baseline; list-style-type: none; color: rgb(0, 0, 0); line-height: 28px; widows: 2; orphans: 2;\">\r\n	　　记者现场调查发现，40名应届本科毕业生中，有24名的期望<span name=\"HL_TAG\" style=\"margin: 0px; padding: 0px; border-width: 0px; border-bottom-style: dotted; outline: 0px; font-style: inherit; font-family: inherit; vertical-align: baseline; list-style-type: none; color: rgb(0, 132, 216); text-decoration: underline;\">月薪</span>在2000&mdash;2500元之间，七成学子与本地企业提供的月薪基本一致。</p>\r\n<p style=\"margin: 1em 0px; padding: 0px; border: 0px; outline: 0px; font-family: 宋体; font-size: 16px; vertical-align: baseline; list-style-type: none; color: rgb(0, 0, 0); line-height: 28px; widows: 2; orphans: 2;\">\r\n	　　武汉工业学院药学专业的应届毕业生<span name=\"HL_TAG\" style=\"margin: 0px; padding: 0px; border-width: 0px; border-bottom-style: dotted; outline: 0px; font-style: inherit; font-family: inherit; vertical-align: baseline; list-style-type: none; color: rgb(0, 132, 216); text-decoration: underline;\">杨桂芳</span>说，基于武汉的消费水平，2000元的月薪才能在武汉养活自己。昨天（12日），她在现场逛了一圈，发现专业对口的工作提供的待遇也大多在2000元。武汉一家公司的招聘负责人说，企业不愿意为应届毕业生提供较高的月薪，主要是考虑毕业生刚参加工作，主要以学习为主，而且企业培养他们，也承担一定的风险。</p>\r\n<p style=\"margin: 1em 0px; padding: 0px; border: 0px; outline: 0px; font-family: 宋体; font-size: 16px; vertical-align: baseline; list-style-type: none; color: rgb(0, 0, 0); line-height: 28px; widows: 2; orphans: 2;\">\r\n	　　湖北省人才市场负责人介绍，毕业生期望月薪与企业提供的实际月薪多数达成一致，表明求职者在求职中能根据实际情况理性求职，不管对求职者还是企业都是一件好事。</p>\r\n','','高考资讯','2014-04-13 17:12:37',6),(7,'“聪明大脑”缘何不尚体验','“中国孩子接受教育的时间很长，而且都很聪明、知识也非常渊博，但奇怪的是，很多中国孩子比较缺乏最基本的生命安全、生存和生活能力，他们对于图片上说的、文字上写的各种知识都能做到烂熟于心，但就是不会动手去做。这对孩子成长的隐性伤害是不可逆的！”德国体验教育的泰斗级人物、德国基尔应用技术大学原校长彼得·乔恒生教授近日在北京举行的首届中德体验教育中国青少年成长教育辅导员师资班上说。\r\n\r\n　　95%的大脑潜能等待体验教育“唤醒”\r\n\r\n　　彼得·乔恒生多年频繁往返于中国与德国之间，从事体验教育研究的这些“独特观察”，给当下的中国教育提出了预警。\r\n\r\n　　清华大学—伯克利心理学研究中心特聘教授陈绍建认为：“一个人在某类知识获得和能力形成过程中往往离不开身、心、脑的协同训练。由于右脑是左脑功能的100万倍，所以现在很多人关注右脑开发，而目前每个人的大脑只开发了4%左右，还有95%以上的空间没有被开发，特别是右脑的很多潜能根本没有被唤醒，处于‘沉睡’状态，需要体验来唤醒、激活这些大脑潜能。”\r\n\r\n　　“我们闭上眼睛能迅速想起来的事情往往都是那些带有某种情感、情绪的场景。为什么这些场景令人印象深刻且一辈子难忘？原因就在于它有身、心、脑的参与，有我们的身体体验和内心体验。”在日前北京举行的2015第三届青少年情智教育峰会上，心目教育创始人陶子欧说，“这些在实践、行为、场景中的体验首先能刺激大脑神经元，留下图像和场景，然后进入右脑记忆；其次是影响身体，在做一件具体事情时，是什么样的身体行为参与此事，这些感受、肢体语言都将进入潜意识。再其次，体验会渗透心灵、触动情感，当时是恐惧、紧张，还是高兴，所有情感都会向大脑植入一个‘情绪密码’。最终，每种体验会从身、心、脑三个方面深入到我们整个人体当中，留下深刻印记。”\r\n\r\n　　体验教育“缺席”导致学生学而无以致用\r\n\r\n　　“我们在全世界很多国家开展各种各样的体验教育研究时发现，中国孩子和许多其他国家的孩子相比，有一些特异性。比如，野外生存等体验课，如果在教室上，中国孩子能把野外生存演得非常好。但如果搬到野外，其他国家的孩子大都是一个人背着包，说走就走；而中国孩子普遍是成群结队地去，而且家长要求组织方提供视频看孩子在干什么、吃什么、穿什么和住在哪儿。”彼得·乔恒生说。\r\n\r\n　　“体验教育的缺席，使中国孩子的许多学习探索只停留在书本上，难以学以致用。”陶子欧介绍，在德国的一些中小学，学校都设有木工坊，在那里，孩子们可以用各种工具制作自己想做的各种木件模型，在这个过程中，学校将课堂知识通过学生体验的方式教给学生。\r\n\r\n　　与德国中小学将教育和体验完美融合的做法相似，挪威教育界有一个非常有名的体验教育项目。这个项目就是把孩子带到零下25摄氏度的冰天雪地住一个月甚至更长时间，陪伴他们生活的是几只雪橇狗，孩子们得自己做饭、想办法御寒、想办法找吃的。挪威教育界通过这种真刀真枪的体验教育，培养和引导孩子们适应不同环境的生存和生活能力。\r\n\r\n　　体验与教育融合是孩子快乐成长的密码\r\n\r\n　　事实上，体验与教育的融合是青少年快乐成长的“情绪密码”。中国科学院心理学博士韩海英有在北京安定医院精神科10年从医经历，每当看到青少年甚至比青少年更小的孩子来医院看病时，她的心情都非常沉重：尤其在与病人一起回顾他们的童年时，她发现，之所以后来遭受心理疾病，基本都源于小时候畸形的家庭养育方式和家庭氛围。“所以当成年人有问题来做心理咨询时，帮助他们的过程难度很大，因为一个人从小长到大很多固有模式已经形成，只能微调。”\r\n　　\r\n　　通过体验教育可以发现和捕捉到青少年在不同成长阶段的情绪变化密码，并借助体验教育获得情绪的释放，过滤掉日常学习生活中的各种紧张情绪，使心情得以平复。“身、心、脑参与的各种体验活动，既是教育的内在规律，也是孩子健康成长的秘密，它能缓解青少年成长中出现的许多情绪问题。”韩海英说。\r\n\r\n　　日本在体验教育方面的探索对于中国有所启发。在日本，几乎每所学校都有自己的体验教育活动，并在课程设置中占了很大比例，其内容和形式多种多样，包括仪式性活动、文化活动、促进身心健康的安全体育活动、接近自然和文化来增强公众道德的旅行活动、集体住宿活动等。\r\n\r\n　　“日本通过这些体验活动，发展学生的个性，培养丰富的人格，使学生适应班级和学校生活，并且加深学生作为集体或社会一员的认识、增强其责任感以及良好人际关系建立。”彼得·乔恒生介绍，在中国，“我们目前正准备在中国推出心目少年商学院青少年EMBA项目（德商、情商、健商）实验，以寻找适应中国青少年身心成长实际的体验教育方式，希望未来中国孩子在成长过程中更尚体验。”\r\n','家教网','中考资讯','2017-06-01 22:24:47',2),(9,'练后反思的习惯','　在读书和学习过程中，尤其是复习备考过程中，每个同学都进行过强度较大的练习，但做完题目并非大功告成，重要的在于将知识引申、扩展、深化，因此，反思是解题之后的重要环节。一般说来，习题做完之后，要从五个层次反思：\r\n\r\n　　1、怎样做出来的？想解题采用的方法；\r\n\r\n　　2、为什么这样做？想解题依据的原理；\r\n\r\n　　3、为什么想到这种方法？想解题的思路；\r\n\r\n　　4、有无其它方法？哪种方法更好？想多种途径，培养求异思维；\r\n\r\n　　5、能否变通一下而变成另一习题？想一题多变，促使思维发散。当然，如果发生错解，更应进行反思：错解根源是什么？解答同类试题应注意哪些事项？如何克服常犯错误？“吃一堑，长一智”，不断完善自己。\r\n\r\n　　应当培养的优良习惯还有许多，诸如有疑必问的习惯，有错必改的习惯，动手实验习惯，查找工具书的习惯，健康上网、积极探究的习惯等等。从课堂学习的过程看，还有认真预习、专心听课、及时复习、独立完成作业、积极应考等好习惯。\r\n\r\n　　为学之道，必本于思。思则得知，不思则不得也。——晃说之','互联网','专家辅导','2017-06-01 22:26:34',0);

/*Table structure for table `t_newstype` */

DROP TABLE IF EXISTS `t_newstype`;

CREATE TABLE `t_newstype` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `newsType` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_newstype` */

insert  into `t_newstype`(`id`,`newsType`) values (2,'中考资讯'),(4,'专家辅导'),(5,'高考资讯');

/*Table structure for table `t_notice` */

DROP TABLE IF EXISTS `t_notice`;

CREATE TABLE `t_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '公告标题',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '公告内容',
  `publishtime` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_notice` */

insert  into `t_notice`(`id`,`title`,`content`,`publishtime`) values (2,'系统测试开始啦','<p>\r\n	是的，\r\n就这么开始啦。</p>\r\n','2014-04-13 21:13:07'),(4,'关于会员金币制度的说明','<p>测试测试</p>\r\n','2014-04-13 21:34:51');

/*Table structure for table `t_requirement` */

DROP TABLE IF EXISTS `t_requirement`;

CREATE TABLE `t_requirement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberid` bigint(20) NOT NULL,
  `studentname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stugender` varchar(255) COLLATE utf8_bin NOT NULL,
  `grade` varchar(255) COLLATE utf8_bin NOT NULL,
  `subject` varchar(255) COLLATE utf8_bin NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `contacts` varchar(255) COLLATE utf8_bin NOT NULL,
  `phone` varchar(255) COLLATE utf8_bin NOT NULL,
  `area` varchar(255) COLLATE utf8_bin NOT NULL,
  `salary` int(11) NOT NULL,
  `degree` varchar(255) COLLATE utf8_bin NOT NULL,
  `gender` varchar(255) COLLATE utf8_bin NOT NULL,
  `school` varchar(255) COLLATE utf8_bin NOT NULL,
  `classtime` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `issuetime` varchar(255) COLLATE utf8_bin NOT NULL,
  `state` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_requirement` */

insert  into `t_requirement`(`id`,`memberid`,`studentname`,`birthday`,`stugender`,`grade`,`subject`,`description`,`contacts`,`phone`,`area`,`salary`,`degree`,`gender`,`school`,`classtime`,`issuetime`,`state`) values (16,46,'小小强333','1997-01-17','男','幼儿教育','1','情况一般','小刘','18716319111','渝中',0,'不限','男','不限','每天8点到10点','2014-04-10 20:26:37','可预约'),(17,46,'小小强33323123','1997-12-18','男','幼儿教育','1','情况一般','小刘','18716319111','渝中',0,'不限','男','不限','每天8点到10点','2014-04-10 20:28:28','已预约'),(18,46,'罗小波','1990-03-24','男','幼儿教育','1','粗心马虎','罗先生','18716111111','璧山',50,'大学专科','男','不限','每天上午9点开始到下午4点','2014-04-11 20:24:44','可预约'),(19,55,'胡小波','1990-11-27','男','幼儿教育','高中全科','没信心','杨女士','18799918887','丰都',70,'大学专科','男','重庆工商职业学院','周末上课，每次上3个小时，一共上5次','2014-04-11 20:28:08','可预约'),(20,55,'洋洋','1993-02-28','男','幼儿教育','新概念英语','英语差得很','赵师傅','18899898876','大渡口',60,'硕士研究生','男','重庆旅游职业学院','不限时间','2014-04-11 20:29:38','可预约'),(21,60,'qwerqwer','1998-01-17','男','幼儿教育','1','','werq','qwer','永川',40,'大学专科','男','重庆师大','','2014-04-14 21:55:53','已预约'),(22,60,'','2014-02-02','男','幼儿教育','1','','123123','123123','渝中',0,'不限','男','不限','','2014-04-14 21:58:27','可预约');

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberid` bigint(20) NOT NULL,
  `studentname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `birthday` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stugender` varchar(255) COLLATE utf8_bin NOT NULL,
  `grade` varchar(255) COLLATE utf8_bin NOT NULL,
  `subject` varchar(255) COLLATE utf8_bin NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`memberid`,`studentname`,`birthday`,`stugender`,`grade`,`subject`,`description`) values (4,46,'测试','2011-03-05','男','小学三年级','高中全科',''),(5,60,'123123','2014-02-06','男','幼儿教育','学龄前课程','');

/*Table structure for table `t_sysinfo` */

DROP TABLE IF EXISTS `t_sysinfo`;

CREATE TABLE `t_sysinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sitename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sitelogo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `siteurl` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `keywords` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `serviceqq` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `adminemail` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ICP` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `copyright` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aboutus` varchar(10000) COLLATE utf8_bin DEFAULT NULL,
  `contactus` varchar(5000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_sysinfo` */

insert  into `t_sysinfo`(`id`,`sitename`,`sitelogo`,`siteurl`,`keywords`,`description`,`serviceqq`,`adminemail`,`ICP`,`copyright`,`aboutus`,`contactus`) values (1,'重庆地区家教网','images/sitelogo.jpg','www.cqjj.com','家教网，重庆家教，找家教','这是一个关于家教的网站','424321913','424321913@qq.com','渝icp20140133号','Copyright(c) 2013-2014 重庆家教网 All Rights Reserved ','<h1>\r\n	我们是西南唯一一家专注于家教服务的网站</h1>\r\n','<p>\r\n	<span style=\"font-size:72px;\"><span style=\"color:#ff0000;\">重庆市南岸区崇文路2号</span></span></p>\r\n');

/*Table structure for table `t_teacher` */

DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE `t_teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `memberid` bigint(20) NOT NULL COMMENT 'FK，账户ID，引用自t_member中的id',
  `teachername` varchar(255) COLLATE utf8_bin NOT NULL,
  `mobilephone` varchar(255) COLLATE utf8_bin NOT NULL,
  `birthday` varchar(255) COLLATE utf8_bin NOT NULL,
  `gender` varchar(255) COLLATE utf8_bin NOT NULL,
  `school` varchar(255) COLLATE utf8_bin NOT NULL,
  `degree` varchar(255) COLLATE utf8_bin NOT NULL,
  `specialty` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `authentication` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '待认证',
  `subject` varchar(255) COLLATE utf8_bin NOT NULL,
  `grade` varchar(255) COLLATE utf8_bin NOT NULL,
  `servicearea` varchar(255) COLLATE utf8_bin NOT NULL,
  `servicetype` varchar(255) COLLATE utf8_bin NOT NULL,
  `photo` varchar(255) COLLATE utf8_bin DEFAULT 'upLoadFile/default.jpg',
  `certificate` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `salary` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `notes` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `evaluation` int(11) DEFAULT '0',
  `hascertificate` varchar(10) COLLATE utf8_bin DEFAULT '否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_teacher` */

insert  into `t_teacher`(`id`,`memberid`,`teachername`,`mobilephone`,`birthday`,`gender`,`school`,`degree`,`specialty`,`address`,`authentication`,`subject`,`grade`,`servicearea`,`servicetype`,`photo`,`certificate`,`salary`,`description`,`notes`,`evaluation`,`hascertificate`) values (40,48,'教师2','18716319432','2012-02-05','男','重庆大学','大学本科 ','会计','','待认证','不限','幼儿教育','不限','本人上门','upLoadFile/default.jpg','',0,'','',1,'否'),(41,49,'教师3','18716319432','2013-02-02','男','重庆大学','大学本科 ','','','待认证','不限','幼儿教育','不限','本人上门','upLoadFile/default.jpg','',0,'','',0,'否'),(42,47,'教师','12312','2011-03-07','男','重庆大学','大学本科 ','','','已认证','不限','幼儿教育','不限','本人上门','upLoadFile/default.jpg','',0,'','',0,'否'),(43,51,'教师','18716319432','2013-04-04','男','重庆三峡学院','大学本科 ','计算机科学与技术','沙坪坝','待认证','高中理综','高中一年级','黔江','学生上门','upLoadFile/default.jpg','英语六级证书',60,'好的哈','没有',0,'否'),(44,53,'刘老师','19877765454','1961-11-28','男','重庆大学','大学本科 ','没专业','重庆','待认证','不限','幼儿教育','不限','本人上门','upLoadFile/default.jpg','',40,'','',0,'否'),(45,54,'老师N','18716611111','2012-01-02','男','重庆大学','大学本科 ','信息安全','江北','待认证','不限','幼儿教育','不限','本人上门','upLoadFile/default.jpg','本科毕业证',0,'性格开朗','',0,'否'),(46,62,'asefasd','12sdfqwef','1998-04-16','男','重庆大学','大学本科 ','','','待认证','不限','幼儿教育','不限','本人上门','upLoadFile/default.jpg','',0,'','',0,'否'),(47,0,'','','','','','',NULL,NULL,'待认证','','','','','upLoadFile/default.jpg',NULL,0,NULL,NULL,0,'否');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
