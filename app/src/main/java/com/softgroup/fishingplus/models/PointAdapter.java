package com.softgroup.fishingplus.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;

import java.util.List;


public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {
    private  List<Point> points;
    private LayoutInflater inflater;


    public PointAdapter(List<Point> points) {
        this.points = points;
        setHasStableIds(true);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return ViewHolder.create(inflater, parent);

    }

    @Override
    public void onBindViewHolder(PointAdapter.ViewHolder holder, int position) {
        holder.bind(points.get(position));

    }

    @Override
    public int getItemCount() {
        return points.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView pointName;
        private TextView pointDescription;
        private TextView time;

        private ImageButton showOnTheMap;

        private TextView temperature;
        private TextView pressure;
        private TextView humidity;
        private TextView wind;
        private TextView condition;

        public static ViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            return new ViewHolder(inflater.inflate(R.layout.point_item, parent, false));
        }


        public ViewHolder(View itemView) {
            super(itemView);

            showOnTheMap = (ImageButton)itemView.findViewById(R.id.image_button_show_location_on_the_map);

            pointName = (TextView) itemView.findViewById(R.id.text_view_name_point);
            pointDescription = (TextView) itemView.findViewById(R.id.point_description);
            time = (TextView) itemView.findViewById(R.id.text_view_date_point);
        }

        public void bind(Point point) {
            pointName.setText(point.getName());
            pointDescription.setText(point.getDescription());
            time.setText(Utils.getCurrentDate());

        }

        @Override
        public void onClick(View view) {


        }
    }
}
