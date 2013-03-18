package com.geniusgithub.commondialog.dialog;

import com.geniusgithub.commondialog.R;
import com.geniusgithub.commondialog.util.Utils;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;


public abstract class AbstractListViewDialog extends AbstractBaseDialog implements android.view.View.OnClickListener{

	protected ListView mListView;
	protected Button mBtSure;
	protected Button mBtCancel;
	protected BaseAdapter mAdapter;
	
	public AbstractListViewDialog(Context context) {
		super(context);
		
		alpaWindow();
		setupViews();
		fitWidth();
	}

	public void setAdapter(BaseAdapter adapter){
		mAdapter = adapter;
		mListView.setAdapter(adapter);
	}
	
	public BaseAdapter getAdapter(){
		return mAdapter;
	}
	
	@Override
	protected void setupViews() {
		setContentView(R.layout.listviwe_dialog_layout);
		mBtSure = (Button) findViewById(R.id.bt_sure);
		mBtCancel = (Button) findViewById(R.id.bt_cancel);
		mBtSure.setOnClickListener(this);
		mBtCancel.setOnClickListener(this);
		mListView = (ListView) findViewById(R.id.listview);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bt_sure:
			if (mDialogInterface != null){
				mDialogInterface.onSure();
			}
			break;
		case R.id.bt_cancel:
			if (mDialogInterface != null){
				mDialogInterface.onCancel();
			}
			break;
	}
	}
	
	
}
