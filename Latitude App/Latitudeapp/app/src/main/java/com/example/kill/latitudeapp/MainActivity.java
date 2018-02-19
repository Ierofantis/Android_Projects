package com.example.kill.latitudeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button click;
    EditText lat;
    EditText longt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button)findViewById(R.id.click);
        lat   = (EditText)findViewById(R.id.lat);
        longt   = (EditText)findViewById(R.id.longt);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.g_map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double latitude = 0;
        double longtitude =0;
        click.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {

                        double latitude = Double.parseDouble(lat.getText().toString());
                        double longtitude = Double.parseDouble(longt.getText().toString());
                        LatLng mark = new LatLng( latitude, longtitude);
                        //Log.v("longt", String.valueOf(latitude));
                        mMap.addMarker(new MarkerOptions().position(mark).title("Seattle"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(mark));
                    }
                });
    }
}