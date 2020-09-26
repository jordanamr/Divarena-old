package org.divarena.test;

import java.io.FileInputStream;
import java.io.IOException;

public class SBADecoder {

    public static void main(String[] args) throws Exception {
        FileInputStream fip = new FileInputStream("46.sba");
        InputBitStream bitStream = new InputBitStream(fip);

        // START HEADER
        String signature = new String(bitStream.readBytes(3));
        boolean compressed;
        short version;
        int fileLength;

        if (signature.equals("SBA")) {
            compressed = false;
        } else if (signature.equals("sba")) {
            compressed = true;
        } else {
            throw new IOException("La signature '" + signature + "' du document est invalide!");
        }
        version = (byte)bitStream.readUI8();
        fileLength = (int) bitStream.readUI32();
        // END HEADER

        int codeAndLength = bitStream.readUI16();
        short m_code = (short)(codeAndLength >> 6);
        int m_length = codeAndLength & 0x3F;
        if (m_length == 63) {
            m_length = (int)bitStream.readUI32();
        }

        System.out.println();
    }
}
