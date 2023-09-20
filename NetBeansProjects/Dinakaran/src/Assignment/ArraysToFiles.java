package Assignment;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ArraysToFiles {

    static DinakarManda[] d = new DinakarManda[2];
    static DinakarManda[] dc = new DinakarManda[0];
    static {
        d[0] = new DinakarManda("DarkBlack", "DarkBlack", 0, false);
        d[1] = new DinakarManda("DarkBlack", "Black", 0, false);

   }

    static void write() {
        try ( DataOutputStream out = new DataOutputStream(new FileOutputStream("/home/bas200181/bala.txt"));) {
            for (DinakarManda x : d) {
                out.writeUTF(x.getFaceColor());
                out.writeUTF(x.getHairColor());
                out.writeInt(x.getHairCount());
                out.writeBoolean(x.beardPresent);
            }
        } catch (IOException ex) {
        }
    }

    static void read() {
        try ( DataInputStream in = new DataInputStream(new FileInputStream("/home/bas200181/bala.txt"))) {
            while (true) {
                dc = Arrays.copyOf(dc, dc.length + 1);
                try {
                    dc[dc.length - 1] = new DinakarManda(in.readUTF(), in.readUTF(), in.readInt(), in.readBoolean());
                } catch (EOFException e) {
                    dc = Arrays.copyOf(dc, dc.length - 1);
                    break;
                }

            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {
       write();
        read();
        System.out.println(dc.length);
        for (DinakarManda x : dc) {
            System.out.println(x);
      }
    }
}
