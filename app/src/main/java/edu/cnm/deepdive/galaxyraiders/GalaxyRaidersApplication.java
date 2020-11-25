package edu.cnm.deepdive.galaxyraiders;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.galaxyraiders.service.GalaxyDatabase;
import edu.cnm.deepdive.galaxyraiders.service.GoogleSignInService;
import io.reactivex.schedulers.Schedulers;

public class GalaxyRaidersApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    GoogleSignInService.setContext(this);
    GalaxyDatabase.setContext(this);
    GalaxyDatabase.getInstance().getGameDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}
