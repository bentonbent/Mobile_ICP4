package com.example.vijaya.androidhardware;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StorageActivity extends AppCompatActivity {
    EditText txt_content;
    EditText contenttoDisplay;
    String FILENAME = "MyAppStorage2";
    private static final String tag = "AndroidHardware_log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        txt_content = (EditText) findViewById(R.id.id_txt_mycontent);
        contenttoDisplay = (EditText) findViewById(R.id.id_txt_display);
    }

    public void saveTofile(View v) throws IOException {

        String msg = txt_content.getText().toString();
        // ICP Task4: Write the code to save the text
        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
        fos.write(msg.getBytes());
        fos.close();
        Log.i(tag, msg);
    }

    public void retrieveFromFile(View v) throws IOException {

        FileInputStream fis = openFileInput(FILENAME);
        // ICP Task4: Write the code to display the above saved text
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader buffR = new BufferedReader(isr);
        String recieveString = "";
        StringBuilder sBuild = new StringBuilder();
        while((recieveString=buffR.readLine())!=null){
            sBuild.append(recieveString);
        }

        fis.close();
        String ret=sBuild.toString();
        contenttoDisplay.setText(ret);
        contenttoDisplay.setVisibility(View.VISIBLE);

    }
}
