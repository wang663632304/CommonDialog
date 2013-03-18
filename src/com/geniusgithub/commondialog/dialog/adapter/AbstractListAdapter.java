package com.geniusgithub.commondialog.dialog.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

public abstract class AbstractListAdapter<T> extends BaseAdapter{

	 protected Context mContext;   
	 protected List<T> mObjects = new ArrayList<T>();
	 protected int mCheckBoxResourceID = 0;
	 protected LayoutInflater mInflater; 
	    
	 public AbstractListAdapter(Context context, int checkboxResourceID){
		 mContext = context;
		 mCheckBoxResourceID = checkboxResourceID;
		 mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 }
	 
     
     public void clear(){
    	 mObjects.clear();
         notifyDataSetChanged();
     }
}
