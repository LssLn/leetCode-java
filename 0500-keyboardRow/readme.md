<h1>500 - keyboardRow</h1>

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below. <br>
<img src="https://assets.leetcode.com/uploads/2018/10/12/keyboard.png">

<br>
In the American keyboard:
<br>
the first row consists of the characters "qwertyuiop",<br>
the second row consists of the characters "asdfghjkl", and<br>
the third row consists of the characters "zxcvbnm".<br>

 
<br>
Example 1:<br>

Input: words = ["Hello","Alaska","Dad","Peace"]<br>
Output: ["Alaska","Dad"]<br><br>
Example 2:<br>

Input: words = ["omk"]<br>
Output: []<br><br>
Example 3:<br>

Input: words = ["adsdf","sfd"]<br>
Output: ["adsdf","sfd"]<br>
 
<br>
Constraints:<br>

1 <= words.length <= 20<br>
1 <= words[i].length <= 100<br>
words[i] consists of English letters (both lowercase and uppercase). 