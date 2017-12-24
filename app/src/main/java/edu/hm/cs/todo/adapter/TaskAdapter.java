package edu.hm.cs.todo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.hm.cs.todo.R;
import edu.hm.cs.todo.model.Task;

/**
 * Created by Sam on 24/12/2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private static final String TAG = TaskAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;
    private List<Task> mTasks;

    public TaskAdapter(ListItemClickListener onClickListener, List<Task> tasks) {
        mOnClickListener = onClickListener;
        mTasks = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForGridItem = R.layout.task_grid_item_view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = layoutInflater.inflate(layoutIdForGridItem, parent,
                shouldAttachToParentImmediately);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bind(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTaskTitle;

        public TaskViewHolder(View itemView) {
            super(itemView);
            mTaskTitle = (TextView) itemView.findViewById(R.id.tv_task_title);
            itemView.setOnClickListener(this);
        }

        void bind(Task task) {
            mTaskTitle.setText(task.getName());
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
