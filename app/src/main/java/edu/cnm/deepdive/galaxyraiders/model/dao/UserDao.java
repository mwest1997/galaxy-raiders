package edu.cnm.deepdive.galaxyraiders.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.galaxyraiders.model.entity.User;
import edu.cnm.deepdive.galaxyraiders.model.pojo.UserWithGames;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * Manages the connection with the user data source.
 */
@Dao
public interface UserDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  Single<Long> insert(User user);

  @Insert
  Single<List<Long>> insert(User... users);

  @Insert
  Single<List<Long>> insert(Collection<User> users);

  @Delete
  Single<Integer> delete(User user);

  @Delete
  Single<Integer> delete(User... users);

  @Delete
  Single<Integer> delete(Collection<User> users);

  @Update
  Single<Integer> update(User user);

  @Update
  Single<Integer> update(User... users);

  @Update
  Single<Integer> update(Collection<User> users);

  @Query("SELECT * FROM user WHERE user_id = :userId")
  LiveData<User> getById(long userId);

  @Transaction
  @Query("SELECT * FROM user WHERE user_id = :userId")
  LiveData<UserWithGames> getByIdWithGames(long userId);

  @Query("SELECT * FROM User WHERE oauth_key = :oauthKey")
  Maybe<User> getByOauthKey(String oauthKey);

}
