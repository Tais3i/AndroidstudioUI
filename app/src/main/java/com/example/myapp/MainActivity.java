package com.example.myapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // メソッドを呼び出し、デフォルトでMainFragmentを表示
        addFragment(new MainFragment());
    }

    // Fragmentを表示させるメソッドを定義（表示したいFragmentを引数として渡す）
    private void addFragment(Fragment fragment) {
        // フラグメントマネージャーの取得
        FragmentManager manager = getSupportFragmentManager();
        // フラグメントトランザクションの開始
        FragmentTransaction transaction = manager.beginTransaction();
        // MainFragmentを追加
        transaction.add(R.id.activityMain, fragment);
        // フラグメントトランザクションのコミット。コミットすることでFragmentの状態が反映される
        transaction.commit();
    }

    // 戻るボタン「←」をアクションバー（上部バー）にセットするメソッドを定義
    public void setupBackButton(boolean enableBackButton) {
        // アクションバーを取得
        ActionBar actionBar = getSupportActionBar();
        // アクションバーに戻るボタン「←」をセット（引数が true: 表示、false: 非表示）
        actionBar.setDisplayHomeAsUpEnabled(enableBackButton);
    }
}