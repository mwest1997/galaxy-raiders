package edu.cnm.deepdive.galaxyraiders.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.galaxyraiders.model.dao.UserDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import edu.cnm.deepdive.galaxyraiders.model.pojo.UserWithGames;
import io.reactivex.Completable;
import io.reactivex.Maybe;

public class UserRepository {

  private final Context context;

  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    userDao = GalaxyDatabase.getInstance().getUserDao();
  }

  public Completable save(User user) {
    return (user.getId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement();
  }
  public Completable delete(User user) {
    return (user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement();
  }

  LiveData<User> getById(long userId) {
    return userDao.getById(userId);
  }

  LiveData<UserWithGames> getByIdWithGames(long userId) {
    return userDao.getByIdWithGames(userId);
  }

  Maybe<User> getByOauthKey(String oauthKey){
    return userDao.getByOauthKey(oauthKey);
  }

}
