package com.example.xpoup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.blankj.utilcode.BuildConfig
import com.example.xpoup.fragment.*
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.impl.LoadingPopupView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var pageInfos = arrayOf(
        PageInfo("快速开始", QuickStartDemo()),
        PageInfo("局部阴影", PartShadowDemo()),
        PageInfo("图片浏览", ImageViewerDemo()),
        PageInfo("尝试不同动画", AllAnimatorDemo()),
        PageInfo("自定义弹窗", CustomPopupDemo()),
        PageInfo("自定义动画", CustomAnimatorDemo())
    )

    var loadingPopupView: LoadingPopupView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        BarUtils.setStatusBarLightMode(this, true);
//        BarUtils.setNavBarColor(this, Color.RED);
        val actionBar = supportActionBar
        actionBar!!.setTitle(actionBar.title.toString() + "-" + BuildConfig.VERSION_NAME)

        viewPager.setAdapter(MainAdapter(supportFragmentManager))
        tabLayout.setupWithViewPager(viewPager)

        XPopup.setPrimaryColor(resources.getColor(R.color.colorPrimary))
//        XPopup.setAnimationDuration(1000);
//        XPopup.setPrimaryColor(Color.RED);
//        ScreenUtils.setLandscape(this);
        //        XPopup.setAnimationDuration(1000);
//        XPopup.setPrimaryColor(Color.RED);
//        ScreenUtils.setLandscape(this);
        loadingPopupView = XPopup.Builder(this).asLoading("嘻嘻嘻嘻嘻")
        loadingPopupView?.show()
        loadingPopupView?.delayDismiss(1000)

//        BarUtils.setStatusBarVisibility(this, false);
//        BarUtils.setNavBarVisibility(this, false);

//        ToastUtils.showLong(FuckRomUtils.getRomInfo().getName() + FuckRomUtils.getRomInfo().getVersion());
//        ToastUtils.showLong(android.os.Build.MODEL);
    }

    inner class MainAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm!!) {
        override fun getItem(i: Int): Fragment {
            return pageInfos.get(i).fragment
        }

        override fun getCount(): Int {
            return pageInfos.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return pageInfos.get(position).title
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewPager.removeAllViews()
    }
}