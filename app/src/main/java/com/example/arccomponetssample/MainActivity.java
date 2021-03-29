package com.example.arccomponetssample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

import com.example.arccomponetssample.model.data.Todos;
import com.example.arccomponetssample.viewmodel.TodosViewModel;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private TodosViewModel todosViewModel;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.plant(new Timber.DebugTree());
        Timber.e("test timber");

        initUI();

//        retrofit();

        // add your viewModel here
        bindViewModelAll();

        // add your observing of liveData
        observeAll();

        // call api to update data model
        todosViewModel.apiGetTodoList();
    }

    private void initUI() {
        textView = findViewById(R.id.text);
    }

    private void bindViewModelAll(){
        todosViewModel = ViewModelProviders.of(this).get(TodosViewModel.class);
    }

    private void observeAll(){
        observeTodosList();
    }

    private void observeTodosList() {
        todosViewModel.getTodosObserver().observe(this, new Observer<List<Todos>>() {
            @Override
            public void onChanged(List<Todos> todosList) {
                if (todosList == null){
                    return;
                }
                // do something about UI
                textView.setText("Test Retrofit, data.size = " + todosList.size());
            }
        });
    }
}