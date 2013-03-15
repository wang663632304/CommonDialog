package com.geniusgithub.commondialog;

import com.geniusgithub.commondialog.util.CommonLog;
import com.geniusgithub.commondialog.util.LogFactory;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestActivity extends Activity implements OnClickListener{

private static final CommonLog log = LogFactory.createLog();
	
	private Button mButton1;
	private Button mButton2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity_layout);
		log.e("onCreate");
		
		setupViews();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		log.e("onDestroy");
	}

	
	
	private void setupViews(){
		mButton1 = (Button) findViewById(R.id.button1);
		mButton1.setOnClickListener(this);
		mButton2 = (Button) findViewById(R.id.button2);
		mButton2.setOnClickListener(this);
		
	
	}

	
	private final static int DILOG1_ID = 0x0001;
	private final static int DILOG2_ID = 0x0002;
	@Override
	protected Dialog onCreateDialog(int id) {

		switch(id){
			case DILOG1_ID:
				return createDialog1();
			case DILOG2_ID:
				return createDialog2();
			default:
				break;
		}
		
		
		return super.onCreateDialog(id);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1:
			button1();
			break;
		case R.id.button2:
			button2();
			break;
		}
	}


	private void button1(){

		showDialog(DILOG1_ID);
	}
	
	private void button2(){
		showDialog(DILOG2_ID);
	}

	
	private Dialog createDialog1(){
		  Builder builder=new android.app.AlertDialog.Builder(this);

          builder.setTitle("单选按钮对话框");    
          DialogInterface.OnClickListener onlClickListener = new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				log.e(which);				
			}
		};
		
		builder.setSingleChoiceItems(R.array.dev_week_name, 0, onlClickListener);
          builder.setPositiveButton(" 确 定 ", new DialogInterface.OnClickListener(){
              public void onClick(DialogInterface dialog, int which) {
                  
              }
          });

		 return builder.create();
	}

	private Dialog createDialog2(){
		  Dialog dialog = new Dialog(this);
		

		 return dialog;
	}
}
