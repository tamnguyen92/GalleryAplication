package com.king.jerem.imagegallery.Model;

import android.util.Log;

import com.king.jerem.imagegallery.Callback.Listenner;
import com.king.jerem.imagegallery.Connection.Config;
import com.king.jerem.imagegallery.Connection.DowloardHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by jerem on 14/03/2018.
 */

public class ModelGalery_getURL {
    public List<String>listUrl;
    DowloardHtml dowloardHtml;
    public ModelGalery_getURL() {


    }
    public List<String> getListUrl(String url)
    {
        listUrl=new ArrayList<>();
        dowloardHtml =new DowloardHtml();
        dowloardHtml.execute(url);

        try {
            String html=dowloardHtml.get();
            Document document= Jsoup.parse(html);
            if(document!=null)
            {   // Log.e("URL",document.toString());
                Elements elements=document.getElementsByTag("img");
                Log.e("URL",elements.size()+"");
                for(Element e:elements )
                {
                    String src=e.absUrl("src");
                    if(!src.equals(""))
                    {
                        listUrl.add(src);
                    }

                    Log.e("SRCCCCCCCCCCCCCCCC",src );
                }
            }
            if(listUrl!=null)
            {
                SaveList();
            }
            return listUrl;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
    private void SaveList()
    {
        List<String>listnew=new ArrayList<>();
        int i=0;
        for(String s:listUrl)
        {
            if(i%2==0)
            {
                listnew.add(s);
            }
            i++;
        }
        listUrl=listnew;
    }

}
