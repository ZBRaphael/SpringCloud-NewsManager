/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : news_db2

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 09/01/2020 09:29:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'zjh', 'zjh');

-- ----------------------------
-- Table structure for column
-- ----------------------------
DROP TABLE IF EXISTS `column`;
CREATE TABLE `column`  (
  `column_id` int(11) NOT NULL AUTO_INCREMENT,
  `column_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of column
-- ----------------------------
INSERT INTO `column` VALUES (1, '体育新闻');
INSERT INTO `column` VALUES (2, '生活新闻');
INSERT INTO `column` VALUES (3, '娱乐新闻');

-- ----------------------------
-- Table structure for keywords
-- ----------------------------
DROP TABLE IF EXISTS `keywords`;
CREATE TABLE `keywords`  (
  `key_id` int(11) NOT NULL AUTO_INCREMENT,
  `key_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`key_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `news_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `news_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `news_author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `columns_id` int(11) NOT NULL,
  PRIMARY KEY (`news_id`) USING BTREE,
  INDEX `column_id_key`(`columns_id`) USING BTREE,
  CONSTRAINT `column_id_key` FOREIGN KEY (`columns_id`) REFERENCES `column` (`column_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (12, '全球首个可移动量子卫星地面站与墨子号对接成功', '2019年12月31日电，由中国科学技术大学、科大国盾量子技术股份有限公司和济南量子技术研究院共同研制的全球首个可移动量子卫星地面站，在济南与“墨子号”卫星对接成功，标志着我国在量子领域的科技创新与应用取得了重要突破。', '时事一点通', 1);
INSERT INTO `news` VALUES (13, '美国莽行招致伊朗报复 多国呼吁避免局势升级', '美军日前在伊拉克打死伊朗伊斯兰革命卫队下属“圣城旅”指挥官卡西姆·苏莱曼尼。作为报复，伊朗伊斯兰革命卫队8日向驻有美军的伊拉克军事基地发射“数十枚导弹”。\n\n　　针对当前美国与伊朗矛盾激化、海湾地区局势紧张升级，多国专家学者认为，美军打死苏莱曼尼是鲁莽的冒险行为，美国一味采取危险行动将使美国形单影只，也将使地区局势更加危险。对此，国际社会呼吁各方保持克制，避免局势持续升级。法国智库蒙泰涅研究所特别顾问多米尼克·莫伊西发表文章认为，特朗普挑战伊朗是把其外交政策当作竞选的砝码，希望利用美国人对可能遭受恐袭的惧怕心理争取对自己有利的选情，缓解弹劾案带来的压力。然而，美国对苏莱曼尼的空袭是巨大冒险，既使中东地区陷入混乱，也削弱了美国自身的力量。\n\n　　美国布鲁金斯学会高级研究员达雷尔·韦斯特说，未来美国和伊朗之间可能会陷入“打击与报复”“再打击与再报复”的恶性循环，甚至不排除局面迅速失控、双方陷入战争的可能。\n\n　　俄罗斯战略研究所近东和中东中心主任弗拉基米尔·菲京认为，美国与伊朗之间紧张局势难以缓解是因为美方不准备与伊朗直接对话，也不准备接受各方调解。当前局势前景难料，美国已宣布提升其在所有军事基地的戒备状态，伊朗必然会采取回应，军事冲突不符合两国利益。\n\n　　美国赖斯大学贝克公共政策研究所专家吉姆·克雷恩认为，特朗普政府的行为违背了国际法，关闭了美国政府与伊朗和平谈判的路径，增加了爆发战争的风险。美国一味采取“法外行动”，罔顾盟友反应，只会使自己更加形单影只。', '新华网', 1);
INSERT INTO `news` VALUES (14, '武磊攻破巴萨引发中国球迷狂欢 点击量达2.2亿次', '西班牙《每日体育报》在最新的一篇报道中指出，本轮西甲武磊对巴萨的进球，引发了社交网站上的轰动。在新浪微博上，武磊的进球点击量达到了2.2亿次，而西班牙人队也可以充分利用这位中国球星的巨大影响力。\n\n　　《每日体育报》表示，武磊的进球不但给西班牙人带来了重要1分，而且从他打入球队第二球的那一刻起，就引燃了社交网站。中国以及亚洲多个国家的媒体为武磊的进球疯狂，在新浪微博平台上，“武磊进球”的主题点击量达到了2.2亿次。新浪微博相当于中国版的推特。此外，还有几百万的球迷观看了比赛的直播。《每日体育报》表示，武磊成为了中国社交媒体上的主角，他在上场的那一刻，网上称赞他的评论就开始了，而在他攻破巴萨球门后，球迷的情绪瞬间被引爆。\n\n　　“武磊今天比梅西更快”，一位球迷写道，而另一位球迷则表示：“武磊是亚洲最好的前锋。”还有球迷指出：“武磊是西班牙人的拯救者，中国英雄。”\n\n　　新华社以及中国的多家体育媒体也报道武磊的壮举，指出武磊是首位攻破巴萨大门的中国球员。《每日体育报》透露，西班牙人俱乐部也想利用武磊的进球以及他的形象来增加自己在亚洲市场的影响力。在中国，西班牙人队的比赛收视率甚至超过了巴萨和皇马这两大豪门。（伊万）', '新浪体育', 2);
INSERT INTO `news` VALUES (15, '内马尔：交手过最强后卫是他 皇马这2人不可限量', '　巴西双星罗德里戈和维尼修斯被皇马球迷视作球队的未来之星，近日他们的巴西老乡内马尔在采访中也表示，他们两人还会达到更高的高度。\n\n　　“他们是两名非常有潜力的球员，”内马尔在接受环球体育采访时说，“他们只在欧洲踢了很短的时间，但是他们会不断积累经验，然后变得更加成熟，表现的比现在好。”\n\n　　“他们希望参加所有的比赛，但是适应是一件很困难的事情，想要达到在皇马巴萨这样的球队站住脚的水平是很困难的，但是这有些球员都设法去做到这一点。”\n\n　　当被问及谁是他遇到过的最佳后卫时，内马尔回答说：“我一直在谈论拉莫斯，我曾经和他交手过。我还和另外三位出色的后卫皮克、蒂亚戈-席尔瓦和马尔基尼奥斯一起踢过球。”\n\n　　回顾过去的2019年，内马尔表示：“不管从职业还是个人角度来讲，这都是非常艰难的一年，我再次受伤，必须再一次康复。我的目标仍然是帮助巴黎和巴西队赢得一切。”\n\n　　（林登万）', '新浪体育', 2);
INSERT INTO `news` VALUES (16, '迪丽热巴黄景瑜被曝同回公寓过夜 双方疑因戏生情', '新浪娱乐讯  近日娱乐圈的恋情绯闻不断，一个接一个的让吃瓜网友一过新年都有些应接不暇了。1月8日，有媒体曝迪丽热巴与黄景瑜疑似因戏生情后，一起返回家中过平安夜的画面。此前有多次路透曝光，在路透中两个人的吻戏也被拍下来，两个人拥抱在一起拍摄吻戏时，脸上都露出腼腆的笑容，拍完之后现场的气氛也是非常暧昧。\n\n　　报道中指，黄景瑜与迪丽热巴在剧组互动十分亲密。两个人一点都不避讳在工作人员面前的状态，时常一起返回同一辆保姆车，进去之后换完衣服出来。\n\n　　黄景瑜当天与迪丽热巴在房车外聊天，黄景瑜蹲在地上逗猫，迪丽热巴与工作人员聊天。猫走了之后，黄景瑜便起身轻轻拍了一下迪丽热巴，而迪丽热巴的也离开停止了与工作人员的聊天；跟在黄景瑜身后一起进入了房车内。两个人在房车内待了很长时间才出来。', '新浪娱乐', 3);
INSERT INTO `news` VALUES (17, '陈小春出演《黄金甲》：不忘初心，做自己的英雄', '近日，演员陈小春可谓好戏不间断，刚刚结束的台北演唱会，反响热烈。期间又马不停蹄地投入新作品角色的创作中。\n\n　　在很多人眼里，他是《古惑仔之人在江湖》里无数70、80后的青春回忆，是《鹿鼎记》里古灵精怪的韦小宝，也是《爸爸去哪儿》里时而柔情的硬汉老爸。而现实生活中，或许是一路打拼上来的缘故，有人曾经说陈小春身上有股不常见的狠劲和韧劲。他是歌手，又是演员，出道至今，一路上他努力拿出许多演艺作品来表达自己，证明自己，也挑战自己。\n\n　　值得关注的是，陈小春最新的大荧幕作品正在紧锣密鼓地行进中。影片故事围绕一件金甲展开，主要讲述陈小春扮演的男主人公意外遇上一股神秘的力量，在原本过得稀里糊涂的生活中竟遇上“无厘头”女主，从而引发一系列啼笑皆非的故事。故事中，陈小春扮演的男主人公狄青杨是一个前后转变成长巨大的角色。陈小春自己也透露，这次饰演的“狄青杨”这个角色，随着故事发展，在很多表演细节上会呈现人物的转变，是一个挑战。但他一直在接受这个挑战，因为任何一个角色的剖析和饰演对他本人而言也是一个不断自我思考、自我辩证的真实过程。影片故事最开始，在生活的压力下，狄青杨穷困潦倒又不思进取，爱坑蒙拐骗且不劳而获，可以说是一个地地道道的痞子形象。而因一件意外获得的“金甲”，他的生活里突然出现了很多人，在与这些人产生的纷纷纠葛中，狄青杨自己也在不断成长与蜕变。每个人的生活里会有挫折、考验、甚至“恶势力”，而狄青杨就像陈小春本人在现实中曾经说过的一句话一样——“我从没怕过。”\n\n　　无论是工作还是现实生活中，陈小春身上似乎总带着一股少见的“纯爷们”的豪气，而在这一点上，据说也是片中男主人公这个角色人物贯穿始终的重要性格特质之一。而对于这样一次另一种意义上的“本色出演”，也让许多关注影片的影迷朋友万分期待。', '中国娱乐网', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号，自增长',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `forbidden` bit(1) NULL DEFAULT NULL COMMENT '是否被禁止',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yyl', 'yyl', 'ssada', NULL);
INSERT INTO `user` VALUES (2, 'zhang', 'zhang', '974617045@qq.com', NULL);
INSERT INTO `user` VALUES (3, 'zbr', 'zbr', '974617045@qq.com', NULL);

SET FOREIGN_KEY_CHECKS = 1;
