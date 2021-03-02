/*
 Navicat MySQL Data Transfer

 Source Server         : mysql_2019year
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 02/03/2021 16:41:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for basket
-- ----------------------------
DROP TABLE IF EXISTS `basket`;
CREATE TABLE `basket`  (
  `basket_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车主键',
  `user_id` int(11) NULL DEFAULT NULL,
  `sku_id` int(11) NULL DEFAULT NULL,
  `num` int(4) NULL DEFAULT NULL,
  `shop_id` int(11) NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`basket_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basket
-- ----------------------------
INSERT INTO `basket` VALUES (47, 1, 600, 1, NULL, 1, '2020-12-10 10:03:53');
INSERT INTO `basket` VALUES (49, 1, 601, 1, NULL, 1, '2020-12-10 14:17:29');
INSERT INTO `basket` VALUES (50, 1, 602, 1, NULL, 1, '2020-12-10 14:18:38');
INSERT INTO `basket` VALUES (51, 1, 400, 1, NULL, 1, '2020-12-10 14:22:25');
INSERT INTO `basket` VALUES (52, 1, 500, 1, NULL, 1, '2021-02-23 15:08:18');

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `brand_id` int(11) NULL DEFAULT NULL,
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `brand_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '品牌图像',
  `status` tinyint(1) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of brand
-- ----------------------------
INSERT INTO `brand` VALUES (1, 99, '索尼', 'http://www.sina.com', 1, NULL, NULL);
INSERT INTO `brand` VALUES (2, 100, '锤子科技', 'http://www.smart', 1, NULL, NULL);
INSERT INTO `brand` VALUES (3, 128, '锤子科技', '1', 1, NULL, NULL);
INSERT INTO `brand` VALUES (4, 221, '苹果公司', '1', 1, NULL, NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级',
  `seq` int(5) NULL DEFAULT NULL COMMENT '排序',
  `category_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `status` tinyint(1) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5316 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1000, '手机数码', 0, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (1100, '手机', 1000, 1, 'https://resource.smartisan.com/resource/a565ebb3399e2776c97dcb8b906f1b86.png?x-oss-process=image/resize,w_659/format,webp', 1, NULL, NULL);
INSERT INTO `category` VALUES (1200, '手机配件', 1000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (1300, '智能设备', 1000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (1400, '数码配件', 1000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (2000, '运动服饰', 0, 2, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (2100, '运动鞋', 2000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (2200, '男装', 2000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (2300, '女装', 2000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (2400, '休闲鞋', 2000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (3000, '电脑办公', 0, 3, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (3100, '电脑整机', 3000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (3200, '电脑配件', 3000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (3300, '办公设备', 3000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (4000, '美妆清洁', 0, 4, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (4100, '洗发护发', 4000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (4200, '口腔护理', 4000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (4300, '纸品清洗', 4000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (5000, '图书教育', 0, 5, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (5100, '教材教辅', 5000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (5200, '人文社科', 5000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (5300, '艺术', 5000, 1, NULL, 1, NULL, NULL);
INSERT INTO `category` VALUES (5304, '手机壳', 1200, 4, '', 1, '2020-12-25 19:53:10', NULL);
INSERT INTO `category` VALUES (5305, '存储卡', 1400, 0, '', 1, '2020-12-25 19:56:49', NULL);
INSERT INTO `category` VALUES (5306, 'Apple', 1100, 3, 'https://img12.360buyimg.com/n7/jfs/t1/148767/39/18017/86358/5fd32ff0E5ca41721/d885f7c401dfa557.jpg', 1, '2020-12-25 19:59:09', NULL);
INSERT INTO `category` VALUES (5307, 'OPPO R5 pro+', 1100, 0, 'https://img12.360buyimg.com/n4/jfs/t1/145996/14/19095/985912/5fdd9b01Ef7c887f8/f3f6c17ba3b19b24.png', 1, '2020-12-25 21:21:30', NULL);
INSERT INTO `category` VALUES (5313, '红米', 1100, 0, 'https://img14.360buyimg.com/n7/jfs/t1/134740/26/11967/92060/5f843e70E8005bcb6/bb4d854e230a6b2c.jpg', 1, '2020-12-26 17:35:11', NULL);
INSERT INTO `category` VALUES (5314, '华为Mate20', 1100, 1, 'https://img13.360buyimg.com/n7/jfs/t1/95525/40/4579/516710/5deb54a4E7ba986cc/beec9b5943cfa570.jpg', 1, '2020-12-26 21:02:52', NULL);
INSERT INTO `category` VALUES (5315, 'AirPods', 1200, 2, 'https://img1.360buyimg.com/n6/jfs/t1/61017/23/2106/150319/5d07495cE8d404476/bbe3d3abb0ee44c2.png', 1, '2020-12-27 10:32:48', NULL);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `shop_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商家id',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品主图',
  `imgs` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品图片，以,分割',
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '1 上架 0下架 ',
  `brief` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `category_id` int(11) NOT NULL COMMENT '种类',
  `sale_num` int(6) NULL DEFAULT NULL COMMENT '销量',
  `stock_num` int(6) NULL DEFAULT NULL COMMENT '库存数量',
  `sort_num` int(10) NULL DEFAULT NULL COMMENT '排序',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '录入时间',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `putaway_date` datetime(0) NULL DEFAULT NULL COMMENT '上架时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '乐观锁 版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112222171 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (10049901, '索尼（sony) WH-1000XM3', '115662', 'https://img10.360buyimg.com/n7/jfs/t1/132549/13/7602/50860/5f3e4926E8dc899e7/ea99eabb3dba7ad1.jpg', NULL, 1499.00, 1, '索尼耳机，尽情享受!', 3622, 163, 442, 0, '2020-12-27 14:13:34', '2020-12-27 14:24:17', '2020-12-27 14:13:00', 1);
INSERT INTO `product` VALUES (100022101, 'AirPods', '1162344', 'https://img1.360buyimg.com/n6/jfs/t1/61017/23/2106/150319/5d07495cE8d404476/bbe3d3abb0ee44c2.png', 'http://img20.360buyimg.com/imgzone/jfs/t21124/26/1454154758/396853/94c4862e/5b2a0c36Nae2a6c0a.jpg@http://img20.360buyimg.com/imgzone/jfs/t21124/26/1454154758/396853/94c4862e/5b2a0c36Nae2a6c0a.jpg', 552.00, 1, '苹果（Apple） 苹果airpods 无线蓝牙耳机 支持iPad Air 2代/iPhone', 5315, 1263, 26, 1, '2020-12-27 10:32:48', '2020-12-27 10:34:06', '2020-12-27 10:32:00', 1);
INSERT INTO `product` VALUES (100112801, '坚果 R2', '128', 'https://resource.smartisan.com/resource/623bad86546352a2035ec704e2faf041.png?x-oss-process=image/resize,w_270/format,webp', 'https://resource.smartisan.com/resource/79c58355d2f5fd53988684b96d405f9b.png?x-oss-process=image/resize,w_270/format,webp', 4799.00, 1, '是下一代手机，更是下一代电脑', 1005, 111, 24, 2, '2020-11-25 16:30:34', '2020-11-25 16:30:39', '2020-11-25 16:30:48', 1);
INSERT INTO `product` VALUES (100810001, 'Smartisan TNT 大满足套装', '100', 'https://resource.smartisan.com/resource/79c58355d2f5fd53988684b96d405f9b.png?x-oss-process=image/resize,w_270/format,webp', 'https://resource.smartisan.com/resource/623bad86546352a2035ec704e2faf041.png?x-oss-process=image/resize,w_270/format,webp@https://img1.360buyimg.com/n6/jfs/t1/61017/23/2106/150319/5d07495cE8d404476/bbe3d3abb0ee44c2.png', 6999.00, 1, '下一代手机，下一代电脑', 1006, 1112, 1002, 3, '2020-11-25 16:34:00', '2020-11-25 16:34:03', '2020-11-25 16:34:18', 1);
INSERT INTO `product` VALUES (112222102, 'Apple Watch Series 5智能手表', '221', 'https://img11.360buyimg.com/babel/s320x320_jfs/t1/93403/40/3969/124750/5de4aa23E5f3ae6c2/cc8e307f5aeccb49.jpg!cc_320x320.webp', 'https://img1.360buyimg.com/n6/jfs/t1/61017/23/2106/150319/5d07495cE8d404476/bbe3d3abb0ee44c2.png', 2599.00, 1, 'GPS款 40毫米深空灰色铝金属表壳 黑色运动型表带 MWV82CH/A', 1009, 1131, 11142, 4, '2020-11-12 16:38:14', '2020-11-19 16:38:19', '2020-11-21 16:38:39', 1);
INSERT INTO `product` VALUES (112222103, 'OPPO R5 pro+', '13552352', 'https://img12.360buyimg.com/n4/jfs/t1/145996/14/19095/985912/5fdd9b01Ef7c887f8/f3f6c17ba3b19b24.png', NULL, 1225.00, 1, 'oppo 新一代拍照手机', 5307, 113, 5322, 5, '2020-12-25 21:21:30', NULL, '2020-12-25 21:21:30', 1);
INSERT INTO `product` VALUES (112222108, '红米', '26332', 'https://img14.360buyimg.com/n7/jfs/t1/134740/26/11967/92060/5f843e70E8005bcb6/bb4d854e230a6b2c.jpg', NULL, 1532.00, 1, '红米手机，性价比高。', 5313, 112, 632, 6, '2020-12-26 17:35:13', '2020-12-26 17:35:58', '2020-12-26 17:35:00', 1);
INSERT INTO `product` VALUES (112222109, '华为Mate20', '1135', 'https://img13.360buyimg.com/n7/jfs/t1/95525/40/4579/516710/5deb54a4E7ba986cc/beec9b5943cfa570.jpg', NULL, 3557.00, 1, '限时销售！', 5314, 113, 666, 7, '2020-12-26 21:02:52', '2020-12-26 21:03:57', '2020-12-26 21:02:00', 1);
INSERT INTO `product` VALUES (112222141, 'Redmi Note 9', NULL, '//img14.360buyimg.com/n7/jfs/t1/139560/35/15779/97911/5fbdfbdfE244aee62/b0fe4cfb07693742.jpg', NULL, 1299.00, NULL, '小金刚品质保证，天玑800U处理器', 9999, NULL, NULL, NULL, '2021-03-02 10:40:39', NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222142, 'Redmi Note 9', NULL, '//img12.360buyimg.com/n7/jfs/t1/142405/30/15860/47809/5fbe0736E3284d091/0b92f82917a9c400.jpg', NULL, 1999.00, NULL, '小金刚品质液冷游戏芯，一亿像素，120Hz高刷屏', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222143, '三星 Galaxy S21', NULL, '//img13.360buyimg.com/n7/jfs/t1/158952/34/8633/85676/60374e26Eb4fd659f/2a7182d8eaf3601e.jpg', NULL, 4969.00, NULL, '欢迎选购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222144, 'Redmi 9A 5000mAh大电量', NULL, '//img12.360buyimg.com/n7/jfs/t1/118064/27/12885/59959/5f17b7efE453f688d/5b33ac76b2aaea9b.jpg', NULL, 599.00, NULL, '5000mAh大电量，大屏幕大音量，人脸解锁', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222145, 'OPPO A93 8+256GB', NULL, '//img11.360buyimg.com/n7/jfs/t1/157319/26/3073/116449/5ffd2d15Ebd3809cb/16bbd8b83bd11b9e.jpg', NULL, 1999.00, NULL, '超大存储，5000mAh超大电池', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222146, 'OPPO Reno5 5G', NULL, '//img11.360buyimg.com/n7/jfs/t1/154641/20/10118/122842/5fd8928cE12318ab6/330d61c61b9381a2.jpg', NULL, 2999.00, NULL, '', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222147, '荣耀V40 5G 超级快充', NULL, '//img10.360buyimg.com/n7/jfs/t1/156360/38/7104/68131/60097fcbEc9fbd159/a464adfe1fb2d13d.jpg', NULL, 3599.00, NULL, '欢迎选购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222148, 'Redmi 8A 5000mAh大电量', NULL, '//img11.360buyimg.com/n7/jfs/t1/54085/1/13732/194509/5da6d50fE32d0191a/68d0ac29ce4a326d.jpg', NULL, 699.00, NULL, '5000mAh大电量，18W快充+Type-C接口，线性扬声器', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222149, 'Redmi Note 9', NULL, '//img13.360buyimg.com/n7/jfs/t1/143051/26/15747/73035/5fbdd54cE80757a48/67c387e1d0dc5c83.jpg', NULL, 1099.00, NULL, '小金刚品质保证，骁龙662处理器', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222150, 'OPPO A52 5000mAh超大电池', NULL, '//img13.360buyimg.com/n7/jfs/t1/109265/22/13522/238337/5ea139e0Ec857833d/340a37886f483e67.jpg', NULL, 1399.00, NULL, '5000mAh超大电池，18W疾速快充，AI四摄', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222151, 'Redmi 9 全场景AI四摄', NULL, '//img10.360buyimg.com/n7/jfs/t1/113763/35/10755/184448/5ef076d4E23a60810/f26df22c9c524d65.jpg', NULL, 799.00, NULL, '5020mAh大电量，高性能游戏芯，1080P高清护眼大屏，AI四摄', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222152, 'Redmi Note8 4800万全场景四摄', NULL, '//img13.360buyimg.com/n7/jfs/t1/40559/35/13223/351173/5d6749eeEb5f3d051/940d43d5f4e23d35.jpg', NULL, 1199.00, NULL, '小金刚品质保证，骁龙665处理器，标配18W充电器！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222153, 'OPPO K7x新品手机 【26号至高再减50】', NULL, '//img12.360buyimg.com/n7/jfs/t1/120606/32/20336/105804/5fc1b4b4E8412a875/1b7b4bb358558962.jpg', NULL, 1999.00, NULL, '欢迎选购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222154, 'Apple iPhone 11', NULL, '//img12.360buyimg.com/n7/jfs/t1/148767/39/18017/86358/5fd32ff0E5ca41721/d885f7c401dfa557.jpg', NULL, 4799.00, NULL, '选购iPhone11ProMax，仅加2100元得6.5英寸超大显示屏手机！点击抢购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222155, 'OPPO K7x 双模5G', NULL, '//img14.360buyimg.com/n7/jfs/t1/151005/34/7196/83294/5fb4a9bfE15969ddb/b2dcb8056bd72373.jpg', NULL, 1499.00, NULL, '硬核5G，4800万四摄，5000mAh长续航', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222156, 'vivo iQOO U1x', NULL, '//img13.360buyimg.com/n7/jfs/t1/144283/17/10956/68617/5f8b00b5Ec06fb6b9/0e466d15f51bf6d9.jpg', NULL, 999.00, NULL, '5000mAh大电池！京选好物，立即抢购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222157, 'Redmi K30 5G双模', NULL, '//img11.360buyimg.com/n7/jfs/t1/93562/20/15470/87993/5e71cdbdE7606d124/9e5835e6e0f980dc.jpg', NULL, 1599.00, NULL, 'RedmiK305G版，120Hz流速屏', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222158, '京品手机 realme 真我Q2', NULL, '//img14.360buyimg.com/n7/jfs/t1/134740/26/11967/92060/5f843e70E8005bcb6/bb4d854e230a6b2c.jpg', NULL, 1249.00, NULL, '120Hz畅速屏,4800万像素,入会领20元优惠券', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222159, '【限时至高立减50元赠耳机！】OPPO K7x 5G新品手机90Hz电竞屏拍照游戏视频智能长续航手机', NULL, '//img14.360buyimg.com/n7/jfs/t1/165765/8/7543/31777/6038615aE94a86b52/218e1f8f250d0c02.jpg', NULL, 1499.00, NULL, '欢迎选购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222160, 'vivo iQOO Neo3', NULL, '//img13.360buyimg.com/n7/jfs/t1/136013/4/2911/444519/5ef32450Eb8ab3c52/1c233f664015b793.jpg', NULL, 2698.00, NULL, 'iQOO7享12期免息，速抢！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222161, 'Apple iPhone 12', NULL, '//img10.360buyimg.com/n7/jfs/t1/120344/32/14989/43851/5f861a0fEdd59a92d/3c64d4346f9a6cf3.jpg', NULL, 6799.00, NULL, '推荐选购', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222162, 'vivo iQOO 7', NULL, '//img13.360buyimg.com/n7/jfs/t1/171097/25/2137/75197/5ffc04a9Ec37de9b6/e6580eefa2fde62b.jpg', NULL, 4198.00, NULL, '骁龙888处理器！京选好物，立即抢购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222163, 'Redmi 10X 5G', NULL, '//img10.360buyimg.com/n7/jfs/t1/117983/29/8108/89342/5ecbbf8eEf1103a18/8bc36e84ae221109.jpg', NULL, 1399.00, NULL, '天玑820高性能处理器，双5G待机', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222164, '一加手机 OnePlus 8T', NULL, '//img11.360buyimg.com/n7/jfs/t1/160046/11/8209/86732/6034d920Ea2902549/f3796f06ce0eeb1f.jpg', NULL, 3699.00, NULL, '！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222165, 'realme 真我V15 6400万像素', NULL, '//img10.360buyimg.com/n7/jfs/t1/161062/22/2538/62003/5ffe5562Eef9422ed/37352a085d79a792.jpg', NULL, 1499.00, NULL, '欢迎选购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222166, '荣耀X10 5G双模 麒麟820', NULL, '//img12.360buyimg.com/n7/jfs/t1/141768/29/1714/131082/5ef9966aEcf368671/aaffea2c94abe8ac.jpg', NULL, 2399.00, NULL, '麒麟820soc5G芯片，90Hz屏幕刷新率，疾速游戏体验！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222167, '京品手机 vivo iQOO', NULL, '//img12.360buyimg.com/n7/jfs/t1/148894/22/3698/64829/5f1a5f37Ea337bd39/f5c8cd13effd7b8b.jpg', NULL, 1398.00, NULL, '骁龙720G，4500mAh大电池！京选好物，立即抢购！', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222168, 'Redmi 10X 4G', NULL, '//img13.360buyimg.com/n7/jfs/t1/129887/36/392/108566/5eccc3e5E1c5fb0d7/c00a373623f3eb2e.jpg', NULL, 999.00, NULL, 'HelioG85高性能处理器', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222169, 'Apple iPhone 12', NULL, '//img12.360buyimg.com/n7/jfs/t1/122505/19/15070/68848/5f861494Ebe330db5/24bc162f493ec940.jpg', NULL, 10099.00, NULL, '推荐选购', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `product` VALUES (112222170, 'OPPO K7 双模5G', NULL, '//img13.360buyimg.com/n7/jfs/t1/113447/6/14007/68063/5f28d6caEd77a9ab7/a5cc7efa8090563e.jpg', NULL, 1899.00, NULL, 'OLED屏幕指纹，4800万超清四摄，3200万前摄', 9999, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for prop_name
-- ----------------------------
DROP TABLE IF EXISTS `prop_name`;
CREATE TABLE `prop_name`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prop_name_id` int(11) NULL DEFAULT NULL,
  `prop_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prop_name
-- ----------------------------
INSERT INTO `prop_name` VALUES (1, 1000, '颜色');
INSERT INTO `prop_name` VALUES (2, 2000, '尺寸');
INSERT INTO `prop_name` VALUES (3, 3000, '内存');
INSERT INTO `prop_name` VALUES (4, 4000, '有线/无线');

-- ----------------------------
-- Table structure for prop_value
-- ----------------------------
DROP TABLE IF EXISTS `prop_value`;
CREATE TABLE `prop_value`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prop_value_id` int(11) NULL DEFAULT NULL,
  `prop_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `prop_name_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prop_value
-- ----------------------------
INSERT INTO `prop_value` VALUES (1, 1002, '红色', 1000);
INSERT INTO `prop_value` VALUES (2, 1003, '白色', 1000);
INSERT INTO `prop_value` VALUES (3, 1004, '黑色', 1000);
INSERT INTO `prop_value` VALUES (4, 2001, 'L', 2000);
INSERT INTO `prop_value` VALUES (5, 2002, 'XL', 2000);
INSERT INTO `prop_value` VALUES (6, 3002, '64G', 3000);
INSERT INTO `prop_value` VALUES (7, 3003, '128G', 3000);
INSERT INTO `prop_value` VALUES (8, 4001, '有线耳机', 4000);
INSERT INTO `prop_value` VALUES (9, 4002, '无线耳机', 4000);
INSERT INTO `prop_value` VALUES (10, 1005, '深绿', 1000);
INSERT INTO `prop_value` VALUES (11, 1006, '暗夜黑', 1000);

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku`  (
  `sku_id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_properties` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '属性描述',
  `sku_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sku_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sku_price` decimal(10, 2) NULL DEFAULT NULL,
  `sku_stock` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '库存',
  `sku_sale_num` int(11) NULL DEFAULT NULL,
  `shop_id` int(11) NULL DEFAULT NULL,
  `status` tinyint(2) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `version` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 604 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sku
-- ----------------------------
INSERT INTO `sku` VALUES (400, '深绿64G内存', '坚果R2手机', 'https://resource.smartisan.com/resource/1d3331e0b97a9e9bcb184c57055957cb.jpg?x-oss-process=image/resize,w_270/format,webp', 3999.00, '299', 11, 3333, 1, '2020-11-30 10:10:20', NULL, 1);
INSERT INTO `sku` VALUES (401, '暗夜黑64G内存', '坚果R2手机', 'https://resource.smartisan.com/resource/f195e666e089d4e3775ce67d8e9523ce.png?x-oss-process=image/resize,w_270/format,webp', 3999.00, '1216', 573, 3333, 1, '2020-11-30 10:11:33', NULL, 1);
INSERT INTO `sku` VALUES (402, '深绿128G内存', '坚果R2手机', 'https://resource.smartisan.com/resource/1d3331e0b97a9e9bcb184c57055957cb.jpg?x-oss-process=image/resize,w_270/format,webp', 4999.00, '456', 63, 3333, 1, '2020-11-30 10:12:19', NULL, 1);
INSERT INTO `sku` VALUES (403, '暗夜黑128G内存', '坚果R2手机', 'https://resource.smartisan.com/resource/f195e666e089d4e3775ce67d8e9523ce.png?x-oss-process=image/resize,w_270/format,webp', 4999.00, '352', 64, 3333, 1, '2020-11-30 10:13:05', NULL, 1);
INSERT INTO `sku` VALUES (500, '红色', '索尼（SONY）WH-1000XM3', 'https://img13.360buyimg.com/n1/jfs/t1/95393/2/16383/77544/5e7adf3fEcce0f333/19ffa0e489f3fabc.jpg', 99.00, '322', 2226, 1111, 1, '2020-11-27 21:22:52', NULL, 1);
INSERT INTO `sku` VALUES (501, '黑色', '索尼（SONY）WH-1000XM3', 'https://img11.360buyimg.com/babel/s320x320_jfs/t26881/248/1069038704/78844/5f504fd9/5bc0914fN9c0e3876.jpg!cc_320x320.webp', 99.00, '333', 222, 1111, 1, '2020-11-28 11:19:51', NULL, 1);
INSERT INTO `sku` VALUES (502, '白色', '索尼（SONY）WH-1000XM3', 'https://img11.360buyimg.com/n7/jfs/t1/89688/12/14954/70230/5e6b00fbE7d7ee8dd/03a07799505b35a1.jpg', 99.00, '111', 22, 1111, 1, '2020-11-28 11:22:38', NULL, 1);
INSERT INTO `sku` VALUES (600, '红色有线耳机', 'AirPods', 'https://img1.360buyimg.com/n6/jfs/t1/91467/16/14634/99605/5e6b0182E7a5d1956/802b29a63459eac0.jpg', 599.00, '1200', 1122, 2222, 1, '2020-11-28 11:29:25', NULL, 1);
INSERT INTO `sku` VALUES (601, '白色有线耳机', 'AirPods', 'https://img11.360buyimg.com/n7/jfs/t1/89688/12/14954/70230/5e6b00fbE7d7ee8dd/03a07799505b35a1.jpg', 799.00, '1211', 11112, 2222, 1, '2020-11-28 11:30:03', NULL, 1);
INSERT INTO `sku` VALUES (602, '红色无线耳机', 'AirPods', 'https://img10.360buyimg.com/n7/jfs/t1/119356/20/10254/147992/5ee719e9E2024ca76/98de2c35b5ec637c.jpg', 1099.00, '22', 1199, 2222, 1, '2020-11-28 11:30:50', NULL, 1);
INSERT INTO `sku` VALUES (603, '白色无线耳机', 'AirPods', 'https://img12.360buyimg.com/n7/jfs/t1/122350/21/18925/23756/5fb3d2a5E62bcf79d/5fbcc81dbc3df07f.jpg', 1099.00, '221', 1174, 2222, 1, '2020-11-28 11:31:39', NULL, 1);

-- ----------------------------
-- Table structure for spu_sku_rel
-- ----------------------------
DROP TABLE IF EXISTS `spu_sku_rel`;
CREATE TABLE `spu_sku_rel`  (
  `id` int(11) NOT NULL,
  `spu_id` int(11) NULL DEFAULT NULL COMMENT '产品id',
  `sku_id` int(11) NULL DEFAULT NULL,
  `prop_name_id` int(11) NULL DEFAULT NULL COMMENT '对应属性名如颜色，内存等',
  `prop_value_id` int(11) NULL DEFAULT NULL COMMENT '具体属性如红色，64G ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of spu_sku_rel
-- ----------------------------
INSERT INTO `spu_sku_rel` VALUES (1, 10049901, 500, 1000, 1002);
INSERT INTO `spu_sku_rel` VALUES (2, 10049901, 502, 1000, 1003);
INSERT INTO `spu_sku_rel` VALUES (3, 10049901, 501, 1000, 1004);
INSERT INTO `spu_sku_rel` VALUES (4, 100022101, 600, 1000, 1002);
INSERT INTO `spu_sku_rel` VALUES (5, 100022101, 601, 1000, 1003);
INSERT INTO `spu_sku_rel` VALUES (6, 100022101, 602, 4000, 4002);
INSERT INTO `spu_sku_rel` VALUES (7, 100022101, 603, 4000, 4002);
INSERT INTO `spu_sku_rel` VALUES (8, 100022101, 602, 1000, 1002);
INSERT INTO `spu_sku_rel` VALUES (9, 100022101, 603, 1000, 1003);
INSERT INTO `spu_sku_rel` VALUES (10, 100022101, 601, 4000, 4001);
INSERT INTO `spu_sku_rel` VALUES (11, 100022101, 600, 4000, 4001);
INSERT INTO `spu_sku_rel` VALUES (12, 100112801, 400, 1000, 1005);
INSERT INTO `spu_sku_rel` VALUES (13, 100112801, 400, 3000, 3002);
INSERT INTO `spu_sku_rel` VALUES (14, 100112801, 401, 1000, 1006);
INSERT INTO `spu_sku_rel` VALUES (15, 100112801, 401, 3000, 3002);
INSERT INTO `spu_sku_rel` VALUES (16, 100112801, 402, 1000, 1005);
INSERT INTO `spu_sku_rel` VALUES (17, 100112801, 402, 3000, 3003);
INSERT INTO `spu_sku_rel` VALUES (18, 100112801, 403, 1000, 1006);
INSERT INTO `spu_sku_rel` VALUES (19, 100112801, 403, 3000, 3003);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` int(11) NULL DEFAULT NULL,
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `perms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `type` tinyint(4) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_num` int(6) UNSIGNED NULL DEFAULT 0 COMMENT '排序',
  `create_at` datetime(0) NULL DEFAULT NULL,
  `update_at` datetime(0) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, NULL, NULL, 0, 'fa fa-cog', 1, '2020-12-23 09:56:45', NULL, 1);
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, '/sys/user', NULL, 1, 'fa fa-user', 10, '2020-12-23 09:57:10', NULL, 1);
INSERT INTO `sys_menu` VALUES (3, '查看', 2, NULL, 'sys:user:view', 2, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (4, '新增', 2, NULL, 'sys:user:add', 2, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (5, '修改', 2, NULL, 'sys:user:edit', 2, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (6, '删除', 2, NULL, 'sys:user:delete', 2, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_menu` VALUES (12, '菜单管理', 1, '/sys/menu', NULL, 1, 'fa fa-bars', 20, '2020-12-23 15:12:10', NULL, NULL);
INSERT INTO `sys_menu` VALUES (13, '查看', 12, NULL, 'sys:menu:view', 2, NULL, 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (14, '新增', 12, NULL, 'sys:menu:add', 2, NULL, 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (15, '修改', 12, NULL, 'sys:menu:edit', 2, NULL, 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (16, '删除', 12, NULL, 'sys:menu:delete', 2, NULL, 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (19, '商品管理', 0, '', '', 0, 'fa fa-bank', 2, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (20, '商品种类', 19, '/prod/category', '', 1, 'fa fa-asterisk', 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (22, '查看', 20, '', 'prod:cate:view', 2, '', 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (24, '新增', 20, '', 'prod:cate:add', 2, '', 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (25, '删除', 20, '', 'prod:cate:delete', 2, '', 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (26, '修改', 20, '', 'prod:cate:edit', 2, '', 0, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (27, '产品信息', 19, '/prod/info', '', 1, 'fa fa-product-hunt', 1, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (28, '属性参数', 19, '/prod/kvProperty', '', 1, 'fa fa-random', 0, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_nickname` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  `create_by` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '超级管理员', 1, '2020-12-22 20:53:09');
INSERT INTO `sys_role` VALUES (2, 'test', '测试角色1', 1, '2020-12-26 09:34:40');

-- ----------------------------
-- Table structure for sys_role_menu_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu_rel`;
CREATE TABLE `sys_role_menu_rel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  `create_at` datetime(0) NULL DEFAULT NULL,
  `update_at` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1116 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu_rel
-- ----------------------------
INSERT INTO `sys_role_menu_rel` VALUES (1111, 2, 3, '2020-12-26 09:35:03', NULL);
INSERT INTO `sys_role_menu_rel` VALUES (1112, 2, 13, '2020-12-26 09:45:25', NULL);
INSERT INTO `sys_role_menu_rel` VALUES (1113, 2, 19, '2020-12-26 09:47:29', NULL);
INSERT INTO `sys_role_menu_rel` VALUES (1114, 2, 20, '2020-12-26 09:48:15', NULL);
INSERT INTO `sys_role_menu_rel` VALUES (1115, 2, 22, '2020-12-26 09:51:16', NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nickname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_by` datetime(0) NULL DEFAULT NULL,
  `update_by` datetime(0) NULL DEFAULT NULL,
  `enabled` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (111, 'admin', '管理员', '$2a$10$LqpYDVLEza5OX8MDWnBxzeF2ZJwpXdHQrIG86QdO3eNbaAnWOK2Qa', 'http://imgsrc.baidu.com/forum/w=580/sign=259ce8d5252dd42a5f0901a3333a5b2f/71bb3cce36d3d53944b6b27f3a87e950342ab051.jpg', '2020-12-22 20:48:26', NULL, 1);
INSERT INTO `sys_user` VALUES (112, 'zs', '张三', '$2a$10$LqpYDVLEza5OX8MDWnBxzeF2ZJwpXdHQrIG86QdO3eNbaAnWOK2Qa', NULL, '2020-12-26 09:32:42', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role_rel
-- ----------------------------
INSERT INTO `sys_user_role_rel` VALUES (1, 111, 1, 1);
INSERT INTO `sys_user_role_rel` VALUES (2, 112, 2, 1);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NULL DEFAULT NULL,
  `order_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `order_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` int(11) NULL DEFAULT NULL,
  `total_price` decimal(10, 2) NULL DEFAULT NULL,
  `actual_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实际支付',
  `product_num` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `order_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_type` int(4) NULL DEFAULT NULL COMMENT '支付类型 1 支付宝  ； 2微信支付',
  `status` int(4) NULL DEFAULT NULL COMMENT '0 未付款 ；1已付款',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (3, NULL, '产品名称', 'd8c947b3-86fd-4214-9603-33b398b3cdd9', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-05 12:18:49', NULL);
INSERT INTO `t_order` VALUES (4, NULL, '产品名称', '966f921c-5902-48f2-adb6-ccfa61b7c184', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-05 12:24:00', NULL);
INSERT INTO `t_order` VALUES (5, NULL, '产品名称', 'fc0f6141-35e5-45af-8613-5aead157b1dc', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-05 12:28:58', NULL);
INSERT INTO `t_order` VALUES (6, NULL, '产品名称', '65cb6363-09fc-4a16-8267-2c97d7031ffb', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-05 12:30:17', NULL);
INSERT INTO `t_order` VALUES (7, NULL, '产品名称', '858cc04d-2eb9-4ce1-a430-0cca6207c463', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-05 12:31:55', NULL);
INSERT INTO `t_order` VALUES (8, NULL, '产品名称', 'b352df18-43f9-4d40-9c5c-1ac66e224e40', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-07 17:16:54', NULL);
INSERT INTO `t_order` VALUES (9, NULL, '产品名称', '10a5edaf-ec13-4bb5-b5df-24afed1b194d', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-09 17:55:27', NULL);
INSERT INTO `t_order` VALUES (10, NULL, '产品名称', 'c8a7547c-570d-425c-8977-b05f7719d0c6', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-09 17:56:18', NULL);
INSERT INTO `t_order` VALUES (11, NULL, '产品名称', '67896481-3bef-49c3-b9e0-c8bf79454843', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-09 17:56:44', NULL);
INSERT INTO `t_order` VALUES (12, NULL, '产品名称', '5b2d3479-31ca-4fa3-a99e-2e3e9ff1c60e', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-09 17:58:22', NULL);
INSERT INTO `t_order` VALUES (13, NULL, '产品名称', '1401a3f6-bed0-4c5a-8e9b-0212d5a55d0b', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-09 17:58:40', NULL);
INSERT INTO `t_order` VALUES (14, NULL, '产品名称', 'b22f7684-45f2-46a3-9bfe-4ac4f11219c7', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-10 09:25:39', NULL);
INSERT INTO `t_order` VALUES (15, NULL, '产品名称', '66c8735b-e792-439f-9987-dee1ea319036', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-10 09:26:02', NULL);
INSERT INTO `t_order` VALUES (16, NULL, '产品名称', 'fec46b50-b6a8-4b14-8e0d-a440e5eaab1c', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-10 09:57:50', NULL);
INSERT INTO `t_order` VALUES (17, NULL, '产品名称', 'b695f884-ab87-4323-8675-64e2bb10b73d', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-10 09:59:15', NULL);
INSERT INTO `t_order` VALUES (18, NULL, '产品名称', 'dff3da58-7dc6-4bea-bf59-7da3857303b1', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-10 10:01:46', NULL);
INSERT INTO `t_order` VALUES (19, NULL, '产品名称', '5af76eca-477f-4cc3-a83b-fb70604fb303', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2020-12-10 10:04:02', NULL);
INSERT INTO `t_order` VALUES (20, NULL, '产品名称', '49d472a6-e999-4e7e-b5fc-97055a37db42', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-01-01 17:26:15', NULL);
INSERT INTO `t_order` VALUES (21, NULL, '产品名称', 'dfb55d7f-b538-4b32-a74d-57aba15c64f3', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-22 09:54:53', NULL);
INSERT INTO `t_order` VALUES (22, NULL, '产品名称', 'bc2819ba-d3aa-4370-898a-fa32f4e06e21', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 17:47:07', NULL);
INSERT INTO `t_order` VALUES (23, NULL, '产品名称', '6ce48fb1-61b5-475e-a051-1a0355adb7d4', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:47:05', NULL);
INSERT INTO `t_order` VALUES (24, NULL, '产品名称', '8d12a96a-56cd-4936-9689-d3668e38eb6a', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:47:11', NULL);
INSERT INTO `t_order` VALUES (25, NULL, '产品名称', '0b924c7c-3972-4693-925c-895fd892c839', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:47:51', NULL);
INSERT INTO `t_order` VALUES (26, NULL, '产品名称', 'ff9a41b9-91e4-481d-af23-ae45cf63a27a', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:48:04', NULL);
INSERT INTO `t_order` VALUES (27, NULL, '产品名称', 'c0fa8868-ef05-4435-8b8d-596c35aa1754', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:49:35', NULL);
INSERT INTO `t_order` VALUES (28, NULL, '产品名称', '02f37072-ee25-4543-8eef-a9a39ebc1742', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:50:33', NULL);
INSERT INTO `t_order` VALUES (29, NULL, '产品名称', 'e8377966-66c1-4d64-8853-0c6585942b0c', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:50:37', NULL);
INSERT INTO `t_order` VALUES (30, NULL, '产品名称', 'd01b2fba-0fa0-4965-be9e-7ef51912e7cc', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:57:07', NULL);
INSERT INTO `t_order` VALUES (31, NULL, '产品名称', 'f97f8d6e-8839-4248-b37f-b426b2eac939', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 19:57:25', NULL);
INSERT INTO `t_order` VALUES (32, NULL, '产品名称', '8ed601a3-32c8-48b6-91d4-6fed067a8e73', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:04:20', NULL);
INSERT INTO `t_order` VALUES (33, NULL, '产品名称', '7cab58c6-4845-42b0-bc80-7b079aee2f4e', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:05:23', NULL);
INSERT INTO `t_order` VALUES (34, NULL, '产品名称', '69277bcf-2857-4bf6-a63f-73b9b8679f66', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:07:25', NULL);
INSERT INTO `t_order` VALUES (35, NULL, '产品名称', '61c871c3-024b-46bc-8639-a3e074e91b9d', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:17:13', NULL);
INSERT INTO `t_order` VALUES (36, NULL, '产品名称', '046dd2e4-64d4-4c4b-a995-25a679589867', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:19:50', NULL);
INSERT INTO `t_order` VALUES (37, NULL, '产品名称', '86f07f95-2236-4e93-a309-629d30c715ff', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:23:22', NULL);
INSERT INTO `t_order` VALUES (38, NULL, '产品名称', '1af397d7-d597-4583-8ea6-d0fb679003cb', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:23:24', NULL);
INSERT INTO `t_order` VALUES (39, NULL, '产品名称', '09fe659b-4cdd-459e-b69d-66a534269613', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:23:47', NULL);
INSERT INTO `t_order` VALUES (40, NULL, '产品名称', 'c98a6ab6-6b44-4ca8-b297-d67ce5129a59', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:26:00', NULL);
INSERT INTO `t_order` VALUES (41, NULL, '产品名称', '999a612c-c273-4798-a581-0dd411817a21', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:27:58', NULL);
INSERT INTO `t_order` VALUES (42, NULL, '产品名称', '0171c28c-d719-4d99-b86c-69610a4dd0d7', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:30:54', NULL);
INSERT INTO `t_order` VALUES (43, NULL, '产品名称', '7756b5a6-a86a-4982-a1e2-e7015f71abeb', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:33:24', NULL);
INSERT INTO `t_order` VALUES (44, NULL, '产品名称', 'd3695094-a1c5-4965-9b6e-25eb6ce66ca7', NULL, NULL, 10.00, NULL, '', 1, 0, NULL, '2021-02-26 20:34:47', NULL);

-- ----------------------------
-- Table structure for tb_seckill_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_seckill_goods`;
CREATE TABLE `tb_seckill_goods`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spu_id` bigint(20) NULL DEFAULT NULL COMMENT 'spu ID',
  `sku_id` bigint(20) NULL DEFAULT NULL COMMENT 'sku ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `small_pic` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '原价格',
  `cost_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '秒杀价格',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '添加日期',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '审核日期',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态，0未审核，1审核通过，2审核不通过',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `num` int(11) NULL DEFAULT NULL COMMENT '秒杀商品数',
  `stock_count` int(11) NULL DEFAULT NULL COMMENT '剩余库存数',
  `introduction` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_seckill_goods
-- ----------------------------
INSERT INTO `tb_seckill_goods` VALUES (1, 10049901, 500, '索尼（SONY）WH-1000XM3', 'https://img10.360buyimg.com/n7/jfs/t1/132549/13/7602/50860/5f3e4926E8dc899e7/ea99eabb3dba7ad1.jpg', 99.00, 49.00, '2021-02-22 18:34:25', NULL, '1', '2021-02-22 08:00:00', '2021-04-01 22:00:00', 10, 22, NULL);
INSERT INTO `tb_seckill_goods` VALUES (2, 100022101, 600, 'AirPods', 'https://img1.360buyimg.com/n6/jfs/t1/61017/23/2106/150319/5d07495cE8d404476/bbe3d3abb0ee44c2.png', 552.00, 421.00, '2021-02-22 18:34:25', NULL, '1', '2021-02-22 08:00:00', '2021-04-01 22:00:00', 12, 26, NULL);
INSERT INTO `tb_seckill_goods` VALUES (3, 100112801, 400, '坚果 R2', 'https://resource.smartisan.com/resource/623bad86546352a2035ec704e2faf041.png?x-oss-process=image/resize,w_270/format,webp', 4799.00, 4299.00, '2021-02-22 20:43:56', NULL, '1', '2021-02-22 08:00:00', '2021-04-01 22:00:00', 4, 24, NULL);
INSERT INTO `tb_seckill_goods` VALUES (4, 100810001, NULL, 'Smartisan TNT 大满足套装', 'https://resource.smartisan.com/resource/79c58355d2f5fd53988684b96d405f9b.png?x-oss-process=image/resize,w_270/format,webp', 6999.00, 5999.00, '2021-02-22 20:47:25', NULL, '1', '2021-02-22 08:00:00', '2021-04-01 22:00:00', 3, 13, NULL);

-- ----------------------------
-- Table structure for tb_seckill_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_seckill_order`;
CREATE TABLE `tb_seckill_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `seckill_id` bigint(20) NULL DEFAULT NULL COMMENT '秒杀商品ID',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态，0未支付，1已支付',
  `receiver_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人地址',
  `receiver_mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人电话',
  `receiver` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货人',
  `transaction_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易流水',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 159 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_seckill_order
-- ----------------------------
INSERT INTO `tb_seckill_order` VALUES (151, 100112801, 4299.00, '1', '2021-02-26 19:00:00', NULL, '1', NULL, NULL, NULL, '1365255335182393344');
INSERT INTO `tb_seckill_order` VALUES (152, 100112801, 4299.00, '1', '2021-02-26 19:49:00', NULL, '1', NULL, NULL, NULL, '1365267743229665280');
INSERT INTO `tb_seckill_order` VALUES (153, 100112801, 4299.00, '1', '2021-02-26 19:57:00', NULL, '1', NULL, NULL, NULL, '1365269651239526400');
INSERT INTO `tb_seckill_order` VALUES (154, 100112801, 4299.00, '1', '2021-02-26 20:05:00', NULL, '1', NULL, NULL, NULL, '1365271723439611904');
INSERT INTO `tb_seckill_order` VALUES (155, 100112801, 4299.00, '1', '2021-02-26 20:15:00', NULL, '1', NULL, NULL, NULL, '1365274405583773696');
INSERT INTO `tb_seckill_order` VALUES (156, 100112801, 4299.00, '1', '2021-02-26 20:17:00', NULL, '1', NULL, NULL, NULL, '1365274711944126464');
INSERT INTO `tb_seckill_order` VALUES (157, 100112801, 4299.00, '1', '2021-02-26 20:23:00', NULL, '1', NULL, NULL, NULL, '1365276360787943424');
INSERT INTO `tb_seckill_order` VALUES (158, 100112801, 4299.00, '1', '2021-02-26 20:30:00', NULL, '1', NULL, NULL, NULL, '1365278146366070784');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pay_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'M男 或 F 女',
  `birth_date` datetime(0) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态1 有效 0 无效',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '例如 2020-09-11',
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', 'zs', '123', 'aa@sina.com', '12345678', '123456', NULL, '1', '2015-01-01 19:01:09', 1, '2020-11-26 19:01:37', NULL);

SET FOREIGN_KEY_CHECKS = 1;
