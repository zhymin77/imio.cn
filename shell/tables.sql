/**
 * create for Blog.
 */
CREATE TABLE IF NOT EXISTS tb_blog(
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  timestamp int(11),
  type char(10),
  title char(30),
  brief char(250),
  review int(6) NOT NULL DEFAULT 0,
  data blob
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/**
 * create for Comment.
 */
CREATE TABLE IF NOT EXISTS tb_comment(
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  blogId int(11),
  userId int(11),
  timestamp int(11),
  content char(255) NOT NULL DEFAULT '',
  parentId int(11),
  username char(50) NOT NULL DEFAULT '',
  email char(50) NOT NULL DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/**
 * create for trace.
 */
CREATE TABLE IF NOT EXISTS tb_trace(
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  blogId int(11),
  timestamp int(11),
  ip char(20)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
