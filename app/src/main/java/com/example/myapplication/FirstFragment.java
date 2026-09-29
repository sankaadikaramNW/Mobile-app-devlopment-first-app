package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

// This class gives us easy access to the views in fragment_first.xml.
// For example, binding.buttonFirst is the Button in that file.
import com.example.myapplication.databinding.FragmentFirstBinding;

// A Fragment is one screen inside the app.
// This app moves between FirstFragment and SecondFragment.
public class FirstFragment extends Fragment {

    // Holds the views from this Fragment's layout file.
    // We set it to null in onDestroyView() below, so we don't waste memory.
    private FragmentFirstBinding binding;

    // This runs when the Fragment needs to build its screen (its views).
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Load the layout file fragment_first.xml.
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        // Give the root view back so it can be shown on screen.
        return binding.getRoot();

    }

    // This runs right after the views are ready.
    // It is safe to set up buttons here.
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // When the button is tapped, go to SecondFragment.
        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }

    // This runs when the Fragment's view is removed (for example, when we
    // move to another screen). We set binding to null so we don't keep
    // using views that are gone.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
