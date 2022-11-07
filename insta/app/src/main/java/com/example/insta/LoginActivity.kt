package com.example.insta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var auth: FirebaseAuth? = null;
    var googleSiginInClient : GoogleSignInClient? = null;
    var GOOGLE_LOGIN_CODE = 9001;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance();

        email_login_button.setOnClickListener {
            sigininAndSignup();
        }
        google_sigin_in_button.setOnClickListener {
            googleLogin();
        }
        // Google SiginInOption
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build();

        googleSiginInClient = GoogleSignIn.getClient(this, gso);
    }

    fun googleLogin() {
        var siginInIntent = googleSiginInClient?.signInIntent;
        startActivityForResult(siginInIntent, GOOGLE_LOGIN_CODE);
    }

    override fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent?) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GOOGLE_LOGIN_CODE) {
            var result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!);
            if(result?.isSuccess == true) {
                var account = result?.signInAccount;
                // 두번 쨰 단계 Firebase 에 넘겨 줌 SNS 로그인을 위하여
                firebaseAuthWithGoogle(account);
            }
        }
    }

    fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        var credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        auth?.signInWithCredential(credential);
    }

    // FireBase 연결 Login System 구현을 위하여 Firebase 연결 함
    // 회원가입
    fun sigininAndSignup() {
        // Login 코드
        auth?.createUserWithEmailAndPassword(
            email_edittext.text.toString(),
            password_edittext.text.toString()
        )?.addOnCompleteListener {task ->
            if (task.isSuccessful) {
                // Create ID 성공적
                // Login 성공 시 다음 페이지로 이동
                task.result.user?.let { moveMainPage(it) };
            } else if (task.exception?.message.isNullOrEmpty()) {
                // Login Error 발생 시 ERR MSG 표출
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show();
            } else {
                // Login 하는 화면으로 이동 아무것도 아닐 시
                sigininEmail();
            }
        }
    }
    // emailSigin In
    fun sigininEmail() {
        auth?.signInWithEmailAndPassword(
            email_edittext.text.toString(),
            password_edittext.text.toString()
        )?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Create ID 성공적
                task.result.user?.let { moveMainPage(it) };
            } else if (task.exception?.message.isNullOrEmpty()) {
                // Login Error 발생 시 ERR MSG 표출
            } else {
                // Err Msg 출력
                Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show();
            }
        }
    }

    // 다음 페이지로 이동 Function
    fun moveMainPage(user : FirebaseUser) {
        if(user != null) {
            startActivity(Intent(this, MainActivity::class.java));
        }
    }

    // FireBase Email Login 연결 방법
    // 1. https://console.firebase.google.com/project/insta-ececc/authentication/providers?hl=ko
    // 2. Authentication 페이지 로 이동 하여 siginInMethod 로 이동하여 Email / Password 사용 설정 후 저장 클릭
    
    // Email 로그인은 2가지 단계임 
    // 앱에서 Login 요청 시 Firebase 로 요청
    // Firebase 는 서버 플랫폼임
    
    
    // SNS 로그인은 3단계임 앱에서 Firebase 로 보낸 후 SNS 로 전송을 함
    
    
}
