package com.example.sgdy.emoji;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DotView dotView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.et);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        EmojiPagerAdaper adapter = new EmojiPagerAdaper();
        adapter.setListener(new EmojiGridView.onEmoItemClickListener() {
            @Override
            public void onEmoItemClick(String emoName, int id) {
                Drawable drawable = ContextCompat.getDrawable(MainActivity.this, id);
                drawable.setBounds(0, 0, 25, 25);
                emoName = "[" + emoName + "]";
                SpannableStringBuilder stringBuilder = new SpannableStringBuilder();
                ImageSpan span = new ImageSpan(drawable);
                stringBuilder.setSpan(span,0,emoName.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

                Editable originText = mEditText.getText();
                int index = mEditText.getSelectionEnd();
                if (index < originText.length()) {
                    //说明光标不在末尾
                    originText.insert(index, stringBuilder);
                } else {
                    originText.append(stringBuilder);
                }
            }

            @Override
            public void onDeleteItemClick() {
                mEditText.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
//                mEditText.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
            }
        });
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                dotView.notifyDataChanged(2, position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        dotView = (DotView) findViewById(R.id.dot_view);

    }
}
