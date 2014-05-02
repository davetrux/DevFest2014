package com.devfest.roboguice.app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.devfest.roboguice.data.DataProvider;
import com.devfest.roboguice.data.ToDo;

import java.util.List;

import javax.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;


public class MainActivity extends RoboActivity {

    @InjectView(R.id.taskText)
    private TextView mNewTaskText;

    @InjectView(R.id.taskList)
    private ListView mTaskView;

    @Inject
    private DataProvider mProvider;

    private List<ToDo> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button action = (Button) findViewById(R.id.newTask);
        action.setOnClickListener(this.handleNewTaskEvent);

        mData = findPersistedRecords();

        if(!mData.isEmpty()) {
            BindToDoList();
        }

    }


    private final View.OnClickListener handleNewTaskEvent = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {

            ToDo newItem = new ToDo();
            newItem.setTitle(mNewTaskText.getText().toString());
            newItem.setId(mProvider.getNextId());
            mProvider.addTask(newItem);

            mData.add(newItem);

            BindToDoList();

            mNewTaskText.setText("");
        }
    };

    /**
     * Helper method to put the list of items into the ListView
     */
    private void BindToDoList() {
        final ToDoAdapter adapter = new ToDoAdapter(this, mData);
        mTaskView.setAdapter(adapter);

        mTaskView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {

                final TextView v = (TextView) view;

                final long todoId = (Long) v.getTag();

                //Remove from the local database
                mProvider.deleteTask(todoId);

                mData.remove(position);

                BindToDoList();
            }
        });
    }

    /**
     * Find any objects in the database
     * @return An ArrayList of To-Do objects
     */
    protected List<ToDo> findPersistedRecords() {

        List<ToDo> result = mProvider.findAll();

        return result;
    }
}
