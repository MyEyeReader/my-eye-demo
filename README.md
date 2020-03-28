# my-eye-demo
Dummy data for the device.

Instructions: Enter the string to translate to braille. Enter 'exit' (or ctrl+C) to exit the program.

The characters are listed sequentially in unicode. `toUnicode` returns the braille unicode representing the letter. `toByte` returns a number whose bits represent the raised dots. 

Examples:

`toByte('S')` = 14 (dec) = 00001110 (bin) = dots 4, 3, 2 are raised
`toByte('Y')` = 61 (dec) = 00111101 (bin) = dots 6, 5, 4, 3, 1 are raised

Note that dots are 1-indexed. Click this https://en.wikipedia.org/wiki/Braille_Patterns to see how the dots are derived from unicode.