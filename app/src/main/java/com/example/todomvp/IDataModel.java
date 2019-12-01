package com.example.todomvp;

import rx.Observable;

public interface  IDataModel {
    Observable<String> getTodo();
}
