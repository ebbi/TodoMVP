package com.example.todomvp;

import android.app.Application;

public class TodoApplication extends Application {

    private final IDataModel mDataModel;

    public TodoApplication() {
        mDataModel = new DataModel();
    }

    public IDataModel getDataModel() {
        return mDataModel;
    }
}
