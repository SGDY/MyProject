package com.example.sgdy.emoji;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * Created by sgdy on 16/8/22.
 * 展示每一页表情
 */
public class EmojiGridView extends GridView implements AdapterView.OnItemClickListener {

    private int currentPage;
    private int firstEmoId;//当前页第一个表情的id
    private onEmoItemClickListener mListener;

    public void setListener(onEmoItemClickListener mListener) {
        this.mListener = mListener;
    }

    public EmojiGridView(Context context) {
        this(context, null);
    }

    public EmojiGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmojiGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setNumColumns(8);//设置8列
        int widthPixels = (int) context.getResources().getDisplayMetrics().density;
        //每个表情的大小 25px适配不同屏幕
        int emojiSize = 25 * widthPixels;
        //设置列间距
        setVerticalSpacing(5 * widthPixels);
        setAdapter(new EmojiAdapter());

    }

    public void initData(int currentPage) {
        this.currentPage = currentPage;
        //每个表情的资源id是上个资源id加1
        firstEmoId = currentPage * 27 + R.mipmap.ic_launcher;
    }

    /**
     * GridView适配器
     */
    class EmojiAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 28;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //初始化LinearLayout 和 ImageView 返回LinearLayout 宽高为emojiSize
            int imageId = firstEmoId + position;
            if (position < 27) {

            } else {
                //添加删除键
            }
            return null;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //点击表情
        //当前表情的资源id
        int imageId = firstEmoId + position;
        //获取表情资源的名字
        int index = currentPage * 20 + position;
        String name = "xxx_";
        if (index < 10) {
            name += "0" + index;
        } else {
            name += index;
        }
        //传递表情的id和name
        if (mListener != null) {
            if (position < 27) {
                mListener.onEmoItemClick(name, imageId);
            } else {
                mListener.onDeleteItemClick();
            }
        }
    }

    public interface onEmoItemClickListener {
        void onEmoItemClick(String emoName, int id);

        void onDeleteItemClick();
    }
}
