package com.geniusgithub.commondialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.geniusgithub.commondialog.dialog.AbstractNormalDialog;
import com.geniusgithub.commondialog.dialog.AbstractSimpleDialog;
import com.geniusgithub.commondialog.dialog.AbstractTipDialog;
import com.geniusgithub.commondialog.dialog.IDialogInterface;
import com.geniusgithub.commondialog.util.CommonLog;
import com.geniusgithub.commondialog.util.LogFactory;

public class MainActivity extends Activity implements OnClickListener,
														IDialogInterface{
	
	private static final CommonLog log = LogFactory.createLog();
	
	private Button mButton1;
	private Button mButton2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		
		normalDialog = new AbstractNormalDialog(this);
		normalDialog.setCommonDialogListener(this);
		
		simpleDialog = new AbstractSimpleDialog(this);
		simpleDialog.setCommonDialogListener(this);
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

	private AbstractTipDialog normalDialog;
	private AbstractTipDialog simpleDialog;
	private void button1(){
		normalDialog.show();
	}
	private void button2(){
		simpleDialog.show();
	}


	@Override
	public void onSure() {
		// TODO Auto-generated method stub
		log.e("onSure");
		normalDialog.dismiss();
		simpleDialog.dismiss();
	}



	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		log.e("onCancel");
		normalDialog.dismiss();
		simpleDialog.dismiss();
	}

}
