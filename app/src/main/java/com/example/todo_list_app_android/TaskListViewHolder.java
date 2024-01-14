package com.example.todo_list_app_android;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.view.View;
import androidx.annotation.NonNull;
public class TaskListViewHolder extends RecyclerView.ViewHolder {

    Button task;

    public TaskListViewHolder(@NonNull View view) {
        super(view);
        task = view.findViewById(R.id.added_task);
    }
}
