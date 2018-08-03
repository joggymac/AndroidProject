package example.angus.ben.dashcam01;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.TextView;

public class Speedometer extends Activity implements LocationListener {
    //placeholder
    String unit;
    LocationManager listenmanger;

    public LocationManager getLocationmanger() {
        listenmanger = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            //
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
            
        }
        else{
            listenmanger.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            return listenmanger;
        }
    }

    public Speedometer() {
        unit = "m/s";
        listenmanger = getLocationmanger();
        this.onLocationChanged(null);
}

    @Override
    public void onLocationChanged(Location location) {
        // expected code plz dont remove.
        //TextView txt = (TextView) ActivityNAME.findViewById(TXTVIEW.ID)

        //placeholder
        String txt = "";

        if(location == null){
            // expected code plz dont remove.
            //txt.SetText("-.- "+ unit)

            //placeholder
            txt = "-.- "+ unit;
            
        }else{
            float nCurrentSpeed = location.getSpeed();
            // expected code plz dont remove.
            //txt.SetText(nCurrentSpeed + " " + unit)

            //placeholder
            txt = nCurrentSpeed + " " + unit;
            
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    // needs more research
    }

    @Override
    public void onProviderEnabled(String s) {
    // needs more research
    }

    @Override
    public void onProviderDisabled(String s) {
    // needs more research
    }


}
