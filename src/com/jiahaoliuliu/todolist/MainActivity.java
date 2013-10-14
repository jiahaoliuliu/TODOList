package com.jiahaoliuliu.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.ArrayAdapter;

public class MainActivity extends FragmentActivity implements OnNewItemAddedListener {

	private ArrayAdapter<String> aa;
	private ArrayList<String> todoItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Get reference to the Fragments
		FragmentManager fm = getSupportFragmentManager();
		ToDoListFragment todoListFragment =
				(ToDoListFragment)fm.findFragmentById(R.id.ToDoListFragment);
		
		// Create the array list of to do items
		todoItems = new ArrayList<String>();
		
		// Create the array adapter to bind the array to the listview
		aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
		
		// Bind the array adapter to the listview.
		todoListFragment.setListAdapter(aa);
	}

	public void onNewItemAdded(String newItem) {
		todoItems.add(newItem);
		aa.notifyDataSetChanged();
	}
}
