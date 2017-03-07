package app.a2017;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toast.makeText(this, getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            //未赋予权限  在Fragment中申请权限， 直接使用Fragment的requestPermissions方法
            // 在子Fragment中，建议使用 getParentFragment().requestPermissions方法，父Fragment onRequestPermissionsResult
            // 方法中需要判断子Fragment 是否不为null ,回调子 Fragment 的onRequestPermissionsResult方法
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},100);
        }else{
            callPhone("15802954021");
        }
    }

    private void callPhone(String tel) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+tel));
        startActivity(intent);
    }

    public void sendMessage(String to,String body){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:"+to));
        intent.putExtra("sms_body",body);
        startActivity(intent);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100){
            //请求Call 权限返回
            int result=grantResults[0];
            if(result==PackageManager.PERMISSION_GRANTED){
                //权限赋予
                callPhone("15802954021");
            }else {
                Toast.makeText(this, "打电话权限被取消", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
