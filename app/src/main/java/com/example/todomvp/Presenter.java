package com.example.todomvp;

import androidx.annotation.NonNull;

import rx.subscriptions.CompositeSubscription;

public class Presenter implements IPresenter {

    @NonNull
    private final IDataModel mDataModel;
    @NonNull
    private final IView mView;

    private CompositeSubscription mSubscription;

    public Presenter(@NonNull final IDataModel dataModel,
                     @NonNull final IView view) {
        mDataModel = dataModel;
        mView = view;
    }

    public Presenter(@NonNull final IDataModel dataModel,
                     @NonNull IView view, MainActivity mainActivity) {
        mDataModel = dataModel;
        mView = view;
    }

    @Override
    public void bind() {
        mSubscription = new CompositeSubscription();

        mSubscription.add(mDataModel.getTodo()
                .subscribe(this::setTodo));
    }

    @Override
    public void unbind() {
        mSubscription.unsubscribe();
    }

    private void setTodo(final String todo) {
        mView.setTodo(todo);
    }
}
