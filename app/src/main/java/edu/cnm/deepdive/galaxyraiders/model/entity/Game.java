package edu.cnm.deepdive.galaxyraiders.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import java.util.Date;

/**
 * Creates a database for games.
 */
@Entity(
    indices = {
        @Index(value = {"score"})
    },
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = {"user_id"}, childColumns = {"user_id"}
        )
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long gameId;

  @NonNull
  @ColumnInfo(name = "ship_type")
  private int shipType;

  @NonNull
  @ColumnInfo(name = "weapon_type")
  private int weaponType;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  private int score;

  @NonNull
  private Date created;

  private boolean completed;

  @ColumnInfo(name = "game_mode")
  private GameMode gameMode;

  /**
   * Gets the game id.
   */
  public long getGameId() {
    return gameId;
  }

  /**
   * Sets the game id.
   */
  public void setGameId(long gameId) {
    this.gameId = gameId;
  }

  /**
   * Gets the ship type.
   */
  public int getShipType() {
    return shipType;
  }

  /**
   * Sets the ship type.
   */
  public void setShipType(int shipType) {
    this.shipType = shipType;
  }

  /**
   * Gets the weapon type.
   */
  public int getWeaponType() {
    return weaponType;
  }

  /**
   * Sets the weapon type.
   */
  public void setWeaponType(int weaponType) {
    this.weaponType = weaponType;
  }

  /**
   * Gets the user id.
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the user id.
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Gets the score.
   */
  public int getScore() {
    return score;
  }

  /**
   * Sets the score.
   */
  public void setScore(int score) {
    this.score = score;
  }

  /**
   * Gets the created game.
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the created game.
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * Checks whether a game is completed or not.
   * @return Returns completed games.
   */
  public boolean isCompleted() {
    return completed;
  }

  /**
   * Sets completed game.
   */
  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  /**
   * Gets the game mode.
   */
  public GameMode getGameMode() {
    return gameMode;
  }

  /**
   * Sets the game mode.
   */
  public void setGameMode(GameMode gameMode) {
    this.gameMode = gameMode;
  }

  /**
   * Determines the game mode.
   */
  public enum GameMode {
    CAMPAIGN, SURVIVAL;

    @TypeConverter
    public static Integer gameModeToInt(GameMode value) {
      return (value != null ? value.ordinal() : null);
    }

    @TypeConverter
    public static GameMode intToGameMode(Integer value) {
      return (value != null ? GameMode.values()[value] : null);
    }

  }

}
