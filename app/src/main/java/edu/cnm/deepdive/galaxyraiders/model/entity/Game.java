package edu.cnm.deepdive.galaxyraiders.model.entity;

import android.service.autofill.FieldClassification.Match;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    indices = {
        @Index(value = {"score"})
    },
    foreignKeys = {
        @ForeignKey(
            entity = Match.class,
            parentColumns = {"user_id"}, childColumns = {"user_id"}
        )
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "custom_id")
  private int customisationId;

  @NonNull
  @ColumnInfo(name = "ship_type")
  private int shipType;

  @NonNull
  @ColumnInfo(name = "weapon_type")
  private int weaponType;

  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(index = true)
  private Integer score;

  @NonNull
  private Date created;

  private boolean completed;

  public int getCustomisationId() {
    return customisationId;
  }

  public void setCustomisationId(int customisationId) {
    this.customisationId = customisationId;
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
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

  private Enum mode;

}
