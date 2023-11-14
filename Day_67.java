public static boolean areRotations(String s1, String s2 )

    {

        // Your code here

        s1 += s1;

        return s1.indexOf(s2) != -1;

    }
