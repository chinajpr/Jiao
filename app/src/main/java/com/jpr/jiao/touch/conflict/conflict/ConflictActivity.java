package com.jpr.jiao.touch.conflict.conflict;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jpr.jiao.R;

/**
 * 类描述：解决事件冲突
 * 1.外部拦截法：触摸事件都先经过父容器的拦截处理，如果父容器需要此事件就拦截，不需要就不拦截（此方法符合view事件分发机制），这样就可以解决滑动冲突问题
 * 2.内部拦截法：父容器不拦截任何事件，所有的事件都传递给子元素，如果子元素需要此事件就直接消耗掉，否则就交由父容器进行处理，这种方法和android中的事件分发机制不一致，需要配合requestDisallowInterceptTouchEvent方法才能正常工作，使用越来较外部拦截法稍显复杂。
 * 作者：jiaopeirong on 2019-08-19 22:35
 * 邮箱：chinajpr@163.com
 */
public class ConflictActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conflict);

    }
}
