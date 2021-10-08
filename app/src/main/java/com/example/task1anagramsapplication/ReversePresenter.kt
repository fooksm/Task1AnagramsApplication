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
        val userInputStr = userInput.toCharArray()
        val charactersToEscapeStr = charactersToEscape.toCharArray()
        // Initialize left and right traversal
        var right = userInputStr.size - 1
        var left = 0

        // Traverse string from both ends until
        // 'l' and 'r'
        while (left < right) {
            // Ignore special characters from user
            when {
                charactersToEscapeStr.contains(userInputStr[left]) -> left++
                charactersToEscapeStr.contains(userInputStr[right]) -> right--
                else -> {
                    val tmp = userInputStr[left]
                    userInputStr[left] = userInputStr[right]
                    userInputStr[right] = tmp
                    left++
                    right--
                }
            }
        }
        return String(userInputStr)
    }
}