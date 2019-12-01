package com.example.todomvp;

import androidx.annotation.NonNull;

import rx.Observable;

class DataModel implements IDataModel {

    @NonNull
    @Override
    public Observable<String> getTodo() {

        return Observable.just("Hello");
    }

}
