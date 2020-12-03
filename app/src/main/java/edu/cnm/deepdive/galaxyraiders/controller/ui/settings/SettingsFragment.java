package edu.cnm.deepdive.galaxyraiders.controller.ui.settings;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.galaxyraiders.R;

/**
 * Connects the settings layou to the campaign functionality.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

  /**
   * Calls the campaign fragment UI.
   * @param savedInstanceState Saves the Instance
   * @param rootKey Key for the root.
   */
  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.preferences, rootKey);
  }

}
