package com.ulfat.myvivid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    android.hardware.Camera camera;
    FrameLayout frameLayout;
    ShowCamera showCamera;
    Bitmap picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout= findViewById(R.id.frameLayout);

        //Open camera :

        camera= android.hardware.Camera.open();

        showCamera= new ShowCamera(this, camera);

        frameLayout.addView(showCamera);

    }

    android.hardware.Camera.PictureCallback mPictureCallback = new android.hardware.Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, android.hardware.Camera camera) {

             picture = BitmapFactory.decodeByteArray(data, 0, data.length);




        }
    } ;

    public void captureImage(View v ){

        if(camera!= null){
            camera.takePicture(null,null,mPictureCallback);




        }

    }
}
