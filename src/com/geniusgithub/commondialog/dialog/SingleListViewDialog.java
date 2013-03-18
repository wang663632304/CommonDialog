package com.geniusgithub.commondialog.dialog;

import java.util.ArrayList;
import java.util.List;

import com.geniusgithub.commondialog.R;
import com.geniusgithub.commondialog.dialog.adapter.SingleChoicAdapter;
import com.geniusgithub.commondialog.util.CustomUtils;

import android.content.Context;

public class SingleListViewDialog extends AbstractListViewDialog{

	private SingleChoicAdapter<String> mAdapter;
	private List<String> mList;
	private int mSelItem = 0;
	
	public SingleListViewDialog(Context context) {
		super(context);

		mList = new ArrayList<String>();
		mAdapter = new SingleChoicAdapter<String>(mContext, R.drawable.selector_checkbox1);
		mAdapter.refreshData(mList);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(mAdapter);   
		
	}

	public int getSelectItem()
	{
		return mAdapter.getSelectItem();
	}
	
	public void refreshData(List<String> list, int selectItem){
		mList = list;
		mSelItem = selectItem;
		mAdapter.refreshData(mList);
		CustomUtils.setListViewHeightBasedOnChildren(mListView);
		fitHeight();
	}
	
	public void setSelectItem(int selectItem){
		   mAdapter.setSelectItem(selectItem);
	}
}
