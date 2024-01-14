package com.example.todo_list_app_android;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_list_app_android.databinding.TodoListFragmentBinding;

import java.util.List;
import java.util.ArrayList;

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

        RecyclerView recyclerView = view.findViewById(R.id.task_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Wake up"));

        TaskListAdapter adapter = new TaskListAdapter(tasks, getContext());

        recyclerView.setAdapter(adapter);

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
                else if (inputtedTextLength > 0) {
                    tasks.add(new Task(inputtedText));
                    adapter.notifyDataSetChanged();
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