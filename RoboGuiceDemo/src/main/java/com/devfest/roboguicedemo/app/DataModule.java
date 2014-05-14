package com.devfest.roboguicedemo.app;

import android.content.Context;
import com.devfest.roboguicedemo.data.DataProvider;
import com.devfest.roboguicedemo.data.SqlLiteProvider;
import com.google.inject.AbstractModule;


/**
 * Created by truxall on 5/2/2014.
 */
public class DataModule extends AbstractModule {

    private final Context context;

    public DataModule(final Context context)
    {
        super();
        this.context = context;
    }

    @Override
    protected void configure() {

        DataProvider provider = new SqlLiteProvider(context);

        bind(DataProvider.class).toInstance(provider);
    }
}
