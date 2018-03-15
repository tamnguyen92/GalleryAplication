package com.king.jerem.imagegallery.Presenter;

import com.king.jerem.imagegallery.Connection.Config;
import com.king.jerem.imagegallery.Model.ModelGalery_getURL;
import com.king.jerem.imagegallery.View.ViewShowGallery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerem on 14/03/2018.
 */

public class LPresenterLoadGallery implements IPresenterLoadGallery {
    ViewShowGallery viewShowGallery;
    ModelGalery_getURL modelGalerygetURL;
    List<String> list_URL;
    public LPresenterLoadGallery(ViewShowGallery viewShowGallery) {
        this.viewShowGallery=viewShowGallery;
        modelGalerygetURL =new ModelGalery_getURL();
        list_URL=new ArrayList<>();
    }

    @Override
    public void GetListUrl(String url) {
        if(url.equals(""))
        {
            url= Config.BaseURL;
        }
        list_URL= modelGalerygetURL.getListUrl(url);
        if(list_URL!=null&&list_URL.size()>0)
        {
            viewShowGallery.ShowAllImage(list_URL);
        }
        else
        {
            viewShowGallery.ShowError("data is null");
        }
    }
}
