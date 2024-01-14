package com.example.todo_list_app_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.todo_list_app_android.databinding.TutorialFragmentBinding;

public class TutorialFragment extends Fragment {

    private TutorialFragmentBinding binding;

    /** The counter's associated view binding */
    private TextView counterDisplay;

    /** Tracks the current count */
    private int count;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = TutorialFragmentBinding.inflate(inflater, container, false);
        counterDisplay = binding.getRoot().findViewById(R.id.counter_display);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toTodoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TutorialFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.toastButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showToast(getString(R.string.tutorial_toast_string));
            }
        });

        binding.countButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                updateCount();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Displays a basic toast message.
     *
     * @param message The message to display.
     */
    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT)
                .show();
    }

    /**
     * Updates the counter on the screen.
     */
    private void updateCount() {
        count++;
        counterDisplay.setText(Integer.valueOf(count).toString());
    }
}