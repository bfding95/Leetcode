package string;

import java.util.*;

/**
 * date 2021/10/8
 * problem：https://leetcode.com/problems/subdomain-visit-count/
 */

/*
    Solution: 1. hashmap for counting
    tips: String[] domains = strs[1].split("\\.");
    Java 的正则表达式在匹配点(.)  和斜杠(\)，表达式要分别写作 \\. 和 \\\\，难看些，不好理解。幸好还有些人记住了，
    匹配点(.) 或  {、[、(、?、$、^ 和 * 这些特殊符号要要前加双斜框，匹配 \ 时要用四斜杠

    那为什么是双斜杠呢？这个很简单，因为点号(.)，是个特殊字符，所以它前面需要需要加个斜杠给它转义，你要真只用一个斜杠来转义，问题就来了，提示你：
    Invalid escape sequence (valid ones are \b \t \n \f \r \" \' \\)，也就是 Java 不认 \. 序列，所以还需要前面再加一道杠给其后的斜杠转义出一个斜杠给点号(.) 用，
    也就是在 Java 字符串看起来是 “\\.”, 但作为正则表达式来说就是 “\.”，这于其语言的正则表达式是一致的。
 */
public class subDomainVisitCount_811 {

    public List<String> subdomainVisits(String[] cpdomains) {

        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            String[] strs = cpdomain.split(" ");
            int times = Integer.parseInt(strs[0]);

            String[] domains = strs[1].split("\\.");
            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                domain = domains[i] + (i == domains.length - 1 ? "" : ".") + domain;
                map.put(domain, map.getOrDefault(domain, 0) + times);
            }
        }

        for (String domain : map.keySet()) {
            res.add(String.valueOf(map.get(domain)) + " " + domain);
        }

        return res;
    }
}
