package com.colo.bookapp;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bachors.wordtospan.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.github.angads25.filepicker.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.jsibbold.zoomage.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import uk.co.senab.photoview.*;

public class ReadmoreActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> data_map = new HashMap<>();
	private String uid = "";
	private String key = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear17;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private ImageView imageview1;
	private LinearLayout linear5;
	private TextView title;
	private TextView textview3;
	private TextView whats_new;
	private TextView textview5;
	private TextView about_app;
	private TextView textview7;
	private TextView more_info;
	private TextView textview9;
	private LinearLayout linear12;
	private TextView textview10;
	private TextView textview11;
	private LinearLayout linear14;
	private TextView textview12;
	private TextView textview13;
	private LinearLayout linear16;
	private TextView textview14;
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private DatabaseReference download = _firebase.getReference("download");
	private ChildEventListener _download_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.readmore);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear17 = findViewById(R.id.linear17);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		imageview1 = findViewById(R.id.imageview1);
		linear5 = findViewById(R.id.linear5);
		title = findViewById(R.id.title);
		textview3 = findViewById(R.id.textview3);
		whats_new = findViewById(R.id.whats_new);
		textview5 = findViewById(R.id.textview5);
		about_app = findViewById(R.id.about_app);
		textview7 = findViewById(R.id.textview7);
		more_info = findViewById(R.id.more_info);
		textview9 = findViewById(R.id.textview9);
		linear12 = findViewById(R.id.linear12);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		linear14 = findViewById(R.id.linear14);
		textview12 = findViewById(R.id.textview12);
		textview13 = findViewById(R.id.textview13);
		linear16 = findViewById(R.id.linear16);
		textview14 = findViewById(R.id.textview14);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("title")) {
						title.setText(_childValue.get("title").toString());
					}
					if (_childValue.containsKey("time")) {
						textview12.setText(_childValue.get("time").toString());
					}
					if (_childValue.containsKey("dec")) {
						textview7.setText(_childValue.get("dec").toString());
					}
					else {
						textview5.setText("not available");
					}
					if (_childValue.containsKey("new")) {
						textview5.setText(_childValue.get("new").toString());
					}
					else {
						textview5.setText("not available");
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("title")) {
						title.setText(_childValue.get("title").toString());
					}
					if (_childValue.containsKey("time")) {
						textview12.setText(_childValue.get("time").toString());
					}
					if (_childValue.containsKey("dec")) {
						textview7.setText(_childValue.get("dec").toString());
					}
					else {
						textview5.setText("not available");
					}
					if (_childValue.containsKey("new")) {
						textview5.setText(_childValue.get("new").toString());
					}
					else {
						textview5.setText("not available");
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		data1.addChildEventListener(_data1_child_listener);
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(uid)) {
					if (_childValue.containsKey("name")) {
						textview14.setText(_childValue.get("name").toString());
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		user.addChildEventListener(_user_child_listener);
		
		_download_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("download")) {
						textview10.setText(_childValue.get("download").toString());
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("download")) {
						textview10.setText(_childValue.get("download").toString());
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		download.addChildEventListener(_download_child_listener);
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =ReadmoreActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFFFFFFFF);
		}
		title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		whats_new.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		about_app.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		more_info.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 0);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 0);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 0);
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 0);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 0);
		uid = getIntent().getStringExtra("uid");
		vscroll1.setVerticalScrollBarEnabled(false);
		textview14.setText(getIntent().getStringExtra("name"));
		key = getIntent().getStringExtra("key");
		textview5.setTextIsSelectable(true);
		textview7.setTextIsSelectable(true);
		_Chat_Link(textview5);
		_Chat_Link(textview7);
	}
	
	public void _Chat_Link(final TextView _Text_) {
		_Text_.setTextIsSelectable(true);
		_Text_.setClickable(true);
		android.text.util.Linkify.addLinks(_Text_, android.text.util.Linkify.ALL);
		_Text_.setLinkTextColor(Color.parseColor("#03A9F4"));
		_Text_.setLinksClickable(true);
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