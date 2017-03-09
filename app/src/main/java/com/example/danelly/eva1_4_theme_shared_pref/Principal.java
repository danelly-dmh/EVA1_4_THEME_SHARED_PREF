package com.example.danelly.eva1_4_theme_shared_pref;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Set;

public class Principal extends AppCompatActivity {
    RadioGroup rg;
    RadioButton tRosa, tVerde;
    SharedPreferences shPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        shPref = getSharedPreferences("misdatos", Activity.MODE_PRIVATE);
        int tema = shPref.getInt("tema", R.style.AppTheme);
        android:setTheme(tema);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        tRosa = (RadioButton)findViewById(R.id.tRosa);
        tVerde = (RadioButton)findViewById(R.id.tVerde);
        tema = shPref.getInt("tema", R.style.AppTheme);

    }
    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        SharedPreferences.Editor edtDatos = shPref.edit();
        switch(view.getId()) {
            case R.id.tRosa:
                if(checked)
                edtDatos.putInt("tema", R.style.rosado);
                edtDatos.commit();
                recreate();
                break;
            case R.id.tVerde:
                if(checked)

                edtDatos.putInt("tema", R.style.jardin);
                edtDatos.commit();
                recreate();
                break;
        }
        shPref = getSharedPreferences("misdatos", Activity.MODE_PRIVATE);
    }
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor edtDatos = shPref.edit();
        edtDatos.commit();
    }
}