package edu.cnm.deepdive.galaxyraiders.service;

import android.content.Context;
import edu.cnm.deepdive.galaxyraiders.model.dao.UserDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import io.reactivex.Completable;

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

}
