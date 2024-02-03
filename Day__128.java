long modulo = 1000000007;
    long len(Node head)
    {
        Node curr = head;
        long length=0;
        while(curr!=null)
        {
            curr = curr.next;
            length++;
        }
        return length;
    } 
   long[] calculatePowersOfTwo(long length) {
        long[] powersOfTwo = new long[(int) length];
        powersOfTwo[0] = 1;

        for (int i = 1; i < length; i++) {
            powersOfTwo[i] = (powersOfTwo[i - 1] * 2) % modulo;
        }

        return powersOfTwo;
    }

    long DecimalValue(Node head) {
        long n = len(head);
        long sum = 0;
        Node curr = head;

        long[] powersOfTwo = calculatePowersOfTwo(n);

        while (curr != null) {
            long mul = powersOfTwo[(int) (n - 1)] % modulo;
            mul = (mul * curr.data) % modulo;
            sum = (sum + mul) % modulo;
            n--;
            curr = curr.next;
        }

        return sum;
     
   }
