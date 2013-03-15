package com.geniusgithub.commondialog.dialog;

import android.app.Dialog;
import android.content.Context;

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
	
}
