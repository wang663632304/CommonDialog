package com.geniusgithub.commondialog.dialog;

import com.geniusgithub.commondialog.util.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;
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
		
		WindowManager.LayoutParams lp = getWindow().getAttributes();	
		int width = (int) (0.9 * Utils.getScreenWidth(mContext));
		lp.width = width;
		getWindow().setAttributes(lp);
	
	
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
