package edu.cnm.deepdive.galaxyraiders.controller.ui.settings;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.galaxyraiders.R;

public class SettingsFragment extends PreferenceFragmentCompat {

  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.preferences, rootKey);
  }

}
