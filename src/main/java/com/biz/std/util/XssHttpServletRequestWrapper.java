package com.biz.std.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {


    XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (values != null){
            for (int i  = 0;i<values.length;i++){
                values[i] = xssEncode(values[i]);
            }
        }
        return values;
    }

    /**
     * 将容易引起xss漏洞的半角字符直接替换成全角字符
     */
    private static String xssEncode(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '>':
                    sb.append('＞');
                    break;
                case '<':
                    sb.append("＜");
                    break;
                case '\'':
                    sb.append("＇");
                    break;
                case '"':
                    sb.append("＂");
                    break;
                case '&':
                    sb.append("＆");
                    break;
                case '/':
                    sb.append("／");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
