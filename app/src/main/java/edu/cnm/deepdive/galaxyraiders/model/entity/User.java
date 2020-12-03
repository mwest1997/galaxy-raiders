package edu.cnm.deepdive.galaxyraiders.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * Creates a database for users.
 */
@Entity(
    indices = {
        @Index(value = {"oauth_key"}, unique = true)
    }
)
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "oauth_key")
  private String oauthKey;

  private int level;

  @NonNull
  @ColumnInfo(index = true)
  private Date created = new Date();

  /**
   * Gets the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the oauthKey.
   */
  @NonNull
  public String getOauthKey() {
    return oauthKey;
  }

  /**
   * Sets the oauthKey.
   */
  public void setOauthKey(@NonNull String oauthKey) {
    this.oauthKey = oauthKey;
  }

  /**
   * Gets the current level.
   */
  public int getLevel() {
    return level;
  }

  /**
   * Sets the current level.
   */
  public void setLevel(int level) {
    this.level = level;
  }

  /**
   * Gets the created user.
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the created user.
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }
}
