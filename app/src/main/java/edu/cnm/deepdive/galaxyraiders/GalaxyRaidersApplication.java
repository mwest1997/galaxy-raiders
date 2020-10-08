package edu.cnm.deepdive.galaxyraiders;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class GalaxyRaidersApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }

}
