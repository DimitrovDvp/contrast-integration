CREATE DATABASE IF NOT EXISTS contrast_db;
USE contrast_db;

#TABLE DEFINITIONS
CREATE TABLE IF NOT EXISTS `organization` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `platform` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `application` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `organization_id` bigint NOT NULL,
  `platform_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`platform_id`) REFERENCES `platform` (`id`),
  FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


#POPULATE SAMPLE DATA
INSERT INTO organization (name) VALUES ("Mentormate");
INSERT INTO organization (name) VALUES ("Contrast-Security");

INSERT INTO platform (name) VALUES ("DevsMM");
INSERT INTO platform (name) VALUES ("Integration");

INSERT INTO application (name, organization_id, platform_id) VALUES ("CharityMate", 3, 3);
INSERT INTO application (name, organization_id, platform_id) VALUES ("Mentornet", 3, 3);
INSERT INTO application (name, organization_id, platform_id) VALUES ("ChronoMate", 3, 3);
INSERT INTO application (name, organization_id, platform_id) VALUES ("Inveni", 3, 3);

INSERT INTO application (name, organization_id, platform_id) VALUES ("Jenkins-Integration", 4, 4);
INSERT INTO application (name, organization_id, platform_id) VALUES ("Slack-Integration", 4, 4);
INSERT INTO application (name, organization_id, platform_id) VALUES ("Heroku-Integration", 4, 4);