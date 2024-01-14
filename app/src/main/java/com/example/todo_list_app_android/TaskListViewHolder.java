package com.example.todo_list_app_android;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
public class TaskListViewHolder extends RecyclerView.ViewHolder {

    TextView taskName;

    public TaskListViewHolder(@NonNull View view) {
        super(view);
        taskName = view.findViewById(R.id.added_task);
    }
}
