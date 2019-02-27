package com.example.lenovo.hello;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.example.lenovo.hello.util.ToastUtil;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar tb_1;
    private DrawerLayout dl_1;
    private NavigationView nv_1;
    private RelativeLayout rl_1;
    private SwipeRefreshLayout sw_1;

    private MapView mapView = null;
    private BaiduMap baiduMap = null;
    LocationClient locationClient = null;
    LocationClientOption locationClientOption = null;
    MyLocationListener myLocationListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        tb_1 = findViewById(R.id.TB_1);
        setSupportActionBar(tb_1);
        dl_1 = findViewById(R.id.DL_1);
        nv_1 = findViewById(R.id.NV_1);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.home1);
        }

        locationClient = new LocationClient(getApplicationContext());
        locationClientOption = new LocationClientOption();
        myLocationListener = new MyLocationListener();
        mapView = findViewById(R.id.MV_1);
        baiduMap = mapView.getMap();
        initLocationOption();

        nv_1.setCheckedItem(R.id.friend_bar);
        nv_1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.friend_bar:
                        ToastUtil.showMsg(ToolBarActivity.this,"点击了friend");
                        dl_1.closeDrawers();
                        break;
                    case R.id.location_bar:
                        ToastUtil.showMsg(ToolBarActivity.this,"点击了location");
                        dl_1.closeDrawers();
                        break;
                    case R.id.mail_bar:
                        ToastUtil.showMsg(ToolBarActivity.this,"点击了mail");
                        dl_1.closeDrawers();
                        break;
                }
                return true;
            }
        });

        sw_1 = findViewById(R.id.SW_1);
        sw_1.setColorSchemeResources(R.color.colorPrimary);
        sw_1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ToastUtil.showMsg(ToolBarActivity.this,"刷新成功");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sw_1.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        rl_1 = findViewById(R.id.RL_1);
        rl_1.getBackground().mutate().setAlpha(100);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_bar:
                ToastUtil.showMsg(ToolBarActivity.this,"点击了:search");
                break;
            case R.id.about:
                ToastUtil.showMsg(ToolBarActivity.this,"点击了:about");
                break;
            case R.id.setting:
                ToastUtil.showMsg(ToolBarActivity.this,"点击了:setting");
                break;
            case android.R.id.home:
                dl_1.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    private void initLocationOption(){
        locationClient.registerLocationListener(myLocationListener);
        locationClientOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        locationClientOption.setCoorType("gcj02");
        locationClientOption.setScanSpan(1000);
        locationClientOption.setNeedDeviceDirect(true);
        locationClientOption.setOpenGps(true);
        locationClientOption.setOpenAutoNotifyMode();
        locationClient.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        locationClient.unRegisterLocationListener(myLocationListener);
        locationClient.stop();
    }

    private class MyLocationListener extends BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            double latitude = bdLocation.getLatitude();
            double longitude = bdLocation.getLongitude();
            float radius = bdLocation.getRadius();
            String coorType = bdLocation.getCoorType();
            int errorType = bdLocation.getLocType();
            ToastUtil.showMsg(ToolBarActivity.this,"显示一下"+coorType);
            baiduMap.setMyLocationEnabled(true);
            // 构造定位数据
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(radius)//
                    .latitude(latitude)//
                    .longitude(longitude)//
                    .build();
            // 设置定位数据
            baiduMap.setMyLocationData(locData);
            MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.FOLLOWING,false,null,R.color.colorFill,R.color.colorStroke);
            baiduMap.setMyLocationConfiguration(config);
        }
    }
}
