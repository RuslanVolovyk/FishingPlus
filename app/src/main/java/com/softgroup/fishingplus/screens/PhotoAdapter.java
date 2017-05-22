package com.softgroup.fishingplus.screens;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softgroup.fishingplus.R;

import java.util.List;


public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private List photoList;
    private LayoutInflater inflater;

    public PhotoAdapter(List photoList) {
        this.photoList = photoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PhotoAdapter.ViewHolder holder, int position) {
        String photo = (String) photoList.get(position);
        holder.bind(photo);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private String photo;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view_photo_galery);

        }

        public void bind(String photo) {
            this.photo = photo;

            Glide.with(imageView.getContext())
                    .load(photo)
                    .into(imageView);
        }

    }
}