package com.colo.bookapp;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import com.github.angads25.filepicker.*;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.*;
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
import com.github.angads25.filepicker.controller.DialogSelectionListener ;
import com.github.angads25.filepicker.model.DialogConfigs;
import com.github.angads25.filepicker.model.DialogProperties;
import com.github.angads25.filepicker.view.FilePickerDialog;

public class UploadActivity extends AppCompatActivity {
	
	public final int REQ_CD_SC_1 = 101;
	public final int REQ_CD_SC_2 = 102;
	public final int REQ_CD_SC_3 = 103;
	public final int REQ_CD_SC_4 = 104;
	public final int REQ_CD_SC_5 = 105;
	public final int REQ_CD_ICON_ = 106;
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String sc1 = "";
	private String sc2 = "";
	private String sc3 = "";
	private String up_icon = "";
	private String up_edit = "";
	private String project_key = "";
	private double number = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String size = "";
	private String project_url = "";
	private HashMap<String, Object> data_map = new HashMap<>();
	private String screenshot_1 = "";
	private String scr1name = "";
	private String screenshot_2 = "";
	private String scr2name = "";
	private String screenshot_3 = "";
	private String scr3name = "";
	private String sc4 = "";
	private String sc5 = "";
	private String screenshot4 = "";
	private String scr4name = "";
	private String screenshot5 = "";
	private String scr5name = "";
	private String ProjectType = "";
	private double TypeID = 0;
	private HashMap<String, Object> temp_map1 = new HashMap<>();
	private String temp_decrypted = "";
	private String PATH_HIDE_SKETCHLIB = "";
	private String PATH_SKETCHLIB = "";
	private String PATH_SKETCHWARE = "";
	private String icon_path = "";
	private String path = "";
	private String file_size = "";
	private double B = 0;
	private double KB = 0;
	private double MB = 0;
	private double GB = 0;
	private double TB = 0;
	private double PB = 0;
	private String returnedSize = "";
	private String icon_url = "";
	private boolean isVisible = false;
	private String swb_file = "";
	private double files_count = 0;
	private String swb_ = "";
	private boolean switch_ = false;
	
	private ArrayList<String> lst = new ArrayList<>();
	private ArrayList<String> temp_str1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> temp_listmap1 = new ArrayList<>();
	private ArrayList<String> copy_list = new ArrayList<>();
	private ArrayList<String> files = new ArrayList<>();
	
	private LinearLayout toolbar;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private LinearLayout linear3;
	private ImageView imageview2;
	private LinearLayout linear12;
	private LinearLayout linear2;
	private TextView textview1;
	private LinearLayout linear11;
	private TextInputLayout textinputlayout1;
	private TextView title_limit;
	private TextInputLayout textinputlayout2;
	private TextView dc_limit;
	private TextInputLayout textinputlayout3;
	private TextView what_limit;
	private TextView textview3;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private LinearLayout linear8;
	private LinearLayout linear22;
	private LinearLayout linear21;
	private ImageView imageview9;
	private TextView textview2;
	private EditText title;
	private EditText deception;
	private EditText what;
	private LinearLayout scr1;
	private LinearLayout scr2;
	private LinearLayout scr3;
	private LinearLayout scr4;
	private LinearLayout scr5;
	private LinearLayout linear4;
	private ImageView screenshot__1;
	private TextView textview15;
	private ImageView imageview14;
	private ImageView screenshot__2;
	private TextView textview16;
	private ImageView imageview15;
	private ImageView screenshot__3;
	private TextView textview17;
	private ImageView imageview16;
	private ImageView screenshot_4;
	private TextView textview18;
	private ImageView imageview20;
	private ImageView screenshot_5;
	private TextView textview20;
	private ImageView imageview24;
	private ImageView imageview4;
	private TextView textview10;
	private ImageView imageview5;
	private ImageView imageview17;
	private TextView textview_category;
	private ImageView imageview18;
	private ImageView imageview10;
	private TextView textview8;
	private ImageView imageview3;
	private ImageView imageview25;
	private TextView textview21;
	private ImageView imageview26;
	private LinearLayout linear15;
	private LinearLayout switch_main;
	private TextView textview14;
	private TextView textview12;
	private LinearLayout switch_bg;
	private LinearLayout switch_thumb;
	
	private Intent sc_1 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent sc_2 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent sc_3 = new Intent(Intent.ACTION_GET_CONTENT);
	private DatabaseReference data1 = _firebase.getReference("data1");
	private ChildEventListener _data1_child_listener;
	private Calendar calendar = Calendar.getInstance();
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
	
	private TimerTask t;
	private ProgressDialog prog;
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
	
	private Intent sc_4 = new Intent(Intent.ACTION_GET_CONTENT);
	private Intent sc_5 = new Intent(Intent.ACTION_GET_CONTENT);
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
	
	private StorageReference icon = _firebase_storage.getReference("icon");
	private OnCompleteListener<Uri> _icon_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _icon_download_success_listener;
	private OnSuccessListener _icon_delete_success_listener;
	private OnProgressListener _icon_upload_progress_listener;
	private OnProgressListener _icon_download_progress_listener;
	private OnFailureListener _icon_failure_listener;
	
	private StorageReference project = _firebase_storage.getReference("project");
	private OnCompleteListener<Uri> _project_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _project_download_success_listener;
	private OnSuccessListener _project_delete_success_listener;
	private OnProgressListener _project_upload_progress_listener;
	private OnProgressListener _project_download_progress_listener;
	private OnFailureListener _project_failure_listener;
	
	private TimerTask timer;
	private Intent icon_ = new Intent(Intent.ACTION_GET_CONTENT);
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
		setContentView(R.layout.upload);
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
		toolbar = findViewById(R.id.toolbar);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		linear3 = findViewById(R.id.linear3);
		imageview2 = findViewById(R.id.imageview2);
		linear12 = findViewById(R.id.linear12);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		linear11 = findViewById(R.id.linear11);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		title_limit = findViewById(R.id.title_limit);
		textinputlayout2 = findViewById(R.id.textinputlayout2);
		dc_limit = findViewById(R.id.dc_limit);
		textinputlayout3 = findViewById(R.id.textinputlayout3);
		what_limit = findViewById(R.id.what_limit);
		textview3 = findViewById(R.id.textview3);
		linear19 = findViewById(R.id.linear19);
		linear20 = findViewById(R.id.linear20);
		linear8 = findViewById(R.id.linear8);
		linear22 = findViewById(R.id.linear22);
		linear21 = findViewById(R.id.linear21);
		imageview9 = findViewById(R.id.imageview9);
		textview2 = findViewById(R.id.textview2);
		title = findViewById(R.id.title);
		deception = findViewById(R.id.deception);
		what = findViewById(R.id.what);
		scr1 = findViewById(R.id.scr1);
		scr2 = findViewById(R.id.scr2);
		scr3 = findViewById(R.id.scr3);
		scr4 = findViewById(R.id.scr4);
		scr5 = findViewById(R.id.scr5);
		linear4 = findViewById(R.id.linear4);
		screenshot__1 = findViewById(R.id.screenshot__1);
		textview15 = findViewById(R.id.textview15);
		imageview14 = findViewById(R.id.imageview14);
		screenshot__2 = findViewById(R.id.screenshot__2);
		textview16 = findViewById(R.id.textview16);
		imageview15 = findViewById(R.id.imageview15);
		screenshot__3 = findViewById(R.id.screenshot__3);
		textview17 = findViewById(R.id.textview17);
		imageview16 = findViewById(R.id.imageview16);
		screenshot_4 = findViewById(R.id.screenshot_4);
		textview18 = findViewById(R.id.textview18);
		imageview20 = findViewById(R.id.imageview20);
		screenshot_5 = findViewById(R.id.screenshot_5);
		textview20 = findViewById(R.id.textview20);
		imageview24 = findViewById(R.id.imageview24);
		imageview4 = findViewById(R.id.imageview4);
		textview10 = findViewById(R.id.textview10);
		imageview5 = findViewById(R.id.imageview5);
		imageview17 = findViewById(R.id.imageview17);
		textview_category = findViewById(R.id.textview_category);
		imageview18 = findViewById(R.id.imageview18);
		imageview10 = findViewById(R.id.imageview10);
		textview8 = findViewById(R.id.textview8);
		imageview3 = findViewById(R.id.imageview3);
		imageview25 = findViewById(R.id.imageview25);
		textview21 = findViewById(R.id.textview21);
		imageview26 = findViewById(R.id.imageview26);
		linear15 = findViewById(R.id.linear15);
		switch_main = findViewById(R.id.switch_main);
		textview14 = findViewById(R.id.textview14);
		textview12 = findViewById(R.id.textview12);
		switch_bg = findViewById(R.id.switch_bg);
		switch_thumb = findViewById(R.id.switch_thumb);
		sc_1.setType("image/*");
		sc_1.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		sc_2.setType("image/*");
		sc_2.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		sc_3.setType("image/*");
		sc_3.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		auth = FirebaseAuth.getInstance();
		sc_4.setType("image/*");
		sc_4.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		sc_5.setType("image/*");
		sc_5.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		icon_.setType("image/*");
		icon_.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_up();
			}
		});
		
		linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_oops();
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_ProjectTypeDialog();
			}
		});
		
		linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_FilePickerDialog("pick pdf file", "Select", "pdf");
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(icon_, REQ_CD_ICON_);
			}
		});
		
		deception.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (deception.getLayout().getLineForOffset(Selection.getSelectionStart(deception.getText())) < 6) {
						deception.setLines(6);
				}
				else {
						deception.setLines(deception.getLayout().getLineForOffset(Selection.getSelectionStart(deception.getText())) + 1);
						
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		scr1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(sc_1, REQ_CD_SC_1);
				if (sc1.equals("")) {
					
				}
				else {
					_firebase_storage.getReferenceFromUrl(sc1).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
				}
			}
		});
		
		scr2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(sc_2, REQ_CD_SC_2);
				if (sc2.equals("")) {
					
				}
				else {
					_firebase_storage.getReferenceFromUrl(sc2).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
				}
			}
		});
		
		scr3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(sc_3, REQ_CD_SC_3);
				if (sc3.equals("")) {
					
				}
				else {
					_firebase_storage.getReferenceFromUrl(sc3).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
				}
			}
		});
		
		scr4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(sc_4, REQ_CD_SC_4);
				if (sc4.equals("")) {
					
				}
				else {
					_firebase_storage.getReferenceFromUrl(sc4).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
				}
			}
		});
		
		scr5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(sc_5, REQ_CD_SC_5);
				if (sc5.equals("")) {
					
				}
				else {
					_firebase_storage.getReferenceFromUrl(sc5).delete().addOnSuccessListener(_screenshot1_delete_success_listener).addOnFailureListener(_screenshot1_failure_listener);
				}
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sc1.equals("")) {
					startActivityForResult(sc_1, REQ_CD_SC_1);
				}
				else {
					if (sc2.equals("")) {
						startActivityForResult(sc_2, REQ_CD_SC_2);
					}
					else {
						if (sc3.equals("")) {
							startActivityForResult(sc_3, REQ_CD_SC_3);
						}
						else {
							if (sc4.equals("")) {
								startActivityForResult(sc_4, REQ_CD_SC_4);
							}
							else {
								if (sc5.equals("")) {
									startActivityForResult(sc_5, REQ_CD_SC_5);
								}
								else {
									
								}
							}
						}
					}
				}
			}
		});
		
		imageview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sc2.equals("")) {
					sc1 = "";
					scr1.setVisibility(View.GONE);
				}
				else {
					
				}
			}
		});
		
		imageview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sc3.equals("")) {
					sc2 = "";
					scr2.setVisibility(View.GONE);
				}
				else {
					
				}
			}
		});
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sc4.equals("")) {
					sc3 = "";
					scr3.setVisibility(View.GONE);
				}
				else {
					
				}
			}
		});
		
		imageview20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sc5.equals("")) {
					sc4 = "";
					scr4.setVisibility(View.GONE);
				}
				else {
					
				}
			}
		});
		
		imageview24.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sc5 = "";
				scr5.setVisibility(View.GONE);
				linear4.setVisibility(View.VISIBLE);
			}
		});
		
		_data1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		data1.addChildEventListener(_data1_child_listener);
		
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
				sc1 = _downloadUrl;
				_telegramLoaderDialog(false);
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
				sc2 = _downloadUrl;
				_telegramLoaderDialog(false);
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
				sc3 = _downloadUrl;
				_telegramLoaderDialog(false);
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
				sc4 = _downloadUrl;
				_telegramLoaderDialog(false);
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
				sc5 = _downloadUrl;
				_telegramLoaderDialog(false);
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
		
		_icon_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_icon_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				_telegramLoaderDialog(false);
				icon_url = _downloadUrl;
			}
		};
		
		_icon_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_icon_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_icon_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
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
				project_url = _downloadUrl;
				_telegramLoaderDialog(false);
				if (!up_icon.equals("")) {
					icon.child(up_edit.concat(project_key.concat(".png"))).putFile(Uri.fromFile(new File(up_icon))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
						@Override
						public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
							return icon.child(up_edit.concat(project_key.concat(".png"))).getDownloadUrl();
						}}).addOnCompleteListener(_icon_upload_success_listener);
					_telegramLoaderDialog(true);
				}
			}
		};
		
		_project_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
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
				project_url = _downloadUrl;
				_telegramLoaderDialog(false);
			}
		};
		
		_swb_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
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
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		switch_thumb.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)7, 0xFFE0E0E0, 0xFFFFFFFF));
		switch_bg.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFF000000, 0xFFE0E0E0));
		switch_ = true;
		switch_main.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch_) {
					_TransitionManager(linear2, 200);
					switch_thumb.setTranslationX((float)(4));
					switch_bg.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFF000000, 0xFF2196F3));
					switch_thumb.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)7, 0xFF2196F3, 0xFFFFFFFF));
					switch_ = false;
				}
				else {
					_TransitionManager(linear2, 200);
					switch_thumb.setTranslationX((float)(-45));
					switch_bg.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)0, 0xFF000000, 0xFFE0E0E0));
					switch_thumb.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)50, (int)7, 0xFFE0E0E0, 0xFFFFFFFF));
					switch_ = true;
				}
			}
		});
		_removeScollBar(vscroll1);
		
		scr1.setVisibility(View.GONE);
		scr2.setVisibility(View.GONE);
		scr3.setVisibility(View.GONE);
		scr4.setVisibility(View.GONE);
		scr5.setVisibility(View.GONE);
		imageview9.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)0, 0xFF424242, 0xFF37474F));
		linear11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)2, 0xFF9E9E9E, Color.TRANSPARENT));
		linear19.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFF9E9E9E, Color.TRANSPARENT));
		linear8.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFF9E9E9E, Color.TRANSPARENT));
		linear20.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFF9E9E9E, Color.TRANSPARENT));
		linear22.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)2, 0xFF9E9E9E, Color.TRANSPARENT));
		_AdvancedEdittext(title, 50, title_limit, "");
		_AdvancedEdittext(deception, 1500, dc_limit, "");
		_AdvancedEdittext(what, 200, what_limit, "");
		PATH_SKETCHWARE = FileUtil.getExternalStorageDir().concat("/.sketchware/");
		PATH_HIDE_SKETCHLIB = FileUtil.getExternalStorageDir().concat("/.SKETCHLIB/");
		PATH_SKETCHLIB = FileUtil.getExternalStorageDir().concat("/Sketchub/");
		if (!FileUtil.isExistFile(PATH_SKETCHWARE)) {
			FileUtil.makeDir(PATH_SKETCHWARE);
		}
		if (!FileUtil.isExistFile(PATH_HIDE_SKETCHLIB)) {
			FileUtil.makeDir(PATH_HIDE_SKETCHLIB);
		}
		if (!FileUtil.isExistFile(PATH_SKETCHLIB)) {
			FileUtil.makeDir(PATH_SKETCHLIB);
		}
		imageview4.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview17.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview10.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview25.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview5.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview18.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview3.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		imageview26.setColorFilter(0xFF9E9E9E, PorterDuff.Mode.MULTIPLY);
		_font();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_SC_1:
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
				screenshot_1 = _filePath.get((int)(0));
				scr1name = Uri.parse(screenshot_1).getLastPathSegment();
				screenshot__1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(screenshot_1, 1024, 1024));
				scr1.setVisibility(View.VISIBLE);
				_TransitionManager(linear2, 200);
				screenshot1.child(scr1name).putFile(Uri.fromFile(new File(screenshot_1))).addOnFailureListener(_screenshot1_failure_listener).addOnProgressListener(_screenshot1_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return screenshot1.child(scr1name).getDownloadUrl();
					}}).addOnCompleteListener(_screenshot1_upload_success_listener);
				_telegramLoaderDialog(true);
			}
			else {
				
			}
			break;
			
			case REQ_CD_SC_2:
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
				screenshot_2 = _filePath.get((int)(0));
				scr2name = Uri.parse(screenshot_2).getLastPathSegment();
				screenshot__2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(screenshot_2, 1024, 1024));
				scr2.setVisibility(View.VISIBLE);
				_TransitionManager(linear2, 200);
				screenshot2.child(scr2name).putFile(Uri.fromFile(new File(screenshot_2))).addOnFailureListener(_screenshot2_failure_listener).addOnProgressListener(_screenshot2_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return screenshot2.child(scr2name).getDownloadUrl();
					}}).addOnCompleteListener(_screenshot2_upload_success_listener);
				_telegramLoaderDialog(true);
			}
			else {
				
			}
			break;
			
			case REQ_CD_SC_3:
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
				screenshot_3 = _filePath.get((int)(0));
				scr3name = Uri.parse(screenshot_3).getLastPathSegment();
				screenshot__3.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(screenshot_3, 1024, 1024));
				scr3.setVisibility(View.VISIBLE);
				_TransitionManager(linear2, 200);
				screenshot3.child(scr3name).putFile(Uri.fromFile(new File(screenshot_3))).addOnFailureListener(_screenshot3_failure_listener).addOnProgressListener(_screenshot3_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return screenshot3.child(scr3name).getDownloadUrl();
					}}).addOnCompleteListener(_screenshot3_upload_success_listener);
				_telegramLoaderDialog(true);
			}
			else {
				
			}
			break;
			
			case REQ_CD_SC_4:
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
				screenshot4 = _filePath.get((int)(0));
				scr4name = Uri.parse(screenshot4).getLastPathSegment();
				screenshot_4.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(screenshot4, 1024, 1024));
				scr4.setVisibility(View.VISIBLE);
				_TransitionManager(linear2, 200);
				screenshot4_.child(scr4name).putFile(Uri.fromFile(new File(screenshot4))).addOnFailureListener(_screenshot4__failure_listener).addOnProgressListener(_screenshot4__upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return screenshot4_.child(scr4name).getDownloadUrl();
					}}).addOnCompleteListener(_screenshot4__upload_success_listener);
				_telegramLoaderDialog(true);
			}
			else {
				
			}
			break;
			
			case REQ_CD_SC_5:
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
				screenshot5 = _filePath.get((int)(0));
				scr5name = Uri.parse(screenshot5).getLastPathSegment();
				screenshot_5.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(screenshot5, 1024, 1024));
				scr5.setVisibility(View.VISIBLE);
				linear4.setVisibility(View.GONE);
				_TransitionManager(linear2, 200);
				screenshot5_.child(scr5name).putFile(Uri.fromFile(new File(screenshot5))).addOnFailureListener(_screenshot5__failure_listener).addOnProgressListener(_screenshot5__upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return screenshot5_.child(scr5name).getDownloadUrl();
					}}).addOnCompleteListener(_screenshot5__upload_success_listener);
				_telegramLoaderDialog(true);
			}
			else {
				
			}
			break;
			
			case REQ_CD_ICON_:
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
				up_icon = _filePath.get((int)(0));
				imageview9.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(up_icon, 1024, 1024));
				icon.child(up_edit.concat(project_key).concat(".png")).putFile(Uri.fromFile(new File(up_icon))).addOnFailureListener(_icon_failure_listener).addOnProgressListener(_icon_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return icon.child(up_edit.concat(project_key).concat(".png")).getDownloadUrl();
					}}).addOnCompleteListener(_icon_upload_success_listener);
				_telegramLoaderDialog(true);
			}
			else {
				
			}
			break;
			default:
			break;
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
	
	
	public void _oops() {
		final AlertDialog dialog1 = new AlertDialog.Builder(UploadActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.custom4,null); 
		dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog1.setView(inflate);
		LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
		TextView t1 = (TextView) inflate.findViewById(R.id.t1);
		
		TextView t2 = (TextView) inflate.findViewById(R.id.t2);
		
		TextView t3 = (TextView) inflate.findViewById(R.id.t3);
		
		TextView t4 = (TextView) inflate.findViewById(R.id.t4);
		
		TextView t5 = (TextView) inflate.findViewById(R.id.t5);
		
		TextView t6 = (TextView) inflate.findViewById(R.id.t6);
		
		TextView t7 = (TextView) inflate.findViewById(R.id.t7);
		
		TextView t8 = (TextView) inflate.findViewById(R.id.t8);
		
		TextView t9 = (TextView) inflate.findViewById(R.id.t9);
		
		TextView t10 = (TextView) inflate.findViewById(R.id.t10);
		
		TextView t11 = (TextView) inflate.findViewById(R.id.t11);
		
		TextView t12 = (TextView) inflate.findViewById(R.id.t12);
		
		TextView t13 = (TextView) inflate.findViewById(R.id.t13);
		
		TextView t14 = (TextView) inflate.findViewById(R.id.t14);
		
		TextView t15 = (TextView) inflate.findViewById(R.id.t15);
		
		TextView t16 = (TextView) inflate.findViewById(R.id.t16);
		
		TextView t17 = (TextView) inflate.findViewById(R.id.t17);
		ImageView i1 = (ImageView) inflate.findViewById(R.id.i1);
		
		ImageView i2 = (ImageView) inflate.findViewById(R.id.i2);
		
		ImageView i3 = (ImageView) inflate.findViewById(R.id.i3);
		
		ImageView i4 = (ImageView) inflate.findViewById(R.id.i4);
		
		ImageView i5 = (ImageView) inflate.findViewById(R.id.i5);
		
		ImageView i6 = (ImageView) inflate.findViewById(R.id.i6);
		
		ImageView i7 = (ImageView) inflate.findViewById(R.id.i7);
		
		ImageView i8 = (ImageView) inflate.findViewById(R.id.i8);
		
		ImageView i9 = (ImageView) inflate.findViewById(R.id.i9);
		
		ImageView i10 = (ImageView) inflate.findViewById(R.id.i10);
		
		ImageView i11 = (ImageView) inflate.findViewById(R.id.i11);
		
		ImageView i12 = (ImageView) inflate.findViewById(R.id.i12);
		
		ImageView i13 = (ImageView) inflate.findViewById(R.id.i13);
		
		ImageView i14 = (ImageView) inflate.findViewById(R.id.i14);
		
		ImageView i15 = (ImageView) inflate.findViewById(R.id.i15);
		
		ImageView i16 = (ImageView) inflate.findViewById(R.id.i16);
		LinearLayout b1 = (LinearLayout) inflate.findViewById(R.id.b1);
		
		LinearLayout b2 = (LinearLayout) inflate.findViewById(R.id.b2);
		
		LinearLayout b3 = (LinearLayout) inflate.findViewById(R.id.b3);
		
		LinearLayout b4 = (LinearLayout) inflate.findViewById(R.id.b4);
		
		LinearLayout b5 = (LinearLayout) inflate.findViewById(R.id.b5);
		
		LinearLayout b6 = (LinearLayout) inflate.findViewById(R.id.b6);
		
		LinearLayout b7 = (LinearLayout) inflate.findViewById(R.id.b7);
		
		LinearLayout b8 = (LinearLayout) inflate.findViewById(R.id.b8);
		
		LinearLayout b9 = (LinearLayout) inflate.findViewById(R.id.b9);
		
		LinearLayout b10 = (LinearLayout) inflate.findViewById(R.id.b10);
		
		LinearLayout b11 = (LinearLayout) inflate.findViewById(R.id.b11);
		
		LinearLayout b12 = (LinearLayout) inflate.findViewById(R.id.b12);
		
		LinearLayout b13 = (LinearLayout) inflate.findViewById(R.id.b13);
		
		LinearLayout b14 = (LinearLayout) inflate.findViewById(R.id.b14);
		
		LinearLayout b15 = (LinearLayout) inflate.findViewById(R.id.b15);
		
		LinearLayout b16 = (LinearLayout) inflate.findViewById(R.id.b16);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t11.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		t17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_light.ttf"), 0);
		i1.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i2.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i3.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i4.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i5.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i6.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i7.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i8.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i9.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i10.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i11.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i12.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i13.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i14.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i15.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		i16.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
		_rippleRoundStroke(bg, "#FFFFFF", "#000000", 25, 0, "#00000000");
		_rippleRoundStroke(b1, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b2, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b3, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b4, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b5, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b6, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b7, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b8, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b9, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b10, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b11, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b12, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b13, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b14, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b15, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		_rippleRoundStroke(b16, "#FFFFFF", "#E0E0E0", 0, 0, "#00000000");
		b1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Books & Reference");
				dialog1.dismiss();
			}
		});
		b2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Business");
				dialog1.dismiss();
			}
		});
		b3.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Communication");
				dialog1.dismiss();
			}
		});
		b4.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Education");
				dialog1.dismiss();
			}
		});
		b5.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Entertainment");
				dialog1.dismiss();
			}
		});
		b6.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Example & Tutorial");
				dialog1.dismiss();
			}
		});
		b7.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Games");
				dialog1.dismiss();
			}
		});
		b8.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Multi-Device");
				dialog1.dismiss();
			}
		});
		b9.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Music & Audio");
				dialog1.dismiss();
			}
		});
		b10.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Other");
				dialog1.dismiss();
			}
		});
		b11.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Photographic");
				dialog1.dismiss();
			}
		});
		b12.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Productivity");
				dialog1.dismiss();
			}
		});
		b13.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Social");
				dialog1.dismiss();
			}
		});
		b14.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Tools");
				dialog1.dismiss();
			}
		});
		b15.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Ui & UX");
				dialog1.dismiss();
			}
		});
		b16.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				textview_category.setText("Videography");
				dialog1.dismiss();
			}
		});
		dialog1.setCancelable(false);
		dialog1.show();
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
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(UploadActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _ProjectTypeDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setTitle("Select Project Type");
		String[] items = {
			"Free Books",
			"Premium Book",
			
		};
		int checkedItem = (int)(TypeID);
		dialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
					case 0:
					ProjectType = "SK";
					break;
					case 1:
					ProjectType = "SW";
					break;
				}
			}
		});
		dialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				if (ProjectType.equals("SK")) {
					textview8.setText("Free Books ");
					TypeID = 0;
				}
				else {
					if (ProjectType.equals("SW")) {
						textview8.setText("Premium Book");
						TypeID = 1;
					}
					else {
						
					}
				}
			}
		});
		AlertDialog alert = dialog.create();
		alert.setCanceledOnTouchOutside(false);
		alert.show();
	}
	
	
	public void _autoTransitionScroll(final View _scroll) {
		android.transition.TransitionManager.beginDelayedTransition((LinearLayout)_scroll, new android.transition.AutoTransition());
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration);
		autoTransition.setInterpolator(new android.view.animation.DecelerateInterpolator()); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _Load_Projects() {
		temp_str1.clear();
		temp_listmap1.clear();
		temp_map1.clear();
		FileUtil.listDir(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/"), temp_str1);
		Collections.sort(temp_str1, String.CASE_INSENSITIVE_ORDER);
		number = 0;
		for(int _repeat18 = 0; _repeat18 < (int)(temp_str1.size()); _repeat18++) {
			if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(temp_str1.get((int)(number))).getLastPathSegment().concat("/project"))))) {
				try {
					javax.crypto.Cipher instance = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5Padding");
					byte[] bytes = "sketchwaresecure".getBytes();
					instance.init(2, new javax.crypto.spec.SecretKeySpec(bytes, "AES"), new javax.crypto.spec.IvParameterSpec(bytes));
					java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(FileUtil.getExternalStorageDir().concat("/.sketchware/mysc/list/".concat(Uri.parse(temp_str1.get((int)(number))).getLastPathSegment().concat("/project"))), "r");
					byte[] bArr = new byte[((int) randomAccessFile.length())];
					randomAccessFile.readFully(bArr);
					temp_decrypted = new String(instance.doFinal(bArr));
					temp_map1 = new HashMap<>();
					temp_map1 = new Gson().fromJson(temp_decrypted, new TypeToken<HashMap<String, Object>>(){}.getType());
					temp_listmap1.add(temp_map1);
				} catch(Exception e) {
					showMessage(e.toString());
				}
			}
			number++;
		}
		Collections.reverse(temp_listmap1);
	}
	
	
	public void _Show_Projects_Dialog() {
		final AlertDialog p_dialog = new AlertDialog.Builder(UploadActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.dialog_cus, null);
		p_dialog.setView(inflate);
		
		LinearLayout linear1 = (LinearLayout)inflate.findViewById(R.id.linear1);
		
		final LinearLayout main = (LinearLayout)inflate.findViewById(R.id.main);
		main.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
		
		TextView textview1 = (TextView)inflate.findViewById(R.id.textview1);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_bold.ttf"), 0);
		textview1.setText("Select Project");
		
		ImageView imageview1 = (ImageView)inflate.findViewById(R.id.imageview1);
		
		final ListView listView2 = new ListView(UploadActivity.this);
		listView2.setDivider(null); 
		listView2.setDividerHeight(0);
		listView2.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT));
		listView2.setAdapter(new List1Adapter(temp_listmap1));
		((BaseAdapter)listView2.getAdapter()).notifyDataSetChanged();
		linear1.addView(listView2);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				p_dialog.dismiss();
			}
		});
		
		
		listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView parent, View view, int _pos, long id) {
				p_dialog.dismiss();
				_SHARE(_pos, temp_listmap1);
			}});
		
		p_dialog.show();
	}
	private ListView listView2;
	public class List1Adapter extends
	BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public List1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.project_cus, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			
			final ImageView icon = (ImageView) _v.findViewById(R.id.icon);
			
			final TextView title = (TextView) _v.findViewById(R.id.title);
			
			final TextView pack = (TextView) _v.findViewById(R.id.pack);
			
			final TextView num = (TextView) _v.findViewById(R.id.num);
			
			if (_data.get((int)_position).containsKey("sc_id")) {
				if (_data.get((int)_position).containsKey("my_app_name")) {
					title.setText(_data.get((int)_position).get("my_app_name").toString());
				}
				
				if (_data.get((int)_position).containsKey("my_sc_pkg_name")) {
					pack.setText(_data.get((int)_position).get("my_sc_pkg_name").toString());
				}
				if (_data.get((int)_position).containsKey("sc_id")) {
					num.setText(_data.get((int)_position).get("sc_id").toString());
				}
				if (_data.get((int)_position).containsKey("custom_icon")) {
					if (_data.get((int)_position).get("custom_icon").toString().equals("true")) {
						if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_data.get((int)_position).get("sc_id").toString().concat("/icon.png"))))) {
							if (BitmapFactory.decodeFile(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_data.get((int)_position).get("sc_id").toString().concat("/icon.png")))) != null) {	icon.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_data.get((int)_position).get("sc_id").toString().concat("/icon.png"))), 1024, 1024));
							}else {
								icon.setImageResource(R.drawable.android_icon);
							}
						}else {
							icon.setImageResource(R.drawable.android_icon);
						}
					} else {
						icon.setImageResource(R.drawable.android_icon);
					}
				} else {
					icon.setImageResource(R.drawable.android_icon);
				}
				linear1.setVisibility(View.VISIBLE);
			}else {
				linear1.setVisibility(View.GONE);
			}
			return _v;
		}
	}
	
	
	public void _SHARE(final double _position, final ArrayList<HashMap<String, Object>> _listmap) {
		_telegramLoaderDialog(true);
		FileUtil.makeDir(PATH_HIDE_SKETCHLIB.concat("temp/data/"));
		FileUtil.makeDir(PATH_HIDE_SKETCHLIB.concat("temp/list/"));
		FileUtil.makeDir(PATH_HIDE_SKETCHLIB.concat("temp/fonts/"));
		FileUtil.makeDir(PATH_HIDE_SKETCHLIB.concat("temp/icons/"));
		FileUtil.makeDir(PATH_HIDE_SKETCHLIB.concat("temp/images/"));
		FileUtil.makeDir(PATH_HIDE_SKETCHLIB.concat("temp/sounds/"));
		FileUtil.makeDir(PATH_SKETCHLIB.concat("temp/"));
		_Copy(PATH_SKETCHWARE.concat("data/".concat(_listmap.get((int)_position).get("sc_id").toString())), PATH_HIDE_SKETCHLIB.concat("temp/data/"));
		_Copy(PATH_SKETCHWARE.concat("mysc/list/".concat(_listmap.get((int)_position).get("sc_id").toString())), PATH_HIDE_SKETCHLIB.concat("temp/list/"));
		_Copy(PATH_SKETCHWARE.concat("resources/fonts/".concat(_listmap.get((int)_position).get("sc_id").toString())), PATH_HIDE_SKETCHLIB.concat("temp/fonts/"));
		_Copy(PATH_SKETCHWARE.concat("resources/icons/".concat(_listmap.get((int)_position).get("sc_id").toString())), PATH_HIDE_SKETCHLIB.concat("temp/icons/"));
		_Copy(PATH_SKETCHWARE.concat("resources/images/".concat(_listmap.get((int)_position).get("sc_id").toString())), PATH_HIDE_SKETCHLIB.concat("temp/images/"));
		_Copy(PATH_SKETCHWARE.concat("resources/sounds/".concat(_listmap.get((int)_position).get("sc_id").toString())), PATH_HIDE_SKETCHLIB.concat("temp/sounds/"));
		_zip(PATH_HIDE_SKETCHLIB.concat("temp"), PATH_SKETCHLIB.concat("temp/temp.zip"));
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						FileUtil.deleteFile(PATH_HIDE_SKETCHLIB.concat("temp"));
						_telegramLoaderDialog(false);
						up_edit = (_listmap.get((int)_position).get("my_app_name").toString());;
						if (_listmap.get((int)_position).containsKey("custom_icon")) {
							if (_listmap.get((int)_position).get("custom_icon").toString().equals("true")) {
								if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_listmap.get((int)_position).get("sc_id").toString().concat("/icon.png"))))) {
									icon_path = FileUtil.getExternalStorageDir().concat("/.sketchware/resources/icons/".concat(_listmap.get((int)_position).get("sc_id").toString().concat("/icon.png")));
									if (BitmapFactory.decodeFile(icon_path) != null) {
										up_icon = icon_path;
									}
									else {
										up_icon = "";
									}
								}
								else {
									up_icon = "";
								}
							}
							else {
								up_icon = "";
							}
						}
						else {
							up_icon = "";
						}
						if (up_edit.trim().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Title empty");
						}
						else {
							title.setText(up_edit);
							path = PATH_SKETCHLIB.concat("temp/temp.zip");
							java.io.File file = new java.io.File(path);
							file_size = String.valueOf(file.length());
							_CalculateSize(Double.parseDouble(file_size));
							project.child("project/".concat(project_key.concat(".zip"))).putFile(Uri.fromFile(new File(PATH_SKETCHLIB.concat("temp/temp.zip")))).addOnFailureListener(_project_failure_listener).addOnProgressListener(_project_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
								@Override
								public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
									return project.child("project/".concat(project_key.concat(".zip"))).getDownloadUrl();
								}}).addOnCompleteListener(_project_upload_success_listener);
							_telegramLoaderDialog(true);
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(3000));
	}
	
	
	public void _Copy(final String _F, final String _T) {
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
	
	
	public void _up() {
		if (icon_url.equals("")) {
			com.google.android.material.snackbar.Snackbar.make(linear3, "icon cannot be empty", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
				@Override
				public void onClick(View _view) {
					 
				}
			}).show();
		}
		else {
			if (title.getText().toString().equals("")) {
				com.google.android.material.snackbar.Snackbar.make(linear3, "Title cannot be empty", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
					@Override
					public void onClick(View _view) {
						 
					}
				}).show();
			}
			else {
				if (deception.getText().toString().equals("")) {
					com.google.android.material.snackbar.Snackbar.make(linear3, "Deception cannot be empty", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
				}
				else {
					if (textview_category.getText().toString().equals("Select a catagory")) {
						com.google.android.material.snackbar.Snackbar.make(linear3, "Catagory is empty", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
					}
					else {
						if (textview8.getText().toString().equals("Select Project Type")) {
							com.google.android.material.snackbar.Snackbar.make(linear3, "Select Project Type", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
						}
						else {
							if (sc1.equals("")) {
								com.google.android.material.snackbar.Snackbar.make(linear3, "Screenshot 1 is empty", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
									@Override
									public void onClick(View _view) {
										 
									}
								}).show();
							}
							else {
								if (sc2.equals("")) {
									com.google.android.material.snackbar.Snackbar.make(linear3, "Screenshot 2 is empty", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
										@Override
										public void onClick(View _view) {
											 
										}
									}).show();
								}
								else {
									if (project_url.equals("")) {
										com.google.android.material.snackbar.Snackbar.make(linear3, "Select project to continue", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Ok", new View.OnClickListener(){
											@Override
											public void onClick(View _view) {
												 
											}
										}).show();
									}
									else {
										_telegramLoaderDialog(true);
										project_key = data1.push().getKey();
										data_map = new HashMap<>();
										if (!icon_url.equals("")) {
											data_map.put("icon", icon_url);
										}
										data_map.put("title", title.getText().toString());
										data_map.put("dec", deception.getText().toString());
										data_map.put("new", what.getText().toString());
										data_map.put("catagory", textview_category.getText().toString());
										data_map.put("type", textview8.getText().toString());
										data_map.put("sc1", sc1);
										data_map.put("sc2", sc2);
										data_map.put("sc3", sc3);
										data_map.put("sc4", sc4);
										data_map.put("sc5", sc5);
										data_map.put("project", project_url);
										data_map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
										data_map.put("key", project_key);
										data_map.put("likes", "0");
										data_map.put("comments", "0");
										data_map.put("size", returnedSize);
										data_map.put("editor", "false");
										data_map.put("time", new SimpleDateFormat("dd/MM/yyyy - hh:mm a").format(calendar.getTime()));
										data1.child(project_key).updateChildren(data_map);
										data_map.clear();
										t = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														_MaterialDialog("Success", "Project have been uploaded\nSuccessful", "", "EXIT");
														_telegramLoaderDialog(false);
													}
												});
											}
										};
										_timer.schedule(t, (int)(4000));
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	public void _zip(final String _source, final String _destination) {
		FileUtil.writeFile("Don't Remove it Thanks.\nModified By: Rohit Verma", "This Block Added for Manage Permission");
		try {
			java.util.zip.ZipOutputStream os = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(_destination));
					zip(os, _source, null);
					os.close();
		}
		
		catch(java.io.IOException e) {}
	}
	private void zip(java.util.zip.ZipOutputStream os, String filePath, String name) throws java.io.IOException
		{
				java.io.File file = new java.io.File(filePath);
				java.util.zip.ZipEntry entry = new java.util.zip.ZipEntry((name != null ? name + java.io.File.separator : "") + file.getName() + (file.isDirectory() ? java.io.File.separator : ""));
				os.putNextEntry(entry);
				
				if(file.isFile()) {
						java.io.InputStream is = new java.io.FileInputStream(file);
						int size = is.available();
						byte[] buff = new byte[size];
						int len = is.read(buff);
						os.write(buff, 0, len);
						return;
				}
				
				java.io.File[] fileArr = file.listFiles();
				for(java.io.File subFile : fileArr) {
						zip(os, subFile.getAbsolutePath(), entry.getName());
				}
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
	
	
	public void _MaterialDialog(final String _title, final String _message, final String _button1text, final String _button2text) {
		final AlertDialog dialog1 = new AlertDialog.Builder(UploadActivity.this).create();
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
				finish();
			}
		});
		dialog1.setCancelable(false);
		dialog1.show();
	}
	
	
	public void _FilePickerDialog(final String _title, final String _message, final String _format) {
		//Change activity of this code to your activity
		//add import
		//import com.github.angads25.filepicker.controller.DialogSelectionListener ;
		//import com.github.angads25.filepicker.model.DialogConfigs;
		//import com.github.angads25.filepicker.model.DialogProperties;
		//import com.github.angads25.filepicker.view.FilePickerDialog;
		//need filepicker_v.1.1.1 library
		files_count = 0;
		DialogProperties filePickerp = new DialogProperties();
		filePickerp.selection_mode = DialogConfigs.SINGLE_MODE;
		filePickerp.selection_type = DialogConfigs.FILE_SELECT;
		filePickerp.root = new java.io.File(FileUtil.getExternalStorageDir());
		filePickerp.error_dir = new java.io.File(FileUtil.getExternalStorageDir());
		filePickerp.offset = new java.io.File(FileUtil.getExternalStorageDir());
		filePickerp.extensions = new String[] {_format};
		final FilePickerDialog filePicker = new FilePickerDialog((UploadActivity.this),filePickerp);
		filePicker.setTitle(_title);
		filePicker.setPositiveBtnName(_message);
		filePicker.setNegativeBtnName("cancel");
		filePicker.setDialogSelectionListener(new DialogSelectionListener() {
					@Override public void onSelectedFilePaths(String[] _files) {
						files = new ArrayList<String>(Arrays.asList(_files));
										
									
				//Here add what you want to do after pick file 👇
				swb_ = Arrays.asList(_files).get((int) 0).toString();
				swb_file = Uri.parse(swb_).getLastPathSegment();
				title.setText(swb_file);
				path = swb_;
				java.io.File file = new java.io.File(path);
				file_size = String.valueOf(file.length());
				_CalculateSize(Double.parseDouble(file_size));
				swb.child(swb_file).putFile(Uri.fromFile(new File(swb_))).addOnFailureListener(_swb_failure_listener).addOnProgressListener(_swb_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
					@Override
					public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
						return swb.child(swb_file).getDownloadUrl();
					}}).addOnCompleteListener(_swb_upload_success_listener);
				_telegramLoaderDialog(true);
			} 
		});
		filePicker.show();
	}
	
	
	public void _removeScollBar(final View _view) {
		_view.setVerticalScrollBarEnabled(false); _view.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _font() {
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		title_limit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		dc_limit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		what_limit.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		deception.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		what.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview16.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview18.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview20.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview_category.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview21.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
		textview14.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_medium.ttf"), 0);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/google_sans_regular.ttf"), 0);
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