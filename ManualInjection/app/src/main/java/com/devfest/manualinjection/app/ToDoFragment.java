package com.devfest.manualinjection.app;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.devfest.manualinjection.data.DataProvider;
import com.devfest.manualinjection.data.SqlLiteProvider;
import com.devfest.manualinjection.data.ToDo;

import java.util.List;

/**
 * Created by truxall on 4/28/2014.
 */
public class ToDoFragment extends Fragment {
    private TextView mNewTaskText;
    private List<ToDo> mData;
    private ListView mTaskView;
    private DataProvider mProvider;

    public ToDoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mTaskView = (ListView) getView().findViewById(R.id.taskList);

        mNewTaskText = (TextView) getView().findViewById(R.id.taskText);

        Button action = (Button) getView().findViewById(R.id.newTask);
        action.setOnClickListener(this.handleNewTaskEvent);

        MainApplication app = (MainApplication) getActivity().getApplication();

        mProvider = app.getDataProvider();

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
        final ToDoAdapter adapter = new ToDoAdapter(getView().getContext(), mData);
        mTaskView.setAdapter(adapter);

        mTaskView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {

                final TextView v = (TextView) view;

                final long todoId = (Long) v.getTag();

                //Remove from the local database
                final SqlLiteProvider provider = new SqlLiteProvider(parent.getContext());
                provider.deleteTask(todoId);

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
        final SqlLiteProvider provider = new SqlLiteProvider(getView().getContext());

        List<ToDo> result = provider.findAll();

        return result;
    }
}
