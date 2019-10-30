package com.example.retrof.atividade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.retrof.R;
import com.example.retrof.adapter.PostAdapter;
import com.example.retrof.bootstrap.BoostrapApi;
import com.example.retrof.representacao.Posts;
import com.example.retrof.resoucer.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {
    EditText textId;
    EditText txtUseId;
    EditText txtTitle;
    EditText txtBody;
    ListView listView;
    ////////////////////////////////////////////////////
    PostService postService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }
    private void carregarDados(){
        /////////////////////////////////////////////////
        postService = BoostrapApi.getClient()
                .create(PostService.class);

        final Call<List<Posts>> get = postService.get();

        get.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response
                    <List<Posts>> response) {
                ////////////////lista de posts
                List<Posts> posts = response.body();
                //pegar lista
                listView = findViewById(R.id.listViewPost);
                //chamar adapter
                PostAdapter adapter=new PostAdapter(getApplicationContext(),posts);
                //bind com a lista
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }

    public void adicionar(View view) {
        carregarDados();

    }
}
