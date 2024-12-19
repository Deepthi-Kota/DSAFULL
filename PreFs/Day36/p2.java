package PreFs.Day36;
//1268 find and replace in string
/* Mr Ajay Sharma is working woth words.
He found that few words in the langugage have same meaning.
Such words are given as a list of pairs as mappedpairs[],
where mappedpairs[i] = [word1, word2] indicates that word1 and word2 are 
the words with same meaning.

He is given phrase, and he wants to apply all the mappedpairs[] on the phrase.

Your task is to help Mr.Ajay Sharma to find and return all possible 
Mapped Phrases generated after applying all the mapped words,
and print them in lexicographical order.


Input Format:
-------------
Line-1: An integer N, number of mapped pairs.
Next N lines: Two space separated words, mappedpair[].
Last Line: A line of words, the phrase.

Output Format:
--------------
Print the list of mapped phrases in sorted order.


Sample Input-1:
---------------
3
hi hello
sweet sugar
candy chocolate
hi sam! ram has a sugar candy

Sample Output-1:
----------------
[hello sam! he has sugar candy, hello sam! he has sugar chocolate, 
hello sam! he has sweet candy, hello sam! he has sweet chocolate, 
hi sam! he has sugar candy, hi sam! he has sugar chocolate, 
hi sam! he has sweet candy, hi sam! he has sweet chocolate]



Sample Input-2:
---------------
2
hi hey
hey hello
hi how are you

Sample Output-2:
----------------
[hello how are you, hey how are you, hi how are you]*/

import java.util.*;
public class p2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] s = sc.nextLine().split(" ");
            a.add(s[0]);
            b.add(s[1]);
        }
        String sen = sc.nextLine();
        List<String> ans = new ArrayList<>();
        find(a,b,sen,ans);
        Collections.sort(ans);
        System.out.println(ans);
        sc.close();
    }
    static void find(List<String> a, List<String> b, String sen, List<String> ans){
        ans.add(sen);
        for(int i=0; i<a.size(); i++){
            if(sen.contains(a.get(i))){
                String p = sen.replace(a.get(i),b.get(i));
                find(a,b,p,ans);
            }
        }
    }
}