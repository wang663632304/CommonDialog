package com.geniusgithub.commondialog.dialog;

import com.geniusgithub.commondialog.util.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.view.WindowManager;

public abstract class AbstractBaseDialog extends Dialog{

	protected Context mContext;
	protected IDialogInterface mDialogInterface;
	
	public AbstractBaseDialog(Context context) {
		super(context);
		mContext = context;
	}
	
	protected abstract void setupViews();
	
	public void setCommonDialogListener(IDialogInterface listener){
		mDialogInterface = listener;
	}
	
	public void alpaWindow(){
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		ColorDrawable dw = new ColorDrawable(0x00);
		Window window = getWindow();
		window.setBackgroundDrawable(dw);
	}
	
	
	public void fitWidth(){
		WindowManager.LayoutParams lp = getWindow().getAttributes();	
		int width = (int) (0.9 * Utils.getScreenWidth(mContext));
		lp.width = width;
		getWindow().setAttributes(lp);
	}
	
	public void fitHeight(){
		WindowManager.LayoutParams lp = getWindow().getAttributes();	
		int height = (int) (0.8 * Utils.getScreenHeight(mContext));
		lp.height = height;
		getWindow().setAttributes(lp);
	}
}
