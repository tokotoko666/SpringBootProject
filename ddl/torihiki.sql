DROP TABLE IF EXISTS
    `torihiki`;
CREATE TABLE `torihiki`(
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `torihiki_code` VARCHAR(5) NOT NULL COMMENT '取引コード',
    `torihiki_gaiyou` VARCHAR(256) DEFAULT NULL COMMENT '取引概要',
    `amount` INT(8) DEFAULT NULL COMMENT '金額',
    `tax` DECIMAL(3,3) DEFAULT NULL COMMENT '税'
) comment='取引テーブル' ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;