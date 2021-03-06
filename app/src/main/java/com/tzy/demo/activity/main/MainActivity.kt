package com.tzy.demo.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.tzy.demo.R
import com.tzy.demo.activity.animator.LottieActivity
import com.tzy.demo.activity.animator.ObjectAnimatorActivity
import com.tzy.demo.activity.base.BaseActivity
import com.tzy.demo.activity.camera.CameraActivity
import com.tzy.demo.activity.downloadprogress.OkhttpDownloadActivity
import com.tzy.demo.activity.js.TestJsActivity
import com.tzy.demo.activity.largeimage.LargeImageActivity
import com.tzy.demo.activity.media.MediaPlayerActivity
import com.tzy.demo.activity.recyclerview.MultiRecyclerViewActivity
import com.tzy.demo.activity.recyclerview.TestRefreshActivity
import com.tzy.demo.activity.sms.ReadSmsActivity
import com.tzy.demo.activity.tablayout.TabLayoutActivity
import com.tzy.demo.activity.task.TaskA1Activity
import com.tzy.demo.activity.web.CommonWebviewActivity
import com.tzy.demo.activity.websocket.WebSocketActivity
import com.tzy.demo.activity.wifi.WiFiPasswordActivity
import com.tzy.demo.adapter.MainAdapter
import com.tzy.demo.bean.MainItemBean
import com.tzy.demo.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var adapter: MainAdapter

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        mBinding.rv.layoutManager = LinearLayoutManager(this)
        mBinding.rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter = MainAdapter()
        adapter.setNewInstance(getFunctionList())
        mBinding.rv.adapter = adapter
    }

    override fun initEvent() {
        adapter.setOnItemClickListener { _, _, position ->
            val itemBean: MainItemBean = adapter.getItem(position)
            startActivity(Intent(this, itemBean.target))
        }
    }

    private fun getFunctionList() = arrayListOf(MainItemBean("Lottie动画", LottieActivity::class.java)
            , MainItemBean("Object动画", ObjectAnimatorActivity::class.java)
            , MainItemBean("拍照", CameraActivity::class.java)
            , MainItemBean("文件下载进度", OkhttpDownloadActivity::class.java)
            , MainItemBean("JS交互", TestJsActivity::class.java)
            , MainItemBean("加载大图", LargeImageActivity::class.java)
            , MainItemBean("ExoPlayer多音频同时播放", MediaPlayerActivity::class.java)
            , MainItemBean("MultiRecyclerView", MultiRecyclerViewActivity::class.java)
            , MainItemBean("TabLayout", TabLayoutActivity::class.java)
            , MainItemBean("任务栈测试", TaskA1Activity::class.java)
            , MainItemBean("Web", CommonWebviewActivity::class.java)
            , MainItemBean("WebSocket", WebSocketActivity::class.java)
            , MainItemBean("查看Wifi密码", WiFiPasswordActivity::class.java)
            , MainItemBean("读取短信", ReadSmsActivity::class.java))

}