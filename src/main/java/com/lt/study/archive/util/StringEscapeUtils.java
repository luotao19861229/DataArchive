package com.lt.study.archive.util;

/**
  * User: luotao
 * Date: 14-1-2
 * Time: 上午11:10
 * To change this template use File | Settings | File Templates.
 */


import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.BitSet;

/**
 * 字符串转义工具类，能将字符串转换成适应 Java、Java Script、HTML、XML、和SQL语句的形式。
 *
 */
public class StringEscapeUtils {

    /**
     * 按Java的规则对字符串进行转义。
     * <p>
     * 将双引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn't say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @return 转义后的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeJava(String value) {
        return escapeJavaStyleString(value, false, false);
    }

    /**
     * 按Java的规则对字符串进行转义。
     * <p>
     * 将双引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn't say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @param strict 是否以严格的方式编码字符串
     * @return 转义后的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeJava(String value, boolean strict) {
        return escapeJavaStyleString(value, false, strict);
    }

    /**
     * 按Java的规则对字符串进行转义。
     * <p>
     * 将双引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn't say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void escapeJava(String value, Writer out) throws IOException {
        escapeJavaStyleString(value, false, out, false);
    }

    /**
     * 按Java的规则对字符串进行转义。
     * <p>
     * 将双引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn't say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @param strict 是否以严格的方式编码字符串
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void escapeJava(String value, Writer out, boolean strict) throws IOException {
        escapeJavaStyleString(value, false, out, strict);
    }

    /**
     * 按JavaScript的规则对字符串进行转义。
     * <p>
     * 将双引号、单引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn\'t say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @return 转义后的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeJavaScript(String value) {
        return escapeJavaStyleString(value, true, false);
    }

    /**
     * 按JavaScript的规则对字符串进行转义。
     * <p>
     * 将双引号、单引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn\'t say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @param strict 是否以严格的方式编码字符串
     * @return 转义后的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeJavaScript(String value, boolean strict) {
        return escapeJavaStyleString(value, true, strict);
    }

    /**
     * 按JavaScript的规则对字符串进行转义。
     * <p>
     * 将双引号、单引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn\'t say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void escapeJavaScript(String value, Writer out) throws IOException {
        escapeJavaStyleString(value, true, out, false);
    }

    /**
     * 按JavaScript的规则对字符串进行转义。
     * <p>
     * 将双引号、单引号和控制字符转换成<code>'\\'</code>开头的形式，例如tab制表符将被转换成<code>\t</code>。
     * </p>
     * <p>
     * Java和JavaScript字符串的唯一差别是，JavaScript必须对单引号进行转义，而Java不需要。
     * </p>
     * <p>
     * 例如：字符串：<code>He didn't say, "Stop!"</code>被转换成<code>He didn\'t say, \"Stop!\"</code>
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @param strict 是否以严格的方式编码字符串
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void escapeJavaScript(String value, Writer out, boolean strict) throws IOException {
        escapeJavaStyleString(value, true, out, strict);
    }

    /**
     * 按Java或JavaScript的规则对字符串进行转义。
     *
     * @param value 要转义的字符串
     * @param escapeSingleQuotes 是否对单引号进行转义
     * @param strict 是否以严格的方式编码字符串
     * @return 转义后的字符串
     */
    private static String escapeJavaStyleString(String value, boolean escapeSingleQuotes, boolean strict) {
        if (value == null) {
            return null;
        }

        try {
            StringWriter out = new StringWriter(value.length() * 2);

            if (escapeJavaStyleString(value, escapeSingleQuotes, out, strict)) {
                return out.toString();
            }

            return value;
        } catch (IOException e) {
            return value; // StringWriter不可能发生这个异常
        }
    }

    /**
     * 按Java或JavaScript的规则对字符串进行转义。
     *
     * @param value 要转义的字符串
     * @param escapeSingleQuote 是否对单引号进行转义
     * @param out 输出流
     * @param strict 是否以严格的方式编码字符串
     * @return 如果字符串没有变化，则返回<code>false</code>
     */
    private static boolean escapeJavaStyleString(String value, boolean escapeSingleQuote, Writer out, boolean strict)
            throws IOException {
        boolean needToChange = false;

        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }

        if (value == null) {
            return needToChange;
        }

        int length = value.length();

        for (int i = 0; i < length; i++) {
            char ch = value.charAt(i);

            if (ch < 32) {
                switch (ch) {
                    case '\b':
                        out.write('\\');
                        out.write('b');
                        break;

                    case '\n':
                        out.write('\\');
                        out.write('n');
                        break;

                    case '\t':
                        out.write('\\');
                        out.write('t');
                        break;

                    case '\f':
                        out.write('\\');
                        out.write('f');
                        break;

                    case '\r':
                        out.write('\\');
                        out.write('r');
                        break;

                    default:

                        if (ch > 0xf) {
                            out.write("\\u00" + Integer.toHexString(ch).toUpperCase());
                        } else {
                            out.write("\\u000" + Integer.toHexString(ch).toUpperCase());
                        }

                        break;
                }

                // 设置改变标志
                needToChange = true;
            } else if (strict && (ch > 0xff)) {
                if (ch > 0xfff) {
                    out.write("\\u" + Integer.toHexString(ch).toUpperCase());
                } else {
                    out.write("\\u0" + Integer.toHexString(ch).toUpperCase());
                }

                // 设置改变标志
                needToChange = true;
            } else {
                switch (ch) {
                    case '\'':

                        if (escapeSingleQuote) {
                            out.write('\\');

                            // 设置改变标志
                            needToChange = true;
                        }

                        out.write('\'');

                        break;

                    case '"':
                        out.write('\\');
                        out.write('"');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case '\\':
                        out.write('\\');
                        out.write('\\');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    default:
                        out.write(ch);
                        break;
                }
            }
        }

        return needToChange;
    }

    /**
     * 按Java的规则对字符串进行反向转义。
     * <p>
     * <code>'\\'</code>开头的形式转换成相应的字符，例如<code>\t</code>将被转换成tab制表符
     * </p>
     * <p>
     * 如果转义符不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 不包含转义字符的字符串
     * @return 恢复成未转义的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String unescapeJava(String value) {
        return unescapeJavaStyleString(value);
    }

    /**
     * 按Java的规则对字符串进行反向转义。
     * <p>
     * <code>'\\'</code>开头的形式转换成相应的字符，例如<code>\t</code>将被转换成tab制表符
     * </p>
     * <p>
     * 如果转义符不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 包含转义字符的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void unescapeJava(String value, Writer out) throws IOException {
        unescapeJavaStyleString(value, out);
    }

    /**
     * 按JavaScript的规则对字符串进行反向转义。
     * <p>
     * <code>'\\'</code>开头的形式转换成相应的字符，例如<code>\t</code>将被转换成tab制表符
     * </p>
     * <p>
     * 如果转义符不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 包含转义字符的字符串
     * @return 恢复成未转义的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String unescapeJavaScript(String value) {
        return unescapeJavaStyleString(value);
    }

    /**
     * 按Java的规则对字符串进行反向转义。
     * <p>
     * <code>'\\'</code>开头的形式转换成相应的字符，例如<code>\t</code>将被转换成tab制表符
     * </p>
     * <p>
     * 如果转义符不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 包含转义字符的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void unescapeJavaScript(String value, Writer out) throws IOException {
        unescapeJavaStyleString(value, out);
    }

    /**
     * 按Java的规则对字符串进行反向转义。
     * <p>
     * <code>'\\'</code>开头的形式转换成相应的字符，例如<code>\t</code>将被转换成tab制表符
     * </p>
     * <p>
     * 如果转义符不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 包含转义字符的字符串
     * @return 不包含转义字符的字符串
     */
    private static String unescapeJavaStyleString(String value) {
        if (value == null) {
            return null;
        }

        try {
            StringWriter out = new StringWriter(value.length());

            if (unescapeJavaStyleString(value, out)) {
                return out.toString();
            }

            return value;
        } catch (IOException e) {
            return value; // StringWriter不可能发生这个异常
        }
    }

    /**
     * 按Java的规则对字符串进行反向转义。
     * <p>
     * <code>'\\'</code>开头的形式转换成相应的字符，例如<code>\t</code>将被转换成tab制表符
     * </p>
     * <p>
     * 如果转义符不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 包含转义字符的字符串
     * @param out 输出流
     * @return 如果字符串没有变化，则返回<code>false</code>
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    private static boolean unescapeJavaStyleString(String value, Writer out) throws IOException {
        boolean needToChange = false;

        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }

        if (value == null) {
            return needToChange;
        }

        int length = value.length();
        StringBuffer unicode = new StringBuffer(4);
        boolean hadSlash = false;
        boolean inUnicode = false;

        for (int i = 0; i < length; i++) {
            char ch = value.charAt(i);

            if (inUnicode) {
                unicode.append(ch);

                if (unicode.length() == 4) {
                    String unicodeStr = unicode.toString();

                    try {
                        int value1 = Integer.parseInt(unicodeStr, 16);

                        out.write((char) value1);
                        unicode.setLength(0);
                        inUnicode = false;
                        hadSlash = false;

                        // 设置改变标志
                        needToChange = true;
                    } catch (NumberFormatException e) {
                        out.write("\\u" + unicodeStr);
                    }
                }

                continue;
            }

            if (hadSlash) {
                hadSlash = false;

                switch (ch) {
                    case '\\':
                        out.write('\\');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case '\'':
                        out.write('\'');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case '\"':
                        out.write('"');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case 'r':
                        out.write('\r');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case 'f':
                        out.write('\f');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case 't':
                        out.write('\t');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case 'n':
                        out.write('\n');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case 'b':
                        out.write('\b');

                        // 设置改变标志
                        needToChange = true;
                        break;

                    case 'u': {
                        inUnicode = true;
                        break;
                    }

                    default:
                        out.write(ch);
                        break;
                }

                continue;
            } else if (ch == '\\') {
                hadSlash = true;
                continue;
            }

            out.write(ch);
        }

        if (hadSlash) {
            out.write('\\');
        }

        return needToChange;
    }


    /**
     * 根据HTML的规则，将字符串中的部分字符转换成实体编码。
     * <p>
     * 例如：<code>"bread" & "butter"</code>将被转换成<tt>&amp;quot;bread&amp;quot; &amp;amp;
     * &amp;quot;butter&amp;quot;</tt>.
     * </p>
     * <p>
     * 支持所有HTML 4.0 entities。
     * </p>
     *
     * @param value 要转义的字符串
     * @return 用实体编码转义的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     * @see <a href="http://hotwired.lycos.com/webmonkey/reference/special_characters/">ISO Entities</a>
     * @see <a href="http://www.w3.org/TR/REC-html32#latin1">HTML 3.2 Character Entities for ISO Latin-1</a>
     * @see <a href="http://www.w3.org/TR/REC-html40/sgml/entities.html">HTML 4.0 Character entity references</a>
     * @see <a href="http://www.w3.org/TR/html401/charset.html#h-5.3">HTML 4.01 Character References</a>
     * @see <a href="http://www.w3.org/TR/html401/charset.html#code-position">HTML 4.01 Code positions</a>
     */
    public static String escapeHtml(String value) {
        return escapeEntities(Entities.HTML40, value);
    }

    /**
     * 组合cookie的转义
     * @param value 要转义的字符串
     * @return 用实体编码转义的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeCombinedCookie(String value) {
        return escapeEntities(Entities.COMBINED_COOKIE, value);
    }

    /**
     *  组合cookie反转义
     * @param value
     * @return 用实体编码转义的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     */
    public static String unescapeCombinedCookie(String value) {
        return unescapeEntities(Entities.COMBINED_COOKIE, value);
    }


    /**
     * 根据HTML的规则，将字符串中的部分字符转换成实体编码。
     * <p>
     * 例如：<code>"bread" & "butter"</code>将被转换成<tt>&amp;quot;bread&amp;quot; &amp;amp;
     * &amp;quot;butter&amp;quot;</tt>.
     * </p>
     * <p>
     * 支持所有HTML 4.0 entities。
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     * @see <a href="http://hotwired.lycos.com/webmonkey/reference/special_characters/">ISO Entities</a>
     * @see <a href="http://www.w3.org/TR/REC-html32#latin1">HTML 3.2 Character Entities for ISO Latin-1</a>
     * @see <a href="http://www.w3.org/TR/REC-html40/sgml/entities.html">HTML 4.0 Character entity references</a>
     * @see <a href="http://www.w3.org/TR/html401/charset.html#h-5.3">HTML 4.01 Character References</a>
     * @see <a href="http://www.w3.org/TR/html401/charset.html#code-position">HTML 4.01 Code positions</a>
     */
    public static void escapeHtml(String value, Writer out) throws IOException {
        escapeEntities(Entities.HTML40, value, out);
    }

    /**
     * 根据XML的规则，将字符串中的部分字符转换成实体编码。
     * <p>
     * 例如：<code>"bread" & "butter"</code>将被转换成<tt>&amp;quot;bread&amp;quot; &amp;amp;
     * &amp;quot;butter&amp;quot;</tt>.
     * </p>
     * <p>
     * 只转换4种基本的XML实体：<code>gt</code>、<code>lt</code>、<code>quot</code>和<code>amp</code>。 不支持DTD或外部实体。
     * </p>
     *
     * @param value 要转义的字符串
     * @return 用实体编码转义的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeXml(String value) {
        return escapeEntities(Entities.XML, value);
    }

    /**
     * 根据XML的规则，将字符串中的部分字符转换成实体编码。
     * <p>
     * 例如：<code>"bread" & "butter"</code>将被转换成<tt>&amp;quot;bread&amp;quot; &amp;amp;
     * &amp;quot;butter&amp;quot;</tt>.
     * </p>
     * <p>
     * 只转换4种基本的XML实体：<code>gt</code>、<code>lt</code>、<code>quot</code>和<code>amp</code>。 不支持DTD或外部实体。
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void escapeXml(String value, Writer out) throws IOException {
        escapeEntities(Entities.XML, value, out);
    }

    /**
     * 根据指定的规则，将字符串中的部分字符转换成实体编码。
     *
     * @param entities 实体集合
     * @param value 要转义的字符串
     * @return 用实体编码转义的字符串，如果原字串为<code>null</code>，则返回<code>null</code>
     */
    public static String escapeEntities(Entities entities, String value) {
        if (value == null) {
            return null;
        }

        try {
            StringWriter out = new StringWriter(value.length());

            if (escapeEntitiesInternal(entities, value, out)) {
                return out.toString();
            }

            return value;
        } catch (IOException e) {
            return value; // StringWriter不可能发生这个异常
        }
    }

    /**
     * 根据指定的规则，将字符串中的部分字符转换成实体编码。
     *
     * @param entities 实体集合
     * @param value 要转义的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void escapeEntities(Entities entities, String value, Writer out) throws IOException {
        escapeEntitiesInternal(entities, value, out);
    }

    /**
     * 按HTML的规则对字符串进行反向转义，支持HTML 4.0中的所有实体，以及unicode实体如<code>&amp;#12345;</code>。
     * <p>
     * 例如："&amp;lt;Fran&amp;ccedil;ais&amp;gt;"将被转换成"&lt;Fran&ccedil;ais&gt;"
     * </p>
     * <p>
     * 如果实体不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 不包含转义字符的字符串
     * @return 恢复成未转义的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String unescapeHtml(String value) {
        return unescapeEntities(Entities.HTML40, value);
    }

    /**
     * 按HTML的规则对字符串进行反向转义，支持HTML 4.0中的所有实体，以及unicode实体如<code>&amp;#12345;</code>。
     * <p>
     * 例如："&amp;lt;Fran&amp;ccedil;ais&amp;gt;"将被转换成"&lt;Fran&ccedil;ais&gt;"
     * </p>
     * <p>
     * 如果实体不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 包含转义字符的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void unescapeHtml(String value, Writer out) throws IOException {
        unescapeEntities(Entities.HTML40, value, out);
    }

    /**
     * 按XML的规则对字符串进行反向转义，支持unicode实体如<code>&amp;#12345;</code>。
     * <p>
     * 例如："&amp;lt;Fran&amp;ccedil;ais&amp;gt;"将被转换成"&lt;Fran&ccedil;ais&gt;"
     * </p>
     * <p>
     * 如果实体不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 不包含转义字符的字符串
     * @return 恢复成未转义的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String unescapeXml(String value) {
        return unescapeEntities(Entities.XML, value);
    }

    /**
     * 按XML的规则对字符串进行反向转义，支持unicode实体如<code>&amp;#12345;</code>。
     * <p>
     * 例如："&amp;lt;Fran&amp;ccedil;ais&amp;gt;"将被转换成"&lt;Fran&ccedil;ais&gt;"
     * </p>
     * <p>
     * 如果实体不能被识别，它将被保留不变。
     * </p>
     *
     * @param value 不包含转义字符的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void unescapeXml(String value, Writer out) throws IOException {
        unescapeEntities(Entities.XML, value, out);
    }

    /**
     * 按指定的规则对字符串进行反向转义。
     *
     * @param entities 实体集合
     * @param value 不包含转义字符的字符串
     * @return 恢复成未转义的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     */
    public static String unescapeEntities(Entities entities, String value) {
        if (value == null) {
            return null;
        }

        try {
            StringWriter out = new StringWriter(value.length());

            if (unescapeEntitiesInternal(entities, value, out)) {
                return out.toString();
            }

            return value;
        } catch (IOException e) {
            return value; // StringWriter不可能发生这个异常
        }
    }

    /**
     * 按指定的规则对字符串进行反向转义。
     * <p>
     * 如果实体不能被识别，它将被保留不变。
     * </p>
     *
     * @param entities 实体集合
     * @param value 不包含转义字符的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    public static void unescapeEntities(Entities entities, String value, Writer out) throws IOException {
        unescapeEntitiesInternal(entities, value, out);
    }

    /**
     * 将字符串中的部分字符转换成实体编码。
     *
     * @param entities 实体集合
     * @param value 要转义的字符串
     * @param out 字符输出流，不能为<code>null</code>
     * @return 如果字符串没有变化，则返回<code>false</code>
     * @throws IllegalArgumentException 如果<code>entities</code>或输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    private static boolean escapeEntitiesInternal(Entities entities, String value, Writer out) throws IOException {
        boolean needChange = false;

        if (entities == null) {
            throw new IllegalArgumentException("The Entities must not be null");
        }

        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }

        if (value == null) {
            return needChange;
        }

        for (int i = 0; i < value.length(); ++i) {
            char ch = value.charAt(i);
            String entityName = entities.getEntityName(ch);

            if (entityName == null) {
                out.write(ch);
            } else {
                out.write('&');
                out.write(entityName);
                out.write(';');

                // 设置改变标志
                needChange = true;
            }
        }

        return needChange;
    }

    /**
     * 将字符串中的已定义实体和unicode实体如<code>&amp;#12345;</code>转换成相应的unicode字符。
     * <p>
     * 未定义的实体将保留不变。
     * </p>
     *
     * @param entities 实体集合，如果为<code>null</code>，则只转换<code>&amp;#number</code>实体。
     * @param value 包含转义字符的字符串
     * @param out 字符输出流，不能为<code>null</code>
     * @return 如果字符串没有变化，则返回<code>false</code>
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     */
    private static boolean unescapeEntitiesInternal(Entities entities, String value, Writer out) throws IOException {
        boolean needToChange = false;

        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }

        if (value == null) {
            return needToChange;
        }

        for (int i = 0; i < value.length(); ++i) {
            char ch = value.charAt(i);

            if (ch == '&') {
                // 查找&xxxx;
                int semi = value.indexOf(';', i + 1);

                if ((semi == -1) || ((i + 1) >= (semi - 1))) {
                    out.write(ch);
                    continue;
                }

                // 如果是&#xxxxx;
                if (value.charAt(i + 1) == '#') {
                    int firstCharIndex = i + 2;
                    int radix = 10;

                    if ((firstCharIndex) >= (semi - 1)) {
                        out.write(ch);
                        out.write('#');
                        i++;
                        continue;
                    }

                    char firstChar = value.charAt(firstCharIndex);

                    if (firstChar == 'x' || firstChar == 'X') {
                        firstCharIndex++;
                        radix = 16;

                        if ((firstCharIndex) >= (semi - 1)) {
                            out.write(ch);
                            out.write('#');
                            i++;
                            continue;
                        }
                    }

                    try {
                        int entityValue = Integer.parseInt(value.substring(firstCharIndex, semi), radix);

                        out.write(entityValue);

                        // 设置改变标志
                        needToChange = true;
                    } catch (NumberFormatException e) {
                        out.write(ch);
                        out.write('#');
                        i++;
                        continue;
                    }
                } else {
                    String entityName = value.substring(i + 1, semi);
                    int entityValue = -1;

                    if (entities != null) {
                        entityValue = entities.getEntityValue(entityName);
                    }

                    if (entityValue == -1) {
                        out.write('&');
                        out.write(entityName);
                        out.write(';');
                    } else {
                        out.write(entityValue);

                        // 设置改变标志
                        needToChange = true;
                    }
                }

                i = semi;
            } else {
                out.write(ch);
            }
        }

        return needToChange;
    }


    /**
     * 按SQL语句的规则对字符串进行转义。
     * <p>
     * 例如：
     *
     * <pre>
     * statement.executeQuery(&quot;SELECT * FROM MOVIES WHERE TITLE='&quot; + StringEscapeUtil.escapeSql(&quot;McHale's Navy&quot;) + &quot;'&quot;);
     * </pre>
     *
     * </p>
     * <p>
     * 目前，此方法只将单引号转换成两个单引号：<code>"McHale's Navy"</code>转换成<code>"McHale''s
     * Navy"</code>。不处理字符串中包含的<code>%</code>和<code>_</code>字符。
     * </p>
     *
     * @param value 要转义的字符串
     * @return 转义后的字符串，如果原字符串为<code>null</code>，则返回<code>null</code>
     * @see <a href="http://www.jguru.com/faq/view.jsp?EID=8881">faq</a>
     */
    public static String escapeSql(String value) {
        return StringUtils.replace(value, "'", "''");
    }

    /**
     * 按SQL语句的规则对字符串进行转义。
     * <p>
     * 例如：
     *
     * <pre>
     * statement.executeQuery(&quot;SELECT * FROM MOVIES WHERE TITLE='&quot; + StringEscapeUtil.escapeSql(&quot;McHale's Navy&quot;) + &quot;'&quot;);
     * </pre>
     *
     * </p>
     * <p>
     * 目前，此方法只将单引号转换成两个单引号：<code>"McHale's Navy"</code>转换成<code>"McHale''s
     * Navy"</code>。不处理字符串中包含的<code>%</code>和<code>_</code>字符。
     * </p>
     *
     * @param value 要转义的字符串
     * @param out 输出流
     * @throws IllegalArgumentException 如果输出流为<code>null</code>
     * @throws IOException 如果输出失败
     * @see <a href="http://www.jguru.com/faq/view.jsp?EID=8881">faq</a>
     */
    public static void escapeSql(String value, Writer out) throws IOException {

        String result = StringUtils.replace(value, "'", "''");

        if (result != null) {
            out.write(result);
        }
    }


    /** "Alpha" characters from RFC 2396. */
    private static final BitSet ALPHA       = new BitSet(256);

    static {
        for (int i = 'a'; i <= 'z'; i++) {
            ALPHA.set(i);
        }

        for (int i = 'A'; i <= 'Z'; i++) {
            ALPHA.set(i);
        }
    }

    /** "Alphanum" characters from RFC 2396. */
    private static final BitSet ALPHANUM    = new BitSet(256);

    static {
        ALPHANUM.or(ALPHA);

        for (int i = '0'; i <= '9'; i++) {
            ALPHANUM.set(i);
        }
    }

    /** "Mark" characters from RFC 2396. */
    private static final BitSet MARK        = new BitSet(256);

    static {
        MARK.set('-');
        MARK.set('_');
        MARK.set('.');
        MARK.set('!');
        MARK.set('~');
        MARK.set('*');
        MARK.set('\'');
        MARK.set('(');
        MARK.set(')');
    }

    /** "Reserved" characters from RFC 2396. */
    private static final BitSet RESERVED    = new BitSet(256);

    static {
        RESERVED.set(';');
        RESERVED.set('/');
        RESERVED.set('?');
        RESERVED.set(':');
        RESERVED.set('@');
        RESERVED.set('&');
        RESERVED.set('=');
        RESERVED.set('+');
        RESERVED.set('$');
        RESERVED.set(',');
    }

    /** "Unreserved" characters from RFC 2396. */
    private static final BitSet UNRESERVED  = new BitSet(256);

    static {
        UNRESERVED.or(ALPHANUM);
        UNRESERVED.or(MARK);
    }

    /** 将一个数字转换成16进制的转换表。 */
    private static int[]        HEXADECIMAL = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F'                       };

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     * <p>
     * 除了RFC2396中的<code>unreserved</code>字符之外的所有字符，都将被转换成URL编码<code>%xx</code>。 根据RFC2396，<code>unreserved</code>的定义如下：
     *
     * <pre>
     * &lt;![CDATA
     *  unreserved  = alphanum | mark
     *  alphanum    = 大小写英文字母 | 数字
     *  mark        = &quot;-&quot; | &quot;_&quot; | &quot;.&quot; | &quot;!&quot; | &quot;&tilde;&quot; | &quot;*&quot; | &quot;'&quot; | &quot;(&quot; | &quot;)&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 警告：该方法使用当前线程默认的字符编码来编码URL，因此该方法在不同的上下文中可能会产生不同的结果。
     * </p>
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @return URL编码后的字符串
     */
    public static String escapeURL(String value) {
        try {
            return escapeURLInternal(value, null, true);
        } catch (UnsupportedEncodingException e) {
            return value; // 不可能发生这个异常
        }
    }

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     * <p>
     * 除了RFC2396中的<code>unreserved</code>字符之外的所有字符，都将被转换成URL编码<code>%xx</code>。 根据RFC2396，<code>unreserved</code>的定义如下：
     *
     * <pre>
     * &lt;![CDATA
     *  unreserved  = alphanum | mark
     *  alphanum    = 大小写英文字母 | 数字
     *  mark        = &quot;-&quot; | &quot;_&quot; | &quot;.&quot; | &quot;!&quot; | &quot;&tilde;&quot; | &quot;*&quot; | &quot;'&quot; | &quot;(&quot; | &quot;)&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 该方法使用指定的字符编码来编码URL。
     * </p>
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @return URL编码后的字符串
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     */
    public static String escapeURL(String value, String encoding) throws UnsupportedEncodingException {
        return escapeURLInternal(value, encoding, true);
    }

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     * <p>
     * 如果指定参数<code>strict</code>为<code>true</code>，则按严格的方式编码URL。 除了RFC2396中的<code>unreserved</code>字符之外的所有字符，都将被转换成URL编码<code>%xx</code>。
     * 根据RFC2396，<code>unreserved</code>的定义如下：
     *
     * <pre>
     * &lt;![CDATA
     *  unreserved  = alphanum | mark
     *  alphanum    = 大小写英文字母 | 数字
     *  mark        = &quot;-&quot; | &quot;_&quot; | &quot;.&quot; | &quot;!&quot; | &quot;&tilde;&quot; | &quot;*&quot; | &quot;'&quot; | &quot;(&quot; | &quot;)&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 如果指定参数<code>strict</code>为<code>false</code>，则使用宽松的方式编码URL。 除了控制字符、空白字符以及RFC2396中的<code>reserved</code>字符之外的所有字符，都将被保留不变。
     * 根据RFC2396，只有控制字符、空白字符以及符合下列<code>reserved</code>定义的字符才被转换成<code>%xx</code>格式：
     *
     * <pre>
     * &lt;![CDATA
     *  reserved      = &quot;;&quot; | &quot;/&quot; | &quot;?&quot; | &quot;:&quot; | &quot;@&quot; | &quot;&amp;&quot; | &quot;=&quot; | &quot;+&quot; | &quot;$&quot; | &quot;,&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 该方法使用指定的字符编码来编码URL。
     * </p>
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用当前线程默认的编码
     * @param strict 是否以严格的方式编码URL
     * @return URL编码后的字符串
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     */
    public static String escapeURL(String value, String encoding, boolean strict) throws UnsupportedEncodingException {
        return escapeURLInternal(value, encoding, strict);
    }

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     * <p>
     * 除了RFC2396中的<code>unreserved</code>字符之外的所有字符，都将被转换成URL编码<code>%xx</code>。 根据RFC2396，<code>unreserved</code>的定义如下：
     *
     * <pre>
     * &lt;![CDATA
     *  unreserved  = alphanum | mark
     *  alphanum    = 大小写英文字母 | 数字
     *  mark        = &quot;-&quot; | &quot;_&quot; | &quot;.&quot; | &quot;!&quot; | &quot;&tilde;&quot; | &quot;*&quot; | &quot;'&quot; | &quot;(&quot; | &quot;)&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 该方法使用指定的字符编码来编码URL。
     * </p>
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @param out 输出到指定字符流
     * @throws IOException 如果输出到<code>out</code>失败
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     * @throws IllegalArgumentException <code>out</code>为<code>null</code>
     */
    public static void escapeURL(String value, String encoding, Writer out) throws IOException {
        escapeURLInternal(value, encoding, out, true);
    }

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     * <p>
     * 如果指定参数<code>strict</code>为<code>true</code>，则按严格的方式编码URL。 除了RFC2396中的<code>unreserved</code>字符之外的所有字符，都将被转换成URL编码<code>%xx</code>。
     * 根据RFC2396，<code>unreserved</code>的定义如下：
     *
     * <pre>
     * &lt;![CDATA
     *  unreserved  = alphanum | mark
     *  alphanum    = 大小写英文字母 | 数字
     *  mark        = &quot;-&quot; | &quot;_&quot; | &quot;.&quot; | &quot;!&quot; | &quot;&tilde;&quot; | &quot;*&quot; | &quot;'&quot; | &quot;(&quot; | &quot;)&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 如果指定参数<code>strict</code>为<code>false</code>，则使用宽松的方式编码URL。 除了控制字符、空白字符以及RFC2396中的<code>reserved</code>字符之外的所有字符，都将被保留不变。
     * 根据RFC2396，只有控制字符、空白字符以及符合下列<code>reserved</code>定义的字符才被转换成<code>%xx</code>格式：
     *
     * <pre>
     * &lt;![CDATA
     *  reserved      = &quot;;&quot; | &quot;/&quot; | &quot;?&quot; | &quot;:&quot; | &quot;@&quot; | &quot;&amp;&quot; | &quot;=&quot; | &quot;+&quot; | &quot;$&quot; | &quot;,&quot;
     * ]]&gt;
     * </pre>
     *
     * </p>
     * <p>
     * 该方法使用指定的字符编码来编码URL。
     * </p>
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @param out 输出到指定字符流
     * @param strict 是否以严格的方式编码URL
     * @throws IOException 如果输出到<code>out</code>失败
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     * @throws IllegalArgumentException <code>out</code>为<code>null</code>
     */
    public static void escapeURL(String value, String encoding, Writer out, boolean strict) throws IOException {
        escapeURLInternal(value, encoding, out, strict);
    }

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @param strict 是否以严格的方式编码URL
     * @return URL编码后的字符串
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     */
    private static String escapeURLInternal(String value, String encoding, boolean strict)
            throws UnsupportedEncodingException {
        if (value == null) {
            return null;
        }

        try {
            StringWriter out = new StringWriter(value.length());

            if (escapeURLInternal(value, encoding, out, strict)) {
                return out.toString();
            }

            return value;
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (IOException e) {
            return value; // StringWriter不可能发生这个异常
        }
    }

    /**
     * 将指定字符串编码成<code>application/x-www-form-urlencoded</code>格式。
     *
     * @param value 要编码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @param strict 是否以严格的方式编码URL
     * @param out 输出流
     * @return 如果字符串被改变，则返回<code>true</code>
     * @throws IOException 如果输出到<code>out</code>失败
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     * @throws IllegalArgumentException <code>out</code>为<code>null</code>
     */
    private static boolean escapeURLInternal(String value, String encoding, Writer out, boolean strict)
            throws IOException {
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }

        boolean needToChange = false;

        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }

        if (value == null) {
            return needToChange;
        }

        // 用来将字符=>字节的临时空间，长度为10足矣。
        ByteArrayOutputStream baos = new ByteArrayOutputStream(10);
        OutputStreamWriter writer = new OutputStreamWriter(baos, encoding);

        for (int i = 0; i < value.length(); i++) {
            int ch = value.charAt(i);

            if (isSafeCharacter(ch, strict)) {
                // “安全”的字符，直接输出
                out.write(ch);
            } else if (ch == ' ') {
                // 特殊情况：空格（0x20）转换成'+'
                out.write('+');

                // 设置改变标志
                needToChange = true;
            } else {
                // 对ch进行URL编码。
                // 首先按指定encoding取得该字符的字节码。
                try {
                    writer.write(ch);
                    writer.flush();
                } catch (IOException e) {
                    baos.reset();
                    continue;
                }

                byte[] bytes = baos.toByteArray();

                for (int j = 0; j < bytes.length; j++) {
                    byte toEscape = bytes[j];

                    out.write('%');

                    int low = (toEscape & 0x0F);
                    int high = (toEscape & 0xF0) >> 4;

                    out.write(HEXADECIMAL[high]);
                    out.write(HEXADECIMAL[low]);
                }

                baos.reset();

                // 设置改变标志
                needToChange = true;
            }
        }

        return needToChange;
    }

    /**
     * 判断指定字符是否是“安全”的，这个字符将不被转换成URL编码。
     *
     * @param ch 要判断的字符
     * @param strict 是否以严格的方式编码
     * @return 如果是“安全”的，则返回<code>true</code>
     */
    private static boolean isSafeCharacter(int ch, boolean strict) {
        if (strict) {
            return UNRESERVED.get(ch);
        } else {
            return (ch > ' ') && !RESERVED.get(ch) && !Character.isWhitespace((char) ch);
        }
    }

    /**
     * 解码<code>application/x-www-form-urlencoded</code>格式的字符串。
     * <p>
     * 警告：该方法使用系统字符编码来解码URL，因此该方法在不同的系统中可能会产生不同的结果。
     * </p>
     *
     * @param value 要解码的字符串，可以是<code>null</code>
     * @return URL解码后的字符串
     */
    public static String unescapeURL(String value) {
        try {
            return unescapeURLInternal(value, null);
        } catch (UnsupportedEncodingException e) {
            return value; // 不可能发生这个异常
        }
    }

    /**
     * 解码<code>application/x-www-form-urlencoded</code>格式的字符串。
     *
     * @param value 要解码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @return URL解码后的字符串
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     */
    public static String unescapeURL(String value, String encoding) throws UnsupportedEncodingException {
        return unescapeURLInternal(value, encoding);
    }

    /**
     * 解码<code>application/x-www-form-urlencoded</code>格式的字符串。
     *
     * @param value 要解码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @param out 输出流
     * @throws IOException 如果输出到<code>out</code>失败
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     * @throws IllegalArgumentException <code>out</code>为<code>null</code>
     */
    public static void unescapeURL(String value, String encoding, Writer out) throws IOException {
        unescapeURLInternal(value, encoding, out);
    }

    /**
     * 解码<code>application/x-www-form-urlencoded</code>格式的字符串。
     *
     * @param value 要解码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @return URL解码后的字符串
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     */
    private static String unescapeURLInternal(String value, String encoding) throws UnsupportedEncodingException {
        if (value == null) {
            return null;
        }

        try {
            StringWriter out = new StringWriter(value.length());

            if (unescapeURLInternal(value, encoding, out)) {
                return out.toString();
            }

            return value;
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (IOException e) {
            return value; // StringWriter不可能发生这个异常
        }
    }

    /**
     * 解码<code>application/x-www-form-urlencoded</code>格式的字符串。
     *
     * @param value 要解码的字符串，可以是<code>null</code>
     * @param encoding 输出字符编码，如果为<code>null</code>，则使用系统默认编码
     * @param out 输出流
     * @return 如果字符串被改变，则返回<code>true</code>
     * @throws IOException 如果输出到<code>out</code>失败
     * @throws UnsupportedEncodingException 如果指定的<code>encoding</code>为非法的
     * @throws IllegalArgumentException <code>out</code>为<code>null</code>
     */
    private static boolean unescapeURLInternal(String value, String encoding, Writer out) throws IOException {
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }

        boolean needChange = false;

        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        }

        int length = value.length();
        byte[] buffer = null;
        int pos = 0;

        for (int i = 0; i < length; i++) {
            int ch = value.charAt(i);

            if (ch < 256) {
                // 读取连续的字节，并将它按指定编码转换成字符。
                if (buffer == null) {
                    buffer = new byte[length - i]; // 最长只需要length - i
                }

                switch (ch) {
                    case '+':

                        // 将'+'转换成' '
                        buffer[pos++] = ' ';

                        // 设置改变标志
                        needChange = true;
                        break;

                    case '%':

                        if ((i + 2) < length) {
                            try {
                                buffer[pos] = (byte) Integer.parseInt(value.substring(i + 1, i + 3), 16);
                                pos++;
                                i += 2;

                                // 设置改变标志
                                needChange = true;
                            } catch (NumberFormatException e) {
                                // 如果%xx不是合法的16进制数，则原样输出
                                buffer[pos++] = (byte) ch;
                            }
                        } else {
                            buffer[pos++] = (byte) ch;
                        }

                        break;

                    default:

                        // 写到bytes中，到时一起输出。
                        buffer[pos++] = (byte) ch;
                        break;
                }
            } else {
                // 先将buffer中的字节串转换成字符串。
                if (pos > 0) {
                    out.write(new String(buffer, 0, pos, encoding));
                    pos = 0;
                }

                // 如果ch是ISO-8859-1以外的字符，直接输出即可
                out.write(ch);
            }
        }

        // 先将buffer中的字节串转换成字符串。
        if (pos > 0) {
            out.write(new String(buffer, 0, pos, encoding));
            pos = 0;
        }

        return needChange;
    }
}

