package com.example.task1anagramsapplication

/***
 * This Presenter contains logic to to reverse a string
 */
class ReversePresenter
{
    /***
     * Returns the reversed string escaping @param charactersToEscape
     * @param userInput is the original user input
     * @param charactersToEscape characters the user wants to escape
     */
    fun reverse(userInput :String,charactersToEscape :String): String {
        val str = userInput.toCharArray()
        val str2 = charactersToEscape.toCharArray()
        // Initialize left and right traversal
        var right = str.size - 1
        var left = 0

        // Traverse string from both ends until
        // 'l' and 'r'
        while (left < right) {
            // Ignore special characters from user
            when {
                str2.contains(str[left]) -> left++
                charactersToEscape.contains(str[right]) -> right--
                else -> {
                    val tmp = str[left]
                    str[left] = str[right]
                    str[right] = tmp
                    left++
                    right--
                }
            }
        }
        return String(str)
    }
}