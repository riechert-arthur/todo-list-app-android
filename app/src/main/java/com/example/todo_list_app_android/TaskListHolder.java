package com.example.todo_list_app_android;

import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
public class TaskListHolder extends RecyclerView.ViewHolder {

    TextView taskName;

    public TaskListHolder(@NonNull View view) {
        super(view);
        taskName = view.findViewById(R.id.added_task);
    }
}
