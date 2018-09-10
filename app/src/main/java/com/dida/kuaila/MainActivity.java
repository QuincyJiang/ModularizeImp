package com.dida.kuaila;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dida.commonservicelib.base.BaseActivity;
import com.dida.commonservicelib.path.ARouterPath;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = $(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build(ARouterPath.FUNNY_STORY_ACTIVITY)
                        .withTransition(R.anim.activity_up_in, R.anim.activity_up_out)
                        .navigation(MainActivity.this, new NavCallback() {
                            @Override
                            public void onFound(Postcard postcard) {
                                Log.i(TAG, "ARouter onFound");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.i(TAG, "ARouter onLost");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.i(TAG, "ARouter onArrival");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.i(TAG, "ARouter onInterrupt");
                            }
                        });

            }
        });
    }


}
