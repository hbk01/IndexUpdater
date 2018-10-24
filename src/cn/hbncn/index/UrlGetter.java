package cn.hbncn.index;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

// Create at 2018-5-26 22:09 by 3243430237@qq.com
// TODO: 2018-5-26 get url
public class UrlGetter {
    private IndexConfig config = new IndexConfig();
    private String page_str = "http://www.jx530.com/web/xgbdst/3?p_p_id=showJournal_INSTANCE_qvak&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_showJournal_INSTANCE_qvak_struts_action=%2Fext%2Fshowjournal%2Fview&_showJournal_INSTANCE_qvak_condition=yes&_showJournal_INSTANCE_qvak_advancedSearch=false&_showJournal_INSTANCE_qvak_andOperator=true&_showJournal_INSTANCE_qvak_groupId=139334&_showJournal_INSTANCE_qvak_version=0.0&_showJournal_INSTANCE_qvak_status=approved&_showJournal_INSTANCE_qvak_organizationId=0&delta=20&cur=";

    public UrlGetter(ArrayList<Default> list) {
        for (Default de : list) {
            config.add(de.getTitle(), de.getUrl());
        }
    }

    public void run(String path) throws IOException {
        for (int page = 1; page <= 6; page++) {
            String urll = page_str + page;
            Document doc = Jsoup.connect(urll).get();//获取网页
            // 寻找所有带有link属性的a标签
            Elements elements = doc.select("a[link]");
            for (Element e : elements) {
                String url = e.attr("link");// 获取链接
                String title = e.attr("title");// 获取标题
                config.add(title, url);// 保存起来
            }
            System.out.println("page" + page + " has " + elements.size() + " urls.");
        }
        config.write(path);// 依据获取到的链接和标题生成一个网页
    }

}
