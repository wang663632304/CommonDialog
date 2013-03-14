package com.geniusgithub.commondialog.util;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;



public class Utils {
	
	public static int getScreenWidth(Context context) {
		WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getWidth();
	}
	
	public static int getScreenHeight(Context context) {
		WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		return display.getHeight();
	}
	
	public static float getScreenDensity(Context context) {
    	try {
    		DisplayMetrics dm = new DisplayMetrics();
	    	WindowManager manager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
	    	manager.getDefaultDisplay().getMetrics(dm);
	    	return dm.density;
    	} catch(Exception ex) {
    	
    	}
    	return 1.0f;
    }

	public static String toHexString(int num)
	{
		String string = "0x" + Integer.toHexString(num);
		return string;
	}
	
	
	public static String getPackageVersionName(Context context) throws Exception
	{
		
       PackageManager packageManager = context.getPackageManager();
       
       PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
       String version = packInfo.versionName;
       return version;
	}
	
	public static String getOSVersion()
	{
		return android.os.Build.VERSION.RELEASE;
	}
	
	public static String getDeviceManufacturer()
	{
		return android.os.Build.MANUFACTURER;
	}
	
	public static String getDeviceModel()
	{
		return android.os.Build.MODEL;
	}

	public static void showToast(Context context, int tip)
	{
		Toast.makeText(context, tip, Toast.LENGTH_SHORT).show();
	}
	public static void showToast(Context context, String tip)
	{
		Toast.makeText(context, tip, Toast.LENGTH_SHORT).show();
	}
	

}