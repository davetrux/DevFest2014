package com.devfest.roboguice.app;

import android.content.Context;

import com.devfest.roboguice.data.DataProvider;
import com.devfest.roboguice.data.SqlLiteProvider;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;


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
