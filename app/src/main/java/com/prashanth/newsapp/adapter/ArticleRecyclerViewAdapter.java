package com.prashanth.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.prashanth.newsapp.Constants;
import com.prashanth.newsapp.R;
import com.prashanth.newsapp.activity.ArticleWebViewActivity;
import com.prashanth.newsapp.model.Articles;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class ArticleRecyclerViewAdapter extends RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Articles> articles;

    private Context context;

    public ArticleRecyclerViewAdapter(Context context, ArrayList<Articles> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NotNull
    @Override
    public ArticleRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull ArticleRecyclerViewAdapter.ViewHolder holder, int position) {

        String title = articles.get(position).getTitle();

        holder.miniDescription.setText(title);

        Picasso.get()
                .load(articles.get(position).getUrlToImage())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView miniDescription;

        private ImageView image;

        private CardView cardView;

        ViewHolder(View view) {
            super(view);
            miniDescription = view.findViewById(R.id.miniDescription);
            image = view.findViewById(R.id.image);
            cardView = view.findViewById(R.id.card_view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ArticleWebViewActivity.class);
            intent.putExtra(Constants.URL_INTENT, articles.get(getAdapterPosition()).getUrl());
            context.startActivity(intent);
        }
    }
}
