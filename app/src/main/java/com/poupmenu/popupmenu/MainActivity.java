package com.poupmenu.popupmenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_CODE_CHOOSE_PICTURE = 13; // can be any integer number



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this::showPopupMenu); // using lambda




    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.menu_upload, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.take_picture) {
                choosePicture();
            } else if (item.getItemId() == R.id.choose_picture) {
                choosePicture();
            }
            return true;
        });
        popupMenu.show();
    }

    private void choosePicture() {
        Intent intent = new Intent();
        intent.setType("images/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        if (intent.resolveActivity(this.getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_CODE_CHOOSE_PICTURE);
        }
    }

}
