package edu.cnm.deepdive.galaxyraiders.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.galaxyraiders.BuildConfig;
import io.reactivex.Single;

/**
 * Creates the opportunity to use Google Sign-in upon launch of the app.
 */
public class GoogleSignInService {

  private static Application context;

  private final GoogleSignInClient client;

  private GoogleSignInAccount account;

  private GoogleSignInService() {
    GoogleSignInOptions options  = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
//        .requestIdToken(BuildConfig.CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  /**
   * Sets the context.
   */
  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  /**
   * Gets the instance.
   */
  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Gets the current account.
   */
  public GoogleSignInAccount getAccount() {
    return account;
  }

  /**
   * Refreshes the accounts available.
   * @return Returns the Single of an account.
   */
  public Single<GoogleSignInAccount> refresh() {
    return Single.create((emitter) ->
        client.silentSignIn()
            .addOnSuccessListener(this::setAccount)
            .addOnSuccessListener(emitter::onSuccess)
            .addOnFailureListener(emitter::onError)
    );
  }

  /**
   * Starts the sign-in process.
   * @param activity The activity of Google Sign-in.
   * @param requestCode Requests the code.
   */
  public void startSignIn(Activity activity, int requestCode) {
    account = null;
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  /**
   * Completes the sign-in process.
   * @param data The data within the Google account.
   * @return Returns the task.
   */
  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      setAccount(task.getResult(ApiException.class));
    } catch (ApiException e) {
      // Exception will be passed automatically to onFailureListener.
    }
    return task;
  }

  /**
   * Creates the ability to sign out of the current Google account.
   * @return Returns signOut.
   */
  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((ignored) -> setAccount(null));
  }

  private void setAccount(GoogleSignInAccount account) {
    this.account = account;
//    if (account != null) {
//      //noinspection ConstantConditions
//      Log.d(getClass().getSimpleName(), account.getIdToken());
//    }
  }

  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
