package ulab.edu.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonTakePhoto;   //create a button object
    ImageView keepImageHere; //create a imageView object
    private static final int CAMERA_REQUEST = 500; //set timeout for camera request

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Take a picture to detect color",Toast.LENGTH_LONG);
        keepImageHere = (ImageView)findViewById(R.id.keepImageHere);
        buttonTakePhoto = (Button)findViewById(R.id.buttonTakePhoto);


    }

    public void takePhoto(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent,CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
            Bitmap image = (Bitmap)data.getExtras().get("data");
            keepImageHere.setImageBitmap(image);
        }
    }
}
