DROP TABLE IF EXISTS
    `account`;
CREATE TABLE `account`(
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `account_id` VARCHAR(16) NOT NULL COMMENT 'アカウントID',
    `last_name` VARCHAR(8) NOT NULL COMMENT '苗字',
    `first_name` VARCHAR(8) NOT NULL COMMENT '名前',
    `age` INT(3) NOT NULL COMMENT '年齢',
    `position_code` VARCHAR(5) NOT NULL COMMENT 'ポジション',
    `address` VARCHAR(256) DEFAULT NULL COMMENT '住所',
    `comment` VARCHAR(256) DEFAULT NULL COMMENT 'コメント'
) comment='アカウントテーブル' ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;