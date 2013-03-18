package com.geniusgithub.commondialog;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.geniusgithub.commondialog.dialog.AbstractNormalDialog;
import com.geniusgithub.commondialog.dialog.AbstractSimpleDialog;
import com.geniusgithub.commondialog.dialog.AbstractTipDialog;
import com.geniusgithub.commondialog.dialog.IDialogInterface;
import com.geniusgithub.commondialog.dialog.MultiListViewDialog;
import com.geniusgithub.commondialog.dialog.SingleListViewDialog;
import com.geniusgithub.commondialog.util.CommonLog;
import com.geniusgithub.commondialog.util.LogFactory;

public class MainActivity extends Activity implements OnClickListener,
														IDialogInterface{
	
	private static final CommonLog log = LogFactory.createLog();
	
	private Button mButton1;
	private Button mButton2;
	private Button mButton3;
	private Button mButton4;
	private Button mButton5;
	
	
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
		mButton3 = (Button) findViewById(R.id.button3);
		mButton3.setOnClickListener(this);
		mButton4 = (Button) findViewById(R.id.button4);
		mButton4.setOnClickListener(this);
		mButton5 = (Button) findViewById(R.id.button5);
		mButton5.setOnClickListener(this);
		
		normalDialog = new AbstractNormalDialog(this);
		normalDialog.setCommonDialogListener(this);
		
		simpleDialog = new AbstractSimpleDialog(this);
		simpleDialog.setCommonDialogListener(this);
		
		initListDialog();
	}

	private final static int MAX_COUNT = 10;
	private void initListDialog(){
		singleListViewDialog = new SingleListViewDialog(this);
		singleListViewDialog.setCommonDialogListener(this);
		
		multiListViewDialog = new MultiListViewDialog(this);
		multiListViewDialog.setCommonDialogListener(this);
		
		
		List<String> list1 = new ArrayList<String>();
		for(int i = 0; i < MAX_COUNT; i++){
			list1.add("geniusgit" + i);
		}		
		singleListViewDialog.refreshData(list1, 0);
		
		
		List<String> list2 = new ArrayList<String>();
		boolean [] flag = new boolean[MAX_COUNT];
		for(int i = 0; i < MAX_COUNT; i++){
			list2.add("geniusgit" + i);
		}
		multiListViewDialog.refreshData(list2, flag);
		
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
		case R.id.button3:
			button3();
			break;
		case R.id.button4:
			button4();
			break;
		case R.id.button5:
			button5();
			break;
		}
	}

	private AbstractTipDialog normalDialog;
	private AbstractTipDialog simpleDialog;
	private SingleListViewDialog singleListViewDialog;
	private MultiListViewDialog multiListViewDialog;
	private void button1(){
		normalDialog.show();
	}
	private void button2(){
		simpleDialog.show();
	}
	private void button3(){
		singleListViewDialog.show();
	}
	private void button4(){
		multiListViewDialog.show();
	}
	private void button5(){
		showDialog(DILOG1_ID);
	}

	@Override
	public void onSure() {
		// TODO Auto-generated method stub
		log.e("onSure");
		normalDialog.dismiss();
		simpleDialog.dismiss();
		singleListViewDialog.dismiss();
		multiListViewDialog.dismiss();
	}



	@Override
	public void onCancel() {
		// TODO Auto-generated method stub
		log.e("onCancel");
		normalDialog.dismiss();
		simpleDialog.dismiss();
		singleListViewDialog.dismiss();
		multiListViewDialog.dismiss();
	}

	
	
	private final static int DILOG1_ID = 0x0001;
	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id){
		case DILOG1_ID:
			return createDialog1();
		default:
			break;
		}
		return super.onCreateDialog(id);
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
}
