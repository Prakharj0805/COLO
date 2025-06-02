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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
import com.google.gson.Gson;
import com.jsibbold.zoomage.*;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import uk.co.senab.photoview.*;

public class AccountActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String uid = "";
	private String str = "";
	private double num = 0;
	
	private ArrayList<HashMap<String, Object>> gridmap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private ImageView imageview1;
	private LinearLayout linear2;
	private ImageView imageview2;
	private ImageView imageview3;
	private LinearLayout linear4;
	private TextView textview11;
	private RecyclerView recyclerview1;
	private LinearLayout linear12;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private CircleImageView circleimageview1;
	private LinearLayout linear11;
	private TextView name;
	private TextView bio;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview3;
	private TextView total_projects;
	private TextView textview5;
	private TextView total_likes;
	private TextView textview7;
	private TextView total_downloads;
	private TextView textview10;
	
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
	
	private Intent i = new Intent();
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private SharedPreferences data;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.account);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
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
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		linear4 = findViewById(R.id.linear4);
		textview11 = findViewById(R.id.textview11);
		recyclerview1 = findViewById(R.id.recyclerview1);
		linear12 = findViewById(R.id.linear12);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		circleimageview1 = findViewById(R.id.circleimageview1);
		linear11 = findViewById(R.id.linear11);
		name = findViewById(R.id.name);
		bio = findViewById(R.id.bio);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		textview3 = findViewById(R.id.textview3);
		total_projects = findViewById(R.id.total_projects);
		textview5 = findViewById(R.id.textview5);
		total_likes = findViewById(R.id.total_likes);
		textview7 = findViewById(R.id.textview7);
		total_downloads = findViewById(R.id.total_downloads);
		textview10 = findViewById(R.id.textview10);
		auth = FirebaseAuth.getInstance();
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_MaterialDialog("Conform action", "Do you want to sign out?", "CANCEL", "SIGN OUT");
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(AccountActivity.this, EditActivity.class)); Animatoo.animateFade(AccountActivity.this);
			}
		});
		
		_users_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(uid)) {
					if (_childValue.containsKey("name")) {
						name.setText(_childValue.get("name").toString());
					}
					if (_childValue.containsKey("bio")) {
						if (_childValue.get("bio").toString().equals("")) {
							bio.setText("No bio available");
						}
						else {
							bio.setText(_childValue.get("bio").toString());
						}
					}
					if (_childValue.get("pic").toString().equals("")) {
						circleimageview1.setImageResource(R.drawable.user);
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(circleimageview1);
					}
					if (_childValue.containsKey("download")) {
						total_downloads.setText(_childValue.get("download").toString());
					}
					if (_childValue.containsKey("likes")) {
						total_likes.setText(_childValue.get("likes").toString());
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
						name.setText(_childValue.get("name").toString());
					}
					if (_childValue.containsKey("bio")) {
						if (_childValue.get("bio").toString().equals("")) {
							bio.setText(_childValue.get("bio").toString());
						}
					}
					if (_childValue.get("pic").toString().equals("")) {
						circleimageview1.setImageResource(R.drawable.user);
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("pic").toString())).into(circleimageview1);
					}
					if (_childValue.containsKey("download")) {
						total_downloads.setText(_childValue.get("download").toString());
					}
					if (_childValue.containsKey("likes")) {
						total_likes.setText(_childValue.get("likes").toString());
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
				if (getIntent().getStringExtra("mode").equals("user")) {
					if (_childValue.get("uid").toString().equals(getIntent().getStringExtra("uid"))) {
						gridmap.add((int)0, _childValue);
					}
					recyclerview1.setAdapter(new Recyclerview1Adapter(gridmap));
					total_projects.setText(String.valueOf((long)(gridmap.size())));
					data.edit().putString("user", new Gson().toJson(gridmap)).commit();
					if (total_projects.getText().toString().equals("0")) {
						linear12.setVisibility(View.VISIBLE);
						textview11.setVisibility(View.GONE);
					}
					else {
						linear12.setVisibility(View.GONE);
						textview11.setVisibility(View.VISIBLE);
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (getIntent().getStringExtra("mode").equals("user")) {
					if (_childValue.get("uid").toString().equals(getIntent().getStringExtra("uid"))) {
						gridmap.add((int)0, _childValue);
					}
					recyclerview1.setAdapter(new Recyclerview1Adapter(gridmap));
					total_projects.setText(String.valueOf((long)(gridmap.size())));
					data.edit().putString("user", new Gson().toJson(gridmap)).commit();
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
				if (getIntent().getStringExtra("mode").equals("user")) {
					if (_childValue.get("uid").toString().equals(getIntent().getStringExtra("uid"))) {
						gridmap.add((int)0, _childValue);
					}
					recyclerview1.setAdapter(new Recyclerview1Adapter(gridmap));
					total_projects.setText(String.valueOf((long)(gridmap.size())));
					data.edit().putString("user", new Gson().toJson(gridmap)).commit();
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		data1.addChildEventListener(_data1_child_listener);
		
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
		uid = getIntent().getStringExtra("uid");
		if (getIntent().getStringExtra("uid").equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
			
		}
		else {
			imageview2.setVisibility(View.GONE);
			imageview3.setVisibility(View.GONE);
		}
		_CardView(linear1, 5, 0, "#FFFFFF", true);
		_NavStatusBarColor("#FFFFFF", "#FFFFFF");
		try{ 
			getSupportActionBar().hide(); 
		} catch (Exception e){}
		if (total_projects.getText().toString().equals("0")) {
			linear12.setVisibility(View.VISIBLE);
			textview11.setVisibility(View.GONE);
		}
		else {
			linear12.setVisibility(View.GONE);
			textview11.setVisibility(View.VISIBLE);
		}
		recyclerview1.setLayoutManager(new LinearLayoutManager(this));
		recyclerview1.setHasFixedSize(true);
		recyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
		_rippleRoundStroke(imageview2, "#FFFFFF", "#90CAF9", 50, 0, "#FFFFFF");
		_rippleRoundStroke(imageview3, "#FFFFFF", "#90CAF9", 50, 0, "#FFFFFF");
		_GetTransition(circleimageview1, "p");
		textview11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		name.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		bio.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		total_projects.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		total_likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		total_downloads.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
	}
	
	public void _CardView(final View _view, final double _shadow, final double _radius, final String _color, final boolean _touch) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_radius);
		_view.setBackground(gd);
		if (Build.VERSION.SDK_INT >= 21){
			_view.setElevation((int)_shadow);}
		if (_touch) {
			
		}
		else {
			_view.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()){
						case MotionEvent.ACTION_DOWN:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues(0.9f);
							scaleX.setDuration(100);
							scaleX.start();
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues(0.9f);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
						case MotionEvent.ACTION_UP:{
							ObjectAnimator scaleX = new ObjectAnimator();
							scaleX.setTarget(_view);
							scaleX.setPropertyName("scaleX");
							scaleX.setFloatValues((float)1);
							scaleX.setDuration(100);
							scaleX.start();
							ObjectAnimator scaleY = new ObjectAnimator();
							scaleY.setTarget(_view);
							scaleY.setPropertyName("scaleY");
							scaleY.setFloatValues((float)1);
							scaleY.setDuration(100);
							scaleY.start();
							break;
						}
					}
					return false;
				}
			});
		}
	}
	
	
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _DARK_ICONS() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
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
	
	
	public void _MarqueTextView(final TextView _view, final String _text) {
		_view.setText(_text);
		_view.setSingleLine(true);
		_view.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		_view.setSelected(true);
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
	
	
	public void _TransictionActivity() {
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	
	
	public void _MaterialDialog(final String _title, final String _message, final String _button1text, final String _button2text) {
		final AlertDialog dialog1 = new AlertDialog.Builder(AccountActivity.this).create();
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
		b2.setTextColor(0xFFF44336);
		_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				dialog1.dismiss();
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
				dialog1.dismiss();
				FirebaseAuth.getInstance().signOut();
				startActivity(new Intent(AccountActivity.this, MainActivity.class)); Animatoo.animateFade(AccountActivity.this);
				finish();
			}
		});
		dialog1.setCancelable(true);
		dialog1.show();
	}
	
	
	public void _GetTransition(final View _view, final String _name) {
		_view.setTransitionName(_name); 
	}
	
	
	public void _StartTransitionActivity(final Intent _intent, final View _view, final String _name) {
		//code made by LORD HOSSEIN 
		_view.setTransitionName(_name); 
		
		
		android.app.ActivityOptions optionsCompat = android.app.ActivityOptions.makeSceneTransitionAnimation(AccountActivity.this, _view, _name); 
		startActivity(_intent, optionsCompat.toBundle());
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			likes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
			comments.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/opensans_regular.ttf"), 0);
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
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), ProjectViewActivity.class);
					i.putExtra("key", _data.get((int)_position).get("key").toString());
					i.putExtra("uid", _data.get((int)_position).get("uid").toString());
					_StartTransitionActivity(i, cardview1, "project");
					startActivity(i);
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