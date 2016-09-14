# HappyPeople
Please, write a Java code that, given a text in input read by the file "input.txt", will:

Count the length of any single lines in the file WITHOUT counting the spaces. 
Store the longest one in a String object without the spaces. 
Select the middle character.
If the number of letters is even, the middle character is the middle character in case the string would have N-1 character , where N is the length of the string.
Example: dog -> o , house -> u , cell -> e , banana -> n

Prompt the user to write a word that starts for this character.
Check if the word is actually starting for the given character and print a message for the user to make him/her happy.

Example:
"input.txt" contains:
"Hello, I'm very happy with this assignment!
I can't wait to see how many points
I will get! "

Longest string line without the spaces: "Hello, I'm very happy with this assignment!"
String line without the spaces: "Hello,I'mveryhappywiththisassignment!"
Middle letter: w
Prompting the user: "Write a word that starts for: w "
User input: Word
Output: "Well done. You are the greatest!"
or
User input: "Dog"
Output: "Sorry, this word doesn't start for w"