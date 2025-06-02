package com.colo.bookapp;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bachors.wordtospan.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.github.angads25.filepicker.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.jsibbold.zoomage.*;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import uk.co.senab.photoview.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String icon_path = "";
	private String PATH_SKETCHWARE = "";
	private String PATH_HIDE_SKETCHLIB = "";
	private String PATH_SKETCHLIB = "";
	private double number = 0;
	private String up_edit = "";
	private String up_icon = "";
	private String project_key = "";
	private String icon_url = "";
	private HashMap<String, Object> data_map = new HashMap<>();
	private String priv_text = "";
	private String charSeq = "";
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private String temp_decrypted = "";
	private HashMap<String, Object> temp_map2 = new HashMap<>();
	private String line = "";
	private String privacy_text = "";
	private String name = "";
	private String email = "";
	private double viewPager_position = 0;
	private double search_n = 0;
	private double search_n1 = 0;
	private double n = 0;
	private boolean data1_loaded = false;
	private boolean data2_loaded = false;
	private boolean data3_loaded = false;
	private String app_version = "";
	private HashMap<String, Object> mp = new HashMap<>();
	private String uid = "";
	private double B = 0;
	private double KB = 0;
	private double MB = 0;
	private double GB = 0;
	private double TB = 0;
	private double PB = 0;
	private String returnedSize = "";
	private String path = "";
	private String file_size = "";
	private String package_name = "";
	
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap2 = new ArrayList<>();
	private ArrayList<String> temp_str2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap3 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> gridmap3 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap4 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmp = new ArrayList<>();
	private ArrayList<String> lst = new ArrayList<>();
	private ArrayList<String> jsonstring = new ArrayList<>();
	
	private LinearLayout appbar;
	private LinearLayout line_home;
	private LinearLayout linear9;
	private ImageView imageview1;
	private EditText search_text;
	private CircleImageView circleimageview1;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private RecyclerView recyclerview1;
	private LinearLayout linear5;
	private RecyclerView recyclerview2;
	private LinearLayout linear6;
	private RecyclerView recyclerview3;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private ScrollView _drawer_vscroll1;
	private CircleImageView _drawer_circleimageview1;
	private TextView _drawer_textview1;
	private TextView _drawer_textview2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_profile;
	private LinearLayout _drawer_upload;
	private LinearLayout _drawer_code;
	private LinearLayout _drawer_mblocks;
	private LinearLayout _drawer_cblocks;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_linear6;
	private LinearLayout _drawer_about;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview9;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview9;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview15;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview16;
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private Intent intent = new Intent();
	private TimerTask timer;
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private AlertDialog.Builder p_publish_dialog;
	private SharedPreferences data;
	private TimerTask data_load;
	private TimerTask update_time;
	private AlertDialog.Builder update_dialog;
	private Intent update_intent = new Intent();
	private SharedPreferences m;
	private Calendar calendar = Calendar.getInstance();
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private ObjectAnimator anim = new ObjectAnimator();
	private ProgressDialog prog;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		appbar = findViewById(R.id.appbar);
		line_home = findViewById(R.id.line_home);
		linear9 = findViewById(R.id.linear9);
		imageview1 = findViewById(R.id.imageview1);
		search_text = findViewById(R.id.search_text);
		circleimageview1 = findViewById(R.id.circleimageview1);
		vscroll1 = findViewById(R.id.vscroll1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		recyclerview1 = findViewById(R.id.recyclerview1);
		linear5 = findViewById(R.id.linear5);
		recyclerview2 = findViewById(R.id.recyclerview2);
		linear6 = findViewById(R.id.linear6);
		recyclerview3 = findViewById(R.id.recyclerview3);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_circleimageview1 = _nav_view.findViewById(R.id.circleimageview1);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_profile = _nav_view.findViewById(R.id.profile);
		_drawer_upload = _nav_view.findViewById(R.id.upload);
		_drawer_code = _nav_view.findViewById(R.id.code);
		_drawer_mblocks = _nav_view.findViewById(R.id.mblocks);
		_drawer_cblocks = _nav_view.findViewById(R.id.cblocks);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_about = _nav_view.findViewById(R.id.about);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_imageview7 = _nav_view.findViewById(R.id.imageview7);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		_drawer_imageview10 = _nav_view.findViewById(R.id.imageview10);
		_drawer_textview12 = _nav_view.findViewById(R.id.textview12);
		_drawer_imageview9 = _nav_view.findViewById(R.id.imageview9);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_imageview11 = _nav_view.findViewById(R.id.imageview11);
		_drawer_textview13 = _nav_view.findViewById(R.id.textview13);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview12 = _nav_view.findViewById(R.id.imageview12);
		_drawer_textview15 = _nav_view.findViewById(R.id.textview15);
		_drawer_imageview13 = _nav_view.findViewById(R.id.imageview13);
		_drawer_textview16 = _nav_view.findViewById(R.id.textview16);
		auth = FirebaseAuth.getInstance();
		p_publish_dialog = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		update_dialog = new AlertDialog.Builder(this);
		m = getSharedPreferences("t", Activity.MODE_PRIVATE);
		network = new RequestNetwork(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AccountActivity.class);
				intent.putExtra("mode", "user");
				intent.putExtra("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				_StartTransitionActivity(intent, circleimageview1, "p");
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, UploadActivity.class)); Animatoo.animateFade(HomeActivity.this);
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(_childKey)) {
					if (_childValue.containsKey("name")) {
						_drawer_textview1.setText(_childValue.get("name").toString());
						name = _childValue.get("name").toString();
						email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
						if (_childValue.get("pic").toString().equals("")) {
							_drawer_circleimageview1.setImageResource(R.drawable.user);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(circleimageview1);
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(_drawer_circleimageview1);
						}
						if (_childValue.containsKey("active")) {
							if (_childValue.get("active").toString().equals("true")) {
								
							}
							else {
								final AlertDialog dialog1 = new AlertDialog.Builder(HomeActivity.this).create();
								View inflate = getLayoutInflater().inflate(R.layout.signout,null); 
								dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
								dialog1.setView(inflate);
								TextView t1 = (TextView) inflate.findViewById(R.id.t1);
								
								TextView t2 = (TextView) inflate.findViewById(R.id.t2);
								
								TextView b1 = (TextView) inflate.findViewById(R.id.b1);
								
								TextView b2 = (TextView) inflate.findViewById(R.id.b2);
								
								LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
								
								LinearLayout linear3 = (LinearLayout) inflate.findViewById(R.id.linear3);
								t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 1);
								t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 0);
								b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 1);
								b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 1);
								t1.setText("Banned!");
								t2.setText("Your account was banned. You are brake the Sketchub rules. If you think it was a mistake to connect us projectstore79@gmail.com");
								b1.setText("");
								b2.setText("EXIT APP");
								_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
								t2.setClickable(true);
								android.text.util.Linkify.addLinks(t2, android.text.util.Linkify.ALL);
								t2.setLinkTextColor(Color.parseColor("#2196F3"));
								t2.setLinksClickable(true);
								b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										dialog1.dismiss();
									}
								});
								b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										dialog1.dismiss();
										finish();
									}
								});
								dialog1.setCancelable(false);
								dialog1.show();
							}
						}
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(_childKey)) {
					if (_childValue.containsKey("name")) {
						_drawer_textview1.setText(_childValue.get("name").toString());
						name = _childValue.get("name").toString();
						email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
						if (_childValue.get("pic").toString().equals("")) {
							_drawer_circleimageview1.setImageResource(R.drawable.user);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(circleimageview1);
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(_drawer_circleimageview1);
						}
						if (_childValue.containsKey("active")) {
							if (_childValue.get("active").toString().equals("true")) {
								
							}
							else {
								final AlertDialog dialog1 = new AlertDialog.Builder(HomeActivity.this).create();
								View inflate = getLayoutInflater().inflate(R.layout.signout,null); 
								dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
								dialog1.setView(inflate);
								TextView t1 = (TextView) inflate.findViewById(R.id.t1);
								
								TextView t2 = (TextView) inflate.findViewById(R.id.t2);
								
								TextView b1 = (TextView) inflate.findViewById(R.id.b1);
								
								TextView b2 = (TextView) inflate.findViewById(R.id.b2);
								
								LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
								
								LinearLayout linear3 = (LinearLayout) inflate.findViewById(R.id.linear3);
								t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 1);
								t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 0);
								b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 1);
								b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans.ttf"), 1);
								t1.setText("Banned!");
								t2.setText("Your account was banned. You are brake the Sketchub rules. If you think it was a mistake to connect us projectstore79@gmail.com");
								b1.setText("");
								b2.setText("EXIT APP");
								b2.setClickable(true);
								android.text.util.Linkify.addLinks(b2, android.text.util.Linkify.ALL);
								b2.setLinkTextColor(Color.parseColor("#2196F3"));
								b2.setLinksClickable(true);
								_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
								b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										dialog1.dismiss();
									}
								});
								b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										dialog1.dismiss();
										finish();
									}
								});
								dialog1.setCancelable(false);
								dialog1.show();
							}
						}
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
		users.addChildEventListener(_users_child_listener);
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				data1_loaded = true;
				gridmap1.add((int)0, _childValue);
				recyclerview2.setHasFixedSize(true);
				recyclerview2.setAdapter(new Recyclerview2Adapter(gridmap1));
				if (_childValue.containsKey("likes")) {
					gridmap2.add((int)0, _childValue);
					recyclerview3.setHasFixedSize(true);
					recyclerview3.setAdapter(new Recyclerview3Adapter(gridmap2));
					_SortMap(gridmap2, "likes", true, false);
				}
				if (_childValue.containsKey("editor")) {
					if (_childValue.get("editor").toString().equals("true")) {
						gridmap3.add((int)0, _childValue);
					}
					recyclerview1.setHasFixedSize(true);
					recyclerview1.setAdapter(new Recyclerview1Adapter(gridmap3));
				}
				_TransitionManager(line_home, 400);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				n = 0;
				for(int _repeat18 = 0; _repeat18 < (int)(gridmap1.size()); _repeat18++) {
					if (gridmap1.get((int)n).get("key").toString().equals(_childKey)) {
						gridmap1.remove((int)(n));
						gridmap1.add((int)n, _childValue);
					}
					n++;
				}
				recyclerview2.setHasFixedSize(true);
				recyclerview2.setAdapter(new Recyclerview2Adapter(gridmap1));
				if (_childValue.containsKey("likes")) {
					n = 0;
					for(int _repeat50 = 0; _repeat50 < (int)(gridmap2.size()); _repeat50++) {
						if (gridmap2.get((int)n).get("key").toString().equals(_childKey)) {
							gridmap2.remove((int)(n));
							gridmap2.add((int)n, _childValue);
						}
						n++;
					}
					recyclerview3.setHasFixedSize(true);
					recyclerview3.setAdapter(new Recyclerview3Adapter(gridmap2));
					_SortMap(gridmap2, "likes", true, false);
				}
				if (_childValue.containsKey("editor")) {
					if (_childValue.get("editor").toString().equals("true")) {
						n = 0;
						for(int _repeat82 = 0; _repeat82 < (int)(gridmap3.size()); _repeat82++) {
							if (gridmap3.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap3.remove((int)(n));
								gridmap3.add((int)n, _childValue);
							}
							n++;
						}
					}
					recyclerview1.setHasFixedSize(true);
					recyclerview1.setAdapter(new Recyclerview1Adapter(gridmap3));
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
				n = 0;
				for(int _repeat16 = 0; _repeat16 < (int)(gridmap1.size()); _repeat16++) {
					if (gridmap1.get((int)n).get("key").toString().equals(_childKey)) {
						gridmap1.remove((int)(n));
					}
					n++;
				}
				recyclerview2.setHasFixedSize(true);
				recyclerview2.setAdapter(new Recyclerview2Adapter(gridmap1));
				if (_childValue.containsKey("likes")) {
					n = 0;
					for(int _repeat32 = 0; _repeat32 < (int)(gridmap2.size()); _repeat32++) {
						if (gridmap2.get((int)n).get("key").toString().equals(_childKey)) {
							gridmap2.remove((int)(n));
						}
						n++;
					}
					recyclerview3.setHasFixedSize(true);
					recyclerview3.setAdapter(new Recyclerview3Adapter(gridmap2));
					_SortMap(gridmap2, "likes", true, false);
				}
				if (_childValue.containsKey("editor")) {
					if (_childValue.get("editor").toString().equals("true")) {
						n = 0;
						for(int _repeat55 = 0; _repeat55 < (int)(gridmap3.size()); _repeat55++) {
							if (gridmap3.get((int)n).get("key").toString().equals(_childKey)) {
								gridmap3.remove((int)(n));
							}
							n++;
						}
					}
					recyclerview1.setHasFixedSize(true);
					recyclerview1.setAdapter(new Recyclerview1Adapter(gridmap3));
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		data1.addChildEventListener(_data1_child_listener);
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_drawer_profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AccountActivity.class);
				intent.putExtra("mode", "user");
				intent.putExtra("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				startActivity(intent);
				_TransictionActivity();
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_upload.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, UploadActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_code.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, PhysicalGrowthActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_mblocks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, TimeManagementActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_cblocks.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, MetalhealthActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, CodingExpActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, CodingLangActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(HomeActivity.this, AboutActivity.class)); Animatoo.animateFade(HomeActivity.this);
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		search_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
			Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(0xFF008375); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		_removeScollBar(vscroll1);
		_drawer();
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		_Toolbar(false);
		_card_style(linear9, 7, 15, "#FFFFFF");
		if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals("dGB4o2perCOwKGn9c16lJC5ycSV2")) {
			_fab.show();
		}
		else {
			_fab.hide();
		}
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this));
		recyclerview2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this));
		recyclerview3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		linear3.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
			public void onSwipeRight() {
				_drawer.openDrawer(GravityCompat.START);
			}
			public void onSwipeLeft() {
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
	}
	public class OnSwipeTouchListener implements View.OnTouchListener {
		
		private final GestureDetector gestureDetector;
		
		public OnSwipeTouchListener(Context c) {
			gestureDetector = new GestureDetector(c, new GestureListener());
		}
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			return gestureDetector.onTouchEvent(event);
		}
		
		private final class GestureListener extends GestureDetector.SimpleOnGestureListener {
			
			private static final int SWIPE_THRESHOLD = 100;
			private static final int SWIPE_VELOCITY_THRESHOLD = 100;
			
			@Override
			public boolean onDown(MotionEvent e) {
				return true;
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
				boolean result = false;
				try {
					float diffY = e2.getY() - e1.getY();
					float diffX = e2.getX() - e1.getX();
					if (Math.abs(diffX) > Math.abs(diffY)) {
						if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
							if (diffX > 0) {
								onSwipeRight();
							}
							else {
								onSwipeLeft();
							}
							result = true;
						}
					}
					else {
						if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
							if (diffY > 0) {
								onSwipeBottom();
							}
							else {
								onSwipeTop();
							}
							result = true;
						}
					}
				}
				catch (Exception exception) {
					exception.printStackTrace();
				}
				return result;
			}
		}
		
		public void onSwipeRight() {}
		public void onSwipeLeft() {}
		public void onSwipeTop() {}
		public void onSwipeBottom() {}
		
	}
	{
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _click_effect(final View _view, final String _c) {
		_view.setBackground(Drawables.getSelectableDrawableFor(Color.parseColor(_c)));
		_view.setClickable(true);
		
	}
	
	public static class Drawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[8];
			        Arrays.fill(outerRadii, 0);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
			    }
	}
	public static class CircleDrawables {
		    public static android.graphics.drawable.Drawable getSelectableDrawableFor(int color) {
			        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
				            android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_pressed},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{android.R.attr.state_focused},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            stateListDrawable.addState(
				                new int[]{},
				                new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"))
				            );
				            return stateListDrawable;
				        } else {
				            android.content.res.ColorStateList pressedColor = android.content.res.ColorStateList.valueOf(color);
				            android.graphics.drawable.ColorDrawable defaultColor = new android.graphics.drawable.ColorDrawable(Color.parseColor("#00ffffff"));
				            
				android.graphics.drawable.Drawable rippleColor = getRippleColor(color);
				            return new android.graphics.drawable.RippleDrawable(
				                pressedColor,
				                defaultColor,
				                rippleColor
				            );
				        }
			    }
		
		    private static android.graphics.drawable.Drawable getRippleColor(int color) {
			        float[] outerRadii = new float[180];
			        Arrays.fill(outerRadii, 80);
			        android.graphics.drawable.shapes.RoundRectShape r = new android.graphics.drawable.shapes.RoundRectShape(outerRadii, null, null);
			        
			android.graphics.drawable.ShapeDrawable shapeDrawable = new 
			android.graphics.drawable.ShapeDrawable(r);
			        shapeDrawable.getPaint().setColor(color);
			        return shapeDrawable;
			    }
		 
		    private static int lightenOrDarken(int color, double fraction) {
			        if (canLighten(color, fraction)) {
				            return lighten(color, fraction);
				        } else {
				            return darken(color, fraction);
				        }
			    }
		 
		    private static int lighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = lightenColor(red, fraction);
			        green = lightenColor(green, fraction);
			        blue = lightenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static int darken(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        red = darkenColor(red, fraction);
			        green = darkenColor(green, fraction);
			        blue = darkenColor(blue, fraction);
			        int alpha = Color.alpha(color);
			 
			        return Color.argb(alpha, red, green, blue);
			    }
		 
		    private static boolean canLighten(int color, double fraction) {
			        int red = Color.red(color);
			        int green = Color.green(color);
			        int blue = Color.blue(color);
			        return canLightenComponent(red, fraction)
			            && canLightenComponent(green, fraction)
			            && canLightenComponent(blue, fraction);
			    }
		 
		    private static boolean canLightenComponent(int colorComponent, double fraction) {
			        int red = Color.red(colorComponent);
			        int green = Color.green(colorComponent);
			        int blue = Color.blue(colorComponent);
			        return red + (red * fraction) < 255
			            && green + (green * fraction) < 255
			            && blue + (blue * fraction) < 255;
			    }
		 
		    private static int darkenColor(int color, double fraction) {
			        return (int) Math.max(color - (color * fraction), 0);
			    }
		 
		    private static int lightenColor(int color, double fraction) {
			        return (int) Math.min(color + (color * fraction), 255);
		}
	}
	
	public void drawableclass() {
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(HomeActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _priv_snap(final String _text) {
		
	}
	
	
	public void _Toolbar(final boolean _v) {
		if (_v) {
			getSupportActionBar().show();
		}
		else {
			getSupportActionBar().hide();
		}
	}
	
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		final Object _keyObject = _key;
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					}
					else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				}
				else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					}
					else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
		///Use true or false blocks if sorting number of listmap
	}
	
	
	public void _card_style(final View _view, final double _shadow, final double _rounds, final String _colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_colour));
		gd.setCornerRadius((int)_rounds);
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _notification(final String _Title, final String _Content) {
		final Context context = getApplicationContext();
		
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this, HomeActivity.class); 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0); 
		androidx.core.app.NotificationCompat.Builder builder; 
		int notificationId = 1;
		    String channelId = "channel-01";
		    String channelName = "Channel Name";
		    int importance = NotificationManager.IMPORTANCE_HIGH;
		
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			        NotificationChannel mChannel = new NotificationChannel(
			                channelId, channelName, importance);
			        notificationManager.createNotificationChannel(mChannel);
			    }
		 androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
		            .setSmallIcon(R.drawable.sk_logo_2)
		            .setContentTitle(_Title)
		            .setContentText(_Content)
		            .setAutoCancel(true)
		            .setOngoing(false)
		            .setContentIntent(pendingIntent);
		    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		    stackBuilder.addNextIntent(intent);
		    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		    );
		    mBuilder.setContentIntent(resultPendingIntent);
		
		    notificationManager.notify(notificationId, mBuilder.build());
	}
	
	
	public void _drawer() {
		_drawer_textview2.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
		_drawer_textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		_drawer_textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		_drawer_textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		_drawer_textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		_drawer_textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		_drawer_textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
	}
	
	
	public void _Download(final String _url, final String _path) {
		try{
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse( _url)); 
			request.setMimeType(This.getContentResolver().getType(Uri.parse(_url))); 
			String cookies = CookieManager.getInstance().getCookie(_url); 
			request.addRequestHeader("cookie", cookies); 
			//request.addRequestHeader("User-Agent", tab.getSettings().getUserAgentString());
			request.setDescription("Downloading file..."); 
			request.setTitle(URLUtil.guessFileName(_url,"",""));
			request.allowScanningByMediaScanner(); 
			request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); 
			request.setDestinationInExternalPublicDir( _path.equals("")?Environment.DIRECTORY_DOWNLOADS:_path, URLUtil.guessFileName(_url,"","")); 
			DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE); dm.enqueue(request);
			Toast.makeText(getApplicationContext(), "Downloading File", Toast.LENGTH_LONG).show();
		}catch(Exception e){showMessage(e.toString());}
	}final Context This = this; void nothing(){
		
		
	}
	
	
	public void _Icon_Colour(final ImageView _iconview, final String _colour) {
		_iconview.getDrawable().setColorFilter(Color.parseColor(_colour), PorterDuff.Mode.SRC_IN);
	}
	
	
	public void _CalculateSize(final double _fileSize) {
		B = 1024;
		KB = B * B;
		MB = B * (B * B);
		GB = B * (B * (B * B));
		TB = B * (B * (B * (B * B)));
		PB = B * (B * (B * (B * (B * B))));
		if (_fileSize < B) {
			returnedSize = String.valueOf((long)(_fileSize)).concat(" B");
		}
		else {
			if (_fileSize < KB) {
				returnedSize = new DecimalFormat("0.00").format(_fileSize / B).concat(" KB");
			}
			else {
				if (_fileSize < MB) {
					returnedSize = new DecimalFormat("0.00").format(_fileSize / KB).concat(" MB");
				}
				else {
					if (_fileSize < GB) {
						returnedSize = new DecimalFormat("0.00").format(_fileSize / MB).concat(" GB");
					}
					else {
						if (_fileSize < TB) {
							returnedSize = new DecimalFormat("0.00").format(_fileSize / GB).concat(" TB");
						}
						else {
							if (_fileSize < PB) {
								returnedSize = new DecimalFormat("0.00").format(_fileSize / TB).concat(" PB");
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _TransictionActivity() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration);
		autoTransition.setInterpolator(new android.view.animation.DecelerateInterpolator()); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _StartTransitionActivity(final Intent _intent, final View _view, final String _name) {
		//code made by LORD HOSSEIN 
		_view.setTransitionName(_name); 
		
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, _view, _name); 
		startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public void _RoundAndBorder(final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	
	public void _addCardView(final View _layoutView, final double _margins, final double _cornerRadius, final double _cardElevation, final double _cardMaxElevation, final boolean _preventCornerOverlap, final String _backgroundColor) {
		androidx.cardview.widget.CardView cv = new androidx.cardview.widget.CardView(this);
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		int m = (int)_margins;
		lp.setMargins(m,m,m,m);
		cv.setLayoutParams(lp);
		int c = Color.parseColor(_backgroundColor);
		cv.setCardBackgroundColor(c);
		cv.setRadius((float)_cornerRadius);
		cv.setCardElevation((float)_cardElevation);
		cv.setMaxCardElevation((float)_cardMaxElevation);
		cv.setPreventCornerOverlap(_preventCornerOverlap);
		if(_layoutView.getParent() instanceof LinearLayout){
			ViewGroup vg = ((ViewGroup)_layoutView.getParent());
			vg.removeView(_layoutView);
			vg.removeAllViews();
			vg.addView(cv);
			cv.addView(_layoutView);
		}else{
			
		}
	}
	
	
	public void _showRating() {
		final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(HomeActivity.this);
		
		View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.rating,null );
		bottomSheetDialog.setContentView(bottomSheetView);
		
		bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
		TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
		
		TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
		
		TextView b1 = (TextView) bottomSheetView.findViewById(R.id.b1);
		
		TextView b2 = (TextView) bottomSheetView.findViewById(R.id.b2);
		
		TextView t3 = (TextView) bottomSheetView.findViewById(R.id.t3);
		
		TextView t4 = (TextView) bottomSheetView.findViewById(R.id.t4);
		
		ImageView i1 = (ImageView) bottomSheetView.findViewById(R.id.i1);
		
		LinearLayout bg1 = (LinearLayout) bottomSheetView.findViewById(R.id.bg1);
		
		LinearLayout bg2 = (LinearLayout) bottomSheetView.findViewById(R.id.bg2);
		
		LinearLayout card = (LinearLayout) bottomSheetView.findViewById(R.id.card);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
		b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_medium.ttf"), 0);
		t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/en_light.ttf"), 0);
		_RoundAndBorder(bg1, "#FFFFFF", 0, "#000000", 15);
		_RoundAndBorder(bg2, "#FFFFFF", 0, "#000000", 15);
		_addCardView(card, 0, 15, 0, 0, true, "#FFFFFF");
		_rippleRoundStroke(b2, "#FFFFFF", "#EEEEEE", 15, 2.5d, "#EEEEEE");
		_rippleRoundStroke(b1, "#4169E1", "#40FFFFFF", 15, 0, "#000000");
		i1.setImageResource(R.drawable.app_icon);
		package_name = getApplicationContext().getPackageName();
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			t4.setText("Version ".concat(pinfo.versionName));
		}
		catch (Exception e){ showMessage(e.toString()); }
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				bottomSheetDialog.dismiss();
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=arghozalidev.ARG.Injector"));
				startActivity(intent);
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				bottomSheetDialog.dismiss();
			}
		});
		bottomSheetDialog.setCancelable(true);
		bottomSheetDialog.show();
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.editors, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView title = _view.findViewById(R.id.title);
			final TextView catagory = _view.findViewById(R.id.catagory);
			final TextView size = _view.findViewById(R.id.size);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
			catagory.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			size.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ProjectViewActivity.class);
					intent.putExtra("key", _data.get((int)_position).get("key").toString());
					intent.putExtra("uid", _data.get((int)_position).get("uid").toString());
					_StartTransitionActivity(intent, cardview2, "project");
				}
			});
			if (_data.get((int)_position).containsKey("size")) {
				size.setText(_data.get((int)_position).get("size").toString());
			}
			if (_data.get((int)_position).containsKey("title")) {
				title.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("catagory")) {
				catagory.setText(_data.get((int)_position).get("catagory").toString());
			}
			if (_data.get((int)_position).containsKey("sc1")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("sc1").toString())).into(imageview1);
			}
			if (_data.get((int)_position).containsKey("icon")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(imageview2);
			}
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.home_cus, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView title = _view.findViewById(R.id.title);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView icon = _view.findViewById(R.id.icon);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView likes = _view.findViewById(R.id.likes);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView comments = _view.findViewById(R.id.comments);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			if (_data.get((int)_position).containsKey("icon")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(icon);
			}
			else {
				icon.setImageResource(R.drawable.android_icon);
			}
			if (_data.get((int)_position).containsKey("title")) {
				title.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("likes")) {
				likes.setText(_data.get((int)_position).get("likes").toString());
			}
			if (_data.get((int)_position).containsKey("comments")) {
				comments.setText(_data.get((int)_position).get("comments").toString());
			}
			title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			comments.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ProjectViewActivity.class);
					intent.putExtra("key", _data.get((int)_position).get("key").toString());
					intent.putExtra("uid", _data.get((int)_position).get("uid").toString());
					_StartTransitionActivity(intent, cardview1, "project");
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
		}
	}
	
	public class Recyclerview3Adapter extends RecyclerView.Adapter<Recyclerview3Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview3Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.home_cus, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final TextView title = _view.findViewById(R.id.title);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView icon = _view.findViewById(R.id.icon);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView likes = _view.findViewById(R.id.likes);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			final TextView comments = _view.findViewById(R.id.comments);
			
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_view.setLayoutParams(_lp);
			if (_data.get((int)_position).containsKey("icon")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("icon").toString())).into(icon);
			}
			else {
				icon.setImageResource(R.drawable.android_icon);
			}
			if (_data.get((int)_position).containsKey("title")) {
				title.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("likes")) {
				likes.setText(_data.get((int)_position).get("likes").toString());
			}
			if (_data.get((int)_position).containsKey("comments")) {
				comments.setText(_data.get((int)_position).get("comments").toString());
			}
			title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			comments.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), ProjectViewActivity.class);
					intent.putExtra("key", _data.get((int)_position).get("key").toString());
					intent.putExtra("uid", _data.get((int)_position).get("uid").toString());
					_StartTransitionActivity(intent, cardview1, "project");
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
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