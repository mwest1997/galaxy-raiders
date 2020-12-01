package edu.cnm.deepdive.galaxyraiders.controller.ui.campaign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.galaxyraiders.R;

public class CampaignFragment extends Fragment {

  private CampaignViewModel campaignViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    campaignViewModel =
        ViewModelProviders.of(this).get(CampaignViewModel.class);
    View root = inflater.inflate(R.layout.fragment_campaign, container, false);
    final TextView textView = root.findViewById(R.id.text_home);
    campaignViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}