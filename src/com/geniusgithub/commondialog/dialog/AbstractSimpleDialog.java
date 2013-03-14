package com.geniusgithub.commondialog.dialog;


import com.geniusgithub.commondialog.R;
import com.geniusgithub.commondialog.util.Utils;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class AbstractSimpleDialog extends AbstractTipDialog implements android.view.View.OnClickListener{
	
	protected Button mBtSure;
	
	public AbstractSimpleDialog(Context context) {
		super(context);
	}


	@Override
	protected void setupViews() {
		setContentView(R.layout.common_simple_layout);
		mTVTitle = (TextView)findViewById(R.id.tv_title);
		mTVMessage = (TextView) findViewById(R.id.tv_message);
		mBtSure = (Button) findViewById(R.id.bt_sure);
		mBtSure.setOnClickListener(this);
		
		WindowManager.LayoutParams lp = getWindow().getAttributes();	
		int width = (int) (0.8 * Utils.getScreenWidth(mContext));
		if (width < 300)
		{
			width = 300;
		}
		lp.width = width;	
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.bt_sure:
				if (mDialogInterface != null){
					mDialogInterface.onSure();
				}
				break;
		}
	}

	
}
