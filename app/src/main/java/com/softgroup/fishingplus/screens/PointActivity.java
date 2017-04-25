package com.softgroup.fishingplus.screens;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.models.Point;
import com.softgroup.fishingplus.models.Weather;

import static com.softgroup.fishingplus.screens.PointsListActivity.POINT;


public class PointActivity extends AppCompatActivity {
    static double lat;
    static double lon;
    private static final String TAG = PointActivity.class.getName();
    static private Location location;
    public static final String POINT_ID = "Point id";
    public static final String LAT = "latitude";
    public static final String LON = "longitude";
    Point point;
    static Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


         point = (Point) getIntent().getSerializableExtra(POINT);


        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment =createFragment();

            fragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }



//    public static Intent newIntent(Context context){
//
//        Intent intent = new Intent (context, PointActivity.class);
//      //  intent.putExtra(POINT_ID, uuid);
//        return intent;
//    }

    protected Fragment createFragment() {
      // UUID uuid = (UUID) getIntent().getSerializableExtra(POINT_ID);
       // return newInstance(uuid);
//    }
//    public static PointFragment newInstance(UUID uuid){
       // Bundle arg = new Bundle();
        //*arg.putParcelable(WEATHER, weather);
        //arg.putSerializable(ARGUMENTS, uuid);


        Bundle bundle = new Bundle();
        bundle.putSerializable(POINT, point);


        PointFragment pointFragment = new PointFragment();
        pointFragment.setArguments(bundle);
        return pointFragment;
    }

//    public class WeatherTaskPoint extends AsyncTask<String, Void, Point> {
//
//        @Override
//        protected Point doInBackground(String... strings) {
//
//            if (strings.length == 0) {
//                return null;
//            }
//            String data = ((new WeatherHttpClient()).getWeatherData(strings[0]));
//
//            if (data == null) {
//                Log.v(TAG, "Data null");
//                return null;
//            } else {
//                Log.v(TAG, "Data "+ data);
//            }
//            point = JsonparserPOint.getWeatherPoint(data);
//
//            if (point == null) {
//                Log.v(TAG, "Weather null");
//
//                return null;
//            } else {
//                Log.v(TAG, "Weather " + point.getTemperature());
//
//            }
//            return point;
//        }
//
//        @Override
//        protected void onPostExecute(Point point) {
//            super.onPostExecute(point);
//
//
//        }
//    }

}
