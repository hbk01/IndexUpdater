package cn.hbncn.index;

import java.io.IOException;
import java.util.ArrayList;

// Create at 2018-5-26 21:55 by 3243430237@qq.com
// TODO: 2018-5-26 lunch program
public class Main {
    public static void main(String[] args) {
        ArrayList<Default> list = new ArrayList<>();
        list.add(new Default("【本站】全网音乐聚合搜索引擎", "http://hbkcn.cn/music"));
        list.add(new Default("【本站】黑客游戏", "http://hbkcn.cn/game"));
        list.add(new Default("【本站】电视直播", "http://hbkcn.cn/tv"));
        list.add(new Default("【成绩查询】学生成绩查询入口", "http://www.jxyyxx.com/jwweb/"));
        UrlGetter getter = new UrlGetter(list);
        try {
            getter.run("E:\\Project\\web\\index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
