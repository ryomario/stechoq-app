package com.example.daftarku.daftarku;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.daftarku.R;
import com.example.daftarku.model.Photo;
import com.squareup.picasso.Picasso;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DaftarKuAdapter extends RecyclerView.Adapter<DaftarKuAdapter.DaftarKuViewHolder> {
    private List<Photo> daftarku;

    Context context;

    public DaftarKuAdapter(Context context) {
        this.context = context;
        daftarku = new ArrayList<>();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Photo> daftar) {
        daftarku = daftar;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public DaftarKuViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new DaftarKuViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daftar_ku,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DaftarKuViewHolder holder, int position) {
        holder.onBindData(daftarku.get(position),context);
    }

    @Override
    public int getItemCount() {
        return daftarku.size();
    }

    static class DaftarKuViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public DaftarKuViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);

        }

        void onBindData(Photo photo, Context context) {

//            Toast.makeText(context,photo.getThumbnailUrl(),Toast.LENGTH_SHORT).show();

//            RequestBuilder<Drawable> requestBuilder = Glide.with(context).load(photo.getUrl());
//
//            requestBuilder
//                    .thumbnail(Glide.with(context)
//                            .load(photo.getThumbnailUrl()))
//                    .load(photo.getUrl())
//                    .into(imageView);
//
//
//            Glide.with(context)
//                    .load(photo.getUrl())
//                    .into(imageView);

//            Glide.with(context)
//                    .asBitmap()
//                    .load(photo.getThumbnailUrl() + "")
//                    .centerCrop()
//                    .placeholder(android.R.drawable.ic_popup_sync)
//                    .error(android.R.drawable.stat_notify_error)
//                    .into(
//                            imageView
//                    );

            Picasso.get()
                    .load(photo.getThumbnailUrl())
                    .into(imageView);

        }
    }
}
