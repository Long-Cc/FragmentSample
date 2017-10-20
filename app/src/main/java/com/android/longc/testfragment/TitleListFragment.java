package com.android.longc.testfragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 用来显示标题列表的Fragment
 * 
 * @author longc
 *
 */
public class TitleListFragment extends ListFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// 给ListView设置adapter列表
		setListAdapter(new ArrayAdapter<String>(getActivity(),R.layout.list_item, DataUtils.TITLES));
		//默认选中第一个item
		getListView().setItemChecked(0, true);
		//显示第一的详情
		showDetail(0);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		showDetail(position);
		
	}
	/**
	 * 显示指定下标的详情
	 * @param position
	 */
	private void showDetail(int position) {
		//创建DetailFragment对象
		DetailFragment fragment = new DetailFragment();
		//将对应的详情数据携带过去
		Bundle bundle=new Bundle();
		bundle.putString("DETAIL", DataUtils.DETAILS[position]);
		fragment.setArguments(bundle);
		//将其替换到id为fl_main_container的容器布局中
		getFragmentManager().beginTransaction().replace(R.id.fl_main_container, fragment).commit();
	}
}
