package edu.cnm.deepdive.galaxyraiders.service;

import android.content.Context;
import edu.cnm.deepdive.galaxyraiders.model.dao.GameDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.Game;
import io.reactivex.Completable;

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


}
