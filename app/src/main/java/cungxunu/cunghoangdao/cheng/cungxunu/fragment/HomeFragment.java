package cungxunu.cunghoangdao.cheng.cungxunu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cungxunu.cunghoangdao.cheng.cungxunu.BaseFragment;
import cungxunu.cunghoangdao.cheng.cungxunu.R;
import cungxunu.cunghoangdao.cheng.cungxunu.adapter.RecyclerViewIconCungHoangDaoAdapter;
import cungxunu.cunghoangdao.cheng.cungxunu.model.Cunghoangdao;

/**
 * Created by Welcome on 6/28/2016.
 */
public class HomeFragment extends BaseFragment implements RecyclerViewIconCungHoangDaoAdapter.OnItemClickIconCungHoangDao {
    @BindView(R.id.fragment_home_slider)
    SliderLayout slider;
    @BindView(R.id.fragment_home_rcvWidget)
    RecyclerView rcvWidget;
    ArrayList<Cunghoangdao> arrayCunghoangdao;
    RecyclerViewIconCungHoangDaoAdapter custom_addapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        ButterKnife.bind(this,view);
        rcvWidget.setHasFixedSize(true);
        rcvWidget.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        initSlider();
        initSlideCungHoangDao();
        return view;
    }

    private void initSlider() {
        //添加资源
        TextSliderView slider1 = new TextSliderView(getContext());
        slider1.description("音箱狂欢").image("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg").setScaleType(BaseSliderView.ScaleType.Fit);
        //为该图片添加点击事件
        slider1.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getContext(), "音箱狂欢", Toast.LENGTH_SHORT).show();
            }
        });
        TextSliderView slider2 = new TextSliderView(getContext());
        slider2.description("手机国庆礼").image("http://7mno4h.com2.z0.glb.qiniucdn.com/5608eb8cN9b9a0a39.jpg").setScaleType(BaseSliderView.ScaleType.Fit);
        slider2.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getContext(), "手机国庆礼", Toast.LENGTH_SHORT).show();
            }
        });
        TextSliderView slider3 = new TextSliderView(getContext());
        slider3.description("IT生活").image("http://7mno4h.com2.z0.glb.qiniucdn.com/5608cae6Nbb1a39f9.jpg").setScaleType(BaseSliderView.ScaleType.Fit);
        slider3.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
            @Override
            public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(HomeFragment.this.getContext(), "IT生活", Toast.LENGTH_SHORT).show();
            }
        });
        //进行基本显示
        slider.addSlider(slider3);
        slider.addSlider(slider3);
        slider.addSlider(slider3);


        //设置图片切换动画以及展示时间
        slider.setPresetTransformer(SliderLayout.Transformer.Default);
        slider.setDuration(3000);

        //添加图片切换事件
        slider.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("Slide","onPageScrolled");
            }
            @Override
            public void onPageSelected(int position) {
                Log.i("Slide","onPageSelected");
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i("Slide","onPageScrollStateChanged");
            }
        });
    }
    private void initSlideCungHoangDao() {
        arrayCunghoangdao = new ArrayList<>();
        Cunghoangdao cunghoangdao = null;
        for (int i = 0; i < getResources().getStringArray(R.array.item_drawer).length; i++) {
            cunghoangdao = new Cunghoangdao(getResources().getStringArray(R.array.item_drawer)[i],
                    getResources().obtainTypedArray(R.array.icon_drawer).getResourceId(i, -1));
            arrayCunghoangdao.add(cunghoangdao);
        }
        custom_addapter = new RecyclerViewIconCungHoangDaoAdapter(getActivity(), arrayCunghoangdao, this);
        rcvWidget.setAdapter(custom_addapter);
        custom_addapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClickIconCungHoangDao(View v, int position, String category) {

    }
}
