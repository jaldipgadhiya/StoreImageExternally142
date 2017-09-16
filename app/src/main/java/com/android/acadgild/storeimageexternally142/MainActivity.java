package com.android.acadgild.storeimageexternally142;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnStoreExternally = (Button) findViewById(R.id.btnStoreExternally);
        // Get the bitmap from drawable object

        btnStoreExternally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get Drawable Image

                Drawable drawable = getDrawable(R.drawable.entertainment);

                //Crete Bitmap object

                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

                File file;

                // Get path to store image from drawable
                String path = Environment.getExternalStorageDirectory().toString();

                // Get File object

                file = new File(path, "entertainment"+".png");

                try{
                    //FileOutPutstream object
                    FileOutputStream stream = new FileOutputStream(file);
                    //compress image
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                    //Stream flush
                    stream.flush();
                    //Stream close
                    stream.close();
                }
                catch (IOException e) // Catch the exception
                {
                    e.printStackTrace();
                }

                Uri savedImageURI = Uri.parse(file.getAbsolutePath());

                Toast.makeText(MainActivity.this, "Image saved in external storage."+"\n" + savedImageURI, Toast.LENGTH_LONG).show();


            }
        });

    }
}
