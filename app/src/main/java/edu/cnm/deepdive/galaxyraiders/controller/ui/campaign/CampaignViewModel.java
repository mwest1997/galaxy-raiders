package edu.cnm.deepdive.galaxyraiders.controller.ui.campaign;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CampaignViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public CampaignViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue(" ");
  }

  public LiveData<String> getText() {
    return mText;
  }
}