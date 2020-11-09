package edu.cnm.deepdive.galaxyraiders.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.galaxyraiders.model.dao.GameDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import edu.cnm.deepdive.galaxyraiders.model.pojo.GameWithUser;
import io.reactivex.Completable;
import java.util.List;

public class GameRepository {
  
  private final Context context;
  
  private final GameDao gameDao;


  public GameRepository(Context context) {
    this.context = context;
    gameDao = GalaxyDatabase.getInstance().getGameDao();
  }

  public Completable save(Game game) {
    return (game.getGameId() == 0)
        ? gameDao.insert(game)
        .doAfterSuccess(game::setGameId)
        .ignoreElement()
        : gameDao.update(game)
            .ignoreElement();
  }
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
