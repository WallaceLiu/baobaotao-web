CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `t_auth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `erp` varchar(50) DEFAULT NULL,
  `object_id` bigint(20) DEFAULT NULL,
  `object_type` bigint(20) DEFAULT NULL,
  `object_name` varchar(50) DEFAULT NULL,
  `op` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8
