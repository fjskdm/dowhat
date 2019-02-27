package com.example.lenovo.hello;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.example.lenovo.hello.util.LocationUtil;
import com.example.lenovo.hello.util.ToastUtil;

import java.util.Map;

public class MapSDKActivity extends LocationUtil {
    //标记为1的为定位功能
    //标记为2的为提醒功能
    private MapView mapView = null;//1

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location;
    private TextView tv_1;
    private Button btn_1;
    private BaiduMap baiduMap = null;
    private RadioGroup rg_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_sdk);
        layout_init();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        baiduMap = mapView.getMap();
        rg_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb_1 = group.findViewById(checkedId);
                if(rb_1.getText().equals("一般地图")){
                    baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                }else {
                    baiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                }
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkMyLocation();
            }
        });
        super.showLocation(tv_1);
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            checkMyLocation();
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
    };

    public void layout_init(){
        mapView = findViewById(R.id.bmapView);
        rg_1 = findViewById(R.id.RG_1);
        btn_1 = findViewById(R.id.BTN1_1);
        tv_1 = findViewById(R.id.TV_1);
    }

    public void checkMyLocation(){//1
        location = super.LocationInit(locationListener);
        while (location == null){
            ToastUtil.showMsg(MapSDKActivity.this,"正在查找你的地址");
        }
        BitmapDescriptor customMarker = BitmapDescriptorFactory.fromResource(R.drawable.icon);
        baiduMap.setMyLocationEnabled(true);
        MyLocationData locationData = new MyLocationData.Builder()
                .latitude(location.getLatitude())
                .longitude(location.getLongitude())
                .accuracy(location.getAccuracy())
                .build();
        baiduMap.setMyLocationData(locationData);
        MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING,false,null,R.color.colorFill,R.color.colorStroke);
        baiduMap.setMyLocationConfiguration(config);
        super.showLocation(tv_1,location);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        baiduMap.setMyLocationEnabled(false);
        mapView.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

}
