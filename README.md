# grboard
자바 스프링으로 만든 연습용 게시판.

## 환경
- jdk 8
- gradle
- spring boot 1.2.3
- mysql 5.6
- intellij

### 데이터베이스
mysql

```sql
CREATE TABLE `article` (
  `articleid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(300) DEFAULT NULL,
  `contents` text,
  `likecount` int(11) DEFAULT '0',
  `hatecount` int(11) DEFAULT '0',
  `hitcount` int(11) DEFAULT '0',
  `regdttm` datetime DEFAULT NULL,
  PRIMARY KEY (`articleid`),
  KEY `idx_article_regdttm` (`regdttm`)
) ENGINE=InnoDB AUTO_INCREMENT=100093 DEFAULT CHARSET=utf8;
```
pull request by hs9923 // 테스트
