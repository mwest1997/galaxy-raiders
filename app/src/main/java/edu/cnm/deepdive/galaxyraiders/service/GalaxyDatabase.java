package edu.cnm.deepdive.galaxyraiders.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.galaxyraiders.model.dao.GameDao;
import edu.cnm.deepdive.galaxyraiders.model.dao.UserDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import edu.cnm.deepdive.galaxyraiders.service.GalaxyDatabase.Converters;
import java.util.Date;

/**
 * An instance of the database of the app.
 */
@Database(entities = {User.class, Game.class}, version = 1)
@TypeConverters({Converters.class, Game.GameMode.class})
public abstract class GalaxyDatabase extends RoomDatabase {

  private static final String DB_NAME = "galaxy_db";

  private static Application context;

  /**
   * Sets the context.
   */
  public static void setContext(Application context) {
    GalaxyDatabase.context = context;
  }

  /**
   * Gets the instance.
   */
  public static GalaxyDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets the {@link GameDao}
   */
  public abstract GameDao getGameDao();

  /**
   * Gets the {@link UserDao}
   */
  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final GalaxyDatabase INSTANCE =
        Room.databaseBuilder(context, GalaxyDatabase.class, DB_NAME)
            .build();

  }

  /**
   * Converts dates and longs.
   */
  public static class Converters {

    /**
     * Converts a date to a Long.
     * @param created The date created.
     * @return Returns the created time.
     */
    @TypeConverter
    public static Long dateToLong(Date created) {
      return (created != null) ? created.getTime() : null;
    }

    /**
     * Converts a Long to date.
     * @param created The Long created.
     * @return Returns the date created.
     */
    @TypeConverter
    public static Date longToDate(Long created) {
      return (created != null) ? new Date(created) : null;
    }

  }

}
