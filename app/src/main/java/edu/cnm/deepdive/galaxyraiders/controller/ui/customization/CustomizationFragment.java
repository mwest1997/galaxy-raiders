package edu.cnm.deepdive.galaxyraiders.controller.ui.customization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.galaxyraiders.R;

/**
 *  Connects the customization layout to the customization functionality.
 */
public class CustomizationFragment extends Fragment {

  /**
   * Calls the customization fragment UI.
   * @param inflater Used to uncompress data.
   * @param container A view of a collection.
   * @param savedInstanceState Saves the instance.
   * @return Returns the root.
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    CustomizationViewModel customizationViewModel = ViewModelProviders.of(this)
        .get(CustomizationViewModel.class);
    View root = inflater.inflate(R.layout.fragment_customization, container, false);
    return root;
  }
}