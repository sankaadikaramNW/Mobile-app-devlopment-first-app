package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

// This class gives us easy access to the views in fragment_second.xml.
// For example, binding.buttonSecond is the Button in that file.
import com.example.myapplication.databinding.FragmentSecondBinding;

// The second screen in the app.
// This class looks almost the same as FirstFragment. Compare them to see
// the pattern: load layout, set up a button, clean up in onDestroyView().
public class SecondFragment extends Fragment {

    // Holds the views from this Fragment's layout file.
    private FragmentSecondBinding binding;

    // This runs when the Fragment needs to build its screen (its views).
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Load the layout file fragment_second.xml.
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        // Give the root view back so it can be shown on screen.
        return binding.getRoot();

    }

    // This runs right after the views are ready.
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // When the button is tapped, go back to FirstFragment.
        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }

    // Set binding to null when the view is gone, so we don't waste memory.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
