package bilibili.bilibili.activity;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import bilibili.bilibili.R;
import bilibili.bilibili.base.BaseActivity;
import butterknife.Bind;

public class SplashActivity extends BaseActivity {


    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.activity_splash)
    RelativeLayout activitySplash;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {

        AlphaAnimation animation = new AlphaAnimation(0, 1);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        activitySplash.setAnimation(animation);

    }

    @Override
    protected void initListener() {

    }
}
