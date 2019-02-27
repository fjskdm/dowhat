package com.example.lenovo.hello.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.hello.R;

public class AFragment extends Fragment {

    private TextView tv_1;
    private Button btn;
    private IOnMessageClick listener;

//    为了传入数据而设立的新的构造方法
    public static AFragment newInstance(String title){
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }


//    Fragment中构造的接口
    public interface IOnMessageClick{
        void onClick(String data);
    }
//    与构造的接口配合使用的函数，在Fragment连接上Activity的时候使用，确定Fragment传递的Activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException("avtivity 为实现IOnMessageClick接口");
        }
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_1 = view.findViewById(R.id.tv_title);
        btn = view.findViewById(R.id.btn_message);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                通信方法1 使用Activity中的函数
//                ((FragmentActivity)getActivity()).setData("set data");
//                通信方法2 使用fragment中的构造的接口
                listener.onClick("set data");
            }
        });
        if(getArguments() != null){
            tv_1.setText(getArguments().getString("title"));
        }
    }
}
