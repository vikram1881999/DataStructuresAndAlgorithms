package com.vikram.dsa.arrays;

public class Compress {

  public static void main( String[] args ) {
    Compress compress  = new Compress();
    char[] ch = {'a','a','b','b','c', 'c', 'c'};
    System.out.println( compress.compress(ch));
  }


  public int compress(char[] chars) {
    int n = chars.length;
    int write = 0;       // where to write next in chars[]
    int anchor = 0;      // start of current group

    for (int read = 0; read < n; read++) {
        // if we're at the end of a group…
        if (read + 1 == n || chars[read] != chars[read + 1]) {
            // 1) write the character
            chars[write++] = chars[anchor];

            // 2) write the count if > 1
            int count = read - anchor + 1;
            if (count > 1) {
                // convert count to string, then write each digit
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }

            // 3) move anchor to the next new character
            anchor = read + 1;
        }
    }

    // 'write' is now the length of the compressed array
    return write;
}
  
}
