package com.example.sendmessageBinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendmessageBinding.R;
import com.example.sendmessageBinding.SendMessageApplication;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setCover(R.mipmap.ic_launcher)
                .setName((((SendMessageApplication)getApplication()).getUser().getName()))
                .setSubTitle(getResources().getString(R.string.subtituloAboutUs))
                .setBrief(getResources().getString(R.string.briefAboutUs))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink(getResources().getString(R.string.playStoreLinkAboutUs))
                .addGitHubLink(getResources().getString(R.string.gitHubLinkAboutUs))
                .addFacebookLink(getResources().getString(R.string.facebookLinkAboutUs))
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();

        setContentView(view);
    }
}