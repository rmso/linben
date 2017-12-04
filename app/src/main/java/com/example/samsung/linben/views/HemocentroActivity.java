package com.example.samsung.linben.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.samsung.linben.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Raquel on 06/07/2016.
 */
public class HemocentroActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Button btn_verRota;
    private TextView tv_link;
    private GoogleMap mMap;
    LatLng latLng;
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hemocentro);

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)) {

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_verRota = (Button) findViewById(R.id.btn_ver_rota);
        tv_link = (TextView) findViewById(R.id.tv_link);

        tv_link.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HemocentroActivity.this, WebViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        latLng = new LatLng(-8.05428, -34.8813);

        mMap.clear();

        CameraPosition position = new CameraPosition.Builder().target(latLng).zoom(12).build();
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(position);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng).title("Position");

        Marker marker = mMap.addMarker(markerOptions);
        marker.setPosition(latLng);

        mMap.animateCamera(update, 1000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
            }

            @Override
            public void onCancel() {
            }
        });
    }
}
