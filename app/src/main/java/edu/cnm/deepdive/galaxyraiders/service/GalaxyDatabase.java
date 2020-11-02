package edu.cnm.deepdive.galaxyraiders.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.galaxyraiders.model.dao.GameDao;
import edu.cnm.deepdive.galaxyraiders.model.dao.UserDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import edu.cnm.deepdive.galaxyraiders.service.GalaxyDatabase.Converters;
import java.util.Date;

@Database(entities = {User.class, Game.class}, version = 1)
@TypeConverters({Converters.class, Game.GameMode.class})
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
