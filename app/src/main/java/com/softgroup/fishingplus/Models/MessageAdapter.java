package com.softgroup.fishingplus.models;

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

import java.util.List;


/**
 * Created by Администратор on 20.03.2017.
 */

public class MessageAdapter extends ArrayAdapter<FriendlyMessage> {


    public MessageAdapter(Context context, int resource, List<FriendlyMessage> objects) {
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


        FriendlyMessage friendlyMessage = getItem(position);

        boolean isPhoto = friendlyMessage.getPhoto() != null;
        if (isPhoto) {
            messageTextView.setVisibility(View.INVISIBLE);
            messageImageView.setVisibility(View.VISIBLE);
            Glide.with(messageImageView.getContext())
                    .load(friendlyMessage.getPhoto())
                    .into(messageImageView);

        } else {
            messageTextView.setVisibility(View.VISIBLE);
            messageImageView.setVisibility(View.INVISIBLE);
            messageTextView.setText(friendlyMessage.getText());
        }
        nameUser.setText(friendlyMessage.getName());

        time.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                friendlyMessage.getTime()));
        return convertView;

    }

}