package com.example.resumebuilder.fragments;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.resumebuilder.R;
import com.example.resumebuilder.datamodels.Experience;
import com.example.resumebuilder.datamodels.PersonalInfo;
import com.example.resumebuilder.datamodels.Project;
import com.example.resumebuilder.datamodels.Resume;
import com.example.resumebuilder.datamodels.School;
import com.example.resumebuilder.helper.ResumeFragment;

public class PreviewFragment extends ResumeFragment {
    WebView webView;
    int template = 1;
    StringBuilder htmlContent;
    Resume resume;
    PersonalInfo personalInfo;


    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new PreviewFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preview, container, false);
        webView = view.findViewById(R.id.webView);
        htmlContent = new StringBuilder();
        resume = getResume();
        personalInfo = resume.personalInfo;
        changeTemplate(template);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.print, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_print) {
            createWebPrintJob(webView);
        } else if (item.getItemId() == R.id.action_template) {
            changeTemplate((++template) % 2);
        }
        return super.onOptionsItemSelected(item);
    }

    private void changeTemplate(int i) {
        htmlContent.delete(0, htmlContent.length());
        if (i == 0) {
            htmlContent.append(String.format("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title>Resume</title>\n" +
                    "<meta charset=UTF-8>\n" +
                    "<link rel=\"shortcut icon\" href=https://ssl.gstatic.com/docs/documents/images/kix-favicon6.ico>\n" +
                    "<style type=text/css>body{font-family:arial,sans,sans-serif;margin:0}iframe{border:0;frameborder:0;height:100%%;width:100%%}#header,#footer{background:#f0f0f0;padding:10px 10px}#header{border-bottom:1px #ccc solid}#footer{border-top:1px #ccc solid;border-bottom:1px #ccc solid;font-size:13}#contents{margin:6px}.dash{padding:0 6px}</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div id=contents>\n" +
                    "<style type=text/css>@import url('https://themes.googleusercontent.com/fonts/css?kit=xTOoZr6X-i3kNg7pYrzMsnEzyYBuwf3lO_Sc3Mw9RUVbV0WvE1cEyAoIq5yYZlSc');ol{margin:0;padding:0}table td,table th{padding:0}.c26{border-right-style:solid;padding:3.6pt 3.6pt 3.6pt 3.6pt;border-bottom-color:#fff;border-top-width:0;border-right-width:0;border-left-color:#fff;vertical-align:top;border-right-color:#fff;border-left-width:0;border-top-style:solid;border-left-style:solid;border-bottom-width:0;width:176.3pt;border-top-color:#fff;border-bottom-style:solid}.c4{border-right-style:solid;padding:5pt 5pt 5pt 5pt;border-bottom-color:#fff;border-top-width:0;border-right-width:0;border-left-color:#fff;vertical-align:top;border-right-color:#fff;border-left-width:0;border-top-style:solid;border-left-style:solid;border-bottom-width:0;width:327.7pt;border-top-color:#fff;border-bottom-style:solid}.c16{color:#000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:12pt;font-family:\"Raleway\";font-style:normal}.c7{color:#000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Lato\";font-style:normal}.c13{color:#000;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:10pt;font-family:\"Lato\";font-style:normal}.c1{color:#666;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:9pt;font-family:\"Lato\";font-style:normal}.c19{color:#000;font-weight:400;text-decoration:none;vertical-align:baseline;font-size:6pt;font-family:\"Lato\";font-style:normal}.c20{color:#f2511b;font-weight:700;text-decoration:none;vertical-align:baseline;font-size:16pt;font-family:\"Raleway\";font-style:normal}.c6{padding-top:0;padding-bottom:0;line-height:1.0;text-align:left}.c32{padding-top:5pt;padding-bottom:0;line-height:1.15;text-align:left}.c0{padding-top:10pt;padding-bottom:0;line-height:1.0;text-align:left}.c22{padding-top:5pt;padding-bottom:0;line-height:1.0;text-align:left}.c10{color:#d44500;text-decoration:none;vertical-align:baseline;font-style:normal}.c2{padding-top:0;padding-bottom:0;line-height:1.15;text-align:left}.c33{padding-top:3pt;padding-bottom:0;line-height:1.0;text-align:left}.c9{padding-top:4pt;padding-bottom:0;line-height:1.15;text-align:left}.c23{border-spacing:0;border-collapse:collapse;margin:0 auto}.c30{color:#000;text-decoration:none;vertical-align:baseline;font-style:normal}.c3{padding-top:6pt;padding-bottom:0;line-height:1.15;text-align:left}.c14{padding-top:16pt;padding-bottom:0;line-height:1.15;text-align:left}.c28{padding-top:6pt;padding-bottom:0;line-height:1.0;text-align:left}.c18{font-size:9pt;font-family:\"Lato\";font-weight:400}.c24{font-size:14pt;font-family:\"Lato\";font-weight:700}.c8{font-size:10pt;font-family:\"Lato\";font-weight:400}.c5{font-size:11pt;font-family:\"Lato\";font-weight:400}.c31{background-color:#fff;max-width:504pt;padding:36pt 54pt 36pt 54pt}.c35{font-weight:700;font-size:24pt;font-family:\"Raleway\"}.c11{orphans:2;widows:2;height:11pt}.c21{height:auto}.c15{height:auto}.c27{height:auto}.c34{height:auto}.c29{height:auto}.c25{font-size:10pt}.c12{page-break-after:avoid}.c17{height:265pt}.title{padding-top:6pt;color:#000;font-weight:700;font-size:24pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.0;page-break-after:avoid;orphans:2;widows:2;text-align:left}.subtitle{padding-top:3pt;color:#f2511b;font-weight:700;font-size:16pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.0;page-break-after:avoid;orphans:2;widows:2;text-align:left}li{color:#000;font-size:11pt;font-family:\"Lato\"}p{margin:0;color:#000;font-size:11pt;font-family:\"Lato\"}h1{padding-top:4pt;color:#000;font-weight:700;font-size:12pt;padding-bottom:0;font-family:\"Raleway\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h2{padding-top:6pt;color:#000;font-weight:700;font-size:11pt;padding-bottom:0;font-family:\"Lato\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h3{padding-top:6pt;color:#666;font-size:9pt;padding-bottom:0;font-family:\"Lato\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h4{padding-top:8pt;-webkit-text-decoration-skip:none;color:#666;text-decoration:underline;font-size:11pt;padding-bottom:0;line-height:1.15;page-break-after:avoid;text-decoration-skip-ink:none;font-family:\"Trebuchet MS\";orphans:2;widows:2;text-align:left}h5{padding-top:8pt;color:#666;font-size:11pt;padding-bottom:0;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;orphans:2;widows:2;text-align:left}h6{padding-top:8pt;color:#666;font-size:11pt;padding-bottom:0;font-family:\"Trebuchet MS\";line-height:1.15;page-break-after:avoid;font-style:italic;orphans:2;widows:2;text-align:left}</style>\n" +
                    "<p class=\"c2 c29\"><span class=c19></span></p>\n" +
                    "<a id=t.b7144d62fc47a2bfcf177a3c3dd72df0e868051e></a>\n" +
                    "<a id=t.0></a>\n" +
                    "<table class=c23>\n" +
                    "            <tbody>\n" +
                    "                <tr class=\"c21\">\n" +
                    "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6 c12 title\" id=\"h.4prkjmzco10w\"><span>%s</span></p>\n" +
                    "                        <p class=\"c33 subtitle\" id=\"h.o2iwx3vdck7p\"><span class=\"c20\">%s</span></p>\n" +
                    "                    </td>\n" +
                    "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n" +
                    "                        <p class=\"c6\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh4.googleusercontent.com/j7t3_XjsJ1PHIrgcWuJOWmQ2fFs9q-TT_LNTDfAXGnVu49aapNgutWcfK1k7pPzGtsu9lOvPynvLW07b_KwpVV0ituspJAXOQ_IBZyN087cqGsXawUahO2qDRCQZ8-qq4esAcP7M\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n" +
                    "                        <h1 class=\"c3\" id=\"h.lf5wiiqsu4ub\"><span>%s</span></h1>\n" +
                    "                        <p class=\"c6\"><span class=\"c7\">%s</span></p>\n" +
                    "                        <p class=\"c6\"><span class=\"c25\">%s</span></p>\n" +
                    "                        <p class=\"c0\"><span class=\"c10 c8\">%s</span></p>\n" +
                    "                        <p class=\"c6\"><span class=\"c8 c10\">%s</span></p>\n" +
                    "                    </td>\n" +
                    "                </tr>", personalInfo.getName(), personalInfo.getJobTitle(), personalInfo.getName(), personalInfo.getAddressLine1(), personalInfo.getAddressLine2(), personalInfo.getPhone(), personalInfo.getEmail()));

            if (!resume.skills.isEmpty()) {
                htmlContent.append(String.format("\n" +
                        "                <tr class=\"c27\">\n" +
                        "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                        "                        <h1 class=\"c9\" id=\"h.61e3cm1p1fln\"><span class=\"c16\">" + getString(R.string.hint_skills) + "</span></h1></td>\n" +
                        "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh3.googleusercontent.com/n8bZfGajkthDbPpbjeiRJ4w7rNUmj1iFxdZKCHUOVnfH9FgHVt5EBo3vOYIIoE3augYQ_DCZJUzdlStyJ5RaldVrSG36sTE0CjIot2qaiJ3YRyr2i87bt9Y9d0ngdseS9PpG0HzM\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n" +
                        "                        <p class=\"c3\"><span class=\"c7\">%s</span></p>\n" +
                        "                    </td>\n" +
                        "                </tr>", resume.skills));
            }
            if (!resume.languages.isEmpty()) {
                htmlContent.append(String.format("\n" +
                        "                <tr class=\"c27\">\n" +
                        "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                        "                        <h1 class=\"c9\" id=\"h.61e3cm1p1fln\"><span class=\"c16\">" + getString(R.string.hint_languages) + "</span></h1></td>\n" +
                        "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c2\"><span style=\"overflow: hidden; display: inline-block; margin: 0.00px 0.00px; border: 0.00px solid #000000; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px); width: 418.00px; height: 2.67px;\"><img alt=\"\" src=\"https://lh3.googleusercontent.com/n8bZfGajkthDbPpbjeiRJ4w7rNUmj1iFxdZKCHUOVnfH9FgHVt5EBo3vOYIIoE3augYQ_DCZJUzdlStyJ5RaldVrSG36sTE0CjIot2qaiJ3YRyr2i87bt9Y9d0ngdseS9PpG0HzM\" style=\"width: 418.00px; height: 2.67px; margin-left: 0.00px; margin-top: 0.00px; transform: rotate(0.00rad) translateZ(0px); -webkit-transform: rotate(0.00rad) translateZ(0px);\" title=\"horizontal line\"></span></p>\n" +
                        "                        <p class=\"c3\"><span class=\"c7\">%s</span></p>\n" +
                        "                    </td>\n" +
                        "                </tr>", resume.languages));
            }
            if (resume.schools.size() != 0) {
                htmlContent.append("\n" +
                        "                <tr class=\"c15\">\n" +
                        "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                        "                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">" + getString(R.string.education) + "</span></h1></td>\n" +
                        "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
                boolean first = true;
                for (School school : resume.schools) {
                    htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n" +
                            "                        <h3 class=\"c2\" id=\"h.re1qtuma0rpm\"><span class=\"c1\">%s</span></h3>\n" +
                            "                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", first ? "c3" : "c14", school.getSchoolName(), school.getDegree(), school.getLocation(), school.getDescription()));
                    first = false;
                }
                htmlContent.append("</td>\n" +
                        "                </tr>");
            }
            if (resume.projects.size() != 0) {
                htmlContent.append("\n" +
                        "                <tr class=\"c15\">\n" +
                        "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                        "                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">" + getString(R.string.hint_project_name) + "</span></h1></td>\n" +
                        "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
                boolean first = true;
                for (Project project : resume.projects) {
                    htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n" +
                            "                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", first ? "c3" : "c14", project.getName(), project.getDetail(), project.getDescription()));
                    first = false;
                }
                htmlContent.append("</td>\n" +
                        "                </tr>");
            }
            if (resume.experience.size() != 0) {
                htmlContent.append("\n" +
                        "                <tr class=\"c15\">\n" +
                        "                    <td class=\"c26\" colspan=\"1\" rowspan=\"1\">\n" +
                        "                        <p class=\"c6\"><span class=\"c24\">ㅡ</span></p>\n" +
                        "                        <h1 class=\"c9\" id=\"h.tk538brb1kdf\"><span class=\"c16\">" + getString(R.string.navigation_experience) + "</span></h1></td>\n" +
                        "                    <td class=\"c4\" colspan=\"1\" rowspan=\"1\">\n");
                boolean first = true;
                for (Experience experience : resume.experience) {
                    htmlContent.append(String.format("<h2 class=\"%s\" id=\"h.u3uy0857ab2n\"><span class=\"c5\">%s </span><span class=\"c30 c5\">/ %s</span></h2>\n" +
                            "                        <h3 class=\"c2\" id=\"h.re1qtuma0rpm\"><span class=\"c1\">%s</span></h3>\n" +
                            "                        <p class=\"c32\"><span class=\"c7\">%s</span></p>\n", first ? "c3" : "c14", experience.getCompany(), experience.getLocation(), experience.getJobTitle(), experience.getDescription()));
                    first = false;
                }
                htmlContent.append("</td>\n" +
                        "                </tr>");
            }
            htmlContent.append("</tbody>\n" +
                    "</table>\n" +
                    "<p class=\"c2 c11\"><span class=\"c30 c5\"></span></p>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>");
        } else if (i == 1) {
            htmlContent.append("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<title>Resume</title>\n" +
                    "\n" +
                    "<meta name=\"viewport\" content=\"width=device-width\"/>\n" +
                    "<meta charset=\"UTF-8\">" +
                    "<link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet' type='text/css'>" +
                    "<style type=\"text/css\">html,body,div,span,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,abbr,address,cite,code,del,dfn,em,img,ins,kbd,q,samp,small,strong,sub,sup,var,b,i,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,figcaption,figure,footer,header,hgroup,menu,nav,section,summary,time,mark,audio,video {\n" +
                    "border:0;\n" +
                    "font:inherit;\n" +
                    "font-size:100%;\n" +
                    "margin:0;\n" +
                    "padding:0;\n" +
                    "vertical-align:baseline;\n" +
                    "}\n" +
                    "\n" +
                    "article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section {\n" +
                    "display:block;\n" +
                    "}\n" +
                    "\n" +
                    "html, body {background: #181818; font-family: 'Lato', helvetica, arial, sans-serif; font-size: 16px; color: #222;}\n" +
                    "\n" +
                    ".clear {clear: both;}\n" +
                    "\n" +
                    "p {\n" +
                    "\tfont-size: 1em;\n" +
                    "\tline-height: 1.4em;\n" +
                    "\tmargin-bottom: 20px;\n" +
                    "\tcolor: #444;\n" +
                    "}\n" +
                    "\n" +
                    "#cv {\n" +
                    "\twidth: 90%;\n" +
                    "\tmax-width: 800px;\n" +
                    "\tbackground: #f3f3f3;\n" +
                    "\tmargin: 30px auto;\n" +
                    "}\n" +
                    "\n" +
                    ".mainDetails {\n" +
                    "\tpadding: 25px 35px;\n" +
                    "\tborder-bottom: 2px solid #cf8a05;\n" +
                    "\tbackground: #ededed;\n" +
                    "}\n" +
                    "\n" +
                    "#name h1 {\n" +
                    "\tfont-size: 2.5em;\n" +
                    "\tfont-weight: 700;\n" +
                    "\tfont-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "\tmargin-bottom: -6px;\n" +
                    "}\n" +
                    "\n" +
                    "#name h2 {\n" +
                    "\tfont-size: 2em;\n" +
                    "\tmargin-left: 2px;\n" +
                    "\tfont-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "}\n" +
                    "\n" +
                    "#mainArea {\n" +
                    "\tpadding: 0 40px;\n" +
                    "}\n" +
                    "\n" +
                    "#headshot {\n" +
                    "\twidth: 12.5%;\n" +
                    "\tfloat: left;\n" +
                    "\tmargin-right: 30px;\n" +
                    "}\n" +
                    "\n" +
                    "#headshot img {\n" +
                    "\twidth: 100%;\n" +
                    "\theight: auto;\n" +
                    "\t-webkit-border-radius: 50px;\n" +
                    "\tborder-radius: 50px;\n" +
                    "}\n" +
                    "\n" +
                    "#name {\n" +
                    "\tfloat: left;\n" +
                    "}\n" +
                    "\n" +
                    "#contactDetails {\n" +
                    "\tfloat: right;\n" +
                    "}\n" +
                    "\n" +
                    "#contactDetails ul {\n" +
                    "\tlist-style-type: none;\n" +
                    "\tfont-size: 0.9em;\n" +
                    "\tmargin-top: 2px;\n" +
                    "}\n" +
                    "\n" +
                    "#contactDetails ul li {\n" +
                    "\tmargin-bottom: 3px;\n" +
                    "\tcolor: #444;\n" +
                    "}\n" +
                    "\n" +
                    "#contactDetails ul li a, a[href^=tel] {\n" +
                    "\tcolor: #444; \n" +
                    "\ttext-decoration: none;\n" +
                    "\t-webkit-transition: all .3s ease-in;\n" +
                    "\t-moz-transition: all .3s ease-in;\n" +
                    "\t-o-transition: all .3s ease-in;\n" +
                    "\t-ms-transition: all .3s ease-in;\n" +
                    "\ttransition: all .3s ease-in;\n" +
                    "}\n" +
                    "\n" +
                    "#contactDetails ul li a:hover { \n" +
                    "\tcolor: #cf8a05;\n" +
                    "}\n" +
                    "\n" +
                    "\n" +
                    "section {\n" +
                    "\tborder-top: 1px solid #dedede;\n" +
                    "\tpadding: 20px 0 0;\n" +
                    "}\n" +
                    "\n" +
                    "section:first-child {\n" +
                    "\tborder-top: 0;\n" +
                    "}\n" +
                    "\n" +
                    "section:last-child {\n" +
                    "\tpadding: 20px 0 10px;\n" +
                    "}\n" +
                    "\n" +
                    ".sectionTitle {\n" +
                    "\tfloat: left;\n" +
                    "\twidth: 25%;\n" +
                    "}\n" +
                    "\n" +
                    ".sectionContent {\n" +
                    "\tfloat: right;\n" +
                    "\twidth: 72.5%;\n" +
                    "}\n" +
                    "\n" +
                    ".sectionTitle h1 {\n" +
                    "\tfont-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "\tfont-style: italic;\n" +
                    "\tfont-size: 1.5em;\n" +
                    "\tcolor: #cf8a05;\n" +
                    "}\n" +
                    "\n" +
                    ".sectionContent h2 {\n" +
                    "\tfont-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "\tfont-size: 1.5em;\n" +
                    "\tmargin-bottom: -2px;\n" +
                    "}\n" +
                    "\n" +
                    ".subDetails {\n" +
                    "\tfont-size: 0.8em;\n" +
                    "\tfont-style: italic;\n" +
                    "\tmargin-bottom: 3px;\n" +
                    "}\n" +
                    "\n" +
                    ".keySkills {\n" +
                    "\tlist-style-type: none;\n" +
                    "\t-moz-column-count:3;\n" +
                    "\t-webkit-column-count:3;\n" +
                    "\tcolumn-count:3;\n" +
                    "\tmargin-bottom: 20px;\n" +
                    "\tfont-size: 1em;\n" +
                    "\tcolor: #444;\n" +
                    "}\n" +
                    "\n" +
                    ".keySkills ul li {\n" +
                    "\tmargin-bottom: 3px;\n" +
                    "}\n" +
                    "\n" +
                    "@media all and (min-width: 602px) and (max-width: 800px) {\n" +
                    "\t#headshot {\n" +
                    "\t\tdisplay: none;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t.keySkills {\n" +
                    "\t-moz-column-count:2;\n" +
                    "\t-webkit-column-count:2;\n" +
                    "\tcolumn-count:2;\n" +
                    "\t}\n" +
                    "}\n" +
                    "\n" +
                    "@media all and (max-width: 601px) {\n" +
                    "\t#cv {\n" +
                    "\t\twidth: 95%;\n" +
                    "\t\tmargin: 10px auto;\n" +
                    "\t\tmin-width: 280px;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t#headshot {\n" +
                    "\t\tdisplay: none;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t#name, #contactDetails {\n" +
                    "\t\tfloat: none;\n" +
                    "\t\twidth: 100%;\n" +
                    "\t\ttext-align: center;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t.sectionTitle, .sectionContent {\n" +
                    "\t\tfloat: none;\n" +
                    "\t\twidth: 100%;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t.sectionTitle {\n" +
                    "\t\tmargin-left: -2px;\n" +
                    "\t\tfont-size: 1.25em;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t.keySkills {\n" +
                    "\t\t-moz-column-count:2;\n" +
                    "\t\t-webkit-column-count:2;\n" +
                    "\t\tcolumn-count:2;\n" +
                    "\t}\n" +
                    "}\n" +
                    "\n" +
                    "@media all and (max-width: 480px) {\n" +
                    "\t.mainDetails {\n" +
                    "\t\tpadding: 15px 15px;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\tsection {\n" +
                    "\t\tpadding: 15px 0 0;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t#mainArea {\n" +
                    "\t\tpadding: 0 25px;\n" +
                    "\t}\n" +
                    "\n" +
                    "\t\n" +
                    "\t.keySkills {\n" +
                    "\t-moz-column-count:1;\n" +
                    "\t-webkit-column-count:1;\n" +
                    "\tcolumn-count:1;\n" +
                    "\t}\n" +
                    "\t\n" +
                    "\t#name h1 {\n" +
                    "\t\tline-height: .8em;\n" +
                    "\t\tmargin-bottom: 4px;\n" +
                    "\t}\n" +
                    "}\n" +
                    "\n" +
                    "@media print {\n" +
                    "    #cv {\n" +
                    "        width: 100%;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "}</style>" +
                    "< link href = 'http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel = 'stylesheet' type = 'text/css' >" +
                    "</head >" +
                    "<body id = \"top\" >" +
                    "<div id = \"cv\" class=\"instaFade\" >" +
                    "<div class=\"mainDetails\" >" +
                    "<div id = \"name\" >" +
                    "<h1 class=\"quickFade delayTwo\" >" + personalInfo.getName() + "</h1>" +
                    "<h2 class=\"quickFade delayThree\">" + personalInfo.getJobTitle() + "</h2>" +
                    "</div>" +
                    "<div id=\"contactDetails\" class=\"quickFade delayFour\">\n" +
                    "\t\t\t<ul>\n" +
                    "\t\t\t\t<li>Email: <a href=\"mailto:" + personalInfo.getEmail() + "\" target=\"_blank\">" + personalInfo.getEmail() + "</a></li>\n" +
                    "\t\t\t\t<li>mobile: " + personalInfo.getPhone() + "</li>\n" +
                    "\t\t\t</ul>\n" +
                    "\t\t</div>\n" +
                    "\t\t<div class=\"clear\"></div>\n" +
                    "\t</div>" +
                    "<div id=\"mainArea\" class=\"quickFade delayFive\">\n" +
                    "<section>\n" +
                    "\t\t\t<div class=\"sectionTitle\">\n");
            if (!resume.skills.isEmpty()) {
                htmlContent.append("<section>\n" +
                        "\t\t\t<div class=\"sectionTitle\">\n" +
                        "\t\t\t\t<h1>Key Skills</h1>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t\t\n" +
                        "\t\t\t<div class=\"sectionContent\">\n" +
                        "\t\t\t\t<ul class=\"keySkills\">\n" +

                        "\t\t\t\t\t<li>" + resume.skills + "</li>\n" +
                        "\t\t\t\t</ul>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t\t<div class=\"clear\"></div>\n" +
                        "\t\t</section>");
            }
            if (!resume.languages.isEmpty()) {
                htmlContent.append("<section>" + "\n" +
                        "<div class=\"sectionTitle\">" + "\n" +
                        "<h1>Languages</h1>" + "\n" +
                        "</div>" + "\n" +
                        "\n" +
                        "<div class=\"sectionContent\">" + "\n" +
                        "<ul class=\"Languages\">" + "\n" +
                        "\n" +
                        "<li>" + resume.languages + "</li>" + "\n" +
                        "</ul>" + "\n" +
                        "</div>" + "\n" +
                        "<div class=\"clear\"></div>\n" +
                        "</section>");
            }
            if (!resume.schools.isEmpty()) {
                htmlContent.append("<section>\n" +
                        "\t\t\t<div class=\"sectionTitle\">\n" +
                        "\t\t\t\t<h1>Education</h1>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t\t\n" +
                        "\t\t\t<div class=\"sectionContent\">\n");
                for (School school : resume.schools) {
                    htmlContent.append("\t\t\t\t<article>\n" +
                            "\t\t\t\t\t<h2>" + school.getSchoolName() + "</h2>\n" +
                            "\t\t\t\t\t<p class=\"subDetails\">" + school.getDegree() + "</p>\n" +
                            "\t\t\t\t\t<p>" + school.getDescription() + "</p>\n" +
                            "\t\t\t\t</article>\n" +
                            "\t\t\t\t\n");
                }

                htmlContent.append("\t\t\t</div>\n" +
                        "\t\t\t<div class=\"clear\"></div>\n" +
                        "\t\t</section>"
                );
            }

            if (!resume.projects.isEmpty()) {
                htmlContent.append("<section>\n" +
                        "\t\t\t<div class=\"sectionTitle\">\n" +
                        "\t\t\t\t<h1>Projects</h1>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t\t\n" +
                        "\t\t\t<div class=\"sectionContent\">\n");
                for (Project project : resume.projects) {
                    htmlContent.append("\t\t\t\t<article>\n" +
                            "\t\t\t\t\t<h2>" + project.getName() + "</h2>\n" +
                            "\t\t\t\t\t<p>" + project.getDescription() + "</p>\n" +
                            "\t\t\t\t</article>\n" +
                            "\t\t\t\t\n");
                }

                htmlContent.append("\t\t\t</div>\n" +
                        "\t\t\t<div class=\"clear\"></div>\n" +
                        "\t\t</section>"
                );
            }
            if (resume.experience.size() != 0) {
                htmlContent.append("\t\t\t\t<h1>Work Experience</h1>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t\t\n" +
                        "\t\t\t<div class=\"sectionContent\">\n");
                for (Experience experience : resume.experience) {
                    htmlContent.append("\t\t\t\t<article>\n" +
                            "\t\t\t\t\t<h2>" + experience.getJobTitle() + " at " + experience.getCompany() + "(" + experience.getLocation() + ")" + "</h2>\n" +
                            "\t\t\t\t\t<p class=\"subDetails\">" + experience.getFromDate() + "-" + experience.getToDate() + "</p>\n" +
                            "\t\t\t\t\t<p>" + experience.getDescription() + "</p>\n" +
                            "\t\t\t\t</article>\n" +
                            "\t\t\t\t\n");

                }

                htmlContent.append("\t\t\t<div class=\"clear\"></div>\n" +
                        "\t\t</section>");


            }



            htmlContent.append("</div>\n" +
                    "</div>\n" +
                    "<script type=\"text/javascript\">\n" +
                    "var gaJsHost = ((\"https:\" == document.location.protocol) ? \"https://ssl.\" : \"http://www.\");\n" +
                    "document.write(unescape(\"%3Cscript src='\" + gaJsHost + \"google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E\"));\n" +
                    "</script>\n" +
                    "<script type=\"text/javascript\">\n" +
                    "var pageTracker = _gat._getTracker(\"UA-3753241-1\");\n" +
                    "pageTracker._initData();\n" +
                    "pageTracker._trackPageview();\n" +
                    "</script>\n" +
                    "</body>\n" +
                    "</html>");
        }
        webView.loadDataWithBaseURL(null, htmlContent.toString(), "text/html", "utf-8", null);

    }

    private void createWebPrintJob(WebView webView) {

        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) getActivity()
                .getSystemService(Context.PRINT_SERVICE);

        // Get a print adapter instance
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();

        // Create a print job with name and adapter instance
        String jobName = getString(R.string.app_name) + " Document";
        PrintJob printJob = printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());
    }
}
