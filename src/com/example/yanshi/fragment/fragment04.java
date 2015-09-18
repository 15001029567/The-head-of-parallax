package com.example.yanshi.fragment;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.headparallax.R;
import com.example.yanshi.view.PullListView;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class fragment04 extends BaseFragment {

	private PullListView pull_listview;
	private ImageView iv_listview_head;
private String[] list={"马云","马化腾","李彦宏","周鸿祎","罗永浩","雷军","柳传志","库克","郭台铭","刘青","刘强东","任志强","张朝阳","张敬","扎克伯格","斯诺登","郭美美"};
private View view2;
	@SuppressLint("NewApi")
	@Override
	public View getFragmentView() {
		View view = View.inflate(getActivity(), R.layout.adapter_fragment1, null);
		pull_listview = (PullListView) view.findViewById(R.id.pull_listview);
		view2 = View.inflate(getActivity(), R.layout.listview_head, null);
		iv_listview_head = (ImageView) view2.findViewById(R.id.iv_listview_head);
		pull_listview.addHeaderView(view2);
		pull_listview.setAdapter(new ListViewAdapter());
		
		pull_listview.setPullListView(iv_listview_head);
		pull_listview.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
		return view;
	}

	@Override
	public void prepareData() {
		// TODO Auto-generated method stub
		
	}
	class ListViewAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
//			TextView textView =new TextView(getActivity());
//			textView.setText(list[position]);
			ViewHolder mHolder=null;
			if (convertView==null) {
				convertView=View.inflate(getActivity(), R.layout.adapter, null);
				mHolder=new ViewHolder();
				mHolder.adapter_textview=(TextView) convertView.findViewById(R.id.adapter_textview);
			convertView.setTag(mHolder);
			}
			else {
				mHolder=(ViewHolder) convertView.getTag();
			}
			mHolder.adapter_textview.setText(list[position]);
			ViewHelper.setRotationX(convertView, 60);
			ViewPropertyAnimator.animate(convertView).rotationX(0).setDuration(600).setInterpolator(new OvershootInterpolator(8)).start();
			ViewHelper.setScaleX(convertView, 0.4f);
			ViewPropertyAnimator.animate(convertView).scaleX(1f).setDuration(600).setInterpolator(new OvershootInterpolator(8)).start();
			ViewHelper.setAlpha(convertView, 0.2f);
			ViewPropertyAnimator.animate(convertView).alpha(1f).setDuration(600).start();
			return convertView;
		}
		
	}
	class ViewHolder{
		TextView adapter_textview;
	}
}
