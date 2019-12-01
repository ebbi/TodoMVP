package com.example.todomvp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements IView {

    @NonNull
    private IPresenter mPresenter;

    @Nullable
    private TextView mTodoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(getDataModel(), this);

        setupViews();
    }

    private void setupViews() {

        mTodoView = (TextView) findViewById(R.id.txtViewTodo);
    }

    public void setTodo(final String todo){
        mTodoView.setText(todo);
    }

    private IDataModel getDataModel(){
        return ((TodoApplication) getApplication()).getDataModel();
    }

    protected void onPause(){
        super.onPause();
        mPresenter.unbind();
    }

    protected void onResume() {
        super.onResume();
        mPresenter.bind();
    }


}
