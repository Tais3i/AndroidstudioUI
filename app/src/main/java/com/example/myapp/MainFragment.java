package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFragment extends Fragment {

    @Override
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントで表示する画面をlayoutファイルからインフレートする
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        // 所属している親アクティビティを取得
        MainActivity activity = (MainActivity) getActivity();
        // アクションバーにタイトルをセット
        activity.setTitle("メインフラグメント");
        // 戻るボタンは非表示にする（MainFragmentでは戻るボタン不要）
        // ここをfalseにしておかないとサブフラグメントから戻ってきた際に戻るボタンが表示されたままになってしまう
        activity.setupBackButton(false);

        // ボタン要素を取得
        Button bt1 = view.findViewById(R.id.bt1);
        Button bt2 = view.findViewById(R.id.bt2);
        Button bt3 = view.findViewById(R.id.bt3);
        Button bt4 = view.findViewById(R.id.bt4);


        // ①ボタンをクリックした時の処理
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SubFragment1に遷移させる
                replaceFragment(new SubFragment1());
            }
        });

        // ②ボタンをクリックした時の処理
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SubFragment2に遷移させる
                replaceFragment(new SubFragment2());
            }
        });

        // ③ボタンをクリックした時の処理
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SubFragment3に遷移させる
                replaceFragment(new SubFragment3());
            }
        });

        // ④ボタンをクリックした時の処理
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SubFragment2に遷移させる
                replaceFragment(new SubFragment4());
            }
        });

        return view;
    }

    // 表示させるFragmentを切り替えるメソッドを定義（表示したいFragmentを引数として渡す）
    private void replaceFragment(Fragment fragment) {
        // フラグメントマネージャーの取得
        FragmentManager manager = getFragmentManager(); // アクティビティではgetSupportFragmentManager()?
        // フラグメントトランザクションの開始
        FragmentTransaction transaction = manager.beginTransaction();
        // レイアウトをfragmentに置き換え（追加）
        transaction.replace(R.id.activityMain, fragment);
        // 置き換えのトランザクションをバックスタックに保存する
        transaction.addToBackStack(null);
        // フラグメントトランザクションをコミット
        transaction.commit();
    }
}