public class AsciiCharSequence implements CharSequence {

    byte[] sequence;

    AsciiCharSequence(byte[] sequence) {
        this.sequence = sequence;
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int i) {
        return (char) this.sequence[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] subSeq = new byte[i1 - i];
        System.arraycopy(this.sequence, i, subSeq, 0, i1 - i - 1);
        return new AsciiCharSequence(subSeq);
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (byte chr : sequence) {
            buffer.append((char) chr);
        }
        return buffer.toString();
    }
}