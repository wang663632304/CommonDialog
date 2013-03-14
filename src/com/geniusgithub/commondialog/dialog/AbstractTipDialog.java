package com.geniusgithub.commondialog.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.TextView;

public abstract class AbstractTipDialog extends Dialog{

	protected Context mContext;
	protected IDialogInterface mDialogInterface;
	
	protected TextView mTVTitle;
	protected TextView mTVMessage;
	
	
	public AbstractTipDialog(Context context) {
		super(context);
		mContext = context;
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ColorDrawable dw = new ColorDrawable(0x00);
		Window window = getWindow();
		window.setBackgroundDrawable(dw);

		setupViews();
	}
	
	protected abstract void setupViews();
	
	public void setCommonDialogListener(IDialogInterface listener){
		mDialogInterface = listener;
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
