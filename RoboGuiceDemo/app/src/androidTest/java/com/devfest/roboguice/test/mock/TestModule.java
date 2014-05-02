package com.devfest.roboguice.test.mock;

import com.devfest.roboguice.data.DataProvider;

import com.google.inject.AbstractModule;

/**
 * Created by truxall on 5/2/2014.
 */
public class TestModule  extends AbstractModule {

    @Override
    protected void configure() {

        DataProvider provider = new MockDataSource();
        bind(DataProvider.class).toInstance(provider);
    }
}
