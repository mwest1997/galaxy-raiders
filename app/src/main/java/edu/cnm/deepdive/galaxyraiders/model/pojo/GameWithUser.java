package edu.cnm.deepdive.galaxyraiders.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;

/**
 * Pojo for games with their users.
 */
public class GameWithUser extends Game {

  @Relation(
      entity = User.class,
      entityColumn = "user_id",
      parentColumn = "user_id"
  )
  private User user;

  /**
   * Gets the current {@link User}.
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets the current {@link User}
   */
  public void setUser(User user) {
    this.user = user;
  }

}
