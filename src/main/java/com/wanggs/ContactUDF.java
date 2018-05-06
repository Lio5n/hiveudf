package com.wanggs;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

@Description(
        name = "ContactUDF",
        value = "_FUNC_(input_str...) - returns str1.str2...",
        extended = "Example:\n"
                + "> SELECT _FUNC_('Hello','ZhangS','LiS') FROM src LIMIT 1;\n"
                + "Hello.ZhangS.LiS'"
)

public class ContactUDF extends UDF {
    private StringBuffer rst = new StringBuffer();

    private String evaluate(String... input) {
        for (String item : input) {
            rst = rst.append(".").append(item);
        }
        return rst.substring(1);
    }

    public static void main(String[] args) {
        ContactUDF UDF = new ContactUDF();
        System.out.println(UDF.evaluate("hello", "WangGS", "SongSG"));
    }
}
