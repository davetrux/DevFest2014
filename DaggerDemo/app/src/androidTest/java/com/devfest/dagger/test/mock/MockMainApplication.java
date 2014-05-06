package com.devfest.dagger.test.mock;

import android.test.mock.MockApplication;

import com.devfest.dagger.app.DataModule;
import com.devfest.dagger.app.MainApplication;
import com.devfest.dagger.data.DataProvider;

import dagger.ObjectGraph;

/**
 * Created by david on 4/28/14.
 */
public class MockMainApplication extends MainApplication {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {

        objectGraph = ObjectGraph.create(new MockModule());
    }

    public ObjectGraph getObjectGraph() {
        return this.objectGraph;
    }

}
