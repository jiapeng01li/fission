-- 分销商表
CREATE TABLE `fission_distributor` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `tracing` varchar(128) NOT NULL COMMENT '追踪信息',
  `display_type` varchar(32) NOT NULL COMMENT '展示类型:B端、C端、PU、会员、大促...',
  `materiel_id` bigint(11) NOT NULL COMMENT '配置的物料id',
  `agency_type` varchar(32) NOT NULL COMMENT '分销机构类型,目前只有用户,考虑后面扩展机构分销等',
  `agency_id` varchar(32) NOT NULL COMMENT '分销机构id,对于用户类型就是member_id',
  `qrcode_url` varchar(200) DEFAULT NULL COMMENT '二维码url',
  `qrcode_content` varchar(200) DEFAULT NULL COMMENT '二维码内容',
  `expire_timestamp` bigint(20) DEFAULT NULL COMMENT '结束时间',
  `poster_url` varchar(256) DEFAULT NULL COMMENT '海报图url',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_tracing` (`tracing`),
  UNIQUE KEY `idx_materiel_id_agency_id_agency_type` (`materiel_id`,`agency_id`,`agency_type`),
  KEY `idx_agency` (`agency_id`,`agency_type`),
  KEY `idx_created_at` (`created_at`),
  KEY `idx_updated_at` (`updated_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销商信息表';

-- 分销收益表
CREATE TABLE `fission_earnings` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `trade_number` varchar(64) NOT NULL COMMENT '交易单号',
  `distributor_id` bigint(11) NOT NULL COMMENT '分销商id',
  `distributor_agency_type` varchar(32) NOT NULL COMMENT '分销机构类型',
  `distributor_agency_id` varchar(32) NOT NULL COMMENT '分销机构id',
  `buyer_member_id` bigint(20) NOT NULL COMMENT '购买者member_id',
  `display_type` varchar(32) NOT NULL COMMENT '展示类型',
  `settlement_type` varchar(32) NOT NULL COMMENT '结算类型',
  `settlement_status` varchar(32) NOT NULL COMMENT '结算状态',
  `earnings` text NOT NULL COMMENT '所赚取的收益,包括现金、赠品等',
  `materiel_id` bigint(11) DEFAULT NULL COMMENT '分销物料id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_trade_number` (`trade_number`),
  KEY `idx_distributor_id` (`distributor_id`),
  KEY `idx_distributor` (`distributor_agency_id`,`distributor_agency_type`),
  KEY `idx_materiel_id` (`materiel_id`),
  KEY `idx_created_at` (`created_at`),
  KEY `idx_updated_at` (`updated_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销收益表';