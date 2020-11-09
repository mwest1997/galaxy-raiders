package edu.cnm.deepdive.galaxyraiders.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;

public class GameWithUser extends Game {

  @Relation(
      entity = User.class,
      entityColumn = "user_id",
      parentColumn = "user_id"
  )
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
