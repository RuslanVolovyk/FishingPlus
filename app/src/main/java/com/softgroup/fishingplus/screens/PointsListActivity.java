package com.softgroup.fishingplus.screens;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.data.GPSCurrentPosition;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.PointAdapter;
import com.softgroup.fishingplus.models.Weather;

import java.util.ArrayList;
import java.util.List;

import static com.softgroup.fishingplus.screens.SplashActivity.WEATHER;

public class PointsListActivity extends AppCompatActivity {
    private static final String TAG = PointsListActivity.class.getName();
    public static final String POINT = "point";
    public static final String POINTWEATHER = "weathepoint";

    private RecyclerView recyclerView;
    private PointAdapter pointAdapter;

    private Weather weather;
    private Location location;
    List<Point> pointList;


    public void updateUI() {


        if (pointAdapter == null) {
            pointAdapter = new PointAdapter(pointList);
            recyclerView.setAdapter(pointAdapter);
        } else {
            pointAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.point_list);
       // setHasOptionsMenu(true);
        weather = getIntent().getExtras().getParcelable(WEATHER);



        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_points);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUI();



    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_points, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_create_new_points:

                createNewPoint();


                break;


        }
        return true;
    }

    @NonNull
    private List<Point>  createNewPoint() {
        getLocationCoord();
        final List<Point> pointList = new ArrayList<>();
        Point point = new Point();


        point.setTemperature(weather.getTemp());
        point.setCondition(weather.getCondition() + weather.getDescription());
        point.setHumidity(weather.getHuminity());
        point.setWind(weather.getSpeed());
        point.setPressure(weather.getPressure());

        point.setLon(location.getLongitude());
        point.setLat(location.getLatitude());
        pointList.add(point);

        Log.v("Referee", "Referee " + weather.getTemp());
        Log.v("Referee", "Referee " + weather.getCondition());
        Log.v("Referee", "Referee " + weather.getHuminity());
        Log.v("Referee", "Referee " + weather.getSpeed());
        Log.v("Referee", "Referee " + weather.getPressure());
        Log.v("Referee", "Referee " + location.getLongitude());
        Log.v("Referee", "Referee " + location.getLatitude());

        Log.v("Referee", "Referee " + pointList);



        Intent intent = new Intent(getApplicationContext(), PointActivity.class);
        intent.putExtra(POINT, point);
        startActivity(intent);
        return pointList;
    }

    public void getLocationCoord(){
        GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(this);
        location = gpsCurrentPosition.getLocation();

    }



}

