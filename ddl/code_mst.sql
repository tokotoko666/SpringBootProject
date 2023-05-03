DROP TABLE IF EXISTS
    `code_mst`;
CREATE TABLE `code_mst`(
    `torihiki_code` VARCHAR(5) PRIMARY KEY COMMENT '取引コード',
    `torihiki_name` VARCHAR(64) NOT NULL COMMENT '取引名称'
) comment='コードマスタテーブル' ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;