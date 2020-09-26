package org.divarena.test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

public final class InputBitStream {
    private InputStream m_stream;
    private int m_bitBuffer;
    private int m_bitCursor = 8;
    private boolean m_compressed = false;
    private long m_offset;

    public InputBitStream(InputStream stream) {
        this.m_stream = stream;
        this.m_offset = 0L;
    }

    public InputBitStream(byte[] buffer) {
        this(new ByteArrayInputStream(buffer));
    }

    public long getOffset() {
        return this.m_offset;
    }

    public void setOffset(long offset) throws IOException {
        this.m_offset = offset;
        this.m_stream.reset();
        long i = this.m_stream.skip(this.m_offset);
        if (i != this.m_offset) {
            throw new IOException("InputBitStream : skip() a \u00e9chou\u00e9 \u00e0 ignorer le bon nombre d'octets : m_offset=" + this.m_offset + ", saut effectif=" + i);
        }
    }

    public void align() {
        this.m_bitCursor = 8;
    }

    public int available() throws IOException {
        if (this.m_compressed) {
            throw new IllegalStateException("Impossible sur un flux compress\u00e9 !");
        }
        return this.m_stream.available();
    }

    public void close() throws IOException {
        this.m_stream.close();
    }

    public void enableCompression() {
        if (!this.m_compressed) {
            this.m_stream = new BufferedInputStream(new InflaterInputStream(this.m_stream));
        }
        this.m_compressed = true;
    }

    public void move(long delta) throws IOException {
        this.m_offset += delta;
        this.m_stream.reset();
        long i = this.m_stream.skip(this.m_offset);
        if (i != this.m_offset) {
            throw new IOException("InputBitStream : skip() a \u00e9chou\u00e9 \u00e0 ignorer le bon nombre d'octets : m_offset=" + this.m_offset + ", saut effectif=" + i);
        }
    }

    public boolean readBooleanBit() throws IOException {
        return this.readUnsignedBits(1) == 1L;
    }

    public byte[] readBytes(int length) throws IOException {
        byte[] result;
        if (length > 0) {
            int read;
            result = new byte[length];
            for (int totalRead = 0; totalRead < length; totalRead += read) {
                read = this.m_stream.read(result, totalRead, length - totalRead);
                if (read >= 0) continue;
                this.endReached();
                return null;
            }
        } else {
            return new byte[0];
        }
        this.m_offset += (long)length;
        this.align();
        return result;
    }

    public double readDouble() throws IOException {
        byte[] buffer = this.readBytes(8);
        long longBits = ((long)buffer[3] << 56) + ((long)(buffer[2] & 0xFF) << 48) + ((long)(buffer[1] & 0xFF) << 40) + ((long)(buffer[0] & 0xFF) << 32) + ((long)(buffer[7] & 0xFF) << 24) + (long)((buffer[6] & 0xFF) << 16) + (long)((buffer[5] & 0xFF) << 8) + (long)((buffer[4] & 0xFF) << 0);
        return Double.longBitsToDouble(longBits);
    }

    public double readFP16() throws IOException {
        short value = this.readSI16();
        return (double)value / 256.0;
    }

    public double readFP32() throws IOException {
        int value = this.readSI32();
        return (double)value / 65536.0;
    }

    public double readFPBits(int numBits) throws IOException {
        long longNumber = this.readSignedBits(numBits);
        return (double)longNumber / 65536.0;
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(this.readSI32());
    }

    public float readFloat16() throws IOException {
        int bits16 = this.readUI16();
        int sign = (bits16 & 0x8000) >> 15;
        int exponent16 = (bits16 & 0x7C00) >> 10;
        int mantissa16 = bits16 & 0x3FF;
        int exponent32 = 0;
        if (exponent16 != 0) {
            exponent32 = exponent16 == 31 ? 255 : exponent16 - 15 + 127;
        }
        int mantissa32 = mantissa16 << 13;
        int bits32 = sign << 31;
        bits32 |= exponent32 << 23;
        return Float.intBitsToFloat(bits32 |= mantissa32);
    }

    public short readSI16() throws IOException {
        return (short)this.readUI16();
    }

    public int readSI32() throws IOException {
        return (int)this.readUI32();
    }

    public byte readSI8() throws IOException {
        return (byte)this.readUI8();
    }

    public long readSignedBits(int numBits) throws IOException {
        long result = this.readUnsignedBits(numBits);
        if ((result & 1L << numBits - 1) != 0L) {
            result |= -1L << numBits;
        }
        return result;
    }

    public String readString() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        this.fillBitBuffer();
        while (this.m_bitBuffer != 0) {
            baos.write(this.m_bitBuffer);
            this.fillBitBuffer();
        }
        byte[] buffer = baos.toByteArray();
        String encoding = "UTF-8";
        return new String(buffer, encoding);
    }

    public int readUI16() throws IOException {
        this.fillBitBuffer();
        int result = this.m_bitBuffer;
        this.fillBitBuffer();
        this.align();
        return result |= this.m_bitBuffer << 8;
    }

    public long readUI32() throws IOException {
        this.fillBitBuffer();
        long result = this.m_bitBuffer;
        this.fillBitBuffer();
        result |= (long)(this.m_bitBuffer << 8);
        this.fillBitBuffer();
        result |= (long)(this.m_bitBuffer << 16);
        this.fillBitBuffer();
        this.align();
        return result |= (long)(this.m_bitBuffer << 24);
    }

    public short readUI8() throws IOException {
        this.fillBitBuffer();
        short result = (short)this.m_bitBuffer;
        this.align();
        return result;
    }

    public long readUnsignedBits(int numBits) throws IOException {
        if (numBits == 0) {
            return 0L;
        }
        long result = 0L;
        for (int bitsLeft = numBits; bitsLeft > 0; --bitsLeft) {
            if (this.m_bitCursor == 8) {
                this.fillBitBuffer();
            }
            if ((this.m_bitBuffer & 1 << 7 - this.m_bitCursor) != 0) {
                result |= 1L << bitsLeft - 1;
            }
            ++this.m_bitCursor;
        }
        return result;
    }

    private void endReached() throws IOException {
        throw new IOException("Fin inattendu de flux");
    }

    private void fillBitBuffer() throws IOException {
        this.m_bitBuffer = this.m_stream.read();
        ++this.m_offset;
        if (this.m_bitBuffer < 0) {
            this.endReached();
        }
        this.m_bitCursor = 0;
    }
}