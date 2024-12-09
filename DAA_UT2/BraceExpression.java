package DAA.Day26;
/* Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
Line-1: A string EXP, expression.

Output Format:
--------------
Line-1: Print list of words, formed from the expression.

Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:x   
----------------
[xyzab, xyzac]*/

import java.util.*;
/*50 grade */
public class BraceExpression{

    // Parse the input string into groups of options
    private static List<List<String>> parseExpression(String exp) {
        List<List<String>> groups = new ArrayList<>();
        
        int i = 0;
        while (i < exp.length()) {
            if (exp.charAt(i) == '[') {
                // Parse contents inside square brackets
                int j = i + 1;
                while (j < exp.length() && exp.charAt(j) != ']') {
                    j++;
                }
                String content = exp.substring(i + 1, j);
                groups.add(Arrays.asList(content.split(",")));
                i = j + 1;
            } else {
                // Handle literal characters
                List<String> literalGroup = new ArrayList<>();
                while (i < exp.length() && exp.charAt(i) != '[') {
                    if (exp.charAt(i) != ' ') {
                        literalGroup.add(String.valueOf(exp.charAt(i)));
                    }
                    i++;
                }
                if (!literalGroup.isEmpty()) {
                    groups.add(literalGroup);
                }
            }
        }

        return groups;
    }

    // Iteratively compute Cartesian product of groups
    private static List<String> computeCombinations(List<List<String>> groups) {
        List<String> combinations = new ArrayList<>();
        
        if (groups.isEmpty()) {
            return combinations;
        }

        // Start with the first group's elements
        combinations.addAll(groups.get(0));

        for (int i = 1; i < groups.size(); i++) {
            List<String> currentGroup = groups.get(i);
            List<String> newCombinations = new ArrayList<>();

            // Compute new combinations by appending each string from the current group
            for (String prefix : combinations) {
                for (String choice : currentGroup) {
                    newCombinations.add(prefix + choice);
                }
            }

            combinations = newCombinations; // Update with new combinations
        }

        return combinations;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine(); // Read the input string

        // Parse the expression into groups
        List<List<String>> groups = parseExpression(exp);

        // Compute combinations iteratively
        List<String> result = computeCombinations(groups);

        // Sort the results lexicographically
        Collections.sort(result);

        // Print the result
        System.out.println(result);

        sc.close();
    }
}
/* 25 grade */
/*import java.util.*;

public class BraceExpression {

    // Function to parse groups from the input string
    private static List<List<String>> parseExpression(String exp) {
        List<List<String>> groups = new ArrayList<>();
        
        int i = 0;
        while (i < exp.length()) {
            if (exp.charAt(i) == '[') {
                // Find the closing bracket
                int j = i + 1;
                while (j < exp.length() && exp.charAt(j) != ']') {
                    j++;
                }
                String content = exp.substring(i + 1, j);
                groups.add(Arrays.asList(content.split(",")));
                i = j + 1;
            } else {
                // Handle literal characters
                List<String> literalGroup = new ArrayList<>();
                while (i < exp.length() && exp.charAt(i) != '[') {
                    if (exp.charAt(i) != ' ') {
                        literalGroup.add(String.valueOf(exp.charAt(i)));
                    }
                    i++;
                }
                if (!literalGroup.isEmpty()) {
                    groups.add(literalGroup);
                }
            }
        }

        return groups;
    }

    // Recursive function to generate combinations
    private static void generateCombinations(List<List<String>> groups, int index, StringBuilder current, List<String> result) {
        if (index == groups.size()) {
            result.add(current.toString());
            return;
        }

        for (String choice : groups.get(index)) {
            current.append(choice);
            generateCombinations(groups, index + 1, current, result);
            current.setLength(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine(); // Read input string
        
        // Parse the expression into groups
        List<List<String>> groups = parseExpression(exp);

        // Generate all combinations using backtracking
        List<String> result = new ArrayList<>();
        generateCombinations(groups, 0, new StringBuilder(), result);

        // Sort the results lexicographically
        Collections.sort(result);

        // Print the result
        System.out.println(result);

        sc.close();
    }
}
*/