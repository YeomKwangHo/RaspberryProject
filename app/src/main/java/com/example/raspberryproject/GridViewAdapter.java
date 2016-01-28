package com.example.raspberryproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by JISU on 2016-01-28.
 */
public class GridViewAdapter extends BaseAdapter {

    Context context = null;
    int[] imageIDs;

    GridViewAdapter(Context context, int[] id)
    {
        this.context = context;
        this.imageIDs = id;
    }

    @Override
    public int getCount() {
        return (imageIDs != null) ? imageIDs.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return (imageIDs != null) ? imageIDs[position] : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ImageView imageView;

        if(convertView != null) imageView = (ImageView)convertView;

        else{
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), imageIDs[position]);

            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);        // 비율에 맞춘다.
            imageView.setImageBitmap(bitmap);
        }

        return imageView;
    }
}
