package com.hp.reference.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.hp.reference.data.DataProvider;
import com.hp.reference.data.ToDo;

import java.util.List;

/**
 * Created by truxall on 4/18/2014.
 */
public class ToDoFragment extends Fragment {

    private TextView mNewTaskText;
    private List<ToDo> mData;
    private ListView mTaskView;
    private final DataProvider mProvider;

    public ToDoFragment(DataProvider provider) {
        mProvider = provider;
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

        mData = mProvider.findAll();

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
                mProvider.deleteTask(todoId);

                mData.remove(position);

                BindToDoList();
            }
        });
    }
}
