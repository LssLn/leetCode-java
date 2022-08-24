<h1>1704 - halvesStringsAlike </h1> 
You are given a string s of even length. <br>Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
<br>
Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
<br>
Return true if a and b are alike. Otherwise, return false.

 <br><br>

Example 1:<br>

Input: s = "book"<br>
Output: true<br>
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.<br>
<br>
Example 2:<br>

Input: s = "textbook"<br>
Output: false<br>
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.<br>
Notice that the vowel o is counted twice.<br>
 <br>

Constraints:<br>

2 <= s.length <= 1000<br>
s.length is even.<br>
s consists of uppercase and lowercase letters.