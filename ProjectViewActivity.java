package com.colo.bookapp;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.webkit.*;
import android.widget.*;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bachors.wordtospan.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.github.angads25.filepicker.*;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jsibbold.zoomage.*;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import uk.co.senab.photoview.*;

public class ProjectViewActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private boolean int_isLoaded = false;
	private String key = "";
	private String uid = "";
	private String URL = "";
	private String icon_URL = "";
	private String SKETCHLIB_PATH = "";
	private String SKETCHLIB_PATH_HIDE = "";
	private String SKETCHWARE_PATH = "";
	private String new_id = "";
	private HashMap<String, Object> decrypt_map = new HashMap<>();
	private String temp_decrypted = "";
	private double number = 0;
	private double like_num = 0;
	private double comment_num = 0;
	private boolean liked = false;
	private String like_key = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> map2 = new HashMap<>();
	private HashMap<String, Object> data_map = new HashMap<>();
	private String share = "";
	private HashMap<String, Object> mp = new HashMap<>();
	private String name = "";
	private String s1 = "";
	private String s2 = "";
	private String s3 = "";
	private String s4 = "";
	private String s5 = "";
	private double download_num = 0;
	private HashMap<String, Object> map_download2 = new HashMap<>();
	private boolean isVisible = false;
	private String message = "";
	
	private ArrayList<String> temp = new ArrayList<>();
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm1 = new ArrayList<>();
	
	private LinearLayout linear30;
	private LinearLayout toolbar;
	private LinearLayout back;
	private ImageView imageview4;
	private TextView textview10;
	private ImageView like_btn;
	private ImageView imageview9;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear9;
	private HorizontalScrollView hscroll2;
	private LinearLayout linear4;
	private LinearLayout linear26;
	private LinearLayout linear13;
	private CardView cardview6;
	private LinearLayout linear25;
	private ImageView icon;
	private TextView title;
	private TextView username;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear31;
	private LinearLayout linear17;
	private LinearLayout linear27;
	private LinearLayout linear8;
	private TextView likes;
	private TextView textview12;
	private ImageView imageview1;
	private TextView textview22;
	private ImageView imageview8;
	private TextView textview20;
	private TextView textview21;
	private TextView textview13;
	private TextView downloadlink;
	private LinearLayout download_btn;
	private TextView download_txt;
	private ProgressBar progressbar1;
	private LinearLayout linear28;
	private LinearLayout linear10;
	private HorizontalScrollView hscroll3;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private LinearLayout linear11;
	private ImageView imageview5;
	private LinearLayout linear29;
	private CardView cardview1;
	private CardView cardview2;
	private CardView cardview3;
	private CardView cardview4;
	private CardView cardview5;
	private ImageView im1;
	private ImageView im2;
	private ImageView imageview10;
	private ImageView im4;
	private ImageView im5;
	private LinearLayout linear6;
	private TextView textview11;
	private TextView comments;
	private ImageView imageview7;
	
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
	
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private StorageReference project = _firebase_storage.getReference("project");
	private OnCompleteListener<Uri> _project_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _project_download_success_listener;
	private OnSuccessListener _project_delete_success_listener;
	private OnProgressListener _project_upload_progress_listener;
	private OnProgressListener _project_download_progress_listener;
	private OnFailureListener _project_failure_listener;
	
	private StorageReference icon_ = _firebase_storage.getReference("icon");
	private OnCompleteListener<Uri> _icon__upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _icon__download_success_listener;
	private OnSuccessListener _icon__delete_success_listener;
	private OnProgressListener _icon__upload_progress_listener;
	private OnProgressListener _icon__download_progress_listener;
	private OnFailureListener _icon__failure_listener;
	
	private AlertDialog.Builder delete;
	private TimerTask timer;
	private DatabaseReference like = _firebase.getReference("likes");
	private ChildEventListener _like_child_listener;
	private DatabaseReference comment = _firebase.getReference("comments");
	private ChildEventListener _comment_child_listener;
	private Intent intent = new Intent();
	private StorageReference screenshot1 = _firebase_storage.getReference("screenshot1");
	private OnCompleteListener<Uri> _screenshot1_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _screenshot1_download_success_listener;
	private OnSuccessListener _screenshot1_delete_success_listener;
	private OnProgressListener _screenshot1_upload_progress_listener;
	private OnProgressListener _screenshot1_download_progress_listener;
	private OnFailureListener _screenshot1_failure_listener;
	
	private StorageReference screenshot2 = _firebase_storage.getReference("screenshot2");
	private OnCompleteListener<Uri> _screenshot2_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _screenshot2_download_success_listener;
	private OnSuccessListener _screenshot2_delete_success_listener;
	private OnProgressListener _screenshot2_upload_progress_listener;
	private OnProgressListener _screenshot2_download_progress_listener;
	private OnFailureListener _screenshot2_failure_listener;
	
	private StorageReference screenshot3 = _firebase_storage.getReference("screenshot3");
	private OnCompleteListener<Uri> _screenshot3_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _screenshot3_download_success_listener;
	private OnSuccessListener _screenshot3_delete_success_listener;
	private OnProgressListener _screenshot3_upload_progress_listener;
	private OnProgressListener _screenshot3_download_progress_listener;
	private OnFailureListener _screenshot3_failure_listener;
	
	private StorageReference screenshot4_ = _firebase_storage.getReference("screenshot4");
	private OnCompleteListener<Uri> _screenshot4__upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _screenshot4__download_success_listener;
	private OnSuccessListener _screenshot4__delete_success_listener;
	private OnProgressListener _screenshot4__upload_progress_listener;
	private OnProgressListener _screenshot4__download_progress_listener;
	private OnFailureListener _screenshot4__failure_listener;
	
	private StorageReference screenshot5_ = _firebase_storage.getReference("screenshot5");
	private OnCompleteListener<Uri> _screenshot5__upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _screenshot5__download_success_listener;
	private OnSuccessListener _screenshot5__delete_success_listener;
	private OnProgressListener _screenshot5__upload_progress_listener;
	private OnProgressListener _screenshot5__download_progress_listener;
	private OnFailureListener _screenshot5__failure_listener;
	
	private DatabaseReference download = _firebase.getReference("download");
	private ChildEventListener _download_child_listener;
	private TimerTask t;
	private StorageReference swb = _firebase_storage.getReference("swb");
	private OnCompleteListener<Uri> _swb_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _swb_download_success_listener;
	private OnSuccessListener _swb_delete_success_listener;
	private OnProgressListener _swb_upload_progress_listener;
	private OnProgressListener _swb_download_progress_listener;
	private OnFailureListener _swb_failure_listener;
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.project_view);
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
		linear30 = findViewById(R.id.linear30);
		toolbar = findViewById(R.id.toolbar);
		back = findViewById(R.id.back);
		imageview4 = findViewById(R.id.imageview4);
		textview10 = findViewById(R.id.textview10);
		like_btn = findViewById(R.id.like_btn);
		imageview9 = findViewById(R.id.imageview9);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear9 = findViewById(R.id.linear9);
		hscroll2 = findViewById(R.id.hscroll2);
		linear4 = findViewById(R.id.linear4);
		linear26 = findViewById(R.id.linear26);
		linear13 = findViewById(R.id.linear13);
		cardview6 = findViewById(R.id.cardview6);
		linear25 = findViewById(R.id.linear25);
		icon = findViewById(R.id.icon);
		title = findViewById(R.id.title);
		username = findViewById(R.id.username);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear31 = findViewById(R.id.linear31);
		linear17 = findViewById(R.id.linear17);
		linear27 = findViewById(R.id.linear27);
		linear8 = findViewById(R.id.linear8);
		likes = findViewById(R.id.likes);
		textview12 = findViewById(R.id.textview12);
		imageview1 = findViewById(R.id.imageview1);
		textview22 = findViewById(R.id.textview22);
		imageview8 = findViewById(R.id.imageview8);
		textview20 = findViewById(R.id.textview20);
		textview21 = findViewById(R.id.textview21);
		textview13 = findViewById(R.id.textview13);
		downloadlink = findViewById(R.id.downloadlink);
		download_btn = findViewById(R.id.download_btn);
		download_txt = findViewById(R.id.download_txt);
		progressbar1 = findViewById(R.id.progressbar1);
		linear28 = findViewById(R.id.linear28);
		linear10 = findViewById(R.id.linear10);
		hscroll3 = findViewById(R.id.hscroll3);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		linear11 = findViewById(R.id.linear11);
		imageview5 = findViewById(R.id.imageview5);
		linear29 = findViewById(R.id.linear29);
		cardview1 = findViewById(R.id.cardview1);
		cardview2 = findViewById(R.id.cardview2);
		cardview3 = findViewById(R.id.cardview3);
		cardview4 = findViewById(R.id.cardview4);
		cardview5 = findViewById(R.id.cardview5);
		im1 = findViewById(R.id.im1);
		im2 = findViewById(R.id.im2);
		imageview10 = findViewById(R.id.imageview10);
		im4 = findViewById(R.id.im4);
		im5 = findViewById(R.id.im5);
		linear6 = findViewById(R.id.linear6);
		textview11 = findViewById(R.id.textview11);
		comments = findViewById(R.id.comments);
		imageview7 = findViewById(R.id.imageview7);
		auth = FirebaseAuth.getInstance();
		delete = new AlertDialog.Builder(this);
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		like_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(like_btn);
				_Ripple_Drawable(like_btn, "#EEEEEE");
				if (liked) {
					map = new HashMap<>();
					map.put("value", "false");
					map.put("key", key);
					map.put("like_key", like_key);
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					like.child(like_key).updateChildren(map);
				}
				else {
					map = new HashMap<>();
					map.put("value", "true");
					map.put("key", key);
					map.put("like_key", like_key);
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					like.child(like_key).updateChildren(map);
				}
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear30.performClick();
				_PopUpMenu(linear30);
			}
		});
		
		icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), IconViewActivity.class);
				intent.putExtra("icon", icon_URL);
				_StartTransitionActivity(intent, icon, "im");
			}
		});
		
		username.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), AccountActivity.class);
				intent.putExtra("mode", "user");
				intent.putExtra("uid", uid);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				_TransictionActivity();
			}
		});
		
		download_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(downloadlink.getText().toString()));
				startActivity(intent);
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), ReadmoreActivity.class);
				intent.putExtra("uid", uid);
				intent.putExtra("key", key);
				intent.putExtra("name", name);
				startActivity(intent);
				_TransictionActivity();
			}
		});
		
		im1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!s1.equals("")) {
					intent.setClass(getApplicationContext(), IconViewActivity.class);
					intent.putExtra("icon", s1);
					_StartTransitionActivity(intent, im1, "im");
				}
			}
		});
		
		im2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!s2.equals("")) {
					intent.setClass(getApplicationContext(), IconViewActivity.class);
					intent.putExtra("icon", s2);
					_StartTransitionActivity(intent, im2, "im");
				}
			}
		});
		
		im4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!s4.equals("")) {
					intent.setClass(getApplicationContext(), IconViewActivity.class);
					intent.putExtra("icon", s4);
					_StartTransitionActivity(intent, im4, "im");
				}
			}
		});
		
		im5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!s5.equals("")) {
					intent.setClass(getApplicationContext(), IconViewActivity.class);
					intent.putExtra("icon", s5);
					_StartTransitionActivity(intent, im5, "im");
				}
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), CommentsActivity.class);
				intent.putExtra("title", title.getText().toString());
				intent.putExtra("key", key);
				intent.putExtra("uid", uid);
				intent.putExtra("icon", icon_URL);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
				_TransictionActivity();
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("icon")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("icon").toString())).into(icon);
						icon_URL = _childValue.get("icon").toString();
					}
					else {
						icon.setImageResource(R.drawable.android_icon);
					}
					if (_childValue.containsKey("title")) {
						title.setText(_childValue.get("title").toString());
					}
					if (_childValue.containsKey("likes")) {
						likes.setText(_childValue.get("likes").toString());
					}
					if (_childValue.containsKey("comments")) {
						comments.setText(_childValue.get("comments").toString());
					}
					if (_childValue.containsKey("project")) {
						URL = _childValue.get("project").toString();
					}
					if (_childValue.containsKey("type")) {
						textview13.setText(_childValue.get("type").toString());
					}
					else {
						textview13.setText("FREE BOOKS ");
					}
					if (_childValue.containsKey("editor")) {
						if (_childValue.containsValue("true")) {
							linear31.setVisibility(View.VISIBLE);
						}
						else {
							linear31.setVisibility(View.GONE);
						}
					}
					if (_childValue.containsKey("catagory")) {
						textview21.setText(_childValue.get("catagory").toString());
					}
					else {
						textview21.setText("UI & UX");
					}
					if (_childValue.containsKey("size")) {
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										_TransitionManager(linear1, 400);
										download_txt.setText("Download Book".concat("(".concat(_childValue.get("size").toString()).concat(")")));
									}
								});
							}
						};
						_timer.schedule(timer, (int)(700));
					}
					else {
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										_TransitionManager(linear1, 400);
										download_txt.setText("Download Book ");
									}
								});
							}
						};
						_timer.schedule(timer, (int)(700));
					}
					if (_childValue.containsKey("dec")) {
						
					}
					if (_childValue.containsKey("new")) {
						if (_childValue.get("new").toString().equals("")) {
							textview4.setText("not available");
						}
						else {
							//Do not remove
							/*
MADE BY ABHILASH DHOKANE 
Give me credit if you decide to use, share this codes or project
*/
							message = _childValue.get("new").toString();
							Pattern p = Pattern.compile("(\\*\\*)(.*?)(\\*\\*)");
							    Matcher matcher = p.matcher(message);
							
							    SpannableStringBuilder spannable = new SpannableStringBuilder(message);
							    List<StyleSpan> spans = new ArrayList<>();
							    //for making text bold
							    while (matcher.find()) {
								        StyleSpan span = new StyleSpan(Typeface.BOLD);
								        spannable.setSpan(span, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
								        spans.add(span);
								    }
							    //for removing ** text
							    for (StyleSpan span : spans) {
								        spannable.replace(spannable.getSpanStart(span), spannable.getSpanStart(span) + 2, "");
								        spannable.replace(spannable.getSpanEnd(span) - 2, spannable.getSpanEnd(span), "");
								    }
								
							textview4.setText(spannable);
						}
					}
					if (_childValue.containsKey("sc1")) {
						if (_childValue.get("sc1").toString().equals("")) {
							cardview1.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc1").toString())).into(im1);
							s1 = _childValue.get("sc1").toString();
							cardview1.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im1);
					}
					if (_childValue.containsKey("sc2")) {
						if (_childValue.get("sc2").toString().equals("")) {
							cardview2.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc2").toString())).into(im2);
							s2 = _childValue.get("sc2").toString();
							cardview2.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im2);
					}
					if (_childValue.containsKey("project")) {
						if (_childValue.get("project").toString().equals("")) {
							cardview3.setVisibility(View.GONE);
						}
						else {
							downloadlink.setText(_childValue.get("project").toString());
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc2").toString())).into(imageview10);
							s3 = _childValue.get("project").toString();
							cardview3.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(imageview10);
					}
					if (_childValue.containsKey("sc4")) {
						if (_childValue.get("sc4").toString().equals("")) {
							cardview4.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc4").toString())).into(im4);
							s4 = _childValue.get("sc4").toString();
							cardview4.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im4);
					}
					if (_childValue.containsKey("sc5")) {
						if (_childValue.get("sc5").toString().equals("")) {
							cardview5.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc5").toString())).into(im5);
							s5 = _childValue.get("sc5").toString();
							cardview5.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im5);
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("icon")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("icon").toString())).into(icon);
						icon_URL = _childValue.get("icon").toString();
					}
					else {
						icon.setImageResource(R.drawable.android_icon);
					}
					if (_childValue.containsKey("title")) {
						title.setText(_childValue.get("title").toString());
					}
					if (_childValue.containsKey("likes")) {
						likes.setText(_childValue.get("likes").toString());
					}
					if (_childValue.containsKey("comments")) {
						comments.setText(_childValue.get("comments").toString());
					}
					if (_childValue.containsKey("project")) {
						URL = _childValue.get("project").toString();
					}
					if (_childValue.containsKey("catagory")) {
						textview21.setText(_childValue.get("catagory").toString());
					}
					else {
						textview21.setText("Premium Book ");
					}
					if (_childValue.containsKey("size")) {
						download_txt.setText("Download book".concat("(".concat(_childValue.get("size").toString()).concat(")")));
					}
					else {
						download_txt.setText("Download project");
					}
					if (_childValue.containsKey("dec")) {
						
					}
					if (_childValue.containsKey("new")) {
						if (_childValue.get("new").toString().equals("")) {
							textview4.setText("not available");
						}
						else {
							textview4.setText(_childValue.get("new").toString());
						}
					}
					if (_childValue.containsKey("sc1")) {
						if (_childValue.get("sc1").toString().equals("")) {
							cardview1.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc1").toString())).into(im1);
							s1 = _childValue.get("sc1").toString();
							cardview1.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im1);
					}
					if (_childValue.containsKey("sc2")) {
						if (_childValue.get("sc2").toString().equals("")) {
							cardview2.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc2").toString())).into(im2);
							s2 = _childValue.get("sc2").toString();
							cardview2.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im2);
					}
					if (_childValue.containsKey("sc3")) {
						if (_childValue.get("sc3").toString().equals("")) {
							cardview3.setVisibility(View.GONE);
						}
						else {
							
							s3 = _childValue.get("sc3").toString();
							cardview3.setVisibility(View.VISIBLE);
						}
					}
					else {
						
					}
					if (_childValue.containsKey("sc4")) {
						if (_childValue.get("sc4").toString().equals("")) {
							cardview4.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc4").toString())).into(im4);
							s4 = _childValue.get("sc4").toString();
							cardview4.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im4);
					}
					if (_childValue.containsKey("sc5")) {
						if (_childValue.get("sc5").toString().equals("")) {
							cardview5.setVisibility(View.GONE);
						}
						else {
							Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("sc5").toString())).into(im5);
							s5 = _childValue.get("sc5").toString();
							cardview5.setVisibility(View.VISIBLE);
						}
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/your.gif")).into(im5);
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
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(uid)) {
					if (_childValue.containsKey("name")) {
						username.setText(_childValue.get("name").toString());
						name = _childValue.get("name").toString();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(uid)) {
					if (_childValue.containsKey("name")) {
						username.setText(_childValue.get("name").toString());
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
		
		_project_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_project_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_project_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_project_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				progressbar1.setVisibility(View.GONE);
				download_txt.setVisibility(View.VISIBLE);
				download_txt.setText("Downloading...");
				_UnZip(SKETCHLIB_PATH.concat("temp/temp.zip"), SKETCHLIB_PATH_HIDE);
				_New_ID_Generation();
				FileUtil.makeDir(SKETCHWARE_PATH.concat("data/".concat(new_id)));
				FileUtil.makeDir(SKETCHWARE_PATH.concat("mysc/list/".concat(new_id)));
				FileUtil.makeDir(SKETCHWARE_PATH.concat("resources/fonts/".concat(new_id)));
				FileUtil.makeDir(SKETCHWARE_PATH.concat("resources/icons/".concat(new_id)));
				FileUtil.makeDir(SKETCHWARE_PATH.concat("resources/images/".concat(new_id)));
				FileUtil.makeDir(SKETCHWARE_PATH.concat("resources/sounds/".concat(new_id)));
				_Decrypt(SKETCHLIB_PATH_HIDE.concat("temp/list/project"));
				decrypt_map = new HashMap<>();
				decrypt_map = new Gson().fromJson(temp_decrypted, new TypeToken<HashMap<String, Object>>(){}.getType());
				decrypt_map.put("sc_id", new_id);
				temp_decrypted = new Gson().toJson(decrypt_map);
				_Encrypt(SKETCHLIB_PATH_HIDE.concat("temp/list/project"));
				_Copy(SKETCHLIB_PATH_HIDE.concat("temp/data"), SKETCHWARE_PATH.concat("data/".concat(new_id)));
				_Copy(SKETCHLIB_PATH_HIDE.concat("temp/list/"), SKETCHWARE_PATH.concat("mysc/list/".concat(new_id)));
				_Copy(SKETCHLIB_PATH_HIDE.concat("temp/fonts/"), SKETCHWARE_PATH.concat("resources/fonts/".concat(new_id)));
				_Copy(SKETCHLIB_PATH_HIDE.concat("temp/icons/"), SKETCHWARE_PATH.concat("resources/icons/".concat(new_id)));
				_Copy(SKETCHLIB_PATH_HIDE.concat("temp/images/"), SKETCHWARE_PATH.concat("resources/images/".concat(new_id)));
				_Copy(SKETCHLIB_PATH_HIDE.concat("temp/sounds/"), SKETCHWARE_PATH.concat("resources/sounds/".concat(new_id)));
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								download_txt.setText("");
								_TransitionManager(linear1, 400);
								download_txt.setText("Download complete.");
								download_btn.setEnabled(false);
								FileUtil.deleteFile(SKETCHLIB_PATH_HIDE.concat("temp"));
								download_num++;
								map_download2 = new HashMap<>();
								map_download2.put("download", String.valueOf((long)(download_num)));
								download.child(key).updateChildren(map_download2);
								users.child(uid).updateChildren(map_download2);
								map_download2.clear();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(2500));
			}
		};
		
		_project_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_project_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_icon__upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon__download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon__upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_icon__download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_icon__delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_icon__failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_like_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((_childValue.containsKey("key") && _childValue.containsKey("value")) && _childValue.containsKey("uid")) {
					if (key.equals(_childValue.get("key").toString()) && _childValue.get("value").toString().equals("true")) {
						like_num++;
						map2 = new HashMap<>();
						map2.put("likes", String.valueOf((long)(like_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
					if (key.equals(_childValue.get("key").toString()) && _childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						if (_childValue.get("value").toString().equals("true")) {
							like_btn.setImageResource(R.drawable.love_48dp);
							liked = true;
						}
						else {
							like_btn.setImageResource(R.drawable.ic_favorite_outline_grey);
							liked = false;
						}
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("key").toString().equals(key)) {
					if (_childValue.get("value").toString().equals("true")) {
						like_num++;
						map2 = new HashMap<>();
						map2.put("likes", String.valueOf((long)(like_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
					else {
						like_num--;
						map2 = new HashMap<>();
						map2.put("likes", String.valueOf((long)(like_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
				}
				if (_childValue.get("key").toString().equals(key) && _childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.get("value").toString().equals("true")) {
						like_btn.setImageResource(R.drawable.love_48dp);
						liked = true;
					}
					else {
						like_btn.setImageResource(R.drawable.ic_favorite_outline_grey);
						liked = false;
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
		like.addChildEventListener(_like_child_listener);
		
		_comment_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("post_key")) {
					if (key.equals(_childValue.get("post_key").toString())) {
						comment_num++;
						map2 = new HashMap<>();
						map2.put("comments", String.valueOf((long)(comment_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				SketchwareUtil.showMessage(getApplicationContext(), FirebaseAuth.getInstance().getCurrentUser().getUid().concat(FirebaseAuth.getInstance().getCurrentUser().getEmail()));
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("post_key")) {
					if (key.equals(_childValue.get("post_key").toString())) {
						comment_num--;
						map2 = new HashMap<>();
						map2.put("comments", String.valueOf((long)(comment_num)));
						data1.child(key).updateChildren(map2);
						map2.clear();
					}
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		comment.addChildEventListener(_comment_child_listener);
		
		_screenshot1_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot1_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot1_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_screenshot1_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot1_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_screenshot1_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_screenshot2_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot2_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot2_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_screenshot2_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot2_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_screenshot2_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_screenshot3_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot3_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot3_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_screenshot3_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot3_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_screenshot3_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_screenshot4__upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot4__download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot4__upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_screenshot4__download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot4__delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_screenshot4__failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_screenshot5__upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot5__download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot5__upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_screenshot5__download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_screenshot5__delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_screenshot5__failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_download_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(key)) {
					if (_childValue.containsKey("download")) {
						download_num = Double.parseDouble(_childValue.get("download").toString());
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
						download_num = Double.parseDouble(_childValue.get("download").toString());
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
		
		_swb_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_swb_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_swb_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_swb_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				_TransitionManager(linear4, 200);
				progressbar1.setVisibility(View.GONE);
				download_txt.setVisibility(View.VISIBLE);
				download_txt.setText("");
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_TransitionManager(linear4, 400);
								download_txt.setText("Download complete.");
								_MaterialDialog("Success", "File has been downloaded\nsuccessfuly to: /storage/emulated/ 0/Colo/Book Download/".concat(title.getText().toString()).concat(".pdf"), "", "OK");
							}
						});
					}
				};
				_timer.schedule(t, (int)(500));
			}
		};
		
		_swb_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_swb_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
		download_txt.setText("");
		progressbar1.setVisibility(View.GONE);
		_setProgressbarColor(progressbar1, "#FFFFFF");
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		imageview8.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		download_btn.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)12, (int)0, Color.TRANSPARENT, 0xFF2196F3));
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, Color.TRANSPARENT, 0xFFFF5722));
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)2, 0xFF9E9E9E, Color.TRANSPARENT));
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, Color.TRANSPARENT, 0xFF4CAF50));
		linear27.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)2, 0xFF9E9E9E, 0xFFFFFFFF));
		linear28.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFF000000, 0xFFFFFFFF));
		linear31.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, Color.TRANSPARENT, 0xFF2196F3));
		SKETCHLIB_PATH = FileUtil.getExternalStorageDir().concat("/Sketchub/");
		SKETCHLIB_PATH_HIDE = FileUtil.getExternalStorageDir().concat("/.SKETCHLIB/");
		SKETCHWARE_PATH = FileUtil.getExternalStorageDir().concat("/.sketchware/");
		if (!FileUtil.isExistFile(SKETCHLIB_PATH)) {
			FileUtil.makeDir(SKETCHLIB_PATH);
		}
		if (!FileUtil.isExistFile(SKETCHLIB_PATH_HIDE)) {
			FileUtil.makeDir(SKETCHLIB_PATH_HIDE);
		}
		if (!FileUtil.isExistFile(SKETCHWARE_PATH)) {
			FileUtil.makeDir(SKETCHWARE_PATH);
		}
		int_isLoaded = false;
		_Elevation(toolbar, 7);
		_Elevation(linear1, 7);
		_gd(linear1, 4, "#ffffff");
		getSupportActionBar().hide();
		key = getIntent().getStringExtra("key");
		uid = getIntent().getStringExtra("uid");
		_extrab();
		like_num = 0;
		comment_num = 0;
		download_num = 0;
		liked = false;
		like_key = key.concat(FirebaseAuth.getInstance().getCurrentUser().getUid());
		_more();
		linear5.setVisibility(View.GONE);
		linear29.setVisibility(View.GONE);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_TransitionManager(linear1, 400);
						linear5.setVisibility(View.VISIBLE);
						linear29.setVisibility(View.VISIBLE);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(500));
		_GetTransition(cardview6, "book");
		_removeScollBar(vscroll1);
		_removeScollBar(hscroll3);
		_removeScollBar(hscroll2);
	}
	
	public void _Elevation(final View _view, final double _number) {
		
		_view.setElevation((int)_number);
	}
	
	
	public void _gd(final View _view, final double _numb, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_numb);
		_view.setBackground(gd);
	}
	
	
	public void _Ripple_Drawable(final View _view, final String _c) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_c)}); android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null); _view.setBackground(ripdr);
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(ProjectViewActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _extrab() {
	}
	private ProgressDialog prog;
	{
	}
	
	
	public void _New_ID_Generation() {
		FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list"), temp);
		Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
		if (temp.size() == 0) {
			new_id = "601";
		}
		else {
			try {
				new_id = String.valueOf((long)(Double.parseDouble(Uri.parse(temp.get((int)(temp.size() - 1))).getLastPathSegment()) + 1));
			} catch(Exception e) {
			}
		}
	}
	
	
	public void _UnZip(final String _fileZip, final String _destDir) {
		try
		{
			java.io.File outdir = new java.io.File(_destDir);
			java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(_fileZip));
			java.util.zip.ZipEntry entry;
			String name, dir;
			while ((entry = zin.getNextEntry()) != null)
			{
				name = entry.getName();
				if(entry.isDirectory())
				{
					mkdirs(outdir, name);
					continue;
				}
				
				/* this part is necessary because file entry can come before
* directory entry where is file located
* i.e.:
* /foo/foo.txt
* /foo/
*/
				
				dir = dirpart(name);
				if(dir != null)
				mkdirs(outdir, dir);
				
				extractFile(zin, outdir, name);
			}
			zin.close();
		}
		catch (java.io.IOException e)
		{
			e.printStackTrace();
		}
	}
	private static void extractFile(java.util.zip.ZipInputStream in, java.io.File outdir, String name) throws java.io.IOException
	{
		byte[] buffer = new byte[4096];
		java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(outdir, name)));
		int count = -1;
		while ((count = in.read(buffer)) != -1)
		out.write(buffer, 0, count);
		out.close();
	}
	
	private static void mkdirs(java.io.File outdir, String path)
	{
		java.io.File d = new java.io.File(outdir, path);
		if(!d.exists())
		d.mkdirs();
	}
	
	private static String dirpart(String name)
	{
		int s = name.lastIndexOf(java.io.File.separatorChar);
		return s == -1 ? null : name.substring(0, s);
	}
	
	
	public void _Decrypt(final String _path) {
		try {
			javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] bytes = "sketchwaresecure".getBytes();
			instance.init(2, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
			java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(_path, "r");
			byte[] bArr = new byte[((int) randomAccessFile.length())];
			randomAccessFile.readFully(bArr);
			temp_decrypted = new String(instance.doFinal(bArr));
		} catch(Exception e) {
			showMessage(e.toString());
		}
	}
	
	
	public void _Encrypt(final String _path) {
		try {
			javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] bytes = "sketchwaresecure".getBytes();
			instance.init(1, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
			new java.io.RandomAccessFile(_path, "rw").write(instance.doFinal(temp_decrypted.getBytes()));
		} catch(Exception e) {
			showMessage(e.toString());
		}
	}
	
	
	public void _Copy(final String _F, final String _T) {
		FileUtil.makeDir(_T.concat("/"));
		copy_list.clear();
		FileUtil.listDir(_F.concat("/"), copy_list);
		number = 0;
		for(int _repeat11 = 0; _repeat11 < (int)(copy_list.size()); _repeat11++) {
			if (FileUtil.isFile(copy_list.get((int)(number)))) {
				FileUtil.copyFile(copy_list.get((int)(number)), _T.concat("/".concat(Uri.parse(copy_list.get((int)(number))).getLastPathSegment())));
			}
			number++;
		}
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration);
		autoTransition.setInterpolator(new android.view.animation.DecelerateInterpolator()); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _more() {
		toolbar.setElevation((float)10);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		comments.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
		download_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
		username.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		textview22.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		textview21.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
		textview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
	}
	
	
	public void _setProgressbarColor(final ProgressBar _prog, final String _color) {
		if (android.os.Build.VERSION.SDK_INT >= 21) {
			_prog.getIndeterminateDrawable().setColorFilter(Color.parseColor(_color), PorterDuff.Mode.SRC_IN);
			//KerDev
		}
	}
	
	
	public void _TransictionActivity() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	
	
	public void _PopUpMenu(final View _view) {
		View popup = getLayoutInflater().inflate(R.layout.popup, null);
		final PopupWindow pop_up = new PopupWindow(popup, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
		final LinearLayout bg = popup.findViewById(R.id.bg);
		final LinearLayout menu1 = popup.findViewById(R.id.menu1);
		final LinearLayout menu2 = popup.findViewById(R.id.menu2);
		final LinearLayout menu3 = popup.findViewById(R.id.menu3);
		bg.setElevation((float)4);
		menu1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_MaterialDialog("Confirm action", "Do you want to delete this project?", "CANCEL", "DELETE");
			}
		});
		menu2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pop_up.dismiss();
				com.google.android.material.snackbar.Snackbar.make(back, "Report not available", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
					@Override
					public void onClick(View _view) {
						 
					}
				}).show();
			}
		});
		menu3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				share = title.getText().toString().concat("  ".concat(URL));
				Intent i = new Intent(android.content.Intent.ACTION_SEND);i.setType("text/plain"); i.putExtra(android.content.Intent.EXTRA_TEXT, share); startActivity(Intent.createChooser(i,"Share using"));
				pop_up.dismiss();
			}
		});
		bg.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFFFFFFF));
		pop_up.showAsDropDown(_view, 0,0);
	}
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			isVisible = true;
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.loading);
			
			
			LinearLayout linear2 = (LinearLayout)coreprog.findViewById(R.id.linear2);
			
			LinearLayout background = (LinearLayout)coreprog.findViewById(R.id.background);
			
			LinearLayout layout_progress = (LinearLayout)coreprog.findViewById(R.id.layout_progress);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
			gd.setColor(Color.parseColor("#EEEEEE")); /* color */
			gd.setCornerRadius(40); /* radius */
			gd.setStroke(0, Color.WHITE); /* stroke heigth and color */
			linear2.setBackground(gd);
			
			RadialProgressView progress = new RadialProgressView(this);
			layout_progress.addView(progress);
		}
		else {
			isVisible = false;
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
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
	
	
	public void _MaterialDialog(final String _title, final String _message, final String _button1text, final String _button2text) {
		final AlertDialog dialog1 = new AlertDialog.Builder(ProjectViewActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.signout,null); 
		dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog1.setView(inflate);
		TextView t1 = (TextView) inflate.findViewById(R.id.t1);
		
		TextView t2 = (TextView) inflate.findViewById(R.id.t2);
		
		TextView b1 = (TextView) inflate.findViewById(R.id.b1);
		
		TextView b2 = (TextView) inflate.findViewById(R.id.b2);
		
		LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
		
		LinearLayout linear3 = (LinearLayout) inflate.findViewById(R.id.linear3);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		b1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		b2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		t1.setText(_title);
		t2.setText(_message);
		b1.setText(_button1text);
		b2.setText(_button2text);
		_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				dialog1.dismiss();
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				dialog1.dismiss();
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(uid)) {
					_telegramLoaderDialog(true);
					if (!icon_URL.equals("")) {
						_firebase_storage.getReferenceFromUrl(icon_URL).delete().addOnSuccessListener(_icon__delete_success_listener).addOnFailureListener(_icon__failure_listener);
					}
					if (!URL.equals("")) {
						_firebase_storage.getReferenceFromUrl(URL).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
					}
					if (!s1.equals("")) {
						_firebase_storage.getReferenceFromUrl(s1).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
					}
					if (!s2.equals("")) {
						_firebase_storage.getReferenceFromUrl(s2).delete().addOnSuccessListener(_screenshot2_delete_success_listener).addOnFailureListener(_screenshot2_failure_listener);
					}
					if (!s3.equals("")) {
						_firebase_storage.getReferenceFromUrl(s3).delete().addOnSuccessListener(_screenshot3_delete_success_listener).addOnFailureListener(_screenshot3_failure_listener);
					}
					if (!s4.equals("")) {
						_firebase_storage.getReferenceFromUrl(s4).delete().addOnSuccessListener(_screenshot4__delete_success_listener).addOnFailureListener(_screenshot4__failure_listener);
					}
					if (!s5.equals("")) {
						_firebase_storage.getReferenceFromUrl(s5).delete().addOnSuccessListener(_screenshot5__delete_success_listener).addOnFailureListener(_screenshot5__failure_listener);
					}
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									data1.child(key).removeValue();
									timer = new TimerTask() {
										@Override
										public void run() {
											runOnUiThread(new Runnable() {
												@Override
												public void run() {
													_telegramLoaderDialog(false);
													finish();
												}
											});
										}
									};
									_timer.schedule(timer, (int)(2000));
								}
							});
						}
					};
					_timer.schedule(timer, (int)(2000));
				}
				else {
					if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals("dGB4o2perCOwKGn9c16lJC5ycSV2")) {
						_telegramLoaderDialog(true);
						if (!icon_URL.equals("")) {
							_firebase_storage.getReferenceFromUrl(icon_URL).delete().addOnSuccessListener(_icon__delete_success_listener).addOnFailureListener(_icon__failure_listener);
						}
						if (!URL.equals("")) {
							_firebase_storage.getReferenceFromUrl(URL).delete().addOnSuccessListener(_project_delete_success_listener).addOnFailureListener(_project_failure_listener);
						}
						if (!s1.equals("")) {
							_firebase_storage.getReferenceFromUrl(s1).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
						}
						if (!s2.equals("")) {
							_firebase_storage.getReferenceFromUrl(s2).delete().addOnSuccessListener(_screenshot2_delete_success_listener).addOnFailureListener(_screenshot2_failure_listener);
						}
						if (!s3.equals("")) {
							_firebase_storage.getReferenceFromUrl(s3).delete().addOnSuccessListener(_screenshot3_delete_success_listener).addOnFailureListener(_screenshot3_failure_listener);
						}
						if (!s4.equals("")) {
							_firebase_storage.getReferenceFromUrl(s4).delete().addOnSuccessListener(_screenshot4__delete_success_listener).addOnFailureListener(_screenshot4__failure_listener);
						}
						if (!s5.equals("")) {
							_firebase_storage.getReferenceFromUrl(s5).delete().addOnSuccessListener(_screenshot5__delete_success_listener).addOnFailureListener(_screenshot5__failure_listener);
						}
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										data1.child(key).removeValue();
										timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_telegramLoaderDialog(false);
														finish();
													}
												});
											}
										};
										_timer.schedule(timer, (int)(2000));
									}
								});
							}
						};
						_timer.schedule(timer, (int)(2000));
					}
					else {
						com.google.android.material.snackbar.Snackbar snackbar = com.google.android.material.snackbar.Snackbar.make(linear1, "You can't delete this project",-2);
						
						snackbar.setAction( "ok" , new View.OnClickListener() {
							             @Override
							             public void onClick(View view) {
							}});
						snackbar.show();
						_telegramLoaderDialog(false);
					}
				}
			}
		});
		dialog1.setCancelable(true);
		dialog1.show();
	}
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
	
	public void _StartTransitionActivity(final Intent _intent, final View _view, final String _name) {
		//code made by LORD HOSSEIN 
		_view.setTransitionName(_name); 
		
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(ProjectViewActivity.this, _view, _name); 
		startActivity(_intent, optionsCompat.toBundle());
	}
	
	
	public void _GetTransition(final View _view, final String _name) {
		_view.setTransitionName(_name); 
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