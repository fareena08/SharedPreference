package com.example.mysharedpreferences_a181617;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_language, tv_sound;
    LinearLayout ll_setting_notification, ll_setting_language, ll_setting_bluetooth, ll_setting_location, ll_setting_sound;
    Switch switch_notification, switch_bluetooth, switch_location;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SP_LANGUAGE = "language";
    String SP_NOTIFICATION = "notification";
    String SP_BLUETOOTH = "bluetooth";
    String SP_LOCATION = "location";
    String SP_SOUND = "sound";

    String[] values = {"English", "Melayu", "Chinese", "Tamil"};
    AlertDialog alertDialog;

    String[] valuesSound = {"Sound", "Vibrate", "Mute"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_language = findViewById(R.id.tv_language);
        tv_sound = findViewById(R.id.tv_sound);
        switch_notification = findViewById(R.id.switch_notification);
        switch_bluetooth = findViewById(R.id.switch_bluetooth);
        switch_location = findViewById(R.id.switch_location);
        ll_setting_language = findViewById(R.id.ll_setting_language);
        ll_setting_notification = findViewById(R.id.ll_setting_notification);
        ll_setting_bluetooth = findViewById(R.id.ll_setting_bluetooth);
        ll_setting_location = findViewById(R.id.ll_setting_location);
        ll_setting_sound = findViewById(R.id.ll_setting_sound);

        sharedPreferences = getSharedPreferences("app_settings", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        switch_notification.setChecked(sharedPreferences.getBoolean(SP_NOTIFICATION, false));
        tv_language.setText(values[sharedPreferences.getInt(SP_LANGUAGE,0)]);
        switch_bluetooth.setChecked(sharedPreferences.getBoolean(SP_BLUETOOTH, false));
        switch_location.setChecked(sharedPreferences.getBoolean(SP_LOCATION, false));
        tv_sound.setText(valuesSound[sharedPreferences.getInt(SP_SOUND, 0)]);

        switch_notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SP_NOTIFICATION, b);
                editor.commit();
            }
        });
        ll_setting_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean switchState = switch_notification.isChecked();

                switch_notification.setChecked(!switchState);
                editor.putBoolean(SP_NOTIFICATION, !switchState);
                editor.commit();
            }
        });
        ll_setting_language.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ShowLanguageOptions();
            }
        });

        switch_bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SP_BLUETOOTH, b);
                editor.commit();
            }
        });
       ll_setting_bluetooth.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Boolean switchState = switch_bluetooth.isChecked();

               switch_bluetooth.setChecked(!switchState);
               editor.putBoolean(SP_BLUETOOTH, !switchState);
               editor.commit();
           }
       });
        switch_location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                editor.putBoolean(SP_LOCATION, b);
                editor.commit();
            }
        });
        ll_setting_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean switchState = switch_bluetooth.isChecked();

                switch_location.setChecked(!switchState);
                editor.putBoolean(SP_LOCATION, !switchState);
                editor.commit();
            }
        });
        ll_setting_sound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ShowSoundOptions();
            }
        });

    }
    public void ShowLanguageOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select your language" );
        builder.setSingleChoiceItems(values, sharedPreferences.getInt(SP_LANGUAGE,0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        editor.putInt(SP_LANGUAGE, 0);
                        editor.commit();
                        break;

                    case 1:
                        editor.putInt(SP_LANGUAGE, 1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_LANGUAGE, 2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_LANGUAGE, 3);
                        editor.commit();
                        break;

                }
                alertDialog.dismiss();
                tv_language.setText(values[sharedPreferences.getInt(SP_LANGUAGE,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
    public void ShowSoundOptions() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select sound" );
        builder.setSingleChoiceItems(valuesSound, sharedPreferences.getInt(SP_SOUND,0), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i) {
                    case 0:
                        editor.putInt(SP_SOUND, 0);
                        editor.commit();
                        break;

                    case 1:
                        editor.putInt(SP_SOUND, 1);
                        editor.commit();
                        break;
                    case 2:
                        editor.putInt(SP_SOUND, 2);
                        editor.commit();
                        break;
                    case 3:
                        editor.putInt(SP_SOUND, 3);
                        editor.commit();
                        break;

                }
                alertDialog.dismiss();
                tv_sound.setText(valuesSound[sharedPreferences.getInt(SP_SOUND,0)]);
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

}