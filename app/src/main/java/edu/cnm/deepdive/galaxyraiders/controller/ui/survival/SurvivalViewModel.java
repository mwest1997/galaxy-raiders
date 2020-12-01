package edu.cnm.deepdive.galaxyraiders.controller.ui.survival;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SurvivalViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public SurvivalViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue(" ");
  }

  public LiveData<String> getText() {
    return mText;
  }
}