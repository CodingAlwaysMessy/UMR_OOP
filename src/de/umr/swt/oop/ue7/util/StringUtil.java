package de.umr.swt.oop.ue7.util;

public class StringUtil {

    /**
     * Recursive String cropping by index.
     *
     * @param string     String to crop.
     * @param startIndex First (inclusive) position.
     * @param endIndex   Last (exclusive) position.
     * @return Returns the new String.
     */
    public static String substring(String string, int startIndex, int endIndex) {
        if (string == null) { // case: null
            return null;
        } else if (string == "") {
            return "";
        } else if (startIndex < 0 || startIndex >= endIndex) { // case: invalid starting index
            return "";
        } else if (startIndex == endIndex - 1) { // termination
            return "" + string.charAt(startIndex);
        } else { // Recursive step
            if (endIndex > string.length()) { // reconfigure endIndex if too long
                endIndex = string.length();
                return string.charAt(startIndex) + substring(string, startIndex + 1, endIndex);
            } else {
            return string.charAt(startIndex) + substring(string, startIndex + 1, endIndex);
            }
        }
    }


}