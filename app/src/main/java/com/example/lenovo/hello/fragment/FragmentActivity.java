package com.example.lenovo.hello.fragment;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.hello.R;

public class FragmentActivity extends AppCompatActivity implements AFragment.IOnMessageClick{

    private AFragment aFragment;
    private BFragment bFragment;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        btn = findViewById(R.id.btn_change);
        tv = findViewById(R.id.tv_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null) {
                    bFragment = new BFragment();
                }

                //addToBackStack 是设置按返回键返回上一个fragment
                //注释的为保留上一fragment的状态，上个fragment不会被重置
//                Fragment fragment = new BFragment();
//                if(fragment != null){
//                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_show,bFragment).addToBackStack(null).commitAllowingStateLoss();
//                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_show,bFragment).addToBackStack(null).commitAllowingStateLoss();
//                }
            }
        });
        aFragment = AFragment.newInstance("show the new");
        //添加AFargment到Activity中，记得使用commit方法
        getFragmentManager().beginTransaction().add(R.id.fl_show,aFragment,"1").commitAllowingStateLoss();

    }
//    为传递数据构造的方法
    public void setData(String data){
        tv.setText(data);
    }

//    实现接口
    @Override
    public void onClick(String data) {
        tv.setText(data);
    }
}
