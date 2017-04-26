package com.softgroup.fishingplus.screens;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.data.GPSCurrentPosition;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.PointSingle;
import com.softgroup.fishingplus.models.Weather;

import java.util.List;

import static com.softgroup.fishingplus.screens.SplashActivity.WEATHER;

/**
 * Created by Администратор on 26.04.2017.
 */

public class PointListFragment extends Fragment {
    Weather weather;
    Location location;


    private static final String TAG = PointListFragment.class.getName();
    public static final String LAT = "lat";
    public static final String LON = "lon";
    private RecyclerView recyclerView;
    private PointAdapter pointAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.point_list, container, false);

        weather = getArguments().getParcelable(WEATHER) ;

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_points);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public void updateUI() {

        PointSingle pointSingle = PointSingle.get(getActivity());
        List<Point> pointList = pointSingle.getPointList();

        if (pointAdapter == null) {
            pointAdapter = new PointAdapter(pointList);
            recyclerView.setAdapter(pointAdapter);
        } else {
            pointAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.add_points, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_create_new_points:

                GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(getActivity());
                location = gpsCurrentPosition.getLocation();

                double lat=location.getLatitude();
                double lon=location.getLongitude();
                Log.v(TAG, "Нажатие " + "Ветер " + location.getLatitude());
                Log.v(TAG, "Нажатие " + "Ветер " + location.getLongitude());


                Point point = new Point();
                point.setTemperature(weather.getTemp());
                point.setCondition(weather.getCondition() + weather.getDescription());
                point.setHumidity(weather.getHuminity());
                point.setWind(weather.getSpeed());
                point.setPressure(weather.getPressure());

                point.setLon(location.getLongitude());
                point.setLat(location.getLatitude());
                PointSingle.get(getActivity()).addPoint(point);
                Intent intent = PointActivity.newIntent(getActivity(), point.getUuid());
                startActivity(intent);

                break;
        }
        return true;
    }


    public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ViewHolder> {
        private List<Point> pointList;
        private LayoutInflater inflater;

        public PointAdapter(List<Point> pointList) {
            this.pointList = pointList;
            setHasStableIds(true);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            inflater = LayoutInflater.from(getActivity());
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
            return pointList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private TextView pointName;
            private TextView time;
            private ImageButton showOnTheMap;
            private Point point;


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
                        double lat = point.getLat();
                        double lon = point.getLon();
                        Intent intent = new Intent(getActivity(), MapsActivity.class);
                        intent.putExtra(LAT, lat);
                        intent.putExtra(LON, lon);
                        startActivity(intent);

                        Log.v(TAG, "Нажатие " + "Координаты лат " + point.getLat());
                        Log.v(TAG, "Нажатие " + "Координаты лон " + point.getLon());
                    }
                });

            }

            public void bind(Point point) {
                this.point = point;
                pointName.setText(point.getName());
                time.setText(android.text.format.DateFormat.format("dd-MM-yyyy (HH:mm:ss)",point.getDate()));
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
                Log.v(TAG, "Нажатие " + "Координаты лат " + point.getLat());
                Log.v(TAG, "Нажатие " + "Координаты лон " + point.getLon());


                Intent intent = PointActivity.newIntent(getActivity(), point.getUuid());
                startActivity(intent);
            }
        }
    }
}
