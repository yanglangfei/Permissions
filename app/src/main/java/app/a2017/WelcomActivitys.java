package app.a2017;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.media.MediaRecorder;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;
/**
 * Created by Administrator on 2017/1/11.
 */

public class WelcomActivitys extends Activity implements SurfaceHolder.Callback {
    private MediaRecorder mediaRecorder;
    private SurfaceView mSurfaceView;
    private SurfaceHolder holder;
    DevicePolicyManager manager;
    GLSurfaceView surfaceView=new GLSurfaceView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recoder);
        initView();
    }

    private void initView() {
        manager= (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        if(manager.getCameraDisabled(null))

        mSurfaceView= (SurfaceView) findViewById(R.id.sv);
        holder=mSurfaceView.getHolder();
        holder.setFormat(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        holder.addCallback(this);
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setVideoSize(176,144);
        mediaRecorder.setVideoFrameRate(22);
        mediaRecorder.setPreviewDisplay(holder.getSurface());
        mediaRecorder.setOutputFile("");
    }

    public  void  onStart(View view){
        try {
            mediaRecorder.prepare();
            mediaRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  void  onEnd(View view){
        mediaRecorder.stop();
        mediaRecorder.release();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            if(requestCode==100){

            }else{

            }
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
