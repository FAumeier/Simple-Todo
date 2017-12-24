package edu.hm.cs.todo.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.hm.cs.todo.R;
import edu.hm.cs.todo.adapter.TaskAdapter;
import edu.hm.cs.todo.model.Task;

public class MainActivity extends AppCompatActivity implements TaskAdapter.ListItemClickListener {
    private final static String TAG = MainActivity.class.getSimpleName();
    private List<Task> mTasks;
    private TaskAdapter mTaskAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mTasks = new LinkedList<>();
        mTasks.add(new Task(new Date(), "Test", "Bla", false));
        mTaskAdapter = new TaskAdapter(this, mTasks);
        mRecyclerView = findViewById(R.id.rv_task_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mTaskAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
