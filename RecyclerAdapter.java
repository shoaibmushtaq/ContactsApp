package com.example.muhammadshoaib.contactsapp;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {


    private LayoutInflater layoutInflater;
    public List<Contacts> cont;
    Contacts list;
    private ArrayList<Contacts> arraylist;
    boolean checked = false;
    View vv;

    public RecyclerAdapter(LayoutInflater inflater, List<Contacts> items) {
        this.layoutInflater = inflater;
        this.cont = items;
        this.arraylist = new ArrayList<Contacts>();
        this.arraylist.addAll(cont);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = layoutInflater.inflate(R.layout.row_layout, viewGroup, false);
        ImageViewHolder viewHolder = new ImageViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder viewHolder, int i) {


        list = cont.get(i);
        String name = (list.getName());

        viewHolder.name.setText(name);
        viewHolder.number.setText(list.getPhone());

        try {
            viewHolder.imageView.setImageBitmap(list.getImage());


        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return cont.size();
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView number;



        public ImageViewHolder(View itemView) {
                super(itemView);
                this.setIsRecyclable(false);
                name = (TextView) itemView.findViewById(R.id.name);
                number = (TextView) itemView.findViewById(R.id.number);
                imageView=(ImageView) itemView.findViewById(R.id.img);


            }
        }

    }



