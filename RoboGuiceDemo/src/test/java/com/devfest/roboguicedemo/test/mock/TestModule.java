package com.devfest.roboguicedemo.test.mock;

import com.devfest.roboguicedemo.data.DataProvider;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by truxall on 5/2/2014.
 */
public class TestModule  implements Module {

    @Override
    public void configure(Binder binder) {
        DataProvider provider = new MockDataSource();
        binder.bind(DataProvider.class).toInstance(provider);

    }
}
