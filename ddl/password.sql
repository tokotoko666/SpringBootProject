DROP TABLE IF EXISTS
    `password`;
CREATE TABLE `password`(
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'ID',
    `account_id` VARCHAR(16) NOT NULL COMMENT 'アカウントID',
    `password` VARCHAR(64) NOT NULL COMMENT 'パスワード'
) comment='パスワードテーブル' ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;