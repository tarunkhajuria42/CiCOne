package AudioProbe;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.os.Bundle;
public class ProbeActivation extends PhoneStateListener{
	private static final int BufferElements2Rec = 1024;
	private static final int BytesPerElement = 2;
	int prevstate=TelephonyManager.CALL_STATE_IDLE;  
	byte[] audioData;
	AudioRecord audiorecorder;
	
	
	//Listen to phone state
	@Override
	public void onCallStateChanged(int state,String incomingNumber)
	{
		Log.d("Tarun","Comming here");
		switch(state)
		{
		case TelephonyManager.CALL_STATE_IDLE:
			if(prevstate==TelephonyManager.CALL_STATE_OFFHOOK)
			{
				audiorecorder.stop();
			}
			prevstate=TelephonyManager.CALL_STATE_IDLE;
			break;
		case TelephonyManager.CALL_STATE_RINGING:
			prevstate=TelephonyManager.CALL_STATE_RINGING;
			break;
		case TelephonyManager.CALL_STATE_OFFHOOK:
			Log.d("Tarun","It Started");
			try
			{
				audiorecorder=new AudioRecord(MediaRecorder.AudioSource.VOICE_UPLINK,44100,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT,AudioRecord.getMinBufferSize(44100,AudioFormat.CHANNEL_IN_MONO,AudioFormat.ENCODING_PCM_16BIT)*10);
				Log.d("Tarun","Instantiated");
			}
			catch(Exception e)
			{
				Log.e("Tarun","Caught creating instance"+e);
			}
			try
			{
				audiorecorder.startRecording();	
				
			}
			catch(Exception e)
			{
				Log.e("Datalist","Caught at StartRecording");
				//Catch it later
			}
			try
			{
			audiorecorder.read(audioData,0,10);
			
			Log.d("Read Audio","Recording seems complete");
			 FileOutputStream os = new FileOutputStream("/sdcard/8k16bitMono.dat");
			 Log.d("filestream","created");
			os.write(audioData,0,audioData.length);
			}
			catch(Exception e)
			{
			Log.e("Datalist","Caught at Reading"+e); 	
			}
			prevstate=TelephonyManager.CALL_STATE_OFFHOOK;
			break;
		}
	}
/*	
	private void writeAudioDataToFile() {
		  // Write the output audio in byte
		  String filePath = "/sdcard/8k16bitMono.pcm";
		  
		 short sData[] = new short[BufferElements2Rec];

		  FileOutputStream os = null;
		  try {
		   os = new FileOutputStream(filePath);
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }

		  while (isRecording) {
		   // gets the voice output from microphone to byte format
		   recorder.read(sData, 0, BufferElements2Rec);
		   System.out.println("Short wirting to file" + sData.toString());
		   try {
		    // writes the data to file from buffer stores the voice buffer
		    byte bData[] = short2byte(sData);

		    os.write(bData, 0, BufferElements2Rec * BytesPerElement);

		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		  }

*/
	

}
