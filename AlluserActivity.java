package com.colo.bookapp;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bachors.wordtospan.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.github.angads25.filepicker.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jsibbold.zoomage.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import uk.co.senab.photoview.*;

public class AlluserActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double n = 0;
	private double search_n = 0;
	private double search_n1 = 0;
	private String charSeq = "";
	private double n_1 = 0;
	private double search_n_1 = 0;
	private double search_n1_1 = 0;
	private boolean is_checked = false;
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap1 = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout top;
	private ImageView back;
	private EditText search;
	private ImageView imageview1;
	private ImageView imageview2;
	private LinearLayout filters;
	private LinearLayout linear_user;
	private LinearLayout Project;
	private LinearLayout bt_fruits;
	private LinearLayout bt_animals;
	private ImageView i1;
	private TextView textview1;
	private ImageView i2;
	private TextView textview2;
	private ListView listview1;
	private ListView listview2;
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private Intent intent = new Intent();
	private SharedPreferences data;
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.alluser);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		top = findViewById(R.id.top);
		back = findViewById(R.id.back);
		search = findViewById(R.id.search);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		filters = findViewById(R.id.filters);
		linear_user = findViewById(R.id.linear_user);
		Project = findViewById(R.id.Project);
		bt_fruits = findViewById(R.id.bt_fruits);
		bt_animals = findViewById(R.id.bt_animals);
		i1 = findViewById(R.id.i1);
		textview1 = findViewById(R.id.textview1);
		i2 = findViewById(R.id.i2);
		textview2 = findViewById(R.id.textview2);
		listview1 = findViewById(R.id.listview1);
		listview2 = findViewById(R.id.listview2);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		search.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				charSeq = _charSeq.trim();
				if (linear_user.getVisibility() == View.VISIBLE) {
					if (!data.getString("data3", "").equals("")) {
						listmap = new Gson().fromJson(data.getString("data3", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (charSeq.length() > 0) {
							search_n1 = listmap.size() - 1;
							search_n = listmap.size();
							for(int _repeat28 = 0; _repeat28 < (int)(search_n); _repeat28++) {
								if (listmap.get((int)search_n1).get("name").toString().toLowerCase().contains(charSeq.toLowerCase())) {
									
								}
								else {
									listmap.remove((int)(search_n1));
								}
								search_n1--;
							}
						}
					}
				}
				else {
					if (!data.getString("data1", "").equals("")) {
						listmap1 = new Gson().fromJson(data.getString("data1", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
						if (charSeq.length() > 0) {
							search_n1_1 = listmap1.size() - 1;
							search_n_1 = listmap1.size();
							for(int _repeat56 = 0; _repeat56 < (int)(search_n_1); _repeat56++) {
								if (listmap1.get((int)search_n1_1).get("title").toString().toLowerCase().contains(charSeq.toLowerCase())) {
									
								}
								else {
									listmap1.remove((int)(search_n1_1));
								}
								search_n1_1--;
							}
						}
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (is_checked) {
					filters.setVisibility(View.GONE);
					is_checked = !is_checked;
					_TransitionManager(linear2, 200);
				}
				else {
					filters.setVisibility(View.VISIBLE);
					is_checked = !is_checked;
					_TransitionManager(linear2, 200);
				}
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (linear_user.getVisibility() == View.VISIBLE) {
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}
				else {
					listview2.setAdapter(new Listview2Adapter(listmap1));
					((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				}
				SketchwareUtil.hideKeyboard(getApplicationContext());
			}
		});
		
		bt_fruits.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i2.setVisibility(View.GONE);
				i1.setVisibility(View.VISIBLE);
				linear_user.setVisibility(View.VISIBLE);
				Project.setVisibility(View.GONE);
			}
		});
		
		bt_animals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i1.setVisibility(View.GONE);
				i2.setVisibility(View.VISIBLE);
				Project.setVisibility(View.VISIBLE);
				linear_user.setVisibility(View.GONE);
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("name") && _childValue.containsKey("uid")) {
					map.put(_childValue.get("uid").toString(), _childValue.get("name").toString());
				}
				listmap.add((int)0, _childValue);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				data.edit().putString("data3", new Gson().toJson(listmap)).commit();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n = 0;
				for(int _repeat14 = 0; _repeat14 < (int)(listmap.size()); _repeat14++) {
					if (listmap.get((int)n).get("key").toString().equals(_childKey)) {
						listmap.remove((int)(n));
						listmap.add((int)n, _childValue);
					}
					n++;
				}
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				data.edit().putString("data3", new Gson().toJson(listmap)).commit();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n = 0;
				for(int _repeat14 = 0; _repeat14 < (int)(listmap.size()); _repeat14++) {
					if (listmap.get((int)n).get("key").toString().equals(_childKey)) {
						listmap.remove((int)(n));
					}
					n++;
				}
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				data.edit().putString("data3", new Gson().toJson(listmap)).commit();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		users.addChildEventListener(_users_child_listener);
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				listmap1.add((int)0, _childValue);
				listview2.setAdapter(new Listview2Adapter(listmap1));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				data.edit().putString("data1", new Gson().toJson(listmap1)).commit();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n_1 = 0;
				for(int _repeat11 = 0; _repeat11 < (int)(listmap1.size()); _repeat11++) {
					if (listmap1.get((int)n).get("key").toString().equals(_childKey)) {
						listmap1.remove((int)(n));
						listmap1.add((int)n, _childValue);
					}
					n_1++;
				}
				listview2.setAdapter(new Listview2Adapter(listmap1));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				data.edit().putString("data1", new Gson().toJson(listmap1)).commit();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n_1 = 0;
				for(int _repeat11 = 0; _repeat11 < (int)(listmap1.size()); _repeat11++) {
					if (listmap1.get((int)n).get("key").toString().equals(_childKey)) {
						listmap1.remove((int)(n));
					}
					n_1++;
				}
				listview2.setAdapter(new Listview2Adapter(listmap1));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				data.edit().putString("data1", new Gson().toJson(listmap1)).commit();
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		data1.addChildEventListener(_data1_child_listener);
	}
	
	private void initializeLogic() {
		i1.setColorFilter(0xFFEEEEEE, PorterDuff.Mode.MULTIPLY);
		i2.setColorFilter(0xFFEEEEEE, PorterDuff.Mode.MULTIPLY);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		top.setElevation((float)7);
		search.requestFocus();
		SketchwareUtil.showKeyboard(getApplicationContext());
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		_GetTransition(top, "search");
		search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
			@Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) { 
				if(actionId == 3){
					if (linear_user.getVisibility() == View.VISIBLE) {
						listview1.setAdapter(new Listview1Adapter(listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					else {
						listview2.setAdapter(new Listview2Adapter(listmap1));
						((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
					}
					SketchwareUtil.hideKeyboard(getApplicationContext());
				} 
				return false;
			}
		});
		linear_user.setVisibility(View.VISIBLE);
		Project.setVisibility(View.GONE);
		is_checked = false;
		filters.setVisibility(View.GONE);
		i2.setVisibility(View.GONE);
		_ChipsDesigning(bt_fruits);
		_ChipsDesigning(bt_animals);
		_removeScollBar(listview1);
		_removeScollBar(listview2);
	}
	
	public void _StartTransitionActivity(final Intent _intent, final View _view, final String _name) {
		//code made by LORD HOSSEIN 
		_view.setTransitionName(_name); 
		
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(AlluserActivity.this, _view, _name); 
		startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public void _GetTransition(final View _view, final String _name) {
		_view.setTransitionName(_name); 
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration);
		autoTransition.setInterpolator(new android.view.animation.DecelerateInterpolator()); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _ChipsDesigning(final View _view) {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF9E9E9E);SketchUi.setCornerRadii(new float[]{d*360,d*360,d*360 ,d*360,d*360,d*360 ,d*360,d*360});
			SketchUi.setStroke(d*0,0xFF008DCD);
			_view.setElevation(d*3);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
			_view.setBackground(SketchUiRD);
			_view.setClickable(true);
		}
	}
	
	
	public void _RoundedImage(final ImageView _view, final double _radius, final String _image) {
		
		Glide.with(getApplicationContext())
		.load(getApplicationContext().getResources().getIdentifier(_image, "drawable", this.getPackageName()))
		.transform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners((int)_radius))
		.into(_view);
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.users, null);
			}
			
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final de.hdodenhof.circleimageview.CircleImageView circleimageview1 = _view.findViewById(R.id.circleimageview1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView bio = _view.findViewById(R.id.bio);
			final TextView name = _view.findViewById(R.id.name);
			final Button button1 = _view.findViewById(R.id.button1);
			
			name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
			bio.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			name.setText(listmap.get((int)_position).get("name").toString());
			bio.setText(listmap.get((int)_position).get("bio").toString());
			if (listmap.get((int)_position).get("pic").toString().equals("")) {
				circleimageview1.setImageResource(R.drawable.user);
			}
			else {
				Glide.with(getApplicationContext()).load(Uri.parse(listmap.get((int)_position).get("pic").toString())).into(circleimageview1);
			}
			if (listmap.get((int)_position).containsKey("active")) {
				if (listmap.get((int)_position).get("active").toString().equals("true")) {
					button1.setVisibility(View.GONE);
				}
				else {
					button1.setVisibility(View.VISIBLE);
				}
			}
			linear4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), AccountActivity.class);
					intent.putExtra("mode", "user");
					intent.putExtra("uid", listmap.get((int)_position).get("uid").toString());
					_StartTransitionActivity(intent, circleimageview1, "p");
				}
			});
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.projects, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView icon = _view.findViewById(R.id.icon);
			final TextView title = _view.findViewById(R.id.title);
			final TextView name = _view.findViewById(R.id.name);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView likes = _view.findViewById(R.id.likes);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView comments = _view.findViewById(R.id.comments);
			final ImageView imageview4 = _view.findViewById(R.id.imageview4);
			final TextView download = _view.findViewById(R.id.download);
			
			title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
			name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			comments.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			download.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			if (_data.get((int)_position).containsKey("title")) {
				title.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("icon")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(icon);
			}
			if (_data.get((int)_position).containsKey("uid")) {
				if (map.containsKey(_data.get((int)_position).get("uid").toString())) {
					name.setText(map.get(_data.get((int)_position).get("uid").toString()).toString());
				}
			}
			if (_data.get((int)_position).containsKey("likes")) {
				likes.setText(_data.get((int)_position).get("likes").toString());
			}
			if (_data.get((int)_position).containsKey("comments")) {
				comments.setText(_data.get((int)_position).get("comments").toString());
			}
			if (_data.get((int)_position).containsKey("download")) {
				download.setText(_data.get((int)_position).get("download").toString());
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ProjectViewActivity.class);
					intent.putExtra("key", _data.get((int)_position).get("key").toString());
					intent.putExtra("uid", _data.get((int)_position).get("uid").toString());
					_StartTransitionActivity(intent, cardview2, "project");
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}