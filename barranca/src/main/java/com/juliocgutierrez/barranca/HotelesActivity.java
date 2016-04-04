package com.juliocgutierrez.barranca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class HotelesActivity extends AppCompatActivity {

    private static final int[] hotel1 = { R.drawable.hotel, R.drawable.hotelm2,
            R.drawable.hotelm3,R.drawable.hotelm4};
    private static final int[] hotel2 = { R.drawable.ciudad, R.drawable.ciudad1,
            R.drawable.ciudad2,R.drawable.ciudad3};
    private static final int[] hotel3 = { R.drawable.pipaton1, R.drawable.pipaton2,
            R.drawable.pipaton3,R.drawable.pipaton4};
    private int photel1 = 0;
    private int photel2 = 0;
    private int photel3 = 0;
    private ImageSwitcher mImageSwitcher1;
    private ImageSwitcher mImageSwitcher2;
    private ImageSwitcher mImageSwitcher3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);

        mImageSwitcher1 = (ImageSwitcher) findViewById(R.id.imagenesh1);
        mImageSwitcher2 = (ImageSwitcher) findViewById(R.id.imagenesh2);
        mImageSwitcher3 = (ImageSwitcher) findViewById(R.id.imagenesh3);

        mImageSwitcher1.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(HotelesActivity.this);
                return imageView;
            }
        });
        mImageSwitcher1.setInAnimation(this, android.R.anim.slide_in_left);
        mImageSwitcher1.setOutAnimation(this, android.R.anim.slide_out_right);

        mImageSwitcher2.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(HotelesActivity.this);
                return imageView;
            }
        });
        mImageSwitcher2.setInAnimation(this, android.R.anim.slide_in_left);
        mImageSwitcher2.setOutAnimation(this, android.R.anim.slide_out_right);

        mImageSwitcher3.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(HotelesActivity.this);
                return imageView;
            }
        });
        mImageSwitcher3.setInAnimation(this, android.R.anim.slide_in_left);
        mImageSwitcher3.setOutAnimation(this, android.R.anim.slide_out_right);

        onSwitch1(null);
        onSwitch2(null);
        onSwitch3(null);
    }

    public void onSwitch1(View view) {
        mImageSwitcher1.setBackgroundResource(hotel1[photel1]);
        photel1 = (photel1 + 1) % 4;
    }

    public void onSwitch2(View view) {
        mImageSwitcher2.setBackgroundResource(hotel2[photel2]);
        photel2 = (photel2 + 1) % 4;
    }

    public void onSwitch3(View view) {
        mImageSwitcher3.setBackgroundResource(hotel3[photel3]);
        photel3 = (photel3 + 1) % 4;
    }
}
