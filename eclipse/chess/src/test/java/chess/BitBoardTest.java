package chess;

import java.util.BitSet;

import org.junit.Test;

public class BitBoardTest {

   @Test
   public void test() {

      BitBoard bb = new BitBoard();
      bb.setBitsAt(Square.a2, Square.b2, Square.c2, Square.d2, Square.e2, Square.f2, Square.g2, Square.h2);

      System.out.println(bb.display());

      long lo = bb.toLong();

      BitSet bs2 = BitSet.valueOf(new long[] { (lo << 9) }); // a2->b3 // need to blank file 8
      // System.out.println(BitBoard.display(bs2));

      bs2 = BitSet.valueOf(new long[] { (lo << 8) }); // a2->a3
      // System.out.println(BitBoard.display(bs2));

      BitSet bs = bb.cloneBitSet();
      bs.and(BitBoard.ONLY_RANK_TWO.getBitSet());
      lo = bs.toLongArray()[0];
      bs2 = BitSet.valueOf(new long[] { (lo << 16) }); // c2->c4; need to blank everything except rank 2 since only
                                                       // these pawns can move 2
      System.out.println(BitBoard.display(bs2));

      bs = bb.cloneBitSet();
      bs.and(BitBoard.NOT_FILE_ONE.getBitSet());
      lo = bs.toLongArray()[0];
      bs2 = BitSet.valueOf(new long[] { (lo << 7) }); // c2->b3; need to blank file 1
      // System.out.println(BitBoard.display(bs2));

   }

}
