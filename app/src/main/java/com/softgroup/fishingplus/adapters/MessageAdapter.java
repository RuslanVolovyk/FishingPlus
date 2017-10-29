package com.softgroup.fishingplus.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.models.Message;

import java.util.List;


/**
 * Created by Администратор on 20.03.2017.
 */

public class MessageAdapter extends ArrayAdapter<Message> {


    public MessageAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.layout_message_item, parent, false);
        }
        TextView messageTextView = (TextView) convertView.findViewById(R.id.text_view_message);
        ImageView messageImageView = (ImageView) convertView.findViewById(R.id.image_view_user);
        TextView nameUser = (TextView) convertView.findViewById(R.id.text_view_name_user);
        TextView time = (TextView) convertView.findViewById(R.id.message_time);


        Message message = getItem(position);

        boolean isPhoto = false;
        if (message != null) {
            isPhoto = message.getPhoto() != null;
        }
        if (isPhoto) {
            messageTextView.setVisibility(View.GONE);
            messageImageView.setVisibility(View.VISIBLE);
            Glide.with(messageImageView.getContext())
                    .load(message.getPhoto())
                    .into(messageImageView);

        } else {
            messageTextView.setVisibility(View.VISIBLE);
            messageImageView.setVisibility(View.GONE);
            messageTextView.setText(message.getText());
        }
        nameUser.setText(message.getName());

        time.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                message.getTime()));
        return convertView;

    }

}