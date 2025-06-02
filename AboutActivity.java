package com.colo.bookapp;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
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
import com.jsibbold.zoomage.*;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import uk.co.senab.photoview.*;

public class AboutActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private ImageView imageview26;
	private LinearLayout linear2;
	private LinearLayout d1;
	private LinearLayout d2;
	private TextView textview1;
	private LinearLayout linear4;
	private LinearLayout linear6;
	private LinearLayout linear5;
	private LinearLayout lik;
	private LinearLayout linear12;
	private LinearLayout linear14;
	private CircleImageView circleimageview1;
	private TextView textview2;
	private LinearLayout linear7;
	private TextView textview3;
	private ImageView imageview1;
	private LinearLayout linear9;
	private TextView textview4;
	private TextView textview5;
	private ImageView imageview3;
	private LinearLayout linear13;
	private TextView textview8;
	private TextView textview9;
	private ImageView imageview4;
	private LinearLayout linear15;
	private TextView textview10;
	private TextView textview11;
	private TextView textview19;
	private LinearLayout linear35;
	private LinearLayout linear37;
	private LinearLayout linear39;
	private LinearLayout linear41;
	private LinearLayout linear43;
	private ImageView imageview14;
	private LinearLayout linear36;
	private TextView textview23;
	private TextView textview24;
	private ImageView imageview15;
	private LinearLayout linear38;
	private TextView textview25;
	private TextView textview26;
	private ImageView imageview16;
	private LinearLayout linear40;
	private TextView textview27;
	private TextView textview28;
	private ImageView imageview17;
	private LinearLayout linear42;
	private TextView textview29;
	private TextView textview30;
	private ImageView imageview18;
	private LinearLayout linear44;
	private TextView textview31;
	private TextView textview32;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview26 = findViewById(R.id.imageview26);
		linear2 = findViewById(R.id.linear2);
		d1 = findViewById(R.id.d1);
		d2 = findViewById(R.id.d2);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		linear6 = findViewById(R.id.linear6);
		linear5 = findViewById(R.id.linear5);
		lik = findViewById(R.id.lik);
		linear12 = findViewById(R.id.linear12);
		linear14 = findViewById(R.id.linear14);
		circleimageview1 = findViewById(R.id.circleimageview1);
		textview2 = findViewById(R.id.textview2);
		linear7 = findViewById(R.id.linear7);
		textview3 = findViewById(R.id.textview3);
		imageview1 = findViewById(R.id.imageview1);
		linear9 = findViewById(R.id.linear9);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		imageview3 = findViewById(R.id.imageview3);
		linear13 = findViewById(R.id.linear13);
		textview8 = findViewById(R.id.textview8);
		textview9 = findViewById(R.id.textview9);
		imageview4 = findViewById(R.id.imageview4);
		linear15 = findViewById(R.id.linear15);
		textview10 = findViewById(R.id.textview10);
		textview11 = findViewById(R.id.textview11);
		textview19 = findViewById(R.id.textview19);
		linear35 = findViewById(R.id.linear35);
		linear37 = findViewById(R.id.linear37);
		linear39 = findViewById(R.id.linear39);
		linear41 = findViewById(R.id.linear41);
		linear43 = findViewById(R.id.linear43);
		imageview14 = findViewById(R.id.imageview14);
		linear36 = findViewById(R.id.linear36);
		textview23 = findViewById(R.id.textview23);
		textview24 = findViewById(R.id.textview24);
		imageview15 = findViewById(R.id.imageview15);
		linear38 = findViewById(R.id.linear38);
		textview25 = findViewById(R.id.textview25);
		textview26 = findViewById(R.id.textview26);
		imageview16 = findViewById(R.id.imageview16);
		linear40 = findViewById(R.id.linear40);
		textview27 = findViewById(R.id.textview27);
		textview28 = findViewById(R.id.textview28);
		imageview17 = findViewById(R.id.imageview17);
		linear42 = findViewById(R.id.linear42);
		textview29 = findViewById(R.id.textview29);
		textview30 = findViewById(R.id.textview30);
		imageview18 = findViewById(R.id.imageview18);
		linear44 = findViewById(R.id.linear44);
		textview31 = findViewById(R.id.textview31);
		textview32 = findViewById(R.id.textview32);
		
		imageview26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		_removeScollBar(vscroll1);
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
	}
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
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