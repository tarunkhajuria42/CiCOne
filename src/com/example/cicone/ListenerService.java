package com.example.cicone;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import edu.mit.media.funf.FunfManager;
import edu.mit.media.funf.pipeline.BasicPipeline;
import AudioProbe.DataList;
import AudioProbe.ProbeActivation;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class ListenerService extends Service {
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	@Override
	public int onStartCommand(Intent intent,int flags,int startId)
	{
		super.onStartCommand(intent, flags, startId);
        TelephonyManager manager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        manager.listen(new ProbeActivation(), PhoneStateListener.LISTEN_CALL_STATE);
		return START_STICKY;
	}
	@Override
	public void onCreate()
	{
		super.onCreate();
		
	}

}
