CREATE TABLE IF NOT EXISTS `User`
(
    `user_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key` TEXT                              NOT NULL,
    `level`     INTEGER                           NOT NULL,
    `created`   INTEGER                           NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_User_oauth_key` ON `User` (`oauth_key`);

CREATE INDEX IF NOT EXISTS `index_User_created` ON `User` (`created`);

CREATE TABLE IF NOT EXISTS `Game`
(
    `game_id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `ship_type`   INTEGER                           NOT NULL,
    `weapon_type` INTEGER                           NOT NULL,
    `user_id`     INTEGER                           NOT NULL,
    `score`       INTEGER                           NOT NULL,
    `created`     INTEGER                           NOT NULL,
    `completed`   INTEGER                           NOT NULL,
    `game_mode`   INTEGER,
    FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE INDEX IF NOT EXISTS `index_Game_score` ON `Game` (`score`);

CREATE INDEX IF NOT EXISTS `index_Game_user_id` ON `Game` (`user_id`);
