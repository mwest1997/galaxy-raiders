package edu.cnm.deepdive.galaxyraiders.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import java.util.Date;

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

  public long getGameId() {
    return gameId;
  }

  public void setGameId(long gameId) {
    this.gameId = gameId;
  }

  public int getShipType() {
    return shipType;
  }

  public void setShipType(int shipType) {
    this.shipType = shipType;
  }

  public int getWeaponType() {
    return weaponType;
  }

  public void setWeaponType(int weaponType) {
    this.weaponType = weaponType;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public GameMode getGameMode() {
    return gameMode;
  }

  public void setGameMode(GameMode gameMode) {
    this.gameMode = gameMode;
  }

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
