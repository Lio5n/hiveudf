package com.wanggs;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

@Description(
        name = "SayHello",
        value = "_FUNC_(input_str) - returns Hello:input",
        extended = "Example:\n"
                + "> SELECT _FUNC_('zhangsan') FROM src LIMIT 1;\n"
                + "Hello:zhangsan'"
)

//继承 UDF 类
public class HelloUDF extends UDF {
    //重写 evaluate 方法
    private Text evaluate(Text input) {
        return new Text("Hello:" + input);
    }

    public static void main(String[] args) {
        HelloUDF UDF = new HelloUDF();
        System.out.println(UDF.evaluate(new Text("WangGS")));
    }
}
