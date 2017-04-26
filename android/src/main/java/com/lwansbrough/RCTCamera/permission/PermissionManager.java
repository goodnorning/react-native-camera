package com.lwansbrough.RCTCamera.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;
import android.util.Log;

import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

/**
 * Created by derrick on 24/04/17.
 */

public class PermissionManager {

    private static final String TAG = "PermissionManager";

    public static boolean isM(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ;
    }
    public static boolean hasPermission(Context context,String permission){
        boolean result = ActivityCompat.checkSelfPermission(context, permission)== PackageManager.PERMISSION_GRANTED;
        Log.i(TAG,"hasPermission : "+result);
            
        return result;
    }
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode,PermissionListener listener){
        Log.i(TAG,"requestPermissions : "+permissions);
        
        //ActivityCompat.requestPermissions(activity, permissions, requestCode);
        ((PermissionAwareActivity)  activity).requestPermissions(permissions,requestCode,listener);
        /*new PermissionListener() {
            @Override
            public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
                Log.i(TAG,"onRequestPermissionsResult : "+permissions);
                if (requestCode == 1) {
                    for (int grantResult : grantResults) {
                        if (grantResult == PackageManager.PERMISSION_DENIED) {
                            //permissionPromise.resolve(false);
                            return true;
                        }
                    }

                    //permissionPromise.resolve(true);
                }

                return true;
            }
        });*/
    }

    public static void onRequestPermissionsResult(Activity activity, int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults,PermissionUtils.PermissionGrant permissionGrant) {
        Log.i(TAG,"onRequestPermissionsResult : "+requestCode);
        PermissionUtils.requestPermissionsResult(activity, requestCode, permissions, grantResults, permissionGrant);
    }
    

}
