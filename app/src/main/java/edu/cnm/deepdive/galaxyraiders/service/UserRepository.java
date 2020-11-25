package edu.cnm.deepdive.galaxyraiders.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.galaxyraiders.model.dao.UserDao;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import edu.cnm.deepdive.galaxyraiders.model.pojo.UserWithGames;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;

public class UserRepository {

  private final Context context;

  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    userDao = GalaxyDatabase.getInstance().getUserDao();
  }

  @SuppressWarnings("ConstantConditions")
  public Single<User> createUser(@NonNull GoogleSignInAccount account) {
    return Single.fromCallable(() -> {
      User user = new User();
      user.setCreated(new Date());
      user.setOauthKey(account.getId());
      return user;
    })
        .flatMap((user) ->
            userDao.insert(user)
                .map((id) -> {
                  if (id > 0) {
                    user.setId(id);
                  }
                  return user;
                })
        )
        .subscribeOn(Schedulers.io());
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
