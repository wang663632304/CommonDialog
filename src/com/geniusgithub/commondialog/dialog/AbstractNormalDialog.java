package com.geniusgithub.commondialog.dialog;


import com.geniusgithub.commondialog.R;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbstractNormalDialog extends AbstractTipDialog implements android.view.View.OnClickListener{
	
	protected Button mBtSure;
	protected Button mBtCancel;

	
	public AbstractNormalDialog(Context context) {
		super(context);
	}
	

	@Override
	protected void setupViews() {
		setContentView(R.layout.common_normal_layout);
		mTVTitle = (TextView)findViewById(R.id.tv_title);
		mTVMessage = (TextView) findViewById(R.id.tv_message);
		mBtSure = (Button) findViewById(R.id.bt_sure);
		mBtCancel = (Button) findViewById(R.id.bt_cancel);
		mBtSure.setOnClickListener(this);
		mBtCancel.setOnClickListener(this);
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
