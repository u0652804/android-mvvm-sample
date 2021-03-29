package com.example.arccomponetssample.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.arccomponetssample.model.data.Todos;
import com.example.arccomponetssample.model.remote.todos.RestApiService;
import com.example.arccomponetssample.model.remote.todos.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class TodosViewModel extends ViewModel {

    private MutableLiveData<List<Todos>> todosList;

    public TodosViewModel(){
        todosList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Todos>> getTodosObserver(){
        return todosList;
    }

    public void apiGetTodoList(){
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<List<Todos>> call = apiService.getTodosList();
        call.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                Timber.d("check resp data with retrofit, data = " + response.body());
                todosList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                todosList.postValue(null);
            }
        });
    }
}