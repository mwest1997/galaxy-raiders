package edu.cnm.deepdive.galaxyraiders.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import edu.cnm.deepdive.galaxyraiders.model.dao.GameDao;
import edu.cnm.deepdive.galaxyraiders.model.dao.UserDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import java.util.Date;

@Database(entities = {User.class, Game.class}, version = 1)
public abstract class GalaxyDatabase extends RoomDatabase {

  private static final String DB_NAME = "galaxy_db";

  private static Application context;

  public static void setContext(Application context) {
    GalaxyDatabase.context = context;
  }

  public abstract GameDao getGameDao();

  public abstract UserDao getUserDao();

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date created) {
      return (created != null) ? created.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long created) {
      return (created != null) ? new Date(created) : null;
    }

  }

}
