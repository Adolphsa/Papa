package com.lucas.papa;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lucas.papa.navigator.FixFragmentNavigator;
import com.lucas.papa.ui.camera.CameraFragment;
import com.lucas.papa.ui.device.DeviceFragment;
import com.lucas.papa.ui.location.LocationFragment;
import com.lucas.papa.ui.setting.SettingFragment;

import java.util.Objects;

/**
 * Created by lucas
 * <p>
 * Date: 2020/9/25 15:45
 * <p>
 * Description:
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private NavController navController;
    private BottomNavigationView navView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //由于 启动时设置了 R.style.launcher 的windowBackground属性
        //势必要在进入主页后,把窗口背景清理掉
        setTheme(R.style.AppTheme);

        //启用沉浸式布局，白底黑字
//        StatusBar.fitSystemBar(this);

        setContentView(R.layout.activity_main);

        navView = findViewById(R.id.nav_view);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (fragment != null) {

            navController = NavHostFragment.findNavController(fragment);

            //创建自定义的fragment导航器
            FixFragmentNavigator fragmentNavigator = new FixFragmentNavigator(
                    this,
                    fragment.getChildFragmentManager(),
                    fragment.getId());
            //获取导航器提供者
            NavigatorProvider provider = navController.getNavigatorProvider();
            //把自定义的Fragment导航器添加进去
            provider.addNavigator(fragmentNavigator);
            //手动创建导航图
            NavGraph navGraph = initNavGraph(provider, fragmentNavigator);
            //设置导航图
            navController.setGraph(navGraph);
            navView.setOnNavigationItemSelectedListener(item -> {
                navController.navigate(item.getItemId());
                return true;
            });
        }

    }


    //手动创建导航图，把4个目的地添加进来
    private NavGraph initNavGraph(NavigatorProvider provider, FixFragmentNavigator fragmentNavigator) {

        NavGraph navGraph = new NavGraph(new NavGraphNavigator(provider));

        //用自定义的导航器来创建目的地
        FragmentNavigator.Destination device = fragmentNavigator.createDestination();
        device.setId(R.id.navigation_device);
        device.setClassName(Objects.requireNonNull(DeviceFragment.class.getCanonicalName()));
        device.setLabel(getResources().getString(R.string.nav_title_device));
        navGraph.addDestination(device);

        FragmentNavigator.Destination location = fragmentNavigator.createDestination();
        location.setId(R.id.navigation_location);
        location.setClassName(Objects.requireNonNull(LocationFragment.class.getCanonicalName()));
        location.setLabel(getResources().getString(R.string.nav_title_location));
        navGraph.addDestination(location);

        FragmentNavigator.Destination camera = fragmentNavigator.createDestination();
        camera.setId(R.id.navigation_camera);
        camera.setClassName(Objects.requireNonNull(CameraFragment.class.getCanonicalName()));
        camera.setLabel(getResources().getString(R.string.nav_title_camera));
        navGraph.addDestination(camera);

        FragmentNavigator.Destination setting = fragmentNavigator.createDestination();
        setting.setId(R.id.navigation_setting);
        setting.setClassName(Objects.requireNonNull(SettingFragment.class.getCanonicalName()));
        setting.setLabel(getResources().getString(R.string.nav_title_setting));
        navGraph.addDestination(setting);

        navGraph.setStartDestination(R.id.navigation_device);

        return navGraph;
    }

    /**
     * 重写返回键事件
     * fix: ComponentActivity.onBackPressed -> ... -> NavController.popBackStack()
     * 自定义导航器后，会引起NavController管理的回退栈出问题
     */
    @Override
    public void onBackPressed() {
        int currentId = navController.getCurrentDestination().getId();
        int startId = navController.getGraph().getStartDestination();
        //如果当前目的地不是HomeFragment，则先回到HomeFragment
        if (currentId != startId) {
            navView.setSelectedItemId(startId);
        } else {
            finish();
        }
    }
}