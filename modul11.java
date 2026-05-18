import java.util.*;

public class modul11 {

    // Class untuk merepresentasikan pemain futsal
    static class Pemain {
        int nomor;
        String tim;
        int tinggiBadan;
        int beratBadan;

        public Pemain(int nomor, String tim, int tinggiBadan, int beratBadan) {
            this.nomor = nomor;
            this.tim = tim;
            this.tinggiBadan = tinggiBadan;
            this.beratBadan = beratBadan;
        }

        @Override
        public String toString() {
            return String.format("No.%2d | Tim %s | Tinggi: %d cm | Berat: %d kg",
                    nomor, tim, tinggiBadan, beratBadan);
        }
    }

    // Comparator untuk tinggi badan ascending
    static class SortByTinggiAsc implements Comparator<Pemain> {
        public int compare(Pemain a, Pemain b) {
            return a.tinggiBadan - b.tinggiBadan;
        }
    }

    // Comparator untuk tinggi badan descending
    static class SortByTinggiDesc implements Comparator<Pemain> {
        public int compare(Pemain a, Pemain b) {
            return b.tinggiBadan - a.tinggiBadan;
        }
    }

    // Comparator untuk berat badan ascending
    static class SortByBeratAsc implements Comparator<Pemain> {
        public int compare(Pemain a, Pemain b) {
            return a.beratBadan - b.beratBadan;
        }
    }

    // Comparator untuk berat badan descending
    static class SortByBeratDesc implements Comparator<Pemain> {
        public int compare(Pemain a, Pemain b) {
            return b.beratBadan - a.beratBadan;
        }
    }

    static void printList(List<Pemain> list) {
        for (Pemain p : list) {
            System.out.println("  " + p);
        }
    }

    static void printSeparator(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + title);
        System.out.println("=".repeat(60));
    }

    public static void main(String[] args) {

        // ============================================================
        // DATA TIM A DAN TIM B
        // ============================================================
        int[][] dataTimA = {
            {168,50},{170,60},{165,56},{168,55},{172,60},
            {170,70},{169,66},{165,56},{171,72},{166,56}
        };
        int[][] dataTimB = {
            {170,66},{167,60},{165,59},{166,58},{168,58},
            {175,71},{172,68},{171,68},{168,65},{169,60}
        };

        ArrayList<Pemain> timA = new ArrayList<>();
        ArrayList<Pemain> timB = new ArrayList<>();

        for (int i = 0; i < dataTimA.length; i++) {
            timA.add(new Pemain(i+1, "A", dataTimA[i][0], dataTimA[i][1]));
        }
        for (int i = 0; i < dataTimB.length; i++) {
            timB.add(new Pemain(i+1, "B", dataTimB[i][0], dataTimB[i][1]));
        }

        // Gabungkan semua pemain kedua tim
        ArrayList<Pemain> semuaPemain = new ArrayList<>();
        semuaPemain.addAll(timA);
        semuaPemain.addAll(timB);

        // ============================================================
        // TUGAS 1a: Urutkan berdasarkan Tinggi Badan (Ascending & Descending)
        // ============================================================
        printSeparator("TUGAS 1a: URUTAN BERDASARKAN TINGGI BADAN");

        Collections.sort(semuaPemain, new SortByTinggiAsc());
        System.out.println("\n  >> Ascending (Terpendek ke Tertinggi):");
        printList(semuaPemain);

        Collections.sort(semuaPemain, new SortByTinggiDesc());
        System.out.println("\n  >> Descending (Tertinggi ke Terpendek):");
        printList(semuaPemain);

        // ============================================================
        // TUGAS 1b: Urutkan berdasarkan Berat Badan (Ascending & Descending)
        // ============================================================
        printSeparator("TUGAS 1b: URUTAN BERDASARKAN BERAT BADAN");

        Collections.sort(semuaPemain, new SortByBeratAsc());
        System.out.println("\n  >> Ascending (Teringan ke Terberat):");
        printList(semuaPemain);

        Collections.sort(semuaPemain, new SortByBeratDesc());
        System.out.println("\n  >> Descending (Terberat ke Teringan):");
        printList(semuaPemain);

        // ============================================================
        // TUGAS 1c: Nilai Maks & Min Tinggi dan Berat per Tim
        // ============================================================
        printSeparator("TUGAS 1c: NILAI MAKSIMUM DAN MINIMUM PER TIM");

        // Tim A - Tinggi
        Pemain maxTinggiA = Collections.max(timA, new SortByTinggiAsc());
        Pemain minTinggiA = Collections.min(timA, new SortByTinggiAsc());
        // Tim A - Berat
        Pemain maxBeratA  = Collections.max(timA, new SortByBeratAsc());
        Pemain minBeratA  = Collections.min(timA, new SortByBeratAsc());

        System.out.println("\n  [ TIM A ]");
        System.out.printf("  Tinggi Badan MAX : %d cm  (%s)%n", maxTinggiA.tinggiBadan, maxTinggiA);
        System.out.printf("  Tinggi Badan MIN : %d cm  (%s)%n", minTinggiA.tinggiBadan, minTinggiA);
        System.out.printf("  Berat Badan  MAX : %d kg  (%s)%n", maxBeratA.beratBadan,   maxBeratA);
        System.out.printf("  Berat Badan  MIN : %d kg  (%s)%n", minBeratA.beratBadan,   minBeratA);

        // Tim B - Tinggi
        Pemain maxTinggiB = Collections.max(timB, new SortByTinggiAsc());
        Pemain minTinggiB = Collections.min(timB, new SortByTinggiAsc());
        // Tim B - Berat
        Pemain maxBeratB  = Collections.max(timB, new SortByBeratAsc());
        Pemain minBeratB  = Collections.min(timB, new SortByBeratAsc());

        System.out.println("\n  [ TIM B ]");
        System.out.printf("  Tinggi Badan MAX : %d cm  (%s)%n", maxTinggiB.tinggiBadan, maxTinggiB);
        System.out.printf("  Tinggi Badan MIN : %d cm  (%s)%n", minTinggiB.tinggiBadan, minTinggiB);
        System.out.printf("  Berat Badan  MAX : %d kg  (%s)%n", maxBeratB.beratBadan,   maxBeratB);
        System.out.printf("  Berat Badan  MIN : %d kg  (%s)%n", minBeratB.beratBadan,   minBeratB);

        // ============================================================
        // TUGAS 1d: Copy seluruh Tim B ke Tim C
        // ============================================================
        printSeparator("TUGAS 1d: COPY TIM B KE TIM C");

        // Buat timC dengan ukuran sama persis dengan timB
        ArrayList<Pemain> timC = new ArrayList<>(Arrays.asList(new Pemain[timB.size()]));
        Collections.copy(timC, timB);

        // Ubah label tim menjadi "C"
        for (int i = 0; i < timC.size(); i++) {
            Pemain asal = timC.get(i);
            timC.set(i, new Pemain(asal.nomor, "C", asal.tinggiBadan, asal.beratBadan));
        }

        System.out.println("\n  Isi Tim C (hasil copy dari Tim B):");
        printList(timC);

        // ============================================================
        // TUGAS 2: BINARY SEARCH
        // ============================================================
        printSeparator("TUGAS 2: BINARY SEARCH");

        // 2a: ArrayList tinggi badan dan berat badan terpisah
        ArrayList<Integer> tinggiBadanA = new ArrayList<>();
        ArrayList<Integer> beratBadanA  = new ArrayList<>();
        ArrayList<Integer> tinggiBadanB = new ArrayList<>();
        ArrayList<Integer> beratBadanB  = new ArrayList<>();

        for (Pemain p : timA) {
            tinggiBadanA.add(p.tinggiBadan);
            beratBadanA.add(p.beratBadan);
        }
        for (Pemain p : timB) {
            tinggiBadanB.add(p.tinggiBadan);
            beratBadanB.add(p.beratBadan);
        }

        System.out.println("\n  >> 2a: Data ArrayList Tim A dan Tim B");
        System.out.println("  Tinggi Badan Tim A: " + tinggiBadanA);
        System.out.println("  Berat Badan Tim A : " + beratBadanA);
        System.out.println("  Tinggi Badan Tim B: " + tinggiBadanB);
        System.out.println("  Berat Badan Tim B : " + beratBadanB);

        // 2b: Jumlah pemain Tim B dengan tinggi 168 cm dan 160 cm
        System.out.println("\n  >> 2b: Frekuensi Tinggi Badan di Tim B");
        int freq168B = Collections.frequency(tinggiBadanB, 168);
        int freq160B = Collections.frequency(tinggiBadanB, 160);
        System.out.printf("  Jumlah pemain Tim B dengan tinggi 168 cm : %d orang%n", freq168B);
        System.out.printf("  Jumlah pemain Tim B dengan tinggi 160 cm : %d orang%n", freq160B);

        // Binary Search konfirmasi (perlu sort dulu)
        ArrayList<Integer> tinggiBadanBSorted = new ArrayList<>(tinggiBadanB);
        Collections.sort(tinggiBadanBSorted);
        int idx168B = Collections.binarySearch(tinggiBadanBSorted, 168);
        int idx160B = Collections.binarySearch(tinggiBadanBSorted, 160);
        System.out.printf("  BinarySearch tinggi 168 cm di Tim B: %s%n",
                idx168B >= 0 ? "Ditemukan (indeks ke-" + idx168B + " pada data terurut)" : "Tidak ditemukan");
        System.out.printf("  BinarySearch tinggi 160 cm di Tim B: %s%n",
                idx160B >= 0 ? "Ditemukan (indeks ke-" + idx160B + " pada data terurut)" : "Tidak ditemukan");

        // 2c: Jumlah pemain Tim A dengan berat 56 kg dan 53 kg
        System.out.println("\n  >> 2c: Frekuensi Berat Badan di Tim A");
        int freq56A = Collections.frequency(beratBadanA, 56);
        int freq53A = Collections.frequency(beratBadanA, 53);
        System.out.printf("  Jumlah pemain Tim A dengan berat 56 kg : %d orang%n", freq56A);
        System.out.printf("  Jumlah pemain Tim A dengan berat 53 kg : %d orang%n", freq53A);

        // Binary Search konfirmasi
        ArrayList<Integer> beratBadanASorted = new ArrayList<>(beratBadanA);
        Collections.sort(beratBadanASorted);
        int idx56A = Collections.binarySearch(beratBadanASorted, 56);
        int idx53A = Collections.binarySearch(beratBadanASorted, 53);
        System.out.printf("  BinarySearch berat 56 kg di Tim A: %s%n",
                idx56A >= 0 ? "Ditemukan (indeks ke-" + idx56A + " pada data terurut)" : "Tidak ditemukan");
        System.out.printf("  BinarySearch berat 53 kg di Tim A: %s%n",
                idx53A >= 0 ? "Ditemukan (indeks ke-" + idx53A + " pada data terurut)" : "Tidak ditemukan");

        // 2d: Apakah ada tinggi badan atau berat badan yang sama antara Tim A dan Tim B?
        System.out.println("\n  >> 2d: Kesamaan Tinggi/Berat antara Tim A dan Tim B");

        boolean disjointTinggi = Collections.disjoint(tinggiBadanA, tinggiBadanB);
        boolean disjointBerat  = Collections.disjoint(beratBadanA,  beratBadanB);

        System.out.printf("  Tinggi badan: Tim A dan Tim B %s yang sama%n",
                disjointTinggi ? "TIDAK MEMILIKI nilai" : "MEMILIKI nilai");
        System.out.printf("  Berat badan : Tim A dan Tim B %s yang sama%n",
                disjointBerat  ? "TIDAK MEMILIKI nilai" : "MEMILIKI nilai");

        // Detail nilai yang sama
        if (!disjointTinggi) {
            Set<Integer> setTinggiA = new HashSet<>(tinggiBadanA);
            Set<Integer> setTinggiB = new HashSet<>(tinggiBadanB);
            setTinggiA.retainAll(setTinggiB);
            System.out.println("  Nilai tinggi badan yang sama: " + setTinggiA + " cm");
        }
        if (!disjointBerat) {
            Set<Integer> setBeratA = new HashSet<>(beratBadanA);
            Set<Integer> setBeratB = new HashSet<>(beratBadanB);
            setBeratA.retainAll(setBeratB);
            System.out.println("  Nilai berat badan yang sama : " + setBeratA + " kg");
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("  Selesai - Semua tugas praktikum telah dikerjakan.");
        System.out.println("=".repeat(60));
    }
}
