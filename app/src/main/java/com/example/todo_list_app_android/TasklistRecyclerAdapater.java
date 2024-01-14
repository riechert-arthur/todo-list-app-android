package com.example.todo_list_app_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import androidx.annotation.NonNull;
public class TasklistRecyclerAdapater extends RecyclerView.Adapter<TaskListViewHolder> {
    private List<Task> taskList;
    private Context context;

    public TasklistRecyclerAdapater(List<Task> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @NonNull
    @Override
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskListViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.task_template, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        holder.taskName.setText(taskList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
