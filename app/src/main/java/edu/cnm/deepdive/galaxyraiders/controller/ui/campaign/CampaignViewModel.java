package edu.cnm.deepdive.galaxyraiders.controller.ui.campaign;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *  Loads and gets the value of the campaign text view.
 */
public class CampaignViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  /**
   *  Loads the text view.
   */
  public CampaignViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue(" ");
  }

  /**
   *  Gets the text.
   * @return Returns mText.
   */
  public LiveData<String> getText() {
    return mText;
  }

}