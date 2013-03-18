package com.geniusgithub.commondialog.dialog;

import com.geniusgithub.commondialog.util.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public abstract class AbstractTipDialog extends AbstractBaseDialog{

	protected TextView mTVTitle;
	protected TextView mTVMessage;
	
	
	public AbstractTipDialog(Context context) {
		super(context);
		mContext = context;
		
		alpaWindow();
		setupViews();
		fitWidth();
	
	
	}
	
	public void setTitle(String title){
		if (mTVTitle != null){
			mTVTitle.setText(title);
		}
	}
	
	public void setMessage(String msg){
		if (mTVMessage != null){
			mTVMessage.setText(msg);
		}
	}
}
