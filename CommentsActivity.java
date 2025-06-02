package com.colo.bookapp;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bachors.wordtospan.*;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.github.angads25.filepicker.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import java.io.*;
import java.text.*;
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

public class CommentsActivity extends AppCompatActivity {
	
	public final int REQ_CD_FP = 101;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String post_key = "";
	private String key = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> user_names = new HashMap<>();
	private double number = 0;
	private String uid = "";
	private String icon = "";
	private String comment_uid = "";
	private HashMap<String, Object> notify_map = new HashMap<>();
	private String report = "";
	private String image = "";
	private double tm_difference = 0;
	private double duration = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear2;
	private ImageView imageview3;
	private TextView textview1;
	private ListView listview1;
	private EditText edittext1;
	private ImageView imageview1;
	private ImageView imageview2;
	
	private Calendar c = Calendar.getInstance();
	private DatabaseReference comment = _firebase.getReference("comments");
	private ChildEventListener _comment_child_listener;
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
	
	private DatabaseReference users = _firebase.getReference("users");
	private ChildEventListener _users_child_listener;
	private AlertDialog.Builder dialog;
	private SharedPreferences u;
	private Intent intent = new Intent();
	private Intent fp = new Intent(Intent.ACTION_GET_CONTENT);
	private TimerTask timer;
	private Calendar time2 = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.comments);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear2 = findViewById(R.id.linear2);
		imageview3 = findViewById(R.id.imageview3);
		textview1 = findViewById(R.id.textview1);
		listview1 = findViewById(R.id.listview1);
		edittext1 = findViewById(R.id.edittext1);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		auth = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		u = getSharedPreferences("n", Activity.MODE_PRIVATE);
		fp.setType("*/*");
		fp.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				final AlertDialog dialog1 = new AlertDialog.Builder(CommentsActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dialog,null); 
				dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog1.setView(inflate);
				TextView t1 = (TextView) inflate.findViewById(R.id.t1);
				
				TextView t2 = (TextView) inflate.findViewById(R.id.t2);
				
				TextView t3 = (TextView) inflate.findViewById(R.id.t3);
				
				TextView t4 = (TextView) inflate.findViewById(R.id.t4);
				
				TextView tp = (TextView) inflate.findViewById(R.id.tp);
				
				LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
				
				LinearLayout bg2 = (LinearLayout) inflate.findViewById(R.id.bg2);
				
				LinearLayout l1 = (LinearLayout) inflate.findViewById(R.id.l1);
				
				LinearLayout l2 = (LinearLayout) inflate.findViewById(R.id.l2);
				
				LinearLayout l3 = (LinearLayout) inflate.findViewById(R.id.l3);
				
				LinearLayout l4 = (LinearLayout) inflate.findViewById(R.id.l4);
				
				LinearLayout lp = (LinearLayout) inflate.findViewById(R.id.lp);
				t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_medium.ttf"), 1);
				t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
				t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
				t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
				tp.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
				_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
				_rippleRoundStroke(l1, "#FFFFFF", "#BDBDBD", 0, 0, "#FFFFFF");
				_rippleRoundStroke(l2, "#FFFFFF", "#BDBDBD", 0, 0, "#FFFFFF");
				_rippleRoundStroke(l3, "#FFFFFF", "#BDBDBD", 0, 0, "#FFFFFF");
				_rippleRoundStroke(l4, "#FFFFFF", "#BDBDBD", 0, 0, "#FFFFFF");
				_rippleRoundStroke(lp, "#FFFFFF", "#BDBDBD", 0, 0, "#FFFFFF");
				l1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						dialog1.dismiss();
					}
				});
				l2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						dialog1.dismiss();
						if ("dGB4o2perCOwKGn9c16lJC5ycSV2".equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
							final AlertDialog dialog1 = new AlertDialog.Builder(CommentsActivity.this).create();
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
							t1.setText("Confirm action");
							t2.setText(listmap.get((int)_position).get("message").toString());
							b1.setText("CANCEL");
							b2.setText("DELETE");
							_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
							b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									dialog1.dismiss();
								}
							});
							b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
									dialog1.dismiss();
									comment.child(listmap.get((int)_position).get("key").toString()).removeValue();
								}
							});
							dialog1.setCancelable(true);
							dialog1.show();
						}
						else {
							if (listmap.get((int)_position).get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								final AlertDialog dialog1 = new AlertDialog.Builder(CommentsActivity.this).create();
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
								t1.setText("Confirm action");
								t2.setText(listmap.get((int)_position).get("message").toString());
								b1.setText("CANCEL");
								b2.setText("DELETE");
								_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
								b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										dialog1.dismiss();
									}
								});
								b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										dialog1.dismiss();
										comment.child(listmap.get((int)_position).get("key").toString()).removeValue();
									}
								});
								dialog1.setCancelable(true);
								dialog1.show();
							}
							else {
								if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(uid)) {
									final AlertDialog dialog1 = new AlertDialog.Builder(CommentsActivity.this).create();
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
									t1.setText("Confirm action");
									t2.setText(listmap.get((int)_position).get("message").toString());
									b1.setText("CANCEL");
									b2.setText("DELETE");
									_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
									b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
											dialog1.dismiss();
										}
									});
									b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
											dialog1.dismiss();
											comment.child(listmap.get((int)_position).get("key").toString()).removeValue();
										}
									});
									dialog1.setCancelable(true);
									dialog1.show();
								}
								else {
									com.google.android.material.snackbar.Snackbar.make(linear1, "You cannot delete this massage", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
										@Override
										public void onClick(View _view) {
											 
										}
									}).show();
								}
							}
						}
					}
				});
				l3.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						dialog1.dismiss();
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", listmap.get((int)_position).get("message").toString()));
						com.google.android.material.snackbar.Snackbar.make(linear1, "Massage copyid", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
					}
				});
				l4.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						dialog1.dismiss();
						com.google.android.material.snackbar.Snackbar.make(linear1, "Report is not available", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
					}
				});
				lp.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						dialog1.dismiss();
						intent.setClass(getApplicationContext(), AccountActivity.class);
						intent.putExtra("mode", "user");
						intent.putExtra("uid", listmap.get((int)_position).get("uid").toString());
						startActivity(intent);
						_TransictionActivity();
					}
				});
				dialog1.setCancelable(true);
				dialog1.show();
				return true;
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext1.getText().toString().equals("")) {
					imageview2.setVisibility(View.VISIBLE);
				}
				else {
					imageview2.setVisibility(View.GONE);
				}
				edittext1.setLinkTextColor(0xFF2196F3);
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
				if (!edittext1.getText().toString().trim().equals("")) {
					c = Calendar.getInstance();
					key = comment.push().getKey();
					map = new HashMap<>();
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map.put("post_key", post_key);
					map.put("key", key);
					map.put("time", String.valueOf((long)(c.getTimeInMillis())));
					map.put("message", edittext1.getText().toString());
					comment.child(key).updateChildren(map);
					map.clear();
					edittext1.setText("");
					users.addChildEventListener(_users_child_listener);
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_comment_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (post_key.equals(_childValue.get("post_key").toString())) {
					listmap.add(_childValue);
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					users.addChildEventListener(_users_child_listener);
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (post_key.equals(_childValue.get("post_key").toString())) {
					number = 0;
					for(int _repeat17 = 0; _repeat17 < (int)(listmap.size()); _repeat17++) {
						if (listmap.get((int)number).get("key").toString().equals(_childKey)) {
							listmap.remove((int)(number));
							listmap.add((int)number, _childValue);
						}
						number++;
					}
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					users.addChildEventListener(_users_child_listener);
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
				if (post_key.equals(_childValue.get("post_key").toString())) {
					number = 0;
					for(int _repeat16 = 0; _repeat16 < (int)(listmap.size()); _repeat16++) {
						if (listmap.get((int)number).get("key").toString().equals(_childKey)) {
							listmap.remove((int)(number));
						}
						number++;
					}
					listview1.setAdapter(new Listview1Adapter(listmap));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					users.addChildEventListener(_users_child_listener);
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		comment.addChildEventListener(_comment_child_listener);
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("name") && _childValue.containsKey("uid")) {
					user_names.put(_childValue.get("uid").toString(), _childValue.get("name").toString());
				}
				if (_childValue.containsKey("pic") && _childValue.containsKey("uid")) {
					map.put(_childValue.get("uid").toString(), _childValue.get("pic").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("name") && _childValue.containsKey("uid")) {
					user_names.put(_childValue.get("uid").toString(), _childValue.get("name").toString());
				}
				if (_childValue.containsKey("pic") && _childValue.containsKey("uid")) {
					map.put(_childValue.get("uid").toString(), _childValue.get("pic").toString());
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
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		textview1.setText(getIntent().getStringExtra("title"));
		post_key = getIntent().getStringExtra("key");
		uid = getIntent().getStringExtra("uid");
		icon = getIntent().getStringExtra("icon");
		_Elevation(linear2, 8);
		_Elevation(linear3, 8);
		listview1.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		listview1.setStackFromBottom(true);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FP:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				
				edittext1.setText("");
			}
			else {
				
			}
			break;
			default:
			break;
		}
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
	
	
	public void _statusbar_color(final String _color) {
		
		Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor(_color));
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
	
	
	public void _DARK_ICONS() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
	}
	
	
	public void _Send(final Intent _IntentName, final String _to, final String _subject, final String _text) {
		_IntentName.setAction(Intent.ACTION_VIEW);
		_IntentName.setData(Uri.parse("mailto:".concat(_to)));
		_IntentName.putExtra("android.intent.extra.SUBJECT", _subject);
		_IntentName.putExtra("android.intent.extra.TEXT", _text);
		startActivity(_IntentName);
	}
	
	
	public void _Round(final View _viewRound, final double _viewRoundSetRadius) {
		// Gradient Drawable
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		// Color
		android.graphics.drawable.ColorDrawable cd = new android.graphics.drawable.ColorDrawable();
		
		cd = (android.graphics.drawable.ColorDrawable)_viewRound.getBackground();
		
		int colorId = cd.getColor();
		gd.setColor(colorId);
		gd.setCornerRadius((int)_viewRoundSetRadius);
		_viewRound.setBackground(gd);
	}
	
	
	public void _sx2(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#212121")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _AdvancedEdittext(final TextView _edittext, final double _limit, final TextView _indicator, final String _color) {
		try {
			_indicator.setText(String.valueOf(_edittext.getText().toString().length())+"/"+String.valueOf((int)_limit));
			((EditText)_edittext).setFilters(new InputFilter[]{new InputFilter.LengthFilter((int)_limit)});
			_edittext.addTextChangedListener(new TextWatcher() {
				@Override
				public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) { final String _charSeq = _param1.toString();
					_indicator.setText(String.valueOf(_charSeq.length())+"/"+String.valueOf((int)_limit));
				}
				@Override
				public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				}
				@Override 
				public void afterTextChanged(Editable _param1) {
				}});
		} catch (Exception e) {
			/* Made by xenondry */
		}
		// XTrack
		try {
			((EditText)_edittext).getBackground().mutate().setColorFilter(Color.parseColor("#"+_color.replace("#","")), PorterDuff.Mode.SRC_ATOP);
		} catch (Exception e) {}
		//XTrack
	}
	
	
	public void _TransictionActivity() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	
	
	public void _G_speaker() {
	}
	public static final int REQ_CODE_SPEECH_INPUT = 1;
	{
	}
	
	
	public void _setTime(final double _currentTime, final TextView _txt) {
		tm_difference = c.getTimeInMillis() - _currentTime;
		if (tm_difference < 60000) {
			if ((tm_difference / 1000) < 2) {
				_txt.setText("1 second ago");
			}
			else {
				_txt.setText(String.valueOf((long)(tm_difference / 1000)).concat(" seconds ago"));
			}
		}
		else {
			if (tm_difference < (60 * 60000)) {
				if ((tm_difference / 60000) < 2) {
					_txt.setText("1 minute ago");
				}
				else {
					_txt.setText(String.valueOf((long)(tm_difference / 60000)).concat(" minute ago"));
				}
			}
			else {
				if (tm_difference < (24 * (60 * 60000))) {
					if ((tm_difference / (60 * 60000)) < 2) {
						_txt.setText(String.valueOf((long)(tm_difference / (60 * 60000))).concat(" hours ago"));
					}
					else {
						_txt.setText(String.valueOf((long)(tm_difference / (60 * 60000))).concat(" hours ago"));
					}
				}
				else {
					if (tm_difference < (7 * (24 * (60 * 60000)))) {
						if ((tm_difference / (24 * (60 * 60000))) < 2) {
							_txt.setText(String.valueOf((long)(tm_difference / (24 * (60 * 60000)))).concat(" days ago"));
						}
						else {
							_txt.setText(String.valueOf((long)(tm_difference / (24 * (60 * 60000)))).concat(" days ago"));
						}
					}
					else {
						time2.setTimeInMillis((long)(_currentTime));
						_txt.setText(new SimpleDateFormat("dd MMM YYYY").format(time2.getTime()));
					}
				}
			}
		}
	}
	
	
	public void _spannableTextview(final TextView _tv, final String _urlColor, final String _usernameColor, final String _hashtagColor, final String _phoneNumberColor, final String _mailColor, final boolean _underline, final String _content) {
		WordToSpan link = new WordToSpan();
		link.setColorTAG(Color.parseColor(_hashtagColor))
			.setColorURL(Color.parseColor(_urlColor))
			.setColorPHONE(Color.parseColor(_phoneNumberColor))
			.setColorMAIL(Color.parseColor(_mailColor))
			.setColorMENTION(Color.parseColor(_usernameColor))
			.setUnderlineURL(_underline)
			.setLink(_content)
		  .into(_tv)
		  .setClickListener(new WordToSpan.ClickListener() {
			 @Override
					public void onClick(String type, String text) {
					// type: "tag", "mail", "url", "phone", "mention" or "custom"
							//Toast.makeText(getApplication(), "Type: " + type + "\nText: " + text, Toast.LENGTH_LONG).show();
				if (type.equals("tag")) {
					SketchwareUtil.showMessage(getApplicationContext(), text);
				}
				else {
					if (type.equals("mail")) {
						SketchwareUtil.showMessage(getApplicationContext(), text);
					}
					else {
						if (type.equals("url")) {
							SketchwareUtil.showMessage(getApplicationContext(), text);
						}
						else {
							if (type.equals("phone")) {
								SketchwareUtil.showMessage(getApplicationContext(), text);
							}
							else {
								if (type.equals("mention")) {
									SketchwareUtil.showMessage(getApplicationContext(), text);
								}
								else {
									if (type.equals("custom")) {
										SketchwareUtil.showMessage(getApplicationContext(), text);
									}
									else {
										
									}
								}
							}
						}
					}
				}
				}
			});
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
				_view = _inflater.inflate(R.layout.comment_cus, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final de.hdodenhof.circleimageview.CircleImageView circleimageview1 = _view.findViewById(R.id.circleimageview1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView message = _view.findViewById(R.id.message);
			final TextView name = _view.findViewById(R.id.name);
			final TextView time = _view.findViewById(R.id.time);
			
			_Elevation(linear2, 7);
			_gd(linear2, 4, "#FFFFFF");
			name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_semibold.ttf"), 1);
			message.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			time.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			if (_data.get((int)_position).containsKey("message")) {
				_spannableTextview(message, "#316ffe", "#316ffe", "#316ffe", "#316ffe", "#316ffe", false, _data.get((int)_position).get("message").toString());
			}
			if (_data.get((int)_position).containsKey("time")) {
				_setTime(Double.parseDouble(_data.get((int)_position).get("time").toString()), time);
			}
			if (_data.get((int)_position).containsKey("uid")) {
				if (user_names.containsKey(_data.get((int)_position).get("uid").toString())) {
					name.setText(user_names.get(_data.get((int)_position).get("uid").toString()).toString());
				}
			}
			if (_data.get((int)_position).containsKey("uid")) {
				if (map.containsKey(_data.get((int)_position).get("uid").toString())) {
					Glide.with(getApplicationContext()).load(Uri.parse(map.get(_data.get((int)_position).get("uid").toString()).toString())).into(circleimageview1);
				}
			}
			circleimageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					intent.setClass(getApplicationContext(), AccountActivity.class);
					intent.putExtra("mode", "user");
					intent.putExtra("uid", listmap.get((int)_position).get("uid").toString());
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intent);
					_TransictionActivity();
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