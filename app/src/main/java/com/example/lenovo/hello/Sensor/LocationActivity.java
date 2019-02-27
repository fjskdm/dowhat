package com.example.lenovo.hello.Sensor;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.lenovo.hello.R;

import java.util.Iterator;
import java.util.List;

public class LocationActivity extends AppCompatActivity {

    private TextView tv_1, tv_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_1 = findViewById(R.id.textview);
        tv_2 = findViewById(R.id.textview1);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        /************************获取能取得定位信息的locationProvider***********************/
//        List<String> providerNames = locationManager.getAllProviders();
//        StringBuilder stringBuilder = new StringBuilder();
//        for(Iterator<String> iterator = providerNames.iterator();iterator.hasNext();){
//            stringBuilder.append(iterator.next()+"\n");
//        }
//        tv_1.setText(stringBuilder.toString());

        /******************获得基于GPS的locationProvider(通过名称获得locationProvider)********************/
//        LocationProvider locationProvider = locationManager.getProvider(LocationManager.GPS_PROVIDER);
//        tv_1.setText(locationProvider.getName());

        /**************************获得最佳的LocationProvider(使用Criteria类)****************************/
        Criteria criteria = new Criteria();
        criteria.setCostAllowed(false);//是否收费
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//精度
        criteria.setPowerRequirement(Criteria.POWER_LOW);//耗电量
        String provider = locationManager.getBestProvider(criteria, true);
        tv_1.setText(provider);

            /**********************动态定位***********************/
            //权限检查
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER//位置提供者
                    , 1000//间隔时间
                    , 1//位置间隔1米
                    , new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {//信息改变时触发
                            locationUpdates(location);
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {//信息状态改变时触发

                        }

                        @Override
                        public void onProviderEnabled(String provider) {//定位信息提供者启动时回调

                        }

                        @Override
                        public void onProviderDisabled(String provider) {//定位信息提供者关闭时回调

                        }
                    });
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationUpdates(location);

    }

    public void locationUpdates(Location location){
        if(location != null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("您的位置时：\n");
            stringBuilder.append("经度：");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\n纬度：");
            stringBuilder.append(location.getLatitude());
            tv_2.setText(stringBuilder.toString());
        }else {
            tv_2.setText("没有位置信息");
        }
    }
}
