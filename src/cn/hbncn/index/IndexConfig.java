package cn.hbncn.index;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

// Create at 2018-5-26 21:56 by 324343237@qq.com
// TODO: 2018-5-26 config
public class IndexConfig {
    private String head = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "    <meta name=\"keywords\" content=\"江西省医药学校，江西药校，影像药校，药校\" />\n" +
            "    <meta name=\"description\" content=\"影像药校_视频索引\" />\n" +
            "    <title>影像药校</title>\n" +
            "    <style>\n" +
            "\n" +
            "        * {\n" +
            "        width: 98%;\n" +
            "        margin: 0 auto;\n" +
            "        background: #fff;\n" +
            "    }\n" +
            "\n" +
            "    /*头部*/\n" +
            "        .header {\n" +
            "        width: 80%;\n" +
            "        text-align: center;\n" +
            "        margin-top: 10px;\n" +
            "        font-size: 200%;\n" +
            "    }\n" +
            "\n" +
            "    /*内容容器*/\n" +
            "        #content {\n" +
            "        width: 100%;\n" +
            "        height: 100%;\n" +
            "    }\n" +
            "\n" +
            "    /*每一个内容*/\n" +
            "        ._content {\n" +
            "        padding-left: 10px;\n" +
            "        margin-top: 10px;\n" +
            "        margin-bottom: 10px;\n" +
            "    }\n" +
            "\n" +
            "    /*底部的版权声明*/\n" +
            "        .footer {\n" +
            "        width: 100%;\n" +
            "        height: 30px;\n" +
            "        text-align: center;\n" +
            "    }\n" +
            "\n" +
            "    /*设置a标签显示的颜色*/\n" +
            "    a {\n" +
            "        text-decoration: none;\n" +
            "        color: #333;\n" +
            "    }\n" +
            "\n" +
            "    a:hover{\n" +
            "        color:#F00; text-decoration:underline;\n" +
            "    }\n" +
            "\n" +
            "    a:active{\n" +
            "        color:#30F;\n" +
            "    }\n" +
            "\n" +
            "    </style>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "    <header class=\"header\">影像药校</header>\n" +
            "    <div>所有内容均使用程序自动化生成，若有标题与链接不符合的情况，<a target=\"_blank\" href=\"http://wpa.qq.com/msgrd?v=3&uin=3243430237&site=qq&menu=yes\">点击这里反馈</a>或发送邮件至hbk.ai@qq.com</div>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        alert(\"注意：本站中所有链接均来自江西省医药学校(jx530.com)\\n因校官网中许多视频仍使用flash palyer播放，但现在许多(几乎所有)的手机端浏览器已经不再支持flash player，这将导致手机端无法播放采用falsh player的视频，但一般来说电脑端可以正常播放。\")\n" +
            "    </script>" +
            "    <div id=\"content\"></div>\n" +
            "    <footer class=\"footer\">版权所有 © 2018-2019 <a href=\"http://hbkcn.cn\" target=\"_abank\">hbkcn.cn</a></footer>\n" +
            "\n" +
            "    <script type=\"text/javascript\">\n" +
            "    // url列表\n" +
            "    var list_url = [\n";
    private String item = "\n" +
            "            ];\n" +
            "\n" +
            "    // url对应的标题\n" +
            "    var list_title = [\n";
    private String end = "\n" +
            "            ];\n" +
            "\n" +
            "    // 在加载网页时执行\n" +
            "    window.onload = function(){\n" +
            "        // 根据id获得元素\n" +
            "        var con = document.getElementById('content');\n" +
            "        // 遍历标题中的内容\n" +
            "        for (var i = 0; i < list_title.length; i++) {\n" +
            "            // 将每个标题及对应的url插入html\n" +
            "            con.innerHTML += \"<div class=\\\"_content\\\"><a href=\\\"\" + list_url[i] + \"\\\" target=\\\"_abank\\\">\" + list_title[i] + \"</a></div>\";\n" +
            "        }\n" +
            "    }\n" +
            "    </script>\n" +
            "\n" +
            "</body>\n" +
            "</html>";
    private ArrayList<String> titles = new ArrayList<>();// 装标题
    private ArrayList<String> urls = new ArrayList<>();// 装链接

    /**
     * 添加一条标题及链接
     * @param title 标题
     * @param url 链接
     */
    public void add(String title, String url) {
        System.out.println("add " + title + " of " + url);
        titles.add("        \"" + title.trim() + "\",\n");
        urls.add("        \"" + url.trim() + "\",\n");
    }

    /**
     * 写入文件
     * @param path 路径
     */
    public void write(String path) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(head);
        sb1.append(item);
        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String url = urls.get(i);
            sb1.append(title);
            sb.append(url);
        }
        sb1.append(end);
        String str = sb.toString() + sb1.toString();

        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(str.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
