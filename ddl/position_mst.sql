DROP TABLE IF EXISTS
    `position_mst`;
CREATE TABLE `position_mst`(
    `code` VARCHAR(5) PRIMARY KEY COMMENT 'ポジションコード',
    `name` VARCHAR(64) NOT NULL COMMENT 'ポジション名'
) comment='ポジションマスタテーブル' ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;