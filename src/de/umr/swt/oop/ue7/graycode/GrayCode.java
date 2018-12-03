package de.umr.swt.oop.ue7.graycode;

public class GrayCode {

    public String[] strCode; // field declaration

    /**
     * Instantiates a GrayCode object recursively for the given size.
     *
     * @param len Size of the final gray code array. The array will be of size 2^(len).
     */
    public GrayCode(int len) {
        this.strCode = new String[(int) Math.pow(2, len)]; // create new field with length: 2^(len)

        if (len < 2) { // termination, initialise 1 gray code bit
            strCode[0] = "0";
            strCode[1] = "1";
        } else {
            // recursive step, create new instance with reduced array size
            GrayCode gc = new GrayCode(len - 1);

            // fill array of this. instance with array value of gc (n-1 instance)
            System.arraycopy(gc.strCode, 0, this.strCode, 0, gc.strCode.length);

            // add mirrored code to this. instance recursively
            addMirroredCode(gc.strCode.length / 2);

            // add leading 0/1 to each array element recursively
            addLeadingFigures(0);
        }
    }

    /**
     * Fills the given array with its own mirrored copy recursively.
     *
     * @param pos Current position within the array.
     */
    private void addMirroredCode(int pos) {
        if (pos <= this.strCode.length - 1) {
            addMirroredCode(pos + 1); // recursive step
            this.strCode[pos] = this.strCode[(this.strCode.length - pos) - 1]; // fill mirrored position with corresponding element
        }
    }

    /**
     * Fills the array with leading figures recursively.
     *
     * @param pos Current position within the array.
     */
    private void addLeadingFigures(int pos) {
        if (pos <= this.strCode.length - 1) {
            addLeadingFigures(pos + 1); // recursive step

            if (pos >= (this.strCode.length / 2)) { // determine position within the array to add correct figure
                this.strCode[pos] = "1" + this.strCode[pos];
            } else {
                this.strCode[pos] = "0" + this.strCode[pos];
            }
        }
    }

    /**
     * Prints the array to the console
     */
    public void print() {
        for (String chunk :
                strCode) {
            System.out.print(chunk);
        }
    }

    /**
     * Initialises the recusive search for a given chunk of graycode and returns the position within the array.
     *
     * @param code Chunk to search for.
     * @return Returns the index of the given chunk.
     */
    public int findCode(String code) {
        return findCode(code, 0, 0, true); // initialize recursion
    }

    /**
     * Searches recursively for a given chunk of graycode and returns the position within the array.
     *
     * @param code      Chunk to search for.
     * @param level     Current position within the gray code bit sequence to searh for.
     * @param pos       Current position within the array.
     * @param firstHalf Determines how to proceed the searching process.
     * @return Returns the position of the Chunk within the array.
     */
    private int findCode(String code, int level, int pos, boolean firstHalf) {

        if (level == code.length()) { // termination
            return pos;
        } else {
            if (code.charAt(level) == '0') { // 0 = do not flip the searching pattern on next level
                if (firstHalf) { // if last level was 0, procced to next level
                    return findCode(code, level + 1, pos, firstHalf);
                } else { // if last level was 1, proceed to next level at second half
                    return findCode(code, level + 1, pos + ((int) (strCode.length / Math.pow(2, level + 1))), firstHalf);
                }
            } else { // 1 = flip the searching pattern on next level
                if (!firstHalf) { // if last level was 1, stay at position but flip searching pattern at next level
                    return findCode(code, level + 1, pos, !firstHalf);
                } else { // if last level was 0, proceed to next level at second half
                    return findCode(code, level + 1, pos + ((int) (strCode.length / Math.pow(2, level + 1))), !firstHalf);
                }
            }
        }
    }
}