package edu.cnm.deepdive.galaxyraiders.controller.ui.survival;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Loads and gets the value of the survival text view.
 */
public class SurvivalViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  /**
   * Loads the text view.
   */
  public SurvivalViewModel() {
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