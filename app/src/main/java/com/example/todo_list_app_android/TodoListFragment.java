package com.example.todo_list_app_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.todo_list_app_android.databinding.TodoListFragmentBinding;

public class TodoListFragment extends Fragment {

    private TodoListFragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = TodoListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TodoListFragment.this)
                        .navigate(R.id.action_TodoList_to_SecondFragment);
            }
        });

        binding.addTaskButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast addTaskToast = Toast.makeText(
                        getActivity(),
                        "Added new task!",
                        Toast.LENGTH_SHORT
                );

                String inputtedText = binding.newTask.getText().toString();
                int inputtedTextLength = inputtedText.length();

                if (inputtedTextLength <= 0) {
                    addTaskToast.setText("You can't add an empty task, lazy!");
                }


                addTaskToast.show();
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}