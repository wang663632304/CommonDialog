package com.geniusgithub.commondialog.dialog.adapter;


import java.util.List;

import com.geniusgithub.commondialog.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;



public class SingleChoicAdapter<T> extends AbstractListAdapter implements OnItemClickListener{

	private int mSelectItem = 0;
	
	public SingleChoicAdapter(Context context, int checkboxResourceID) {
		super(context, checkboxResourceID);

	}

	@Override
	public int getCount() {
		return mObjects.size();
	}

	@Override
	public Object getItem(int position) {
		return mObjects.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}



	public void refreshData(List objects) {
		if (objects != null)
    	{
    		mObjects = objects;
    		setSelectItem(0);
    	}
	}
    
    public void setSelectItem(int selectItem)
    {
    	if (selectItem >= 0 && selectItem < mObjects.size())
    	{
    		mSelectItem = selectItem;
    		notifyDataSetChanged();
    	}
    
    }

    public int getSelectItem()
    {
    	return mSelectItem;
    }

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {   
	
    	 ViewHolder viewHolder;
    	 
	     if (convertView == null) {
	    	 convertView = mInflater.inflate(R.layout.choice_list_item_layout, null);
	         viewHolder = new ViewHolder();
	         viewHolder.mTextView = (TextView) convertView.findViewById(R.id.textView);
	         viewHolder.mCheckBox = (CheckBox) convertView.findViewById(R.id.checkBox);
	         convertView.setTag(viewHolder);
	         
	         if (mCheckBoxResourceID != 0)
	         {
	        	 viewHolder.mCheckBox.setButtonDrawable(mCheckBoxResourceID);
	         }

	     } else {
	         viewHolder = (ViewHolder) convertView.getTag();
	     }
	   
	     viewHolder.mCheckBox.setChecked(mSelectItem == position);
	   
	     	 
	     T item = (T) getItem(position);
		 if (item instanceof CharSequence) {
		        viewHolder.mTextView.setText((CharSequence)item);
		 } else {
			 viewHolder.mTextView.setText(item.toString());
		 }
	
	     return convertView;
    }

    public static class ViewHolder
    {
    	public TextView mTextView;
    	public CheckBox mCheckBox;
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		if (position != mSelectItem)
		{
			mSelectItem = position;
			notifyDataSetChanged();
		}
	}

}
