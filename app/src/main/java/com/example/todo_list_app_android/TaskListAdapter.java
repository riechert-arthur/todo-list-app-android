package com.example.todo_list_app_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import androidx.annotation.NonNull;
public class TaskListAdapter extends RecyclerView.Adapter<TaskListHolder> {
    private List<Task> taskList;
    private Context context;

    public TaskListAdapter(List<Task> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskListHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.task_template, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListHolder holder, int position) {
        holder.taskName.setText(taskList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
