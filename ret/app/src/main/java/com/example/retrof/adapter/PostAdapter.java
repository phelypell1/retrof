package com.example.retrof.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.retrof.R;
import com.example.retrof.representacao.Posts;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    Context context;
    List<Posts> colecao;
    LayoutInflater inflter;

    public PostAdapter(final Context applicationContext,
                         final List<Posts> colecao) {
        this.context = applicationContext;
        this.colecao = colecao;
    }

    @Override
    public int getCount() {
        return this.colecao!=null ? this.colecao.size() :0 ;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // inflate the layout for each list row
        //'Infla' o layout(pega a referencia) para ser trabalhada
        //no método
        if (view == null) {
            view = LayoutInflater.from(context).
                    inflate(R.layout.item_post,
                            parent, false);

            Posts posts = (Posts) getItem(position);
            TextView userId, id, title;
            userId =view.findViewById(R.id.textUserId);
            id = view.findViewById(R.id.txtID);
            title =view.findViewById(R.id.txtTitle);
            /////
            userId.setText(posts.getId());
            id.setText(posts.getId());
            title.setText(posts.getId());

            return view;


        }

        return null;
    }
}
