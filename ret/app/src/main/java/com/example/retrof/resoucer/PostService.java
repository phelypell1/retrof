package com.example.retrof.resoucer;
//////////////////////////
import com.example.retrof.representacao.Posts;

import java.util.List;
//////////////////////////
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
///////////////////////////
public interface PostService {
        ///////////////////envia post para o servidor
        @POST("posts")
        Call<Posts> post(@Body Posts post);
        ///////////////////recupera post
        @GET("posts/{id}")
        Call<Posts>get(@Path("id") Integer id);
        ///////////////////tras listas
        @GET("posts")
        Call<List<Posts>> get();
        ///////////////////atualiza tudo
        @PUT("posts/{id}")
        Call<Posts> put(@Path("id") Integer id, @Body Posts posts);
        ///////////////////atualizar parcialmente
        @PATCH("posts/{id}")
        Call<Posts> patch(@Path("id") Integer id, @Body Posts posts);
        ///////////////////apagar
        @DELETE("posts/{id}")
        Call<Void>delete(@Path("id") Integer id);
        ///////////////////////







}
