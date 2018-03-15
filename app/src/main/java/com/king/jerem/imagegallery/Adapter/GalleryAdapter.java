package com.king.jerem.imagegallery.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.king.jerem.imagegallery.View.Main2Activity;
import com.king.jerem.imagegallery.R;

import java.util.List;

/**
 * Created by jerem on 14/03/2018.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {
    Context context;
    List<String>listUrl;
    public GalleryAdapter(Context context, List<String>listUrl) {
       // RemoveList(listUrl);
        this.context=context;
        this.listUrl=listUrl;
    }

    @Override
    public GalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.custom_layout_adapter,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final GalleryAdapter.MyViewHolder holder, int position) {
        String url=listUrl.get(position);
        ImageView imageView = holder.imageView;
        if(!url.equals(""))//do html cua web tra link hinh anh? bi sai
        {
            Glide.with(context)
                    .load(url)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            holder.progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .fitCenter()
                    .placeholder(R.drawable.banan)
                    .into(imageView);

        }

    }

    @Override
    public int getItemCount() {
        return listUrl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_photo);
            progressBar=itemView.findViewById(R.id.progess);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent intent=new Intent(context, Main2Activity.class);
                    String url=listUrl.get(position);
                    intent.putExtra("poUrl",url);
                    context.startActivity(intent);
                }
            });

        }
    }

}
