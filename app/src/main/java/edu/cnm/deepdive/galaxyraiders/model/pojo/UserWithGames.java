package edu.cnm.deepdive.galaxyraiders.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import java.util.List;

/**
 * Pojo for Users with their games.
 */
public class UserWithGames extends User {

  @Relation(
      entity = Game.class,
      entityColumn = "user_id",
      parentColumn = "user_id"
  )
  private List<Game> games;

  /**
   * Gets the current {@link Game}.
   */
  public List<Game> getGames() {
    return games;
  }

  /**
   * Sets the current {@link Game}.
   */
  public void setGames(List<Game> games) {
    this.games = games;
  }

}
