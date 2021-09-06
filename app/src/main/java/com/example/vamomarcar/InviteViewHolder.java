package com.example.vamomarcar;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InviteViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public InviteViewHolder(@NonNull  View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imvPhotoEvI);
    }
}
