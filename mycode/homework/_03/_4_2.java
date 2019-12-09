package nju.homework._03;

import java.util.Scanner;

/**
 * 棋盘覆盖
 */
class Main {
    static private int tile = 1;
    static private int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cishu = Integer.parseInt(scanner.nextLine());
        while (cishu-- > 0) {
            String[] s = scanner.nextLine().split(" ");
            int size = 1 << (Integer.parseInt(s[0]));
            int quex = Integer.parseInt(s[1]);
            int quey = Integer.parseInt(s[2]);
            String[] s1 = scanner.nextLine().split(" ");
            int zhaox = Integer.parseInt(s1[0]);
            int zhaoy = Integer.parseInt(s1[1]);
            board = new int[size][size];
            ChessBoard(0, 0, quex, quey, size);
            int k = 0;
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (zhaox + i < 0 || zhaox + i >= size || zhaoy + j < 0 || zhaoy + j >= size || (i == 0 && j == 0)) {
                    }
                    else if (board[zhaox][zhaoy] == board[zhaox + i][zhaoy + j]) {
                        System.out.print(zhaox + i);
                        System.out.print(" ");
                        System.out.print(zhaoy + j);
                        if (k==0) System.out.print(",");
                        k++;
                    }
            System.out.println();
        }
    }

    static void ChessBoard(int tr, int tc, int dr, int dc, int size) {
        if (size == 1) return;

        int t = tile++;//L型骨牌号
        int s = size / 2;//分割棋盘
        //覆盖左上角子棋盘
        if (dr < tr + s && dc < tc + s)
            ChessBoard(tr, tc, dr, dc, s);//特殊方格在此棋盘中
        else //此棋盘中无特殊方格，用t号L型骨牌覆盖右下角
        {
            board[tr + s - 1][tc + s - 1] = t;
            //覆盖其余方格
            ChessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        //覆盖右上角子棋盘
        if (dr < tr + s && dc >= tc + s)
            ChessBoard(tr, tc + s, dr, dc, s);//特殊方格在此棋盘中
        else //此棋盘中无特殊方格，用t号L型骨牌覆盖左下角
        {
            board[tr + s - 1][tc + s] = t;
            //覆盖其余方格
            ChessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        //覆盖左下角子棋盘
        if (dr >= tr + s && dc < tc + s)//特殊方格在此棋盘中
            ChessBoard(tr + s, tc, dr, dc, s);
        else //此棋盘中无特殊方格，用t号L型骨牌覆盖右上角
        {
            board[tr + s][tc + s - 1] = t;
            //覆盖其余方格
            ChessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        //覆盖右下角子棋盘
        if (dr >= tr + s && dc >= tc + s)//特殊方格在此棋盘中
            ChessBoard(tr + s, tc + s, dr, dc, s);
        else //此棋盘中无特殊方格，用t号L型骨牌覆盖左上角
        {
            board[tr + s][tc + s] = t;
            //覆盖其余方格
            ChessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }

}