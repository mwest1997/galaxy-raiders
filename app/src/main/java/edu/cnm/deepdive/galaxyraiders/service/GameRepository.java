package edu.cnm.deepdive.galaxyraiders.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.galaxyraiders.model.dao.GameDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.pojo.GameWithUser;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * The repository for games.
 */
public class GameRepository {
  
  private final Context context;
  
  private final GameDao gameDao;

  /**
   * Context of the {@link GameRepository}
   * @param context context of this repository.
   */
  public GameRepository(Context context) {
    this.context = context;
    gameDao = GalaxyDatabase.getInstance().getGameDao();
  }

  /**
   * Saves the current game.
   * @param game Reference to the {@link Game}.
   * @return Returns game id.
   */
  public Completable save(Game game) {
    return (game.getGameId() == 0)
        ? gameDao.insert(game)
        .doAfterSuccess(game::setGameId)
        .ignoreElement()
        : gameDao.update(game)
            .ignoreElement();
  }

  /**
   * Deletes the current game.
   * @param game Reference to the {@link Game}
   * @return Returns game id.
   */
  public Completable delete(Game game) {
    return (game.getGameId() == 0)
        ? Completable.complete()
        : gameDao.delete(game)
            .ignoreElement();
  }

  LiveData<Game> getGameById(long gameId) {
    return gameDao.getById(gameId);
  }

  LiveData<List<GameWithUser>> getHighScores(int limit) {
    return gameDao.getHighScores(limit);
  }

}
