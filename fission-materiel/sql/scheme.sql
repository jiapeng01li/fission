-- 分销物料表
CREATE TABLE `fission_materiel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL COMMENT '名称',
  `origin_poster_url` varchar(512) DEFAULT NULL COMMENT '海报原图地址',
  `landing_page_url` varchar(512) DEFAULT NULL COMMENT '落地页地址',
  `start_time` datetime NOT NULL COMMENT '开始时间',
  `stop_time` datetime NOT NULL COMMENT '结束时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否公开，0->不公开，1->公开',
  `materiel_type` varchar(32) NOT NULL COMMENT '物料类型:目前只有sku',
  `display_type` varchar(32) NOT NULL COMMENT '展示类型:B端、C端、PU、会员...',
  `settlement_type` varchar(32) NOT NULL COMMENT '结算类型:实时结算、财务定期人工结算...',
  `items` text NOT NULL COMMENT '物料具体条目(JSON)',
  `extra` text COMMENT '额外信息(JSON)',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `sku_id` varchar(64) DEFAULT NULL COMMENT '分销商品id,仅针对单sku分销有效,方便查询',
  `reward_count_limit` int(10) DEFAULT NULL COMMENT '奖励次数限制',
  PRIMARY KEY (`id`),
  KEY `idx_display_type` (`display_type`),
  KEY `idx_created_at` (`created_at`),
  KEY `idx_updated_at` (`updated_at`),
  KEY `idx_sku_id` (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分销物料表';
