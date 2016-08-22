package com.example.sgdy.emoji;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.example.sgdy.emoji.EmojiGridView.onEmoItemClickListener;

/**
 * Created by sgdy on 16/8/22.
 * 表情viewpager的adapter
 */
public class EmojiPagerAdaper extends PagerAdapter {

    private onEmoItemClickListener mListener;

    public void setListener(onEmoItemClickListener mListener) {
        this.mListener = mListener;
    }

    /**
     * 两页数据 每页28个表情
     *
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //生成每一页数据
        EmojiGridView gridView = new EmojiGridView(container.getContext());
        gridView.setListener(mListener);
        gridView.initData(position);
        container.addView(gridView);
        return container;
    }
}
