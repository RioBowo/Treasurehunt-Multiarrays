import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        System.out.println("Temukan 3 kotak harta karun");
        System.out.println("Dimensi 6x8!");
        boolean[][] treasure = new boolean[8][6];
        boolean[][] board = new boolean[8][6];
        boolean gameover = false;
        int baris;
        int kolom;
        int userPoint = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                treasure[i][j] = false;
            }
        }

        treasure[1][3] = true;
        treasure[6][2] = true;
        treasure[7][5] = true;

        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 6; j++) {
                System.out.print("❓");
            }
        }
        System.out.println();
        while (!gameover) {
            System.out.println();
            System.out.println("Clue Baris:");
            System.out.println("Kotak pertama   = hari Lahir Pancasila");
            System.out.println("Kotak kedua     = agama di Indonesia");
            System.out.println("Kotak ketiga    = matkul PTI-A semester 1");
            System.out.println("Clue Kolom:");
            System.out.println("Kotak pertama   = segitiga");
            System.out.println("Kotak kedua     = berpasangan");
            System.out.println("Kotak ketiga    = jari tangan");
            System.out.println();

            System.out.println("Baris keberapa yang ingin Anda cari?");
            baris = input.nextInt();

            System.out.println("Kolom keberapa yang ingin Anda cari?");
            kolom = input.nextInt();

            board[baris][kolom] = true;
            updateboard(board, treasure);
            if (treasure[baris][kolom]) {
                userPoint += 1;
            }
            if (userPoint == 3) {
                System.out.println();
                System.out.println("Selamat, semua harta karun ditemukan!!!");
                gameover = true;
            }
            System.out.println();
            System.out.println("Points : " + userPoint);
        }
    }
    public  static void  updateboard(boolean[][] upboard, boolean[][]treasure) {
        System.out.print('\u000C');
        for (int i = 1; i < 8; i++) {
            System.out.println();
            for (int j = 1; j < 6; j++) {
                if(upboard[i][j] && treasure[i][j]) {
                    System.out.print("\uD83E\uDE99");
                } else if (upboard[i][j] && !treasure[i][j]) {
                    System.out.print("\u200D☠");
                } else {
                    System.out.print("❓");
                }
            }
        }
    }
}
