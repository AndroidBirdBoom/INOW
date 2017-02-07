package principal;

import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.kobe.ubersplash.R;

/**
 * Created by HP on 2017/1/24.
 */

public class SecondActivity extends SlidingFragmentActivity{
    public void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        //设置主页面
        setContentView(R.layout.activity_principal);
        //设置左侧菜单
        setBehindContentView(R.layout.leftmenu);
        //设置右侧菜单
        SlidingMenu slidingMenu=getSlidingMenu();
        slidingMenu.setSecondaryMenu(R.layout.rightmenu);

        //4.设置滑动模式：滑动全屏，边缘，不可以滑动
        slidingMenu.setTouchModeAbove(slidingMenu.TOUCHMODE_FULLSCREEN);

        //5.设置视图模式，左侧菜单加主页，主页+右侧菜单，左侧+主+右侧
        slidingMenu.setMode(slidingMenu.LEFT_RIGHT);

        //6.设置主页面占领的宽度
       slidingMenu.setBehindOffset(getWindowManager().getDefaultDisplay().getWidth()/2);
    }
}
