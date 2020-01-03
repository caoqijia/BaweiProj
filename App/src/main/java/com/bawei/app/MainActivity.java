package com.bawei.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bawei.app.service.MyService;
import com.bawei.basemodule.val.ValPool;

/**
 * @author FreePay
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, MyService.class));
        ARouter.getInstance().build(ValPool.SKIP_LOGIN).navigation();
        finish();
    }
}
