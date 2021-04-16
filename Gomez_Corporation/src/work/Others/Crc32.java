package work.Others;

// Generates a crc32 checksum for a given string or byte array

import java.util.BitSet;

public class Crc32 {
    public static void main(String[] args) {
        System.out.println(Integer.toHexString(Crc32("Hello World")));
    }

    public static int Crc32(String str) {
        return Crc32(str.getBytes());
    }

    public static int Crc32(byte[] data) {
        BitSet bitSet = BitSet.valueOf(data);
        int Crc32 = 0xFFFFFFFF;                                     // Initial value
        for (int i = 0; i < data.length * 8; i++) {
            if (((Crc32 >>> 31) & 1) !=(bitSet.get(i) ? 1: 0)) {
                Crc32 = (Crc32 << 1) ^ 0x04C11DB7;                  // Xoring with polynomial
            }
            else {
                Crc32 = (Crc32 << 1);
            }
        }
        Crc32 = Integer.reverse(Crc32);                             // Result reflect
        return Crc32 ^ 0xFFFFFFFF;                                  // Final xor value
    }
}
