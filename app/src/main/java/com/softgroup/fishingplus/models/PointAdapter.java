package com.softgroup.fishingplus.models;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softgroup.fishingplus.R;

import java.util.List;

/**
 * Created by Администратор on 25.04.2017.
 */

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {
    private static final String TAG = PointAdapter.class.getName();
    private List<Point> pointList;
    private LayoutInflater inflater;

    public PointAdapter(List<Point> pointList) {
        this.pointList = pointList;
        setHasStableIds(true);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.point_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PointAdapter.ViewHolder holder, int position) {
        Point point = pointList.get(position);
        holder.bind(point);
    }

    @Override
    public int getItemCount() {
        return pointList == null ? 0 : pointList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView pointName;
        private TextView time;
        private ImageButton showOnTheMap;
        private Point point;

        private TextView condition;


        private TextView temperature;
        private TextView pressure;
        private TextView humidity;
        private TextView wind;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            pointName = (TextView) itemView.findViewById(R.id.text_view_name_point);
            time = (TextView) itemView.findViewById(R.id.text_view_date_point);
            showOnTheMap = (ImageButton) itemView.findViewById(R.id.image_button_show_location_on_the_map);

            showOnTheMap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //TODO: переход на фрагмент карты с координатами точки

//                        Log.v(TAG, "Нажатие " + "Координаты лат " + weather.getLat());
//                        Log.v(TAG, "Нажатие " + "Координаты лон " + weather.getLon());
                }
            });

        }

        public void bind(Point point) {
            this.point = point;
            pointName.setText(point.getName());
            time.setText(point.getDate().toString());


        }

        @Override
        public void onClick(View view) {

            Log.v(TAG, "Нажатие " + "Описние " + point.getDescription());
            Log.v(TAG, "Нажатие " + "Дата " + point.getDate());
            Log.v(TAG, "Нажатие " + "Название " + point.getName());
            Log.v(TAG, "Нажатие " + "ІД " + point.getUuid());
            Log.v(TAG, "Нажатие " + "Облачность " + point.getCondition());
            Log.v(TAG, "Нажатие " + "Влажность " + point.getHumidity());
            Log.v(TAG, "Нажатие " + "Температура " + point.getTemperature());
            Log.v(TAG, "Нажатие " + "Ветер " + point.getWind());
            // Log.v(TAG, "Нажатие " + "Координаты лат " + point.getLat());
            Log.v(TAG, "Нажатие " + "Координаты лон " + point.getLon());


//                Intent intent = PointActivity.newIntent(getActivity(), point.getUuid());
//                startActivity(intent);
//
//            Intent intent = new Intent(get, PointActivity.class);
//            intent.putExtra(POINT, point);
//            startActivity(intent);

        }
    }
}
