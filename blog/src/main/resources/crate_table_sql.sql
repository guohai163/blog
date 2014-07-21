CREATE TABLE `blog`.`gh_posts` (
  `code` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_date` DATETIME NOT NULL,
  `post_title` VARCHAR(200) NOT NULL,
  `post_content` TEXT NOT NULL,
  `post_status` VARCHAR(45) NOT NULL,
  `post_small_name` VARCHAR(50) NULL,
  PRIMARY KEY (`code`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


CREATE TABLE `blog`.`gh_user` (
  `code` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(200) NOT NULL,
  `pass_word` VARCHAR(200) NOT NULL,
  `pass_key` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`code`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;
