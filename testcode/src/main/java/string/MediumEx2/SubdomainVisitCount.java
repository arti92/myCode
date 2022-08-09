package string.MediumEx2;

/**
 * @author Arti.Jadhav
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 * Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 * Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
 * For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {
        SubdomainVisitCount subdomainVisitCount = new SubdomainVisitCount();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        subdomainVisitCount.subdomainVisits(cpdomains);
    }

    //https://leetcode.com/problems/subdomain-visit-count/
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> mostVisited = new ArrayList<>();
        HashMap<String, Integer> mapStack = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split("\\s");
            Integer num = Integer.valueOf(split[0]);
            String[] domainSplit = split[1].split("\\.");
            String subDomain = domainSplit[domainSplit.length - 1];
            mapStack.put(subDomain, mapStack.containsKey(subDomain) ? num + mapStack.get(subDomain) : num);
            for (int k = domainSplit.length - 2; k >= 0; k--) {
                subDomain = domainSplit[k] + "." + subDomain;
                mapStack.put(subDomain, mapStack.containsKey(subDomain) ? num + mapStack.get(subDomain) : num);
            }
        }
        mapStack.entrySet().stream().forEach(map -> mostVisited.add(map.getValue() + " " + map.getKey()));
        System.out.println("mostVisited:: " + mostVisited);
        return mostVisited;
    }
}
