# Host: localhost  (Version: 5.5.8)
# Date: 2020-07-30 09:29:58
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "tb_absensi"
#

DROP TABLE IF EXISTS `tb_absensi`;
CREATE TABLE `tb_absensi` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nip` varchar(20) DEFAULT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `tanggal` date DEFAULT '0000-00-00',
  `masuk` varchar(20) DEFAULT NULL,
  `pulang` varchar(20) DEFAULT NULL,
  `ket` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

#
# Data for table "tb_absensi"
#

INSERT INTO `tb_absensi` VALUES (1,'n112211','Eww','2020-04-20','08:00','17:00','IZIN'),(2,'n112211','Eww','2020-04-20','08:00','17:00','HADIR'),(3,'n112211','Eww','2020-05-27','08:00','17:00','SAKIT'),(4,'12211244444','Sonia','2020-07-01','08:00','17:00','IZIN'),(5,'12211244444','Sonia','2020-07-02','08:00','17:00','HADIR');

#
# Structure for table "tb_bagian"
#

DROP TABLE IF EXISTS `tb_bagian`;
CREATE TABLE `tb_bagian` (
  `idbagian` varchar(20) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idbagian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_bagian"
#

INSERT INTO `tb_bagian` VALUES ('D0001','KEAGAMAAN'),('D0002','KEUANGAN');

#
# Structure for table "tb_pegawai"
#

DROP TABLE IF EXISTS `tb_pegawai`;
CREATE TABLE `tb_pegawai` (
  `nip` varchar(20) NOT NULL DEFAULT '',
  `nama` varchar(50) DEFAULT NULL,
  `tanggal` date DEFAULT '0000-00-00',
  `pekerjaan` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `agama` varchar(30) DEFAULT NULL,
  `idbagian` varchar(20) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nip`),
  KEY `idbagian` (`idbagian`),
  CONSTRAINT `tb_pegawai_ibfk_1` FOREIGN KEY (`idbagian`) REFERENCES `tb_bagian` (`idbagian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_pegawai"
#

INSERT INTO `tb_pegawai` VALUES ('111qqq','aaa','2020-04-17','PNS','KAWIN','ISLAM','D0001','Ganet'),('12211244444','Sonia','1995-07-03','PNS','BELUM KAWIN','ISLAM','D0001','Batu 9'),('n112211','Eww','2020-07-06','PNS','BELUM KAWIN','ISLAM','D0002','Batu 9');
