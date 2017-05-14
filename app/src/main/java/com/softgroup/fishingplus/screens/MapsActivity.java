package com.softgroup.fishingplus.screens;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.softgroup.fishingplus.R;
import com.softgroup.fishingplus.Utils;
import com.softgroup.fishingplus.data.GPSCurrentPosition;

import static com.softgroup.fishingplus.R.id.map;
import static com.softgroup.fishingplus.screens.PointListFragment.LAT;
import static com.softgroup.fishingplus.screens.PointListFragment.LON;


//        GoogleApiClient.ConnectionCallbacks,
//        GoogleApiClient.OnConnectionFailedListener,
//        LocationListener

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    //  public static final int MY_PERMISSIONS_REQUEST_LOCATION = 101;
    private static final String TAG = MapsActivity.class.getName();

    private GoogleMap mMap;
    //    GoogleApiClient mGoogleApiClient;
//    Location mLastLocation;
//    Marker mCurrLocationMarker;
//    LocationRequest mLocationRequest;
    double latPointMarker;
    double lonPointMarker;

    double currentLatitudePositionMarker;
    double currentLongitudePositionMarker;

    Location location;

    private Marker currentPositionMarker;
    private Marker pointPositionMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        GPSCurrentPosition gpsCurrentPosition = new GPSCurrentPosition(this);

        location = gpsCurrentPosition.getLocation();

        if (location == null) {
            Toast.makeText(this, "Проверьте подключение к геолокации", Toast.LENGTH_LONG).show();
        } else {

            currentLatitudePositionMarker = location.getLatitude();
            currentLongitudePositionMarker = location.getLongitude();

        }

        latPointMarker = getIntent().getDoubleExtra(LAT, 0.0);
        lonPointMarker = getIntent().getDoubleExtra(LON, 0.0);

        Log.v(TAG, "Нажатие " + "Ветер " + latPointMarker);
        Log.v(TAG, "Нажатие " + "Ветер " + lonPointMarker);

        // showLineOntheMap(latPointMarker, lonPointMarker);

//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            checkLocationPermission();
//        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }

    //    public void showLineOntheMap(){
//        Polyline line = mMap.addPolyline(new PolylineOptions()
//                .add(new LatLng(-37.81319, 144.96298), new LatLng(-31.95285, 115.85734))
//                .width(25)
//                .color(Color.BLUE)
//                .geodesic(true));
//    }
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (latPointMarker == 0.0 & lonPointMarker == 0.0) {

            LatLng latLng = new LatLng(currentLatitudePositionMarker, currentLongitudePositionMarker);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title(ChatActivity.getUsername());
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            currentPositionMarker = mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(11));


//            currentPositionMarker = mMap.addMarker(new MarkerOptions()
//                    .position(new LatLng(currentLatitudePositionMarker, currentLongitudePositionMarker))
//                    .title(ChatActivity.getUsername()));
//


        } else {
            LatLng latLng = new LatLng(currentLatitudePositionMarker, currentLongitudePositionMarker);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title(ChatActivity.getUsername());
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            currentPositionMarker = mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

            double distance = getDistanceBeetwenTwoPoints(currentLatitudePositionMarker, currentLongitudePositionMarker, latPointMarker, lonPointMarker);
            distance = Utils.convertToKm(distance);


            pointPositionMarker = mMap.addMarker(new MarkerOptions()
                    .snippet(String.valueOf("К точке " + String.format("%.2f", distance)) + " км")
                    .position(new LatLng(latPointMarker, lonPointMarker))// Поставить координаты latPointMarker, lonPointMarker
                    .title("Цель"));


            Polyline line = mMap.addPolyline(new PolylineOptions()
                    .add(new LatLng(currentLatitudePositionMarker, currentLongitudePositionMarker),
                            new LatLng(latPointMarker, lonPointMarker)) // Поставить координаты latPointMarker, lonPointMarker
                    .width(5)
                    .color(Color.RED)
                    .geodesic(true));

        }


//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)
//                    == PackageManager.PERMISSION_GRANTED) {
//                //buildGoogleApiClient();
//                mMap.setMyLocationEnabled(true);
//                if (latPointMarker!= 0.0 & lonPointMarker!=0.0){
//                    currentPositionMarker = mMap.addMarker(new MarkerOptions()
//                            .position(new LatLng(49.122356,33.256589))
//                            .title("Цель"));
//                    currentPositionMarker.setTag(0);
//                }else {
//                    Toast.makeText(this, "Точка не найдена", Toast.LENGTH_SHORT).show();
//                }
//            }
//        } else {
//            if (latPointMarker!= 0.0 & lonPointMarker!=0.0){
//                currentPositionMarker = mMap.addMarker(new MarkerOptions()
//                        .position(new LatLng(49.122356,33.256589))
//                        .title("Цель"));
//                currentPositionMarker.setTag(0);
//                //buildGoogleApiClient();
//                mMap.setMyLocationEnabled(true);
//            }else {
//                Toast.makeText(this, "Точка не найдена", Toast.LENGTH_SHORT).show();
//            }
//
//        }
    }

//    protected synchronized void buildGoogleApiClient() {
//        mGoogleApiClient = new GoogleApiClient.Builder(this)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .addApi(LocationServices.API)
//                .build();
//        mGoogleApiClient.connect();
//    }

//    @Override
//    public void onConnected(Bundle bundle) {
//
//        mLocationRequest = new LocationRequest();
//        mLocationRequest.setInterval(1000);
//        mLocationRequest.setFastestInterval(1000);
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                == PackageManager.PERMISSION_GRANTED) {
//            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//        }
//
//    }

//    @Override
//    public void onConnectionSuspended(int i) {
//    }

//    @Override
//    public void onLocationChanged(Location location) {
//        mLastLocation = location;
//        if (mCurrLocationMarker != null) {
//            mCurrLocationMarker.remove();
//        }
//        //Place current location marker
//        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(latLng);
//        markerOptions.title(ChatActivity.getUsername());
//
//        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
//        mCurrLocationMarker = mMap.addMarker(markerOptions);
//        //move map camera
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
//        //stop location updates
//        if (mGoogleApiClient != null) {
//            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
//        }
//    }

//    @Override
//    public void onConnectionFailed(ConnectionResult connectionResult) {
//    }

//    public boolean checkLocationPermission() {
//        if (ContextCompat.checkSelfPermission(this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//            } else {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                        MY_PERMISSIONS_REQUEST_LOCATION);
//            }
//            return false;
//        } else {
//            return true;
//        }
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_LOCATION: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    if (ContextCompat.checkSelfPermission(this,
//                            Manifest.permission.ACCESS_FINE_LOCATION)
//                            == PackageManager.PERMISSION_GRANTED) {
//                        if (mGoogleApiClient == null) {
//                            buildGoogleApiClient();
//                        }
//                        mMap.setMyLocationEnabled(true);
//                    }
//                } else {
//                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
//                }
//            }
//
//        }
//    }

    public double getDistanceBeetwenTwoPoints(double latCurrent, double lonCurrent, double latPointer, double lonPointer) {

        Location currentPoint = new Location("Текущее положение");
        currentPoint.setLatitude(latCurrent);
        currentPoint.setLongitude(lonCurrent);

        Location changePoint = new Location("Сохранення точка");
        changePoint.setLatitude(latPointer);
        changePoint.setLongitude(lonPointer);

        double distance = currentPoint.distanceTo(changePoint);
        return distance;
    }
}