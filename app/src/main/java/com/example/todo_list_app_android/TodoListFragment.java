package com.example.todo_list_app_android;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo_list_app_android.databinding.TodoListFragmentBinding;

import java.util.List;
import java.util.ArrayList;

/**
 * The main fragment to be displayed in the app.
 *
 * @author Arthur Riechert
 * @version 1.0.0
 */
public class TodoListFragment extends Fragment {

    /** Binds to todo_list_fragment.xml */
    private TodoListFragmentBinding binding;

    /** A list to hold various tasks the user adds */
    private List<Task> tasks;

    /** A binding for tasks array list */
    private TaskListRecyclerAdapater tasklistRecyclerAdapater;

    /** The binding for the button to add tasks to the list */
    private Button addTaskButton;

    /** The binding for the area where task is inputted */
    private EditText newTaskInput;

    /** The checkbox used for items in the task list */
    private Button checkTaskButton;

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

        tasks = new ArrayList<>();
        tasks.add(new Task("Wake up"));

        RecyclerView recyclerView = view.findViewById(R.id.task_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        tasklistRecyclerAdapater = new TaskListRecyclerAdapater(tasks, getContext());

        recyclerView.setAdapter(tasklistRecyclerAdapater);

        addTaskButton = view.findViewById(R.id.add_task_button);
        newTaskInput = view.findViewById(R.id.new_task_input);
        checkTaskButton = view.findViewById(R.id.added_task);

        // Button to navigate to next page.
        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TodoListFragment.this)
                        .navigate(R.id.action_TodoList_to_SecondFragment);
            }
        });

        // Button to add a new task.
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
    }

    /**
     * Adds a single task item to the task lists and notifies
     * the recycler view adapter.
     */
    private void addTask() {
        String inputtedText = newTaskInput.getText().toString();
        int inputtedTextLength = inputtedText.length();

        if (inputtedTextLength <= 0) {
            showToast("Can't add an empty task, Lazy!");
        }
        else if (inputtedTextLength > 0) {
            tasks.add(new Task(inputtedText));
            tasklistRecyclerAdapater.notifyDataSetChanged();
        }
    }

    /**
     * Removes a task from the task list
     * and notifies the task list recycler.
     *
     * @param index The text of the item in the list to remove.
     */


    /**
     * Displays a toast with the specified message.
     *
     * @param message The message to display in the toast.
     */
    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}