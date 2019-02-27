package com.example.lenovo.hello.util;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LocationUtil extends AppCompatActivity {

    public Location LocationInit(LocationListener locationListener) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER//位置提供者
                , 1000//间隔时间
                , 1//位置间隔1米
                , locationListener);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return location;
    }

    public void showLocation(TextView view){
        Location location = this.LocationInit(new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        });
        if(location != null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("经度：");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\t纬度：");
            stringBuilder.append(location.getLatitude());
            view.setText(stringBuilder.toString());
        }else {
            view.setText("没有位置信息");
        }
    }


    public void showLocation(TextView view,Location location){
        if(location != null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("经度：");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\t纬度：");
            stringBuilder.append(location.getLatitude());
            view.setText(stringBuilder.toString());
        }else {
            view.setText("没有位置信息");
        }
    }
}
