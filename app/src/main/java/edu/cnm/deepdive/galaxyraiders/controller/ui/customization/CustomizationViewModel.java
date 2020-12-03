package edu.cnm.deepdive.galaxyraiders.controller.ui.customization;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Loads and gets the value of the customization text view.
 */
public class CustomizationViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  /**
   * Loads the text view.
   */
  public CustomizationViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue(" ");
  }

  /**
   * Gets the text.
   * @return Returns mText.
   */
  public LiveData<String> getText() {
    return mText;
  }
}